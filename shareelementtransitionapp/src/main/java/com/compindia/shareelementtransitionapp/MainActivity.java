
package com.compindia.shareelementtransitionapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivShareElementOne;
    private ImageView ivShareElementTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        ivShareElementOne = (ImageView) findViewById(R.id.iv_one);
        ivShareElementTwo = (ImageView) findViewById(R.id.iv_two);
        ivShareElementOne.setOnClickListener(this);
        ivShareElementTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_one:
                startAnotherActivity(ivShareElementOne);
                break;
            case R.id.iv_two:
                startAnotherActivity(ivShareElementTwo);
                break;
        }
    }

    private void startAnotherActivity(ImageView ivShareElementTwo) {

        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, (View) ivShareElementTwo, "userPick");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, options.toBundle());
        }

    }
}
