package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hotelFineDinning_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hotelFineDinning_page10 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public hotelFineDinning_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hotelFineDinning_page10.
     */
    // TODO: Rename and change types and number of parameters
    public static hotelFineDinning_page10 newInstance(String param1, String param2) {
        hotelFineDinning_page10 fragment = new hotelFineDinning_page10();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view=    inflater.inflate(R.layout.fragment_hotel_fine_dinning_page10, container, false);
     Button resturant = view.findViewById(R.id.text1);
     Button homemade = view.findViewById(R.id.text2);
     Button farm = view.findViewById(R.id.text3);
     Button menulist = view.findViewById(R.id.text4);
     Button MenuPhotes = view.findViewById(R.id.text5);
     Button About = view.findViewById(R.id.text6);
     Button Review = view.findViewById(R.id.text7);



     resturant.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
             transaction.replace(R.id.sqlfame,new Resturant_SQLite());
             transaction.commit();

         }
     });

     homemade.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
             transaction.replace(R.id.sqlfame,new Homemade_SQLite());
             transaction.commit();
         }
     });

      farm.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.sqlfame,new Farm_SQLite());
              transaction.commit();
          }
      });

      menulist.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
              transaction.replace(R.id.sqlfame,new MenuListSQL_page13());
              transaction.commit();
          }
      });

     /*  EditText name = view.findViewById(R.id.text1);
        EditText location = view.findViewById(R.id.text2);
        EditText offers = view.findViewById(R.id.text3);
        EditText image = view.findViewById(R.id.text4);
        EditText about = view.findViewById(R.id.text5);
        EditText number = view.findViewById(R.id.text6);
        EditText averagecost = view.findViewById(R.id.text7);
        Button submit = view.findViewById(R.id.submitb);

     DBHelper helper = new DBHelper(getContext());


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strname = name.getText().toString();
              String Location =  location.getText().toString();
              String Offer=  offers.getText().toString();
              String About =  about.getText().toString();
              String Image =  image.getText().toString();
              String Number =  number.getText().toString();
              String Averagecost =  averagecost.getText().toString();

                helper.addhotelinfo(strname,Location,Image,Offer,About,Number,Averagecost);

            }
        });


      */  return view;

    }

}