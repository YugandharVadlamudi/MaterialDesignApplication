package com.compindia.shareelementtransitionapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ListViewTextShareElementActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView tvOne;
    private TextView tvTwo;
    private TextView tvThree;
    private TextView tvFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_text_share_element);
        setUpTextViews();
    }

    private void setUpTextViews() {
       /* getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
// set an enter transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Explode());
            getWindow().setExitTransition(new Explode());
        }
*/
        tvOne = (TextView) findViewById(R.id.tv_hello_1);
        tvTwo = (TextView) findViewById(R.id.tv_hello_2);
        tvThree = (TextView) findViewById(R.id.tv_hello_3);
        tvFour = (TextView) findViewById(R.id.tv_hello_4);
        tvOne.setOnClickListener(this);
        tvTwo.setOnClickListener(this);
        tvThree.setOnClickListener(this);
        tvFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_hello_1:
                startAnotherActivity(tvOne);
                break;
            case R.id.tv_hello_2:
                startAnotherActivity(tvTwo);
                break;
            case R.id.tv_hello_3:
                startAnotherActivity(tvThree);
                break;
            case R.id.tv_hello_4:
                startAnotherActivity(tvFour);
                break;
        }
    }
    private void startAnotherActivity(TextView ivShareElementTwo) {
        Intent intent = new Intent(getApplicationContext(), ListViewShareElementActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(ListViewTextShareElementActivity.this
                , (View) ivShareElementTwo, "dummy");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent, options.toBundle());
        }

    }
}
