package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
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
 * Use the {@link MenuListSQL_page13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuListSQL_page13 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuListSQL_page13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuListSQL_page13.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuListSQL_page13 newInstance(String param1, String param2) {
        MenuListSQL_page13 fragment = new MenuListSQL_page13();
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
        DBHelper helper = new DBHelper(getContext());
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_menu_list_s_q_l_page13, container, false);
        EditText menuname = view.findViewById(R.id.mtext1);
        EditText menuprice = view.findViewById(R.id.mtext2);
        EditText menuoffer = view.findViewById(R.id.mtext3);
        EditText menucategory = view.findViewById(R.id.mtext4);
        EditText menuimage = view.findViewById(R.id.mtext5);
        Button submit = view.findViewById(R.id.msubmit);
        Spinner spinner2 = view.findViewById(R.id.spinner2);
        Spinner spinner = view.findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                spinner.getSelectedItem().toString();
                Log.e("TAG",spinner.getSelectedItem().toString());
                helper.gethotelsinfo().size();
                Log.e("TAG", String.valueOf(helper.gethotelsinfo().size()));
                helper.getHomemadeinfo().size();
                Log.e("TAG", String.valueOf(helper.getHomemadeinfo().size()));


                if (spinner.getSelectedItem().toString().equalsIgnoreCase("Restaurant")){
                    List<Hotelinfo> list = helper.gethotelsinfo();

                    List<String> spinerlist = new ArrayList<>();
                    for (int j=0; j<list.size();j++){
                         spinerlist.add(list.get(j).getId()+"-"+list.get(j).getName());
                        Log.e("TAG", "onItemSelected: "+helper.gethotelsinfo().get(j).getName() );
                    }
                    spinner2.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,spinerlist));


                }
                else if (spinner.getSelectedItem().toString().equalsIgnoreCase("Homemade")){
                    List<String> spinerlist1 = new ArrayList<>();

                    for (int k=0; k<helper.getHomemadeinfo().size();k++){
                        spinerlist1.add(helper.getHomemadeinfo().get(k).getId()+"-"+helper.getHomemadeinfo().get(k).getName());
                        Log.e("TAG", "onItemSelected: "+helper.getHomemadeinfo().get(k).getName() );
                    }
                    spinner2.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,spinerlist1));

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = menuname.getText().toString();
                String Price = menuprice.getText().toString();
                String Serve = menuoffer.getText().toString();
                String Category = menucategory.getText().toString();
                String Image = menuimage.getText().toString();
                helper.addmenuinfo(name,Image,Price,Category,Serve,spinner2.getSelectedItem().toString().split("-")[0]);
            }
        });


        return view;
    }
}