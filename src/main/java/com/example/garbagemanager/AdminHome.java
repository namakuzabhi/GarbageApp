package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {
Button b1,b2,b3,b4,dr,b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

      b1=findViewById(R.id.view);
      b2=findViewById(R.id.request);
      b3=findViewById(R.id.st);
      b5=findViewById(R.id.list);


      b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(AdminHome.this,detail.class);
          startActivity(i);
        }
      });
      b5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(AdminHome.this,driver_list.class);
          startActivity(i);
        }
      });

      b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(AdminHome.this,ViewUsers.class);
          startActivity(i);
        }
      });

      b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(AdminHome.this,AdminStatus.class);
          startActivity(i);
        }
      });


      dr=findViewById(R.id.dr);

      dr.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),DriverReg.class);
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
