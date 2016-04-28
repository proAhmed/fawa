package droidahmed.com.fawaz.api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.controller.Keys;
import droidahmed.com.fawaz.controller.OnResponseResult;
import droidahmed.com.fawaz.model.FavoriteResponse;

/**
 * Created by ahmed on 4/2/2016.
 */
public class AddToFavorite extends AsyncTask<String, Void, FavoriteResponse> {

    private final static String URL = Keys.BASE_URL + "profile/addoffer";
    private ProgressDialog dialog;
    private OnResponseResult callback;
    private Context context;

    public AddToFavorite(Context context, OnResponseResult cb) {
        dialog = new ProgressDialog(context);
        callback = cb;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        this.dialog.setMessage(context.getResources().getString(
                R.string.cancel));
        this.dialog.setCancelable(false);
        this.dialog.show();
    }

    @Override
    protected FavoriteResponse doInBackground(String... params) {
        String responseJSON = null;
        FavoriteResponse obj = null;

        try {
       //     responseJSON = makeRequest(params[0]);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d("iii", e.toString());
        }

        Gson gson = new Gson();
        if (responseJSON != null && responseJSON.length() > 1) {

            GsonBuilder gb = new GsonBuilder();
            gb.serializeNulls();
            gson = gb.create();
            try {
                obj = gson.fromJson(responseJSON, FavoriteResponse.class);
            } catch (com.google.gson.JsonSyntaxException ex) {
                ex.printStackTrace();
            }
        }

        return obj;
    }

    @Override
    protected void onPostExecute(FavoriteResponse result) {

        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        if (result != null) {
            callback.onSuccess(result);
        } else {
            callback.onFailure();
        }
    }
//    public static String makeRequest(String obj) throws Exception {
//        String jsons ;
//        StringBuilder total = new StringBuilder();
//        try{
//            DefaultHttpClient httpclient = new DefaultHttpClient();
//            HttpPost httpost = new HttpPost(URL);
//
//            JSONObject json = new JSONObject();
//
////            json.put("AuthUserName", obj.getAuthUserName());
////            json.put("AuthPassword", obj.getAuthPassword());
////            json.put("Category", obj.getCategoryID());
////            json.put("City", obj.getCityID());
////            json.put("Title", obj.getTitle());
////            json.put("Contents", obj.getContents());
////            json.put("Mobile", obj.getMobile());
////
////            if (obj.getAllowComments().equalsIgnoreCase("true"))
////                json.put("AllowComments", "1");
////            else
////                json.put("AllowComments", "0");
////
////            if (!obj.getPicture().equals("-1")) {
////
////                json.put("Picture", obj.getPicture());
////                json.put("Pictures", new JSONArray(obj.getPictures()));
////            }
//            //jsons =json.toString();
//            //	new String(json.put("name").getBytes("ISO-8859-1"), "UTF-8");
//            //	Log.d("yyyy", jsons);
////		InputStreamEntity entity = null;
//
//            InputStreamEntity entity = null;
//            try {
//                InputStream is = new ByteArrayInputStream(json.toString().getBytes(
//                        "UTF-8"));
//
//                entity = new InputStreamEntity(is, is.available());
//
//            } catch (UnsupportedEncodingException e) {
//
//                e.printStackTrace();
//            } catch (IOException e) {
//
//                e.printStackTrace();
//            }
//
//            httpost.setEntity(entity);
//            //httpost.setHeader("Content-type", "application/json");
//            HttpResponse response = (HttpResponse) httpclient.execute(httpost);
//
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//
//                InputStream instream = response.getEntity().getContent();
//                BufferedReader r = new BufferedReader(new InputStreamReader(
//                        instream), 8000);
//                String line;
//                while ((line = r.readLine()) != null) {
//                    total.append(line);
//                    Log.d("uuurespo", total.toString());
//                }
//                instream.close();
//            }
//            return total.toString();
//
//
//
//
//////		try {
////			InputStream is = new ByteArrayInputStream(json.toString().getBytes(
////					"UTF-8"));
//////
//////			entity = new InputStreamEntity(is, is.available());
//////
//////		} catch (UnsupportedEncodingException e) {
//////
//////			e.printStackTrace();
//////		} catch (IOException e) {
//////
//////			e.printStackTrace();
//////		}
////
////		//httpost.setEntity(entity);
////		//httpost.setHeader("", json.toString());
////
////
////
////
////	    StringEntity se = new StringEntity(json.toString(),"UTF-8");
////	    se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
////Log.d("sss", se.toString());
//// 		httpost.setEntity(se);
////////
//////
////	httpost.setHeader("Accept", "application/json");
////	se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
////
////		HttpResponse response = (HttpResponse) httpclient.execute(httpost);
////
////		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
////
////			InputStream instream = response.getEntity().getContent();
////			BufferedReader r = new BufferedReader(new InputStreamReader(
////					instream), 8000);
////			String line;
////			while ((line = r.readLine()) != null) {
////				total.append(line);
////			}
////			instream.close();
////		}
//////
//
////		OkHttpClient client = new OkHttpClient();
////
////		MediaType mediaType = MediaType.parse("application/octet-stream");
////		RequestBody body = RequestBody.create(mediaType, "{\r\n\t\"AuthUserName\": \"android\",\r\n\t\"AuthPassword\": \"android2014\",\r\n\t\"Category\": \"300\",\r\n\t\"City\": \"277\",\r\n\t\"Title\": \"إعلان جديد\",\r\n\t\"Contents\": \"محتوى الإعلان محتوى الإعلان محتوى الإعلان محتوى الإعلان \",\r\n\t\"Keywords\": \"إعلان, جديد\",\r\n\t\"Mobile\": \"01111055288\",\r\n\t\"Picture\": \"Media/Images/2015/01/24/14221147208311.jpg\",\r\n\t\"Pictures\": [\r\n\t\t\"Media/Images/2015/01/28/1422480003.jpg\",\r\n\t\t\"Media/Images/2015/01/28/1422480018.jpg\",\r\n\t\t\"Media/Images/2015/01/28/1422480034.jpg\",\r\n\t\t\"Media/Images/2015/01/28/1422480048.jpg\"\r\n\t],\r\n    \"AllowComments\": 1\r\n}\r\n");
////		Request request = new Request.Builder()
////		  .url("http://ksa4sale.com/API/profile/addoffer")
////		  .post(body)
////		  .addHeader("cache-control", "no-cache")
////		  .addHeader("postman-token", "f52a4f92-98b2-afdc-08c6-9b6af4050ad7")
////		  .build();
////
////		Response response = client.newCall(request).execute();
//
//        }
//        catch(Exception e){
//            Log.d("yyyyee", e.toString());
//        }
//
//
//        return total.toString();
//
//    }

//	public static String makeRequest(AddOfferInput obj) throws Exception {
//
//		DefaultHttpClient httpclient = new DefaultHttpClient();
//		HttpPost httpost = new HttpPost(URL);
//		StringBuilder total = new StringBuilder();
//		JSONObject json = new JSONObject();
//
//		json.put("AuthUserName", obj.getAuthUserName());
//		json.put("AuthPassword", obj.getAuthPassword());
//		json.put("Category", obj.getCategoryID());
//		json.put("City", obj.getCityID());
//		json.put("Title", obj.getTitle());
//		json.put("Contents", obj.getContents());
//		json.put("Mobile", obj.getMobile());
//		if (obj.getAllowComments().equalsIgnoreCase("true"))
//			json.put("AllowComments", "1");
//		else
//			json.put("AllowComments", "0");
//
//		if (!obj.getPicture().equals("-1")) {
//
//			json.put("Picture", obj.getPicture());
//			json.put("Pictures", new JSONArray(obj.getPictures()));
//		}
//		InputStreamEntity entity = null;
//		try {
//			InputStream is = new ByteArrayInputStream(json.toString().getBytes(
//					"UTF-8"));
//
//			entity = new InputStreamEntity(is, is.available());
//
//		} catch (UnsupportedEncodingException e) {
//
//			e.printStackTrace();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		httpost.setEntity(entity);
//		httpost.setHeader("Content-type", "application/json");
//		HttpResponse response = (HttpResponse) httpclient.execute(httpost);
//
//		if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//
//			InputStream instream = response.getEntity().getContent();
//			BufferedReader r = new BufferedReader(new InputStreamReader(
//					instream), 8000);
//			String line;
//			while ((line = r.readLine()) != null) {
//				total.append(line);
//			}
//			instream.close();
//		}
//		return total.toString();
//
//	}
// 	private final OkHttpClient client = new OkHttpClient();
//
// 	  public void run() throws Exception {
// 	    RequestBody formBody = new FormEncodingBuilder()
// 	        .add("search", "Jurassic Park")
// 	        .build();
// 	    Request request = new Request.Builder()
// 	        .url("https://en.wikipedia.org/w/index.php")
// 	        .post(formBody)
// 	        .build();
//
// 	    Response response = client.newCall(request).execute();
// 	    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
// 	    System.out.println(response.body().string());
// 	  }


//    public static HttpResponse makeRequest(String uri, String json) {
//        try {
//            HttpPost httpPost = new HttpPost(uri);
//            httpPost.setEntity(new StringEntity(json));
//            httpPost.setHeader("Accept", "application/json");
//            httpPost.setHeader("Content-type", "application/json");
//            return new DefaultHttpClient().execute(httpPost);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
