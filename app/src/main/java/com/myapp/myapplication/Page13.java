package com.myapp.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Page13 extends AppCompatActivity {
    ViewPager pager;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page13);
        pager = findViewById(R.id.pager13);
        tab = findViewById(R.id.tabpage13);
        tab.setupWithViewPager(pager);
        PagerAdpter adpter = new PagerAdpter(getSupportFragmentManager());
        pager.setAdapter(adpter);
        tab.getTabAt(0).setText("Menu");
        tab.getTabAt(1).setText("Photo");
        tab.getTabAt(2).setText("Review");
        tab.getTabAt(3).setText("About");

    }
    class PagerAdpter extends FragmentPagerAdapter{

        public PagerAdpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new Homepage13();
            }
            else if (position==1){
                return new photopage13();
            }
            if (position==2){
                return new Reviewpage13();
            }
            if (position==3){
                return new Aboutpage13();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}