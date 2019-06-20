package com.nytimes.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nytimes.R;
import com.nytimes.custom_font.MyTextView;
import com.nytimes.model.ArticleList;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private Context mContext;
    private List<ArticleList> articleLists;
    ArticleList mArticleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyTextView tvAuthor, tvDate;
        TextView tvHeader;
        RelativeLayout layout;

        public MyViewHolder(View view) {
            super(view);
            tvHeader = view.findViewById(R.id.tvHeader);
            tvAuthor = view.findViewById(R.id.tvAuthor);
            tvDate = view.findViewById(R.id.tvDate);
            layout = view.findViewById(R.id.layout);

        }
    }


    public ArticleAdapter(Context mContext, List<ArticleList> installmentsInfos) {
        this.mContext = mContext;
        this.articleLists = installmentsInfos;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.articles_cell, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        mArticleList = articleLists.get(position);
        holder.tvHeader.setText(mArticleList.getTitle());
        holder.tvAuthor.setText(mArticleList.getByline());
        holder.tvDate.setText(mArticleList.getPublishedDate());


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext,"pos " + position,Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    public int getItemCount() {
        return articleLists.size();
    }
}



