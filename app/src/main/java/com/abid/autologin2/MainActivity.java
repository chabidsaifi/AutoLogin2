package com.abid.autologin2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.edittext1);
        e2 = findViewById(R.id.Edittext2);
        btn = findViewById(R.id.button);
        final SharedPreferences pref = getSharedPreferences("Data", Context.MODE_PRIVATE);

        final String type = pref.getString("Email","");
        if (type.isEmpty()){
            Toast.makeText(MainActivity.this, "Please Login ", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(MainActivity.this,Home.class);
            startActivity(i);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = pref.edit();

                editor.putString("Email",e1.getText().toString());

                editor.putString("Password",e2.getText().toString());

                editor.commit();

                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,Home.class);
                startActivity(i);
            }
        });
    }
}