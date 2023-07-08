package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class GPS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

      Button b1=findViewById(R.id.findID);
      Button bk;

      bk=findViewById(R.id.back);

      bk.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),HomePage.class);
          startActivity(i);
        }
      });




      b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),MapsActivity.class);
          startActivity(i);
        }
      });


      DBHelper db = new DBHelper(this);
      ArrayList<HashMap<String, String>> userList = db.GetRequest2();
      ListView lv = (ListView) findViewById(R.id.user_list);
      ListAdapter adapter = new SimpleAdapter(GPS.this, userList, R.layout.driver ,new String[]{"name","phone","date","location","status"}, new int[]{R.id.name,R.id.phone,R.id.date,R.id.loc,R.id.status});
      lv.setAdapter(adapter);

    }
}
