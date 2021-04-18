package com.example.activity4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private DBHelper database;
    private TextView textView;
    private Button btnHobbies,btnFriends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        database=new DBHelper(this);
        String[] data=database.loadValues("1");
        textView.setText("Hello, "+data[1]+". Your id is "+data[0]);

        btnHobbies=findViewById(R.id.btnHobbies);
        btnFriends=findViewById(R.id.btnFriends);
        btnHobbies.setText("My Hobbies");
        btnFriends.setText("My Friends");
        btnHobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, HobbiesActivity.class);
                startActivity(i);
            }
        });
        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,FriendsActivity.class);
                startActivity(i);
            }
        });

    }
}