package droidahmed.com.fawaz.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.bhavin.horizontallistview.HorizontalListView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.controller.GridAdapter;
import droidahmed.com.fawaz.controller.GridAdapterOrder;
import droidahmed.com.fawaz.model.HomeModel;
import droidahmed.com.fawaz.model.Products;

public class OrderFragment extends Fragment {

    GridView gridView;
    ArrayList<HomeModel>products;
    EditText edName,edMobile,edMail;
    Button btnSubmit,btnCancel;
    HorizontalListView viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders,container,false);
        products = new ArrayList<>();
     //   products.add(new HomeModel());
        products.add(new HomeModel(1,1,1,"ds","dfdfs","dfs","dfd","df","df","df",1,1,1,1,1));
      // products.add(new HomeModel("","",""));
          viewPager = (HorizontalListView) view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new GridAdapterOrder(getActivity(),products));

        edName = (EditText) view.findViewById(R.id.edName);
        edMobile = (EditText) view.findViewById(R.id.edMobile);
        edMail = (EditText) view.findViewById(R.id.edMail);
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
//        gridView = (GridView) view.findViewById(R.id.grid);
//        gridView.setAdapter(new GridAdapter(getActivity(),products));
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                FragmentManager fm = getActivity().getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.mainFragment, new ProductsFragment());
//                ft.commit();
//            }
//        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        MainActivity mainActivity = new MainActivity();
//        mainActivity.ui("Products");
        getActivity().findViewById(R.id.imgLogo).setVisibility(View.GONE);
        getActivity().findViewById(R.id.imgBack).setVisibility(View.VISIBLE);
//        getActivity().findViewById(R.id.textTitle).setVisibility(View.VISIBLE);
//     TextView tv = (TextView) getActivity().findViewById(R.id.textTitle);
//        tv.setText(getString(R.string.order));
    }
}
