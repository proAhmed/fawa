package droidahmed.com.fawaz.controller;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import droidahmed.com.fawaz.model.InputCartItem;

/**
 * Created by ahmed on 4/2/2016.
 */
public class JsonParser {
    public String createSipAccount(String urls,String sdkName,
                                   String device_model,String sdk_version,
                                   String device_version,String device_token,
                                   String deviceUid,String deviceName) throws Exception {

        HttpsURLConnection conexao = null;
        BufferedReader br = null;

        try {

            URL url = new URL(urls);
            conexao = (HttpsURLConnection) url.openConnection();
            conexao.setConnectTimeout(2000);
            conexao.setReadTimeout(3500);
            conexao.setRequestMethod("POST");
            conexao.setDoInput(true);
            conexao.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("sdk_name",sdkName)
                    .appendQueryParameter("device_model", device_model)
                    .appendQueryParameter("sdk_version", sdk_version)
                    .appendQueryParameter("device_version", device_version)
                    .appendQueryParameter("device_token", device_token)
                    .appendQueryParameter("deviceUid", deviceUid)
                    .appendQueryParameter("deviceName", deviceName);
            String query = builder.build().getEncodedQuery();

            conexao.setFixedLengthStreamingMode(query.getBytes().length);

            OutputStream os = conexao.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            writer.write(query);
            writer.flush();
            writer.close();
            os.close();

            conexao.connect();

            int responseCode = conexao.getResponseCode();

            Log.v(" reponseCode", String.valueOf(responseCode));

            if(responseCode == HttpURLConnection.HTTP_OK){

                StringBuilder sb = new StringBuilder();
                try{

                    br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                    String linha;

                    while ((linha = br.readLine())!= null){

                        sb.append(linha);
                    }

                    return sb.toString();
                }catch (Exception e){

//                    e.printStackTrace();
                }

            }else if(responseCode ==401 ){

                return "Unauthorized";
            }

            else{

                if(responseCode == HttpURLConnection.HTTP_CLIENT_TIMEOUT){

                    throw new Exception("Tempo maximo na comunição atingido: "+ conexao.getErrorStream());
                }
            }

        } catch (MalformedURLException e) {

//            e.printStackTrace();
        } catch (IOException e) {

//            e.printStackTrace();
            throw new Exception("Falha de comunicação, verifique sua conexão com a internet");
        }finally {
            br.close();
            conexao.disconnect();
        }

        return null;
    }

    public static String doHttpUrlConnectionAction(String desiredUrl)
    {
        URL url ;
        BufferedReader reader = null;
        StringBuilder stringBuilder;
        HttpURLConnection connection = null;
        String data;
        try
        {
            // create the HttpURLConnection
            url = new URL(desiredUrl);
            connection = (HttpURLConnection) url.openConnection();

            // just want to do an HTTP GET here
            connection.setRequestMethod("GET");
            //   connection.get
            // uncomment this if you want to write output to this url
            //connection.setDoOutput(true);

            // give it 15 seconds to respond
            connection.setReadTimeout(25 * 1000);
            connection.connect();

            // read the output from the server
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            stringBuilder = new StringBuilder();

            String line ;
            while ((line = reader.readLine()) != null)
            {
                stringBuilder.append(line + "\n");

            }
            data= stringBuilder.toString();
            //   Log.d("ddffg",data);
            return data;
        }
        catch (Exception e)
        {

            //  e.printStackTrace();
            data="timeout";
        }
        finally
        {
            // close the reader; this can throw an exception too, so
            // wrap it in another try/catch block.
            if (reader != null)
            {
                try
                {
                    reader.close();
                    connection.disconnect();
                }
                catch (IOException ioe)
                {
                    data="timeout";

                    //  ioe.printStackTrace();
                }
            }
        }
        return data;

    }




    public void method(String string,InputCartItem[] inputCartItem){
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;
        String data="";
        try {
            url = new URL(string);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(true);
             con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestMethod("POST");
             InputStream in = con.getInputStream();
            JSONArray jsonArray = new JSONArray("CartItems");

            for(int i=0;inputCartItem.length>i;i++){
                JSONObject cred = new JSONObject();
                cred.put("ID", inputCartItem[i].getID());
                cred.put("Quantity",inputCartItem[i].getQuantity());
                cred.put("CreatedDate", inputCartItem[i].getCreatedDate());
                jsonArray.put(cred);
            }
            OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
            wr.write(jsonArray.toString());


            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");

            }
            data = stringBuilder.toString();
            //      Log.d("ddfg", data);
        }
        catch (MalformedURLException e) {
//        e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
