package entradas;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class Main {
	
	public static void main(String[] args) 
	{
		System.out.println("\n=== MONGODB ENTRADAS ===\n");
		
		//	AUTOCLOSE MONGOCLIENT OBJECT
		try(MongoClient client = MongoDBClientFactory.createClient()){
			
			//	---	VARIABLES
			MongoDatabase database = client.getDatabase("entradas");
			Scanner entrada = new Scanner(System.in);
			int menuPrincipal = -1;
			//	---
			
			//	---	PROGRAMA
			
			System.out.println("\n--- Connection Succesful ---");
			
			while(menuPrincipal != 3) {
				
				menuPrincipal = Common.menu("\n=== MENÚ PRINCIPAL ===\n"
						+ "\n1. Crear Talonario Entradas"
						+ "\n2. Venta de Entradas"
						+ "\n3. Salir del Programa",entrada,1,3);
				
				switch(menuPrincipal) {
				case 1:	//	---	CREAR TALONARIO DE ENTRADAS
					
					System.out.println("\n--- Crear Talonario de Entradas ---\n");
					
					String talonario = "";
					int localidades = -1;
					boolean exists = false;
					
					do{	
						talonario = Common.inputString("Introduzca el nombre del Talonario", entrada);
						localidades = Common.inputPositiveInt("Introduzca el número de Localidades", entrada);
						for (String nombre : database.listCollectionNames()) {
							if(nombre.equals(talonario)) {
								exists = true;
								break;
							}
						}
						if(exists) {
							System.out.println("ERROR: El Talonario introducido ya existe. Inténtelo de nuevo.");
						}
					}while(exists);
					
					if(!talonario.isEmpty() && localidades != -1) {
						try {
							database.createCollection(talonario.trim().toLowerCase());
							MongoCollection<Document> talonarioCreado = database.getCollection(talonario.trim().toLowerCase());
							for(int i=0; i<localidades;i++) {
								Document documento = new Document("id", i+1).append("observaciones", "Disponible").append("nombre_cliente", "");
								talonarioCreado.insertOne(documento);
							}
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}
					break;
				case 2:	//	---	VENTA DE ENTRADAS
					
					System.out.println("\n--- Venta de Entradas ---\n");
					
					System.out.println("Mostrando Talonarios disponibles ...");
					for(String nombre : database.listCollectionNames()) {
						System.out.println("- " + nombre);
					}
					
					String input = Common.inputString("Introduzca el nombre del talonario a elegir.", entrada).trim().toLowerCase();
					boolean isIn = false;
					for(String nombre : database.listCollectionNames()) {
						if(input.equals(nombre)) {
							isIn = true;
						}
					}
					
					if(isIn) {
						MongoCollection<Document> chosen = database.getCollection(input);
						int disponibles = 0;
						for(Document documento : chosen.find()) {
							if(documento.getString("observaciones").equals("Disponible") &&
									documento.getString("nombre_cliente").isEmpty()) {
								disponibles++;
							}
						}
						if(disponibles > 0) {
							String nombreEntrada = Common.inputString("Introduzca su nombre a continuación.", entrada);
							int numEntradas = Common.inputPositiveInt("Introduzca el número de entradas a reservar.", entrada);
							if(numEntradas > disponibles) {
								System.out.println("ERROR: El número de entradas introducido excede el número de entradas disponibles. Inténtelo de nuevo.");
							}else {
								int contador = 0;
								for(Document documento : chosen.find(eq("observaciones","Disponible"))) {
									chosen.updateOne(
											eq("_id",documento.getObjectId("_id")), 
											combine(
												set("observaciones","Vendido"),
												set("nombre_cliente", nombreEntrada)
											)
									);
									contador++;
									if(contador >= numEntradas) {
										break;
									}
								}
								System.out.printf("Número de entradas disponibles = %d\n", disponibles - numEntradas);
							}
						}else {
							System.out.println("ERROR: El Talonario introducido no tiene entradas disponibles. Inténtelo de nuevo.");
						}
					}else {
						System.out.println("ERROR: El Talonario introducido no está registrado en el sistema. Inténtelo de nuevo.");
					}
					break;
				case 3:	//	---	APAGAR PROGRAMA
					System.out.println("Saliendo del programa ...");
					break;
				}
			}
			//	---
		//	CATCH - MongoException
		}catch(MongoException me) {
			System.out.println(me.getMessage());
		}
	}
}
