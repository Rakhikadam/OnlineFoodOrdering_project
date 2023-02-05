package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link location21_page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class location21_page1 extends Fragment {
    OnPageChangedListner listner;
    AddressAdpter adpter;
    SharedPreferences preferences;
    private JSONArray adddata;
    JSONArray array;
    SharedPreferences.Editor editor;
    DBHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public location21_page1(OnPageChangedListner listner) {
        this.listner = listner;

    }
    // Required empty public constructor


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment location21_page1.
     */
    // TODO: Rename and change types and number of parameters
//    public static location21_page1 newInstance(String param1, String param2) {
//        location21_page1 fragment = new location21_page1();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //preferences = getContext().getSharedPreferences("myapp", Context.MODE_PRIVATE);//address sharedprefernce
        preferences = getContext().getSharedPreferences("MYAPP", Context.MODE_PRIVATE);


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
        View view = inflater.inflate(R.layout.fragment_location21_page1, container, false);

        LinearLayout add_address = view.findViewById(R.id.addaddress);
        LinearLayout info = view.findViewById(R.id.lineargone);
        EditText email = view.findViewById(R.id.email);
        EditText name = view.findViewById(R.id.name);
        EditText address = view.findViewById(R.id.address);
        EditText landmark = view.findViewById(R.id.landmark);
        EditText state = view.findViewById(R.id.state);
        EditText city = view.findViewById(R.id.city);
        Button checkout = view.findViewById(R.id.checkout);


        //set data on the list
        RecyclerView listadd = view.findViewById(R.id.addresslist);
        //JSON method
      /*  List<addresslist> list = new ArrayList<>();
        try {
            adddata = new JSONArray(preferences.getString("ADDRESS", "[]"));
            for (int i = 0; i < adddata.length(); i++) {
                JSONObject object = adddata.getJSONObject(i);
                addresslist addlist = new addresslist(object.getString("Name"), object.getString("Landmark"), object.getString("Address"), object.getString("EmailId"));
                list.add(addlist);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adpter = new AddressAdpter(list);
        listadd.setLayoutManager(new LinearLayoutManager(getContext()));
        listadd.setAdapter(adpter);
*/
        helper = new DBHelper(getContext());
       List<address>list = helper.getaddressinfo();
        listadd.setLayoutManager(new LinearLayoutManager(getContext()));
         adpter = new AddressAdpter(list);
       listadd.setAdapter(adpter);

        Button savebutton = view.findViewById(R.id.savebutton);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //set visiblity
                listadd.setVisibility(View.VISIBLE);
                info.setVisibility(View.GONE);
                add_address.setVisibility(View.VISIBLE);


               /* //set data using JSON
                array = null;
                try {
                    array = new JSONArray(preferences.getString("ADDRESS", "[]"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("EmailId", email.getText().toString());
                    jsonObject.put("Name", name.getText().toString());
                    jsonObject.put("Address", address.getText().toString());
                    jsonObject.put("Landmark", landmark.getText().toString());
                    jsonObject.put("State", state.getText().toString());
                    jsonObject.put("City", city.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                array.put(jsonObject);

                Log.e("TAG", array.toString());

               */

                //set data on the table using SQLite method
                String Email = email.getText().toString();
                String Name = name.getText().toString();
                String Address = address.getText().toString();
                String Landmark = landmark.getText().toString();
                String State = state.getText().toString();
                String City = city.getText().toString();
                helper.addaddress(Name,Email,Address,Landmark,State,City);

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


        //getting total amount price using sharedprefernce
        TextView price = view.findViewById(R.id.addressprice);
        editor = preferences.edit();
        price.setText(preferences.getString("TOTAL", null));


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adpter.checkPosition == -1) {
                    Toast.makeText(getActivity(), "Select address button", Toast.LENGTH_SHORT).show();

                    adpter.notifyDataSetChanged();
                } else {
//                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.page1, new payment21_page1());
//                    transaction.commit();

                    listner.OnPageChanged(1);  //pass listner and set position


                }


            }
        });


        return view;

    }

    class AddressAdpter extends RecyclerView.Adapter<AddressAdpter.CustomViewHolder> {
       // List<addresslist> list;
        List<address> list;
        public int checkPosition = -1;


        public AddressAdpter(List<address> list) { //        List<addresslist> list
            this.list = list;
//            this.listner = listner;

        }

        @NonNull
        @Override
        public AddressAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.addresslist_page21, parent, false);
            CustomViewHolder holder = new CustomViewHolder(ABC);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull AddressAdpter.CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

         /*   holder.name.setText(list.get(position).getName());
            holder.location.setText(list.get(position).getLocation());
            holder.location.setText(list.get(position).getCity());
            holder.address.setText(list.get(position).getAddress());
            holder.number.setText(list.get(position).getNumber());
*/
            holder.name.setText(list.get(position).getName());
            holder.address.setText(list.get(position).getAddress());
            holder.number.setText(list.get(position).getEmail());
            holder.location.setText(list.get(position).getCity());

            //radio button check condition
            if (checkPosition == position) {
                holder.radio.setChecked(true);
            } else {
                holder.radio.setChecked(false);
            }
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkPosition = position;         //checkposition means save position
                    adpter.notifyDataSetChanged();



                }
            });


            holder.radio.setClickable(false);


            holder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    array = new JSONArray();

                    try {
                        array = new JSONArray(preferences.getString("ADDRESS", "[]"));
                        array.remove(position);
                        list.remove(position);
                        editor = preferences.edit();
                        editor.putString("ADDRESS", array.toString());
                        editor.commit();

                        adpter.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            TextView name, location, address, number;
            TextView delete;
            RadioButton radio;
            LinearLayout linearLayout;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.addressname);
                linearLayout = itemView.findViewById(R.id.address1);
                radio = itemView.findViewById(R.id.radio);
                location = itemView.findViewById(R.id.area);
                address = itemView.findViewById(R.id.addressperson);
                number = itemView.findViewById(R.id.mobilenumber);
                delete = itemView.findViewById(R.id.delete);

            }
        }
    }
}