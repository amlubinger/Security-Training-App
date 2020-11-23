package com.example.securitytrainingapp.games.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MFAGame {

    private final int numRounds = 8;
    private static final List<String> knowFactors = new ArrayList<String>() {
        {
            add("Knock Code");
            add("Password");
            add("PIN");
            add("Combination");
            add("Secret Handshake");
        }
    };
    private static final List<String> haveFactors = new ArrayList<String>() {
        {
            add("Key");
            add("Phone Number");
            add("Authentication App");
            add("USB Drive");
            add("ATM Card");
        }
    };
    private static final List<String> areFactors = new ArrayList<String>() {
        {
            add("Fingerprint");
            add("Iris");
            add("Voice");
            add("Face");
            add("Retina");
        }
    };
    private Random rand;
    private int playedRounds;

    private int correctRounds;

    public int getCorrectRounds() {
        return correctRounds;
    }

    //This variable is 0 for something you know, 1 for something you have, and 2 for something you are
    private int currentQuestion;

    public MFAGame() {
        rand = new Random();
    }

    public void addCorrectRound() {
        playedRounds++;
        correctRounds++;
    }

    public void addIncorrectRound() {
        playedRounds++;
    }

    public boolean gameIsOver() {
        return playedRounds == numRounds;
    }

    public String getCurrentQuestion() {
        if (this.currentQuestion == 0) {
            return "Which of these is something you know?";
        } else if (this.currentQuestion == 1) {
            return "Which of these is something you have?";
        } else {
            return "Which of these is something you are?";
        }
    }
    public int getCurrentQuestionNumber() {
        return this.currentQuestion;
    }

    public void setNewRandomQuestion() {
        this.currentQuestion = rand.nextInt(3);
    }

    public String getCorrectAnswerOption() {
        if (this.currentQuestion == 0) {
            return knowFactors.get(rand.nextInt(knowFactors.size()));
        } else if (this.currentQuestion == 1) {
            return haveFactors.get(rand.nextInt(haveFactors.size()));
        } else {
            return areFactors.get(rand.nextInt(areFactors.size()));
        }
    }

    public String getIncorrectAnswerOption() {
        if (this.currentQuestion == 0) {
            if (rand.nextBoolean()) {
                return haveFactors.get(rand.nextInt(knowFactors.size()));
            } else {
                return areFactors.get(rand.nextInt(areFactors.size()));
            }
        } else if (this.currentQuestion == 1) {
            if (rand.nextBoolean()) {
                return areFactors.get(rand.nextInt(areFactors.size()));
            } else {
                return knowFactors.get(rand.nextInt(knowFactors.size()));
            }
        } else {
            if (rand.nextBoolean()) {
                return knowFactors.get(rand.nextInt(knowFactors.size()));
            } else {
                return haveFactors.get(rand.nextInt(haveFactors.size()));
            }
        }
    }

    public String getFinalScoreString() {
        return "You got " + correctRounds + " questions right out of " + playedRounds + ".";
    }

}
