package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FarmProduct_page53#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FarmProduct_page53 extends Fragment {
   /* String data = "[\n" +
            "  {\n" +
            "    \"name\":\"resto1 vgfgn\",\n" +
            "    \"place\":\"bhandup\",\n" +
            "    \"active\":true,\n" +
            "    \"rating\":4.0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"resto2 vgfgn\",\n" +
            "    \"place\":\"bhandup\",\n" +
            "    \"active\":true,\n" +
            "    \"rating\":4.0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"resto3 vgfgn\",\n" +
            "    \"place\":\"bhandup\",\n" +
            "    \"active\":true,\n" +
            "    \"rating\":4.0\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\":\"resto4 vgfgn\",\n" +
            "    \"place\":\"bhandup\",\n" +
            "    \"active\":true,\n" +
            "    \"rating\":4.0\n" +
            "  }\n" +
            "  \n" +
            "]";

    */

    /*String data = "[\n" +
            "  {\n" +
            "    \"foodname\": \"grapes\",\n" +
            "    \"price\" : \"100Rs\",\n" +
            "    \"image\" : \"https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg\"\n" +
            "  },\n" +
            "\n" +
            "  {\n" +
            "    \"foodname\": \"apple\",\n" +
            "    \"price\" : \"100Rs\",\n" +
            "    \"image\" : \"https://www.shutterst" +
            "ock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"foodname\": \"lemone\",\n" +
            "    \"price\" : \"100Rs\",\n" +
            "    \"image\" : \"https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"foodname\": \"pineapple\",\n" +
            "    \"price\" : \"100Rs\",\n" +
            "    \"image\" : \"https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg\"\n" +
            "  }\n" +
            "]";

     */

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    JSONArray farmproduct;

    public FarmProduct_page53() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FarmProduct_page53.
     */
    // TODO: Rename and change types and number of parameters
    public static FarmProduct_page53 newInstance(String param1, String param2) {
        FarmProduct_page53 fragment = new FarmProduct_page53();
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
                farmproduct = new JSONArray(getArguments().getString("data"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_farm_product_page53, container, false);
        RecyclerView farm = view.findViewById(R.id.farmlist);

        List<farmlist>list = new ArrayList<>();

        //ex. using JSONArray
      /* try {
            JSONArray array = new JSONArray(data);
            for (int i=0; i<array.length();i++){
                JSONObject jsonObject = array.getJSONObject(i);
                  restaurant one = new restaurant(jsonObject.getString("name"),"","");
                        List<restaurant> list1 = new ArrayList<>();
                list1.add(one);

            }
        } catch (JSONException e) {
            e.printStackTrace(); .
        }*/



        //using page on JSON method
        List<farm> list1 = new ArrayList<>();
        try {
            farmproduct = new JSONArray(getArguments().getString("data"));
            for (int i = 0; i < farmproduct.length(); i++) {
                JSONObject object = farmproduct.getJSONObject(i);
                farm one = new farm(object.getString("name"),object.getString("price"), object.getString("Farmimage"));
                list1.add(one);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        FarmAdpter adpter = new FarmAdpter(list1);
        farm.setAdapter(adpter);







        /*farmlist image1 = new farmlist("Fresh Grapes","200Rs per/kg","https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg");
        list.add(image1);
 farmlist image2 = new farmlist("Fresh Straberry","200Rs per/kg","https://m.media-amazon.com/images/I/61Xl3VVZjKL._SX679_.jpg");
        list.add(image2);
 farmlist image3 = new farmlist("Fresh Apple","200Rs per/kg","https://blog-images-1.pharmeasy.in/blog/production/wp-content/uploads/2022/05/03114105/7-5.jpg");
        list.add(image3);
        FarmListAdpter adpter = new FarmListAdpter(list);
        farm.setAdapter(adpter);

         */
        farm.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        return view;
    }


    //using JSON method
    class FarmAdpter extends RecyclerView.Adapter<FarmAdpter.custoViewHolder>{
        List<farm> list1;

        public FarmAdpter(List<farm> list1) {
            this.list1 = list1;

        }

        @NonNull
        @Override
        public FarmAdpter.custoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.farmimagepage53,parent,false);
            custoViewHolder holder = new custoViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FarmAdpter.custoViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.name.setText(list1.get(position).getName());
            holder.price.setText(list1.get(position).getPrice());
            Glide.with(getContext()).load(list1.get(position).getImage()).into(holder.image);
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new Farminfo_page55();
                    Bundle bundle = new Bundle();
                    JSONObject object = new JSONObject();

                    try {
                        object = farmproduct.getJSONObject(position);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    bundle.putInt("ID",position);
                    bundle.putString("data",object.toString());
                    fragment.setArguments(bundle);
                    transaction.replace(R.id.frame,fragment);
                    transaction.commit();
                }
            });

        }

        @Override
        public int getItemCount() {
            return list1.size();
        }

        public class custoViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name ,price;
            LinearLayout foods;

            public custoViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.fimage1page53);
                name = itemView.findViewById(R.id.ftext2page53);
                price = itemView.findViewById(R.id.ftext3page53);
                foods= itemView.findViewById(R.id.linear53);

            }
        }
    }






/*
    class FarmListAdpter extends RecyclerView.Adapter<FarmListAdpter.CustomViewHolder>{
        List<farmlist> list;

        public FarmListAdpter(List<farmlist> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public FarmListAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.farmimagepage53,parent,false);
            CustomViewHolder holder = new CustomViewHolder(ABC);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FarmListAdpter.CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.name.setText(list.get(position).getName());
       holder.price.setText(list.get(position).getPrice());
       Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);

       holder.foods.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
               Fragment fragment = new Farminfo_page55();
               Bundle bundle = new Bundle();
               bundle.putInt("ID", position);
               bundle.putString("key","farmproduct");
               fragment.setArguments(bundle);
               transaction.replace(R.id.frame,fragment);
               transaction.commit();
           }
       });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            ImageView image;
            TextView name ,price;
            LinearLayout foods;


            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.fimage1page53);
                name = itemView.findViewById(R.id.ftext2page53);
                price = itemView.findViewById(R.id.ftext3page53);
                foods= itemView.findViewById(R.id.linear53);

            }
        }
    }

 */


}