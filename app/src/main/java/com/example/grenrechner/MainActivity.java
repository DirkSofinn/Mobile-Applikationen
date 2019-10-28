package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.grenrechner.GroesseRoomDatabase.*;

public class MainActivity extends AppCompatActivity{

    GroesseDAO dao;
    RadioButton geschlechtM;
    RadioButton geschlechtW;
    RadioButton geschlechtD;
    Button berechnen;
    Button hilfe;
    Button liste;
    EditText groesseMutter;
    EditText groesseVater;
    int groesseKind =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao= getDatabase(this).groesseDAO();

        geschlechtM=findViewById(R.id.ButtonMännlich);
        geschlechtW=findViewById(R.id.ButtonWeiblich);
        geschlechtD=findViewById(R.id.ButtonDivers);
        groesseMutter=findViewById(R.id.groesseMutter);
        groesseVater=findViewById(R.id.groesseVater);
        berechnen=findViewById(R.id.ButtonBerechnen);
        hilfe=findViewById(R.id.ButtonHilfe);
        liste=findViewById(R.id.ButtonMainListe);

        berechnen.setOnClickListener(view-> {
            berechnungGroesse();
            saveGroesseOnClick();});


        hilfe.setOnClickListener(view -> {
            Intent intent=new Intent(this, ActivityHelp.class);
            startActivity(intent);});

        liste.setOnClickListener(view -> {
            Intent intent1=new Intent(this, ActivityList.class);
            startActivity(intent1);
        });
    }

    public void berechnungGroesse(){
        if(!groesseMutter.getText().toString().isEmpty() && !groesseVater.getText().toString().isEmpty()) {
            if (geschlechtM.isChecked()) {
                groesseKind = (Integer.parseInt(groesseMutter.getText().toString()) +
                        Integer.parseInt(groesseVater.getText().toString()) + 13) / 2;
                Intent intent=new Intent(this, ActivityAusgabe.class);
                intent.putExtra("Groesse Mutter",groesseMutter.getText().toString());
                intent.putExtra("Groesse Vater",groesseVater.getText().toString());
                intent.putExtra("Groesse Kind", groesseKind+"");
                intent.putExtra("Geschlecht","Männlich");
                startActivity(intent);
            }
            if (geschlechtW.isChecked()) {
                groesseKind = (Integer.parseInt(groesseMutter.getText().toString()) +
                        Integer.parseInt(groesseVater.getText().toString()) - 13) / 2;
                Intent intent=new Intent(this, ActivityAusgabe.class);
                intent.putExtra("Groesse Mutter",groesseMutter.getText().toString());
                intent.putExtra("Groesse Vater",groesseVater.getText().toString());
                intent.putExtra("Groesse Kind", groesseKind+"");
                intent.putExtra("Geschlecht","Weiblich");
                startActivity(intent);
            }
            if (geschlechtD.isChecked()) {
                groesseKind = (Integer.parseInt(groesseMutter.getText().toString()) +
                        Integer.parseInt(groesseVater.getText().toString())) / 2;
                Intent intent=new Intent(this, ActivityAusgabe.class);
                intent.putExtra("Groesse Mutter",groesseMutter.getText().toString());
                intent.putExtra("Groesse Vater",groesseVater.getText().toString());
                intent.putExtra("Groesse Kind", groesseKind+"");
                intent.putExtra("Geschlecht","Divers");
                startActivity(intent);
            }
            Toast.makeText(this,"Bitte ein Gescchlecht auswählen",Toast.LENGTH_LONG).show();

        }
    }

    class SpeichernTask extends AsyncTask<Groesse, Void, Void>{

        @Override
        protected Void doInBackground(Groesse... groesses) {
            dao.insert(groesses[0]);
            return null;
        }
        @Override
        protected void onPostExecute (Void avoid){
            super.onPostExecute(avoid);
        }
    }

    private void saveGroesseOnClick(){
        if(!groesseMutter.getText().toString().isEmpty() && !groesseVater.getText().toString().isEmpty()
        && groesseKind>0){
            if(geschlechtW.isChecked())
            new SpeichernTask().execute(new Groesse(Integer.parseInt(groesseMutter.getText().toString()),
                    Integer.parseInt(groesseVater.getText().toString()), groesseKind,'W'));
            if(geschlechtM.isChecked())
                new SpeichernTask().execute(new Groesse(Integer.parseInt(groesseMutter.getText().toString()),
                        Integer.parseInt(groesseVater.getText().toString()), groesseKind,'M'));
            if(geschlechtD.isChecked())
                new SpeichernTask().execute(new Groesse(Integer.parseInt(groesseMutter.getText().toString()),
                        Integer.parseInt(groesseVater.getText().toString()), groesseKind,'D'));
        }
    }

}
