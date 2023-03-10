package com.myapp.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link First_page2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class First_page2 extends Fragment {
SharedPreferences preferences;
SharedPreferences.Editor editor;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public First_page2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     *
     *
     *
     *
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment First_page2.
     */
    // TODO: Rename and change types and number of parameters
    public static First_page2 newInstance(String param1, String param2) {
        First_page2 fragment = new First_page2();
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
        View view = inflater.inflate(R.layout.fragment_first_page2, container, false);
        ImageView image = view.findViewById(R.id.image1);
        TextView text1 = view.findViewById(R.id.text2);
        Button next =  view.findViewById(R.id.button1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                preferences = getActivity().getSharedPreferences("MyApp", Context.MODE_PRIVATE);
                if (!preferences.getString("number","").equalsIgnoreCase("")){
                    editor = preferences.edit();
                    preferences.getString("number","");
                    Intent intent = new Intent(getActivity(),HotelsPage10.class);
                    startActivity(intent);

                }
                else {
                    transaction.replace(R.id.framepage2,new Second_page2());
                    transaction.commit();

                }

            }
        });



        return view;
    }
}