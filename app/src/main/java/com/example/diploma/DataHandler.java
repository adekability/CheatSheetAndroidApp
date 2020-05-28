package com.example.diploma;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHandler extends SQLiteOpenHelper {
    //information of database
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "questions10.db";
    public ArrayList<HashMap<String, String>> list;
    public ArrayList<HashMap<String, String>> listok;
    public static final String FIRST_COLUMN="First";
    public static final String SECOND_COLUMN="Second";
    public static final String THIRD_COLUMN="Third";

    public static final String TABLE_NAME = "questions";
    public static final String COLUMN_QUESTION = "QuestionName";
    public static final String COLUMN_SHORT_CODE = "ShortCode";
    public static final String COLUMN_ANS = "Answer";
    //initialize the database
    public DataHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String create = "CREATE TABLE questions ("+COLUMN_QUESTION +" TEXT,"+COLUMN_SHORT_CODE + " TEXT," + COLUMN_ANS + " TEXT )";
        db.execSQL(create);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
    public ArrayList<HashMap<String, String>> loadHandler() {
        list=new ArrayList<HashMap<String,String>>();

        String result = "";
        String query = "SELECT * "+"FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
//        System.out.println(cursor.getString(0));
        while (cursor.moveToNext()) {
            HashMap<String,String> hashmap=new HashMap<String, String>();
            hashmap.put(FIRST_COLUMN, cursor.getString(0));
            hashmap.put(SECOND_COLUMN, cursor.getString(1));
            hashmap.put(THIRD_COLUMN, cursor.getString(2));
            list.add(hashmap);
            //int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(0);
            String result_2 = cursor.getString(1);
            String result_3 = cursor.getString(2);
            result = result.concat(result_1 + " " + result_2 + " " + result_3 +
                    System.getProperty("line.separator"));
        }
        cursor.close();
        db.close();
        return list;
    }
    public void addHandler(Questions questions) {

        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, questions.getQuestionID());
        values.put(COLUMN_QUESTION, questions.getQuestionName());
        values.put(COLUMN_SHORT_CODE, questions.getQuestionShortCode());
        values.put(COLUMN_ANS, questions.getQuestionAnswer());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public ArrayList<HashMap<String, String>> findHandler(String shortcode) {
        if (isInteger(shortcode,10)){
            listok=new ArrayList<HashMap<String,String>>();
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_SHORT_CODE + "=" + shortcode;

            System.out.println(query);
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            //System.out.println(cursor.getString(0));
            while (cursor.moveToNext()) {
                HashMap<String,String> hashmap=new HashMap<String, String>();
                hashmap.put(FIRST_COLUMN, cursor.getString(0));
                hashmap.put(SECOND_COLUMN, cursor.getString(1));
                hashmap.put(THIRD_COLUMN, cursor.getString(2));
                listok.add(hashmap);
            }
            cursor.close();

            db.close();
        }
        else{
            listok=new ArrayList<HashMap<String,String>>();
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +  COLUMN_QUESTION + " LIKE '%" + shortcode + "%'";

            System.out.println(query);
            System.out.println("Yay");
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            //System.out.println(cursor.getString(0));
            while (cursor.moveToNext()) {
                HashMap<String,String> hashmap=new HashMap<String, String>();
                System.out.println("Yay");
                System.out.println(cursor.getString(0));
                hashmap.put(FIRST_COLUMN, cursor.getString(0));
                hashmap.put(SECOND_COLUMN, cursor.getString(1));
                hashmap.put(THIRD_COLUMN, cursor.getString(2));
                listok.add(hashmap);
            }
            cursor.close();
            db.close();
        }

        return listok;

        /*Questions student = new Questions();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
           // student.setQuestionID(Integer.parseInt(cursor.getString(0)));
            student.setQuestionName(cursor.getString(1));
            cursor.close();
        } else {
            student = null;
        }*/
    }
    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
    /*public boolean  updateHandler(int ID, String name, String shortcode, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
       // args.put(COLUMN_ID, ID);
        args.put(COLUMN_QUESTION, name);
        args.put(COLUMN_SHORT_CODE, shortcode);
        args.put(COLUMN_ANS, answer);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;
    }*/

}