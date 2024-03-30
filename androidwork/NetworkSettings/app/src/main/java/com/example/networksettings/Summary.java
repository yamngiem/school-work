package com.example.networksettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


        TextView tv = (TextView) findViewById(R.id.tvSummary);
        Button donebutton = (Button) findViewById(R.id.btBack);

        Intent intent = getIntent();
        if (intent != null) {
            String receivedData = intent.getStringExtra("keyhedelmat");
            if (receivedData != null) {
                // Do something with the received data, e.g., display it in a TextView.
                tv.setText(receivedData);
            }
        }

        donebutton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Summary.this,MainActivity.class);
                startActivity(intent);
            }


        });

    }
}