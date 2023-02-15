package com.myapp.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link payment21_page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class payment21_page1 extends Fragment {
    OnPageChangedListner listner;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    DBHelper helper;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public payment21_page1(OnPageChangedListner listner) {
        this.listner = listner;
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment payment21_page1.
     */
    // TODO: Rename and change types and number of parameters
   /* public static payment21_page1 newInstance(String param1, String param2) {
        payment21_page1 fragment = new payment21_page1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getContext().getSharedPreferences("MYAPP", Context.MODE_PRIVATE);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        helper = new DBHelper(getContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment21_page1, container, false);
        RecyclerView recycler = view.findViewById(R.id.recyclepayment);
        List<pesronpayment>list = new ArrayList<>();
         /*
         5555  - visa
         4444 - master
         3333 - rupay
         2222 - AMEX
          */
        pesronpayment payment = new pesronpayment("5555 1234 5678","Rakhi","12-22-2023","333211","VISA");
        pesronpayment payment2 = new pesronpayment("4444 1234 5678","Rakhi","12-22-2023","333211","VISA");
        pesronpayment payment3 = new pesronpayment("3333 1234 5678","Rakhi","12-22-2023","333211","VISA");
        pesronpayment payment4 = new pesronpayment("2222 1234 5678","Rakhi","12-22-2023","333211","VISA");
        list.add(payment);
        list.add(payment2);
        list.add(payment3);
        list.add(payment4);
        PaymentlistAdpter adpter = new PaymentlistAdpter(list);
        recycler.setAdapter(adpter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));



        RadioButton button = view.findViewById(R.id.credit_debit);
        LinearLayout card = view.findViewById(R.id.card);
        LinearLayout cardinfo = view.findViewById(R.id.paymentinfo);
        Button add_card = view.findViewById(R.id.add_card);
        Button paynow = view.findViewById(R.id.paynow);
        LinearLayout addresslist = view.findViewById(R.id.addresspay);

        //getting total amount price
        TextView price = view.findViewById(R.id.payprice);
        editor = preferences.edit();
        price.setText(preferences.getString("TOTAL",""));



//getting addresslist of sharedprefernce
        editor = preferences.edit();




        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){

                    card.setVisibility(View.VISIBLE);
                } else{

                    card.setVisibility(View.GONE);
                    cardinfo.setVisibility(View.GONE);
                }
            }
        });



        add_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardinfo.setVisibility(View.VISIBLE);
                card.setVisibility(View.GONE);
            }
        });



         paynow.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 listner.OnPageChanged(2);
               long order_id =  System.currentTimeMillis();
               helper.UpdateCart(String.valueOf(order_id));
              // helper.addbookingOrder("98", String.valueOf(order_id));
               editor = preferences.edit();
               helper.addbookingOrder(preferences.getString("number",""),String.valueOf(order_id));



             }
         });


        return view;
    }




    class PaymentlistAdpter extends RecyclerView.Adapter<PaymentlistAdpter.CustomViewHolder>{
        List<pesronpayment> list;

        public PaymentlistAdpter(List<pesronpayment> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public PaymentlistAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View ABC = LayoutInflater.from(getContext()).inflate(R.layout.cardinfo_page21,parent,false);
           CustomViewHolder holder = new CustomViewHolder(ABC);
           return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull PaymentlistAdpter.CustomViewHolder holder, int position) {

            holder.type.setText(list.get(position).getType());
            holder.card_number.setText(list.get(position).getCard_number());

            //using subString method .add list in credit card and spilit different card type

            Log.e("TAG",list.get(position).getCard_number().substring(0,3));//show input in logcat
            if (list.get(position).getCard_number().substring(0,4).equalsIgnoreCase("5555")){
                holder.type.setText("VISA");
                holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.visa));
            }

              if (list.get(position).getCard_number().substring(0,4).equalsIgnoreCase("4444")){
                holder.type.setText("MASTER");
                holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.master));
            }


              if (list.get(position).getCard_number().substring(0,4).equalsIgnoreCase("3333")){
                holder.type.setText("RUPAY");
                holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.rupay));
            }

              if (list.get(position).getCard_number().substring(0,4).equalsIgnoreCase("2222")){
                holder.type.setText("AMAX");
                holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.amax));
            }
//OR
//using spilt method add list into creditcard and spilt of different type card
         /*  if (list.get(position).getCard_number().split(" ")[0].equalsIgnoreCase("5555")){
               holder.type.setText("VISA");
               holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.visa));
           }
            if (list.get(position).getCard_number().split(" ")[0].equalsIgnoreCase("4444")){
                holder.type.setText("MASTER");
                holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.master));
            }
            if (list.get(position).getCard_number().split(" ")[0].equalsIgnoreCase("3333")){
                holder.type.setText("RUPAY");
                holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.rupay));
            }
            if (list.get(position).getCard_number().split(" ")[0].equalsIgnoreCase("2222")){
                holder.type.setText("AMEX");
               holder.card_img.setImageDrawable(getResources().getDrawable(R.drawable.rupay));
            }

          */





        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            TextView card_number,type;
            ImageView card_img;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                card_number = itemView.findViewById(R.id.card_number);
                type = itemView.findViewById(R.id.typecard);
                card_img = itemView.findViewById(R.id.card_img);


            }
        }
    }
}