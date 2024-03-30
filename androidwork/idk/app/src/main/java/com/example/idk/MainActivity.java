package com.example.idk;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Määrittele TextView luokan tasolla
    private TextView rt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.button3);

        // Alusta rt tässä
        rt = findViewById(R.id.textView2);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomResult();
            }
        });
    }

    private void displayRandomResult() {
        Random random = new Random();
        boolean isYes = random.nextBoolean();

        String result = isYes ? "Yes!" : "No!";
        rt.setText(result);
    }
}
