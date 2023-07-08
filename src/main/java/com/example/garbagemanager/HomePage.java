package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        b1=findViewById(R.id.login);

        b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent i=new Intent(getApplicationContext(),UserLogin.class);
            startActivity(i);
          }
        });


      b2=findViewById(R.id.admin);

      b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),AdminLogin.class);
          startActivity(i);
        }
      });


      b3=findViewById(R.id.driver);

      b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),DriverLogin.class);
          startActivity(i);
        }
      });

    }
}
