package com.example.securitytrainingapp.games.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordCreator {
    /**
     * Utility Class that will supply randomized passwords for the password minigame
     */

    private int passwordMaxLength;
    private boolean passwordHasNumbers;
    private boolean passwordHasSymbols;
    private boolean passwordHasCapitals;


    private static List<String> words = new ArrayList<String>() {
        {
            add("test");
            add("hello");
            add("world");
            add("drink");
            add("lastname");
            add("password");
            add("service");
        }
    };
    private static List<String> capWords = new ArrayList<String>() {
        {
            add("Test");
            add("Hello");
            add("World");
            add("Drink");
            add("Lastname");
            add("Password");
            add("Service");
        }
    };
    private static List<String> numbers = new ArrayList<String>() {
        {
            for(int i = 0; i < 10; i++) {
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

    public PasswordCreator(int passwordMaxLength, boolean passwordHasNumbers, boolean passwordHasSymbols, boolean passwordHasCapitals) {
        this.passwordMaxLength = passwordMaxLength;
        this.passwordHasNumbers = passwordHasNumbers;
        this.passwordHasSymbols = passwordHasSymbols;
        this.passwordHasCapitals = passwordHasCapitals;
    }

    public String newPassword() {
        Random rand = new Random();
        boolean returnPassNumbers = false;
        boolean returnPassSymbols = false;
        String newPassword = "";
        for(int i = 1; i < rand.nextInt(4); i++) {
            if (passwordHasCapitals) {
                newPassword += capWords.get(rand.nextInt(capWords.size()));
            } else {
                newPassword += words.get(rand.nextInt(words.size()));
            }
            if (passwordHasNumbers && rand.nextBoolean()) {
                newPassword += numbers.get(rand.nextInt(numbers.size()));
                returnPassNumbers = true;
            }
            if (passwordHasSymbols && rand.nextBoolean()) {
                newPassword += symbols.get(rand.nextInt(symbols.size()));
                returnPassSymbols = true;
            }
        }
        if (passwordHasNumbers && !returnPassNumbers) {
            newPassword += numbers.get(rand.nextInt(numbers.size()));
        }
        if (passwordHasSymbols && !returnPassSymbols) {
            newPassword += symbols.get(rand.nextInt(symbols.size()));
        }
        return newPassword;
    }
}
