package com.oktopus.jeperaza.mapas.Other;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by jeperaza on 31/05/2017.
 */

public class AsyncTaskProcess extends AsyncTask<String,String,String[]> {

    Context context;
    JSONObject jsonObject;

    public AsyncTaskProcess(Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String[] doInBackground(String... url) {
        try{
            jsonObject = JsonParserObject.readJsonFromUrl(url[0]);
        }catch (Exception ex){

        }
        return new String[0];
    }

    @Override
    protected void onPostExecute(String[] stringFromDoInBackground)
    {
        try{
            new AlertDialog.Builder(context)
                    .setTitle("Advertencia")
                    .setMessage("")
            .setCancelable(false)
            .show();
        }catch (Exception ex){

        }
    }

}
