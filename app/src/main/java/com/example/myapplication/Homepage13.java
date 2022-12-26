package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Homepage13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Homepage13 extends Fragment {
    List<Itemname>MainCourse = new ArrayList<>();
    List<Itemname>Desserts = new ArrayList<>();
    List<Itemname>Chinese = new ArrayList<>();
    List<Itemname>Breakfast = new ArrayList<>();
    List<Itemname>Starters = new ArrayList<>();

    RecyclerView recycler2;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Homepage13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Homepage13.
     */
    // TODO: Rename and change types and number of parameters
    public static Homepage13 newInstance(String param1, String param2) {
        Homepage13 fragment = new Homepage13();
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

        View view  = inflater.inflate(R.layout.fragment_homepage13, container, false);
        RecyclerView recycler1 = view.findViewById(R.id.recycle1page13);

        //Initalize menus category
        Set<String> category = new LinkedHashSet<>(); //set linkedHashSet

        recycler1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));






        //Initalize menulist
        recycler2 = view.findViewById(R.id.recyle2page13);
        List<Itemname>list  = new ArrayList<>();
        Itemname list1 = new Itemname("Paneer","150Rs","Main Course","https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg","Serves2");
        list.add(list1);
        Itemname list2 = new Itemname("Ice-Cream","100Rs","Desserts","https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg","Serves2");
        list.add(list2);
        Itemname list3 = new Itemname("Noodels","150Rs","Chinese","https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg","Serves2");
        list.add(list3);
        Itemname list4 = new Itemname("Paneer","150Rs","Breakfast","https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg","Serves2");
        list.add(list4);
        Itemname list5 = new Itemname("Paneer","150Rs","Main Course","https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg","Serves2");
        list.add(list5);

        ItemAdpter adpter1 = new ItemAdpter(list);   //set adpter
        recycler2.setAdapter(adpter1);

        recycler2.setLayoutManager(new LinearLayoutManager(getContext()));

        //
        for (Itemname item : list){
           if (item.category.equalsIgnoreCase("Main Course")){
               MainCourse.add(item);
           }

           if (item.category.equalsIgnoreCase("Desserts")){
               Desserts.add(item);
           }

            if (item.category.equalsIgnoreCase("Chinese")){
               Chinese.add(item);
           }

             if (item.category.equalsIgnoreCase("Breakfast")){
               Breakfast.add(item);
             }

             if (item.category.equalsIgnoreCase("Starters")){
              Starters.add(item);
           }
           category.add(item.getCategory());

        }
        recycler1.setAdapter(new CategoryAdpter(category)); //recycler1 CategoryAdpter set in category



        return view;

    }
    //create Adpter of list
    class ItemAdpter extends RecyclerView.Adapter<ItemAdpter.CustomAdpterHolder>{
        List<Itemname> list;

        public ItemAdpter(List<Itemname> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public ItemAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(getContext()).inflate(R.layout.menulistpage13,parent,false);
           CustomAdpterHolder holder = new CustomAdpterHolder(view);
           return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemAdpter.CustomAdpterHolder holder, int position) {
            holder.name.setText(list.get(position).getName());
            holder.price.setText(list.get(position).getPrice());
            holder.serves.setText(list.get(position).getService_type());
            Glide.with(Homepage13.this).load(list.get(position).getImage()).into(holder.image);
            Log.e("TAG",list.get(position).getImage());


            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.gone.setVisibility(View.VISIBLE);
                    holder.add.setVisibility(View.GONE);
                }
            });

            holder.gone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.add.setVisibility(View.VISIBLE);
                    holder.gone.setVisibility(View.GONE);
                }
            });

        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder{
            ImageView image;
            TextView name;
            TextView price;
            TextView serves;
            Button add ;
            LinearLayout gone;


            public CustomAdpterHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image1page13);
                name = itemView.findViewById(R.id.text1page13);
                price = itemView.findViewById(R.id.text2page13);
                serves = itemView.findViewById(R.id.text3page13);
                add = itemView.findViewById(R.id.buttonvisible);
                gone = itemView.findViewById(R.id.buttongone);

            }
        }
    }




    //crate Adpter of category
    class CategoryAdpter extends RecyclerView.Adapter<CategoryAdpter.CustomAdpterHolder>{
    //covert set to list
    List<String> category;

    public CategoryAdpter(Set<String> category) {
        this.category = new ArrayList<>(category);

    }

    @NonNull
    @Override
    public CategoryAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.menubuttonpage13,parent,false);
        CustomAdpterHolder holder = new CustomAdpterHolder(view1);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdpter.CustomAdpterHolder holder, @SuppressLint("RecyclerView") int position) {
        //equalIgnoreCase means show capital and small letter same
        holder.button.setText(category.get(position));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (category.get(position).equalsIgnoreCase("main course")){
                    ItemAdpter adpter1 = new ItemAdpter(MainCourse);
                    recycler2.setAdapter(adpter1);
                }

                else if (category.get(position).equalsIgnoreCase("Desserts")){
                    ItemAdpter adpter1 = new ItemAdpter(Desserts);
                    recycler2.setAdapter(adpter1);
                }
            else if (category.get(position).equalsIgnoreCase("Chinese")){
                    ItemAdpter adpter1 = new ItemAdpter(Chinese);
                    recycler2.setAdapter(adpter1);
                }
            else if (category.get(position).equalsIgnoreCase("Starters")){
                    ItemAdpter adpter1 = new ItemAdpter(Starters);
                    recycler2.setAdapter(adpter1);
                }
            else if (category.get(position).equalsIgnoreCase("Breakfast")){
                    ItemAdpter adpter1 = new ItemAdpter(Breakfast);
                    recycler2.setAdapter(adpter1);
                }
            }
        });

       }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class CustomAdpterHolder extends RecyclerView.ViewHolder {
        Button button;
        public CustomAdpterHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.buttonpage13);

        }
    }
}

}