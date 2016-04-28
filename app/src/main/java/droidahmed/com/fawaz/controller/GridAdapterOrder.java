package droidahmed.com.fawaz.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.model.HomeModel;
import droidahmed.com.fawaz.model.Products;


/**
 * Created by ahmed on 1/13/2016.
 */
public class GridAdapterOrder extends BaseAdapter {

    private ArrayList<HomeModel> order;
    private Context context;
    OnItemClicked onItemClicked;
    int amount;
    public GridAdapterOrder(Context ctx, ArrayList<HomeModel> order) {
        this.order = order;
        this.context = ctx;
        this.onItemClicked= onItemClicked;
    }


    @Override
    public int getCount() {
        return order.size();
    }

    @Override
    public Object getItem(int position) {
        return order.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   //     amount = Integer.parseInt(order.get(position).getQuantity());
        TextView tvListItem;
        ImageView imgLeft;
        ImageView imgRight;
        TextView tvPrice;
        TextView tvCold;
        TextView tvCompress;
        TextView tvRemote;
        TextView tvVoltage;
        TextView tvBacterial;
        TextView tvQuantity;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.card_items_order, parent, false);
        }
//        imgLeft = (ImageView) convertView.findViewById(R.id.imgLeft);
//        imgRight = (ImageView) convertView.findViewById(R.id.imgRight);
//        imgLeft.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                amount = Integer.parseInt(order.get(position).getQuantity())+1;
//             }
//        });
//        imgRight.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                amount = Integer.parseInt(order.get(position).getQuantity())-1;
//             }
//        });
//        tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
//        tvPrice.setText(order.get(position).getPrice());
        tvCold = (TextView) convertView.findViewById(R.id.tvCold);
//        tvCold.setText(order.get(position).getPrice());
//        tvCompress = (TextView) convertView.findViewById(R.id.tvCompress);
//        tvCompress.setText(order.get(position).getPrice());
//        tvRemote = (TextView) convertView.findViewById(R.id.tvRemote);
//        tvRemote.setText(order.get(position).getPrice());
//        tvVoltage = (TextView) convertView.findViewById(R.id.tvVoltage);
//        tvVoltage.setText(order.get(position).getPrice());
//        tvBacterial = (TextView) convertView.findViewById(R.id.tvBacterial);
//        tvBacterial.setText(order.get(position).getPrice());
//        tvQuantity = (TextView) convertView.findViewById(R.id.tvQuantity);
//        tvQuantity.setText(amount);

//        tvListItem = (TextView) convertView.findViewById(R.id.grTextView);
//        imageGrid = (ImageView) convertView.findViewById(R.id.grImageView);
//        tvListItem.setText(userTypes.get(position).getUserType());
//        imageGrid.setImageResource(userTypes.get(position).getUserTypeImage());


        return convertView;
    }
}
