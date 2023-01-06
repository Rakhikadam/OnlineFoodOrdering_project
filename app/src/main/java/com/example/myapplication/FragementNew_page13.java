package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class FragementNew_page13 extends Fragment {
    ViewPager pager;
    TabLayout tab;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;

    public FragementNew_page13() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt("id");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragement_new_page13, container, false);
        pager = view.findViewById(R.id.ll_pager13);
        tab = view.findViewById(R.id.ll_tabpage13);
        PagernewAdpter adpter = new PagernewAdpter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adpter);
        tab.setupWithViewPager(pager);

        tab.getTabAt(0).setText("Menu");
//        tab.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.fav));

        tab.getTabAt(1).setText("Photo");
        tab.getTabAt(2).setText("Review");
        tab.getTabAt(3).setText("About");

        List<restaurant> image2 = new ArrayList<>();
        restaurant list5 = new restaurant("Alpha hotel", "30% OFF ", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list5);
        restaurant list6 = new restaurant("Star hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list6);
        restaurant list7 = new restaurant("Blue hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list7);
        restaurant list8 = new restaurant("Alpha hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list8);

        ImageView image = view.findViewById(R.id.imagep13);
        Glide.with(getContext()).load(image2.get(mParam1).getImage()).into(image);

        TextView text = view.findViewById(R.id.textp13);
        text.setText(image2.get(mParam1).getName());

        return view;
    }


    private void doNothing() {

    }

    public static class PagernewAdpter extends  FragmentPagerAdapter{

        public PagernewAdpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if (position == 0){
                return new HomenewPage13();
            }
            else if (position == 1){
                return new PhotonewPage13();
            }
            else if (position == 2){
                return new ReviewnewPage13();
            }
            else if (position == 3){
                return new AboutnewPage13();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Menu";
//        tab.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.fav));

               case  1:return "Photo";
               case  2:return "Review";
               case  3:return "About";
                default:
                    return "";
            }
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }
    }



}