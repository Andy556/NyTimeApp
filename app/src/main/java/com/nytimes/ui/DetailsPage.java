package com.nytimes.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nytimes.R;
import com.nytimes.utils.Constants;
import com.squareup.picasso.Picasso;

public class DetailsPage extends AppCompatActivity {
    private Toolbar mToolbar;
    private String mcaption, mCopyright, mImage;
    private TextView ivCaption, ivCopyright;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailpage);

        init();

        mcaption = getIntent().getStringExtra(Constants.CAPTION);
        mCopyright = getIntent().getStringExtra(Constants.COPYRIGHT);
        mImage = getIntent().getStringExtra(Constants.IMAGE);
        ivCaption.setText(mcaption);
        ivCopyright.setText(mCopyright);

        Picasso.get()
                .load(mImage)
                .into(ivImage);

    }

    private void init() {
        mToolbar = findViewById(R.id.toolbar);
        ivCaption = findViewById(R.id.ivCaption);
        ivCopyright = findViewById(R.id.ivCopyright);
        ivImage = findViewById(R.id.ivImage);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.detail_page));

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
