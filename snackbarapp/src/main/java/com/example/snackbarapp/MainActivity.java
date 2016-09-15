package com.example.snackbarapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton btMainSnackbar;
    private Resources resources;
    private String TAG = MainActivity.class.getSimpleName();
    private CoordinatorLayout clMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        resources = getResources();
        btMainSnackbar = (FloatingActionButton) findViewById(R.id.fab_mainactivity);
        clMainActivity = (CoordinatorLayout) findViewById(R.id.cl_mainactivity);
        setListeners();
    }

    private void setListeners() {
        btMainSnackbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_mainactivity:
                snackBarShow(v);
                break;
        }
    }

    private void snackBarShow(View v) {
        final Snackbar snackbar=Snackbar.make(v, getResources().getString(R.string.main_snackbartext)
                , Snackbar.LENGTH_SHORT);
        snackbar.show();
        snackbar.setAction(resources.getString(R.string.main_snackbaractiontext), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "another snack", Snackbar.LENGTH_SHORT).show();
            }
        });
        Log.e(TAG, "snackBarShow: height"+snackbar.getView().getHeight() );
    }
}
