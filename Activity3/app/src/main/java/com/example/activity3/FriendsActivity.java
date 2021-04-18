package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FriendsActivity extends AppCompatActivity {
    private Button btnFriendsBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        btnFriendsBack=findViewById(R.id.btnFriendsBack);
        btnFriendsBack.setText("Go Back");
        btnFriendsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                finish();
            }
        });
    }
}