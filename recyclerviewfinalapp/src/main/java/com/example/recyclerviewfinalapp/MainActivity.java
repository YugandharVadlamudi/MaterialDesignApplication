package com.example.recyclerviewfinalapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerviewfinalapp.adapters.UserDataAdapter;
import com.example.recyclerviewfinalapp.interfaces.OnItemClickListener;
import com.example.recyclerviewfinalapp.utils.UserData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserData> arraylistUserData;
    private Context context;
    private String TAG = MainActivity.class.getSimpleName();
    private boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        context = getApplicationContext();
        arraylistUserData = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rv_mainactivity_data);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadData();
        final UserDataAdapter userDataAdapter = new UserDataAdapter(arraylistUserData, recyclerView, context);
        userDataAdapter.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClickListener(View v) {
                Toast.makeText(MainActivity.this, "click adapter", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(userDataAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addOnScrollListener(new );
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int totalItemCount = linearLayoutManager.getItemCount();
                int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                Log.e(TAG, "onScrolled: totalItemCount->" + totalItemCount
                        + "\n lastVisibleItem->" + lastVisibleItem
                        +"\n firstvisibleitem->"+linearLayoutManager.findFirstVisibleItemPosition());
                /*
                * Came to end and progress bar is not showing
                * then show it and add null
                * */
                if (!isLoading && totalItemCount <= lastVisibleItem + 2) {
                    Log.e(TAG, "onScrolled: load more data");
//                    adding null to show a progress bar
                    arraylistUserData.add(null);
                    userDataAdapter.notifyDataSetChanged();
                    Handler handler = new Handler();//adding data after a few secounds
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                            get the index of null and removing it update dataset of adapter
                            arraylistUserData.remove(arraylistUserData.indexOf(null));
                            Log.e(TAG, "run: arraylist size is-> " + arraylistUserData.size());
                            userDataAdapter.notifyDataSetChanged();
//                            adding some data
                            for (int i = 0; i < 3; i++) {
                                UserData userData = new UserData();
                                userData.setName("Handler name->" + i);
                                userData.setEmali("Handler email->" + i + "@gmail.com");
                                arraylistUserData.add(userData);
                            }
//                            now dataset changed
                            userDataAdapter.notifyDataSetChanged();
//                            making invisible progressbar
//                            this is excuted after five secounds
//                            in this any scroll happend means it will show multiple progressbar
                            isLoading = false;

                        }
                    }, 3000);
//                    to avoid multiple progressbar in recycleview and multiple times it is neede
//                    and make it true
//                    with in 3 secounds we are scrolling not make to create another thread 
                    isLoading = true;
                }

            }
        });
    }

    private void loadData() {
        for (int item = 0; item < 20; item++) {
            UserData userData = new UserData();
            userData.setName("Name->" + item);
            userData.setEmali("email->" + item + "@gmail.com");
            arraylistUserData.add(userData);
        }
    }
}
