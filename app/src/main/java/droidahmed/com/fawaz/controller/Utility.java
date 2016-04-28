package droidahmed.com.fawaz.controller;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;

import droidahmed.com.fawaz.MainActivity;
import droidahmed.com.fawaz.R;

/**
 * Created by ahmed on 4/7/2016.
 */
public class Utility {
    public static void showFailureDialog(Context mContext, final boolean back,String error) {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                mContext);

        alertDialogBuilder
                .setMessage(
                         error)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        alertDialogBuilder.setCancelable(true);
                        if (back) {
                            Utility.deleteFormBackStack();
                        }
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    public static void deleteFormBackStack() {
        MainActivity.frgManager.popBackStack();
        MainActivity.frgManager.beginTransaction().commit();
    }
    public static String makeRequest(String url) throws Exception {

        HttpURLConnection urlConnection = null;
        try {
            // create connection
            URL urlToRequest = new URL(url);
            urlConnection = (HttpURLConnection) urlToRequest.openConnection();
            // urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            // urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);

            // handle issues
            int statusCode = urlConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
                // handle unauthorized (if service requires user login)
            } else if (statusCode != HttpURLConnection.HTTP_OK) {
                // handle any other errors, like 404, 500,..
            }
            StringBuilder total = new StringBuilder();

            InputStream in = new BufferedInputStream(
                    urlConnection.getInputStream());

            BufferedReader r = new BufferedReader(new InputStreamReader(in),
                    8000);
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            in.close();

            return total.toString();

        } catch (MalformedURLException e) {
            // URL is invalid
        } catch (SocketTimeoutException e) {
            // data retrieval or connection timed out
        } catch (IOException e) {
            // could not read response body
        }

        return null;
    }
}
