package com.myapp.myapplication;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reviewpage13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reviewpage13 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Reviewpage13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reviewpage13.
     */
    // TODO: Rename and change types and number of parameters
    public static Reviewpage13 newInstance(String param1, String param2) {
        Reviewpage13 fragment = new Reviewpage13();
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
        View view = inflater.inflate(R.layout.fragment_reviewpage13, container, false);
        RecyclerView recycler = view.findViewById(R.id.reviewewcycle);
        List<reviewlist> list = new ArrayList<>();
        reviewlist user = new reviewlist("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user);
        reviewlist user1 = new reviewlist("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "3");
        list.add(user1);
        reviewlist user2 = new reviewlist("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user2);
        reviewlist user3 = new reviewlist("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user3);
        reviewlist user4 = new reviewlist("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user4);
        reviewlist user5 = new reviewlist("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user5);
        reviewlist user6 = new reviewlist("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user6);
       //Initalize adpter
        ReviewAdpter adpter = new ReviewAdpter(list);
        recycler.setAdapter(adpter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Button reviewbutton = view.findViewById(R.id.addreview);
        reviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog customdialog = new Dialog(getContext());
                customdialog.setContentView(R.layout.addreviewpage13);
                customdialog.show();

            }
        });

        return view;
    }


    class ReviewAdpter extends RecyclerView.Adapter<ReviewAdpter.CustomviewHolder> {
        List<reviewlist> list;

        public ReviewAdpter(List<reviewlist> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public ReviewAdpter.CustomviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABc = LayoutInflater.from(getContext()).inflate(R.layout.reviewlistpage13, parent, false);
            CustomviewHolder holder = new CustomviewHolder(ABc);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ReviewAdpter.CustomviewHolder holder, int position) {
            holder.date.setText(list.get(position).getDate());
            holder.name.setText(list.get(position).getName());
            holder.message.setText(list.get(position).getMessage());
            holder.comment.setText(list.get(position).getComments());
//set star background using case
            Log.e("TAG",(list.get(position).getStar()));
            switch (list.get(position).getStar()) {
                case "1":
                    holder.ll_star.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.gray));
                    holder.ll_star.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.gray));
                    holder.ll_star.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.gray));
                    holder.ll_star.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.gray));
                    break;
                case "2":
                  holder.ll_star.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.green));
                  holder.ll_star.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.green));
                  holder.ll_star.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.gray));
                  holder.ll_star.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.gray));
                  holder.ll_star.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.gray));
                  break;

                case "3":
                    holder.ll_star.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.gray));
                    holder.ll_star.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.gray));
                    break;

                case "4":
                    holder.ll_star.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.gray));
                    break;

                case "5":
                    holder.ll_star.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(2).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(3).setBackgroundColor(getResources().getColor(R.color.green));
                    holder.ll_star.getChildAt(4).setBackgroundColor(getResources().getColor(R.color.green));
                    break;
            }
            Glide.with(getContext()).load(list.get(position).getProfile()).into(holder.profile);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomviewHolder extends RecyclerView.ViewHolder {
            ImageView profile;
            LinearLayout ll_star;
            TextView name, comment, message, date;

            public CustomviewHolder(@NonNull View itemView) {
                super(itemView);
                profile = itemView.findViewById(R.id.profilereview);
                name = itemView.findViewById(R.id.text1review);
                comment = itemView.findViewById(R.id.text3review);
                message = itemView.findViewById(R.id.text4review);
                date = itemView.findViewById(R.id.text2review);
                ll_star = itemView.findViewById(R.id.ll_star);

            }
        }
    }
}