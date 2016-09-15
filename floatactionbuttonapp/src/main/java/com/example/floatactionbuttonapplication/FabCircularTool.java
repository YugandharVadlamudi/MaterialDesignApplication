package com.example.floatactionbuttonapplication;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FabCircularTool extends AppCompatActivity {

    private FloatingActionButton fabCircularTool;
    private LinearLayout llCircularTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_circular_tool);
        setUpViews();
    }

    private void setUpViews() {
        fabCircularTool = (FloatingActionButton) findViewById(R.id.fab_fabcirculartool);
        llCircularTool = (LinearLayout) findViewById(R.id.ll_fabcirculartool);
        fabCircularTool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FabCircularTool.this, "toast workds", Toast.LENGTH_SHORT).show();
                int centerX = (llCircularTool.getLeft() + llCircularTool.getRight())/2;
                int centerY = (llCircularTool.getTop() + llCircularTool.getBottom())/2;
                int endRadious = Math.max(llCircularTool.getWidth(), llCircularTool.getHeight());
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                  final  Animator animator = ViewAnimationUtils.createCircularReveal(llCircularTool
                            , centerX, centerY, 0, endRadious);
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
                    animation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            fabCircularTool.setVisibility(View.INVISIBLE);
                            llCircularTool.setVisibility(View.VISIBLE);
                            animator.start();
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    fabCircularTool.startAnimation(animation);
                }
            }
        });

    }
}
