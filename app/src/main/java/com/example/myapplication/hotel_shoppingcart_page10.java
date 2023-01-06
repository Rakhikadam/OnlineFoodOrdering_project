package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hotel_shoppingcart_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hotel_shoppingcart_page10 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public hotel_shoppingcart_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hotel_shoppingcart.
     */
    // TODO: Rename and change types and number of parameters
    public static hotel_shoppingcart_page10 newInstance(String param1, String param2) {
        hotel_shoppingcart_page10 fragment = new hotel_shoppingcart_page10();
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
        View view = inflater.inflate(R.layout.fragment_hotel_shoppingcart, container, false);

        RecyclerView cart = view.findViewById(R.id.cart);
        List<shoppingcart> list = new ArrayList<>();

        shoppingcart image1 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
        list.add(image1);
        shoppingcart image2 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
        list.add(image2);
        shoppingcart image3 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
        list.add(image3);
        shoppingcart image4 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
        list.add(image4);

        ShoopingcarAdpter adpter = new ShoopingcarAdpter(list);
        cart.setAdapter(adpter);
        cart.setLayoutManager(new LinearLayoutManager(getContext()));


        //checkout button set listner
        Button checkout = view.findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Page21.class);
                startActivity(intent);
            }
        });



        return view;
    }
class  ShoopingcarAdpter extends RecyclerView.Adapter<ShoopingcarAdpter.CustomAdpterHolder>{
    List<shoppingcart> list;

    public ShoopingcarAdpter(List<shoppingcart> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public ShoopingcarAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.shoppingcartlist_page10,parent,false);

        CustomAdpterHolder holder = new CustomAdpterHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoopingcarAdpter.CustomAdpterHolder holder, int position) {

        holder.price.setText(list.get(position).getPrice());
        holder.name.setText(list.get(position).getName());
        Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomAdpterHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;

        public CustomAdpterHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.shoppingimage1);
            name= itemView.findViewById(R.id.carttext);
            price = itemView.findViewById(R.id.cartprise);

        }
    }
}
}