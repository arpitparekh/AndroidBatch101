package com.example.sep17module;

import android.os.Parcel;
import android.os.Parcelable;

public class Deliver implements Parcelable {

    String name;
    int amount;  // properties

    public Deliver(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    protected Deliver(Parcel in) {
        name = in.readString();
        amount = in.readInt();
    }

    public static final Creator<Deliver> CREATOR = new Creator<Deliver>() {
        @Override
        public Deliver createFromParcel(Parcel in) {
            return new Deliver(in);
        }

        @Override
        public Deliver[] newArray(int size) {
            return new Deliver[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(amount);
    }
}
