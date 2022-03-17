package com.example.sep17module.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.sep17module.databinding.ActivityProgressDialogBinding;

public class ProgressDialogActivity extends AppCompatActivity {
    private ActivityProgressDialogBinding binding;
    private ProgressDialog pd;
    private ProgressDialog pd1;
    int start = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProgressDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.btnShowDialog.setOnClickListener(view -> {

            pd= new ProgressDialog(this);

            pd.setTitle("Downloading...");
            pd.setMessage("Downloading Please Wait....");
//            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.setCancelable(false);

            pd.show();

            new Thread(() -> {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                pd.dismiss();
            }).start();

        });

        binding.button4.setOnClickListener(view -> {

            pd1= new ProgressDialog(this);

            pd1.setTitle("Downloading...");
            pd1.setMessage("Downloading Please Wait....");
            pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd1.setProgress(0);
            pd1.setMax(10);
            pd1.setCancelable(false);

            pd1.show();

            start=0;

            new Thread(new Runnable() {

                @Override
                public void run() {

                    while(pd1.getProgress()<=pd1.getMax()){
                        try {
                            Thread.sleep(1000);
                            start++;
                            pd1.setProgress(start);

                            if(pd1.getProgress()==pd1.getMax()){

                                pd1.dismiss();
                                return;                  // don't forget this..........
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        });
    }
}