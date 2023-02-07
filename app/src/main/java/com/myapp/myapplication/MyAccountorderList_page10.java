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

import com.bumptech.glide.Glide;
import com.example.myapplication.model.CartItem;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyAccountorderList_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyAccountorderList_page10 extends Fragment {
    DBHelper helper;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyAccountorderList_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyAccountorderList_page10.
     */
    // TODO: Rename and change types and number of parameters
    public static MyAccountorderList_page10 newInstance(String param1, String param2) {
        MyAccountorderList_page10 fragment = new MyAccountorderList_page10();
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
            mParam1 = getArguments().getString("data");
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_accountorder_list_page10, container, false);
        RecyclerView recycler = view.findViewById(R.id.listorderitem);

         helper = new DBHelper(getContext());
         helper.BookingID(mParam1,"98");
         ListItemAdpter adpter = new ListItemAdpter(helper.BookingID(mParam1,"98"));
         recycler.setLayoutManager(new LinearLayoutManager(getContext()));
         recycler.setAdapter(adpter);


        return view;
    }
    class ListItemAdpter extends RecyclerView.Adapter<ListItemAdpter.CustomViewHolder>{
        List<CartItem> bookingID;

        public ListItemAdpter(List<CartItem> bookingID) {
            this.bookingID =bookingID;
        }

        @NonNull
        @Override
        public ListItemAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.ordersitem_page10,parent,false);
            CustomViewHolder holder = new CustomViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ListItemAdpter.CustomViewHolder holder, int position) {

            holder.name.setText(bookingID.get(position).getName());
            Glide.with(getContext()).load(bookingID.get(position).getImageUrl()).into(holder.image);
        }

        @Override
        public int getItemCount() {
            return bookingID.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.myorderimage1);
                name = itemView.findViewById(R.id.ordertext);
            }
        }
    }
}