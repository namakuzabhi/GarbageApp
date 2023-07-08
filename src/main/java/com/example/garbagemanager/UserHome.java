package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHome extends AppCompatActivity {

  Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        b1=findViewById(R.id.req);
        b2=findViewById(R.id.status);
        b3=findViewById(R.id.help);

        b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent i=new Intent(getApplicationContext(),Requestt.class);
            startActivity(i);
          }
        });


      b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),Status.class);
          startActivity(i);
        }
      });

      b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),Help.class);
          startActivity(i);
        }
      });


      b4=findViewById(R.id.back);

      b4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),HomePage.class);
          startActivity(i);
        }
      });
    }
}
