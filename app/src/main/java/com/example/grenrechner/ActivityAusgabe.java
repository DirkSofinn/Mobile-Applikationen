package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActivityAusgabe extends AppCompatActivity {

    TextView grKind;
    TextView grMutter;
    TextView grVater;
    TextView geschlecht;
    Button weitereEingabe;
    Button listenAnsicht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(android.R.style.Theme_Material_Light_NoActionBar);
        setContentView(R.layout.activity_ausgabe);

        grKind=findViewById(R.id.AusgabeGroesseKind);
        grMutter=findViewById(R.id.AusgabeGroesseMutter);
        grVater=findViewById(R.id.AusgabeGroesseVater);
        geschlecht=findViewById(R.id.AusgabeGeschlecht);
        weitereEingabe=findViewById(R.id.ButtonZurEingabe);
        listenAnsicht=findViewById(R.id.ButtonZurListe);

        Intent intent=getIntent();

        grKind.setText(intent.getStringExtra("Groesse Kind")+" cm ");
        grMutter.setText(intent.getStringExtra("Groesse Mutter")+ " cm");
        grVater.setText(intent.getStringExtra("Groesse Vater")+" cm");
        geschlecht.setText(intent.getStringExtra("Geschlecht"));

        weitereEingabe.setOnClickListener(view -> finish());
        listenAnsicht.setOnClickListener(view -> {
            Intent intent1=new Intent(this, ActivityList.class);
            startActivity(intent1);
        });
    }
}
