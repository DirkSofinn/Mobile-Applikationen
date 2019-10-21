package com.example.grenrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityHelp extends AppCompatActivity {//implements View.OnClickListener {

    Button zurueck;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

       // zurueck =findViewById(R.id.ButtonHauptseite);

     //   zurueck.setOnClickListener(cl);
    }

   // @Override
   // public void onClick(View view) {
     //   Intent intent =new Intent(this,MainActivity.class);
    //    startActivity(intent);
    //}
}
