package com.example.securitytrainingapp.ui.games;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.securitytrainingapp.R;
import com.example.securitytrainingapp.games.util.PasswordGame;

import java.util.List;
import java.util.Random;


public class BestPasswordFragment extends Fragment implements View.OnClickListener{
    private View view;
    private PasswordGame gameController;
    private Button topButton;
    private Button bottomButton;
    private Button difficulty1Button;
    private Button difficulty2Button;
    private Button difficulty3Button;
    private TextView scoreDisplayText;
    private TextView instructions;
    private Random rand;
    private boolean isTopButtonCorrect;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rand = new Random();
        isTopButtonCorrect = isTopButtonCorrect();
        gameController = new PasswordGame(5, 1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_best_password, container, false);
        difficulty1Button = view.findViewById(R.id.difficultyButton1);
        difficulty2Button = view.findViewById(R.id.difficultyButton2);
        difficulty3Button = view.findViewById(R.id.difficultyButton3);
        topButton = view.findViewById(R.id.passwordButtonTop);
        bottomButton = view.findViewById(R.id.passwordButtonBottom);
        scoreDisplayText = view.findViewById(R.id.textScoreDisplay);
        instructions = view.findViewById(R.id.instructions);
        setPasswordButtonsDisabled();
        topButton.setOnClickListener(this);
        bottomButton.setOnClickListener(this);
        difficulty1Button.setOnClickListener(this);
        difficulty2Button.setOnClickListener(this);
        difficulty3Button.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.passwordButtonTop:
                onTopButtonClick(view);
                break;
            case R.id.passwordButtonBottom:
                onBottomButtonClick(view);
                break;
            case R.id.difficultyButton1:
                gameController = new PasswordGame(5, 1);
                setPasswordButtonsText();
                setPasswordButtonsEnabled();
                instructions.setText("Select the more secure password!");
                break;
            case R.id.difficultyButton2:
                gameController = new PasswordGame(6, 2);
                setPasswordButtonsText();
                setPasswordButtonsEnabled();
                instructions.setText("Select the more secure password!");
                break;
            case R.id.difficultyButton3:
                gameController = new PasswordGame(8, 3);
                setPasswordButtonsText();
                setPasswordButtonsEnabled();
                instructions.setText("Select the more secure password!");
                break;
        }
    }

    private void onTopButtonClick(View view) {
        //Add round
        if (isTopButtonCorrect) {
            gameController.addCorrectRound();
        } else {
            gameController.addIncorrectRound();
        }
        if(!gameController.gameIsOver()) {
            //Set new correct button
            isTopButtonCorrect = isTopButtonCorrect();
            //Set up buttons again
            List<String> passwords = gameController.getPasswords();
            if (isTopButtonCorrect) {
                topButton.setText(passwords.get(1));
                bottomButton.setText(passwords.get(0));
            } else {
                topButton.setText(passwords.get(0));
                bottomButton.setText(passwords.get(1));
            }
        } else {
            //Set text view to show score
            instructions.setText("You scored: " + gameController.percentageCorrect() + "%");
            //Disable buttons
            topButton.setEnabled(false);
            bottomButton.setEnabled(false);
        }
        Log.d("Password Game", gameController.string());
    }

    private void onBottomButtonClick(View view) {
        //Add round
        if (isTopButtonCorrect) {
            gameController.addIncorrectRound();
        } else {
            gameController.addCorrectRound();
        }
        if(!gameController.gameIsOver()) {
            //Set new correct button
            isTopButtonCorrect = isTopButtonCorrect();
            //Set up buttons again
            List<String> passwords = gameController.getPasswords();
            if (isTopButtonCorrect) {
                topButton.setText(passwords.get(1));
                bottomButton.setText(passwords.get(0));
            } else {
                topButton.setText(passwords.get(0));
                bottomButton.setText(passwords.get(1));
            }
        } else {
            //Set text view to show score
            instructions.setText("You scored: " + gameController.percentageCorrect() + "%");
            //Disable buttons
            topButton.setEnabled(false);
            bottomButton.setEnabled(false);
        }
        Log.d("Password Game", gameController.string());
    }

    private boolean isTopButtonCorrect() {
        return rand.nextBoolean();
    }

    private void setPasswordButtonsEnabled() {
        topButton.setEnabled(true);
        bottomButton.setEnabled(true);
    }
    private void setPasswordButtonsDisabled() {
        topButton.setEnabled(false);
        bottomButton.setEnabled(false);
    }

    private void setPasswordButtonsText() {
        //Set up buttons with text
        List<String> passwords = gameController.getPasswords();
        if (isTopButtonCorrect) {
            topButton.setText(passwords.get(1));
            bottomButton.setText(passwords.get(0));
        } else {
            topButton.setText(passwords.get(0));
            bottomButton.setText(passwords.get(1));
        }
    }
}