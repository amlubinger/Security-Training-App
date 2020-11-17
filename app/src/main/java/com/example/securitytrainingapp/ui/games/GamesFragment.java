package com.example.securitytrainingapp.ui.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.securitytrainingapp.R;
import com.example.securitytrainingapp.games.util.PasswordCreator;

public class GamesFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_best_password, container, false);
        PasswordCreator passwordCreatorNoCapsNums = new PasswordCreator(10, true, false, false);
        PasswordCreator passwordCreatorCapsNums = new PasswordCreator(20, true, false, true);
        final Button button1 = (Button)view.findViewById(R.id.passwordButtonTop);
        final Button button2 = (Button)view.findViewById(R.id.passwordButtonBottom);
        button1.setText(passwordCreatorNoCapsNums.newPassword());
        button2.setText(passwordCreatorCapsNums.newPassword());
        return view;
    }
}