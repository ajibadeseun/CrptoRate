package com.treble.crptorate;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by DAMILOLA on 11/12/2017.
 */

public class CurrencyLoader extends AsyncTaskLoader<List<String>> {

    /** Tag for log messages */
    private static final String LOG_TAG = CurrencyLoader.class.getName();

    /** Query URL */
    private String mUrl;
    /**
     * Constructs a new {@link CurrencyLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */

    public CurrencyLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public List<String> loadInBackground() {
        Log.i(LOG_TAG,"TEST: loadInBackground() method called...");
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of gitList.
        List<String> currencyList = QueryUtils.fetchGithubData(mUrl);
        return currencyList;
    }
    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG,"TEST: onStartLoading() method called...");
        forceLoad();
    }
}
