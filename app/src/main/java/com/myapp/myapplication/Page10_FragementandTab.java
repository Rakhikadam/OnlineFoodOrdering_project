package com.myapp.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.model.CartItem;
import com.google.android.material.tabs.TabLayout;

public class Page10_FragementandTab extends AppCompatActivity {
    ViewPager pager;
    TabLayout tab;
    public ItemAddListner Listner;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page10_fragementand_tab);
        pager = findViewById(R.id.fpager);
        tab = findViewById(R.id.tab10);

        PagerAdpter adpter = new PagerAdpter(getSupportFragmentManager());

        pager.setAdapter(adpter);
        tab.setupWithViewPager(pager);

        tab.getTabAt(0).setIcon(R.drawable.home);
        tab.getTabAt(1).setIcon(R.drawable.shopping_cart);
        tab.getTabAt(2).setIcon(R.drawable.dinning);
        tab.getTabAt(3).setIcon(R.drawable.person);
        pager.setOffscreenPageLimit(4);
    }

    //open next and previous fragement page
    @Override
    public void onBackPressed() {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {

            if (fragment instanceof FragementNew_page13) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                for (Fragment fragment1 : getSupportFragmentManager().getFragments()) {
                    if (fragment1 instanceof HomenewPage13 || fragment1 instanceof PhotonewPage13 || fragment1 instanceof ReviewnewPage13 || fragment1 instanceof AboutnewPage13) {
                        transaction.remove(fragment1);
                    }
                }
                transaction.commit();
                return;


                //FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //  transaction.replace(R.id.frame,homefragement_page10);
                //  transaction.addToBackStack(null);
                //  transaction.commit();

            }

        }

    }

    public class PagerAdpter extends FragmentPagerAdapter {

        public PagerAdpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new homefragement_page10();
            } else if (position == 1) {
                return new shoopingcartFragement_page10();
            } else if (position == 2) {
                return new FineDinningFragement_page10();
            } else if (position == 3) {
                return new AccountFragement_page10();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }


    }

}


interface ItemAddListner {  //interface has all method is abstract and that is  public
    void Itemadd(CartItem item);
    Void Update(String name, String quantity);
}