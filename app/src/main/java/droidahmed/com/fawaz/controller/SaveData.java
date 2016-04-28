package droidahmed.com.fawaz.controller;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ahmed on 3/9/2016.
 */
public class SaveData {

    String DATABASE_NAME = "sand.ubicall";
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static boolean callFlag;
    public static boolean acceptCall;
    public static boolean connectionState;
    public SaveData(Context ctx) {
        super();
        this.context = ctx;

        sharedPreferences = context.getSharedPreferences(DATABASE_NAME,
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void saveLang(String lang) {
        editor.putString("lang", lang);
        editor.commit();
    }

    public String getLang() {
        String jsonString = sharedPreferences.getString("lang", "");
        return jsonString;
    }

}
