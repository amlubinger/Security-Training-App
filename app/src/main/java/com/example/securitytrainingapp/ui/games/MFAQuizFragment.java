package com.example.securitytrainingapp.ui.games;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.securitytrainingapp.R;
import com.example.securitytrainingapp.games.util.MFAGame;

import java.util.Random;


public class MFAQuizFragment extends Fragment implements View.OnClickListener{
    private Random rand;
    private Button leftButton;
    private Button rightButton;
    private View view;
    private MFAGame gameController;
    private boolean isLeftButtonCorrect;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rand = new Random();
        isLeftButtonCorrect = isLeftButtonCorrect();
        gameController = new MFAGame();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mfa_quiz, container, false);

        //Set up first question, this needs to be redone on button clicks as well
        String currentQuestion = gameController.getCurrentQuestion();
        TextView questionText = view.findViewById(R.id.questionText);
        questionText.setText(currentQuestion);


        //Set up buttons for first question, redone in button onClicks
        leftButton = view.findViewById(R.id.mfaButtonLeft);
        rightButton = view.findViewById(R.id.mfaButtonRight);
        if (isLeftButtonCorrect) {
            leftButton.setText(gameController.getCorrectAnswerOption());
            rightButton.setText(gameController.getIncorrectAnswerOption());
        } else {
            leftButton.setText(gameController.getIncorrectAnswerOption());
            rightButton.setText(gameController.getCorrectAnswerOption());
        }
        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);




        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mfaButtonLeft:
                onLeftButtonClick();
                break;
            case R.id.mfaButtonRight:
                onRightButtonClick();
                break;
        }
    }

    private void onLeftButtonClick() {
        //Add round
        if (isLeftButtonCorrect) {
            gameController.addCorrectRound();
        } else {
            gameController.addIncorrectRound();
        }
        if (!gameController.gameIsOver()) {
            //Reset question
            gameController.setNewRandomQuestion();
            String currentQuestion = gameController.getCurrentQuestion();
            TextView questionText = this.view.findViewById(R.id.questionText);
            questionText.setText(currentQuestion);
            //Set new correct button
            isLeftButtonCorrect = isLeftButtonCorrect();
            //Set up buttons again
            if (isLeftButtonCorrect) {
                leftButton.setText(gameController.getCorrectAnswerOption());
                rightButton.setText(gameController.getIncorrectAnswerOption());
            } else {
                leftButton.setText(gameController.getIncorrectAnswerOption());
                rightButton.setText(gameController.getCorrectAnswerOption());
            }
        } else {
            //Set question text to show stats
            String overallScore = gameController.getFinalScoreString();
            TextView questionText = this.view.findViewById(R.id.questionText);
            questionText.setText(overallScore);
            //Disable answer buttons
            leftButton.setEnabled(false);
            rightButton.setEnabled(false);
        }

    }

    private void onRightButtonClick() {
        //Add round
        if (isLeftButtonCorrect) {
            gameController.addIncorrectRound();
        } else {
            gameController.addCorrectRound();
        }
        if (!gameController.gameIsOver()) {
            //Reset question
            gameController.setNewRandomQuestion();
            String currentQuestion = gameController.getCurrentQuestion();
            TextView questionText = this.view.findViewById(R.id.questionText);
            questionText.setText(currentQuestion);
            //Set new correct button
            isLeftButtonCorrect = isLeftButtonCorrect();
            //Set up buttons again
            if (isLeftButtonCorrect) {
                leftButton.setText(gameController.getCorrectAnswerOption());
                rightButton.setText(gameController.getIncorrectAnswerOption());
            } else {
                leftButton.setText(gameController.getIncorrectAnswerOption());
                rightButton.setText(gameController.getCorrectAnswerOption());
            }
        } else {
            //Set question text to show stats
            String overallScore = gameController.getFinalScoreString();
            TextView questionText = this.view.findViewById(R.id.questionText);
            questionText.setText(overallScore);
            //Disable answer buttons
            leftButton.setEnabled(false);
            rightButton.setEnabled(false);
        }
    }

    private boolean isLeftButtonCorrect() {
        return rand.nextBoolean();
    }


}