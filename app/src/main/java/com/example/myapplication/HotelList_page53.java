package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelList_page53#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelList_page53 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    JSONArray hotels;

    public HotelList_page53() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotelList_page53.
     */
    // TODO: Rename and change types and number of parameters
    public static HotelList_page53 newInstance(String param1, String param2) {
        HotelList_page53 fragment = new HotelList_page53();
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

            try {
                hotels = new JSONArray(getArguments().getString("data"));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hotel_list_page53, container, false);
        RecyclerView recycler = view.findViewById(R.id.hotel_page53);
        List<Hotellit>list = new ArrayList<>();

        try {
            hotels = new JSONArray(getArguments().getString("data"));
            for (int i =0; i<hotels.length(); i++){
             //  JSONArray array = hotels.getJSONArray(i);
                JSONObject object = hotels.getJSONObject(i);
                Hotellit hotels = new Hotellit(object.getString("hotelname"),object.getString("offers"),object.getString("hotelimage"));
                list.add(hotels);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        /*Hotellit image1 = new Hotellit("Alpha hotel", "30% OFF ", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image1);
        Hotellit image2 = new Hotellit("Star hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image2);
        Hotellit image3 = new Hotellit("Blue hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image3);
        Hotellit image4 = new Hotellit("Alpha hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image4);

         */
        recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        HotelListAdpter adpter = new HotelListAdpter(list);
        recycler.setAdapter(adpter);



        return view;
    }
    class HotelListAdpter extends RecyclerView.Adapter<HotelListAdpter.CustomViewHolder>{
        List<Hotellit> list;

        public HotelListAdpter(List<Hotellit> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public HotelListAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View A = LayoutInflater.from(getContext()).inflate(R.layout.imagepagenew10, parent, false);
            CustomViewHolder holder = new CustomViewHolder(A);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull HotelListAdpter.CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.name.setText(list.get(position).getName());
            holder.offer.setText(list.get(position).getOffer());
            Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);

            holder.relative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new FragementNew_page13();
                    Bundle bundle = new Bundle();
                    JSONObject object = new JSONObject();

                    try {
                        object = hotels.getJSONObject(position);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    bundle.putInt("id", position);
                    bundle.putString("data", object.toString());
                    fragment.setArguments(bundle);
                    transaction.add(R.id.frame, fragment);
                    transaction.commit();

                }
            });


        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;
            TextView offer;
            RelativeLayout relative;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.fimage1page10);
                name = itemView.findViewById(R.id.ftext2page10);
                offer = itemView.findViewById(R.id.ftext1page10);
                relative = itemView.findViewById(R.id.realitive1);

            }
        }
    }
}