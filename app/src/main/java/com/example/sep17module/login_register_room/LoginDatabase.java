package com.example.sep17module.login_register_room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {LoginData.class},version = 1,exportSchema = false)
public abstract class LoginDatabase extends RoomDatabase {

    public abstract LoginDao getDao();

    public static LoginDatabase getDatabase(Context context){

        LoginDatabase database = Room.databaseBuilder(context,LoginDatabase.class,"LoginDatabase")

                .build();

        return database;


    }
}
