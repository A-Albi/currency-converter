package com.example.albi.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, Double> CurrencyDouble = new HashMap<String, Double>();
    HashMap<String, String> CurrencySymbol = new HashMap<String, String>();
    String[] Currencies = {"EURO", "YEN", "YUAN", "RUBLE"};
    int Counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText editText1 = findViewById(R.id.textView);
        CurrencyDouble.put("EURO", 0.85);
        CurrencyDouble.put("YEN", 110.77);
        CurrencyDouble.put("YUAN", 6.37);
        CurrencyDouble.put("RUBLE", 62.16);
        CurrencySymbol.put("EURO", "€");
        CurrencySymbol.put("YEN", "¥");
        CurrencySymbol.put("YUAN", "Y");
        CurrencySymbol.put("RUBLE", "R");
    }

    public void onClick1 (View view1) {
        Counter = Counter == 3 ? 0 : Counter + 1;
        EditText editText1 = findViewById(R.id.editText);
        Button button1 = findViewById(R.id.buttonA);
        TextView editText2 = findViewById(R.id.textView);
        TextView editText3 = findViewById(R.id.textView2);
        String editText1_text = editText1.getText().toString();
        String currency = Currencies[Counter];
        editText2.setText((!editText1_text.equals("") && isNumeric(editText1_text)) ? " " + String.format("%.2f", Double.parseDouble(editText1_text) * CurrencyDouble.get(currency)) : " Awaiting Input...");
        button1.setText(("Convert To: " + currency));
        editText3.setText(CurrencySymbol.get(currency));
    }

    public void onClick2(View view2) {
        EditText editText1 = findViewById(R.id.editText);
        editText1.setText("");
        String editText1_text = editText1.getText().toString();
        TextView editText2 = findViewById(R.id.textView);
        String currency = Currencies[Counter];
        editText2.setText((!editText1_text.equals("") && isNumeric(editText1_text)) ? " " + String.format("%2f", Double.parseDouble(editText1_text) * CurrencyDouble.get(currency)) : " Awaiting Input...");
    }

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
