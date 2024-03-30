package com.example.shoppinglist2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button nappidone = (Button) findViewById(R.id.btadd);
        EditText addings =(EditText) findViewById(R.id.etAdd);
        TextView summary =(TextView) findViewById(R.id.tvSummary);

        nappidone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                showAddItemDialog();

            }


        });

    }

    private void showAddItemDialog() {
        // Luo AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lisää tuote");

        // Inflate dialog layout
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_item, null);
        builder.setView(dialogView);

        // Get references to the EditTexts in the dialog layout
        final EditText editTextItemName = dialogView.findViewById(R.id.editTextItemName);
        final EditText editTextItemCount = dialogView.findViewById(R.id.editTextItemCount);

        // Set up the buttons
        builder.setPositiveButton("Lisää", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Käsittele tuotenimi ja määrä tarpeen mukaan
                String itemName = editTextItemName.getText().toString();
                String itemCountString = editTextItemCount.getText().toString();

                int itemCount;
                try {
                    itemCount = Integer.parseInt(itemCountString);
                } catch (NumberFormatException e) {
                    itemCount = 0;
                }

                // Kutsu metodia, joka käsittelee tuotteen nimen ja määrän
                handleItemNameAndCount(itemName, itemCount);
            }
        });

        builder.setNegativeButton("Peruuta", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Käyttäjä peruutti dialogin
            }
        });

        // Näytä AlertDialog
        builder.create().show();
    }

    private void handleItemNameAndCount(String itemName, int itemCount) {
        // Tee jotain tuotteen nimen ja määrän kanssa
        // Esimerkiksi voit lisätä tuotteen listaan tai tehdä muuta liiketoimintalogiikkaa
    }
}