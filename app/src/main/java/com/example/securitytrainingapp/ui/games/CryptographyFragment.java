package com.example.securitytrainingapp.ui.games;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.example.securitytrainingapp.R;
import com.example.securitytrainingapp.games.util.CryptographyGame;

public class CryptographyFragment extends Fragment implements NumberPicker.OnValueChangeListener {
    private View view;
    private CryptographyGame gameController;
    private TextView cipherText;
    private TextView decryptText;
    private NumberPicker userOffsetPicker;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameController = new CryptographyGame();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.view = inflater.inflate(R.layout.fragment_cryptography, container, false);
        this.userOffsetPicker = view.findViewById(R.id.userOffsetNumberPicker);
        this.userOffsetPicker.setMaxValue(26);
        this.userOffsetPicker.setMinValue(1);

        this.cipherText = this.view.findViewById(R.id.encryptedText);
        this.cipherText.setText(gameController.provideCipherText());
        this.decryptText = this.view.findViewById(R.id.userDecryptText);
        this.decryptText.setText("");
        this.userOffsetPicker.setOnValueChangedListener(this);
        return this.view;
    }

    @Override
    public void onValueChange(NumberPicker numberPicker, int i, int i1) {
        //Set the decrypt text to display user's choice for offset
        this.decryptText.setText(gameController.provideDecryptText(gameController.provideCipherText(), this.userOffsetPicker.getValue()));
        if (gameController.checkUserOffset(gameController.provideCipherText(), this.userOffsetPicker.getValue())) {
            this.view.setBackgroundColor(0xFFB2F478);
        } else {
            this.view.setBackgroundColor(0xFFFF6F6F);
        }
    }
}