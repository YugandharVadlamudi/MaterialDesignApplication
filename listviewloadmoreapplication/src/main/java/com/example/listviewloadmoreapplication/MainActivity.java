package com.example.listviewloadmoreapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import com.example.listviewloadmoreapplication.adapter.DataAdapter;
import com.example.listviewloadmoreapplication.utils.UserData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private View footer;
    private List<UserData> list = new ArrayList<>();
    private String TAG = MainActivity.class.getSimpleName();
    private int pageCount=1;
    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_mainactvity);
        for (int i = 0; i < 2; i++) {
            UserData userData=new UserData();
            userData.setName("yuga"+i);
            userData.setEmail("yuga"+i+"@gmail.com");
            list.add(userData);

        }
        dataAdapter = new DataAdapter(list);
        recyclerView.setAdapter(dataAdapter);
        /*
        listview = (ListView) findViewById(R.id.lv_mainactivity);
        String[] arraysList = getResources().getStringArray(R.array.firstList);
        for (int lengthList=0;lengthList<arraysList.length;lengthList++) {
            list.add(arraysList[lengthList]);
        }
        setListViewPropertys();
    */}

//    private void setListViewPropertys() {
//        footer = (View) LayoutInflater.from(getApplicationContext())
//                .inflate(R.layout.layout_progressbar, null);
//        listview.addFooterView(footer);
////        listview.addHeaderView(footer);
//        final ArrayAdapter arrayAdapter = new ArrayAdapter(
//                getApplicationContext(), android.R.layout.simple_list_item_1
//                , list);
//        listview.setAdapter(arrayAdapter);
//        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//                Log.e(TAG, "onScrollStateChanged: view->" + view + "\n ScrollState->" + scrollState);
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                Log.e(TAG, "onScroll: view->" + view + "\n VisibleCount->" + visibleItemCount
//                        + "\n totalItemCount" + totalItemCount
//                        +"\n firstVisibleItem->"+firstVisibleItem);
//                int totalItemsVisible = firstVisibleItem + visibleItemCount;
//                if (pageCount<2) {
//                }
//                if (totalItemsVisible == totalItemCount) {
//                    Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            String[] array=getResources().getStringArray(R.array.secoundfirstList);
//                            for (int i=0;i<array.length;i++) {
//                                list.add(array[i]);
//                            }
//                            arrayAdapter.notifyDataSetChanged();
//                            listview.setAdapter(arrayAdapter);
//                            pageCount++;
//
//                        }
//                    }, 3000);
//                } else {
//                    Log.e("hide footer", "footer hide");
//                    listview.removeFooterView(footer);
//                }
//            }
//        });
//
//    }
}
