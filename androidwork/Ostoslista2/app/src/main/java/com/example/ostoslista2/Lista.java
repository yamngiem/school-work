package com.example.ostoslista2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Button takaisinButton = findViewById(R.id.btTakaisin);
        Intent intent = getIntent();

        ArrayList<String> shoppingList = intent.getStringArrayListExtra("shoppingList");

        // Näytä tiedot ListViewissä tai muulla tavalla
        ListView listView = findViewById(R.id.lvShoppingList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingList);
        listView.setAdapter(adapter);

        takaisinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lista.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}