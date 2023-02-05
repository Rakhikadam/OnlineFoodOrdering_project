package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplication.model.CartItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hotel_shoppingcart_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hotel_shoppingcart_page10 extends Fragment {
    HotelsPage10.ItemCartAddListner listner;
    List<CartItem> list= new ArrayList<>();
    ShoopingcarAdpter adpter;
    int Totalprice = 0;
    TextView price;
    TextView totalprice;
    JSONArray adddata;
    SharedPreferences.Editor editor;
    SharedPreferences preferences; //declare
    DBHelper helper;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public hotel_shoppingcart_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hotel_shoppingcart.
     */
    // TODO: Rename and change types and number of parameters
    public static hotel_shoppingcart_page10 newInstance(String param1, String param2) {
        hotel_shoppingcart_page10 fragment = new hotel_shoppingcart_page10();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper =new DBHelper(getContext());
         preferences = getContext().getSharedPreferences("MYAPP", Context.MODE_PRIVATE);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



       HotelsPage10 activity = (HotelsPage10) getActivity();
       activity.listner = new HotelsPage10.ItemCartAddListner() { //initalize listner
            @Override
            public void AddItem(CartItem item) {
                for (int i=0; i<list.size(); i++){
                    if (list.get(i).getName().equals(item.getName())){
                        listner.Update(item.getName(),item.getCount(),item.getId());
                        return;
                    }
                }

                CartItem shoppingcart = new CartItem(item.getId(),item.getName(),item.getImageUrl(),item.getPrice(),item.getCount(),item.getUser_id(),null);
                list.add(shoppingcart);
                helper.addcartItem(shoppingcart);
                adpter.notifyDataSetChanged(); //change the data n update new value

               update_total();
                Log.e(getClass().getSimpleName(), "AddItem: "+item.getName() );
                Log.e(getClass().getSimpleName(), "AddItem: "+item.getImageUrl() );
                Log.e(getClass().getSimpleName(), "AddItem: "+item.getPrice() );
            }

           @Override
           public void Update(String name, String quntity, String id) {
               for (int i=0; i<list.size(); i++){

                   if (list.get(i).getName().equals(name)){
//                       list.get(i).getName().equals(name);
                       list.get(i).setCount(quntity);
                       if (quntity.equals("0")){
                           helper.DeleteCart(list.get(i).getId());
                           list.remove(i);
                       }
//                       helper.Update(list.get(i).getId(),quntity);  //SQlite update method call
                      Log.e("TAG",quntity);
                       adpter.notifyDataSetChanged();

                       update_total();

                   }
               }

           }

         /*  @Override
            public void Update(String name, String quntity) {

            }
       */ };

        listner = activity.listner;   //assign listner of main activity to this activity


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hotel_shoppingcart, container, false);

        RecyclerView cart = view.findViewById(R.id.cart);

       totalprice = view.findViewById(R.id.totalprice);
    //    TextView checkout = view.findViewById(R.id.checkout);





        //get Shareprefernce data in cart
      /*  try {
            adddata = new JSONArray(preferences.getString("CARTLIST","[]"));
            editor = preferences.edit();

            for (int i = 0; i<adddata.length(); i++){
                JSONObject object = adddata.getJSONObject(i);
                shoppingcart cartlist = new shoppingcart(object.getString("name"),object.getString("price"),object.getString("Image"));
                list.add(cartlist);
                update_total();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
*/

//        shoppingcart image1 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
//        list.add(image1);
//        shoppingcart image2 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
//        list.add(image2);
//        shoppingcart image3 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
//        list.add(image3);
//        shoppingcart image4 = new shoppingcart("Paneer", "150Rs", "https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg");
//        list.add(image4);
        cart.setLayoutManager(new LinearLayoutManager(getContext()));
        list= helper.getcartItem("98");
        adpter = new ShoopingcarAdpter(list);//usig SQLite method
        cart.setAdapter(adpter);


        //checkout button set listner
        Button checkout = view.findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //put totalamount price using shredprefernce
                editor = preferences.edit();
                editor.putString("TOTAL",totalprice.getText().toString());
                editor.commit();


                //Intent convert class
                Intent intent = new Intent(getActivity(),Page21.class);
                startActivity(intent);
            }
        });




        return view;
    }


    //
    class  ShoopingcarAdpter extends RecyclerView.Adapter<ShoopingcarAdpter.CustomAdpterHolder>{
    List<CartItem> list;  //change the typeof list name using SQLite
       // List<shoppingcart> list;
    public ShoopingcarAdpter(List<CartItem> list) {
       // this.list = list;
        this.list = list;

    }

    @NonNull
    @Override
    public ShoopingcarAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.shoppingcartlist_page10,parent,false);

        CustomAdpterHolder holder = new CustomAdpterHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShoopingcarAdpter.CustomAdpterHolder holder, int position) {

        holder.price.setText(list.get(position).getPrice());
        holder.name.setText(list.get(position).getName());
        holder.count.setText(list.get(position).getCount());
       // Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);
        Glide.with(getContext()).load(list.get(position).getImageUrl()).into(holder.image);







      holder.plus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int value = Integer.parseInt(String.valueOf(holder.count.getText().toString()));
              if (value<10){
                  value = value+1;
                  holder.count.setText(String.valueOf(value));
              }
              else {
                  Toast.makeText(getActivity(), "maxium value exceed", Toast.LENGTH_SHORT).show();
              }
              //add ID in update method using Sqlite
              listner.Update(list.get(position).getName(),holder.count.getText().toString(),list.get(position).getId());
              helper.Update(list.get(position).getName(),list.get(position).getCount());  //SQlite update method call

          }
      });

      holder.minus.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int value1 = Integer.parseInt(String.valueOf(holder.count.getText().toString()));
              if (value1>1){
                  value1 = value1-1;
                  holder.count.setText(String.valueOf(value1));
//                  helper.Update(list.get(position).getId(),list.get(position).getCount());
                  //add ID in update method using Sqlite
                  listner.Update(list.get(position).getName(),holder.count.getText().toString(),list.get(position).getId());
                  helper.Update(list.get(position).getId(),list.get(position).getCount());  //SQlite update method call

              }
              else {
                  JSONArray array = new JSONArray();   //removelist in shoopingcart
                  try {
                      array = new JSONArray(preferences.getString("CARTLIST","[]"));
                      array.remove(position);
                      helper.DeleteCart(list.get(position).getId());//Delete shoopingcart item using SQL
                      list.remove(position);
                      editor = preferences.edit();
                      editor.putString("CARTLIST",array.toString());
                      editor.commit();


                      // update_total();

                  } catch (JSONException e) {
                      e.printStackTrace();
                  }

//                  list.remove(i);
                  update_total();   //new value n list updated
                  adpter.notifyDataSetChanged();




                  //Toast.makeText(getActivity(), "Add value", Toast.LENGTH_SHORT).show();
              }

          }
      });




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomAdpterHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView price;
        TextView count,minus,plus;

        public CustomAdpterHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.shoppingimage1);
            name= itemView.findViewById(R.id.carttext);
            count= itemView.findViewById(R.id.count);
            price = itemView.findViewById(R.id.cartprise);
            minus = itemView.findViewById(R.id.minuscart);
            plus = itemView.findViewById(R.id.addcart);

        }
    }
}

//GST add total amount
public void update_total(){
        int total = 0;
        for (int i=0; i< list.size();i++){
          //  total = total+Integer....
            total += Integer.parseInt(list.get(i).getCount()) * Integer.parseInt(list.get(i).getPrice().replace("RS",""));

        }
        total = (int) ((total*0.18)+total);
        totalprice.setText(total+"RS");


    }
}