package com.example.upass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {

    public static final String PASSWORD_TABLE = "PASSWORD_TABLE";
    public static final String COLUMN_EMAIL_ID = "EMAIL_ID";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_ID = "COLUMN_ID";
    public static final String COLUMN_URL = "URL";

    public DataBaseHandler(@Nullable Context context) {
        super(context, "PasswordManager.db", null, 1);
    }

    public  void onCreate(SQLiteDatabase db){

        String createTableStatement = "CREATE TABLE "+PASSWORD_TABLE+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_EMAIL_ID+" TEXT, "+COLUMN_PASSWORD+" TEXT, "+COLUMN_URL+" TEXT)";
        db.execSQL(createTableStatement);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(PasswordData passwordData){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_EMAIL_ID, passwordData.getEmail_id());
        cv.put(COLUMN_PASSWORD, passwordData.getPassword());
        cv.put(COLUMN_URL, passwordData.getUrl());

        long insert = db.insert(PASSWORD_TABLE, null, cv);
        if (insert == -1)
            return false;
        else
            return true;
    }

    public List<PasswordData> returnAll(){

        List<PasswordData> returnList = new ArrayList<>();

        String query = "SELECT * FROM " + PASSWORD_TABLE;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            //loop through the results and crate new PasswordData Objects
            do{
                int columnID = cursor.getInt(0);
                String email_id = cursor.getString(1);
                String password_column = cursor.getString(2);
                String url = cursor.getString(3);

                PasswordData newPasswordData = new PasswordData(columnID,email_id,password_column,url);
                returnList.add(newPasswordData);
            } while(cursor.moveToNext());


        }else {


        }

        cursor.close();
        return returnList;

    }



}