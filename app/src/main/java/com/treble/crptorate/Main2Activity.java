package com.treble.crptorate;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<String>> {


    private List<String> listCurrencies;

    private static final String LOG_TAG = Main2Activity.class.getName();

    private static final int CURRENCY_LOADER_ID = 1;

    private String coin;

    /**
     * TextView that is displayed when the list is empty
     */
    private TextView mEmptyStateTextView;

    /**
     * URL for github data from the Github API dataset
     */
    private static final String EXCHANGE_REQUEST_URL_FOR_BTC =
            "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD,EUR,NGN,GBP,AED,SAR" +
                    ",JPY,INR,EGP,CNY,BRL,AUD,CAD,CHF,DKK,ISK,KES,QAR,SGD,ZAR";

    private  static  final  String  EXCHANGE_REQUEST_URL_FOR_ETH = "https://min-api." +
            "cryptocompare.com/data/price?fsym=ETH&tsyms=" +
            "USD,EUR,NGN,GBP,AED,SAR" +
            ",JPY,INR,EGP,CNY,BRL,AUD,CAD,CHF,DKK,ISK,KES,QAR,SGD,ZAR";







    private  String FINAL_STRING ;
    private AdapterForCards adapterForCards;
    private RecyclerView listView;
    private String selected;
    private RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Toolbar appBar = (Toolbar) findViewById(R.id.app_bar);
//        setSupportActionBar(appBar);

        Bundle i = getIntent().getExtras();
        selected = i.getString("coinType");

        mEmptyStateTextView =  findViewById(R.id.empty_view);

        listView =  findViewById(R.id.recyclerview);

        listView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);


        final  List<String> currencyTypeA = new ArrayList<>();
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






        listCurrencies = new ArrayList<String>();






        if(selected.equals("Bitcoin")){
            coin = "Bitcoin";
            FINAL_STRING = EXCHANGE_REQUEST_URL_FOR_BTC;

            // Get a reference to the LoaderManager , in order to interact with the loaders
            LoaderManager loaderManager = getLoaderManager();

            Log.i(LOG_TAG, "TEST: calling initLoader()...");
            loaderManager.initLoader(CURRENCY_LOADER_ID, null, Main2Activity.this);

            // Get a reference to the ConnectivityManager to check state of network connectivity
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            // Get details on the currently active default data network
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            // If there is a network connection, fetch data
            if (networkInfo != null && networkInfo.isConnected() && (selected.equals("Bitcoin")|| selected.equals("Ethereum"))) {
                // Get a reference to the LoaderManager, in order to interact with loaders.
                loaderManager = getLoaderManager();

                // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                // because this activity implements the LoaderCallbacks interface).
                loaderManager.initLoader(CURRENCY_LOADER_ID, null, Main2Activity.this);
            } else {
                // Otherwise, display error
                // First, hide loading indicator so error message will be visible
                View loadingIndicator = findViewById(R.id.loading_spinner);
                loadingIndicator.setVisibility(View.GONE);

                // Update empty state with no connection error message
                mEmptyStateTextView.setText("No Internet connection");
            }
        }
        else if(selected.equals("Ethereum")){
            coin = "Ethereum";
            FINAL_STRING = EXCHANGE_REQUEST_URL_FOR_ETH;
            // Get a reference to the LoaderManager , in order to interact with the loaders
            LoaderManager loaderManager = getLoaderManager();

            Log.i(LOG_TAG, "TEST: calling initLoader()...");
            loaderManager.initLoader(CURRENCY_LOADER_ID, null, Main2Activity.this);

            // Get a reference to the ConnectivityManager to check state of network connectivity
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            // Get details on the currently active default data network
            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
            // If there is a network connection, fetch data
            if (networkInfo != null && networkInfo.isConnected() && (selected.equals("Bitcoin")|| selected.equals("Ethereum"))) {
                // Get a reference to the LoaderManager, in order to interact with loaders.
                loaderManager = getLoaderManager();

                // Initialize the loader. Pass in the int ID constant defined above and pass in null for
                // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
                // because this activity implements the LoaderCallbacks interface).
                loaderManager.initLoader(CURRENCY_LOADER_ID, null, Main2Activity.this);
            } else {
                // Otherwise, display error
                // First, hide loading indicator so error message will be visible
                View loadingIndicator = findViewById(R.id.loading_spinner);
                loadingIndicator.setVisibility(View.GONE);

                // Update empty state with no connection error message
                mEmptyStateTextView.setText("No Internet connection");
            }
        }











        ItemClickSupport.addTo(listView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView listView, int position, View v) {
                String convRate = listCurrencies.get(position);
                String currencyPos = currencyTypeA.get(position);
                int pos = position;

                Intent intent = new Intent(Main2Activity.this,ConversionPage.class);
                intent.putExtra("convRate",convRate);
                intent.putExtra("selectedCoin",selected);
                intent.putExtra("currencyPos",currencyPos);
                intent.putExtra("pos",pos);
                startActivity(intent);
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



//            }
//        });



    }


    @Override
    public Loader<List<String>> onCreateLoader(int i, Bundle bundle) {
        Log.i(LOG_TAG, "TEST: onCreateLoader() called ...");
        // Create a new loader for the given URL
        return new CurrencyLoader(this, FINAL_STRING);
    }

    @Override
    public void onLoadFinished(Loader<List<String>> loader, List<String> strings) {
        Log.i(LOG_TAG, "TEST: onLoadFinished() called....");
        View loadingIndicator = findViewById(R.id.loading_spinner);

        loadingIndicator.setVisibility(View.GONE);

//        listCurrencies.clear();




        // If there is a valid list of {@link Github}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (strings != null && !strings.isEmpty()) {

            listCurrencies.addAll(strings);
            adapterForCards = new AdapterForCards(Main2Activity.this,listCurrencies,coin);
            listView.setLayoutManager(manager);
//            int curSize = adapterForCards.getItemCount();
//            adapterForCards.notifyItemRangeInserted(curSize,listCurrencies.size());
            listView.setAdapter(adapterForCards);
            listView.smoothScrollToPosition(listCurrencies.size()-1);





        }
        else{
            // Set empty state text to display "No currency information found."
            mEmptyStateTextView.setText("No Currency information found.");
        }

    }

    @Override
    public void onLoaderReset(Loader<List<String>> loader) {
        Log.i(LOG_TAG, "TEST: onLoaderReset() called...");
        // Loader reset, so we can clear out our existing data.
//        adapterForCards.clear();

    }
}
