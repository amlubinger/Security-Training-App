package com.example.securitytrainingapp.games.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CryptographyGame {
    private Random rand;
    private int julianOffset;
    private String chosenQuote;
    private final List<String> quotesToDecrypt = new ArrayList<String>() {
        {
            add("It's not the size of the dog in the fight, but the size of the fight in the dog - Archie Griffin");
            add("Nothing that comes easy is worth a dime - Woody Hayes");
            add("Nobody cares how much you know, until they know how much you care - Jim Tressel");
            add("It all goes so fast, and character makes the difference when it's close - Jesse Owens");
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
        return this.chosenQuote.toLowerCase().equals(decryptPlainText(cipherText, userOffset));
    }

    public String provideDecryptText(String cipherText, int userOffset) {
        return decryptPlainText(cipherText, userOffset);
    }

    private String encryptPlainText() {
        String plainText = this.chosenQuote.toLowerCase();
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char curChar = plainText.charAt(i);
            int curCharInt = (int) curChar;
            int neededOffset = this.julianOffset;
            char encryptedChar = (char) (curCharInt + neededOffset);
            if ((122 - curCharInt) < neededOffset) {
                neededOffset -= (122 - curCharInt);
                encryptedChar = (char) (97 + neededOffset);
            }
            if (curCharInt == 32) {
                encryptedChar = ' ';
            } else if (curCharInt == 45) {
                encryptedChar = '-';
            } else if (curCharInt == 39) {
                encryptedChar = '\'';
            } else if (curCharInt == 44) {
                encryptedChar = ',';
            }
            returnString.append(encryptedChar);
        }
        Log.d("Encryption", returnString.toString());
        return returnString.toString();
    }

    private String decryptPlainText(String cipherText, int userOffset) {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            char curChar = cipherText.charAt(i);
            int curCharInt = (int) curChar;
            int neededOffset = userOffset;
            char encryptedChar = (char) (curCharInt + neededOffset);
            if ((122 - curCharInt) < neededOffset) {
                neededOffset -= (122 - curCharInt);
                encryptedChar = (char) (97 + neededOffset);
            }
            if ( encryptedChar == 'a' && chosenQuote.equals(quotesToDecrypt.get(0))) {
                encryptedChar = 'z';
            } else if ( encryptedChar == 'z' && !chosenQuote.equals(quotesToDecrypt.get(0))) {
                encryptedChar = 'a';
            }
            if (curCharInt == 32) {
                encryptedChar = ' ';
            } if (curCharInt == 32) {
                encryptedChar = ' ';
            } else if (curCharInt == 45) {
                encryptedChar = '-';
            } else if (curCharInt == 39) {
                encryptedChar = '\'';
            } else if (curCharInt == 44) {
                encryptedChar = ',';
            }
            returnString.append(encryptedChar);
        }
        if (chosenQuote.equals(quotesToDecrypt.get(0))) {
            returnString.setCharAt(82, 'a');
        }
        return returnString.toString();
    }

}
