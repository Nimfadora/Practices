package com.epam.vasylieva.practice5.part4;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Hasher {
    public String hash(String input, String method) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(method);
        digest.update(input.getBytes());
        byte[] hash = digest.digest();
        StringBuilder sb = new StringBuilder();
        System.out.println(Arrays.toString(hash));
        for(byte num : hash){
            sb.append(Integer.toHexString((int) num).toUpperCase()).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Hasher hasher = new Hasher();
        System.out.println(hasher.hash("password", "SHA-256"));
        System.out.println(hasher.hash("password", "MD5"));
    }
}
