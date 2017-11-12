package com.treble.crptorate;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAMILOLA on 11/12/2017.
 */

public class AdapterForCards extends RecyclerView.Adapter<AdapterForCards.ViewHolder> {
    private Activity mContext;
    private List<String> currenciesEx ;
    private String mCoinType;
    private int num;
    private static final int LENGTH = 20;


    public AdapterForCards(Activity context,List<String> mCurrencies, String coinType){
        super();
        this.mContext = context;
        this.currenciesEx = mCurrencies;
        this.mCoinType = coinType;
    }

    @Override
    public int getItemCount() {
        return LENGTH;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView cardTitle,convFig,   cardTxt;
        private ImageView sym;
        private ViewHolder(View v){
            super(v);
            cardTitle =  v.findViewById(R.id.card_title);
            convFig =  v.findViewById(R.id.conversion_fig);
            cardTxt =  v.findViewById(R.id.card_text);
            sym = v.findViewById(R.id.symbol);


        }
    }


    @Override
    public AdapterForCards.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listProvider = inflater.inflate(R.layout.conversion_card, parent, false);
        return new AdapterForCards.ViewHolder(listProvider);
    }

    @Override
    public void onBindViewHolder(AdapterForCards.ViewHolder holder, int position) {
        String getRate = currenciesEx.get(position);
        float rate = Float.parseFloat(getRate);

        final List<String> currencyTypeA = new ArrayList<String>();

        currencyTypeA.add("USD");
        currencyTypeA.add("EUR");
        currencyTypeA.add("NGN");
        currencyTypeA.add("GBP");
        currencyTypeA.add("AED");
        currencyTypeA.add("SAR");
        currencyTypeA.add("JPY");
        currencyTypeA.add("INR");
        currencyTypeA.add("EGP");
        currencyTypeA.add("CNY");
        currencyTypeA.add("BRL");
        currencyTypeA.add("AUD");
        currencyTypeA.add("CAD");
        currencyTypeA.add("CHF");
        currencyTypeA.add("DKK");
        currencyTypeA.add("ISK");
        currencyTypeA.add("KES");
        currencyTypeA.add("QAR");
        currencyTypeA.add("SGD");
        currencyTypeA.add("ZAR");

        final List<String> currencyTxtB = new ArrayList<>();
        currencyTxtB.add("Dollars");
        currencyTxtB.add("Euros");
        currencyTxtB.add("Naira");
        currencyTxtB.add("Great Britain pounds");
        currencyTxtB.add("UAE dirham");
        currencyTxtB.add("Saudi Arabia Riyal");
        currencyTxtB.add("Japan Yen");
        currencyTxtB.add("Indian Rupee");
        currencyTxtB.add("Egypt pounds");
        currencyTxtB.add("China Yuan");
        currencyTxtB.add("Brazil Real");
        currencyTxtB.add("Australian dollars");
        currencyTxtB.add("Canada Dollar");
        currencyTxtB.add("Switzerland Francs");
        currencyTxtB.add("Denmark Krone");
        currencyTxtB.add("Iceland Krona");
        currencyTxtB.add("Kenya Shilling");
        currencyTxtB.add( "Qatar Riyal");
        currencyTxtB.add( "Singapore Dollar");
        currencyTxtB.add("South Africa Rand");

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





//       String you = currencyTypeA[position];
//       String rate = getRate;

        holder.cardTitle.setText("1"+mCoinType+"-"+currencyTypeA.get(position));
        holder.convFig.setText(getFormattedConv(rate));
        holder.sym.setImageResource(symbols.get(position));
        holder.cardTxt.setText("Click here for "+currencyTxtB.get(position)+" to "+mCoinType+" exchange rate");

    }

    public String getFormattedConv(float output){
        String pattern = "###,###.### ";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
//        decimalFormat.setGroupingSize(3);
//        decimalFormat.format(output);

        return decimalFormat.format(output);
    }

}

