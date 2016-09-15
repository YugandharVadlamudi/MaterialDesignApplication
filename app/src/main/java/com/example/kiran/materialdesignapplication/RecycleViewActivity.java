package com.example.kiran.materialdesignapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.kiran.materialdesignapplication.adapter.RecycleViewAdater;

public class RecycleViewActivity extends ActionBarActivity {
    private static final String TAG = RecycleViewActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        initilizingViews();
    }

    private void initilizingViews() {

        recyclerView = (RecyclerView) findViewById(R.id.rv_activityrv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        String[] nRowValues = getResources().getStringArray(R.array.recycleview_values);
        Log.e(TAG, "initilizingViews: nRowValue->" + nRowValues.length);
        RecycleViewAdater recycleViewAdater=new RecycleViewAdater(nRowValues);
        recyclerView.setAdapter(recycleViewAdater);
    }
}
