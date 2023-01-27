package com.example.myapplication;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;
//interface implement on this class and method override and OnPageChangedListner open new interface class
//becz  this interface assess all activity
public class Page21 extends AppCompatActivity implements OnPageChangedListner {
    ViewPager pager ;
    TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(R.layout.activity_page21);
        pager = findViewById(R.id.pagerpage21);
        tab = findViewById(R.id.tabpage21);
        tab.setupWithViewPager(pager);

        PagerAdpter adpter = new PagerAdpter(getSupportFragmentManager(),this);
        pager.setAdapter(adpter);

        tab.getTabAt(0).setIcon(R.drawable.location);
        tab.getTabAt(0).setText("Location");
        tab.getTabAt(1).setIcon(R.drawable.payments);
        tab.getTabAt(1).setText("Payment");
        tab.getTabAt(2).setIcon(R.drawable.complete);
        tab.getTabAt(2).setText("Complete");




    }


    @Override                                       //override method
    public void OnPageChanged(int position) {
        Log.e("TAG", "OnPageChanged: " );
        pager.setCurrentItem(position);
    }


    //backpressed fargement
    @Override
    public void onBackPressed() {
        for (Fragment fragment : getSupportFragmentManager().getFragments()){
            if (fragment instanceof payments_page21||fragment instanceof complete_page21){
                if (pager.getCurrentItem()==1){
                    pager.setCurrentItem(0);
                }
                if (pager.getCurrentItem()==2){
                    pager.setCurrentItem(1);
                }

                return;
            }
        }

    }

    class PagerAdpter extends FragmentPagerAdapter{
        OnPageChangedListner listner;                      //declartion

        public PagerAdpter(@NonNull FragmentManager fm,OnPageChangedListner listner) { //add parameter in constructor
            super(fm);
            this.listner = listner;                         //assign listner
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position==0){
                return new location_page21(listner);     //pass listner
            }
            if (position==1){
                return new payments_page21(listner);
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