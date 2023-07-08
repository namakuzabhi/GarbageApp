package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class UserRegister extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup, signin;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);

        signup = findViewById(R.id.btnsignup);
        signin = findViewById(R.id.btnsignin);




        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

               // String u="[a-zA-Z]+['-][a-zA-Z]*" ;
                String u="^[a-zA-Z]*$";

                String p="^" +"(?=.*[0-9])" +"(?=.*[a-z])" +"(?=.*[A-Z])" +"(?=.*[@#$%^&+=])"+ ".{6,}" + "$";

                if (user.equals("") || pass.equals("") || repass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                    username.setError("Please enter username");
                    password.setError("Please enter password");
                    repassword.setError("Please enter Re-password");
                }
                else  if(username.length()<2)
                {
                    username.requestFocus();
                    username.setError("Name is to small");
                }
                else if(username.length()>15)
                {
                    username.requestFocus();
                    username.setError("Name is to large");
                }
                else if(!user.matches(u))
                {
                    username.requestFocus();
                    username.setError("Enter only alpha numeric characters");
                }
                else if(!pass.matches(p))
                {
                    password.requestFocus();
                    password.setError("Password contain 6 characters!.. 1 Digit / 1 Lower Case / 1 Upper Case /1 Special Character");
                }
                else
                {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                                username.setText("");
                                password.setText("");
                                repassword.setText("");
                                Intent intent = new Intent(getApplicationContext(), UserLogin.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                                username.setText("");
                                password.setText("");
                                repassword.setText("");
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Username already exists! please sign in", Toast.LENGTH_SHORT).show();
                            username.setText("");
                            password.setText("");
                            repassword.setText("");
                        }
                    } else {
                        repassword.requestFocus();
                        repassword.setError("Password not Matching!");
                    }
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserLogin.class);
                startActivity(intent);
            }
        });
    }

    public void ShowHidePass(View view){


    }
}
