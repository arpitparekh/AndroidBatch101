package com.example.sep17module.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DownloadService extends Service {



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        downloadFile();

        return super.onStartCommand(intent, flags, startId);
    }

    private void downloadFile() {

//        Executor executor = Executors.newSingleThreadExecutor();
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    URL url = new URL("https://file-examples-com.github.io/uploads/2017/10/file_example_JPG_100kB.jpg");

                    InputStream is = url.openStream();
                    DataInputStream ds = new DataInputStream(is);

                    byte arr[]=new byte[1024];

                    FileOutputStream os = new FileOutputStream(Environment.getExternalStorageDirectory()+"/"+"demo.jpg");

                    int i;
                    while((i=ds.read(arr))>0){

                        os.write(arr,0,i);
                    }
                    ds.close();
                    os.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
