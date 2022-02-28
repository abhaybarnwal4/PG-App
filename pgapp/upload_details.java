package com.example.pgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class upload_details extends AppCompatActivity {


    EditText name,mob,address;
    Button regbtn,showbtn;


    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference refrence = db.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_details);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        name = (EditText)findViewById(R.id.name_et);
        address =(EditText)findViewById(R.id.address_et);
        mob = (EditText)findViewById(R.id.mob_et);
        regbtn =(Button) findViewById(R.id.reg_btn);
        showbtn = (Button) findViewById(R.id.show_btn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= name.getText().toString();
                String adress= address.getText().toString();
                String mobile= mob.getText().toString();

                HashMap<String,Object> usermap = new HashMap<>();
                usermap.put("name",Name);
                usermap.put("Address",adress);
                usermap.put("Mobile",mobile);


                refrence.push().setValue(usermap);

                Toast.makeText(upload_details.this, "Data is Registered", Toast.LENGTH_SHORT).show();


            }
        });
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),recyclerview.class);
                startActivity(intent);
            }
        });
    }
}