package com.compindia.co_ordinatelayoutapp.utils;

import android.content.Context;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Kiran on 23-06-2016.
 */
public class CustomScrollAwareBehavior extends FloatingActionButton.Behavior {
    private Handler handler = new Handler();
    private FloatingActionButton floatingActionButton;

    public CustomScrollAwareBehavior(Context context, AttributeSet attributeSet) {
        super();
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout
                                        , FloatingActionButton child
                                        , View directTargetChild
                                        , View target
                                        , int nestedScrollAxes) {

        floatingActionButton = child;
        return nestedScrollAxes== ViewCompat.SCROLL_AXIS_VERTICAL
                                    || super.onStartNestedScroll(coordinatorLayout, child
                                                                    , directTargetChild, target
                                                                    , nestedScrollAxes);
    }

/*
    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child
                                    , View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
        if()
    }
*/
    Runnable showRunnable = new Runnable() {
        @Override
        public void run() {
            floatingActionButton.show();
        }
    };

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child
                                , View target, int dxConsumed, int dyConsumed, int dxUnconsumed
                                , int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed
                                , dyUnconsumed);

        if (dyConsumed>0&&child.getVisibility()==View.VISIBLE) {
            handler.removeCallbacks(showRunnable);
            handler.postDelayed(showRunnable, 2000);
            child.hide();


        }

    }
}
