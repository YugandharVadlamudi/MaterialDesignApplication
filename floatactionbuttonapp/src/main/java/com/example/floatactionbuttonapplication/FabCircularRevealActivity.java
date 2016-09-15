package com.example.floatactionbuttonapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;

public class FabCircularRevealActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabCircularReveal;
    private RelativeLayout baseLayout;
    private Scene sense1;
    private Scene sense2;
    private AutoTransition transition;
    private boolean start = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_circular_reveal);
        setUpViews();
    }

    private void setUpViews() {

        baseLayout = (RelativeLayout) findViewById(R.id.rl_main);
        ViewGroup startViewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.activity_fab_circular_reveal, baseLayout,false);
        ViewGroup endViewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.secounsense, baseLayout,false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            sense1 = new Scene(baseLayout, startViewGroup);
            sense2 = new Scene(baseLayout, endViewGroup);
            transition = new AutoTransition();
            transition.setDuration(5000);
            transition.setInterpolator(new AccelerateDecelerateInterpolator());

        }


        /*
        fabCircularReveal = (FloatingActionButton) findViewById(R.id.fab_fabcircularreveal);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fabCircularReveal.setTransitionName("reveal");
            fabCircularReveal.setOnClickListener(this);
        }

    */}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.fab_fabcircularreveal:
               /* Toast.makeText(FabCircularRevealActivity.this, "circular reveal", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                ActivityOptionsCompat.makeSceneTransitionAnimation(FabCircularRevealActivity.this
                        ,fabCircularReveal,"fab icon");
                ActivityCompat.startActivity(FabCircularRevealActivity.this, intent, null);
//              startActivity(intent);
*/
//                break;
        }
    }

    public void changeScene(View view) {
        if (start) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.go(sense2, transition);
                start = false;
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.go(sense2, transition);
                start=true;
            }
        }
    }
}
