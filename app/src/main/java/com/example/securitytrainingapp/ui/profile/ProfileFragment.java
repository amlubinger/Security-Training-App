package com.example.securitytrainingapp.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;
import com.example.securitytrainingapp.R;

import java.util.Collections;
import java.util.Comparator;

import static com.example.securitytrainingapp.MainActivity.rewardScore;
import static com.example.securitytrainingapp.MainActivity.rewards;

public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        ListView listView = root.findViewById(R.id.rewards_list);

        Collections.sort(rewards, new SortRewards());

        final ListAdapter adapter = new RewardAdapter(getContext(), R.id.rewards_list, rewards);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Redeem the reward.
                Reward r = (Reward) adapter.getItem(i);
                assert r != null;
                //Can only redeem if you have enough points.
                if(rewardScore >= r.getPointsNeeded()) {
                    r.redeem();
                    TextRoundCornerProgressBar progressBar = view.findViewById(R.id.progress_bar);
                    progressBar.setProgressColor(getResources().getColor(R.color.colorPrimaryDark));
                }
            }
        });

        return root;
    }
}

class SortRewards implements Comparator<Reward> {
    public int compare(Reward a, Reward b) {
        return a.getPointsNeeded() - b.getPointsNeeded();
    }
}
