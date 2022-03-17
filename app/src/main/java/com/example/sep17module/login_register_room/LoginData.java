package com.example.sep17module.login_register_room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoginData {

    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "password")
    String password;

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
