package com.example.homecareconnect.Database;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://Admin:Z9ktreXZ0FlcN3Lm@cluster0.m47kp77.mongodb.net/";
    public static MongoClient  getMongoClient() {
        return MongoClients.create(CONNECTION_STRING);
    }
}

