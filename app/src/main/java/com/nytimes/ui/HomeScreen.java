package com.nytimes.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nytimes.R;
import com.nytimes.adapter.ArticleAdapter;
import com.nytimes.model.ArticleList;
import com.nytimes.utils.Constants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreen extends AppCompatActivity {

    private ProgressDialog mProgressDialog;
    Gson gson;
    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private ArticleAdapter articleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homescreen);

        /*Gson*/
        gson = new Gson();

        init();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        getHomeFeeds();
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);

        mRecyclerView = findViewById(R.id.recycler_view);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        getSupportActionBar().setTitle(getResources().getString(R.string.title));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            Toast.makeText(HomeScreen.this, "Action clicked", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*Login */
    private void getHomeFeeds() {


        mProgressDialog = new ProgressDialog(HomeScreen.this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(getResources().getString(R.string.loading));
        mProgressDialog.show();

        Constants.retrofitService.homefeeds(Constants.API_KEY).enqueue(new Callback<ResponseBody>() {


            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    JSONObject jsonObject = new JSONObject(string);

                    if (jsonObject.getString(getResources().getString(R.string.status)).equalsIgnoreCase(getResources().getString(R.string.ok))) {

                        JSONArray jsonArray = jsonObject.getJSONArray(Constants.RESULTS);

                        if (jsonArray.length() > 0) {
                            Gson gson = new Gson();
                            List<ArticleList> articleLists = gson.fromJson(jsonArray.toString(), new TypeToken<List<ArticleList>>() {
                            }.getType());

                            articleAdapter = new ArticleAdapter(HomeScreen.this, articleLists);
                            mRecyclerView.setAdapter(articleAdapter);
                            mProgressDialog.dismiss();


                        } else {
                            mProgressDialog.dismiss();
                        }
//

                    } else if (jsonObject.getString(getResources().getString(R.string.status)).equalsIgnoreCase(getResources().getString(R.string.failed))) {
                        mProgressDialog.dismiss();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(HomeScreen.this, getResources().getString(R.string.failed_host), Toast.LENGTH_SHORT).show();
                mProgressDialog.dismiss();
            }
        });
    }
}

