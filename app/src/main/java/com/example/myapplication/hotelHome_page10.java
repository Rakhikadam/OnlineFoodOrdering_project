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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hotelHome_page10#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hotelHome_page10 extends Fragment {

    //JSON list of Arraylist
    /*String dataList = "[\n" +
            "  {\n" +
            "    \"hotelimage\": \"https://www.itchotels.com/content/dam/itchotels/in/umbrella/images/headmast-desktop/welcomhotel-bhubaneswar.jpg\",\n" +
            "    \"hotelname\": \"Alpha hotel\",\n" +
            "    \"offers\": \"25% OFF\",\n" +
            "    \"hotelphotos\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"Review\": [\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"22 Dec 2023\",\n" +
            "        \"name\": \"Rakhi kadam\",\n" +
            "        \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "        \"reviewAverage\": \"4.5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"22 Dec 2023\",\n" +
            "        \"name\": \"Rakhi kadam\",\n" +
            "        \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "        \"reviewAverage\": \"4.5\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"About\": {\n" +
            "      \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "      \"Cuisine\": [\n" +
            "        \"Cafe\",\n" +
            "        \"Salad\",\n" +
            "        \"Fast food\",\n" +
            "        \"Dessert\"\n" +
            "      ],\n" +
            "      \"Type\": [\n" +
            "        \"Breakfast\",\n" +
            "        \"Fine Dinning\",\n" +
            "        \"Luxuray Dinning\",\n" +
            "        \"Breakfast Buffect\"\n" +
            "      ],\n" +
            "      \"Address\": \"G1 , Ground flooe P.M.G. Road , Bhandup(w)\",\n" +
            "      \"Number\": \"912346544\",\n" +
            "      \"Average Cost\": \"500RS for two people\",\n" +
            "      \"Facilities\": [\n" +
            "        \"wifi\",\n" +
            "        \"AC\",\n" +
            "        \"Card pay\",\n" +
            "        \"hot water\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Menulist\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "        \"name\": \"Paneer\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"MainCourse\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "        \"name\": \"Ice-Cream\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Desserts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "        \"name\": \"Idle\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Starters\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "        \"name\": \"Noddles\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Chiness\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"hotelimage\": \"https://www.itchotels.com/content/dam/itchotels/in/umbrella/images/headmast-desktop/welcomhotel-bhubaneswar.jpg\",\n" +
            "    \"hotelname\": \"Star hotel\",\n" +
            "    \"offers\": \"30% OFF\",\n" +
            "    \"hotelphotos\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"Review\": [\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"31 Dec 2022\",\n" +
            "        \"name\": \"XYZ XYZ\",\n" +
            "        \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "        \"reviewAverage\": \"3.5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"1 jan 2023\",\n" +
            "        \"name\": \"XXX kadam\",\n" +
            "        \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "        \"reviewAverage\": \"5\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"About\": {\n" +
            "      \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "      \"Cuisine\": [\n" +
            "        \"Cafe\",\n" +
            "        \"Salad\",\n" +
            "        \"Fast food\",\n" +
            "        \"Dessert\"\n" +
            "      ],\n" +
            "      \"Type\": [\n" +
            "        \"Breakfast\",\n" +
            "        \"Fine Dinning\",\n" +
            "        \"Luxuray Dinning\",\n" +
            "        \"Breakfast Buffect\"\n" +
            "      ],\n" +
            "      \"Address\": \"G1 , Ground flooe P.M.G. Road , Bhandup(w)\",\n" +
            "      \"Number\": \"912346544\",\n" +
            "      \"Average Cost\": \"500RS for two people\",\n" +
            "      \"Facilities\": [\n" +
            "        \"wifi\",\n" +
            "        \"AC\",\n" +
            "        \"Card pay\",\n" +
            "        \"hot water\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Menulist\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "        \"name\": \"Paneer\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"MainCourse\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo1\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "        \"name\": \"Ice-Cream\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Desserts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo2\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "        \"name\": \"Idle\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Starters\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo3\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "        \"name\": \"Noddles\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Chiness\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo4\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "        \"name\": \"Egg\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Breakfast\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"hotelimage\": \"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/wendy-haworth-design-portfolio-interiors-commercial-bar-1501165803-005743-1541085120.jpg\",\n" +
            "    \"hotelname\": \"Blue hotel\",\n" +
            "    \"offers\": \"30% OFF\",\n" +
            "    \"\": \"\",\n" +
            "    \"hotelphotos\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"Review\": [\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"31 Dec 2022\",\n" +
            "        \"name\": \"priynka patil\",\n" +
            "        \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "        \"reviewAverage\": \"3.5\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"1 jan 2023\",\n" +
            "        \"name\": \"Rohit kadam\",\n" +
            "        \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "        \"reviewAverage\": \"5\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"About\": {\n" +
            "      \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "      \"Cuisine\": [\n" +
            "        \"Cafe\",\n" +
            "        \"Salad\",\n" +
            "        \"Fast food\",\n" +
            "        \"Dessert\"\n" +
            "      ],\n" +
            "      \"Type\": [\n" +
            "        \"Breakfast\",\n" +
            "        \"Fine Dinning\",\n" +
            "        \"Luxuray Dinning\",\n" +
            "        \"Breakfast Buffect\"\n" +
            "      ],\n" +
            "      \"Address\": \"G1 , Ground flooe L.B.S. Road , Nahur(w)\",\n" +
            "      \"Number\": \"912346544\",\n" +
            "      \"Average Cost\": \"500RS for two people\",\n" +
            "      \"Facilities\": [\n" +
            "        \"wifi\",\n" +
            "        \"AC\",\n" +
            "        \"Card pay\",\n" +
            "        \"hot water\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Menulist\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "        \"name\": \"Paneer\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"MainCourse\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo1\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "        \"name\": \"Ice-Cream\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Desserts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo2\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "        \"name\": \"Idle\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Starters\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo3\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "        \"name\": \"Noddles\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Chiness\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo4\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "        \"name\": \"Egg\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Breakfast\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"hotelimage\": \"https://www.itchotels.com/content/dam/itchotels/in/umbrella/images/headmast-desktop/welcomhotel-bhubaneswar.jpg\",\n" +
            "    \"hotelname\": \"Taj hotel\",\n" +
            "    \"offers\": \"30% OFF\",\n" +
            "    \"hotelphotos\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"Review\": [\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"5 Dec 2022\",\n" +
            "        \"name\": \"Rani Patil\",\n" +
            "        \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "        \"reviewAverage\": \"4\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Title\": \"Food is really amizing.\",\n" +
            "        \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "        \"date\": \"1 jan 2023\",\n" +
            "        \"name\": \"YYY kadam\",\n" +
            "        \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "        \"reviewAverage\": \"5\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"About\": {\n" +
            "      \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "      \"Cuisine\": [\n" +
            "        \"Cafe\",\n" +
            "        \"Salad\",\n" +
            "        \"Fast food\",\n" +
            "        \"Dessert\"\n" +
            "      ],\n" +
            "      \"Type\": [\n" +
            "        \"Breakfast\",\n" +
            "        \"Fine Dinning\",\n" +
            "        \"Luxuray Dinning\",\n" +
            "        \"Breakfast Buffect\"\n" +
            "      ],\n" +
            "      \"Address\": \"G2 , first floor M.G. Road , Vikroli(w)\",\n" +
            "      \"Number\": \"9129253891\",\n" +
            "      \"Average Cost\": \"500RS for two people\",\n" +
            "      \"Facilities\": [\n" +
            "        \"wifi\",\n" +
            "        \"AC\",\n" +
            "        \"Card pay\",\n" +
            "        \"hot water\"\n" +
            "      ]\n" +
            "    },\n" +
            "    \"Menulist\": [\n" +
            "      {\n" +
            "        \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "        \"name\": \"Paneer\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"MainCourse\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo1\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "        \"name\": \"Ice-Cream\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Desserts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo2\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "        \"name\": \"Idle\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Starters\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo3\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "        \"name\": \"Noddles\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Chiness\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"photo4\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "        \"name\": \"Egg\",\n" +
            "        \"price\": \"150RS\",\n" +
            "        \"Service\": \"Service2\",\n" +
            "        \"Catageory\": \"Breakfast\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";
    JSONArray dataArray;

     */


    //JSONlist of ArrayObject
    JSONObject dataArray;
    String dataList = "{\n" +
            "  \"ReatoList\": [\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://www.itchotels.com/content/dam/itchotels/in/umbrella/images/headmast-desktop/welcomhotel-bhubaneswar.jpg\",\n" +
            "      \"hotelname\": \"Alpha hotel\",\n" +
            "      \"offers\": \"25% OFF\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"22 Dec 2023\",\n" +
            "          \"name\": \"Rakhi kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"4.5\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"22 Dec 2023\",\n" +
            "          \"name\": \"Rakhi kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"4.5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G1 , Ground flooe P.M.G. Road , Bhandup(w)\",\n" +
            "        \"Number\": \"912346544\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://media.istockphoto.com/id/1211547141/photo/modern-restaurant-interior-design.jpg?s=612x612&w=0&k=20&c=CvJmHwNNwfFzVjj1_cX9scwYsl4mnVO8XFPi0LQMTsw=\",\n" +
            "      \"hotelname\": \"Star hotel\",\n" +
            "      \"offers\": \"30% OFF\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"31 Dec 2022\",\n" +
            "          \"name\": \"XYZ XYZ\",\n" +
            "          \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "          \"reviewAverage\": \"3.5\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"1 jan 2023\",\n" +
            "          \"name\": \"XXX kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G1 , Ground flooe P.M.G. Road , Bhandup(w)\",\n" +
            "        \"Number\": \"912346544\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "          \"name\": \"Egg\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Breakfast\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/wendy-haworth-design-portfolio-interiors-commercial-bar-1501165803-005743-1541085120.jpg\",\n" +
            "      \"hotelname\": \"Blue hotel\",\n" +
            "      \"offers\": \"30% OFF\",\n" +
            "      \"\": \"\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"31 Dec 2022\",\n" +
            "          \"name\": \"priynka patil\",\n" +
            "          \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "          \"reviewAverage\": \"3.5\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"1 jan 2023\",\n" +
            "          \"name\": \"Rohit kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G1 , Ground flooe L.B.S. Road , Nahur(w)\",\n" +
            "        \"Number\": \"912346544\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo1\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo2\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo3\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo4\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "          \"name\": \"Egg\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Breakfast\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://upload.wikimedia.org/wikipedia/commons/6/62/Barbieri_-_ViaSophia25668.jpg\",\n" +
            "      \"hotelname\": \"Taj hotel\",\n" +
            "      \"offers\": \"30% OFF\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"5 Dec 2022\",\n" +
            "          \"name\": \"Rani Patil\",\n" +
            "          \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "          \"reviewAverage\": \"4\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"1 jan 2023\",\n" +
            "          \"name\": \"YYY kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G2 , first floor M.G. Road , Vikroli(w)\",\n" +
            "        \"Number\": \"9129253891\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "          \"name\": \"Egg\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Breakfast\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"HomemadeList\": [\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://media.istockphoto.com/id/666193858/photo/indian-vegetarian-office-or-school-lunch-box-or-tiffin-with-north-indian-or-maharashtrian.jpg?s=612x612&w=0&k=20&c=Ac-U7hY1leIuM97jLNPqzv7SX5DbZofu5p_pfUCgeJA=\",\n" +
            "      \"hotelname\": \"Varsha Tiffin Service\",\n" +
            "      \"offers\": \"25% OFF\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"22 Dec 2023\",\n" +
            "          \"name\": \"Rakhi kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"4.5\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"22 Dec 2023\",\n" +
            "          \"name\": \"Rakhi kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"4.5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G1 , Ground flooe P.M.G. Road , Bhandup(w)\",\n" +
            "        \"Number\": \"912346544\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Indian_food_%22Parathaaaaaaaaaaa%22.jpg/640px-Indian_food_%22Parathaaaaaaaaaaa%22.jpg\",\n" +
            "      \"hotelname\": \"Adisha Tiffin Service\",\n" +
            "      \"offers\": \"30% OFF\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"31 Dec 2022\",\n" +
            "          \"name\": \"XYZ XYZ\",\n" +
            "          \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "          \"reviewAverage\": \"3.5\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"1 jan 2023\",\n" +
            "          \"name\": \"XXX kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G1 , Ground flooe P.M.G. Road , Bhandup(w)\",\n" +
            "        \"Number\": \"912346544\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "          \"name\": \"Egg\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Breakfast\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://media.istockphoto.com/id/513068410/photo/vintage-metal-food-carrier.jpg?s=612x612&w=is&k=20&c=65MAs3Y-q5AZTeAEO0W9QnoEWeyyLTCnaZ4_EaIlMhs=\",\n" +
            "      \"hotelname\": \"VanitaTiffin Service\",\n" +
            "      \"offers\": \"30% OFF\",\n" +
            "      \"\": \"\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"31 Dec 2022\",\n" +
            "          \"name\": \"priynka patil\",\n" +
            "          \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "          \"reviewAverage\": \"3.5\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"1 jan 2023\",\n" +
            "          \"name\": \"Rohit kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G1 , Ground flooe L.B.S. Road , Nahur(w)\",\n" +
            "        \"Number\": \"912346544\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "          \"name\": \"Egg\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Breakfast\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    {\n" +
            "      \"hotelimage\": \"https://images.jdmagicbox.com/comp/def_content/tiffin_services/default-tiffin-services-8.jpg?clr=\",\n" +
            "      \"hotelname\": \"Jay Tiffin Service\",\n" +
            "      \"offers\": \"30% OFF\",\n" +
            "      \"hotelphotos\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://assets1.cbsnewsstatic.com/hub/i/2015/07/01/0b059f60-344d-4ada-baae-e683aff3650a/istock000044051102large.jpg\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://res.cloudinary.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_508,h_320,c_fill/seqow1xpsqqmheeipuso\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"Review\": [\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"5 Dec 2022\",\n" +
            "          \"name\": \"Rani Patil\",\n" +
            "          \"profile\": \"https://static.vecteezy.com/system/resources/thumbnails/005/544/718/small/profile-icon-design-free-vector.jpg\",\n" +
            "          \"reviewAverage\": \"4\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"Title\": \"Food is really amizing.\",\n" +
            "          \"Decripition\": \"Had a lovely time.Good food and amience and service. A sunny Easter bunny lunch\",\n" +
            "          \"date\": \"1 jan 2023\",\n" +
            "          \"name\": \"YYY kadam\",\n" +
            "          \"profile\": \"https://cdn-icons-png.flaticon.com/512/3135/3135715.png\",\n" +
            "          \"reviewAverage\": \"5\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"About\": {\n" +
            "        \"about\": \"Any bar, cafe, restaurant, hotel or similar business needs to make a great first impression, so it’s a good idea to personalize messages to prospective customers or guests. Use the template below to introduce your establishment\",\n" +
            "        \"Cuisine\": [\n" +
            "          \"Cafe\",\n" +
            "          \"Salad\",\n" +
            "          \"Fast food\",\n" +
            "          \"Dessert\"\n" +
            "        ],\n" +
            "        \"Type\": [\n" +
            "          \"Breakfast\",\n" +
            "          \"Fine Dinning\",\n" +
            "          \"Luxuray Dinning\",\n" +
            "          \"Breakfast Buffect\"\n" +
            "        ],\n" +
            "        \"Address\": \"G2 , first floor M.G. Road , Vikroli(w)\",\n" +
            "        \"Number\": \"9129253891\",\n" +
            "        \"Average Cost\": \"500RS for two people\",\n" +
            "        \"Facilities\": [\n" +
            "          \"wifi\",\n" +
            "          \"AC\",\n" +
            "          \"Card pay\",\n" +
            "          \"hot water\"\n" +
            "        ]\n" +
            "      },\n" +
            "      \"Menulist\": [\n" +
            "        {\n" +
            "          \"photo\": \"https://thumbs.dreamstime.com/b/paneer-butter-masala-cheese-cottage-curry-indian-main-course-recipe-popular-lunch-dinner-menu--served-ceramic-bowl-191806910.jpg\",\n" +
            "          \"name\": \"Paneer\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"MainCourse\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://joyfoodsunshine.com/wp-content/uploads/2020/06/homemade-chocolate-ice-cream-recipe-7.jpg\",\n" +
            "          \"name\": \"Ice-Cream\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Desserts\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.shutterstock.com/image-photo/idli-sambhar-idly-sambar-popular-260nw-1527060110.jpg\",\n" +
            "          \"name\": \"Idle\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Starters\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://www.wellandgood.com/wp-content/uploads/2020/12/chow-mein-cup-full-of-kale-feature.jpg\",\n" +
            "          \"name\": \"Noddles\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Chiness\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"photo\": \"https://images.pexels.com/photos/103124/pexels-photo-103124.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2\",\n" +
            "          \"name\": \"Egg\",\n" +
            "          \"price\": \"150RS\",\n" +
            "          \"Service\": \"Service2\",\n" +
            "          \"Catageory\": \"Breakfast\"\n" +
            "        }\n" +
            "      ]\n" +
            "    }\n" +
            "  ],\n" +
            "  \"FarmProduct\": [\n" +
            "    {\n" +
            "      \"Farmimage\": \"https://www.mahindraagri.com/wp-content/uploads/2020/06/screenshot-2020-05-07-at-4-03-48-pm1.png\",\n" +
            "      \"name\": \"Fresh Grapes\",\n" +
            "      \"price\": \"200RS per/kg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Farmimage\": \"https://m.media-amazon.com/images/I/61Xl3VVZjKL._SX679_.jpg\",\n" +
            "      \"name\": \"Fresh Straberry\",\n" +
            "      \"price\": \"200RS per/kg\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"Farmimage\": \"https://blog-images-1.pharmeasy.in/blog/production/wp-content/uploads/2022/05/03114105/7-5.jpg\",\n" +
            "      \"name\": \"Fresh Apple\",\n" +
            "      \"price\": \"200RS per/kg\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";



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
        try {
            //convert datalist in JSONArray
            dataArray = new JSONObject(dataList);
        } catch (JSONException e) {
            e.printStackTrace();
        }



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
        //Third recycler using JSON method
        RecyclerView recycler2 = view.findViewById(R.id.himagerecycle2);
        List<restaurant> image2 = new ArrayList<>();

        try {
            JSONArray array = dataArray.getJSONArray("ReatoList");
          //  System.out.print(array);
           // Log.e("TAG", "onCreateView: "+array );
            for (int i=0 ; i<array.length(); i++){
                JSONObject object = dataArray.getJSONArray("ReatoList").getJSONObject(i);
                restaurant restaurantlist = new restaurant(object.getString("hotelname"),object.getString("offers"),object.getString("hotelimage"));
                image2.add(restaurantlist);
                Log.e("TAG", "onCreateView: "+array.length() );
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recycler2.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));

        RestaturantAdpter adpter2 = null;
        try {
            adpter2 = new RestaturantAdpter(image2,dataArray.getJSONArray("ReatoList"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recycler2.setAdapter(adpter2);



       /* restaurant list5 = new restaurant("Alpha hotel", "30% OFF ", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list5);
        restaurant list6 = new restaurant("Star hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list6);
        restaurant list7 = new restaurant("Blue hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list7);
        restaurant list8 = new restaurant("Taj hotel", "30% OFF", "https://media.architecturaldigest.com/photos/56c64bb95ef3a2f746a41f52/master/w_3600,h_2400,c_limit/hotel-restaurants-006.jpg");
        image2.add(list8);
        */
      //  RestaturantAdpter adpter2 = new RestaturantAdpter(image2);
       // recycler2.setAdapter(adpter2);



        //Fourth recyclerview
        RecyclerView recycler3 = view.findViewById(R.id.himagerecycle3);
        List<restaurant> image3 = new ArrayList<>();

        try {
            JSONArray array = dataArray.getJSONArray("HomemadeList");
            for (int i = 0 ; i< array.length();i++){
                JSONObject object = dataArray.getJSONArray("HomemadeList").getJSONObject(i);
                restaurant homemade = new restaurant(object.getString("hotelname"),object.getString("offers"),object.getString("hotelimage"));
                image3.add(homemade);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


       /* restaurant list9 = new restaurant("Adisha Tiffin Service", "30% OFF", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Indian_food_%22Parathaaaaaaaaaaa%22.jpg/640px-Indian_food_%22Parathaaaaaaaaaaa%22.jpg");
        image3.add(list9);
        restaurant list10 = new restaurant("Vanita Tiffin Service", "30% OFF", "https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Indian_food_%22Parathaaaaaaaaaaa%22.jpg/640px-Indian_food_%22Parathaaaaaaaaaaa%22.jpg");
        image3.add(list10);
        restaurant list11 = new restaurant("Jay Tiffin Service", "30% OFF", "https://images.jdmagicbox.com/comp/def_content/tiffin_services/default-tiffin-services-8.jpg?clr=");
        image3.add(list11);
        restaurant list12 = new restaurant("Adisha Tiffin Service", "30% OFF", "https://lh3.googleusercontent.com/p/AF1QipNdPWUpjTrLKU7eCylEHyd75-WT3ET0dRsPtZHU=w1080-h608-p-no-v0");
        image3.add(list12);

        */
        RestaturantAdpter adpter3 = null;
        try {
            adpter3 = new RestaturantAdpter(image3,dataArray.getJSONArray("HomemadeList"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        recycler3.setAdapter(adpter3);
        recycler3.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));


        //Fivth recyclerview

        RecyclerView recycler4 = view.findViewById(R.id.himagerecycle4);
        List<farm> image4 = new ArrayList<>();

        try {
            JSONObject array = new JSONObject(dataList);
            for (int i =0; i<array.length(); i++){
                JSONObject object = dataArray.getJSONArray("FarmProduct").getJSONObject(i);
                farm farmlist = new farm(object.getString("name"),object.getString("price"),object.getString("Farmimage"));
                image4.add(farmlist);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /* farm list13 = new farm("Fresh Grapes", "200Rs per/kg", "https://www.shutterstock.com/image-photo/green-grape-leaves-isolated-on-260nw-533487490.jpg");
        image4.add(list13);
        farm list14 = new farm("Fresh Straberry", "200Rs per/kg", "https://m.media-amazon.com/images/I/61Xl3VVZjKL._SX679_.jpg");
        image4.add(list14);
        farm list15 = new farm("Fresh Apple", "200Rs per/kg", "https://blog-images-1.pharmeasy.in/blog/production/wp-content/uploads/2022/05/03114105/7-5.jpg");
        image4.add(list15);

        */
        FarmProductAdpter adpter4 = new FarmProductAdpter(image4);
        recycler4.setAdapter(adpter4);
        recycler4.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));



        //using viewall textview clicklistner
        TextView viewall1 = view.findViewById(R.id.llviewall1);
        viewall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
               Fragment fragment = new HotelList_page53();
               Bundle bundle = new Bundle();
               JSONArray array = new JSONArray();
                try {
                    array = dataArray.getJSONArray("ReatoList");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bundle.putString("data",array.toString());
                fragment.setArguments(bundle);

                transaction.add(R.id.frame,fragment);
               transaction.commit();
            }
        });

        TextView viewall2 = view.findViewById(R.id.ll_viewall2);
        viewall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getContext(), Page11.class);
             //   startActivity(intent);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment fragment = new HotelList_page53();
                Bundle bundle = new Bundle();
                JSONArray array = new JSONArray();
                try {
                    array = dataArray.getJSONArray("HomemadeList");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bundle.putString("data",array.toString());
                fragment.setArguments(bundle);
                transaction.add(R.id.frame,fragment);
                transaction.commit();
            }
        });

        //farm productviewall using clicklistner
        TextView viewall3 = view.findViewById(R.id.ll_viewall3);
        viewall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
               Fragment fragment = new FarmProduct_page53();
               Bundle bundle = new Bundle();
               JSONArray array = new JSONArray();
                try {
                    array = dataArray.getJSONArray("FarmProduct");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                bundle.putString("data",array.toString());
                fragment.setArguments(bundle);
                transaction.add(R.id.frame, fragment);
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

    //Third and fourth recyclerview adpter
    class RestaturantAdpter extends RecyclerView.Adapter<RestaturantAdpter.CustomAdpterHolder> {
        List<restaurant> image2;
        JSONArray data;

        public RestaturantAdpter(List<restaurant> image2, JSONArray reatoList) {
            this.image2 = image2;
            data=reatoList;

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
                    //initalize JSONobject
                    JSONObject object =new JSONObject();
                    try {
                        object = data.getJSONObject(position);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Log.e("MSG",object.toString());
                    bundle.putString("data", object.toString());
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
                    JSONObject object = new JSONObject();
                    try {
                        object = dataArray.getJSONArray("FarmProduct").getJSONObject(position);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    bundle.putInt("ID", position);
                    bundle.putString("data",object.toString());
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