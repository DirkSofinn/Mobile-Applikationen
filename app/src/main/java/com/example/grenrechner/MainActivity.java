package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView titel;
    TextView beschreibung;
    RadioButton geschlechtM;
    RadioButton geschlechtW;
    RadioButton geschlechtD;
    Button berechnen;
    Button hilfe;
    EditText groesseMutter;
    EditText groesseVater;
    int groesseKind =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titel=findViewById(R.id.Titel);
        beschreibung=findViewById(R.id.Beschreibung);
        geschlechtM=findViewById(R.id.ButtonMännlich);
        geschlechtW=findViewById(R.id.ButtonWeiblich);
        geschlechtD=findViewById(R.id.ButtonDivers);
        groesseMutter=findViewById(R.id.groesseMutter);
        groesseVater=findViewById(R.id.groesseVater);
        berechnen=findViewById(R.id.ButtonBerechnen);
        hilfe=findViewById(R.id.ButtonHilfe);

        berechnen.setOnClickListener(view-> {
            berechnungGroesse();
            Intent intent=new Intent(this, ActivityAusgabe.class);
            startActivity(intent);}); //Noch in Datenbank speichern hinzufügen

        hilfe.setOnClickListener(view -> {
            Intent intent=new Intent(this, ActivityHelp.class);
            startActivity(intent);});
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
