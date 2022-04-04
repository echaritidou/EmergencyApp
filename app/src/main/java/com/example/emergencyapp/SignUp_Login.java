package com.example.emergencyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp_Login extends AppCompatActivity {
    EditText editText, editTextPassword;
    FirebaseAuth auth;
    Button registerButton;
    FirebaseDatabase database;
    DatabaseReference mreference;
    private static final String USER = "user";
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login);
        editText = findViewById(R.id.editTextTextPersonName);
        editTextPassword = findViewById(R.id.editTextTextPersonPassword);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        mreference = database.getReference(USER);

        registerButton = findViewById(R.id.button2);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editText.getText().toString();
                user = new User(email);
                register(email);

            }
        });
    }


    public void register(String Email){
        String email = editText.getText().toString();
        String password = editTextPassword.getText().toString();
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if (task.isSuccessful()){
                   showMessage("Success", "User created successfully!");
                   //FirebaseUser user = auth.getCurrentUser();
                   //upDate(user);
                   User user = new User();
                   mreference.child("users").setValue(user);
                   startActivity(new Intent(getApplicationContext(), ContactAcivity.class));
               }else{
                   showMessage("Error", task.getException().getLocalizedMessage());
               }
           }
       });
    }

    public void login(View view){
        String email = editText.getText().toString();
        String password = editTextPassword.getText().toString();
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    showMessage("Success","User signed in successfully!");

                    startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                }else {
                    showMessage("Error",task.getException().getLocalizedMessage());
                }
            }
        });
    }

    void showMessage(String title, String message){
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setCancelable(true).show();
    }

    public void upDate(FirebaseUser currentUser){
        String UID = auth.getUid();

        mreference.child(UID).setValue(user);
    }
}