package com.sg.decrypt;

import com.sg.secret.Secret;
import com.tap.Encrypt.Encrypt;

public class Decrypt {

	
	public static String decrypt(String str)
	{
		String t = "";
		for(int i = 0 ; i < str.length() ; i++)
		{
			t = t + (char)(str.charAt(i)-Secret.getKey());
		}
		return t;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Decrypt.decrypt("y{jvxmIpvjru7lxv"));
	}
}
