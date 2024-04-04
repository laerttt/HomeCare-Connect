package com.example.homecareconnect.Entities;

import android.location.Location;
import android.util.Log;

import com.example.homecareconnect.Database.MongoConnection;
import com.example.homecareconnect.Database.MongoDBDriver;
import com.example.homecareconnect.Util.UserPasswordHashing;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;


enum Gender {
    Male,
    Female,
    Other;
}
enum Bloodtype{
    A_Positive,
    A_Negative,
    B_Positive,
    B_Negative,
    O_Positive,
    O_Negative,
    AB_Positive,
    AB_Negative;
}
public class User implements MongoDBDriver{
    int _id;
    String Name;
    String Email;
    UserPasswordHashing Password;
    String Username;
    int Age;
    String[] Allergies;

    Bloodtype bloodtype;
    Gender Gender;
    Location CurrentLocation;



   public User(String Username, String Name, int Age, String[] Allergies, Bloodtype BloodType , Gender Gender, Location CurrentLocation, String Password) {
          this.bloodtype=BloodType;
          this.Name=Name;
          this.Age=Age;
          this.Gender= Gender;
          this.Allergies=Allergies;
          this.Username=Username;
          this.Password= new UserPasswordHashing(Password);

          Log.v("User", "User Constructor triggered " );
   }

   // Database method integration for User class
    @Override
    public Log addDB() {
        MongoClient mongoClient = MongoConnection.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("HomeCare-Connect");
        MongoCollection<Document> collection = database.getCollection("User");

        Document document = new Document("_id", _id)
                .append("Name",Name)
                .append("Age", Age)
                .append("Allergies",Allergies)
                .append("Username",Username).append("Password_salt",Password.salted).append("Password_Hash",Password.hashedPassword).append("Bloodtype",bloodtype).append("Gender",Gender);

        return null;
    }


    @Override
    public Log delete() {

        return null;
    }

    @Override
    public Log exists() {


       return null;
    }

    @Override
    public Log getByID() {
        return null;
    }
}
