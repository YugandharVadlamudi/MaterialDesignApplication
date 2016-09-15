package com.compindia.collapsingtoolbarapp;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar tbMain;
    private CollapsingToolbarLayout ctlMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctlMain = (CollapsingToolbarLayout) findViewById(R.id.ctl_main);
        ctlMain.setTitle("itemTitle");
//        ctlMain.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
//        ViewCompat.setTransitionName(ctlMain,"EXTRA_NAME");
    }
}
//1901428673
//1901428723
//1901428723re
