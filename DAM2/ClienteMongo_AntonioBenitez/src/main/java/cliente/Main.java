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

public class Main {
	public static void main(String[] args) 
	{
		System.out.println("\n=== CLIENTE MONGODB ===\n");
		try(MongoClient client = MongoDBClientFactory.createClient())
		{
			MongoDatabase database = client.getDatabase("cliente");
			MongoCollection<Document> collection = database.getCollection("grupos_musicales");
			
			Scanner entrada = new Scanner(System.in);
			int opcion = -1;
			
			Document lastEntry = collection.find().sort(new Document("_id", -1)).first();
			int lastCode = Integer.valueOf(lastEntry.getString("codigo").split("-")[1]);
			System.out.println( "DEBUG: LAST CODE = " + lastCode );
			
			while(opcion != 6) {
				opcion = Common.menu("\n--- GRUPOS MUSICALES ---\n"
						+ "\n1. Añadir nuevo GRUPO"
						+ "\n2. Buscar GRUPO por NOMBRE"
						+ "\n3. Buscar GRUPO por GENERO"
						+ "\n4. Modificar GENERO"
						+ "\n5. Borrar GRUPO"
						+ "\n6. Apagar programa", entrada, 1, 6);
				switch(opcion) {
				case 1:	//	---		AÑADIR NUEVO GRUPO
					
					String newNombre = Common.inputString("Introduzca el nombre del nuevo grupo.", entrada);
					String newEstilo = Common.inputString("Introduzca el estilo musical del nuevo grupo", entrada);
					String newPais = Common.inputString("Introduzca el país del nuevo grupo", entrada);
					String newMejor = Common.inputString("Introduzca el mejor album del nuevo grupo", entrada);
					int newAnyo = Common.inputInt("Introduzca el año de aparición del nuevo grupo", entrada);
					
					Document newGrupo = new Document("codigo",String.format("%03d", lastCode))
							.append("nombre",newNombre)
							.append("estilo_musical",newEstilo)
							.append("pais",newPais)
							.append("mejor_album",newMejor)
							.append("anyo_aparicion",newAnyo);
					collection.insertOne(newGrupo);
					break;
					
				case 2:	//	---		BUSCAR GRUPO POR NOMBRE
					
					String buscarNombre = Common.inputString("Introduzca el NOMBRE del grupo a buscar", entrada);
					Document buscarDocument = collection.find(Filters.regex("nombre","^" + Pattern.quote(buscarNombre) + "$","i")).first();
					if(buscarDocument == null) {
						System.out.println("ERROR : No se ha encontrado el GRUPO introducido. Inténtelo de nuevo");
					}else {
						System.out.printf("GRUPO ENCONTRADO: %s\n",formatDocument(buscarDocument));
					}
					break;
					
				case 3:	//	---		BUSCAR GRUPO POR GENERO
					
					String generoBuscar = Common.inputString("Introduzca el GENERO a buscar", entrada);
					int contador = 0;
					for(Document doc : collection.find(Filters.regex("estilo_musical",Pattern.quote(generoBuscar),"i"))) {
						System.out.printf("GRUPO ENCONTRADO: %s\n",formatDocument(doc));
						contador++;
					}
					if(contador == 0) {
						System.out.println("ERROR: No se ha encontrado ningún GRUPO con ese GÉNERO. Inténtelo de nuevo.");
					}
					break;
					
				case 4:	//	---		MODIFICAR GENERO
					
					String updateNombre = Common.inputString("Introduzca el NOMBRE del grupo a modificar", entrada);
					Document updateDocument = collection.find(Filters.regex("nombre","^" + Pattern.quote(updateNombre) + "$","i")).first();
					if(updateDocument == null) {
						System.out.println("ERROR : No se ha encontrado el GRUPO introducido. Inténtelo de nuevo");
					}else {
						System.out.printf("\nGRUPO ENCONTRADO: %s\n",formatDocument(updateDocument));
						String updateGenero = Common.inputString("\nIntroduzca el nuevo GÉNERO a continuación", entrada);
						collection.updateOne(updateDocument, Updates.set("estilo_musical", updateGenero));
						
						updateDocument = collection.find(Filters.regex("nombre","^" + Pattern.quote(updateNombre) + "$","i")).first();
						System.out.printf("\nGRUPO ACTUALIZADO: %s\n",formatDocument(updateDocument));
					}
					break;
					
				case 5:	//	---		BORRAR GRUPO
					
					String borrarNombre = Common.inputString("Introduzca el NOMBRE del grupo a borrar", entrada);
					Document borrarDocument = collection.find(Filters.regex("nombre","^" + Pattern.quote(borrarNombre) + "$","i")).first();
					if(borrarDocument == null) {
						System.out.println("ERROR : No se ha encontrado el GRUPO introducido. Inténtelo de nuevo");
					}else {
						System.out.printf("GRUPO ENCONTRADO: %s\n",formatDocument(borrarDocument));
						boolean toDelete = Common.booleanCheck("¿Está seguro de que desea eliminar este GRUPO? (SI/NO)", entrada);
						if(toDelete) {
							collection.deleteOne(borrarDocument);
						}else {
							System.out.println("Operación cancelada. Volviendo al menú principal ...");
						}
					}
					break;
					
				case 6:	//	---		APAGAR PROGRAMA
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
	
	private static String formatDocument(Document document) {
		return String.format("%s - %s - Género: %s - País: %s - Mejor álbum: %s - Año aparición: %d",
				document.getString("codigo"),
				document.getString("nombre"),
				document.getString("estilo_musical"),
				document.getString("pais"),
				document.getString("mejor_album"),
				document.getInteger("anyo_aparicion"));
	}
}
