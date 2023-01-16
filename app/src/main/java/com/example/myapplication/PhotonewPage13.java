package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhotonewPage13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotonewPage13 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private JSONArray Photodata;
    private String mParam2;

    public PhotonewPage13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PhotonewPage13.
     */
    // TODO: Rename and change types and number of parameters
    public static PhotonewPage13 newInstance(String param1, String param2) {
        PhotonewPage13 fragment = new PhotonewPage13();
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
                Photodata = new JSONArray(getArguments().getString("hotelphotos"));
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
        View view =  inflater.inflate(R.layout.fragment_photonew_page13, container, false);

        RecyclerView recycler =view.findViewById(R.id.ll_photorecycle13);



        List<photo> list = new ArrayList<>();
       /* photo image1 = new photo("https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg");
        list.add(image1);
        photo image2 = new photo("https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso");
        list.add(image2);
        photo image3 = new photo("https://mydaintykitchen.com/wp-content/uploads/2019/07/31-Quick-Party-Appetizers-1.jpg");
        list.add(image3);
        photo image4 = new photo("https://img.buzzfeed.com/thumbnailer-prod-us-east-1/video-api/assets/173373.jpg");
        list.add(image4);

       */

        try {
            Photodata =new JSONArray(getArguments().getString("hotelphotos"));
            for (int i=0 ; i<Photodata.length(); i++){
                JSONObject object = Photodata.getJSONObject(i);
                photo photolit = new photo(object.getString("photo"));
                list.add(photolit);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



        recycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        PhotolistnewAdpter adpter = new PhotolistnewAdpter(list);
        recycler.setAdapter(adpter);


        return view;
    }

    class PhotolistnewAdpter extends RecyclerView.Adapter<PhotolistnewAdpter.CustomAdpterHolder>{

        List<photo> list;
        public PhotolistnewAdpter(List<photo> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public PhotolistnewAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.photoimage13,parent,false);
            CustomAdpterHolder holder = new CustomAdpterHolder(ABC);

            return holder;


        }

        @Override
        public void onBindViewHolder(@NonNull PhotolistnewAdpter.CustomAdpterHolder holder, int position) {
            Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder{
            ImageView image;

            public CustomAdpterHolder(@NonNull View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.photo);

            }
        }
    }

}