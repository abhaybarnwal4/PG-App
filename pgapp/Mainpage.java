package com.example.pgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class Mainpage extends AppCompatActivity {
    public ImageButton button2;
    public ImageButton button3;
    public ImageButton button4;
    public ImageButton button5;
    public  Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();



        button = (Button)findViewById(R.id.btn_et);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Mainpage.this,upload_details.class);
                startActivity(intent);
            }
        });






        button2 = (ImageButton) findViewById(R.id.image12);
        button3=(ImageButton)findViewById(R.id.image13);
        button4=(ImageButton)findViewById(R.id.image14);
        button5=(ImageButton)findViewById(R.id.image15);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Mainpage.this,mainview.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this,mainview.class);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Mainpage.this,mainview.class);
                startActivity(i);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent u = new Intent(Mainpage.this,mainview.class);
             startActivity(u);
            }
        });
    }
}