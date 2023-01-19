package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.compose.ui.BiasAbsoluteAlignment;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.CartItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomenewPage13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomenewPage13 extends Fragment {
    RecyclerView food;
    RecyclerView list1;
    HotelsPage10 activity;


    List<fooditemlist> list3 = new ArrayList<>();
    List<fooditemlist> MainCourse = new ArrayList<>();
    List<fooditemlist> Desserts = new ArrayList<fooditemlist>();
    List<fooditemlist> Chiness = new ArrayList<fooditemlist>();
    List<fooditemlist> Breakfast = new ArrayList<>();
    List<fooditemlist> Starters = new ArrayList<fooditemlist>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private JSONArray Menudata;
    private String mParam2;

    public HomenewPage13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomenewPage13.
     */
    // TODO: Rename and change types and number of parameters
    public static HomenewPage13 newInstance(String param1, String param2) {
        HomenewPage13 fragment = new HomenewPage13();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity  = (HotelsPage10) getActivity();
        if (getArguments() != null) {
            try {
                Menudata = new JSONArray(getArguments().getString("Menulist"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }



    @Override
    public void onStart() {
        super.onStart();
        Log.e("TAG", "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG", "onResume: " );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG", "onCreateView: " );
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_homenew_page13, container, false);

       //1st recycler view adpter
         list1 = v.findViewById(R.id.frecycle1page13);
        Set<String>list = new LinkedHashSet<>();

        //add linearlayout orientation
        list1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));



        //2nd recycler view adpter
         food = v.findViewById(R.id.frecyle2page13);
        List<fooditemlist>list3 = new ArrayList<>();


try {
//            Menudata = new JSONArray(getArguments().getString("Menulist"));
            for (int i=0; i<Menudata.length(); i++){
                JSONObject object = Menudata.getJSONObject(i);
                fooditemlist foodlist = new fooditemlist(object.getString("name"),object.getString("price"),object.getString("Catageory"),object.getString("photo"),object.getString("Service"));
                list3.add(foodlist);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



       /* fooditemlist image1 = new fooditemlist("Paneer","150Rs","MainCourse","https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg","service2");
        list3.add(image1);
        fooditemlist image2 = new fooditemlist("Ice-Cream","150Rs","Desserts","https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg","service2");
        list3.add(image2);
        fooditemlist image3 = new fooditemlist("Idle","150Rs","Starters","https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg","service2");
        list3.add(image3);
        fooditemlist image4 = new fooditemlist("Noddles","150Rs","Chiness","https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg","service2");
        list3.add(image4);
        fooditemlist image5 = new fooditemlist("Noodels","150Rs","Breakfast","https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg","service2");
        list3.add(image5);*/
        food.setLayoutManager(new LinearLayoutManager(getContext()));//first set layout

        MenulistAdpter adpter1 = new MenulistAdpter(list3);
        food.setAdapter(adpter1);

        for (fooditemlist item : list3 ){

            if (item.category.equalsIgnoreCase("MainCourse")){
                MainCourse.add(item);
            }
            if (item.category.equalsIgnoreCase("Desserts")){
                Desserts.add(item);

            }
            if (item.category.equalsIgnoreCase("Chiness")){
                Chiness.add(item);
            }
            if (item.category.equalsIgnoreCase("Starters")){
                Starters.add(item);
            }
            if (item.category.equalsIgnoreCase("Breakfast")){
                Breakfast.add(item);
            }
           list.add(item.getCategory());
        }
        MenuAdpter adpter = new MenuAdpter(list);
        list1.setAdapter(adpter);


        return v;

    }




    //first button recyclerview adpter class
    class MenuAdpter extends RecyclerView.Adapter<MenuAdpter.CustomHolderAdpter>{
        ArrayList<String> list;

        public MenuAdpter(Set<String> list) {
            this.list = new ArrayList<>(list);

        }
        @NonNull
        @Override
        public MenuAdpter.CustomHolderAdpter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view1 = LayoutInflater.from(getContext()).inflate(R.layout.menubuttonpage13,parent,false);
            CustomHolderAdpter holder = new CustomHolderAdpter(view1);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MenuAdpter.CustomHolderAdpter holder, @SuppressLint("RecyclerView") int position) {

            holder.button.setText(list.get(position));

            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (list.get(position).equalsIgnoreCase("All Menulist")){
                        MenulistAdpter adpter = new MenulistAdpter(list3);
                        food.setAdapter(adpter);
                    }
                    if (list.get(position).equalsIgnoreCase("MainCourse")){
                        MenulistAdpter adpter = new MenulistAdpter(MainCourse);
                        food.setAdapter(adpter);
                    }

                    else if (list.get(position).equalsIgnoreCase("Desserts")){
                        MenulistAdpter adpter = new MenulistAdpter(Desserts);
                        food.setAdapter(adpter);
                    }
               else if (list.get(position).equalsIgnoreCase("Chiness")){
                        MenulistAdpter adpter = new MenulistAdpter(Chiness);
                        food.setAdapter(adpter);
                    }
               else if (list.get(position).equalsIgnoreCase("Starters")){
                        MenulistAdpter adpter = new MenulistAdpter(Starters);
                        food.setAdapter(adpter);
                    }
               else if (list.get(position).equalsIgnoreCase("Breakfast")){
                        MenulistAdpter adpter = new MenulistAdpter(Breakfast);
                        food.setAdapter(adpter);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomHolderAdpter extends RecyclerView.ViewHolder {
            Button button ;
            public CustomHolderAdpter(@NonNull View itemView) {
                super(itemView);
                button = itemView.findViewById(R.id.buttonpage13);
            }
        }
    }






    //second Recyclerview adpter class
  public   class MenulistAdpter extends RecyclerView.Adapter<MenulistAdpter.CustomHolderAdpter>{
        List<fooditemlist> list3;


        public MenulistAdpter(List<fooditemlist> list3) {
            this.list3 = list3;

        }

        @NonNull
        @Override
        public MenulistAdpter.CustomHolderAdpter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View A = LayoutInflater.from(getContext()).inflate(R.layout.menulistpage13,parent,false);
            CustomHolderAdpter holder = new CustomHolderAdpter(A);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MenulistAdpter.CustomHolderAdpter holder, int position) {

            holder.name.setText(list3.get(position).getName());
            holder.price.setText(list3.get(position).getPrice());
            holder.serves.setText(list3.get(position).getService_type());

            Glide.with(getContext()).load(list3.get(position).getImage()).into(holder.image);
            Log.e("TAG",list3.get(position).getImage());


            //add button visible and gone method
            holder.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.gone.setVisibility(View.VISIBLE);
                    holder.add.setVisibility(View.GONE);


                    CartItem item= new CartItem(list3.get(position).getName(),list3.get(position).getImage(),list3.get(position).getPrice());
                    Log.e("TAG", "onClick: " );
                    activity.listner.AddItem(item);


                }
            });



            holder.gone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    holder.add.setVisibility(View.VISIBLE);
                    holder.gone.setVisibility(View.GONE);
                }
            });


            //1st method add food
            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (holder.onetext.getText().toString().equalsIgnoreCase("1")){
                        holder.onetext.setText("2");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("2")){
                        holder.onetext.setText("3");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("3")){
                        holder.onetext.setText("4");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("4")){
                        holder.onetext.setText("5");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("5")){
                        holder.onetext.setText("6");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("6")){
                        holder.onetext.setText("7");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("7")){
                        holder.onetext.setText("8");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("8")){
                        holder.onetext.setText("9");
                    }
                    else if (holder.onetext.getText().toString().equalsIgnoreCase("9")){
                        holder.onetext.setText("10");
                    }
                    else if (
                            holder.onetext.getText().toString().equalsIgnoreCase("10")){
                        Toast.makeText(getActivity(), "Maximum value exceed", Toast.LENGTH_SHORT).show();
                    }
                    activity.listner.Update(list3.get(position).getName(),holder.onetext.getText().toString());

                }
            });


            //2nd method remove
            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int value = Integer.parseInt(String.valueOf(holder.onetext.getText().toString()));
                    if (value>1){
                        value = value-1;
                        holder.onetext.setText(String.valueOf(value));
                    }
                    else {
                        Toast.makeText(getActivity(), "Add value", Toast.LENGTH_SHORT).show();

                        holder.add.setVisibility(View.VISIBLE);
                        holder.gone.setVisibility(View.GONE);
                    }

                }
            });






        }

        @Override
        public int getItemCount() {
            return list3.size();
        }

        public class CustomHolderAdpter extends RecyclerView.ViewHolder{
            ImageView image;
            TextView name;
            TextView price;
            TextView serves;
            Button add ;
            LinearLayout gone;
            Button minus , plus;
            TextView onetext;


            public CustomHolderAdpter(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image1page13);
                name = itemView.findViewById(R.id.text1page13);
                price = itemView.findViewById(R.id.text2page13);
                serves = itemView.findViewById(R.id.text3page13);
                add = itemView.findViewById(R.id.buttonvisible);
                gone = itemView.findViewById(R.id.buttongone);

                minus = itemView.findViewById(R.id.minus);
                plus = itemView.findViewById(R.id.plus);
                onetext = itemView.findViewById(R.id.onetext);
            }
        }
    }


}