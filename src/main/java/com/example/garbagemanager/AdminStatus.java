package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminStatus extends AppCompatActivity {
  Button b1,b2,b3;
  EditText e1;
  TextView loc,locat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_status);

      DBHelper DB = new DBHelper(this);


      e1=findViewById(R.id.uid);
      b1=findViewById(R.id.btncheck);

      loc=findViewById(R.id.loc);
      locat=findViewById(R.id.locat);

      b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          String id=e1.getText().toString();
          Cursor cursor = DB.getStatus(id);

          if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
            loc.setVisibility(View.GONE);
            locat.setVisibility(View.GONE);

          }

          StringBuffer buffer = new StringBuffer();

          while (cursor.moveToNext()) {
           // t1.setText(buffer.append( cursor.getString(5) ));
            locat.setText(buffer.append( cursor.getString(5) ));

            loc.setVisibility(View.VISIBLE);
            locat.setVisibility(View.VISIBLE);

          }

        }
      });


      b2=findViewById(R.id.btnup);

      b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          String id=e1.getText().toString();
          Cursor cursor = DB.getupdate(id);

          Cursor cursor1 = DB.getStatus(id);

          if (cursor1.getCount() ==0) {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
         }

          StringBuffer buffer = new StringBuffer();

          while (cursor1.moveToNext()) {
            Toast.makeText(getApplicationContext(), "Your Request is Confirmed", Toast.LENGTH_SHORT).show();

          }


          while (cursor.moveToNext()) {

          }

        }
      });


      b3=findViewById(R.id.btnrej);

      b3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          String id = e1.getText().toString();
          Cursor cursor = DB.getReject(id);

          Cursor cursor1 = DB.getStatus(id);

          if (cursor1.getCount() ==0) {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
          }

          StringBuffer buffer = new StringBuffer();

          while (cursor1.moveToNext()) {
            Toast.makeText(getApplicationContext(), "Your Request is Rejected", Toast.LENGTH_SHORT).show();

          }
          while (cursor.moveToNext()) {

        }}


      });
    }
}
