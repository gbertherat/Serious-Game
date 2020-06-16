package v1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Permet l'encryption d'un mot de passe
 * @author Guillaume
 */
public class Password {
	
	/**
	 * Permet l'encryption d'un mot de passe
	 * @param password - Le mot de passe à encrypter
	 * @return le mot de passe encrypté
	 */
	public static String encryptPassword(String password) {
		String generatedPassword = null;
	    try {
	        MessageDigest md = MessageDigest.getInstance("SHA-1");
	        byte[] bytes = md.digest(password.getBytes());
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
	    
	    return generatedPassword;
	}
}
