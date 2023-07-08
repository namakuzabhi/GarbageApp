package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Status extends AppCompatActivity {
Button b1;
EditText e1;
TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_status);
      DBHelper DB = new DBHelper(this);


      e1 = findViewById(R.id.uid);
      b1 = findViewById(R.id.btncheck);
      t1 = findViewById(R.id.st);

      b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          String id = e1.getText().toString();
          Cursor cursor = DB.getAllData(id);

          if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_SHORT).show();
            t1.setVisibility(View.GONE);

          }

          StringBuffer buffer = new StringBuffer();

          while (cursor.moveToNext()) {
            t1.setText(buffer.append(cursor.getString(6)));
            t1.setVisibility(View.VISIBLE);

          }

        }
      });

    }
}
