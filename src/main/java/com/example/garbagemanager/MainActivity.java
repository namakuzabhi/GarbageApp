package com.example.garbagemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h=new Handler();

        h.postDelayed(new Runnable() {
          @Override
          public void run() {
            Intent i=new Intent(getApplicationContext(),HomePage.class);
            startActivity(i);
          }
        },3000);



    }
}
