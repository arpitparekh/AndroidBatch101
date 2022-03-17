package com.example.sep17module.switching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.classes.Student;
import com.example.sep17module.databinding.ActivityFirstBinding;
import com.example.sep17module.databinding.ActivitySecondBinding;

public class FirstActivity extends AppCompatActivity {

    @Override
    public void setTheme(int resId) {
        super.setTheme(resId);
    }

    private ActivityFirstBinding binding;  //declare
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnSubmit.setOnClickListener(view -> {

//           Intent intent=new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
//            intent.putExtra(Intent.EXTRA_EMAIL,"hemanggoswami987@gmail.com");
//            intent.putExtra(Intent.EXTRA_TEXT,"Random number");
//           startActivity(intent);

            Intent intent=new Intent(this,SecondActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in,R.anim.slide_in);
        });


    }

    @Override
    protected void onPause() {
        Toast.makeText(this,"pause",Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this,"stop",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onResume() {
        Toast.makeText(this,"resume",Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(this,"restart",Toast.LENGTH_SHORT).show();
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Toast.makeText(this,"start",Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this,"destroy",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}