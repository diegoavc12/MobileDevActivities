package com.example.activity4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HobbiesActivity extends AppCompatActivity {
    private TextView TVHobby;
    private EditText ETHobby;
    private Button btnUpdateHobby;
    private DBHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        TVHobby=findViewById(R.id.TVHobby);
        database=new DBHelper(this);
        String hobby=database.getFieldHobby("1");
        if(hobby==null){
            TVHobby.setText("");
        }else{
            TVHobby.setText("Your hobby is "+hobby);
        }
        ETHobby=findViewById(R.id.ETHobby);
        ETHobby.setText("");
        ETHobby.setHint("Update your hobby");
        btnUpdateHobby=findViewById(R.id.btnUpdateHobby);
        btnUpdateHobby.setText("Update");
        btnUpdateHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newHobby=ETHobby.getText().toString();
                database.updateHobby("1",newHobby);
                Toast.makeText(HobbiesActivity.this,"Hobby Updated",Toast.LENGTH_SHORT).show();
                TVHobby.setText("Your hobby is "+newHobby);
            }
        });

    }
}