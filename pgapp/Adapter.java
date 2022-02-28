package com.example.pgapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    ArrayList<Model> arrayList;
    Context context;

    public Adapter(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Model model = arrayList.get(position);
        holder.name.setText(model.getName());
        holder.adress.setText(model.getAddress());
        holder.mob.setText(model.getMobile());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView name,mob,adress;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name =itemView.findViewById(R.id.name);
            adress=itemView.findViewById(R.id.adress);
            mob=itemView.findViewById(R.id.mob);
        }
    }
}
