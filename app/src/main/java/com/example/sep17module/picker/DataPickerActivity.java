package com.example.sep17module.picker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.sep17module.databinding.ActivityDataPickerBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DataPickerActivity extends AppCompatActivity {
    private ActivityDataPickerBinding binding;
    private String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDataPickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.materialButton.setOnClickListener(view -> {

            //time picker

            Calendar calendar = Calendar.getInstance();

            int hour = calendar.get(Calendar.HOUR);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @RequiresApi(api = Build.VERSION_CODES.O)
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {

//                    binding.materialButton.setText(i+":"+i1);
//
                    time = i+":"+i1;
                    SimpleDateFormat hour24 = new SimpleDateFormat("HH:mm");
                    SimpleDateFormat hour12 = new SimpleDateFormat("hh:mm a");

                    try {

                        Date new24Hour = hour24.parse(time);
                        binding.materialButton.setText(hour12.format(new24Hour));
                    }
                    catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            },hour,minute,false);

            timePickerDialog.setTitle("Choose Time");
            timePickerDialog.setMessage("Please Choose Time From Below");
            timePickerDialog.show();


        });

        binding.materialButton2.setOnClickListener(view -> {


            Calendar calendar=Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    binding.materialButton2.setText(i+"/"+i1+"/"+i2);
                }
            },year,month,day);

            datePickerDialog.setTitle("Choose Date");
            datePickerDialog.show();

        });



    }
}