package com.example.sep17module.room_sql_internal_database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1,exportSchema = false)

public abstract class AppDatabase extends RoomDatabase {

    abstract StudentDao getStudentDao();

}


