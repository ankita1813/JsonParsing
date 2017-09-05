package com.androidbuts.jsonparsing.parser;

import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


/**
 * @author Ankita Tiwari
 */
public class JSONParser {

    /********
     * URLS
     *******/
    private static final String MAIN_URL = "http://54.254.198.83:8080/favourite.json";

    /**
     * TAGs Defined Here...
     */
    public static final String TAG = "TAG";

    /**
     * Key to Send
     */
    private static final String KEY_VIEWCOUNT = "VIEW_COUNT";

    /**
     * Response
     */
    private static Response response;

    /**
     * Get Table Booking Charge
     *
     * @return JSON Object
     */
    public static JSONArray getDataFromWeb() {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(MAIN_URL)
                    .build();
            response = client.newCall(request).execute();
            return new JSONArray(response.body().string());
        } catch (@NonNull IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }

    /**
     * Get Particular Record
     *
     * @param Viewcount UserId
     * @return JSONObject
     */
    public static JSONObject getDataById(int Viewcount) {

        try {
            OkHttpClient client = new OkHttpClient();

            RequestBody formBody = new FormEncodingBuilder()
                    .add(KEY_VIEWCOUNT, Integer.toString(Viewcount))
                    .build();

            Request request = new Request.Builder()
                    .url(MAIN_URL)
                    .post(formBody)
                    .build();

            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());

        } catch (IOException | JSONException e) {
            Log.e(TAG, "" + e.getLocalizedMessage());
        }
        return null;
    }
}
