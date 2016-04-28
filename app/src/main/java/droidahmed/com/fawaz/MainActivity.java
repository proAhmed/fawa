package droidahmed.com.fawaz;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.ArrayList;
import java.util.Locale;

import droidahmed.com.fawaz.controller.SaveData;
import droidahmed.com.fawaz.controller.Utility;
import droidahmed.com.fawaz.fragment.MenuFragment;
import droidahmed.com.fawaz.fragment.ProductFragment;
import droidahmed.com.fawaz.fragment.StartFragment;
import droidahmed.com.fawaz.model.SlidingMenuItem;

public class MainActivity extends SlidingFragmentActivity {
    private ArrayList<SlidingMenuItem> listMenuItems;
ImageView imgMenu,imgBack,imgLogo,imgFlag;
    TextView txt;
    public static FragmentManager frgManager;
RelativeLayout relativeLayout;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Locale locale = new Locale(new SaveData(this).getLang());
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        this.getApplicationContext().getResources().updateConfiguration(config, null);
          setContentView(R.layout.content_main);
        setBehindView();
        frgManager = getSupportFragmentManager();
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeMain);
        SlidingMenu sm = getSlidingMenu();
        sm.setMode(SlidingMenu.RIGHT);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgLogo = (ImageView) findViewById(R.id.imgLogo);
        txt = (TextView) findViewById(R.id.textTitle);
        sm.setShadowWidthRes(R.dimen.shadow_width);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        sm.setFadeDegree(0.35f);
//        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainFragment, new StartFragment());
        ft.commit();
        imgMenu = (ImageView) findViewById(R.id.imgMenu);

        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();

            }
        });
    }
    private void setBehindView() {
        setBehindContentView(R.layout.menu_slide);

        //transaction fragment to sliding menu
        transactionFragments(MenuFragment.newInstance(), R.id.menu_slide);
    }
    public void transactionFragments(Fragment fragment, int viewResource) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(viewResource, fragment);
        ft.commit();
        toggle();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void ui(String text){
        setContentView(R.layout.content_main);
        imgBack = (ImageView) findViewById(R.id.imgBack);
    imgLogo = (ImageView) findViewById(R.id.imgLogo);
    txt = (TextView) findViewById(R.id.textTitle);
        imgBack.setVisibility(View.VISIBLE);
        imgLogo.setVisibility(View.GONE);
        txt.setVisibility(View.VISIBLE);
        txt.setText(text);
    }
    private void removeBackStack() {
        frgManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
            frgManager.popBackStack();
            frgManager.beginTransaction().commit();

             super.onBackPressed();
        }

}
