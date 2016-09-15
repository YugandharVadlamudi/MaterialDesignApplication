package com.example.tabapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.tabapp.fragment.TabOneFragment;
import com.example.tabapp.fragment.TabTwoFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tlMain;
    private ViewPager vpMain;

    private String[] tabNames;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        tlMain = (TabLayout) findViewById(R.id.tl_main);
        vpMain = (ViewPager) findViewById(R.id.vp_main);
        getTabNames();
//        addTabs();
        setViewPageAdapter();
    }

    private void setViewPageAdapter() {
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        vpMain.setAdapter(tabAdapter);
        Log.d(TAG, "setViewPageAdapter: childCount->" + tabAdapter.getCount());
        tlMain.setupWithViewPager(vpMain);
    }

    private void addTabs() {
        TabLayout.Tab tab_one= tlMain.newTab();
        TabLayout.Tab tab_two= tlMain.newTab();
        tab_one.setText(tabNames[0]);
        tab_two.setText(tabNames[1]);
        tlMain.addTab(tab_one);
        tlMain.addTab(tab_two);
    }

    public String[] getTabNames() {
        tabNames=getResources().getStringArray(R.array.Tab_names);
        Log.d(TAG, "getTabNames: tabNames[1]"+tabNames[1]);
        return tabNames;
    }

    /**
     * FragmentPagerAdapter used for static fragments
     * mostly usefull for swiping tabs
     */
    class TabAdapter extends FragmentPagerAdapter {
        public TabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TabOneFragment();
                case 1:
                    return new TabTwoFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Log.v("tabNames",""+tabNames[position]);
            return tabNames[position];
        }
    }
}
