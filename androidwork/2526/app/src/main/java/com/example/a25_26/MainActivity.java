package com.example.a25_26;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
        String[] items = new String[]{"Espoo", "Vantaa", "Kotija"};
        String[] items1 = new String[]{"Espoo", "Vantaa", "Kotija"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.planets_array, R.layout.spinner_item);
        spinner.setAdapter(adapter1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.maksutapavalikko);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.maksut, R.layout.spinner_item);
        spinner2.setAdapter(adapter2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
}