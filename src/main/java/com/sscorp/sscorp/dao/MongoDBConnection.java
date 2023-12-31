package com.sscorp.sscorp.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConnection {

    /*public static void main(String[] args) {
        String connectionString = "mongodb+srv://gs19170:k3Op904933HUWlfr@sscorp.tmwg3p1.mongodb.net/?retryWrites=true&w=majority";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();*/
        // Create a new client and connect to the server
       /* try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                database.getCollection("sscorp.userInfo");
                System.out.println(database.getCollection("sscorp.userInfo"));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
                MongoDatabase database = mongoClient.getDatabase("sscorp");
                //database.getCollection("userInfo");

                MongoCollection<Document> userCollection = database.getCollection("userInfo");
                System.out.println(userCollection);
                Document user1 = userCollection.find(new Document("phone", "1234567890")).first();
                System.out.println("user1 1: " + user1.toJson());

            } catch (MongoException e) {
                e.printStackTrace();
            }
        }

    }
*/
    @Bean
    public MongoClient getMongoDBConnection() {
        String connectionString = "mongodb+srv://gs19170:k3Op904933HUWlfr@sscorp.tmwg3p1.mongodb.net/sscorp1?retryWrites=true&w=majority";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        MongoClient mongoClient;
        try {
            mongoClient = MongoClients.create(settings);

        } finally {
            System.out.println("got the mongo db connection");
        }
        return mongoClient;
    }
}
