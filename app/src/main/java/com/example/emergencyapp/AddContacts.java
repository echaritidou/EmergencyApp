package com.example.emergencyapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddContacts extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myref, myref2, myref3, myref4, myref5, myref6, myref7,myref8, myref9,myref10,myref11;
    FirebaseAuth auth;
    FirebaseUser user;
    EditText name1, phone1;
    EditText name3, phone3;
    EditText name4, phone4;
    EditText name5, phone5;
    EditText name6, phone6;
    Contact contactUpdate;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        database= FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        myref = database.getReference(user.getUid()).child("AllContacts");
        myref2 = myref.child("Contact1").child("name");
        myref3 = myref.child("Contact1").child("phoneNumber");
        myref4 = myref.child("Contact2").child("name");
        myref5 = myref.child("Contact2").child("phoneNumber");
        myref6 = myref.child("Contact3").child("name");
        myref7 = myref.child("Contact3").child("phoneNumber");
        myref8 = myref.child("Contact4").child("name");
        myref9 = myref.child("Contact4").child("phoneNumber");
        myref10 = myref.child("Contact5").child("name");
        myref11 = myref.child("Contact5").child("phoneNumber");

        showContact();
        name1 = findViewById(R.id.editTextTextPersonName6);
        phone1 = findViewById(R.id.editTextTextPersonName7);
        name3 = findViewById(R.id.editTextTextPersonName8);
        phone3 = findViewById(R.id.editTextTextPersonName9);
        name4 = findViewById(R.id.editTextTextPersonName10);
        phone4 = findViewById(R.id.editTextTextPersonName11);
        name5 = findViewById(R.id.editTextTextPersonName12);
        phone5 = findViewById(R.id.editTextTextPersonName13);
        name6 = findViewById(R.id.editTextTextPersonName14);
        phone6 = findViewById(R.id.editTextTextPersonName15);

    }

    public void showContact(){
        myref2.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name1.setText(snapshot.getValue(String.class), TextView.BufferType.EDITABLE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        myref3.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                phone1.setText(snapshot.getValue(String.class), TextView.BufferType.EDITABLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myref4.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name3.setText(snapshot.getValue(String.class), TextView.BufferType.EDITABLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myref5.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                phone3.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myref6.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name4.setText(snapshot.getValue(String.class), TextView.BufferType.EDITABLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myref7.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                phone4.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myref8.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name5.setText(snapshot.getValue(String.class), TextView.BufferType.EDITABLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myref9.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                phone5.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        myref10.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name6.setText(snapshot.getValue(String.class), TextView.BufferType.EDITABLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myref11.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                phone6.setText(snapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void editContact1(View view){
        if (name1.getText().toString().equals("") || phone1.getText().toString().equals("")) {
            showMessage("Madatory", "All inputs are mandatory.");
        }else{
            //myref2.setValue(name1.getText().toString());
            //myref3.setValue(phone1.getText().toString());
            myref.child("Contact1").removeValue();
            showMessage("Edit", "Contact changed successfully!");
        }
    }
    public void editContact2(View view){
        if (name3.getText().toString().equals("") || phone3.getText().toString().equals("")) {
            showMessage("Madatory", "All inputs are mandatory.");
        }else{
            myref4.setValue(name3.getText().toString());
            myref5.setValue(phone3.getText().toString());
            showMessage("Edit", "Contact changed successfully!");
        }
    }
    public void editContact3(View view){
        if (name4.getText().toString().equals("") || phone4.getText().toString().equals("")) {
            showMessage("Madatory", "All inputs are mandatory.");
        }else{
            myref6.setValue(name4.getText().toString());
            myref7.setValue(phone4.getText().toString());
            showMessage("Edit", "Contact changed successfully!");
        }
    }
    public void editContact4(View view){
        if (name5.getText().toString().equals("") || phone5.getText().toString().equals("")) {
            showMessage("Madatory", "All inputs are mandatory.");
        }else{
            myref8.setValue(name5.getText().toString());
            myref9.setValue(phone5.getText().toString());
            showMessage("Edit", "Contact changed successfully!");
        }
    }
    public void editContact5(View view){
        if (name6.getText().toString().equals("") || phone6.getText().toString().equals("")) {
            showMessage("Madatory", "All inputs are mandatory.");
        }else{
            myref10.setValue(name6.getText().toString());
            myref11.setValue(phone6.getText().toString());
            showMessage("Edit", "Contact changed successfully!");
        }
    }

    void showMessage(String title, String message){
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setCancelable(true).show();
    }
}