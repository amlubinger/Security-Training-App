package com.example.securitytrainingapp;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.securitytrainingapp.ui.profile.Reward;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    NavController navController;

    public static int rewardScore = 25;
    public static int dayStreak = 3;
    public static ArrayList<Reward> rewards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_games, R.id.navigation_learning, R.id.navigation_profile)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Daily Reward");
        alertDialog.setMessage("You earned 50 points for using the app today!\n\nYour streak is " + (dayStreak + 1) + " days!");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Hooray!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dayStreak++;
                        rewardScore += 50;
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

        //Create the rewards list.
        rewards.add(new Reward("Free Chipotle Burrito", 500));
        rewards.add(new Reward("Free Wendy's Frosty", 500));
        rewards.add(new Reward("Buckeye Necklace", 750));
        rewards.add(new Reward("Brutus Keychain", 1000));
        rewards.add(new Reward("OSU T-Shirt", 1250));
        rewards.add(new Reward("Football Tickets", 1500));
        rewards.add(new Reward("Desk Chair", 1750));
        rewards.add(new Reward("Laptop", 2000));
        rewards.add(new Reward("Signed Heisman Trophy", 3000));
        rewards.add(new Reward("50% off Tuition", 3500));
        rewards.add(new Reward("Honorary Info Security Degree", 4000));

    }

    @Override
    public boolean onSupportNavigateUp() {
        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

}