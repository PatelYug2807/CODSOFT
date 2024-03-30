package com.example.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class AdapterRC extends RecyclerView.Adapter<AdapterRC.viewHolder>
{
    ArrayList<RCModel> arr;
    Context context;

    //Initializing data members by constructor

    AdapterRC(ArrayList<RCModel> arr,Context context)
    {
        this.arr=arr;
        this.context=context;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.samplerc,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
            RCModel rc=arr.get(position);
            holder.tv.setText(rc.getTaskName());
            holder.tv1.setText(rc.getPriority());
            holder.tv2.setText(rc.getTaskTime());

    }

    @Override
    public int getItemCount() {
        if (arr != null) {
            return arr.size();
        } else {
            return 0;
        }
    }

    public  class viewHolder extends RecyclerView.ViewHolder
    {

        TextView tv,tv1,tv2;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.headingTask);
            tv1=itemView.findViewById(R.id.hintTask);
            tv2=itemView.findViewById(R.id.timeToComplete);


        }
    }
}
