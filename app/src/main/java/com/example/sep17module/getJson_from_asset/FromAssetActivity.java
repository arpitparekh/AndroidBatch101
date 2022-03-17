package com.example.sep17module.getJson_from_asset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Canvas;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.sep17module.GetFromAsset;
import com.example.sep17module.databinding.ActivityFromAssetBinding;
import com.example.sep17module.getJson_from_asset.data.DataItem;
import com.example.sep17module.getJson_from_asset.data.User;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FromAssetActivity extends AppCompatActivity {
    private ActivityFromAssetBinding binding;
    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFromAssetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        json = GetFromAsset.getJsonString("demo.json",this);

        Gson gson = new Gson();   // convert json string into Java Object

        User user = gson.fromJson(json,User.class);

        List<DataItem> list =user.getData();

        ArrayAdapter<DataItem> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listView.setAdapter(adapter);



        try {

            JSONObject masterObject = new JSONObject(json);
            JSONArray array = masterObject.getJSONArray("data");

            for(int i=0;i< array.length();i++){

                JSONObject object = array.getJSONObject(i);
                String name = object.getString("name");
                String age = object.getString("age");

              String address = object.getString("address");



                  Log.i("c",address);
                Log.i("c",name);
                Log.i("c",age);

            }


        } catch (JSONException e) {
            Log.i("c",e.toString());
        }



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("myINt",23);  // get Text
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Integer i = (Integer) savedInstanceState.get("myINt");  // setTExt

        super.onRestoreInstanceState(savedInstanceState);
    }
}