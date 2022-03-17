package com.example.sep17module.login_register_room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LoginDao {

    @Insert
    void insert(LoginData data);

    @Query("delete from LoginData")
    void deleteTable();

    @Query("Select * from LoginData where email = :email and password =:password")
    boolean checkLogin(String email,String password);

    @Query("Select * from LoginData where email = :email and password =:password")
    LoginData findData(String email,String password);

    @Query("Select * from LoginData where email = :email")
    LoginData find(String email);

    @Query("Select * from LoginData where email = :email")
    boolean checkAtRegister(String email);

    @Insert
    void insertWholeList(List<LoginData> list);

    @Query("select SUM(password) as total from LoginData")
    long total();



}
