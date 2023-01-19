package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link location21_page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class location21_page1 extends Fragment {
    SharedPreferences preferences;
    private JSONArray adddata;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public location21_page1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment location21_page1.
     */
    // TODO: Rename and change types and number of parameters
    public static location21_page1 newInstance(String param1, String param2) {
        location21_page1 fragment = new location21_page1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getContext().getSharedPreferences("myapp", Context.MODE_PRIVATE);

        if (getArguments() != null) {
            try {
                adddata = new JSONArray(getArguments().getString("ADDRESS"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_location21_page1, container, false);

        LinearLayout add_address = view.findViewById(R.id.addaddress);
        LinearLayout info = view.findViewById(R.id.lineargone);
        EditText email = view.findViewById(R.id.email);
        EditText name = view.findViewById(R.id.name);
        EditText address = view.findViewById(R.id.address);
        EditText landmark = view.findViewById(R.id.landmark);
        EditText state = view.findViewById(R.id.state);
        EditText city = view.findViewById(R.id.city);

        RecyclerView listadd = view.findViewById(R.id.addresslist);
        List<addresslist>list = new ArrayList<>();
        try {
            adddata = new JSONArray(preferences.getString("ADDRESS","[]"));
            for (int i = 0; i<adddata.length(); i++){
                JSONObject object = adddata.getJSONObject(i);
                addresslist addlist = new addresslist(object.getString("Name"), object.getString("Landmark"),object.getString("Address"), object.getString("EmailId") );
                list.add(addlist);

            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        AddressAdpter adpter = new AddressAdpter(list);
        listadd.setLayoutManager(new LinearLayoutManager(getContext()));
        listadd.setAdapter(adpter);



        Button savebutton = view.findViewById(R.id.savebutton);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //set visiblity
                listadd.setVisibility(View.VISIBLE);
                info.setVisibility(View.GONE);
                add_address.setVisibility(View.VISIBLE);


                //set data using JSON
                JSONArray array = null;
                try {
                    array = new JSONArray(preferences.getString("ADDRESS","[]"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("EmailId",email.getText().toString());
                    jsonObject.put("Name",name.getText().toString());
                    jsonObject.put("Address",address.getText().toString());
                    jsonObject.put("Landmark",landmark.getText().toString());
                    jsonObject.put("State",state.getText().toString());
                    jsonObject.put("City",city.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                array.put(jsonObject);

                Log.e("TAG",array.toString());

                //save data in sharedpreferences
                SharedPreferences.Editor editor= preferences.edit();
                editor.putString("ADDRESS",array.toString());
                editor.commit();
                email.setText(preferences.getString("EmailId",null));
                name.setText(preferences.getString("Name",null));
                address.setText(preferences.getString("Address",null));
                landmark.setText(preferences.getString("Landmark",null));
                state.setText(preferences.getString("State",null));
                city.setText(preferences.getString("City",null));



                adpter.notifyDataSetChanged();
            }
        });









        add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info.setVisibility(View.VISIBLE);
                add_address.setVisibility(View.GONE);


            }
        });






        return view;


    }

    class AddressAdpter extends RecyclerView.Adapter<AddressAdpter.CustomViewHolder>{
        List<addresslist> list;

        public AddressAdpter(List<addresslist> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public AddressAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.addresslist_page21,parent,false);
            CustomViewHolder holder = new CustomViewHolder(ABC);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull AddressAdpter.CustomViewHolder holder, int position) {

            holder.name.setText(list.get(position).getName());
            holder.location.setText(list.get(position).getLocation());
            holder.address.setText(list.get(position).getAddress());
            holder.number.setText(list.get(position).getNumber());

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            TextView name,location,address,number;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.addressname);
                location = itemView.findViewById(R.id.area);
                address = itemView.findViewById(R.id.addressperson);
                number = itemView.findViewById(R.id.mobilenumber);

            }
        }
    }
}