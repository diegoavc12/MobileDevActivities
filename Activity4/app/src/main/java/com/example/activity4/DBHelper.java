package com.example.activity4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_FILE = "Database.db";
    private static final String TABLE = "students";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_HOBBY="hobby";
    private int id=1;

    public DBHelper(Context context){

        super(context, DB_FILE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_HOBBY + " TEXT)";

        db.execSQL(query);
        ContentValues values = new ContentValues();
        values.put(FIELD_NAME, "Diego");
        values.put(FIELD_ID, this.id);
        db.insert(TABLE, null, values);
        this.id++;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] args = {TABLE};

        db.execSQL(query, args);

        onCreate(db);

    }
    public String[] loadValues(String id){
        SQLiteDatabase db = getReadableDatabase();
        String[] result= {"not found","not found"};
        String clause = FIELD_ID + " = ?";
        String[] args = {id};
        Cursor c = db.query(TABLE, null, clause, args, null, null, null);
        if(c.moveToFirst()){
            result[0]=c.getString(0);
            result[1]=c.getString(1);
        }
        return result;
    }

    public String getFieldHobby(String id){
        SQLiteDatabase db = getReadableDatabase();
        String result=null;
        String clause=FIELD_ID+" = ?";
        String [] args={id};
        Cursor c=db.query(TABLE,null,clause,args,null,null,null);
        if(c.moveToFirst()){
            result=c.getString(2);
        }
        return result;
    }

    public void updateHobby(String id, String hobby){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_HOBBY,hobby);
        String clause=FIELD_ID+"= ?";
        String [] args={id};
        db.update(TABLE,values,clause,args);
    }

    public void save(String name, String hobby){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FIELD_ID, this.id);
        values.put(FIELD_NAME,name);
        values.put(FIELD_HOBBY,hobby);
        db.insert(TABLE,null,values);
        this.id++;
    }

    public String search(String name){
        SQLiteDatabase db = getReadableDatabase();
        String hobby=null;
        String clause=FIELD_NAME+" = ?";
        String [] args={name};
        Cursor c=db.query(TABLE,null,clause,args,null,null,null);
        if(c.moveToFirst()){
            hobby=c.getString(2);
        }
        return hobby;
    }

    public void delete(String name){
        SQLiteDatabase db= getWritableDatabase();
        String clause=FIELD_NAME+" =?";
        String [] args={name};
        db.delete(TABLE,clause,args);
    }
}
