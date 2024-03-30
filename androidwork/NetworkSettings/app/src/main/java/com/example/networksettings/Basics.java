package com.example.networksettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Basics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics);

        String[] networkTypes = {"Option 1", "Option 2", "Option 3"}; // Esimerkkinä verkkojen tyyppejä

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        Button nappi = (Button) findViewById(R.id.button2);

        // Luo ArrayAdapter ja liitä se Spinneriin
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, networkTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        nappi.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Basics.this,MainActivity.class);
                startActivity(intent);

            }


        });

    }
}
