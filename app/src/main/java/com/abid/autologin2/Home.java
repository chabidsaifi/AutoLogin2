package com.abid.autologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn1 = findViewById(R.id.button2);
        final SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Home.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Home.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}