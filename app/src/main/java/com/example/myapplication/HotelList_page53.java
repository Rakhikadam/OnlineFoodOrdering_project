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

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelList_page53#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotelList_page53 extends Fragment {
    DBHelper helper = new DBHelper(getContext());

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
            mParam1 = getArguments().getString("type");

          //  mParam2 = getArguments().getString("data");

           /* try {
                hotels = new JSONArray(getArguments().getString("data"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hotel_list_page53, container, false);
        RecyclerView recycler = view.findViewById(R.id.hotel_page53);
       // List<Hotellit>list = new ArrayList<>();

       /* try {
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
       */



        /*Hotellit image1 = new Hotellit("Alpha hotel", "30% OFF ", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image1);
        Hotellit image2 = new Hotellit("Star hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image2);
        Hotellit image3 = new Hotellit("Blue hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image3);
        Hotellit image4 = new Hotellit("Alpha hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        list.add(image4);

         */
     //   recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        /*recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        HotelListAdpter adpter = new HotelListAdpter(list);
        recycler.setAdapter(adpter);
*/
        DBHelper helper = new DBHelper(getContext());

        List<Homemadeinfo> homemadeinfo = helper.getHomemadeinfo();
        List<Hotelinfo> hotelinfos = helper.gethotelsinfo();
        recycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
       HomemadeHotelAdpter adpter1 = new HomemadeHotelAdpter(helper.getHomemadeinfo(),helper.gethotelsinfo());
      //  HomemadeHotelAdpter adpter = new HomemadeHotelAdpter(homemadeinfo,hotelinfos,getArguments().getString("data").toString());
        recycler.setAdapter(adpter1);


        return view;
    }
//SQLite adpter class
    class HomemadeHotelAdpter extends RecyclerView.Adapter<HomemadeHotelAdpter.CustomViewHolder>{
        List<Homemadeinfo> homemadeinfo;
        List<Hotelinfo> hotelinfos;

        public HomemadeHotelAdpter(List<Homemadeinfo> homemadeinfo,List<Hotelinfo> hotelinfos) {

            this.homemadeinfo = homemadeinfo;
            this.hotelinfos = hotelinfos;
        }

        @NonNull
        @Override
        public HomemadeHotelAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View A = LayoutInflater.from(getContext()).inflate(R.layout.imagepagenew10, parent, false);
            CustomViewHolder holder = new CustomViewHolder(A);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull HomemadeHotelAdpter.CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
            if (mParam1.equalsIgnoreCase("Homemade")){
                holder.name.setText(homemadeinfo.get(position).getName());
                holder.offer.setText(homemadeinfo.get(position).getOffers());
                Glide.with(getContext()).load(homemadeinfo.get(position).getImage()).into(holder.image);

            }
           else if (mParam1.equalsIgnoreCase("Restaurant")){
                holder.name.setText(hotelinfos.get(position).getName());
                holder.offer.setText(hotelinfos.get(position).getOffers());
                Glide.with(getContext()).load(hotelinfos.get(position).getImage()).into(holder.image);
            }


            holder.relative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new FragementNew_page13();
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", position);
                    if (mParam1.equalsIgnoreCase("Restaurant")){
                        bundle.putString("data",hotelinfos.get(position).getId());
                        bundle.putString("type","Restaurant");

                    }
                    else if (mParam1.equalsIgnoreCase("Homemade")){
                        bundle.putString("data",homemadeinfo.get(position).getId());
                        bundle.putString("type","Homemade");

                    }
                    /*bundle.putString("data",homemadeinfo.get(position).getId());
                    bundle.putString("data",hotelinfos.get(position).getId());
                    bundle.putString("type","Restaurant");
                    bundle.putString("type","Homemade");
                    */fragment.setArguments(bundle);
                    transaction.add(R.id.frame, fragment);
                    transaction.commit();


                }
            });
        }

        @Override
        public int getItemCount() {
            if (mParam1.equalsIgnoreCase("Restaurant")){
                return hotelinfos.size();
            }
            else {
                return homemadeinfo.size();
            }
          // return 0;
        }
        public class CustomViewHolder extends RecyclerView.ViewHolder{
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




//Create adpter class
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