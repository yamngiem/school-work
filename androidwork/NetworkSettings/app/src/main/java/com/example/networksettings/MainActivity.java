package com.example.networksettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ListView mainListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView listView = findViewById(R.id.listview); // Käytä oikeaa ID:tä
        String[] mainOptions = {"Basics", "Encryption", "Summary"};
       // CustomAdapter adapter = new CustomAdapter(this, mainOptions);
       // listView.setAdapter(adapter);
        CustomAdapter adapter = new CustomAdapter(this, mainOptions);
        listView.setAdapter(adapter);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainOptions); // Käytä oikeaa layout-resurssia
        listView.setAdapter(arrayAdapter);
        listView.setBackgroundColor(Color.BLUE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // i kertoo, mikä kohde painettiin
                String selectedItem = mainOptions[i]; // Hae valittu vaihtoehto

                if (selectedItem.equals("Basics")) {
                    // Käsittely perustuen valittuun kohteeseen (Basics)
                    Intent intent = new Intent(MainActivity.this, Basics.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Encryption")) {
                    // Käsittely perustuen valittuun kohteeseen (Encryption)
                    Intent intent = new Intent(MainActivity.this, EncryptionActivity.class);
                    startActivity(intent);
                } else if (selectedItem.equals("Summary")) {
                    // Käsittely perustuen valittuun kohteeseen (Summary)
                    Intent intent = getIntent();
                    if (intent != null) {
                        String receivedData = intent.getStringExtra("key");
                        if (receivedData != null) {
                            // Do something with the received data, e.g., display it in a TextView.
                            String lahetettavahedelmat= String.join("\n", receivedData);
                            Intent intenthedelmat = new Intent(MainActivity.this,Summary.class);
                            intenthedelmat.putExtra("key", lahetettavahedelmat);
                            startActivity(intenthedelmat);
                        }
                    }

                  //  Intent intent = new Intent(MainActivity.this, Summary.class);
                //    startActivity(intent);


                }
            }









        });

    }
    public class CustomAdapter extends ArrayAdapter<String> {
        public CustomAdapter(Context context, String[] items) {
            super(context, R.layout.custom_list_item, items);
        }
    }


}
