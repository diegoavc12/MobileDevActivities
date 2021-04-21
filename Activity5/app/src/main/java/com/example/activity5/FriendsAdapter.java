package com.example.activity5;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder> {
    private ArrayList<String[]> data;
    private View.OnClickListener listener;

    public FriendsAdapter(ArrayList<String[]> data, View.OnClickListener listener){
        this.listener=listener;
        this.data=data;
    }


    @NonNull
    @Override
    public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        v.setOnClickListener(listener);
        FriendsViewHolder fvh= new FriendsViewHolder(v);
        return fvh;

    }

    @Override
    public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
        holder.textView1.setText(data.get(position)[0]);
        holder.textView2.setText(data.get(position)[1]);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class FriendsViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1,textView2;
        public FriendsViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
        }
    }
}
