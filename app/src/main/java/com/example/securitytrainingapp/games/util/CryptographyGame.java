package com.example.securitytrainingapp.games.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CryptographyGame {
    private Random rand;
    private int julianOffset;
    private String chosenQuote;
    private final List<String> quotesToDecrypt = new ArrayList<String>() {
        {
            add("This is quote #1");
            add("This is quote #2");
            add("This is quote #3");
        }
    };

    public CryptographyGame() {
        this.rand = new Random();
        this.julianOffset = rand.nextInt(26);
        while (this.julianOffset == 0) {
            this.julianOffset = rand.nextInt(26);
        }
        this.chosenQuote = this.quotesToDecrypt.get(this.rand.nextInt(this.quotesToDecrypt.size()));
    }

    public String provideCipherText() {
        return encryptPlainText();
    }

    public boolean checkUserOffset(String cipherText, int userOffset) {
        return this.chosenQuote.equals(decryptPlainText(cipherText, userOffset));
    }

    private String encryptPlainText() {
        String plainText = this.chosenQuote.toLowerCase();
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char curChar = plainText.charAt(i);
            int curCharInt = (int) curChar;
            int neededOffset = this.julianOffset;
            char encryptedChar = (char) (curCharInt + neededOffset);
            if ((122 - curCharInt) > neededOffset) {
                neededOffset -= (122 - curCharInt);
                encryptedChar = (char) (97 + neededOffset);
            }
            if (curCharInt == 32) {
                encryptedChar = ' ';
            }
            returnString.append(encryptedChar);
        }
        return returnString.toString();
    }

    private String decryptPlainText(String cipherText, int userOffset) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char curChar = cipherText.charAt(i);
            int curCharInt = (int) curChar;
            int neededOffset = userOffset;
            char encryptedChar = (char) (curCharInt + neededOffset);
            if ((122 - curCharInt) > neededOffset) {
                neededOffset -= (122 - curCharInt);
                encryptedChar = (char) (97 + neededOffset);
            }
            if (curCharInt == 32) {
                encryptedChar = ' ';
            }
            returnString.append(encryptedChar);
        }
        return returnString.toString();
    }

}
