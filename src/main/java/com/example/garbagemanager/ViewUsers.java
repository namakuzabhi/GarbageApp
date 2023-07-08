package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


import androidx.appcompat.app.AppCompatActivity;

public class ViewUsers extends AppCompatActivity {

 TextView t1,t2;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_users);
    DBHelper db = new DBHelper(this);
    ArrayList<HashMap<String, String>> userList = db.GetRequest();
    ListView lv = (ListView) findViewById(R.id.user_list);
    ListAdapter adapter = new SimpleAdapter(ViewUsers.this, userList, R.layout.activity_row ,new String[]{"ano","name","phone","date","location"}, new int[]{R.id.ano,R.id.name,R.id.phone,R.id.date,R.id.loc});
    lv.setAdapter(adapter);
      }
}
