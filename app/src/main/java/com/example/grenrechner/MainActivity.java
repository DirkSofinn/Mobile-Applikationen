package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView titel;
    TextView beschreibung;
    Button berechnen;
    Button hilfe;
    EditText groesseMutter;
    EditText groesseVater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titel=findViewById(R.id.Titel);
        beschreibung=findViewById(R.id.Beschreibung);
        groesseMutter=findViewById(R.id.groesseMutter);
        groesseVater=findViewById(R.id.groesseVater);
        berechnen=findViewById(R.id.ButtonBerechnen);
        hilfe=findViewById(R.id.ButtonHilfe);
    }
}
