package com.myapp.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homemade_SQLite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homemade_SQLite extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Homemade_SQLite() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homemade_SQLite.
     */
    // TODO: Rename and change types and number of parameters
    public static Homemade_SQLite newInstance(String param1, String param2) {
        Homemade_SQLite fragment = new Homemade_SQLite();
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
        View view = inflater.inflate(R.layout.fragment_homemade__s_q_lite, container, false);
        EditText hotelname = view.findViewById(R.id.htext1);
        EditText image = view.findViewById(R.id.htext2);
        EditText offers = view.findViewById(R.id.htext3);
        EditText address = view.findViewById(R.id.htext4);
        EditText about = view.findViewById(R.id.htext5);
        EditText number = view.findViewById(R.id.htext6);
        EditText averagecost = view.findViewById(R.id.htext7);
        Button submit = view.findViewById(R.id.hsubmit);

        DBHelper helper = new DBHelper(getContext());
     submit.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String name = hotelname.getText().toString();    //get
             String Address =  address.getText().toString();
             String Offer=  offers.getText().toString();
             String About =  about.getText().toString();
             String Image =  image.getText().toString();
             String Number =  number.getText().toString();
             String Averagecost =  averagecost.getText().toString();

             helper.addhomemadeinfo(name,Address,Image,Offer,About,Number,Averagecost);

         }
     });

        return view;
    }
}