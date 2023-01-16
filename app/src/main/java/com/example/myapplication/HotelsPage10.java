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

import com.example.myapplication.model.CartItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HotelsPage10 extends AppCompatActivity {
    ViewPager pager;
    TabLayout tab;
    public HotelsPage10.ItemCartAddListner listner ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_page10);
        pager = findViewById(R.id.hpager);
        tab = findViewById(R.id.htab10);
        //listner.AddItem();

        PagerAdpter adpter = new PagerAdpter(getSupportFragmentManager());
        pager.setAdapter(adpter);
        tab.setupWithViewPager(pager);

        tab.getTabAt(0).setIcon(R.drawable.home);
        tab.getTabAt(1).setIcon(R.drawable.shopping_cart);
        tab.getTabAt(2).setIcon(R.drawable.dinning);
        tab.getTabAt(3).setIcon(R.drawable.person);
        pager.setOffscreenPageLimit(4);


    }


    @Override
    public void onBackPressed() {
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            if (fragment instanceof Farminfo_page55) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.remove(fragment);
                transaction.commit();
                return;
            }

            for (Fragment fragment1 : getSupportFragmentManager().getFragments()) {
                if (fragment1 instanceof FarmProduct_page53) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.remove(fragment1);
                    transaction.commit();
                    return;
                }
            }

            for (Fragment fragement2 : getSupportFragmentManager().getFragments()) {
                if (fragement2 instanceof FragementNew_page13) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    for (Fragment fragement4 : getSupportFragmentManager().getFragments()) {
                        if (fragement4 instanceof FragementNew_page13 || fragement4 instanceof HomenewPage13 || fragement4 instanceof PhotonewPage13 || fragement4 instanceof ReviewnewPage13 || fragement4 instanceof AboutnewPage13) {
                            transaction.remove(fragement4);
                        }

                    }
                    transaction.commit();
                    return;
                }
            }

            for (Fragment fragement2 : getSupportFragmentManager().getFragments()) {
                if (fragement2 instanceof HotelList_page53) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.remove(fragement2);
                    transaction.commit();
                    return;
                }
            }


            JSONObject object = new JSONObject();
            try {
                JSONArray facility = object.getJSONArray("Facilities");
                String strfacility = "";
                for (int i = 0; i < facility.length(); i++) {
                    strfacility = strfacility + " " + facility.getString(i);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }


    class PagerAdpter extends FragmentPagerAdapter {

        public PagerAdpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new hotelHome_page10();
            } else if (position == 1) {
                return new hotel_shoppingcart_page10();
            } else if (position == 2) {
                return new hotelFineDinning_page10();
            } else if (position == 3) {
                return new hotelMyAccount_page10();
            }


            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

    interface ItemCartAddListner {
        void AddItem(CartItem item);
        void  Update(String name , String quntity);


    }


}
