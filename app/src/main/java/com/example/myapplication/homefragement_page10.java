package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homefragement_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homefragement_page10 extends Fragment {
    RecyclerView Item;
    RecyclerView Image;
    RecyclerView NonVeg;
    RecyclerView Veg;
    RecyclerView Starter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public homefragement_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homefragement_page10.
     */
    // TODO: Rename and change types and number of parameters
    public static homefragement_page10 newInstance(String param1, String param2) {
        homefragement_page10 fragment = new homefragement_page10();
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
        View view = inflater.inflate(R.layout.fragment_homefragement_page10, container, false);

        //first image Recyclerview
        RecyclerView Item = view.findViewById(R.id.fimagerecycle);
        List<imageitem>list = new ArrayList<>();
        imageitem image = new imageitem("Restaurant Food","https://media.istockphoto.com/id/104704117/photo/restaurant-plates.jpg?s=1024x1024&w=is&k=20&c=E3R2zzqMOSjWHIxUg07jTbs3BiGVcurZGiV_xHdk3YI=");
        list.add(image);
        imageitem image1 = new imageitem("Non-veg Food","https://www.shutterstock.com/shutterstock/photos/1488189020/display_1500/stock-photo-the-concept-of-oriental-cuisine-assorted-uzbek-food-set-pilaf-samsa-lagman-manta-shurpa-uzbek-1488189020.jpg");
        list.add(image1);
        imageitem image2 = new imageitem("Veg Food","https://case.edu/farm/sites/case.edu.farm/files/2019-03/Produce%20Daily%20Posting.jpg");
        list.add(image2);
        imageitem image3 = new imageitem("Starter Food","https://i.ndtvimg.com/i/2015-07/paneer-tikka-625_625x350_81436947019.jpg");
        list.add(image3);

        ItemfoodAdpter adpter = new ItemfoodAdpter(list);
        Item.setAdapter(adpter);
        Item.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));



        //Second image Recycler
        //second RecycleView Adpter list
        Image = view.findViewById(R.id.fimagerecycle1);
        List<Drawable>list1 = new ArrayList<>();
        list1.add(getResources().getDrawable(R.drawable.imagep7));
        list1.add(getResources().getDrawable(R.drawable.image3));
        list1.add(getResources().getDrawable(R.drawable.image4));
        list1.add(getResources().getDrawable(R.drawable.icecream1));
        FoodAdpter adpter1 = new FoodAdpter(list1);
        Image.setAdapter(adpter1);

        Image.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


        //Third image Recycler
        //Third RecycleView Adpter list

        RecyclerView NonVeg = view.findViewById(R.id.fimagerecycle2);
        List<foodlist>nonveglist = new ArrayList<>();
        foodlist photo = new foodlist("Grilled Chiken","25% offers","890https://i.ndtvimg.com/i/2015-12/grilled-chicken-625_625x350_71451368942.jpg");
        nonveglist.add(photo);

        foodlist photo1 = new foodlist("Mutton Korma","50% offers","https://i.ndtvimg.com/i/2015-03/badam-korma_625x350_41426244081.jpg");
        nonveglist.add(photo1);

        foodlist photo2 = new foodlist("Tandoori Lamb Chops","20% offers","https://i.ndtvimg.com/i/2016-06/lamb-chops_625x350_51466768845.jpg");
        nonveglist.add(photo2);

        foodlist photo3 = new foodlist("Malabar Fish Biryani","30% offers","https://i.ndtvimg.com/i/2016-11/biryani-620_620x350_41478678907.jpg");
        nonveglist.add(photo3);

        FoodlistAdpter adpter2 = new FoodlistAdpter(nonveglist);
        NonVeg.setAdapter(adpter2);
        NonVeg.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

        //Fouth image Recycler
        //Fourt RecycleView Adpter list
        RecyclerView Veg = view.findViewById(R.id.fimagerecycle3);
        List<foodlist>veglist = new ArrayList<>();
        foodlist veg1 = new foodlist("Veg Biryani","20% offer","https://foodiewish.com/wp-content/uploads/2020/03/Vegetable-Biryani-foodiewish.jpg");
        veglist.add(veg1);

        foodlist veg2 = new foodlist("Alu Puri","10% offer","https://foodiewish.com/wp-content/uploads/2020/03/Vegetarian-dishes-foodiewish.jpg");
        veglist.add(veg2);

        foodlist veg3 = new foodlist("Khichdi","20% offer","https://foodiewish.com/wp-content/uploads/2020/03/Khichdi-foodiewish.jpg");
        veglist.add(veg3);

        foodlist veg4 = new foodlist("Special Veg Biryani","25% offer","https://foodiewish.com/wp-content/uploads/2020/03/Vegetable-Biryani-foodiewish.jpg");
        veglist.add(veg4);
        FoodlistAdpter adpter3 = new FoodlistAdpter(veglist);
        Veg.setAdapter(adpter3);
        Veg.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));



        //Fith image Recycler
        //Fith RecycleView Adpter list
        RecyclerView Straters =  view.findViewById(R.id.fimagerecycle4);
        List<foodlist>starters = new ArrayList<>();
        foodlist starter1 = new foodlist("Halwa","2% offer","https://foodiewish.com/wp-content/uploads/2020/03/Halwa-foodiewish.jpg");
        starters.add(starter1);
foodlist starter2 = new foodlist("Masala Papad","2% offer","https://profusioncurry.com/wp-content/uploads/2021/09/Masala-papad-recipe-close-up-showing-delicious-appetizer-snack.jpg");
        starters.add(starter2);
foodlist starter3 = new foodlist("Halwa","2% offer","https://foodiewish.com/wp-content/uploads/2020/03/Momos-foodiewish.jpg");
        starters.add(starter3);
foodlist starter4 = new foodlist("Halwa","2% offer","https://foodiewish.com/wp-content/uploads/2020/03/Halwa-foodiewish.jpg");
        starters.add(starter4);
        FoodlistAdpter adpter4 = new FoodlistAdpter(starters);
        Straters.setAdapter(adpter4);
        Straters.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));


        TextView viewall = view.findViewById(R.id.llviewall1);
        TextView viewall1 = view.findViewById(R.id.ll_viewall3);
        TextView vegfood = view.findViewById(R.id.ll_viewall2);

        //underline of textview
        vegfood.setText(Html.fromHtml("<u>View all</u>"));

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,new FragementNew_page13());
                transaction.commit();
            }
        });
        vegfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,new FragementNew_page13());
                transaction.commit();
            }
        });

        viewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,new FragementNew_page13());
                transaction.commit();
            }
        });


        return view;
    }



    //first Recyclerpage class Adpter method
    class ItemfoodAdpter extends RecyclerView.Adapter<ItemfoodAdpter.CustomViewHolder>{
        List<imageitem> list;

        public ItemfoodAdpter(List<imageitem> list) {
            this.list = list;
        }
        @NonNull
        @Override
        public ItemfoodAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.imagepage10,parent,false);
            CustomViewHolder holder = new CustomViewHolder(ABC);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemfoodAdpter.CustomViewHolder holder, int position) {

            holder.food.setText(list.get(position).getName());
            Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            ImageView image;
            TextView food;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.imagerecycle2);
                food = itemView.findViewById(R.id.text4page10);
            }
        }
    }




    //Second Recyclerpage class Adpter method

    class FoodAdpter extends RecyclerView.Adapter<FoodAdpter.CustomViewHolder>{
        List<Drawable> list1;

        public FoodAdpter(List<Drawable> list1) {
            this.list1 = list1;

        }

        @NonNull
        @Override
        public FoodAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(getContext()).inflate(R.layout.image2page10,parent,false);
           CustomViewHolder holder = new CustomViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FoodAdpter.CustomViewHolder holder, int position) {
            holder.image.setImageDrawable(list1.get(position));

        }

        @Override
        public int getItemCount() {
            return list1.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            ImageView image;
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image8);
            }
        }
    }


    //Third Recyclerpage class Adpter method
    class FoodlistAdpter extends RecyclerView.Adapter<FoodlistAdpter.CustomViewHolder>{
        List<foodlist> nonveglist;

        public FoodlistAdpter(List<foodlist> nonveglist) {
            this.nonveglist = nonveglist;

        }

        @NonNull
        @Override
        public FoodlistAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View A = LayoutInflater.from(getContext()).inflate(R.layout.imagepagenew10,parent,false);
           CustomViewHolder holder = new CustomViewHolder(A);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FoodlistAdpter.CustomViewHolder holder, int position) {
            holder.name.setText(nonveglist.get(position).getName());
            holder.offer.setText(nonveglist.get(position).getOffer());
            Glide.with(getContext()).load(nonveglist.get(position).getImage()).into(holder.image);

        }

        @Override
        public int getItemCount() {
            return nonveglist.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;
            TextView offer;
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.fimage1page10);
                name = itemView.findViewById(R.id.ftext2page10);
                offer = itemView.findViewById(R.id.ftext1page10);
            }
        }
    }

}