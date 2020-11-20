package com.example.securitytrainingapp.ui.games;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import com.example.securitytrainingapp.R;
import com.example.securitytrainingapp.games.util.CryptographyGame;

public class CryptographyFragment extends Fragment {
    private View view;
    private CryptographyGame gameController;
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
        NumberPicker userOffsetPicker = view.findViewById(R.id.userOffsetNumberPicker);
        userOffsetPicker.setMaxValue(26);
        userOffsetPicker.setMinValue(1);
        return this.view;
    }
}