package com.myapp.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Page11 extends AppCompatActivity {
    RecyclerView recyle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page11);
        recyle1 = findViewById(R.id.recycle2page11);
        List<Itempage11>list = new ArrayList<>();
        Itempage11 item1 = new Itempage11("Veg Biryani","150Rs","https://foodiewish.com/wp-content/uploads/2020/03/Vegetable-Biryani-foodiewish.jpg");
        list.add(item1);
        Itempage11 item2 = new Itempage11("Alu Puri","100 RS","https://foodiewish.com/wp-content/uploads/2020/03/Vegetarian-dishes-foodiewish.jpg");
        list.add(item2);
        Itempage11 item3 = new Itempage11("Khichdi","120 RS","https://foodiewish.com/wp-content/uploads/2020/03/Khichdi-foodiewish.jpg");
        list.add(item3);
        Itempage11 item4 = new Itempage11("Special Veg Biryani","250 RS","https://foodiewish.com/wp-content/uploads/2020/03/Vegetable-Biryani-foodiewish.jpg");
        list.add(item4);
        FoodAdpter adpter = new FoodAdpter(list);
        recyle1.setAdapter(adpter);
        recyle1.setLayoutManager(new LinearLayoutManager(Page11.this));



     //setonclicklistner in filter activity
        ImageView fliter = findViewById(R.id.filiter);
        fliter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog customdialog = new Dialog(Page11.this);
                customdialog.setContentView(R.layout.filterpage11);
                customdialog.show();
            }
        });



    }

    class FoodAdpter extends RecyclerView.Adapter<FoodAdpter.CustomAdpter>{
        List<Itempage11> list;

        public FoodAdpter(List<Itempage11> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public FoodAdpter.CustomAdpter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(Page11.this).inflate(R.layout.imagepage11,parent,false);
           CustomAdpter holder = new CustomAdpter(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FoodAdpter.CustomAdpter holder, int position) {
            holder.foodname.setText(list.get(position).getFood_name());
            holder.prise.setText(list.get(position).getPrise());
            Glide.with(Page11.this).load(list.get(position).getImage()).into(holder.image);
            holder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.ll_page11,new FragementNew_page13());
                    transaction.commit();
                     }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomAdpter extends RecyclerView.ViewHolder{
            ImageView image;
            TextView foodname;
            TextView prise;
           // RelativeLayout imagess;

            public CustomAdpter(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image1page11);
                foodname = itemView.findViewById(R.id.text2page11);
                prise = itemView.findViewById(R.id.text3page11);
              //  imagess = itemView.findViewById(R.id.ll_image11);
            }
        }
    }
}