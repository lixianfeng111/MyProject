package com.example.myproject.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建数据库sql语句 并 执行,相当于初始化数据库，这里是新建了一张表
        //这个方法继承自SQLiteOpenHelper,会自动调用  也就是 会 当新建了一个DatabaseHelper对象时，就会m=默认新建一张表，表里存着name
        String sql = "create table user(name varchar(20))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //增加操作
    public void insert(String insert_data) {
        SQLiteDatabase db = getWritableDatabase();
        /* ContentValues */
        ContentValues values = new ContentValues();
        values.put("name",insert_data);
        db.insert("user",null,values);
    }

    //删除操作
    public void delete(String delete_data) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("user","name=?",new String[]{delete_data});
    }
    //修改
    public void update(String update_after_data,String update_before_data){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values2 = new ContentValues();
        values2.put("name", update_after_data);
        db.update("user", values2, "name = ?", new String[]{update_before_data});
    }

}
