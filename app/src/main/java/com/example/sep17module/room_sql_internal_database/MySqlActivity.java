package com.example.sep17module.room_sql_internal_database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sep17module.R;
import com.example.sep17module.databinding.ActivityMySqlBinding;
import com.example.sep17module.databinding.SqlEditLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class MySqlActivity extends AppCompatActivity {
    private ActivityMySqlBinding binding;
    private SqlEditLayoutBinding binding1;
    List<Student>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMySqlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // c r u d operation in Room

        /////////////////////////////////////////  get data  ////////////////////////////////////


        list = new ArrayList<>();

        AppDatabase appDatabase = UtilityHelper.getDatabase(this);

        StudentDao dao = appDatabase.getStudentDao();

        list = dao.displayStudentData();

        ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listView.setAdapter(arrayAdapter);

        //////////////////////////////////////////////////////////////////////////////////////////////////////////

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long l) {

                binding1 = SqlEditLayoutBinding.inflate(getLayoutInflater());

                /////////     show values in edittext  //////

                Student s = list.get(i2);

                int roll = s.roll_no;
                int age = s.age;
                String name = s.name;
                String address = s.address;

                binding1.edtRollEdit.setText(String.valueOf(roll));
                binding1.edtNameEdit.setText(name);
                binding1.edtAgeEdit.setText(String.valueOf(age));
                binding1.edtAddressEdit.setText(address);

                binding1.edtRollEdit.setEnabled(false);


                ///////////////////////////////////////////////////////////////////////////////

                new AlertDialog.Builder(MySqlActivity.this)

                        .setTitle("Choose One")

                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                // update

                                ////////////////////////////// update data  ///////////////////////////////////////

                                new AlertDialog.Builder(MySqlActivity.this)
                                        .setTitle("Edit")
                                        .setView(binding1.getRoot())

                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {

                                                Student s=new Student();

                                                s.roll_no= Integer.parseInt(binding1.edtRollEdit.getText().toString());
                                                s.name = binding1.edtNameEdit.getText().toString();
                                                s.age= Integer.parseInt(binding1.edtAgeEdit.getText().toString());
                                                s.address= binding1.edtAddressEdit.getText().toString();

                                                dao.updateStudent(s);   // only in table

                                                list = dao.displayStudentData();  // get new list

                                                ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<>(MySqlActivity.this, android.R.layout.simple_list_item_1,list);

                                                binding.listView.setAdapter(arrayAdapter);


                                            }
                                        }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        dialogInterface.dismiss();

                                    }
                                }).create().show();
                                ///////////////////////////////////////////////////////////////////////////////////
                            }
                        })

                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        //delete

                        Student s = list.get(i2);

                        dao.deleteStudent(s);   // delete only from table

                        list = dao.displayStudentData();   // get new list

                        ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<>(MySqlActivity.this, android.R.layout.simple_list_item_1,list);

                        binding.listView.setAdapter(arrayAdapter);



                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                        .create().show();
                ////////////////////////////////////////////////////////////////////////////////////////////////////
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_data,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_add){

            startActivity(new Intent(this,AddStudentDataActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}