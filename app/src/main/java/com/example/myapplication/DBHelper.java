package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    public static String name = "hotels";
    public static int DB_Version = 6;


    public DBHelper(@Nullable Context context) {
        super(context, name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Hotel(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,loacation TEXT,image TEXT,offers TEXT,about TEXT,number TEXT,averagecost TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Homemade(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,loacation TEXT,image TEXT,offers TEXT,about TEXT,number TEXT,averagecost TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Farm(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,image TEXT,price TEXT,about TEXT,nutriation TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE Menu(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,image TEXT,price TEXT,category TEXT,serve_type TEXT,hotel_id TEXT)");

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

                list1.add(new Homemadeinfo(id,name, location, image, offers, about, number, averagecost));


            }
            while (cursor.moveToNext());


        }

        return list1;
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
                list2.add(new farminfo(id,name, image, price, about, nutriation));

            }
            while (cursor.moveToNext());
        }

        return list2;
    }


    //Menulist data
    public void addmenuinfo(String name,String image,String price,String category,String serve_type,String hotel_id){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("image",image);
        values.put("price",price);
        values.put("category",category);
        values.put("serve_type",serve_type);
        values.put("hotel_id",hotel_id);
        SQLiteDatabase data = this.getWritableDatabase();
        data.insert("Menu",null,values);
        data.close();

    }
    @SuppressLint("Range")
    public List<Menulist>getMenulist(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Menu";
        Cursor cursor = db.rawQuery(query,new String[]{});
        List<Menulist>list = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                String id = cursor.getString(cursor.getColumnIndex("ID"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                String price = cursor.getString(cursor.getColumnIndex("price"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String servetype = cursor.getString(cursor.getColumnIndex("serve_type"));
                String hotelId = cursor.getString(cursor.getColumnIndex("hotel_id"));
                list.add(new Menulist(id,name,image,price,category,servetype,hotelId));
            }
            while (cursor.moveToNext());
        }

        return list;
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Hotel"); //previous delete table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Homemade"); //previous delete table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Farm"); //previous delete table
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Menu"); //previous delete table
        onCreate(sqLiteDatabase); //add again new table version

    }
}
