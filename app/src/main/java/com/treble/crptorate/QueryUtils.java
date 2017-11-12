package com.treble.crptorate;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAMILOLA on 11/12/2017.
 */

public final class QueryUtils {

    /** Tag for the log messages */
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();
    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }

    /**
     * Query the Github API dataset and return a list of {@link String} objects.
     */


    public static List<String> fetchGithubData(String requestUrl) {
        Log.i(LOG_TAG,"TEST: fetchCurrenciesData called...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link Earthquake}s
        List<String> exchangeResp = extractFeatureFromJson(jsonResponse);

        // Return the list of {@link currencies}s
        return exchangeResp;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the exchange rate JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    /**
     * Return a list of {@link Github} objects that has been built up from
     * parsing a JSON response.
     */
    /**
     * Return a list of {@link String} objects that has been built up from
     * parsing the given JSON response.
     */
    private static List<String> extractFeatureFromJson(String githubJSON) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(githubJSON)) {
            return null;
        }

        // Create an empty ArrayList that we can start adding github data to
        List<String>  currencies = new ArrayList<>();

        // Try to parse the JSON response string. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(githubJSON);

//             currencies.add(baseJsonResponse.toString());




//                // Get a single currencyData at position i within the list of items
//                JSONObject currentItemObject = itemsArray.getJSONObject(i);



            // Extract the values for the individual keys
            String usd = baseJsonResponse.getString("USD");
            String eur = baseJsonResponse.getString("EUR");
            String ngn = baseJsonResponse.getString("NGN");
            String gbp = baseJsonResponse.getString("GBP");
            String aed = baseJsonResponse.getString("AED");
            String sar = baseJsonResponse.getString("SAR");
            String jpy = baseJsonResponse.getString("JPY");
            String inr = baseJsonResponse.getString("INR");
            String egp = baseJsonResponse.getString("EGP");
            String cny = baseJsonResponse.getString("CNY");
            String brl = baseJsonResponse.getString("BRL");
            String aud = baseJsonResponse.getString("AUD");
            String cad = baseJsonResponse.getString("CAD");
            String chf = baseJsonResponse.getString("CHF");
            String dkk = baseJsonResponse.getString("DKK");
            String isk = baseJsonResponse.getString("ISK");
            String kes = baseJsonResponse.getString("KES");
            String qar = baseJsonResponse.getString("QAR");
            String sgd = baseJsonResponse.getString("SGD");
            String zar = baseJsonResponse.getString("ZAR");
//                String alc = baseJsonResponse.getString("ALC");







            // Add the new {@link String} to the list of .
            currencies.add(usd);
            currencies.add(eur);
            currencies.add(ngn);
            currencies.add(gbp);
            currencies.add(aed);
            currencies.add(sar);
            currencies.add(jpy);
            currencies.add(inr);
            currencies.add(egp);
            currencies.add(cny);
            currencies.add(brl);
            currencies.add(aud);
            currencies.add(cad);
            currencies.add(chf);
            currencies.add(dkk);
            currencies.add(isk);
            currencies.add(kes);
            currencies.add(qar);
            currencies.add(sgd);
            currencies.add(zar);



        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the currencies JSON results", e);
        }

        // Return the list of currencies
        return currencies;
    }

}


