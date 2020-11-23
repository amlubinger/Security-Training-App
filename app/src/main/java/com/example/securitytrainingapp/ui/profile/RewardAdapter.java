package com.example.securitytrainingapp.ui.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;
import com.example.securitytrainingapp.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.securitytrainingapp.MainActivity.rewardScore;

public class RewardAdapter extends ArrayAdapter<Reward> {
    private final List<Reward> mItems;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public RewardAdapter(Context context, int resourceId, ArrayList<Reward> items) {
        super(context, resourceId, items);

        mContext = context;
        mItems = items;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.reward, null);
            holder = new ViewHolder();
            holder.progressBar = (TextRoundCornerProgressBar)convertView.findViewById(R.id.progress_bar);
            holder.textView = (TextView)convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        Reward item = getItem(position);
        if (item != null) {
            holder.progressBar.setMax(item.getPointsNeeded());
            holder.progressBar.setSecondaryProgress(item.getPointsNeeded());
            holder.progressBar.setProgress(rewardScore);
            int percentage = (int) (((double) (rewardScore / (double) item.getPointsNeeded()) * 100));
            if(percentage > 100) {
                percentage = 100;
            }
            holder.progressBar.setProgressText(percentage + "%");
            holder.textView.setText(item.getName());
        }

        return convertView;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Reward getItem(int position) {
        return mItems.get(position);
    }

    public class ViewHolder {
        TextRoundCornerProgressBar progressBar;
        TextView textView;
    }
}
