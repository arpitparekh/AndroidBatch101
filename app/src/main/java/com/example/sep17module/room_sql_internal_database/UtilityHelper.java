package com.example.sep17module.room_sql_internal_database;

import android.content.Context;

import androidx.room.Room;

public class UtilityHelper {

    public static AppDatabase getDatabase(Context context){
        AppDatabase appDatabase =
                Room.databaseBuilder(context,AppDatabase.class,"My Database")
                .allowMainThreadQueries()
                .build();

                return appDatabase;
    }
}
