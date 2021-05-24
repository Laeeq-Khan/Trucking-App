package com.example.fyp.Company;


import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fyp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ShowCompanyAllCustomerDetails extends AppCompatActivity {

    private TextView nameText, phoneText, cnicText;
    ImageView imageView;
    String uid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_company_all_customer_details);

        uid=getIntent().getStringExtra("customerId");

        nameText = findViewById(R.id.CProfileName);
        phoneText = findViewById(R.id.CProfilePhone);
        cnicText = findViewById(R.id.CProfileCnic);
        imageView = findViewById(R.id.showCustomerprofile_image);

        showEveryThing();




    }







    public void showEveryThing(){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child("Customers").child(uid);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nameText.setText(dataSnapshot.child("name").getValue(String.class));
                phoneText.setText(dataSnapshot.child("mobile").getValue(String.class));
                cnicText.setText(dataSnapshot.child("cnic").getValue(String.class));

                String image = dataSnapshot.child("image").getValue().toString();

                //String s = dataSnapshot.child("image").getValue(String.class);
                if (!image.equals("default")) {
                    Picasso.get().load(image).into(imageView);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


}























