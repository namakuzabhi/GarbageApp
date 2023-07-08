package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
  EditText e1, e2;
  Button b1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_admin_login);

    e1 = findViewById(R.id.username1);
    e2 = findViewById(R.id.password1);

    b1=findViewById(R.id.btnlogin);

    b1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String a = e1.getText().toString();
        String b = e2.getText().toString();

        if(a.equals("") && b.equals(""))
        {
          Toast.makeText(AdminLogin.this, "All Fields are Required ", Toast.LENGTH_SHORT).show();
          e1.setError("Empty");
          e2.setError("Empty");

        }
        else if(!a.matches("^[a-zA-Z]*$"))
        {
          e1.setError("Only Alpha Characters Allowed");
        }
        else if(!b.matches("^[a-zA-Z]*$"))
        {
          e1.setError("Only Alpha Characters Allowed");
        }
        else if(a.length() <=5 && b.length() <=5){
          if(a.equals("admin") && b.equals("admin"))
          {
          Toast.makeText(AdminLogin.this, "Success ", Toast.LENGTH_SHORT).show();
          e1.setText("");
          e2.setText("");
          Intent i=new Intent(AdminLogin.this,AdminHome.class);
          startActivity(i);
          } }
        else
        {
          Toast.makeText(AdminLogin.this, "Failed ", Toast.LENGTH_SHORT).show();
          e1.setText("");
          e2.setText("");
        }
      }
    });
  }
}
