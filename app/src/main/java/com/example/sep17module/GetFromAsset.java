package com.example.sep17module;

import android.app.Activity;
import android.util.Log;

import java.io.InputStream;

public class GetFromAsset {

    public static String getJsonString(String json1, Activity activity) {
        String json ="";
        try{
            InputStream is = activity.getAssets().open(json1);
            byte data[] = new byte[is.available()];
            is.read(data);
            json = new String(data,"UTF-8");
            return json;

        }catch (Exception e){
            Log.i("error",e.getMessage());
        }
        return null;
    }

}
