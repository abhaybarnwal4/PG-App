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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
public EditText loginEmail,loginPass;
public ImageButton loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        loginEmail = (EditText)findViewById(R.id.login_email);
        loginPass = (EditText)findViewById(R.id.login_password);
        loginBtn = (ImageButton) findViewById(R.id.Login_button1);

       loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = loginEmail.getText().toString();
                String pass = loginPass.getText().toString();

                if(mail.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, "All the Fields should be filled properly", Toast.LENGTH_SHORT).show();
                }else{

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this,Mainpage.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

            }
        });


    }
}