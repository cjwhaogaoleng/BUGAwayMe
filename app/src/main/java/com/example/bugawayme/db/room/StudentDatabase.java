package com.example.bugawayme.db.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {


    public abstract StudentDao getStudentDao();

    //单例模式
    private static StudentDatabase INSTANCE;

    public static synchronized StudentDatabase getInstance(Context context) {
        if (INSTANCE==null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StudentDatabase.class, "Student_database")
                    //异步线程
//                    强制开启在主线程也可以用，实际开发中不要用
//                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
