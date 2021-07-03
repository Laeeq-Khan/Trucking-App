package com.example.fyp.Company;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fyp.R;

public class CompanyLogIn extends AppCompatActivity {

    Button companyLogIn;
Button xyz;
    EditText companyEmail, companyPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_log_in);
        companyEmail = findViewById(R.id.companyEmail);
        companyPassword = findViewById(R.id.companyPassword);
        companyEmail.setText("comapny@gmail.com");
        companyPassword.setText("company");
        findViewById(R.id.companyLogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (companyEmail.getText().toString().equals("comapny@gmail.com") && companyPassword.getText().toString().equals("company")){
                    Intent intent=new Intent(CompanyLogIn.this,CompanyMainPage.class);
                    startActivity(intent);
                }
            }
        });

    }
}
