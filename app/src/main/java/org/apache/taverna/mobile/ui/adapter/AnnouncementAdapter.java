package org.apache.taverna.mobile.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.apache.taverna.mobile.R;
import org.apache.taverna.mobile.data.model.Announcements;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnnouncementAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Announcements.Announcement> mAnnouncementList;
    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;


    public AnnouncementAdapter( List<Announcements.Announcement> announcementList) {
        mAnnouncementList = announcementList;
    }

    public void setAnnouncementList(List<Announcements.Announcement> announcementList) {
        mAnnouncementList = announcementList;
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;
        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar)v.findViewById(R.id.progressBar1);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == VIEW_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_recyclerview, parent, false);

            vh = new ViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_progressbar, parent, false);

            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder) {
            ((ViewHolder) holder).tvAnnouncementTitle.setText(mAnnouncementList.get(position).getContent());
            Log.e("", "onBindViewHolder: "+mAnnouncementList.get(1).getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mAnnouncementList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mAnnouncementList.get(position)!=null? VIEW_ITEM: VIEW_PROG;
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textview_announcement)
        TextView tvAnnouncementTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}