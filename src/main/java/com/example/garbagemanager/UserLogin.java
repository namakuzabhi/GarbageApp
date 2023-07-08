package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
  EditText username, password;
  Button btnlogin,btnreg;
  DBHelper DB;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_login);

    username =  findViewById(R.id.username1);
    password =  findViewById(R.id.password1);

    btnlogin =  findViewById(R.id.btnsignin1);
    btnreg=findViewById(R.id.btnregister);


    DB = new DBHelper(this);
    btnlogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        String user = username.getText().toString();
        String pass = password.getText().toString();


        if(user.equals("")||pass.equals("")) {
          Toast.makeText(UserLogin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
          username.setError("");
          password.setError("");
        }
        else{
          Boolean checkuserpass = DB.checkusernamepassword(user, pass);
          if(checkuserpass==true){
            username.setText("");
            password.setText("");
            Toast.makeText(UserLogin.this, "Sign in Successful", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent(getApplicationContext(), UserHome.class);
            startActivity(intent);
          }else{
            Toast.makeText(UserLogin.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
          }
        }
      }
    });


    btnreg.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent i  = new Intent(UserLogin.this,UserRegister.class);
        startActivity(i);

      }
    });

  }
}
