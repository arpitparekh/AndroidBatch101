package com.example.sep17module.progressDialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityProgressDiallogNewBinding;

public class ProgressDiallogNewActivity extends AppCompatActivity {
    private ActivityProgressDiallogNewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProgressDiallogNewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.buttonProgress1.setOnClickListener(view -> {

            ProgressDialog pd =new ProgressDialog(this);
            pd.setTitle("Downloading");
            pd.setMessage("File is being Downloaded");
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.setCancelable(false);
            pd.show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try{
                        Thread.sleep(3000);
                        pd.dismiss();
                    }catch (Exception e){

                    }


                }
            }).start();


        });

        binding.buttonProgress2.setOnLongClickListener(view -> {

            ProgressDialog pd =new ProgressDialog(this);
            pd.setTitle("Downloading");
            pd.setMessage("File is being Downloaded");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setMax(100);
            pd.setProgress(0);
            pd.setIcon(R.drawable.ic_yoga);
            pd.setCancelable(true);
            pd.show();

            Log.i("progress",String.valueOf(pd.getMax()));
            Log.i("progress",String.valueOf(pd.getProgress()));



            new Thread(new Runnable() {
                @Override
                public void run() {
                    int x=0;
                   while(pd.getProgress()<=pd.getMax())
                        try {
                            Thread.sleep(100);
                            pd.setProgress(x);
                            x++;
                            if(pd.getProgress()==pd.getMax()){
                                pd.dismiss();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }



            }).start();
            return true;
        });
    }
}