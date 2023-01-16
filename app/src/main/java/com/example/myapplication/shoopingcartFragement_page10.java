package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.CartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link shoopingcartFragement_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class shoopingcartFragement_page10 extends Fragment {
    ItemAddListner Listner;
    List<shoppingcart> list = new ArrayList<shoppingcart>();
    ShoopingAdpter adpter;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public shoopingcartFragement_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment shoopingcartFragement_page10.
     */
    // TODO: Rename and change types and number of parameters
    public static shoopingcartFragement_page10 newInstance(String param1, String param2) {
        shoopingcartFragement_page10 fragment = new shoopingcartFragement_page10();
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
        Page10_FragementandTab activity = (Page10_FragementandTab) getActivity();
        activity.Listner = new ItemAddListner() {
            @Override
            public void Itemadd(CartItem item) {
                shoppingcart cart = new shoppingcart(item.getName(), item.getPrice(), item.getImageUrl());
                list.add(cart);
                adpter.notifyDataSetChanged();


            }

            @Override
            public Void Update(String name, String quantity) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(name)) {
                        list.get(i).setCount(quantity);
                        adpter.notifyDataSetChanged();
                    }

                }
                return null;
            }

        };

        Listner = activity.Listner;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_shoopingcart_fragement_page10, container, false);
        RecyclerView cartrecycler = view.findViewById(R.id.shoppingcartlist);

        List<shoppingcartlist>list = new ArrayList<>();

        shoppingcartlist list1 = new shoppingcartlist("Paneer","150Rs","https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
        list.add(list1);
 shoppingcartlist list2 = new shoppingcartlist("Paneer","150Rs","https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
        list.add(list2);
 shoppingcartlist list3 = new shoppingcartlist("Paneer","150Rs","https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
        list.add(list3);

        ShoopingAdpter adpter =new ShoopingAdpter(list);
        cartrecycler.setAdapter(adpter);
        cartrecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    class ShoopingAdpter extends RecyclerView.Adapter<ShoopingAdpter.CustomViewHolder>{
        List<shoppingcartlist> list;

        public ShoopingAdpter(List<shoppingcartlist> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public ShoopingAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(getContext()).inflate(R.layout.shoppingcartlist_page10,parent,false);
            CustomViewHolder holder = new CustomViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ShoopingAdpter.CustomViewHolder holder, int position) {

            holder.price.setText(list.get(position).getPrice());
            holder.name.setText(list.get(position).getName());
            Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;
            TextView price;
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.shoppingimage1);
                name= itemView.findViewById(R.id.carttext);
                price = itemView.findViewById(R.id.cartprise);
            }
        }
    }
}