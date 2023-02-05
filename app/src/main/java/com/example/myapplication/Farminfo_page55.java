package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Farminfo_page55#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Farminfo_page55 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    //change string to int
    private int mParam1;
    private String mParam2;
    JSONObject data;


    public Farminfo_page55() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Farminfo_page55.
     */
    // TODO: Rename and change types and number of parameters
    public static Farminfo_page55 newInstance(String param1, String param2) {
        Farminfo_page55 fragment = new Farminfo_page55();
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
            mParam1 = getArguments().getInt("ID");  //set key and change string to int and set same key both fragement
          //JSON set data in Arguments
           /* try {
                data = new JSONObject(getArguments().getString("data"));
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //first paste list of farm product in adpter
        View view= inflater.inflate(R.layout.fragment_farminfo_page55, container, false);
        List<farm> image4 = new ArrayList<>();


        /*farm list13 = new farm("Fresh Grapes","200Rs per/kg","https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg");
        image4.add(list13);
        farm list14 = new farm("Fresh Straberry","200Rs per/kg","https://m.media-amazon.com/images/I/61Xl3VVZjKL._SX679_.jpg");
        image4.add(list14);
        farm list15 = new farm("Fresh Apple","200Rs per/kg","https://blog-images-1.pharmeasy.in/blog/production/wp-content/uploads/2022/05/03114105/7-5.jpg");
        image4.add(list15);

         */

        //first set data
       /* ImageView imageView = view.findViewById(R.id.image_page55);
        Glide.with(getContext()).load(image4.get(mParam1).getImage()).into(imageView);

        TextView name = view.findViewById(R.id.text_page55);
        name.setText(image4.get(mParam1).getName());

        TextView price = view.findViewById(R.id.text1_page55);
        price.setText(image4.get(mParam1).getPrice());

        */

       /* //JSON set data
        ImageView imageView = view.findViewById(R.id.image_page55);
        try {
            Glide.with(getContext()).load(data.getString("Farmimage")).into(imageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        TextView name = view.findViewById(R.id.text_page55);
        try {
            name.setText(data.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView price = view.findViewById(R.id.text1_page55);
        try {
            price.setText(data.getString("price"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
*/

//both the list same
        //2.list page53
        List<farmlist>list = new ArrayList<>();
       /* farmlist image1 = new farmlist("Fresh Grapes","200Rs per/kg","https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg");
        list.add(image1);
        farmlist image2 = new farmlist("Fresh Straberry","200Rs per/kg","https://m.media-amazon.com/images/I/61Xl3VVZjKL._SX679_.jpg");
        list.add(image2);
        farmlist image3 = new farmlist("Fresh Apple","200Rs per/kg","https://blog-images-1.pharmeasy.in/blog/production/wp-content/uploads/2022/05/03114105/7-5.jpg");
        list.add(image3);

        */

   /*     ImageView image = view.findViewById(R.id.image_page55);
        Glide.with(getContext()).load(list.get(mParam1).getImage()).into(image);
        TextView price1 = view.findViewById(R.id.text1_page55);
        price1.setText(list.get(mParam1).getPrice());
        TextView name1 = view.findViewById(R.id.text_page55);
        name1.setText(list.get(mParam1).getName());

    */

      /*  ImageView image = view.findViewById(R.id.image_page55);
        try {
            Glide.with(getContext()).load(data.getString("Farmimage")).into(image);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView price1 = view.findViewById(R.id.text1_page55);
        try {
            price.setText(data.getString("price"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        TextView name1 = view.findViewById(R.id.text_page55);
        try {
            price.setText(data.getString("price"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

*/
        //SQLitedata get
        ImageView image = view.findViewById(R.id.image_page55);
        TextView price1 = view.findViewById(R.id.text1_page55);
        TextView name1 = view.findViewById(R.id.text_page55);

        DBHelper helper = new DBHelper(getContext());
       farminfo farm= helper.getFarm(String.valueOf(getArguments().getString("data")));
        name1.setText(farm.getName());
        price1.setText(farm.getPrice());
        Glide.with(getContext()).load(farm.getImage()).into(image);



        return view;
    }
}