package com.example.recycleviewprogressbarapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.recycleviewprogressbarapplication.Utils.UserDetails;
import com.example.recycleviewprogressbarapplication.adapter.NameEamilAdapter;
import com.example.recycleviewprogressbarapplication.interfaes.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<UserDetails> listUserDetails;
    private LinearLayoutManager linearLayoutManager;
    private NameEamilAdapter nameEamilAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        listUserDetails=new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.rv_main_items);
        creatUserDetails();
        setRecyclerViewPropertys();

    }

    private void setRecyclerViewPropertys() {
        context = getApplicationContext();
        linearLayoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        nameEamilAdapter=new NameEamilAdapter(recyclerView,context,listUserDetails);
        recyclerView.setAdapter(nameEamilAdapter);

//        recyclerView.addOnScrollListener();

        /*nameEamilAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLodeMore() {
                listUserDetails.add(null);
                nameEamilAdapter.notifyItemInserted(listUserDetails.size()-1);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listUserDetails.remove(listUserDetails.size() - 1);
                        nameEamilAdapter.notifyItemRemoved(listUserDetails.size());
                        int index = listUserDetails.size();
                        int end = index + 20;
                        for (int i = index; i < end; i++) {
                            UserDetails userDetails = new UserDetails();
                            userDetails.setUserName("Name:::"+i);
                            userDetails.setUserEmail("Email:::"+i+"@yahoo.in");
                            listUserDetails.add(userDetails);
                        }
                        nameEamilAdapter.notifyDataSetChanged();
                        nameEamilAdapter.setLoaded();

                    }
                }, 5000);

            }
        })*/;
        /*demoInterface demoInterface_=new demoInterface();
        nameEamilAdapter.setOnLoadMoreListener(demoInterface_);*/
    }

    private void creatUserDetails() {
        for (int nLoops = 0; nLoops < 30; nLoops++) {
            UserDetails userDetails=new UserDetails();
            userDetails.setUserName("Name::"+nLoops);
            userDetails.setUserEmail("Email::"+nLoops+"@gmail.com");
            listUserDetails.add(userDetails);
        }
    }

    class demoInterface implements OnLoadMoreListener {

        @Override
        public void onLodeMore() {
            Log.e(TAG, "onLodeMore: demo");
        }
    }
}
