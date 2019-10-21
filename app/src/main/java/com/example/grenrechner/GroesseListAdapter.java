package com.example.grenrechner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class GroesseListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Groesse> groesseList= Collections.emptyList();

    GroesseListAdapter(){}

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item, parent, false);
        return new GroesseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // muss später erfolgen hier werden die einzelnen Attribute den List Items zugewiesen
        TextView groesseMutter=holder.itemView.findViewById(R.id.activity_list_item_GroesseMutter);
        TextView groesseVater=holder.itemView.findViewById(R.id.activity_list_item_GroesseVater);
        TextView groesseKind=holder.itemView.findViewById(R.id.activity_list_item_GroesseKind);
        TextView geschlecht=holder.itemView.findViewById(R.id.activity_list_item_Geschlecht);
    }

    @Override
    public int getItemCount() {
        return groesseList.size();
    }
    public void setGroesseList(List<Groesse> groesses){
        this.groesseList=groesses;
        notifyDataSetChanged();
    }

    class GroesseViewHolder extends RecyclerView.ViewHolder{
        public GroesseViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }
}

