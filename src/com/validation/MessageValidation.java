package com.validation;

import java.util.regex.Pattern;

public class MessageValidation {

	public String isValid(String name, String email, String description) {
		
		String result;
		if(name.length() < 2 || isNotCharacter(name))
			result = "Invalid name!";
		else if(!isEmailValid(email))
			result = "Invalid email!";
		else if(description.length() > 49 || description.length() < 21)
			result = "Invalid message! message length should be greater than 20 and less than 50!";
		else
			result = "Valid";
		
		return result;
	}

	private boolean isNotCharacter(String name) {
		for(char c : name.toCharArray()) {
			if(!Character.isAlphabetic(c))
				return true;
		}
		return false;
	}

	private boolean isEmailValid(String email) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + 
							"(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
        
		Pattern p = Pattern.compile(regex); 
		if (email == null) 
			return false; 
		
		return p.matcher(email).matches(); 
	}
}