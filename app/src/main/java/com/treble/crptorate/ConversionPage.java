package com.treble.crptorate;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConversionPage extends AppCompatActivity {


    private String convRate;
    private double output;
    private int input;
    private TextInputEditText inputTxt;
    private double rate;
    private ImageView img;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_page);

        Bundle i = getIntent().getExtras();
        convRate = i.getString("convRate");
        final   int pos = i.getInt("pos");
        final   String currencyPos = i.getString("currencyPos");
        final   String selectedCoin = i.getString("selectedCoin");

        final List<Integer> symbols = new ArrayList<>();
        symbols.add(R.mipmap.us_dollars);
        symbols.add(R.mipmap.euro_symbol);
        symbols.add(R.mipmap.naira_sym);
        symbols.add(R.mipmap.pounds_symbol);
        symbols.add(R.mipmap.dirham_symbol);
        symbols.add(R.mipmap.saudi_riyal);
        symbols.add(R.mipmap.japan_yen);
        symbols.add(R.mipmap.india_rupee);
        symbols.add(R.mipmap.pounds_symbol);
        symbols.add(R.mipmap.japan_yen);
        symbols.add(R.mipmap.brazil_real);
        symbols.add(R.mipmap.australian_dollars);
        symbols.add(R.mipmap.canada_dollar);
        symbols.add(R.mipmap.swiss_francs);
        symbols.add(R.mipmap.denmark_krone);
        symbols.add(R.mipmap.denmark_krone);
        symbols.add(R.mipmap.kenyan_shillings);
        symbols.add(R.mipmap.qatar_riyal);
        symbols.add(R.mipmap.singapore_dollar);
        symbols.add(R.mipmap.south_rand);



        if(selectedCoin.equals("Bitcoin")){

            final String[] coinType = {"Select currency",selectedCoin,currencyPos};


            ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(ConversionPage.this,
                    android.R.layout.simple_spinner_item,coinType);

            final Spinner spinner = (Spinner) findViewById(R.id.spinner);
            // spinner2 store the selected item in spinner object


            // Drop down layout style - list view with radio button
            categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // attaching  categoryAdapter to spinner

            spinner.setAdapter(categoryAdapter);


//            if(select.equals(selectedCoin)){
            final String[] coinTypeTwo ={"Select coin",selectedCoin,currencyPos};
            ArrayAdapter<String> categoryAdapterTwo = new ArrayAdapter<String>(ConversionPage.this,
                    android.R.layout.simple_spinner_item,coinTypeTwo);

            final Spinner spinnerTwo = (Spinner) findViewById(R.id.spinner2);
            // spinner2 store the selected item in spinner object


            // Drop down layout style - list view with radio button
            categoryAdapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // attaching  categoryAdapter to spinner

            spinnerTwo.setAdapter(categoryAdapter);








            Button calBtn = findViewById(R.id.calculate);
            calBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inputTxt = findViewById(R.id.input_unit);

                    final   String selectOne = spinnerTwo.getSelectedItem().toString();
                    final  String select = spinner.getSelectedItem().toString();
                    if(inputTxt.length() == 0 || select.equals("Select currency") || selectOne.equals("Select currency") ){
                        Toast.makeText(ConversionPage.this, "Please fill up the missing field(s)",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if(selectOne.equals(select)){
                        Toast.makeText(ConversionPage.this,"Please select different currencies above",Toast.LENGTH_LONG).show();
                        return;
                    }

                    String in = inputTxt.getText().toString();
                    float input = Float.parseFloat(in);
                    float rate = Float.parseFloat(convRate);

                    final TextView out = findViewById(R.id.output_txt);



                    if(select.equals(selectedCoin) && selectOne.equals(currencyPos) && inputTxt.length()>0){

                        float  output =  input * rate;
                        if(select.equals(selectedCoin) && selectOne.equals(currencyPos)){
                            img = findViewById(R.id.img);
                            img.setImageResource(symbols.get(pos));
                        }
//                       else if(select.equals(currencyPos) && selectOne.equals(selectedCoin)){
//                           img =  findViewById(R.id.img);
//                           img.setImageResource(R.mipmap.bitcoin_sym);
//                       }

                        out.setText(getFormattedConv(output));

                    }
                    else if(select.equals(currencyPos) && selectOne.equals(selectedCoin) && inputTxt.length()>0){

                        float output =  input / rate;

                        if(select.equals(currencyPos) && selectOne.equals(selectedCoin)){
                            img = findViewById(R.id.img);
                            img.setImageResource(R.mipmap.bitcoin_sym);
                        }
                        out.setText(getFormattedConv(output));
                    }

                    inputTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            out.setText("");
                            img = findViewById(R.id.img);
                            img.setImageResource(0);
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });




                }
            });





        }

        else if(selectedCoin.equals("Ethereum")){

            final String[] coinType = {"Select currency",selectedCoin,currencyPos};


            ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(ConversionPage.this,
                    android.R.layout.simple_spinner_item,coinType);

            final Spinner spinner = (Spinner) findViewById(R.id.spinner);
            // spinner2 store the selected item in spinner object


            // Drop down layout style - list view with radio button
            categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // attaching  categoryAdapter to spinner

            spinner.setAdapter(categoryAdapter);

//            String selectTwo = spinner.getSelectedItem().toString();


            final String[] coinTypeTwo ={"Select coin",selectedCoin,currencyPos};
            ArrayAdapter<String> categoryAdapterTwo = new ArrayAdapter<String>(ConversionPage.this,
                    android.R.layout.simple_spinner_item,coinTypeTwo);

            final Spinner spinnerTwo = (Spinner) findViewById(R.id.spinner2);
            // spinner2 store the selected item in spinner object


            // Drop down layout style - list view with radio button
            categoryAdapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // attaching  categoryAdapter to spinner

            spinnerTwo.setAdapter(categoryAdapter);

//            String selectThree = spinnerTwo.getSelectedItem().toString();




            Button calBtn = findViewById(R.id.calculate);
            calBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inputTxt = findViewById(R.id.input_unit);

                    final   String selectThree = spinnerTwo.getSelectedItem().toString();
                    final  String selectTwo = spinner.getSelectedItem().toString();
                    if(inputTxt.length() == 0 || selectTwo.equals("Select currency") || selectThree.equals("Select currency") ){
                        Toast.makeText(ConversionPage.this, "Please fill up the missing field(s)",Toast.LENGTH_LONG).show();
                        return;
                    }

                    if(selectTwo.equals(selectThree)){
                        Toast.makeText(ConversionPage.this,"Please select different currencies above",Toast.LENGTH_LONG).show();
                        return;
                    }
                    String in = inputTxt.getText().toString();
                    float input = Float.parseFloat(in);
                    float rate = Float.parseFloat(convRate);

                    final TextView out = findViewById(R.id.output_txt);




                    if(selectTwo.equals(selectedCoin) && selectThree.equals(currencyPos) && inputTxt.length()>0){

                        float  output =  input * rate;
                        if(selectTwo.equals(selectedCoin)){
                            imageView = findViewById(R.id.img);
                            imageView.setImageResource(symbols.get(pos));
                        }
//                        else if(!selectTwo.equals(selectedCoin)){
//                            imageView = findViewById(R.id.img);
//                            imageView.setImageResource(R.mipmap.ethereum_sym);
//                        }

                        out.setText(getFormattedConv(output));

                    }
                    else if(selectTwo.equals(currencyPos) && selectThree.equals(selectedCoin) && inputTxt.length()>0){

                        float output =  input / rate;
                        if(selectTwo.equals(currencyPos) && selectThree.equals(selectedCoin)){
                            imageView = findViewById(R.id.img);
                            imageView.setImageResource(R.mipmap.ethereum_sym);

                        }

                        out.setText(getFormattedConv(output));
                    }

                    inputTxt.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                        }

                        @Override
                        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                            out.setText("");
                            imageView = findViewById(R.id.img);
                            imageView.setImageResource(0);
                        }

                        @Override
                        public void afterTextChanged(Editable editable) {

                        }
                    });





                }
            });
        }








    }
    public String getFormattedConv(float output){
        String pattern = "###,###.### ";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
//        decimalFormat.setGroupingSize(3);
//        decimalFormat.format(output);

        return decimalFormat.format(output);
    }
}

