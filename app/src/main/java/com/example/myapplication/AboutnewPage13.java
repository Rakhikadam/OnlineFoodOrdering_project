package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutnewPage13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutnewPage13 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
     JSONArray aboutlist;
    private String mParam2;

    public AboutnewPage13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutnewPage13.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutnewPage13 newInstance(String param1, String param2) {
        AboutnewPage13 fragment = new AboutnewPage13();
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
            try {
                aboutlist = new JSONArray(getArguments().getString("About"));
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
        View view =  inflater.inflate(R.layout.fragment_aboutnew_page13, container, false);
        RecyclerView facilities = view.findViewById(R.id.ll_aboutrecycler);
        List<facility>aboutlist = new ArrayList<>();
        try {
            aboutlist = (List<facility>) new JSONArray(getArguments().getString("About"));
        } catch (JSONException e) {
            e.printStackTrace();
        }







       /* facility first = new facility("wifi");
        aboutlist.add(first);
        facility first1 = new facility("Aire conditioner");
        aboutlist.add(first1);
        facility first2 = new facility("cards Accepted");
        aboutlist.add(first2);
        facility first3 = new facility("Parking");
        aboutlist.add(first3);
        facility first4 = new facility("Wallet Accepted");
        aboutlist.add(first4);

        */
        FacilityAdpter adpter = new FacilityAdpter(aboutlist);
        facilities.setAdapter(adpter);



        return view;
    }

    class FacilityAdpter extends RecyclerView.Adapter<FacilityAdpter.CustomViewHolder>{
        List<facility> aboutlist;

        public FacilityAdpter(List<facility> aboutlist) {
            this.aboutlist = aboutlist;

        }

        @NonNull
        @Override
        public FacilityAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.facilites_recycler13,parent,false);
            CustomViewHolder holder = new CustomViewHolder(ABC);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FacilityAdpter.CustomViewHolder holder, int position) {

            holder.facilityname.setText(aboutlist.get(position).getFacility_name());

        }

        @Override
        public int getItemCount() {
            return aboutlist.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            TextView facilityname;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                facilityname = itemView.findViewById(R.id.textfacility);

            }
        }
    }
}