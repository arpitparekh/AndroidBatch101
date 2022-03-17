package com.example.sep17module.room_sql_internal_database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student s);

    @Update
    void updateStudent(Student s);

    @Delete
    void deleteStudent(Student s);

    @Query("SELECT * FROM Student")
    List<Student> displayStudentData();

    @Query("SELECT * FROM student WHERE roll_no = :roll_no ")
    Student getSpecificData(int roll_no);


}
