package com.example.sep17module.room_sql_internal_database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey
    int roll_no;

    @ColumnInfo(name="name")
    String name;

    @ColumnInfo(name="age")
    int age;

    @ColumnInfo(name="address")
    String address;

    @Override
    public String toString() {
        return
                "roll_no=" + roll_no +
                "\nname= " + name +
                "\nage= " + age +
                "\naddress= " + address ;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
