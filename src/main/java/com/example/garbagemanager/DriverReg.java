package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DriverReg extends AppCompatActivity {
  private EditText e1, e2, e3, e4;
  private Button b1,b2;
  private DBHelper dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_reg);

      e1 = findViewById(R.id.idano);
      e2 = findViewById(R.id.idname);
      e3 = findViewById(R.id.idphone);
      e4 = findViewById(R.id.loc);


      b1 = findViewById(R.id.dd);

      dbHandler = new DBHelper(DriverReg.this);

      b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

          String ano = e1.getText().toString();
          String name = e2.getText().toString();
          String phone = e3.getText().toString();
          String loc = e4.getText().toString();


          if (ano.equals("") && name.equals("") && phone.equals("") && loc.equals("")) {
            Toast.makeText(DriverReg.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
            e1.setError("Please enter the driver id");
            e2.setError("Please enter the name");
            e3.setError("Please enter the phone no");
            e4.setError("Please enter the address");

          }
          else if(!name.matches("^[a-zA-Z]*$"))
          {
            e2.requestFocus();
            e2.setError("ENTER ONLY ALPHABETICAL CHARACTER");
          }
          else if(!phone.matches("(0|91)?[6-9][0-9]{9}"))
          {
            e3.requestFocus();
            e3.setError("Phone Number should be 10 digits");
          }
          else
          {

          dbHandler.addDriver(ano,name, phone, loc);

          Toast.makeText(DriverReg.this, " Driver Successfully Added", Toast.LENGTH_LONG).show();
          e1.setText("");
          e2.setText("");
          e3.setText("");
          e4.setText("");}
        }
      });

      b2=findViewById(R.id.back);

      b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent i=new Intent(getApplicationContext(),HomePage.class);
          startActivity(i);
        }
      });
    }
}
