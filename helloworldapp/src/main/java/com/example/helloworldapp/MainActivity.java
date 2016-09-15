package com.example.helloworldapp;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//Activity class takes care of creating a window for you in
// which you can place your UI with
// setContentView(View)
        setContentView(R.layout.activity_main);
    }
}
