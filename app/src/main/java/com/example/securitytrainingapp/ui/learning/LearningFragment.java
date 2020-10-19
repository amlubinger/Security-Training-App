package com.example.securitytrainingapp.ui.learning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.securitytrainingapp.R;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LearningFragment extends Fragment {

    private LearningViewModel learningViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        learningViewModel =
                ViewModelProviders.of(this).get(LearningViewModel.class);
        View root = inflater.inflate(R.layout.fragment_learning, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.article_card_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Get the articles in a list. Temporarily using just string arrays with mock data.
        List<String[]> articles = new ArrayList<String[]>();
        String[] articleOne = new String[2];
        articleOne[0] = "Article One";
        articleOne[1] = "This is the description/summary of the first article.";
        String[] articleTwo = new String[2];
        articleTwo[0] = "Article Two";
        articleTwo[1] = "Here is another article summary! This will be a really great article for you to read. You will learn a lot.";
        String[] articleThree = new String[3];
        articleThree[0] = "Third Article";
        articleThree[1] = "Here is just one more article summary! Will this be the best article so far? There's only one way to find out! Check it out!";
        articles.add(articleOne);
        articles.add(articleTwo);
        articles.add(articleThree);

        ArticleCardAdapter adapter = new ArticleCardAdapter(articles);
        recyclerView.setAdapter(adapter);

        return root;
    }
}
