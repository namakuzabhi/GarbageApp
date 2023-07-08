package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DriverLogin extends AppCompatActivity {
  EditText username, password;
  Button btnlogin;
  DBHelper DB;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_driver_login);

    username =  findViewById(R.id.username1);
    password =  findViewById(R.id.password1);

    btnlogin =  findViewById(R.id.login);


    DB = new DBHelper(this);
    btnlogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if(user.equals("")||pass.equals("")) {
          username.setError("Empty");
          password.setError("Empty");
          Toast.makeText(DriverLogin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }

        else {
          Boolean checkuserpass = DB.checkDriver(user,pass);
          if(checkuserpass==true){
            username.setText("");
            password.setText("");
            Toast.makeText(DriverLogin.this, "Sign in Successful", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent(getApplicationContext(), GPS.class);
            startActivity(intent);
          }else{
            Toast.makeText(DriverLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
          }
        }
      }
    });

  }
}
