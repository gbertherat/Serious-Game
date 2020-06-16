package v1_tests;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordTest {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String passwordToHash = "123";
		String generatedPassword = null;
		
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-1");
	        byte[] bytes = md.digest(passwordToHash.getBytes());
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i< bytes.length ;i++)
	        {
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        generatedPassword = sb.toString();
	    } 
	    catch (NoSuchAlgorithmException e) 
	    {
	        e.printStackTrace();
	    }
	    
	    System.out.println(generatedPassword);
	}
}
