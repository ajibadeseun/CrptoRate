package com.treble.crptorate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String[] coinTypes = new String[]{"Select coin","Bitcoin","Ethereum"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,coinTypes);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // spinner2 store the selected item in spinner object


        // Drop down layout style - list view with radio button
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching  categoryAdapter to spinner

        spinner.setAdapter(categoryAdapter);

        Button coinBtn = (Button) findViewById(R.id.coin_btn);
        coinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spinner.getSelectedItemPosition();

                String  selected = spinner.getSelectedItem().toString();

                if(selected.equals("Select coin")){
                    Toast.makeText(MainActivity.this,"Please select a type  of coin",Toast.LENGTH_LONG).show();

                }
                else {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("coinType",selected);
                    startActivity(intent);
                }


            }
        });


    }
}
