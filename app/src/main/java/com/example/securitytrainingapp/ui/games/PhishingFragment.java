package com.example.securitytrainingapp.ui.games;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.fragment.app.Fragment;

import com.example.securitytrainingapp.R;

public class PhishingFragment extends Fragment {
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_phishing, container, false);
        Button submitButton = v.findViewById(R.id.submit_button);

        final CheckBox urgent = v.findViewById(R.id.checkbox_urgent);
        final CheckBox address = v.findViewById(R.id.checkbox_address);
        final CheckBox grammar = v.findViewById(R.id.checkbox_grammar);
        final CheckBox url = v.findViewById(R.id.checkbox_url);
        final CheckBox attachment = v.findViewById(R.id.checkbox_attachment);
        final CheckBox personal = v.findViewById(R.id.checkbox_personal);
        final CheckBox unusual = v.findViewById(R.id.checkbox_unusual);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(urgent.isChecked() && address.isChecked() && grammar.isChecked() && !url.isChecked() && !attachment.isChecked() && !personal.isChecked() && unusual.isChecked()) {
                    v.setBackgroundColor(0xFFB2F478);
                } else {
                    v.setBackgroundColor(0xFFFF6F6F);
                }
            }
        });

        return v;
    }
}