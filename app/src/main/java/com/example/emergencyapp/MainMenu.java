package com.example.emergencyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    public void goEdit(View view){
        startActivity(new Intent(getApplicationContext(), AddContacts.class));
    }

    public void goReg(View view){
        startActivity(new Intent(getApplicationContext(), SignUp_Login.class));
    }
}