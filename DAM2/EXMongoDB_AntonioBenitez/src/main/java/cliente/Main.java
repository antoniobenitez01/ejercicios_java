package cliente;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import static com.mongodb.client.model.Filters.lt;

public class Main {
	public static void main(String[] args) 
	{
		System.out.println("\n=== EXAMEN MONGODB ===\n");
		try(MongoClient client = MongoDBClientFactory.createClient())
		{
			MongoDatabase database = client.getDatabase("examen");
			MongoCollection<Document> collection = database.getCollection("articulos");
			
			Scanner entrada = new Scanner(System.in);
			int opcion = -1;
			
			while(opcion != 6) {
				opcion = Common.menu("\n--- ARTICULOS ---\n"
						+ "\n1. Buscar ARTICULOS por CATEGORIA"
						+ "\n2. Buscar ARTICULOS por NOMBRE"
						+ "\n3. Mostrar ARTICULOS por STOCK inferior a N"
						+ "\n4. Actualizar PRECIOS de CATEGORIA"
						+ "\n5. Apagar programa\n", entrada, 1, 5);
				switch(opcion) {
				case 1:	//	---		BUSCAR ARTICULOS POR CATEGORIA
					
					String buscarCategoria = Common.inputString("Introduzca la CATEGORIA a buscar", entrada);
					int contador = 0;
					for(Document doc : collection.find(Filters.regex("categoria","^" + Pattern.quote(buscarCategoria) + "$","i"))) {
						System.out.printf("ARTICULO ENCONTRADO: %s\n",formatDocument(doc));
						contador++;
					}
					if(contador == 0) {
						System.out.println("ERROR: No se ha encontrado ningún ARTICULO con esa CATEGORIA. Inténtelo de nuevo.");
					}
					break;
					
				case 2:	//	---		BUSCAR ARTICULOS POR NOMBRE
					
					String buscarNombre = Common.inputString("Introduzca el NOMBRE a buscar", entrada);
					contador = 0;
					for(Document doc : collection.find(Filters.regex("nombre",Pattern.quote(buscarNombre),"i"))) {
						System.out.printf("ARTICULO ENCONTRADO: %s\n",formatDocument(doc));
						contador++;
					}
					if(contador == 0) {
						System.out.println("ERROR: No se ha encontrado ningún ARTICULO con ese NOMBRE. Inténtelo de nuevo.");
					}
					break;
					
				case 3:	//	---		MOSTRAR ARTICULOS CON STOCK INFERIOR A N
					
					int inferior = Common.inputPositiveInt("Introduzca el valor a continuación.", entrada);
					contador = 0;
					for(Document doc : collection.find(lt("stock",inferior)).sort(new Document("nombre", 1))) {
						System.out.printf("ARTICULO ENCONTRADO: %s\n",formatDocument(doc));
						contador++;
					}
					if(contador == 0) {
						System.out.printf("ERROR: No se ha encontrado ningún ARTICULO con STOCK inferior a %d. Inténtelo de nuevo.\n", inferior);
					}
					break;
					
				case 4:	//	---		ACTUALIZAR PRECIOS DE CATEGORIA
					
					String actualizarCategoria = Common.inputString("Introduzca la CATEGORIA a actualizar", entrada);
					contador = 0;
					for(Document doc : collection.find(Filters.regex("categoria","^" + Pattern.quote(actualizarCategoria) + "$","i"))) {
						System.out.printf("ARTICULO ENCONTRADO: %s\n",formatDocument(doc));
						contador++;
					}
					if(contador == 0) {
						System.out.println("ERROR: No se ha encontrado ningún ARTICULO con esa CATEGORIA. Inténtelo de nuevo.");
					}else {
						System.out.println("\nSe han encontrado artículos con esa categoría.");
						double porcentaje = Common.inputPositiveDouble("Introduzca el porcentaje a continuación", entrada);
						boolean subir = Common.booleanCheck("Desea SUBIR o BAJAR el porcentaje sobre el PRECIO? ( SUBIR / BAJAR )", entrada);
						for(Document doc : collection.find(Filters.regex("categoria","^" + Pattern.quote(actualizarCategoria) + "$","i"))) {
							String precio = doc.get("precio").toString();
							if(precio.contains(".")) {
								Double precioDouble = Double.valueOf(precio);
								collection.updateOne(doc, Updates.set("precio", subir 
										? precioDouble + (precioDouble * (porcentaje / 100)) 
										: precioDouble - (precioDouble * (porcentaje / 100))));
							}else {
								Integer precioInteger = Integer.valueOf(precio);
								collection.updateOne(doc, Updates.set("precio", subir 
										? precioInteger + (precioInteger * (porcentaje / 100)) 
										: precioInteger - (precioInteger * (porcentaje / 100))));
							}
						}
						for(Document doc : collection.find(Filters.regex("categoria","^" + Pattern.quote(actualizarCategoria) + "$","i"))) {
							System.out.printf("ARTICULO ACTUALIZADO: %s\n",formatDocument(doc));
							contador++;
						}
					}
					break;
					
				case 5:	//	---		APAGAR PROGRAMA
					System.out.println("Apagando programa ...");
					break;
				default:
					System.out.println(" LOGIC ERROR ! TOO BAD !");
					break;
				}
			}
		}catch(MongoException me) {
			System.out.println(me.getMessage());
		}
	}
	
	//	FORMAT DOCUMENT - Formatea el Documento a un String para su impresión por consola
	private static String formatDocument(Document document) {
		return String.format("%s - %s - Precio: %s € - Stock: %d - Categoría: %s - Proveedor: %s",
				document.getString("nombre"),
				document.getString("descripcion"),
				document.get("precio").toString(),
				document.getInteger("stock"),
				document.getString("categoria"),
				document.getString("proveedor"));
	}
}
