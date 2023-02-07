package com.myapp.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myapplication.model.CartItem;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static String name = "hotels";
    public static int DB_Version = 31;


    public DBHelper(@Nullable Context context) {
        super(context, name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Hotel(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,loacation TEXT,image TEXT,offers TEXT,about TEXT,number TEXT,averagecost TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Homemade(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,loacation TEXT,image TEXT,offers TEXT,about TEXT,number TEXT,averagecost TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Farm(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,image TEXT,price TEXT,about TEXT,nutriation TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Menu(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,image TEXT,price TEXT,category TEXT,serve_type TEXT,hotel_id TEXT,type TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Photo(id INTEGER PRIMARY KEY AUTOINCREMENT,image TEXT,hotel_id TEXT,type TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Review(id INTEGER PRIMARY KEY AUTOINCREMENT,image TEXT,name TEXT,date TEXT,title TEXT,decription TEXT,reviewaverage TEXT,hotel_id TEXT,type TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Facilites(id INTEGER PRIMARY KEY AUTOINCREMENT,text TEXT,hotel_id TEXT,type TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cuisine(id INTEGER PRIMARY KEY AUTOINCREMENT,text TEXT,hotel_id TEXT,type TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS CartItem(id INTEGER PRIMARY KEY AUTOINCREMENT,user_id TEXT,name TEXT,imageUrl TEXT,price TEXT,count TEXT,status TEXT,order_id TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Address(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,email TEXT,address TEXT,nearest_landmark TEXT,state TEXT,city TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS BookingOrder(id INTEGER PRIMARY KEY AUTOINCREMENT,user_id TEXT,order_id TEXT)");

    }
    public void addbookingOrder(String user_id,String order_id){
        ContentValues values = new ContentValues();
        values.put("user_id",user_id);
        values.put("order_id",order_id);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("BookingOrder",null,values);
        db.close();
    }
    @SuppressLint("Range")
    public List<Booking>getbookingorder (String user_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM BookingOrder WHERE user_id = '"+user_id+"'";
         Cursor cursor = db.rawQuery(query,new String[]{});
        List<Booking>list = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                 String id = cursor.getString(cursor.getColumnIndex("id"));
                 String userid = cursor.getString(cursor.getColumnIndex("user_id"));
                 String orderid = cursor.getString(cursor.getColumnIndex("order_id"));
                 list.add(new Booking(id,userid,orderid));

            }
            while (cursor.moveToNext());
        }
        return list;
    }
    @SuppressLint("Range")
    public List<CartItem> BookingID(String order_id,String user_id){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM CartItem WHERE order_id = '"+order_id+"' AND user_id ='"+user_id+"'";
        Cursor cursor = db.rawQuery(query,new String[]{});
       // db.rawQuery("SELECT * FROM CartItem WHERE order_id ='"+order_id+"' AND user_id = '"+user_id+"'",new String[]{});
        List<CartItem>list = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
               String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                String image = cursor.getString(cursor.getColumnIndex("imageUrl"));
                String count = cursor.getString(cursor.getColumnIndex("count"));
                String userid = cursor.getString(cursor.getColumnIndex("user_id"));
                String Status = cursor.getString(cursor.getColumnIndex("status"));
                list.add(new CartItem(id, name, image, price, count, userid, null));

            }
            while (cursor.moveToNext());
        }
        db.close();

        return list;
    }



    //add CartItem data
    public void addcartItem(CartItem item) {
        ContentValues values = new ContentValues();
        values.put("user_id", item.getUser_id());
        values.put("price", item.getPrice());
        values.put("name", item.getName());
        values.put("imageUrl", item.getImageUrl());
        values.put("count", item.getCount());
        values.put("status","Cart");  //get status hardcourt
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("CartItem", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<CartItem> getcartItem(String userid) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM CartItem WHERE user_id = '" + userid + "' AND status = 'Cart'";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<CartItem> list = new ArrayList<>();
        //  long order_id= System.currentTimeMillis();
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                String image = cursor.getString(cursor.getColumnIndex("imageUrl"));
                String count = cursor.getString(cursor.getColumnIndex("count"));
                String user_id = cursor.getString(cursor.getColumnIndex("user_id"));
                String Status = cursor.getString(cursor.getColumnIndex("status"));
                list.add(new CartItem(id, name, image, price, count, user_id, null));

            }
            while (cursor.moveToNext());
        }
        return list;
    }

    //add interface method
    public void Update(String ID, String count) {  //using name not Id
        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "SELECT * FROM CartItem WHERE user_id = '"+ userid +"'";
        db.execSQL("UPDATE CartItem SET count = '" + count + "'  WHERE name = '" + ID + "' AND status = 'Cart';");
        // db.execSQL("DELETE FROM CartItem WHERE id='"+ID+"'");
        db.close();
    }
    //changed status cart to placed
    public void UpdateCart(String order_id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE CartItem SET status = 'Placed',order_id = '"+order_id+"' WHERE status = 'Cart'");
        db.close();

    }

//add CartItem delete queary
    public void DeleteCart(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM CartItem WHERE id='" + id + "'");
        db.close();
    }
    public void TruncateCart(){                 //delete table
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM CartItem");
        db.close();
    }

    //add address data
    public void addaddress(String name, String Email, String Address, String Nearest_landmark, String State, String City) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", Email);
        values.put("address", Address);
        values.put("nearest_landmark", Nearest_landmark);
        values.put("state", State);
        values.put("city", City);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Address", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<address> getaddressinfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Address";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<address> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String email = cursor.getString(cursor.getColumnIndex("email"));
                String address = cursor.getString(cursor.getColumnIndex("address"));
                String nearest_landmark = cursor.getString(cursor.getColumnIndex("nearest_landmark"));
                String state = cursor.getString(cursor.getColumnIndex("state"));
                String city = cursor.getString(cursor.getColumnIndex("city"));

                list.add(new address(name, email, address, nearest_landmark, state, city));
            }
            while (cursor.moveToNext());
        }
        return list;
    }

    //add cuisine data
    public void addcuisineinfo(String text, String hotel_id, String type) {
        ContentValues values = new ContentValues();
        values.put("text", text);
        values.put("hotel_id", hotel_id);
        values.put("type", type);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("cuisine", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<cuisine> getcuisineinfo(String hotelid, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM cuisine WHERE hotel_id = '" + hotelid + "' AND type = '" + type + "'";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<cuisine> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("text"));
                String hotel_id = cursor.getString(cursor.getColumnIndex("hotel_id"));
                list.add(new cuisine(id, name, hotel_id, type));
            }
            while (cursor.moveToNext());
        }
        return list;
    }


    //add facility data
    public void addfacilitesinfo(String text, String hotel_id, String type) {
        ContentValues values = new ContentValues();
        values.put("text", text);
        values.put("hotel_id", hotel_id);
        values.put("type", type);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Facilites", null, values);
        db.close();

    }

    @SuppressLint("Range")
    public List<facilites> getfacilityinfo(String t, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Facilites WHERE hotel_id = '" + t + "'AND type = '" + type + "'";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<facilites> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("text"));
                String hotel_id = cursor.getString(cursor.getColumnIndex("hotel_id"));
                list.add(new facilites(id, name, hotel_id, type));
            }
            while (cursor.moveToNext());
        }
        return list;
    }

    //add review data
    public void addreviewinfo(String Image, String Name, String Date, String Title, String Decription, String Reviewaverage, String hotel_id, String type) {
        ContentValues values = new ContentValues();
        values.put("image", Image);
        values.put("name", Name);
        values.put("date", Date);
        values.put("title", Title);
        values.put("decription", Decription);
        values.put("reviewaverage", Reviewaverage);
        values.put("hotel_id", hotel_id);
        values.put("type", type);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Review", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<Review> getReviewinfo(String y, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Review WHERE hotel_id = '" + y + "' AND type = '" + type + "'";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<Review> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String decription = cursor.getString(cursor.getColumnIndex("decription"));
                String reviewaverage = cursor.getString(cursor.getColumnIndex("reviewaverage"));
                String hotel_id = cursor.getString(cursor.getColumnIndex("hotel_id"));

                list.add(new Review(id, image, name, date, title, decription, reviewaverage, hotel_id, type));
            }
            while (cursor.moveToNext());
        }
        return list;
    }

    //Homemade Resturant data
    public void addhomemadeinfo(String name, String location, String image, String offers, String about, String number, String averagecost) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("loacation", location);
        values.put("image", image);
        values.put("offers", offers);
        values.put("about", about);
        values.put("number", number);
        values.put("averagecost", averagecost);
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert("Homemade", null, values);
        database.close();          //close means commit data

    }

    @SuppressLint("Range")
    public List<Homemadeinfo> getHomemadeinfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Homemade";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<Homemadeinfo> list1 = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String location = cursor.getString(cursor.getColumnIndex("loacation"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String offers = cursor.getString(cursor.getColumnIndex("offers"));
                String about = cursor.getString(cursor.getColumnIndex("about"));
                String number = cursor.getString(cursor.getColumnIndex("number"));
                String averagecost = cursor.getString(cursor.getColumnIndex("averagecost"));

                list1.add(new Homemadeinfo(id, name, location, image, offers, about, number, averagecost));


            }
            while (cursor.moveToNext());


        }

        return list1;
    }

    //singelone homemadehotel image set method
    @SuppressLint("Range")
    public Homemadeinfo getHomemadeForID(String id) {
        Homemadeinfo homemadeinfo = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Homemade WHERE id = '" + id + "'", new String[]{});
        if (cursor.moveToFirst()) {
            String uid = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String location = cursor.getString(cursor.getColumnIndex("loacation"));
            String image = cursor.getString(cursor.getColumnIndex("image"));
            String offers = cursor.getString(cursor.getColumnIndex("offers"));
            String about = cursor.getString(cursor.getColumnIndex("about"));
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String averagecost = cursor.getString(cursor.getColumnIndex("averagecost"));
            homemadeinfo = new Homemadeinfo(uid, name, location, image, offers, about, number, averagecost);
            cursor.close();
        }
        return homemadeinfo;

    }


    //Resturant hotels data
    public void addhotelinfo(String name, String loacation, String image, String offers, String about, String number, String averagecost) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("loacation", loacation);
        values.put("image", image);
        values.put("offers", offers);
        values.put("about", about);
        values.put("number", number);
        values.put("averagecost", averagecost);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Hotel", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<Hotelinfo> gethotelsinfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Hotel";
        Cursor cursor = db.rawQuery(query, new String[]{});   //cursor means database single row and coloumn
        List<Hotelinfo> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String loacation = cursor.getString(cursor.getColumnIndex("loacation"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String offers = cursor.getString(cursor.getColumnIndex("offers"));
                String about = cursor.getString(cursor.getColumnIndex("about"));
                String number = cursor.getString(cursor.getColumnIndex("number"));
                String averagecost = cursor.getString(cursor.getColumnIndex("averagecost"));
                Hotelinfo hotelinfo = new Hotelinfo(name, loacation, image, offers, about, number, averagecost);
                hotelinfo.setId(id);
                list.add(hotelinfo);
            }
            while (cursor.moveToNext());
        }

        return list;
    }

    //singel one hotel image set
    @SuppressLint("Range")
    public Hotelinfo getHotelForID(String id) {
        Hotelinfo homemadeinfo = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Hotel WHERE id = '" + id + "'", new String[]{});
        if (cursor.moveToFirst()) {
            String uid = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String location = cursor.getString(cursor.getColumnIndex("loacation"));
            String image = cursor.getString(cursor.getColumnIndex("image"));
            String offers = cursor.getString(cursor.getColumnIndex("offers"));
            String about = cursor.getString(cursor.getColumnIndex("about"));
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String averagecost = cursor.getString(cursor.getColumnIndex("averagecost"));
            homemadeinfo = new Hotelinfo(name, location, image, offers, about, number, averagecost);
            homemadeinfo.setId(uid);
            cursor.close();
        }
        return homemadeinfo;

    }


    //add farm product list
    public void addfarminfo(String name, String image, String price, String about, String nutriation) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("image", image);
        values.put("price", price);
        values.put("about", about);
        values.put("nutriation", nutriation);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Farm", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<farminfo> getfarminfo() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Farm";
       /* ALTER TABLE table_name
        RENAME COLUMN oldcolumn_name to newcolumn_name;   change column name
*/
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<farminfo> list2 = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                String about = cursor.getString(cursor.getColumnIndex("about"));
                String nutriation = cursor.getString(cursor.getColumnIndex("nutriation"));
                list2.add(new farminfo(id, name, image, price, about, nutriation));

            }
            while (cursor.moveToNext());
        }

        return list2;
    }

    @SuppressLint("Range")
    public farminfo getFarm(String id) {
        farminfo farm = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Farm WHERE id = '" + id + "'", new String[]{});
        if (cursor.moveToFirst()) {
            String Id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String image = cursor.getString(cursor.getColumnIndex("image"));
            String price = cursor.getString(cursor.getColumnIndex("price"));
            String about = cursor.getString(cursor.getColumnIndex("about"));
            String nutriation = cursor.getString(cursor.getColumnIndex("nutriation"));
            farm = new farminfo(Id, name, image, price, about, nutriation);
            cursor.close();

        }

        return farm;
    }


    //Menulist data
    public void addmenuinfo(String name, String image, String price, String category, String serve_type, String hotel_id, String type) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("image", image);
        values.put("price", price);
        values.put("category", category);
        values.put("serve_type", serve_type);
        values.put("hotel_id", hotel_id);
        values.put("type", type);
        SQLiteDatabase data = this.getWritableDatabase();
        data.insert("Menu", null, values);
        data.close();

    }


    @SuppressLint("Range")
    public List<Menulist> getMenulist(String t, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Menu WHERE hotel_id ='" + t + "' AND type ='" + type + "'";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<Menulist> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String servetype = cursor.getString(cursor.getColumnIndex("serve_type"));
                String hotelId = cursor.getString(cursor.getColumnIndex("hotel_id"));
                list.add(new Menulist(id, name, image, price, category, servetype, hotelId, type));
            }
            while (cursor.moveToNext());
        }

        return list;
    }

    //Photo data
    public void addphotoinfo(String image, String hotel_id, String type) {
        ContentValues values = new ContentValues();
        values.put("image", image);
        values.put("hotel_id", hotel_id);
        values.put("type", type);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("Photo", null, values);
        db.close();
    }

    @SuppressLint("Range")
    public List<Photoinfo> getphotoinfo(String hotelid, String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Photo WHERE hotel_id = '" + hotelid + "' AND Type = '" + type + "'";
        Cursor cursor = db.rawQuery(query, new String[]{});
        List<Photoinfo> list = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String id = cursor.getString(cursor.getColumnIndex("id"));
                String photo = cursor.getString(cursor.getColumnIndex("image"));
                String hotel_id = cursor.getString(cursor.getColumnIndex("hotel_id"));
                list.add(new Photoinfo(id, photo, hotel_id, type));
            }
            while (cursor.moveToNext());
        }

        return list;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //  sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Facilites"); //previous delete table
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Hotel"); //previous delete table
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Homemade"); //previous delete table
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Farm"); //previous delete table
       /* sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Menu"); //previous delete table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Photo"); //previous delete table
      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Review"); //previous delete table
       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cuisine"); //previous delete table
       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CartItem"); //previous delete table
         sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Address"); //previous delete table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BookingOrder"); //previous delete table

x       */        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BookingID"); //previous delete table




        onCreate(sqLiteDatabase); //add again new table version

    }
}
