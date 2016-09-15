package com.example.floatactionbuttonapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabPlus;
    private FloatingActionButton fabMainOne;
    private FloatingActionButton fabMainTwo;
    Animation animation;
    String name = "plus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
//        setUpEnterAnimation();
    }

    private void setUpEnterAnimation() {
        Transition transition = null;
/*
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            transition = TransitionInflater.from(this)
                    .inflateTransition(R.transition.change_bound_with_arc);
            transition.setDuration(300);
            getWindow().setSharedElementEnterTransition(transition);
            transition.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {

                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        }
*/
    }

    private void setUpViews() {
        fabPlus = (FloatingActionButton) findViewById(R.id.fab_main_plus);
        fabMainOne = (FloatingActionButton) findViewById(R.id.fab_main_one);
        fabMainTwo = (FloatingActionButton) findViewById(R.id.fab_main_two);
        final Drawable drawable = getResources().getDrawable(R.drawable.ic_add_black_24dp);
        fabPlus.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open));
        fabPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
                if (name.equals("plus")) {
                    LinearInterpolator overshootInterpolator=new LinearInterpolator();
//                    OvershootInterpolator overshootInterpolator=new OvershootInterpolator();
                    ViewCompat.animate(fabPlus).rotation(50f).withLayer().setDuration(200)
                            .setInterpolator(overshootInterpolator).start();
                    animation = setAnimation(R.anim.fab_open);
                    fabMainOne.setVisibility(View.VISIBLE);
                    fabMainOne.setAnimation(animation);
                    fabMainTwo.setVisibility(View.VISIBLE);
                    fabMainTwo.startAnimation(animation);
                    name = "cross";
                } else if (name.equals("cross")) {
                    LinearInterpolator overshootInterpolator=new LinearInterpolator();
                    ViewCompat.animate(fabPlus).rotation(0f).withLayer().setDuration(200)
                            .setInterpolator(overshootInterpolator).start();
                    animation = setAnimation(R.anim.fab_close);
                    fabMainOne.setVisibility(View.INVISIBLE);
                    fabMainTwo.setVisibility(View.INVISIBLE);
                    fabMainOne.startAnimation(animation);
                    fabMainTwo.startAnimation(animation);
                    name = "plus";
                }
            }
        });
    }

    private Animation setAnimation(int animation) {
        return AnimationUtils.loadAnimation(getApplicationContext(), animation);
    }
}
