package com.example.sep17module.room_sql_internal_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sep17module.databinding.ActivityAddStudentDataBinding;

public class AddStudentDataActivity extends AppCompatActivity {
    private ActivityAddStudentDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddStudentDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase appDatabase = UtilityHelper.getDatabase(this);

        StudentDao dao = appDatabase.getStudentDao();

        binding.btnSubmit.setOnClickListener(view -> {

            Student s = new Student() ;

            s.roll_no = Integer.parseInt(binding.edtKey.getText().toString());
            s.name= binding.edtName.getText().toString();
            s.age = Integer.parseInt(binding.edtAge.getText().toString());
            s.address=binding.edtAddress.getText().toString();

            dao.insertStudent(s);

            Toast.makeText(this,"Data Added Successfully",Toast.LENGTH_LONG).show();

            startActivity(new Intent(this,MySqlActivity.class));

        });
    }
}