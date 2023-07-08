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

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

      DBHelper db = new DBHelper(this);
      ArrayList<HashMap<String, String>> userList = db.GetUsers();
      ListView lv = (ListView) findViewById(R.id.user_list);
      ListAdapter adapter = new SimpleAdapter(detail.this, userList, R.layout.single_item,new String[]{"username","password"}, new int[]{R.id.item_user, R.id.item_pass});
      lv.setAdapter(adapter);
      Button back = (Button)findViewById(R.id.btnBack);
      back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(detail.this,AdminHome.class);
          startActivity(intent);
        }
      });
    }
}
