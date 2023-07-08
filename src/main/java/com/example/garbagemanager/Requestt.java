package com.example.garbagemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Requestt extends AppCompatActivity {

  private EditText e1, e2, e3, e4,e5;
  private Button addCourseBtn,b2;
  private DBHelper dbHandler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_requestt);

    e1 = findViewById(R.id.idano);
    e2 = findViewById(R.id.idname);
    e3 = findViewById(R.id.idphone);
    e4 = findViewById(R.id.iddate);
    e5 = findViewById(R.id.loc);


    addCourseBtn = findViewById(R.id.idBtnAddCourse);

    dbHandler = new DBHelper(Requestt.this);

    addCourseBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String ano = e1.getText().toString();
        String name = e2.getText().toString();
        String phone = e3.getText().toString();
        String dt = e4.getText().toString();
        String loc = e5.getText().toString();
        String status = "Pending";
        String dst="Pending";

        if (ano.isEmpty() && dt.isEmpty() && name.isEmpty() && phone.isEmpty() && loc.isEmpty()) {
          Toast.makeText(Requestt.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
          return;
        }


        dbHandler.addNewCourse(ano,name, phone, dt, loc, status,dst);

        Toast.makeText(Requestt.this, " Request Successfully Send", Toast.LENGTH_LONG).show();
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
      }
    });

    b2=findViewById(R.id.back);

    b2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),UserHome.class);
        startActivity(i);
      }
    });
  }
}
