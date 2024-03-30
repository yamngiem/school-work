package com.example.networksettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EncryptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

        ListView listView = findViewById(R.id.encryptionListView); // Käytä oikeaa ID:tä
        Button donebutton = findViewById(R.id.doneButton);
        Button buttonBack = findViewById(R.id.buttonBack);
        List<String> selectedItems = new ArrayList<>(); // Luo lista valituille kohdeille

        String[] mainOptions = {"Omena", "Päärynä", "Appelsiini", "Ananas"};
        // Aseta monivalintatila CHOICE_MODE_MULTIPLE
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mainOptions);
        // Käytä oikeaa layout-resurssia
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, items);
        //listView.setAdapter(adapter);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // position kertoo, mikä kohde painettiin
                String selectedItem = mainOptions[position]; // Hae valittu vaihtoehto



                SparseBooleanArray checkedPositions = listView.getCheckedItemPositions();
                for (int i = 0; i < checkedPositions.size(); i++) {
                    int key = checkedPositions.keyAt(i);
                    boolean value = checkedPositions.get(key);

                    if (value) {
                        // Valittu kohde
                        selectedItem = mainOptions[key]; // Käytä samaa muuttujaa
                        selectedItems.add(selectedItem); // Lisää valittu kohde listaan
                    }
                }

                // Käsittele valitut kohteet tässä, esimerkiksi tallenna ne tai tee jotain muuta niiden kanssa
                for (String item : selectedItems) {
                    Log.d("Selected Item", item);
                }
            }


        });
        donebutton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {


                String lahetettava= String.join("\n", selectedItems);
                Intent intent = new Intent(EncryptionActivity.this,MainActivity.class);
                intent.putExtra("key", lahetettava);
                startActivity(intent);





            }


        });
        buttonBack.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Intent intentback = new Intent(EncryptionActivity.this,MainActivity.class);
              startActivity(intentback);

            }


        });

    }
}