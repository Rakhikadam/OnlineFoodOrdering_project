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
 * Use the {@link Aboutpage13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Aboutpage13 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Aboutpage13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Aboutpage13.
     */
    // TODO: Rename and change types and number of parameters
    public static Aboutpage13 newInstance(String param1, String param2) {
        Aboutpage13 fragment = new Aboutpage13();
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
        View view = inflater.inflate(R.layout.fragment_aboutpage13, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerFacility);
        List<facility>list1 = new ArrayList<>();
        facility first = new facility("wifi");
        list1.add(first);
        facility first1 = new facility("Aire conditioner");
        list1.add(first1);
        facility first2 = new facility("cards Accepted");
        list1.add(first2);
        facility first3 = new facility("Parking");
        list1.add(first3);
        facility first4 = new facility("Wallet Accepted");
        list1.add(first4);
        FacilityAdpter adpter = new FacilityAdpter(list1);
        recyclerView.setAdapter(adpter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));




        return view;
    }

    class FacilityAdpter extends RecyclerView.Adapter<FacilityAdpter.CustomHolderAdpter>{
        List<facility> list1;

        public FacilityAdpter(List<facility> list1) {
            this.list1 = list1;
        }

        @NonNull
        @Override
        public FacilityAdpter.CustomHolderAdpter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.facilites_recycler13,parent,false);
            CustomHolderAdpter holder = new CustomHolderAdpter(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FacilityAdpter.CustomHolderAdpter holder, int position) {

            holder.facilityname.setText(list1.get(position).getFacility_name());

        }

        @Override
        public int getItemCount() {
            return list1.size() ;
        }

        public class CustomHolderAdpter extends RecyclerView.ViewHolder{
            TextView facilityname;
            public CustomHolderAdpter(@NonNull View itemView) {
                super(itemView);
                facilityname = itemView.findViewById(R.id.textfacility);
            }

        }
    }
}