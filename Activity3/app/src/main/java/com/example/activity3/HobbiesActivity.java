package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HobbiesActivity extends AppCompatActivity {
    private TextView TVHobby;
    private EditText ETHobby;
    private Button btnHobbyBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        TVHobby=findViewById(R.id.TVHobby);
        ETHobby=findViewById(R.id.ETHobby);
        btnHobbyBack=findViewById(R.id.btnHobbyBack);
        TVHobby.setText("What is your hobby?");
        ETHobby.setHint("Please, write your hobby");
        btnHobbyBack.setText("Go Back");
        btnHobbyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.putExtra("myHobby",ETHobby.getText().toString());
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
    }
}