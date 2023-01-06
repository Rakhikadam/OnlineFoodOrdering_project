package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hotelHome_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hotelHome_page10 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public hotelHome_page10() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hotelHome_page10.
     */
    // TODO: Rename and change types and number of parameters
    public static hotelHome_page10 newInstance(String param1, String param2) {
        hotelHome_page10 fragment = new hotelHome_page10();
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
        View view = inflater.inflate(R.layout.fragment_hotel_home_page10, container, false);
        //firstrecycler view
        RecyclerView recycler = view.findViewById(R.id.himagerecycle);
        List<hotellist> list = new ArrayList<>();
        hotellist list1 = new hotellist("Restaurant Food", "https://media.istockphoto.com/id/104704117/photo/restaurant-plates.jpg?s=1024x1024&w=is&k=20&c=E3R2zzqMOSjWHIxUg07jTbs3BiGVcurZGiV_xHdk3YI=");
        list.add(list1);
        hotellist list2 = new hotellist("Homemade Food", "https://media.istockphoto.com/id/104704117/photo/restaurant-plates.jpg?s=1024x1024&w=is&k=20&c=E3R2zzqMOSjWHIxUg07jTbs3BiGVcurZGiV_xHdk3YI=");
        list.add(list2);
        hotellist list3 = new hotellist("Farm Product", "https://media.istockphoto.com/id/104704117/photo/restaurant-plates.jpg?s=1024x1024&w=is&k=20&c=E3R2zzqMOSjWHIxUg07jTbs3BiGVcurZGiV_xHdk3YI=");
        list.add(list3);
        hotellist list4 = new hotellist("Gift Items", "https://media.istockphoto.com/id/104704117/photo/restaurant-plates.jpg?s=1024x1024&w=is&k=20&c=E3R2zzqMOSjWHIxUg07jTbs3BiGVcurZGiV_xHdk3YI=");
        list.add(list4);
        ItemAdpter adpter = new ItemAdpter(list);
        recycler.setAdapter(adpter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));


        //Second recyclerview

        RecyclerView recycler1 = view.findViewById(R.id.himagerecycle1);
        List<Drawable> image = new ArrayList<>();
        image.add(getResources().getDrawable(R.drawable.imagep7));
        image.add(getResources().getDrawable(R.drawable.image3));
        image.add(getResources().getDrawable(R.drawable.image4));
        image.add(getResources().getDrawable(R.drawable.icecream1));
        ImagelistAdpter adpter1 = new ImagelistAdpter(image);
        recycler1.setAdapter(adpter1);
        recycler1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        //Third recyclerview
        RecyclerView recycler2 = view.findViewById(R.id.himagerecycle2);
        List<restaurant> image2 = new ArrayList<>();
        restaurant list5 = new restaurant("Alpha hotel", "30% OFF ", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list5);
        restaurant list6 = new restaurant("Star hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list6);
        restaurant list7 = new restaurant("Blue hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list7);
        restaurant list8 = new restaurant("Alpha hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list8);
        RestaturantAdpter adpter2 = new RestaturantAdpter(image2);
        recycler2.setAdapter(adpter2);
        recycler2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));


        //Fourth recyclerview
        RecyclerView recycler3 = view.findViewById(R.id.himagerecycle3);
        List<restaurant> image3 = new ArrayList<>();
        restaurant list9 = new restaurant("Adisha Tiffin Service", "30% OFF", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Indian_food_%22Parathaaaaaaaaaaa%22.jpg/640px-Indian_food_%22Parathaaaaaaaaaaa%22.jpg");
        image3.add(list9);
        restaurant list10 = new restaurant("Vanita Tiffin Service", "30% OFF", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Indian_food_%22Parathaaaaaaaaaaa%22.jpg/640px-Indian_food_%22Parathaaaaaaaaaaa%22.jpg");
        image3.add(list10);
        restaurant list11 = new restaurant("Jay Tiffin Service", "30% OFF", "https://images.jdmagicbox.com/comp/def_content/tiffin_services/default-tiffin-services-8.jpg?clr=");
        image3.add(list11);
        restaurant list12 = new restaurant("Adisha Tiffin Service", "30% OFF", "https://lh3.googleusercontent.com/p/AF1QipNdPWUpjTrLKU7eCylEHyd75-WT3ET0dRsPtZHU=w1080-h608-p-no-v0");
        image3.add(list12);
        RestaturantAdpter adpter3 = new RestaturantAdpter(image3);
        recycler3.setAdapter(adpter3);
        recycler3.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));


        //Fivth recyclerview

        RecyclerView recycler4 = view.findViewById(R.id.himagerecycle4);
        List<farm> image4 = new ArrayList<>();
        farm list13 = new farm("Fresh Grapes", "200Rs per/kg", "https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg");
        image4.add(list13);
        farm list14 = new farm("Fresh Straberry", "200Rs per/kg", "https://m.media-amazon.com/images/I/61Xl3VVZjKL._SX679_.jpg");
        image4.add(list14);
        farm list15 = new farm("Fresh Apple", "200Rs per/kg", "https://blog-images-1.pharmeasy.in/blog/production/wp-content/uploads/2022/05/03114105/7-5.jpg");
        image4.add(list15);
        FarmProductAdpter adpter4 = new FarmProductAdpter(image4);
        recycler4.setAdapter(adpter4);
        recycler4.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));


        //using viewall textview clicklistner
        TextView viewall1 = view.findViewById(R.id.llviewall1);
        viewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,new HotelList_page53());
                transaction.commit();
            }
        });

        TextView viewall2 = view.findViewById(R.id.ll_viewall2);
        viewall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Page11.class);
                startActivity(intent);
            }
        });

        //farm productviewall using clicklistner
        TextView viewall3 = view.findViewById(R.id.ll_viewall3);
        viewall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, new FarmProduct_page53());
                transaction.commit();
            }
        });


        return view;
    }



    //first recycler class adpter
    class ItemAdpter extends RecyclerView.Adapter<ItemAdpter.CustomAdpterHolder> {
        List<hotellist> list;

        public ItemAdpter(List<hotellist> list) {
            this.list = list;

        }

        @NonNull
        @Override
        public ItemAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View ABC = LayoutInflater.from(getContext()).inflate(R.layout.imagepage10, parent, false);
            CustomAdpterHolder holder = new CustomAdpterHolder(ABC);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemAdpter.CustomAdpterHolder holder, int position) {

            holder.food.setText(list.get(position).getName());
            Glide.with(getContext()).load(list.get(position).getImage()).into(holder.image);

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView food;

            public CustomAdpterHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.imagerecycle2);
                food = itemView.findViewById(R.id.text4page10);

            }
        }
    }

    //second recyclerview adpter
    class ImagelistAdpter extends RecyclerView.Adapter<ImagelistAdpter.CustomAdpterHolder> {
        List<Drawable> image;

        public ImagelistAdpter(List<Drawable> image) {
            this.image = image;
        }

        @NonNull
        @Override
        public ImagelistAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.image2page10, parent, false);

            CustomAdpterHolder holder = new CustomAdpterHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ImagelistAdpter.CustomAdpterHolder holder, int position) {

            holder.image.setImageDrawable(image.get(position));

        }

        @Override
        public int getItemCount() {
            return image.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder {
            ImageView image;

            public CustomAdpterHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.image8);

            }
        }
    }

    //Third recyclerview adpter
    class RestaturantAdpter extends RecyclerView.Adapter<RestaturantAdpter.CustomAdpterHolder> {
        List<restaurant> image2;

        public RestaturantAdpter(List<restaurant> image2) {
            this.image2 = image2;

        }

        @NonNull
        @Override
        public RestaturantAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View A = LayoutInflater.from(getContext()).inflate(R.layout.imagepagenew10, parent, false);
            CustomAdpterHolder holder = new CustomAdpterHolder(A);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RestaturantAdpter.CustomAdpterHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.name.setText(image2.get(position).getName());
            holder.offer.setText(image2.get(position).getOffer());
            Glide.with(getContext()).load(image2.get(position).getImage()).into(holder.image);

            holder.relative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new FragementNew_page13();
                    Bundle bundle = new Bundle();
                    bundle.putInt("id", position);
                    bundle.putString("key", "hotelinfo");
                    fragment.setArguments(bundle);
                    transaction.replace(R.id.frame, fragment);
                    transaction.commit();

                }
            });


        }

        @Override
        public int getItemCount() {
            return image2.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name;
            TextView offer;
            RelativeLayout relative;

            public CustomAdpterHolder(@NonNull View itemView) {
                super(itemView);
                image = itemView.findViewById(R.id.fimage1page10);
                name = itemView.findViewById(R.id.ftext2page10);
                offer = itemView.findViewById(R.id.ftext1page10);
                relative = itemView.findViewById(R.id.realitive1);
            }
        }
    }



   //fivth class

    class FarmProductAdpter extends RecyclerView.Adapter<FarmProductAdpter.CustomAdpterHolder> {
        List<farm> image4;

        public FarmProductAdpter(List<farm> image4) {
            this.image4 = image4;

        }

        @NonNull
        @Override
        public FarmProductAdpter.CustomAdpterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.farmproductpage10, parent, false);
            CustomAdpterHolder holder = new CustomAdpterHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull FarmProductAdpter.CustomAdpterHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.name.setText(image4.get(position).getName());
            holder.price.setText(image4.get(position).getPrice());
            Glide.with(getContext()).load(image4.get(position).getImage()).into(holder.image);
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment fragment = new Farminfo_page55();
                    Bundle bundle = new Bundle();
                    bundle.putInt("ID", position);
                    bundle.putString("key", "farmproduct");
                    fragment.setArguments(bundle);
                    transaction.replace(R.id.frame, fragment);
                    transaction.commit();


                }
            });


        }

        @Override
        public int getItemCount() {
            return image4.size();
        }

        public class CustomAdpterHolder extends RecyclerView.ViewHolder {
            ImageView image;
            TextView name, price;
            LinearLayout layout;

            public CustomAdpterHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.ftext2page11);
                price = itemView.findViewById(R.id.ftext3page11);
                image = itemView.findViewById(R.id.fimage1page11);
                layout = itemView.findViewById(R.id.linearfarm);

            }
        }
    }


}