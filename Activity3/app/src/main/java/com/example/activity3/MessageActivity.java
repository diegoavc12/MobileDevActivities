package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {
    private EditText ETMessage;
    private Button btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ETMessage=findViewById(R.id.ETMessage);
        btnSend=findViewById(R.id.btnSend);
        ETMessage.setHint("Please, write your message");
        btnSend.setText("Send");
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MessageActivity.this,"Message sent",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}