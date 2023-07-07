package com.example.bugawayme.db;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.bugawayme.R;
import com.example.bugawayme.util.MySqliteOpenHelper;

public class testActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


    }

    public void createDB(View view) {
        SQLiteOpenHelper instance = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase readableDatabase = instance.getReadableDatabase();
    }

    public void insert(View view) {
        SQLiteOpenHelper instance = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase db = instance.getWritableDatabase();
        if (db.isOpen()) {
            String sql = "insert into persons(name) values('hyk')";
            db.execSQL(sql);
            db.close();

        }
    }

    @SuppressLint("Range")
    public void select(View view) {
        SQLiteOpenHelper instance = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase db = instance.getReadableDatabase();

        if (db.isOpen()) {
            Cursor cursor = db.rawQuery("select * from persons", null);

            while (cursor.moveToNext()) {
                int _id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                Log.d(TAG, "select: " + _id + " " + name);


            }
            cursor.close();
            db.close();
        }


    }

    public void update(View view) {
        SQLiteOpenHelper instance = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase db = instance.getWritableDatabase();
        if (db.isOpen()) {

            String sql = "update persons set name=? where _id=?";
            db.execSQL(sql, new Object[]{"kkk", 5});
            db.close();

        }
    }

    public void delete(View view) {
        SQLiteOpenHelper instance = MySqliteOpenHelper.getInstance(this);
        SQLiteDatabase db = instance.getWritableDatabase();
        if (db.isOpen()) {

            String sql = "delete from persons where _id = ?";

            db.execSQL(sql, new Object[]{4});
            db.close();

        }
    }
}