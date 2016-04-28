package droidahmed.com.fawaz.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.controller.JsonParser;
import droidahmed.com.fawaz.controller.Keys;
import droidahmed.com.fawaz.controller.OnResponseResult;
import droidahmed.com.fawaz.model.ResponseHome;

/**
 * Created by ahmed on 4/3/2016.
 */
public class GetOrder extends AsyncTask<String,Void,ResponseHome> {
    private ProgressDialog dialog;
    private final static String URL = Keys.BASE_URL_ARABIC + "home/featured";
    private OnResponseResult callback;
    private Context context;
    public GetOrder(Context context, OnResponseResult cb) {
        dialog = new ProgressDialog(context);
        callback = cb;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        this.dialog.setMessage(context.getResources().getString(
                R.string.loading));
        this.dialog.setCancelable(false);
        this.dialog.show();
    }

    @Override
    protected ResponseHome doInBackground(String... params) {
        String responseJSON = null;
        ResponseHome obj = null;

        try {
            responseJSON = JsonParser.doHttpUrlConnectionAction(URL);
            Log.d("home",responseJSON);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Gson gson = new Gson();
        if (responseJSON != null && responseJSON.length() > 1) {

            GsonBuilder gb = new GsonBuilder();
            gb.serializeNulls();
            gson = gb.create();
            try {
                obj = gson.fromJson(responseJSON, ResponseHome.class);
            } catch (com.google.gson.JsonSyntaxException ex) {
                ex.printStackTrace();
            }

        }
        return obj;
    }

    @Override
    protected void onPostExecute(ResponseHome responseHome) {
        super.onPostExecute(responseHome);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }

        if (responseHome != null && !responseHome.isError()) {
            callback.onSuccess(responseHome);
        } else {
            callback.onFailure();
        }
    }
}
