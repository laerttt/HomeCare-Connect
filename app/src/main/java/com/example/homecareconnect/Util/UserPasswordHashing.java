package com.example.homecareconnect.Util;


import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

import java.security.SecureRandom;



public class UserPasswordHashing {
    public byte[] salted = new byte[16];
    public byte[] hashedPassword = new byte[16];
    public UserPasswordHashing(String password){
        SecureRandom random = new SecureRandom();
        random.nextBytes(this.salted);
        this.hashedPassword=hashPassword(password,this.salted);



    }
    private static byte[] hashPassword(String password,byte[] salt){
        int parallelism = 2; // Use 2 threads
        int memory = 65536; // Use 64 MB of memory
        int iterations = 3; // Run 3 iterations
        int hashLength = 32; // Generate a 32 byte (256 bit) hash

        Argon2BytesGenerator generator = new Argon2BytesGenerator();
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder(Argon2Parameters.ARGON2_id)
                .withSalt(salt) // Random Generated salt
                .withParallelism(parallelism) // Parallelism factor
                .withMemoryAsKB(memory) // Memory cost
                .withIterations(iterations); // Number of iterations

        generator.init(builder.build());
        byte[] result = new byte[hashLength];
        generator.generateBytes(password.toCharArray(), result);



     return result;
    }


}
