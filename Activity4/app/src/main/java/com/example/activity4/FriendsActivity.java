package com.example.activity4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity {
    private EditText ETFriendName,ETFriendHobby;
    private Button btnSave,btnSearch,btnDelete;
    private DBHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        database=new DBHelper(this);
        ETFriendName=findViewById(R.id.ETFriendName);
        ETFriendHobby=findViewById(R.id.ETFriendHobby);
        btnSave=findViewById(R.id.btnSave);
        btnSearch=findViewById(R.id.btnSearch);
        btnDelete=findViewById(R.id.btnDelete);
        ETFriendName.setText("");
        ETFriendName.setHint("Write your friend's name");
        ETFriendHobby.setText("");
        ETFriendHobby.setHint("Write your friend's hobby");
        btnSave.setText("Save");
        btnSearch.setText("Search");
        btnDelete.setText("Delete");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ETFriendName.getText().toString();
                String hobby=ETFriendHobby.getText().toString();
                if(!name.isEmpty() && !hobby.isEmpty()) {
                    database.save(name, hobby);
                    Toast.makeText(FriendsActivity.this,"Friend Saved",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hobby=database.search(ETFriendName.getText().toString());
                if (hobby!=null)
                {
                    ETFriendHobby.setText(hobby);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.delete(ETFriendName.getText().toString());
                Toast.makeText(FriendsActivity.this,"Friend Deleted",Toast.LENGTH_SHORT).show();
            }
        });
    }
}