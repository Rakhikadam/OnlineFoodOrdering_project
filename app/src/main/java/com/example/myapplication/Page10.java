package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Page10 extends AppCompatActivity {
    RecyclerView Item;
    RecyclerView Image;
    RecyclerView Nonvegview;
    RecyclerView VegView;
    RecyclerView Starters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page10);
        //FirstRecycleView Adpter list
        Item = findViewById(R.id.imagerecycle);
        List<fooditem>list = new ArrayList<>();
        fooditem food = new fooditem("https://media.istockphoto.com/id/104704117/photo/restaurant-plates.jpg?s=1024x1024&w=is&k=20&c=E3R2zzqMOSjWHIxUg07jTbs3BiGVcurZGiV_xHdk3YI=","Restaurant Food");
        list.add(food);
        fooditem food1 = new fooditem("https://www.shutterstock.com/shutterstock/photos/1488189020/display_1500/stock-photo-the-concept-of-oriental-cuisine-assorted-uzbek-food-set-pilaf-samsa-lagman-manta-shurpa-uzbek-1488189020.jpg","Homemade Food");
        list.add(food1);
        fooditem food2 = new fooditem("https://case.edu/farm/sites/case.edu.farm/files/2019-03/Produce%20Daily%20Posting.jpg","Farm Food");
        list.add(food2);
        ItemfoodAdpter adpter = new ItemfoodAdpter(list);
        Item.setAdapter(adpter);
        Item.setLayoutManager(new LinearLayoutManager(Page10.this,RecyclerView.HORIZONTAL,false));



        //second RecycleView Adpter list
        Image = findViewById(R.id.imagerecycle1);
        List<Drawable>list1 = new ArrayList<>();
        list1.add(getResources().getDrawable(R.drawable.imagep7));
        list1.add(getResources().getDrawable(R.drawable.image3));
        list1.add(getResources().getDrawable(R.drawable.image4));
        list1.add(getResources().getDrawable(R.drawable.icecream1));
        FoodImageAdpter adpter1 = new FoodImageAdpter(list1);
        Image.setAdapter(adpter1);
        Image.setLayoutManager(new LinearLayoutManager(Page10.this,RecyclerView.HORIZONTAL,false));




        //Third RecycleView Adpter List
        Nonvegview = findViewById(R.id.imagerecycle2);
        List<NonvegImage>list2 = new ArrayList<>();
        NonvegImage item = new NonvegImage("25% offers","Grilled Chiken","120 RS","https://i.ndtvimg.com/i/2015-12/grilled-chicken-625_625x350_71451368942.jpg");
        list2.add(item);
        NonvegImage item1 = new NonvegImage("50% offers","Mutton Korma","200 RS","https://i.ndtvimg.com/i/2015-03/badam-korma_625x350_41426244081.jpg");
        list2.add(item1);
        NonvegImage item2 = new NonvegImage("20% offers","Tandoori Lamb Chops","250 RS","https://i.ndtvimg.com/i/2016-06/lamb-chops_625x350_51466768845.jpg");
        list2.add(item2);
        NonvegImage item3 = new NonvegImage("30% offers","Malabar Fish Biryani","220 RS","https://i.ndtvimg.com/i/2016-11/biryani-620_620x350_41478678907.jpg");
        list2.add(item3);
        NonVegAdpter adpter2 = new NonVegAdpter(list2);
        Nonvegview.setAdapter(adpter2);
        Nonvegview.setLayoutManager(new LinearLayoutManager(Page10.this,RecyclerView.HORIZONTAL,false));




        //Fourt RecyleView Adpter List

        TextView vegfood = findViewById(R.id.vegfood);
        VegView = findViewById(R.id.imagerecycle3);
        List<NonvegImage>list3 = new ArrayList<>();
        NonvegImage item4 = new NonvegImage("30% offeres","Veg Biryani","150 RS","https://foodiewish.com/wp-content/uploads/2020/03/Vegetable-Biryani-foodiewish.jpg");
        list3.add(item4);
        NonvegImage item5 = new NonvegImage("30% offeres","Alu Puri","100 RS","https://foodiewish.com/wp-content/uploads/2020/03/Vegetarian-dishes-foodiewish.jpg");
        list3.add(item5);
        NonvegImage item6 = new NonvegImage("10% offeres","Khichdi","120 RS","https://foodiewish.com/wp-content/uploads/2020/03/Khichdi-foodiewish.jpg");
        list3.add(item6);
        NonvegImage item7 = new NonvegImage("40% offeres","Special Veg Biryani","250 RS","https://foodiewish.com/wp-content/uploads/2020/03/Vegetable-Biryani-foodiewish.jpg");
        list3.add(item7);
        NonVegAdpter adpter3 = new NonVegAdpter(list3);
        VegView.setAdapter(adpter3);
        VegView.setLayoutManager(new LinearLayoutManager(Page10.this,RecyclerView.HORIZONTAL,false));

        vegfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Page10.this,Page11.class);
                startActivity(intent);
            }
        });



        //fivth RecyleView Adpter List
        Starters = findViewById(R.id.imagerecycle4);
        List<NonvegImage>list4 = new ArrayList<>();
        NonvegImage image1 = new NonvegImage("2% OFF","Halwa","50 RS","https://foodiewish.com/wp-content/uploads/2020/03/Halwa-foodiewish.jpg");
        list4.add(image1);

        NonvegImage image2 = new NonvegImage("2% OFF","Halwa","50 RS","https://foodiewish.com/wp-content/uploads/2020/03/Halwa-foodiewish.jpg");
        list4.add(image2);

        NonvegImage image3 = new NonvegImage("2% OFF","Paratha","70 RS","https://foodiewish.com/wp-content/uploads/2020/03/Paratha-foodiewish-1536x1067.jpg");
        list4.add(image3);

        NonvegImage image4 = new NonvegImage("2% OFF","Momas","100 RS","https://foodiewish.com/wp-content/uploads/2020/03/Momos-foodiewish.jpg");
        list4.add(image4);




    }




    //FirstRecycleView Adpter class
    class ItemfoodAdpter extends RecyclerView.Adapter<ItemfoodAdpter.CustomViewHolder> {
        List<fooditem> list;

        public ItemfoodAdpter(List<fooditem> list) {
            this.list = list;

        }
        @NonNull
        @Override
        public ItemfoodAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(Page10.this).inflate(R.layout.imagepage10, parent, false);
            CustomViewHolder holder = new CustomViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemfoodAdpter.CustomViewHolder holder, int position) {
            holder.text.setText(list.get(position).getName());
            Glide.with(Page10.this).load(list.get(position).getImage()).into(holder.image);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView text;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.imagerecycle2);
                text = itemView.findViewById(R.id.text4page10);
            }
        }
    }




    //SecondRecycleView Adpter class
    class FoodImageAdpter extends RecyclerView.Adapter<FoodImageAdpter.CustomViewHolder>{
            List<Drawable> list1;

            public FoodImageAdpter(List<Drawable> list1) {
                this.list1 = list1;

            }

            @NonNull
            @Override
            public FoodImageAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
               View view = LayoutInflater.from(Page10.this).inflate(R.layout.image2page10,parent,false);
               CustomViewHolder holder = new CustomViewHolder(view);

                return holder;
            }

            @Override
            public void onBindViewHolder(@NonNull FoodImageAdpter.CustomViewHolder holder, int position) {
                holder.image.setImageDrawable(list1.get(position));
            }

            @Override
            public int getItemCount() {
                return list1.size();
            }

            public class CustomViewHolder extends RecyclerView.ViewHolder {
                ImageView image;
                public CustomViewHolder(@NonNull View itemView) {
                    super(itemView);
                    image = itemView.findViewById(R.id.image8);
                }
            }
        }





    //ThirdRecycleView Adpter class

    class NonVegAdpter extends RecyclerView.Adapter<NonVegAdpter.CustomViewHolder>{
        List<NonvegImage> list2;

        public NonVegAdpter(List<NonvegImage> list2) {
            this.list2 = list2;

        }

        @NonNull
        @Override
        public NonVegAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(Page10.this).inflate(R.layout.image3page10,parent,false);
       CustomViewHolder holder = new CustomViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull NonVegAdpter.CustomViewHolder holder, int position) {
            holder.offers.setText(list2.get(position).getOffer());
            holder.price.setText(list2.get(position).getPrice());
            holder.foodname.setText(list2.get(position).getFood_name());
            Glide.with(Page10.this).load(list2.get(position).getImage()).into(holder.image);


        }

        @Override
        public int getItemCount() {
            return list2.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView foodname;
            TextView price;
            TextView offers;
            TextView vegfood;
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);

                image = itemView.findViewById(R.id.image1page10);
                foodname = itemView.findViewById(R.id.text2page10);
                price = itemView.findViewById(R.id.text3page10);
                offers = itemView.findViewById(R.id.text1page10);


            }
        }
    }


}