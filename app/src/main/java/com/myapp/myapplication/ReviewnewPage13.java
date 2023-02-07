package com.myapp.myapplication;

import android.app.Dialog;
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

import org.json.JSONArray;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewnewPage13#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewnewPage13 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private JSONArray reviewdata;
    private String mParam2;

    public ReviewnewPage13() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReviewnewPage13.
     */
    // TODO: Rename and change types and number of parameters
    public static ReviewnewPage13 newInstance(String param1, String param2) {
        ReviewnewPage13 fragment = new ReviewnewPage13();
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
           /* try {
                reviewdata = new JSONArray(getArguments().getString("Review"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
           */
            mParam2 = getArguments().getString("data");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reviewnew_page13, container, false);
        RecyclerView recyclernew = view.findViewById(R.id.ll_reviewewcycle);
       // List<reviewlistnew> list = new ArrayList<>();

/*
//JSON method
        try {
            reviewdata = new JSONArray(getArguments().getString("Review"));
            for (int i = 0; i<reviewdata.length();i++){
                JSONObject object = reviewdata.getJSONObject(i);
                reviewlistnew review = new reviewlistnew(object.getString("profile"),object.getString("name"),object.getString("Title"),object.getString("date"),object.getString("Decripition"),object.getString("reviewAverage"));
           list.add(review);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
*/


       /* reviewlistnew user = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user);
        reviewlistnew user1 = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user1);
        reviewlistnew user2 = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user2);
        reviewlistnew user3 = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user3);
        reviewlistnew user4 = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user4);
        reviewlistnew user5 = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user5);
        reviewlistnew user6 = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user6);
        reviewlistnew user7 = new reviewlistnew("https://upload.wikimedia.org/wikipedia/commons/b/b6/Image_created_with_a_mobile_phone.png", "Rakhi kadam", "Food is realy amizing", "22 Dec 2023", "Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch", "4");
        list.add(user7);

      */
      /*  ReviewnewAdpter adpter = new ReviewnewAdpter(list);
        recyclernew.setAdapter(adpter);
      */
        //recyclernew.setLayoutManager(new LinearLayoutManager(getContext()));

        Button reviewbutton = view.findViewById(R.id.ll_addreview);
        reviewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog customdialog = new Dialog(getContext());
                customdialog.setContentView(R.layout.addreviewpage13);
                customdialog.show();

            }
        });

        //SQLite method
        DBHelper helper = new DBHelper(getContext());
        List<Review>getReviewinfo =helper.getReviewinfo(getArguments().getString("data"),getArguments().getString("type"));
    recyclernew.setLayoutManager(new LinearLayoutManager(getContext()));
      ReviewnewAdpter adpter = new ReviewnewAdpter(getReviewinfo);
       recyclernew.setAdapter(adpter);


        return view;
    }
    class ReviewnewAdpter extends RecyclerView.Adapter<ReviewnewAdpter.CustomAdpterHolder>{

       // List<reviewlistnew> list;
       List<Review> list;

        public ReviewnewAdpter(List<Review> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public ReviewnewAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABc = LayoutInflater.from(getContext()).inflate(R.layout.reviewlistpage13, parent, false);
            CustomAdpterHolder holder = new CustomAdpterHolder(ABc);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ReviewnewAdpter.CustomAdpterHolder holder, int position) {

            holder.date.setText(list.get(position).getDate());
            holder.name.setText(list.get(position).getName());
           /* holder.message.setText(list.get(position).getMessage());
            holder.comment.setText(list.get(position).getComments());
            Glide.with(getContext()).load(list.get(position).getProfile()).into(holder.profile);
*/
            holder.message.setText(list.get(position).getTitle());
            holder.comment.setText(list.get(position).getDecription());
            Glide.with(getContext()).load(list.get(position).getImage()).into(holder.profile);


            //set star background using case

          //  Log.e("TAG",(list.get(position).getReviewaverage()));
            //switch (list.get(position).getStar()) {
          /*  switch (list.get(position).getReviewaverage()) {
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
          */ // Glide.with(getContext()).load(list.get(position).getProfile()).into(holder.profile);
            Glide.with(getContext()).load(list.get(position).getImage()).into(holder.profile);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder{
            ImageView profile;
            LinearLayout ll_star;
            TextView name, comment, message, date;

            public CustomAdpterHolder(@NonNull View itemView) {
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