package com.example.demo;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;

public class Encrypting {

    public static void main(String[] args) {

        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        String myEncryptionPassword = "password";
        textEncryptor.setPassword(myEncryptionPassword);

        String myText = "The red dog";
        String myEncryptedText = textEncryptor.encrypt(myText);

        String plainText = textEncryptor.decrypt(myEncryptedText);

        System.out.println(myEncryptedText);
    }
}
