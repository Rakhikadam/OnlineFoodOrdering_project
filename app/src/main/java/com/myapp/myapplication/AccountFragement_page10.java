package com.myapp.myapplication;

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

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragement_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragement_page10 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccountFragement_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragement_page10.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragement_page10 newInstance(String param1, String param2) {
        AccountFragement_page10 fragment = new AccountFragement_page10();
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
        View view = inflater.inflate(R.layout.fragment_account_fragement_page10, container, false);
        RecyclerView accountlist = view.findViewById(R.id.accountrecycle);
        List<personaccount>list = new ArrayList<>();
        list.add(new personaccount((R.drawable.fav),"My Orders"));
        list.add(new personaccount((R.drawable.fav),"My Wishlist"));
        list.add(new personaccount((R.drawable.fav),"Address Book"));
        list.add(new personaccount((R.drawable.fav),"My Reviews"));
        list.add(new personaccount((R.drawable.fav),"My Booking"));
        list.add(new personaccount((R.drawable.fav),"Track Orders"));
        list.add(new personaccount((R.drawable.fav),"Refer a friend"));
        list.add(new personaccount((R.drawable.fav),"Help"));
        list.add(new personaccount((R.drawable.fav),"Log Out"));



        accountlist.setLayoutManager(new LinearLayoutManager(getContext()));
        AccountAdpter adpter = new AccountAdpter(list);
        accountlist.setAdapter(adpter);


   return view;
    }

    class AccountAdpter extends RecyclerView.Adapter<AccountAdpter.CustomAdpterHolder>{
        List<personaccount> list;

        public AccountAdpter(List<personaccount> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public AccountAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View B = LayoutInflater.from(getContext()).inflate(R.layout.accountnewpage10,parent,false);
            CustomAdpterHolder holder = new CustomAdpterHolder(B);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull AccountAdpter.CustomAdpterHolder holder, int position) {
            holder.text.setText(list.get(position).getText());




        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder {
            ImageView image ;
            TextView text ;
            public CustomAdpterHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.iamgef);
                text = itemView.findViewById(R.id.tectf);
            }
        }
    }
}