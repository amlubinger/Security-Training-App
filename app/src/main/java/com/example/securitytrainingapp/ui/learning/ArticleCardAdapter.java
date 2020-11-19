package com.example.securitytrainingapp.ui.learning;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.securitytrainingapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.List;

public class ArticleCardAdapter extends RecyclerView.Adapter<ArticleCardAdapter.ArticleViewHolder> {
    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView title;
        TextView text;

        ArticleViewHolder(View cardView) {
            super(cardView);
            card = (CardView) cardView.findViewById(R.id.card_article);
            title = (TextView) cardView.findViewById(R.id.card_article_title);
            text = (TextView) cardView.findViewById(R.id.card_article_text);
        }
    }

    List<String[]> articles;

    ArticleCardAdapter(List<String[]> articles) {
        this.articles = articles;
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.article_card, viewGroup, false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder articleViewHolder, int i) {
        final String[] article = articles.get(i);
        articleViewHolder.title.setText(article[0]);
        articleViewHolder.text.setText(article[1]);
        articleViewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = (View) view.getParent().getParent().getParent();
                View articleView = v.findViewById(R.id.article);
                TextView title = articleView.findViewById(R.id.article_title);
                title.setText(article[0]);
                TextView text = articleView.findViewById(R.id.article_text);
                text.setText(article[2]);
                BottomSheetBehavior<View> bottomSheet = BottomSheetBehavior.from(articleView);
                bottomSheet.setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
