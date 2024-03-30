package com.example.memo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> shoppingList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Alusta ostoslistan tietorakenne
        shoppingList = new ArrayList<>();

        // Alusta ArrayAdapter ja liitä se ListViewiin
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shoppingList);
        ListView listView = findViewById(R.id.lvShoppingList);
        listView.setAdapter(adapter);

        Button addButton = findViewById(R.id.btadd);
        Button backButton = findViewById(R.id.btShow);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddItemDialog();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Lista.class);
                intent.putStringArrayListExtra("shoppingList", shoppingList);
                startActivity(intent);
            }
        });

        // Kun käyttäjä painaa pitkään listview-kohdetta, tulee varmistuskysymys poistosta
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int listitem, long id) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Poistetaanko " + shoppingList.get(listitem) + " listalta?")
                        .setPositiveButton("Kyllä", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // Poista kohde listalta
                                shoppingList.remove(listitem);
                                // Päivitä ArrayAdapter
                                adapter.notifyDataSetChanged();
                                // Näytä Snackbar-ilmoitus onnistuneesta poistosta
                                Snackbar.make(findViewById(android.R.id.content), R.string.item_deleted, Snackbar.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Ei", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();

                return true;
            }
        });

        // Lisää mahdollinen ListViewiin liittyvä click-kuuntelija
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Tallenna valittu kohta
                showEditItemDialog(shoppingList.get(position), position);
            }
        });
    }

    private void showAddItemDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Lisää tuote");

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_item, null);
        builder.setView(dialogView);

        final EditText editTextItemName = dialogView.findViewById(R.id.editTextItemName);
        final EditText editTextItemCount = dialogView.findViewById(R.id.editTextItemCount);

        builder.setPositiveButton("Lisää", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String itemName = editTextItemName.getText().toString();
                String itemCountString = editTextItemCount.getText().toString();

                int itemCount;
                try {
                    itemCount = Integer.parseInt(itemCountString);
                } catch (NumberFormatException e) {
                    itemCount = 0;
                }

                handleItemNameAndCount(itemName, itemCount);
            }
        });

        builder.setNegativeButton("Peruuta", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Käyttäjä peruutti dialogin
            }
        });

        builder.create().show();
    }

    private void handleItemNameAndCount(String itemName, int itemCount) {
        if (itemName.length() >= 3 && itemCount > 0) {
            String newItem = itemName + " " + itemCount + "kpl";

            addToShoppingList(newItem);

            showToast(getString(R.string.item_added, newItem));
            // Päivitä ArrayAdapter
            adapter.notifyDataSetChanged();
        } else {
            // Näytä Snackbar-ilmoitus virheellisestä tuotteesta
            Snackbar.make(findViewById(android.R.id.content), R.string.invalid_item, Snackbar.LENGTH_SHORT).show();
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void addToShoppingList(String newItem) {
        shoppingList.add(newItem);
    }

    private void showEditItemDialog(String currentItem, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Muokkaa tuotetta");

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_edit, null);
        builder.setView(dialogView);

        final EditText editTextNewItem = dialogView.findViewById(R.id.editTextNewItem);
        final EditText editTextNewItemCount = dialogView.findViewById(R.id.editTextNewItemCount);

        // Aseta nykyiset arvot dialogiin
        String[] parts = currentItem.split(" ");
        editTextNewItem.setText(parts[0]);
        editTextNewItemCount.setText(parts[1].replaceAll("[^0-9]", ""));

        builder.setPositiveButton("Tallenna", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newItemName = editTextNewItem.getText().toString();
                String newItemCount = editTextNewItemCount.getText().toString();
                // Päivitä muuttunut arvo listaan
                shoppingList.set(position, newItemName + " " + newItemCount + "kpl");
                // Päivitä ArrayAdapter
                adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Peruuta", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Käyttäjä peruutti muokkauksen
            }
        });

        builder.create().show();
    }
}