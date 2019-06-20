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
import com.nytimes.ui.DetailsPage;
import com.nytimes.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private Context mContext;
    private List<ArticleList> articleLists;
    ArticleList mArticleList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyTextView tvAuthor, tvDate;
        TextView tvHeader;
        RelativeLayout layout;
        CircleImageView ivIcon;

        public MyViewHolder(View view) {
            super(view);
            tvHeader = view.findViewById(R.id.tvHeader);
            tvAuthor = view.findViewById(R.id.tvAuthor);
            tvDate = view.findViewById(R.id.tvDate);
            layout = view.findViewById(R.id.layout);
            ivIcon = view.findViewById(R.id.ivIcon);

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
        Picasso.get()
                .load(mArticleList.getMedia().get(0).getMediaMetadata().get(3).getUrl())
                .into(holder.ivIcon);


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArticleList = articleLists.get(position);
                String mCaption = mArticleList.getMedia().get(0).getCaption();
                String mCopyright = mArticleList.getMedia().get(0).getCopyright();
                String mImage = mArticleList.getMedia().get(0).getMediaMetadata().get(3).getUrl();

                Intent intent = new Intent(mContext, DetailsPage.class);
                intent.putExtra(Constants.CAPTION, mCaption);
                intent.putExtra(Constants.COPYRIGHT, mCopyright);
                intent.putExtra(Constants.IMAGE, mImage);
                mContext.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return articleLists.size();
    }
}



