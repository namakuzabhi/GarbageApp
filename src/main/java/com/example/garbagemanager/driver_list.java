package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class driver_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver_list);
      DBHelper db = new DBHelper(this);
      ArrayList<HashMap<String, String>> userList = db.GetDrivers();
      ListView lv = (ListView) findViewById(R.id.list);
      ListAdapter adapter = new SimpleAdapter(driver_list.this, userList, R.layout.driver_item,new String[]{"dno","name","phone","location"}, new int[]{R.id.driver_id, R.id.driver_name,R.id.driver_phone,R.id.driver_location});
      lv.setAdapter(adapter);
      Button back = (Button)findViewById(R.id.user);
      back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(driver_list.this,AdminHome.class);
          startActivity(intent);
        }
      });
    }
}
