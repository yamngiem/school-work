package com.example.teht8_10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
        import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
        import android.widget.Toast;

public class InfoActivity_1 extends AppCompatActivity {



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.advancedOptions) {
            Toast.makeText(this,"hei",Toast.LENGTH_SHORT).show();

            Switch sw = (Switch) findViewById(R.id.switchFourWheelDrive);
            RadioButton rdSation = (RadioButton) findViewById(R.id.radioButtonStation);
            RadioButton rdSedan = (RadioButton) findViewById(R.id.radioButtonSedan);
            RadioButton rdSport = (RadioButton) findViewById(R.id.radioButtonSport);

            sw.setVisibility(View.VISIBLE);
            rdSation.setVisibility(View.VISIBLE);
            rdSedan.setVisibility(View.VISIBLE);
            rdSport.setVisibility(View.VISIBLE);

            return true;
        } return super.onOptionsItemSelected(item);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1);



        CheckBox laatikko =(CheckBox) findViewById(R.id.checkBox);
        laatikko.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText ika =(EditText) findViewById(R.id.editTextAge);

            //Tarkistaa onko laatikko chekattuna vai ei

                if(laatikko.isChecked()){

                    ika.setEnabled(true);
                }
                else {
                    ika.setEnabled(false);
                }
            }
        });



        Button nappi = (Button) findViewById(R.id.buttonSave);
        nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText ika = (EditText) findViewById(R.id.editTextAge);
            //    CharSequence cr = ika.getText();

                EditText ika = (EditText) findViewById(R.id.editTextAge);
                Switch sw = (Switch) findViewById(R.id.switchFourWheelDrive);
                RadioButton rdSation = (RadioButton) findViewById(R.id.radioButtonStation);
                RadioButton rdSedan = (RadioButton) findViewById(R.id.radioButtonSedan);
                RadioButton rdSport = (RadioButton) findViewById(R.id.radioButtonSport);

                String tweetNo = ika.getText().toString();
                int result = Integer.parseInt(tweetNo);   // convert String to int

                if (result >= 1 && result <= 10){
                    // do whatever you want

                    TextView tvSummary = (TextView) findViewById(R.id.textViewSummary);
                    EditText name =(EditText) findViewById(R.id.editTextName);
                    //tvSummary.setText("Your name is:" + name);
                    CharSequence crName = name.getText();
                    CharSequence crAge = ika.getText();
                    CharSequence crSummary = "";
                    String sSummary = "";
                    CharSequence crSwitch="";
                    CharSequence crSation="";
                    CharSequence crSport="";
                    CharSequence crSedan="";

                    if(sw.isChecked()){
                        crSwitch= " Four wheel drive ";

                    }
                    if(rdSation.isChecked()){
                        crSation="Sation";

                    }
                    if(rdSedan.isChecked()){
                        crSedan=" Sedan";
                    }

                    if(rdSport.isChecked()){
                        crSport=" Sport";
                    }

                    tvSummary.setText("Your name is: "+crName+" The age of your car is: "+crAge + crSwitch + crSation +crSport +crSedan);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Too old or not old enough " , Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}



