package io.confluent.developer;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtility {

    /**
     * Hashes a string using SHA-256 and returns the hexadecimal representation.
     *
     * @param textToHash The text to be hashed.
     * @return The hashed string in hexadecimal format.
     */
    public static String hashWithSHA256(String textToHash) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Perform the hashing
            byte[] hashBytes = digest.digest(textToHash.getBytes("UTF-8"));
            
            // Convert the byte array into a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            // Return the hexadecimal string
            return hexString.toString();
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            throw new RuntimeException("Error hashing the string", e);
        }
    }

    public static void main(String[] args) {
        String textToHash = "Hello, World!";
        String hashedString = hashWithSHA256(textToHash);
        System.out.println("Hashed string with SHA-256: " + hashedString);
    }
}
