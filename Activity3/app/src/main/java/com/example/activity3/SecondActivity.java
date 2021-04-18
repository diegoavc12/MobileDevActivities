package com.example.activity3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textView, textView2;
    private Button btnHobbies, btnFriends, btnMessage;
    private static final int EXAMPLE_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.textView);
        Intent intent =getIntent();
        textView.setText("Hi, "+intent.getStringExtra("myName"));
        textView2=findViewById(R.id.textView2);
        btnHobbies=findViewById(R.id.btnHobbies);
        btnFriends=findViewById(R.id.btnFriends);
        btnMessage=findViewById(R.id.btnMessage);
        btnHobbies.setText("My Hobbies");
        btnFriends.setText("My Friends");
        btnMessage.setText("Leave a Message");
        btnHobbies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SecondActivity.this, HobbiesActivity.class);
                startActivityForResult(i,EXAMPLE_CODE);
            }
        });
        btnFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SecondActivity.this, FriendsActivity.class);
                startActivity(i);
            }
        });
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(SecondActivity.this, MessageActivity.class);
                startActivity(i);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==EXAMPLE_CODE && resultCode== Activity.RESULT_OK){
            textView2.setText("My hobby is "+data.getStringExtra("myHobby"));
        }
    }
}