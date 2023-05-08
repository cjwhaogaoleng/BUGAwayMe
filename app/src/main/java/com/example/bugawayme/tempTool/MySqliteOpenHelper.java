package com.example.bugawayme.tempTool;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//工具类，单例模式（构造函数私有化，对外提供函数）

public class MySqliteOpenHelper extends SQLiteOpenHelper {


    private static SQLiteOpenHelper mInstance;

    public static synchronized SQLiteOpenHelper getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MySqliteOpenHelper(context, "MyDB,db", null, 1);
        }
        return mInstance;
    }

    public MySqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //初始化
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table persons(_id integer primary key autoincrement,name text)";
        db.execSQL(sql);

    }

    //更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
