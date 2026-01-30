package cliente;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDBClientFactory {
	public static MongoClient createClient() {
		String connectionString = "mongodb://localhost:27017/";
		return MongoClients.create(connectionString);
	}
}
