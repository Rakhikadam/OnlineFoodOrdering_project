package com.myapp.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link location_page21#newInstance} factory method to
 * create an instance of this fragment.
 */
public class location_page21 extends Fragment {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    OnPageChangedListner listner;   //


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public location_page21( OnPageChangedListner listner) {
        this.listner= listner;  //assign listner
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment location_page21.
     */
    // TODO: Rename and change types and number of parameters
   /* public static location_page21 newInstance(String param1, String param2) {
        location_page21 fragment = new location_page21();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  preferences = getContext().getSharedPreferences("MYAPP", Context.MODE_PRIVATE);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_page21, container, false);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.location,new location21_page1(listner));
        transaction.commit();


      /*  Button button = view.findViewById(R.id.continuebutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.location,new location21_page2());
                transaction.commit();
            }
        });
*/

        //getting total amount price using sharedprefernce
      /* TextView price = view.findViewById(R.id.addressprice);
       editor = preferences.edit();
       price.setText(preferences.getString("TOTAL",null));
*/




        return view;
    }

}
