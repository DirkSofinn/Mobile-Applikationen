package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityAusgabe extends AppCompatActivity {

    TextView grKind;
    TextView grMutter;
    TextView grVater;
    TextView geschlecht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausgabe);

        grKind=findViewById(R.id.AusgabeGroesseKind);
        grMutter=findViewById(R.id.AusgabeGroesseMutter);
        grVater=findViewById(R.id.AusgabeGroesseVater);
        geschlecht=findViewById(R.id.AusgabeGeschlecht);

        Intent intent=getIntent();

        grKind.setText(intent.getStringExtra("Groesse Kind"));
        grMutter.setText(intent.getStringExtra("Groesse Mutter"));
        grVater.setText(intent.getStringExtra("Groesse Vater"));
        geschlecht.setText(intent.getStringExtra("Geschlecht"));
    }
}
