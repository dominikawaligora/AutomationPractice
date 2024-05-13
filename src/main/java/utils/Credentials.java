package utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Credentials {
    public static String encrypt(String password) {
        String encodedPassword = "";
        try {
            byte[] encodedBytes = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8));
            encodedPassword = new String(encodedBytes);
        } catch (Exception e) {
            System.out.println("Problem occurred when encrypting password");
        }
        return encodedPassword;
    }


    public static String decrypt(String encodedPassword) {
        String decodedPassword = "";
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
            decodedPassword = new String(decodedBytes);
        } catch (Exception e) {
            System.out.println("Problem occurred when decrypting password");
        }
        return decodedPassword;
    }
}
