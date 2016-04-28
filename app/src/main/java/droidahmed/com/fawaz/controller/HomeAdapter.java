package droidahmed.com.fawaz.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.model.HomeModel;
import droidahmed.com.fawaz.model.ProductItem;
import droidahmed.com.fawaz.model.Products;


/**
 * Created by ahmed on 1/19/2016.
 */
public class HomeAdapter extends BaseAdapter {

    List<HomeModel> _choices;
    private Context context;


    public HomeAdapter(Context context, List<HomeModel> _choices) {
        this.context = context;
        this._choices = _choices;
    }

    @Override
    public int getCount() {
        return _choices.size();
    }

    @Override
    public Object getItem(int position) {
        return _choices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TextView textViewName;
        ImageView imageViewIcon;
        TextView tvPrice;
        TextView tvCold;
        TextView tvCompress;
        TextView tvRemote;
        TextView tvVoltage;
        TextView tvBacterial;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.card_items, parent, false);
        }

        imageViewIcon = (ImageView) convertView.findViewById(R.id.imgCard);
        tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
        tvPrice.setText(_choices.get(position).getPrice());
        tvCold = (TextView) convertView.findViewById(R.id.tvCold);
        tvCold.setText(_choices.get(position).getPrice());
        tvCompress = (TextView) convertView.findViewById(R.id.tvCompress);
        tvCompress.setText(_choices.get(position).getPrice());
        tvRemote = (TextView) convertView.findViewById(R.id.tvRemote);
        tvRemote.setText(_choices.get(position).getPrice());
        tvVoltage = (TextView) convertView.findViewById(R.id.tvVoltage);
        tvVoltage.setText(_choices.get(position).getPrice());
        tvBacterial = (TextView) convertView.findViewById(R.id.tvBacterial);
        tvBacterial.setText(_choices.get(position).getPrice());

        Picasso.with(context).load(_choices.get(position).getPicture()).placeholder(context.getResources().getDrawable(R.drawable.airr)).into(imageViewIcon);

        return convertView;
    }
}
