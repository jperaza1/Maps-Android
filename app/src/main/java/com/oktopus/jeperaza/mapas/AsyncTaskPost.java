package com.oktopus.jeperaza.mapas;

import android.os.AsyncTask;
import android.util.Log;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by jeperaza on 30/05/2017.
 */

public class AsyncTaskPost extends AsyncTask <Void, Void,String> {
    String Url,Json;

    public AsyncTaskPost(String Url, String Json){
        this.Url = Url;
        this.Json = Json;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void... params) {
        return getServerResponse(Json);
    }

    @Override
    protected void onPostExecute(String s){

    }

    private String getServerResponse(String jsonss) {
        try {

            URL object = new URL(Url);

            HttpURLConnection con = (HttpURLConnection) object.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(jsonss);
            wr.flush();
            wr.close();

            String response = con.getResponseMessage();

            if(con.getResponseCode() == HttpURLConnection.HTTP_NO_CONTENT || response == null){

            }else{

            }

            return response;

        }catch (Exception ex){
            ex.printStackTrace();
            Log.v("JSON", ex.getMessage());
            //CargaData=false;
            return  null;
        }
    }

}
