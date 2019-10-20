package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity{

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
            Intent intent=new Intent(this, ActivityAusgabe.class);
            intent.putExtra("Groesse Mutter",groesseMutter.getText().toString());
            intent.putExtra("Groesse Vater",groesseVater.getText().toString());
            intent.putExtra("Groesse Kind", groesseKind);
            if(geschlechtM.isChecked())
                intent.putExtra("Geschlecht","Männlich");
            if(geschlechtW.isChecked())
                intent.putExtra("Geschlecht","Weiblich");
            if (geschlechtD.isChecked())
                intent.putExtra("Geschlecht","Divers");
            startActivity(intent);}); //Noch in Datenbank speichern hinzufügen

        hilfe.setOnClickListener(view -> {
            Intent intent=new Intent(this, ActivityHelp.class);
            startActivity(intent);});

        liste.setOnClickListener(view -> {
            Intent intent1=new Intent(this, ActivityList.class);
            startActivity(intent1);
        });
    }

    public void berechnungGroesse(){
        if (geschlechtM.isChecked())
            groesseKind =  (Integer.parseInt(groesseMutter.getText().toString()) +
                    Integer.parseInt(groesseVater.getText().toString())+13)/2;
        if (geschlechtW.isChecked())
            groesseKind =  (Integer.parseInt(groesseMutter.getText().toString()) +
                    Integer.parseInt(groesseVater.getText().toString())-13)/2;
        if (geschlechtD.isChecked())
            groesseKind =  (Integer.parseInt(groesseMutter.getText().toString()) +
                    Integer.parseInt(groesseVater.getText().toString()))/2;
    }

}
