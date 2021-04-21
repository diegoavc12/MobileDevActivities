package com.example.activity5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Handler.Callback, View.OnClickListener{
    private Button btnLoad;
    private RecyclerView recyclerView;
    private Handler handler;
    private ArrayList<String []> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        data=new ArrayList<>();
        handler=new Handler(Looper.getMainLooper(),this);
        btnLoad=findViewById(R.id.btnLoad);
        btnLoad.setText("Load");
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request request = new Request("https://raw.githubusercontent.com/diegoavc12/MobileDevActivities/main/friends.json", handler);
                request.start();
            }
        });
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        String answer=msg.obj.toString();
        try{
            JSONArray friendsData= new JSONArray(answer);
            for (int i=0; i<friendsData.length(); i++){
                JSONObject friend=friendsData.getJSONObject(i);
                String [] friendArray={friend.getString("name"),
                                       friend.getString("hobby"),
                                       friend.getString("age"),
                                       friend.getString("phone"),
                                       friend.getString("address")};
                data.add(friendArray);
            }


            FriendsAdapter adapter=new FriendsAdapter(data,this);
            LinearLayoutManager llm=new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(llm);
            recyclerView.setAdapter(adapter);



        }catch(JSONException ex){
            ex.printStackTrace();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int pos = recyclerView.getChildLayoutPosition(v);
        Intent intent= new Intent(this,FriendsDataActivity.class);
        intent.putExtra("Friend Data",data.get(pos));
        startActivity(intent);
    }
}