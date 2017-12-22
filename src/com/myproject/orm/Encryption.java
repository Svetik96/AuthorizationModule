package com.myproject.orm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import com.google.common.primitives.Bytes; 

public class Encryption {

	private static final String ALGORITHM = "SHA-256"; 
    private static final int ITERATIONS = 10000; 
//  private static final int SALT_SIZE = 64;
    public static final byte[] SALT = {101, -88, -71, -61, 85, -70, -23, 33, 10, 103, 31, 88, 96, 103, -16, -23, 60, 79, 24, -113, -30, 77, 121, -74, 121, -80, 115, -97, -1, 6, -36, -2, 61, 7, -12, 110, 99, 66, 11, 22, 48, -37, 74, 8, -88, -4, 8, -37, 106, -69, 31, 0, 127, 87, 127, -69, -27, 6, 104, -18, -111, -112, 52, -99};
    
    public static String encrypt(String password) throws NoSuchAlgorithmException, 
    UnsupportedEncodingException{
    	MessageDigest md = MessageDigest.getInstance(ALGORITHM); 
        md.reset(); 
    	md.update(SALT); 
        md.update(Bytes.concat(password.getBytes("UTF-8"), SALT));
        byte[] hash = md.digest();
 
        for (int i = 0; i < ITERATIONS; i++) { 
            md.reset(); 
            hash = md.digest(hash);
        }
        
		StringBuilder sb = new StringBuilder();
        for(int i=0; i< hash.length ;i++){
           sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
    
    public static String encrypt2(Integer password) throws NoSuchAlgorithmException, 
    UnsupportedEncodingException{
    	MessageDigest md = MessageDigest.getInstance(ALGORITHM); 
        md.reset(); 
    	md.update(SALT); 
        md.update(Bytes.concat(password.toString().getBytes("UTF-8"), SALT));
        byte[] hash = md.digest();
 
        for (int i = 0; i < ITERATIONS; i++) { 
            md.reset(); 
            hash = md.digest(hash);
        }
        
		StringBuilder sb = new StringBuilder();
        for(int i=0; i< hash.length ;i++){
           sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        return sb.toString();
    }
    
    public static boolean verifyPassword(String originalHash, String password) throws 
    NoSuchAlgorithmException, UnsupportedEncodingException { 
    	
    	String comparisonHash = Encryption.encrypt(password);
    	if(comparisonHash.equals(originalHash)) {
    		return true;
    	} else {
    		return false;
    	}
    }


/*  public static byte[] generateSalt() { 
        SecureRandom random = new SecureRandom(); 
        byte[] salt = new byte[SALT_SIZE]; 
        random.nextBytes(salt);
 
        return salt; 
    } */
}
