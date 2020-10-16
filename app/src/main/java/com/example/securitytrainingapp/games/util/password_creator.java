package com.example.securitytrainingapp.games.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class password_creator {
    /**
     * Utility Class that will supply randomized passwords for the password minigame
     */

    private int passwordMaxLength;
    private boolean passwordHasNumbers;
    private boolean passwordHasSymbols;
    private boolean passwordHasCapitals;
    private static List<String> words = new ArrayList<String>() {
        {
            add("word1");
            add("word2");
            add("word3");
        }
    };
    private static List<String> capWords = new ArrayList<String>() {
        {
            add("Word1");
            add("Word2");
            add("Word3");
        }
    };
    private static List<String> numbers = new ArrayList<String>() {
        {
            for(int i = 1; i < 10; i++) {
                add(Integer.toString(i));
            }
        }
    };
    private static List<String> symbols = new ArrayList<String>() {
        {
            add("*");
            add("(");
            add(")");
            add("_");
            add("-");
        }
    };
    public password_creator() {

    }

    public void setPasswordMaxLength(int passwordMaxLength) {
        this.passwordMaxLength = passwordMaxLength;
    }

    public void setPasswordHasNumbers(boolean passwordHasNumbers) {
        this.passwordHasNumbers = passwordHasNumbers;
    }

    public void setPasswordHasSymbols(boolean passwordHasSymbols) {
        this.passwordHasSymbols = passwordHasSymbols;
    }

    public void setPasswordHasCapitals(boolean passwordHasCapitals) {
        this.passwordHasCapitals = passwordHasCapitals;
    }

    public void setAllOptions(int passwordMaxLength, boolean passwordHasNumbers,
                              boolean passwordHasSymbols, boolean passwordHasCapitals) {
        this.passwordMaxLength = passwordMaxLength;
        this.passwordHasNumbers = passwordHasNumbers;
        this.passwordHasSymbols = passwordHasSymbols;
        this.passwordHasCapitals = passwordHasCapitals;
    }
    public String newPassword() {
        Random rand = new Random();
        String newPassword = "";
        if(passwordHasCapitals) {
            newPassword += capWords.get(rand.nextInt(capWords.size()));
        } else {
            newPassword += words.get(rand.nextInt(capWords.size()));
        }
        return newPassword;
    }
}
