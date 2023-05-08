package com.example.bugawayme.db.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao//Database access object
public interface StudentDao {

    //insert
    @Insert
    void insertStudent(Student... students);

    @Update
    void updateStudent(Student... students);

    @Delete
    void deleteStudent(Student... students);

    @Query("DELETE FROM Student")
    void deleteAllStudents();

    @Query("SELECT * FROM STUDENT ORDER BY _ID DESC")
    List<Student> getAllStudents();

}
