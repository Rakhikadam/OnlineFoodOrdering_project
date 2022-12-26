package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Page21 extends AppCompatActivity {
    ViewPager pager ;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_page21);
        pager = findViewById(R.id.pagerpage21);
        tab = findViewById(R.id.tabpage21);
        tab.setupWithViewPager(pager);

        PagerAdpter adpter = new PagerAdpter(getSupportFragmentManager());
        pager.setAdapter(adpter);
        tab.getTabAt(0).setIcon(R.drawable.location);
        tab.getTabAt(0).setText("Location");
        tab.getTabAt(1).setIcon(R.drawable.payments);
        tab.getTabAt(1).setText("Payment");
        tab.getTabAt(2).setIcon(R.drawable.complete);
        tab.getTabAt(2).setText("Complete");




    }
    class PagerAdpter extends FragmentPagerAdapter{

        public PagerAdpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new location_page21();
            }
            if (position==1){
                return new payments_page21();
            }
            if (position==2){
                return new complete_page21();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}