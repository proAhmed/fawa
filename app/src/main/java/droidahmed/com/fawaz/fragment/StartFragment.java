package droidahmed.com.fawaz.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import droidahmed.com.fawaz.AboutUS;
import droidahmed.com.fawaz.ContactActivity;
import droidahmed.com.fawaz.ContactUs;
import droidahmed.com.fawaz.MainActivity;
import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.SocialMedia;

/**
 * Created by ahmed on 3/8/2016.
 */
public class StartFragment extends Fragment {
    ImageView imgAboutUs,imgContactUs,imgSocialMedia;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start_fragment,container,false);
        imgAboutUs = (ImageView) view.findViewById(R.id.imgAboutUs);
        imgContactUs = (ImageView) view.findViewById(R.id.imgContactUs);
        imgSocialMedia = (ImageView) view.findViewById(R.id.imgSocialMedia);
        MainActivity activity = (MainActivity) getActivity();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        imgAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AboutUS.class);
                startActivity(intent);
            }
        });

        imgContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ContactUs.class);
                startActivity(intent);
            }
        });

        imgSocialMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),SocialMedia.class);
                startActivity(intent);
            }
        });
        return view;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        MainActivity mainActivity = new MainActivity();
//        mainActivity.ui("Products");
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.findViewById(R.id.relativeMain).setBackgroundResource(R.drawable.bar_main);
        mainActivity.findViewById(R.id.imgLogo).setVisibility(View.GONE);
        int color = Color.parseColor("#FFFFFF"); //The color u want
        ImageView imageView= (ImageView) getActivity().findViewById(R.id.imgMenu);
        imageView.setColorFilter(color);


    }
}
