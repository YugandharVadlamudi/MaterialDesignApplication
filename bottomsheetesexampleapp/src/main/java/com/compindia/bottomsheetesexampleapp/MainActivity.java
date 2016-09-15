package com.compindia.bottomsheetesexampleapp;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Button btMain;
    private FrameLayout flMain;
    private BottomSheetDialog bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        btMain = (Button) findViewById(R.id.bt_main);
        btMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View layoutDialog = getLayoutInflater().inflate(R.layout.layout_bootomsheet, null);

                /**
                * ModelBottom Sheet in android example
                * */
                bottomSheetBehavior = new BottomSheetDialog(MainActivity.this);
                bottomSheetBehavior.setContentView(layoutDialog);
                bottomSheetBehavior.show();
            }
        });
    }
}
