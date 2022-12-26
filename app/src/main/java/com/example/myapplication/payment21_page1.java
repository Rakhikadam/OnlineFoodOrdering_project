package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public payment21_page1() {
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
    public static payment21_page1 newInstance(String param1, String param2) {
        payment21_page1 fragment = new payment21_page1();
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
        View view = inflater.inflate(R.layout.fragment_payment21_page1, container, false);
        RecyclerView recycler = view.findViewById(R.id.recyclepayment);
        List<pesronpayment>list = new ArrayList<>();
        pesronpayment payment = new pesronpayment("23344444","Rakhi","12-22-2023","333211","VISA");
        list.add(payment);

        PaymentlistAdpter adpter = new PaymentlistAdpter(list);
        recycler.setAdapter(adpter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));



        RadioButton button = view.findViewById(R.id.credit_debit);
        LinearLayout card = view.findViewById(R.id.card);
        LinearLayout cardinfo = view.findViewById(R.id.paymentinfo);
        Button add_card = view.findViewById(R.id.add_card);


       /* EditText cardnumber = view.findViewById(R.id.card_number);
        cardnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
cardnumber = Pattern.matches("")
            }
        });

        */




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





        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            TextView card_number,type;

            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                card_number = itemView.findViewById(R.id.card_number);
                type = itemView.findViewById(R.id.typecard);


            }
        }
    }
}