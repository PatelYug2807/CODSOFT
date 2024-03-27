package com.example.dailyquotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class AdapterRc extends RecyclerView.Adapter<AdapterRc.viewHolder>
        {
            ArrayList<RCModel> arr;
            Context c;

            public AdapterRc(ArrayList<RCModel> arr, Context c) {
                this.arr = arr;
                this.c = c;
            }
            @NonNull
            @Override
            public AdapterRc.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view= LayoutInflater.from(c).inflate(R.layout.samplerc,parent,false);
                return new viewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull AdapterRc.viewHolder holder, int position)
            {
                RCModel rc=arr.get(position);
                holder.iv.setImageResource(rc.getImg());
                holder.tv.setText(rc.getName());
                holder.iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                       switch (rc.getName())
//                       {
//                           case "IronMan":
//                           {
                        Intent i = new Intent(c, Demo.class);
                        i.putExtra("name", rc.getName());
                        i.putExtra("pic", rc.getImg());
                        i.putExtra("quote", rc.getQuote());
                        c.startActivity(i);
//                               break;
//
//                           }
//                           case "Captian America":
//                           {
//                               Intent i=new Intent(c, Demo.class);
//                               i.putExtra("name",rc.getName());
//                               i.putExtra("pic",rc.getImg());
//                               i.putExtra("quote",rc.getQuote());
//                               c.startActivity(i);
//                               break;
//                           }
//                           case "Hulk":
//                           {
//                               Intent i=new Intent(c, Demo.class);
//                               i.putExtra("name",rc.getName());
//                               i.putExtra("pic",rc.getImg());
//                               i.putExtra("quote",rc.getQuote());
//                               c.startActivity(i);
//                               break;
//                           }
//                           case "Namor":
//                           {
//                               Intent i=new Intent(c, Demo.class);
//                               i.putExtra("name",rc.getName());
//                               i.putExtra("pic",rc.getImg());
//                               i.putExtra("quote",rc.getQuote());
//                               c.startActivity(i);
//                               break;
//                           }
//                           case "SpiderMan":
//                           {
//                               Intent i=new Intent(c, Demo.class);
//                               i.putExtra("name",rc.getName());
//                               i.putExtra("pic",rc.getImg());
//                               i.putExtra("quote",rc.getQuote());
//                               c.startActivity(i);
//                               break;
//                           }
//                           default:
//                               break;
//
//
//                       }
//
//                    }
                    }
                });

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
                ImageView iv;
                TextView tv;
                public viewHolder(@NonNull View itemView) {
                    super(itemView);
                    iv=itemView.findViewById(R.id.sampleImg);
                    tv=itemView.findViewById(R.id.sampleTxt);

                }
            }
        }
