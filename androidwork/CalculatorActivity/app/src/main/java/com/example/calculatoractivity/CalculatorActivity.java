package com.example.calculatoractivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDivision,
            buttonMul, button10, buttonC, buttonEqual;
    EditText crunchifyEditText;
    float mValueOne, mValueTwo;
    float eaquals;
    boolean crunchifyAddition, mSubtract, crunchifyMultiplication, crunchifyDivision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = findViewById(R.id.nolla);
        button1 = findViewById(R.id.yks);
        button2 = findViewById(R.id.kaks);
        button3 = findViewById(R.id.kolme);
        button4 = findViewById(R.id.nelia);
        button5 = findViewById(R.id.viis);
        button6 = findViewById(R.id.kuus);
        button7 = findViewById(R.id.seiska);
        button8 = findViewById(R.id.kasi);
        button9 = findViewById(R.id.ysi);
        button10 = findViewById(R.id.dot);
        buttonAdd = findViewById(R.id.buttonAddition);
        buttonSub = findViewById(R.id.buttonSubtraction);
        buttonMul = findViewById(R.id.buttonMultiplication);
        buttonDivision = findViewById(R.id.buttonDivision);
        buttonC = findViewById(R.id.buttonClear);
        buttonEqual = findViewById(R.id.buttonEquals);
        crunchifyEditText = findViewById(R.id.textDisplay);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + "0");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText.getText() != null && !crunchifyEditText.getText().toString().isEmpty()) {
                    mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
                    crunchifyAddition = true;
                    crunchifyEditText.setText(null);
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText.getText() != null && !crunchifyEditText.getText().toString().isEmpty()) {
                    mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
                    mSubtract = true;
                    crunchifyEditText.setText(null);
                }
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText.getText() != null && !crunchifyEditText.getText().toString().isEmpty()) {
                    mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
                    crunchifyMultiplication = true;
                    crunchifyEditText.setText(null);
                }
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText.getText() != null && !crunchifyEditText.getText().toString().isEmpty()) {
                    mValueOne = Float.parseFloat(crunchifyEditText.getText() + "");
                    crunchifyDivision = true;
                    crunchifyEditText.setText(null);
                }
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (crunchifyEditText.getText() != null && !crunchifyEditText.getText().toString().isEmpty()) {
                    mValueTwo = Float.parseFloat(crunchifyEditText.getText() + "");
                    if (crunchifyAddition) {
                        eaquals = mValueOne + mValueTwo;
                        crunchifyEditText.setText(mValueOne +" + "+mValueTwo+"="+"\n"+ eaquals+ "");
                        crunchifyAddition = false;
                    }
                    if (mSubtract) {
                        eaquals = mValueOne - mValueTwo;
                        crunchifyEditText.setText(mValueOne +" - "+mValueTwo+"="+"\n"+ eaquals+ "");
                        mSubtract = false;
                    }
                    if (crunchifyMultiplication) {
                        eaquals = mValueOne * mValueTwo;
                        crunchifyEditText.setText(mValueOne +" *"+mValueTwo+"="+"\n"+ eaquals+ "");
                        crunchifyMultiplication = false;
                    }
                    if (crunchifyDivision) {
                        if (mValueTwo != 0) {
                            eaquals = mValueOne / mValueTwo;
                            crunchifyEditText.setText(mValueOne +" / "+mValueTwo+"="+"\n"+eaquals+ "");
                        } else {
                            crunchifyEditText.setText("Error");
                        }
                        crunchifyDivision = false;
                    }
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText("");
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crunchifyEditText.setText(crunchifyEditText.getText() + ".");
            }
        });
    }
}
