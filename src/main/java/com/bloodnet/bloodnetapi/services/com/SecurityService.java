package com.bloodnet.bloodnetapi.services.com;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService{
	
	public String encryptPassword(String plainTextPassword){
		
		MessageDigest md5 = null;
		StringBuilder encryptedPwd = null;
		
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		md5.update( (plainTextPassword + "SAVU").getBytes());
	    encryptedPwd = new StringBuilder();
	    for (byte b : md5.digest()) {
	        String hex = String.format("%02x", b);
	        encryptedPwd.append(hex);
	    }
		
	    return encryptedPwd.toString();
	}
	
}