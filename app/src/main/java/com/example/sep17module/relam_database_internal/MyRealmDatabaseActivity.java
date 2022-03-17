package com.example.sep17module.relam_database_internal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.sep17module.databinding.ActivityMyRealmDatabaseBinding;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MyRealmDatabaseActivity extends AppCompatActivity {
    private ActivityMyRealmDatabaseBinding binding;
    private Realm realm;
    private RealmResults<User> list;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMyRealmDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .allowWritesOnUiThread(true)
                .allowQueriesOnUiThread(true)
                .name("MyRealmDatabase")
                .build();

        realm = Realm.getInstance(configuration);

        displayUser();

        binding.listViewRealm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                user = list.get(i);

                new AlertDialog.Builder(MyRealmDatabaseActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                binding.edtNameRealm.setText(user.name);
                                binding.edtEmailRealm.setText(user.email);
                                binding.edtAdressRealm.setText(user.address);
                            }
                        }).setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteUser(user.name);
                        displayUser();
                    }
                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create().show();

            }
        });

        binding.btnSubmitRealm.setOnClickListener(view -> {
            if(user==null){
                insertUser();
                cleanUser();
            }else{
                updateUser(user.name);
            }
            displayUser();
        });

    }
///////////////////////////////////////////////   update  //////////////////////////////////////////
    private void updateUser(String name) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.where(User.class).equalTo("name",name).findFirst();
                if(user!=null){
                    user.name=binding.edtNameRealm.getText().toString();
                    user.email=binding.edtEmailRealm.getText().toString();
                    user.address=binding.edtAdressRealm.getText().toString();
                }


            }
        });
        displayUser();
        cleanUser();
    }
    ////////////////////////////////////////  delete   ////////////////////////////////////////////////////////
    private void deleteUser(String name) {


        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                // find particular user object from database by comparing names
                User user = realm.where(User.class).equalTo("name",name).findFirst();

                if(user!=null){
                    user.deleteFromRealm();
                }

            }
        });
    }
    ////////////////////////////////   display user ///////////////////////////////////////////////////
    void displayUser(){

        list = realm.where(User.class).findAll();

        ArrayAdapter<User> adapter = new ArrayAdapter<>(MyRealmDatabaseActivity.this, android.R.layout.simple_list_item_1,list);

        binding.listViewRealm.setAdapter(adapter);

    }

    /////////////////////////////////  insert user  /////////////////////////////////////////////////////
    void insertUser(){

        String name = binding.edtNameRealm.getText().toString();
        String email = binding.edtEmailRealm.getText().toString();
        String address = binding.edtAdressRealm.getText().toString();

        if(!name.equals("") && !email.equals("") && !address.equals("")){

            User user = new User(name,email,address);

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(user);
                }
            });

        }
    }

    //////////////////////////////////////////////  clean user   /////////////////////////////////////////////
    void cleanUser(){

        binding.edtNameRealm.setText("");
        binding.edtEmailRealm.setText("");
        binding.edtAdressRealm.setText("");
        user=null;

    }
}