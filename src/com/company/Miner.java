package com.company;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Miner {

    public static String sha256(final String toHash){
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
            final StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                final String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public static boolean is_less(String block_hash, String target){
        for (int i = 0; i < block_hash.length(); i++) {
            if ((int) block_hash.charAt(i) < (int) target.charAt(i) ){
                return true;
            } else if ((int) block_hash.charAt(i) > (int) target.charAt(i)){
                return false;
            } else if (i == block_hash.length() - 1 ) return true;
        } return false;
    }

    public static void mine(Block block){
        int i = 0;
        while (!is_less(sha256(block.toSmallString() + i),block.getTarget())){
            i++;
            //System.out.println("Failed " + i + ": " + sha256(block.toSmallString() + i));
        }
        block.setNonce(i);
        block.setHash(sha256(block.toBigString()));
        System.out.println("Target: " + block.getTarget() + "\nHash: " + block.getHash());
        System.out.println(block.toString());
    }
}
