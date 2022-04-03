package com.example.emergencyapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactAcivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference mdatabase;
    Button addContact;
    EditText editTextContactName, editTextContactPhone;
    private  Contact contact;
    FirebaseAuth auth;
    DatabaseReference AllContacts;
    FirebaseUser user;
    DataSnapshot dataSnapshot;
    Button next;

    int clickcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_acivity);
        editTextContactName= findViewById(R.id.editTextContactName);
        editTextContactPhone = findViewById(R.id.editTextContactPhne);
        database = FirebaseDatabase.getInstance();
        mdatabase = database.getReference();
        auth = FirebaseAuth.getInstance();
        AllContacts = database.getReference();
        user = auth.getCurrentUser();
        next = findViewById(R.id.button5);
        next.setEnabled(false);
        addContact = findViewById(R.id.button4);
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcount = clickcount+1;
                String contactName = editTextContactName.getText().toString();
                String contactPhone = editTextContactPhone.getText().toString();
                FirebaseUser user = auth.getCurrentUser();
                contact = new Contact(contactName, contactPhone);

                    if (editTextContactName.getText().toString().equals("") || editTextContactPhone.getText().toString().equals("")) {
                        showMessage("Madatory", "All inputs are mandatory.");
                    } else if (editTextContactPhone.length() < 10) {
                        showMessage("Short", "Phone number should be 10 character.");
                    } else {
                        showMessage("Ok", "Contact added. Please add another contact or tap 'next'");
                        addContact(contactName, contactPhone, user);
                    }

                }

        });
    }

    public void addContact(String contactName, String contactPhone, FirebaseUser user){

        if (clickcount==1){
            mdatabase.child(user.getUid()).child("AllContacts").child("Contact1").setValue(contact);
            editTextContactPhone.getText().clear();
            editTextContactName.getText().clear();
            next.setEnabled(true);
        }else if (clickcount==2){
            mdatabase.child(user.getUid()).child("AllContacts").child("Contact2").setValue(contact);
            editTextContactPhone.getText().clear();
            editTextContactName.getText().clear();
        }
        else if (clickcount==3){
            mdatabase.child(user.getUid()).child("AllContacts").child("Contact3").setValue(contact);
            editTextContactPhone.getText().clear();
            editTextContactName.getText().clear();
        }else if (clickcount==4){
            mdatabase.child(user.getUid()).child("AllContacts").child("Contact4").setValue(contact);
            editTextContactPhone.getText().clear();
            editTextContactName.getText().clear();
        }else if (clickcount==5){
            mdatabase.child(user.getUid()).child("AllContacts").child("Contact5").setValue(contact);
            editTextContactPhone.getText().clear();
            editTextContactName.getText().clear();
        }else{
            showMessage("Contact overload", "You can add up to 5 contacts.");
            startActivity(new Intent(getApplicationContext(), FallActivity.class));
        }


                //showMessage("Contact overload", "You can add up to 5 contacts.");
               // mdatabase.child(user.getUid()).child("AllContacts").child("Contact").push().setValue(contact);
        }

        public void next(View view){

        startActivity(new Intent(getApplicationContext(), FallActivity.class));

        }



        /*String UID = auth.getUid();
        mdatabase.child(UID).setValue(contact);
        AllContacts.push().setValue(contact);
        startActivity(new Intent(getApplicationContext(), ContactAcivity.class));*/


    void showMessage(String title, String message){
        new AlertDialog.Builder(this).setTitle(title).setMessage(message).setCancelable(true).show();
    }
}