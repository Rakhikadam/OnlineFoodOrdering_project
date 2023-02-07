package com.myapp.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Myorder_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Myorder_page10 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    DBHelper helper;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Myorder_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Myorder_page10.
     */
    // TODO: Rename and change types and number of parameters
    public static Myorder_page10 newInstance(String param1, String param2) {
        Myorder_page10 fragment = new Myorder_page10();
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
        View view= inflater.inflate(R.layout.fragment_myorder_page10, container, false);
         helper = new DBHelper(getContext());
        RecyclerView recycler = view.findViewById(R.id.orderrecycler);
        List<Booking>list =helper.getbookingorder("98");
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        OrderAdpter adpter = new OrderAdpter(list);
        recycler.setAdapter(adpter);


        return view;
    }
    class OrderAdpter extends RecyclerView.Adapter<OrderAdpter.CustomViewHolder>{
        List<Booking> list;

        public OrderAdpter(List<Booking> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public OrderAdpter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.myorderrecycler,parent,false);
            CustomViewHolder holder =  new CustomViewHolder(ABC);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull OrderAdpter.CustomViewHolder holder, int position) {
            holder.orderID.setText(list.get(position).getOrder_id());

            holder.orderID.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment1 = new MyAccountorderList_page10();
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",position);
                    bundle.putString("data",list.get(position).getOrder_id());
                    fragment1.setArguments(bundle);
                    transaction.replace(R.id.accountframe,fragment1);
                    transaction.commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder{
            TextView orderID;
            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);
                orderID = itemView.findViewById(R.id.orderid);
            }
        }
    }
}