package com.example.activity5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FriendsDataActivity extends AppCompatActivity {

    private TextView TVName,TVHobby,TVAge,TVPhone,TVAddress;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_data);
        TVName=findViewById(R.id.TVName);
        TVHobby=findViewById(R.id.TVHobby);
        TVAge=findViewById(R.id.TVAge);
        TVPhone=findViewById(R.id.TVPhone);
        TVAddress=findViewById(R.id.TVAddress);
        button=findViewById(R.id.button);

        button.setText("Go Back");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent= getIntent();
        String[] friendData= intent.getStringArrayExtra("Friend Data");

        TVName.setText("Name: "+friendData[0]);
        TVHobby.setText("Hobby: "+friendData[1]);
        TVAge.setText("Age: "+friendData[2]);
        TVPhone.setText("Phone: "+friendData[3]);
        TVAddress.setText("Address: "+friendData[4]);
    }
}