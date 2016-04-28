package droidahmed.com.fawaz.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.model.HomeModel;


/**
 * Created by ahmed on 1/19/2016.
 */
public class ProductsAdapter extends BaseAdapter {

    List<HomeModel> _choices;
    private Context context;


    public ProductsAdapter(Context context, List<HomeModel> _choices) {
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
        TextView tvSelect;
        ImageView imageProduct;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.selected_item, parent, false);
        }

        imageProduct = (ImageView) convertView.findViewById(R.id.imageProduct);
        tvSelect = (TextView) convertView.findViewById(R.id.tvSelect);
        tvSelect.setText(_choices.get(position).getPrice());


        Picasso.with(context).load(_choices.get(position).getPicture()).placeholder(context.getResources().getDrawable(R.drawable.airr)).into(imageProduct);

        return convertView;
    }
}
