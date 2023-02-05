package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotoPage13_SQLite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoPage13_SQLite extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PhotoPage13_SQLite() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhotoPage13_SQLite.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotoPage13_SQLite newInstance(String param1, String param2) {
        PhotoPage13_SQLite fragment = new PhotoPage13_SQLite();
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
        DBHelper helper = new DBHelper(getContext());
        View view= inflater.inflate(R.layout.fragment_photo_page13__s_q_lite, container, false);
        EditText photo = view.findViewById(R.id.photosql);
        Button submit = view.findViewById(R.id.psubmit);
        Spinner spinner = view.findViewById(R.id.photospinner1);
        Spinner spinner1 = view.findViewById(R.id.photospinner2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinner.getSelectedItem().toString().equalsIgnoreCase("Restaurant")){
                    List<Hotelinfo> list = helper.gethotelsinfo();

                    List<String>spinerlist = new ArrayList<>();
                    for (int j=0;j<list.size();j++){
                        spinerlist.add(list.get(j).getId()+"-"+list.get(j).getName());

                    }
                    spinner1.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,spinerlist));
                }
                else if (spinner.getSelectedItem().toString().equalsIgnoreCase("Homemade")){
                    List<Homemadeinfo>list = helper.getHomemadeinfo();
                    List<String>spinerlist = new ArrayList<>();

                    for (int k=0; k<list.size();k++){
                        spinerlist.add(list.get(k).getId()+"-"+list.get(k).getName());

                    }

                    spinner1.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,spinerlist));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Image = photo.getText().toString();
                helper.addphotoinfo(Image,spinner1.getSelectedItem().toString().split("-")[0],spinner.getSelectedItem().toString());
            }
        });

        return view;
    }
}