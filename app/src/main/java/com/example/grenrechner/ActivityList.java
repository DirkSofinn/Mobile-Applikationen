package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import java.util.List;

public class ActivityList extends AppCompatActivity {

    GroesseDAO dao;
    private RecyclerView recyclerView;
    private GroesseListAdapter groesseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //recyclerView=findViewById(R.id.); fehlt id des List items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        groesseListAdapter=new GroesseListAdapter();
        recyclerView.setAdapter(groesseListAdapter);

        dao=GroesseRoomDatabase.getDatabase(this).groesseDAO();
    }
    @Override
    protected void onResume(){
        super.onResume();
        new LadeGroesseTask().execute();
    }
    class LadeGroesseTask extends AsyncTask<Void, Void, List<Groesse>> {

        @Override
        protected List<Groesse> doInBackground(Void... voids) {
            return dao.getAll();
        }
        @Override
        protected void onPostExecute(List<Groesse> groesses){
            super.onPostExecute(groesses);
            groesseListAdapter.setGroesseList(groesses);
        }
    }
}
