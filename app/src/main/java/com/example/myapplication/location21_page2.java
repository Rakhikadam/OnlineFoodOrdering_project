package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link location21_page2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class location21_page2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public location21_page2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment location21_page2.
     */
    // TODO: Rename and change types and number of parameters
    public static location21_page2 newInstance(String param1, String param2) {
        location21_page2 fragment = new location21_page2();
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
        View view =inflater.inflate(R.layout.fragment_location21_page2, container, false);

        RecyclerView view1 = view.findViewById(R.id.recyclerpage21);
        List<addresslist>list = new ArrayList<>();
        addresslist user = new addresslist("Rakhi kadam","Home","M.G Road,Oshiwar Ind Estate ,Opp king circle,sion,Mumbai ,Mharashtra -400002,India","9826653443");
        list.add(user);
        addresslist user1 = new addresslist("Rakhi kadam","Home","M.G Road,Oshiwar Ind Estate ,Opp king circle,Bhnadup,Mumbai ,Mharashtra -400002,India","985526626");
        list.add(user1);
        addresslist user2 = new addresslist("Rakhi kadam","Home","M.G Road,Oshiwar Ind Estate ,Opp king circle,sion,Mumbai ,Mharashtra -400002,India","9877665443");
        list.add(user2);
        addresslist user3 = new addresslist("Rakhi kadam","Home","M.G Road,Oshiwar Ind Estate ,Opp king circle,sion,Mumbai ,Mharashtra -400002,India","9887766654");
        list.add(user3);
        view1.setLayoutManager(new LinearLayoutManager(getContext()));
        AddressAdpter adpter = new AddressAdpter(list);
        view1.setAdapter(adpter);



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