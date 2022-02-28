package com.example.pgapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public EditText email,pass;
    public ImageButton login;
    public ImageButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        email = (EditText)findViewById(R.id.email_reg);
        pass = (EditText)findViewById(R.id.password_reg);
        login = (ImageButton)findViewById(R.id.Log_button_reg);
        register = (ImageButton) findViewById(R.id.Reg_button_reg);



























        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_user = email.getText().toString();
                String pass_user = pass.getText().toString();

                if(email_user.equals("")||pass_user.equals("")){
                    Toast.makeText(MainActivity.this, "All the fields are necessary", Toast.LENGTH_SHORT).show();
                }

                else{
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email_user,pass_user).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });


    }

    public void move(){

    }

}