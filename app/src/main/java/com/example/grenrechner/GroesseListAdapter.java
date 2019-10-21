package com.example.grenrechner;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class GroesseListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Groesse> groesseList= Collections.emptyList();
    private final GroesseDAO dao;

    GroesseListAdapter(GroesseDAO dao){
        this.dao = dao;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_item, parent, false);
        return new GroesseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView groesseMutter = holder.itemView.findViewById(R.id.activity_list_item_GroesseMutter);
        TextView groesseVater=holder.itemView.findViewById(R.id.activity_list_item_GroesseVater);
        TextView groesseKind=holder.itemView.findViewById(R.id.activity_list_item_GroesseKind);
        TextView geschlecht=holder.itemView.findViewById(R.id.activity_list_item_Geschlecht);
        Button loeschen=holder.itemView.findViewById(R.id.activity_list_item_ButtonLoeschen);

        groesseMutter.setText("Grösse eines Elternteils: "+groesseList.get(position).getGroesseMutter()+" cm");
        groesseVater.setText("Grösse des anderen Elternteils: "+groesseList.get(position).getGroesseVater()+" cm");
        groesseKind.setText("Grösse des ausgewachsenen Kindes: "+groesseList.get(position).getGroesseKind()+" cm");
        geschlecht.setText("Geschlecht: "+groesseList.get(position).getGeschlecht()+"");
        loeschen.setOnClickListener(view -> {
            new DeleteGroesseTask(this.dao, this).execute(groesseList.get(position));
        });
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

    static class DeleteGroesseTask extends AsyncTask<Groesse, Void, List<Groesse>>{

        private final GroesseDAO dao;
        private final GroesseListAdapter groesseListAdapter;

        DeleteGroesseTask(GroesseDAO dao, GroesseListAdapter groesseListAdapter) {
            this.dao = dao;
            this.groesseListAdapter = groesseListAdapter;
        }

        @Override
        protected List<Groesse> doInBackground(Groesse... groesses) {
            this.dao.delete(groesses[0]);
            return dao.getAll();
        }
        @Override
        protected void onPostExecute(List<Groesse> groesses){
            super.onPostExecute(groesses);
            groesseListAdapter.setGroesseList(groesses);
        }
    }
}

