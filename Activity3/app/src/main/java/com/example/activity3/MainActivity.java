package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText ETName;
    private Button button;
    private static final int EXAMPLE_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ETName=findViewById(R.id.ETName);
        ETName.setHint("Please, write your name");
        button=findViewById(R.id.button);
        button.setText("SEND");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("myName",ETName.getText().toString());
                startActivityForResult(i,EXAMPLE_CODE);
            }
        });
    }
}