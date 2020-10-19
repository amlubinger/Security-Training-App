package com.example.securitytrainingapp.ui.games;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.securitytrainingapp.R;
import com.example.securitytrainingapp.games.util.PasswordCreator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BestPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BestPasswordFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BestPasswordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BestPasswordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BestPasswordFragment newInstance(String param1, String param2) {
        BestPasswordFragment fragment = new BestPasswordFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_best_password, container, false);
        PasswordCreator passwordCreatorNoCapsNums = new PasswordCreator(10, true, false, false);
        PasswordCreator passwordCreatorCapsNums = new PasswordCreator(20, true, false, true);
        final Button button1 = (Button)view.findViewById(R.id.button_password1);
        final Button button2 = (Button)view.findViewById(R.id.button_password2);
        Log.i("Test", passwordCreatorCapsNums.newPassword());
        button1.setText(passwordCreatorNoCapsNums.newPassword());
        button2.setText(passwordCreatorCapsNums.newPassword());
        return view;
    }
}