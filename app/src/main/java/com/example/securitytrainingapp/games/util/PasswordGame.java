package com.example.securitytrainingapp.games.util;

import java.util.ArrayList;
import java.util.List;

public class PasswordGame {

    private int numRounds;
    private int playedRounds;
    private int correctRounds;
    private PasswordCreator worseAnswerMaker;
    private PasswordCreator betterAnswerMaker;


    public PasswordGame(int numRounds, int difficulty) {
        this.numRounds = numRounds;
        this.playedRounds = 0;
        this.correctRounds = 0;
        if (difficulty == 1) {
            this.worseAnswerMaker = new PasswordCreator(10, false, false, false);
            this.betterAnswerMaker = new PasswordCreator(25, true, true, true);
        } else if (difficulty == 2) {
            this.worseAnswerMaker = new PasswordCreator(15, true, false, true);
            this.betterAnswerMaker = new PasswordCreator(25, true, false, true);
        } else if (difficulty == 3) {
            this.worseAnswerMaker = new PasswordCreator(20, true, true, true);
            this.betterAnswerMaker = new PasswordCreator(25, true, true, true);
        }
    }
    public void addCorrectRound() {
        this.playedRounds += 1;
        this.correctRounds += 1;
    }
    public void addIncorrectRound() {
        this.playedRounds += 1;
    }
    /**
        @return Worse (incorrect choice) password first, then better (correct choice) password as second value in the list
     */
    public List<String> getPasswords() {
        List<String> passwords = new ArrayList<String>();
        String password1 = this.worseAnswerMaker.newPassword();
        String password2 = this.betterAnswerMaker.newPassword();
        if (betterPasswordIsBest(password1, password2)) {
            passwords.add(password1);
            passwords.add(password2);
        } else {
            passwords.add(password2);
            passwords.add(password1);
        }
        return passwords;
    }
    public boolean isGameOver() {
        if (playedRounds == numRounds) { return true; } else { return false; }
    }
    public int percentageCorrect() {
        float value = correctRounds / playedRounds;
        return Math.round(value * 100);
    }


    private boolean betterPasswordIsBest(String worsePassword, String betterPassword) {

        int bestPasswordIndex = 0;
        if (passwordContainsCaps(worsePassword) && !passwordContainsCaps(betterPassword)) {
            bestPasswordIndex -= 1;
        }
        if (passwordContainsNums(worsePassword) && !passwordContainsNums(betterPassword)) {
            bestPasswordIndex -= 1;
        }
        if (passwordContainsSyms(worsePassword) && !passwordContainsSyms(betterPassword)) {
            bestPasswordIndex -= 1;
        }
        if ((betterPassword.length()) - 5 >= worsePassword.length()) {
            bestPasswordIndex += 1;
            if ((betterPassword.length() - 10) >= worsePassword.length()) {
                bestPasswordIndex += 1;
            }
        }
        boolean betterPasswordIsBest = false;
        if (bestPasswordIndex >= 0) {
            betterPasswordIsBest = true;
        }
        return betterPasswordIsBest;
    }

    private boolean passwordContainsCaps(String password) {
        boolean passwordContainsCaps = false;
        for (int i = 0; i < PasswordCreator.capWords.size(); i++) {
            if (password.contains(PasswordCreator.capWords.get(i))) {
                passwordContainsCaps = true;
            }
        }
        return passwordContainsCaps;
    }
    private boolean passwordContainsNums(String password) {
        boolean passwordContainsNums = false;
        for (int i = 0; i < PasswordCreator.numbers.size(); i++) {
            if (password.contains(PasswordCreator.numbers.get(i))) {
                passwordContainsNums = true;
            }
        }
        return passwordContainsNums;
    }
    private boolean passwordContainsSyms(String password) {
        boolean passwordContainsSyms = false;
        for (int i = 0; i < PasswordCreator.symbols.size(); i++) {
            if (password.contains(PasswordCreator.symbols.get(i))) {
                passwordContainsSyms = true;
            }
        }
        return passwordContainsSyms;
    }
}
