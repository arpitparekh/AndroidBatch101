package com.example.sep17module.dateTimePicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityDateTimePickerBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimePickerActivity extends AppCompatActivity {
    private ActivityDateTimePickerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDateTimePickerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

///////////////////////////////////////////////////////////////////////////////////////////////////////
        binding.btnTime.setOnClickListener(view -> {

            Calendar c = Calendar.getInstance();   // instance means object

            int hour = c.get(Calendar.HOUR);
            int minute = c.get(Calendar.MINUTE);                // time picker

            TimePickerDialog d = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {

//                    binding.btnTime.setText(i+":"+i1);

                    String old = i+":"+i1;
/////////////////////////////////////////////////////////////////////////////////////////////
                    SimpleDateFormat hour24 = new SimpleDateFormat("HH:mm");

                    SimpleDateFormat hour12 = new SimpleDateFormat("hh:mm a");

                    Date new24Hour = null;
                    try {
                        new24Hour = hour24.parse(old);   // parse   // 24 hours to 12
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    String _12Hour = hour12.format(new24Hour);
/////////////////////////////////////////////////////////////////////////////////////////////////////
                    binding.btnTime.setText(_12Hour);

                }
            },hour,minute,true);

            d.setTitle("Choose Time");
            d.setMessage("Please Choose Time From below");
            d.setCancelable(false);
            d.show();

        });
////////////////////////////////////////////////////////////////////////////////////////////////////////
        binding.btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c =Calendar.getInstance();

                int year = c.get(Calendar.YEAR);             // date picker
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog d = new DatePickerDialog(DateTimePickerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        binding.btnDate.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                },year,month,day);

                d.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {



                    }
                });
                d.setTitle("Select Date");
                d.setMessage("Please Select Date");
                d.getDatePicker().setMinDate(System.currentTimeMillis());
                d.setIcon(R.drawable.ic_yoga);
                d.show();
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}