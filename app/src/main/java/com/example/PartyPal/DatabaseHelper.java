package com.example.PartyPal;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    protected Context context;
    private static final String DATABASE_NAME = "FoodOrdering.db";
    private static final int DATABASE_VERSION = 1;

    protected static final String CART_TABLE_NAME = "cart";

    private static final String CART_ID = "id";
    private static final String CART_NAME = "cart_name";
    private static final String CART_TIMING = "cart_timing";
    private static final String CART_RATING = "cart_rating";
    private static final String CART_PRICE = "cart_price";

    private static final String CREATE_TABLE_USER = "CREATE TABLE "
            + CART_TABLE_NAME + "(" + CART_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + CART_NAME + " TEXT, " + CART_TIMING + " TEXT, "
            + CART_RATING + " TEXT, " + CART_PRICE + " DOUBLE" + " );";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CART_TABLE_NAME);
        onCreate(db);
    }

    public void deleteFromCart(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(CART_TABLE_NAME, "id=?", new String[]{id});
        if(result == -1){
            Toast.makeText(context, "Failed to delete food from cart!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("Delete", "1");
            context.startActivity(intent);

        }
    }
    public void addToCart(String cartName, String cartTiming, String rating, Double price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(CART_NAME, cartName);
        cv.put(CART_TIMING, cartTiming);
        cv.put(CART_RATING, rating);
        cv.put(CART_PRICE, price);

        long result = 0;
        try{
            result = db.insert(CART_TABLE_NAME, null, cv);
            Toast.makeText(context, "Added to cart", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(context, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
        }

    }
    public void deleteAllFromCart(){
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(CART_TABLE_NAME, null, null);
        if(result == -1){
            Toast.makeText(context, "Failed to complete checkout!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        }
    }



}
