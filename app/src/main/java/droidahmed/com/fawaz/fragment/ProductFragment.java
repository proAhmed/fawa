package droidahmed.com.fawaz.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import droidahmed.com.fawaz.MainActivity;
import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.api.GetHome;
import droidahmed.com.fawaz.controller.GridAdapter;
import droidahmed.com.fawaz.controller.HomeAdapter;
import droidahmed.com.fawaz.controller.OnResponseResult;
import droidahmed.com.fawaz.controller.Utility;
import droidahmed.com.fawaz.model.HomeModel;
import droidahmed.com.fawaz.model.Products;
import droidahmed.com.fawaz.model.ResponseHome;

/**
 * Created by ahmed on 3/8/2016.
 */
public class ProductFragment extends Fragment implements
        AdapterView.OnItemClickListener{
    GridView gridView;
    private ArrayList<HomeModel> homeList;
    private OnResponseResult homeListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_products,container,false);

        gridView = (GridView) view.findViewById(R.id.grid);
       // gridView.setAdapter(new GridAdapter(getActivity(), homeList));
        initLayout();
        return view;

    }
    private void initLayout() {


        gridView.setOnItemClickListener(this);

        homeList = new ArrayList<>();

        homeListener = new OnResponseResult() {

            @Override
            public void onSuccess(Object result) {

                ResponseHome obj = (ResponseHome) result;

                homeList = obj.getData();

                setDate();
            }

            @Override
            public void onFailure() {
                Utility.showFailureDialog(getActivity(), true, "");
            }
        };

        GetHome task = new GetHome(getActivity(), homeListener);
        task.execute();

    }
    private void setDate() {

        HomeAdapter adapter = new HomeAdapter(getActivity(), homeList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ProductsFragment productsFragment = new ProductsFragment();
                Bundle argument = new Bundle();
                argument.putParcelable("", homeList.get(position));
                productsFragment.setArguments(argument);
                ft.replace(R.id.mainFragment, productsFragment);
                ft.commit();
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        MainActivity mainActivity = new MainActivity();
//        mainActivity.ui("Products");
        getActivity().findViewById(R.id.imgLogo).setVisibility(View.GONE);
        getActivity().findViewById(R.id.imgBack).setVisibility(View.VISIBLE);
        getActivity().findViewById(R.id.textTitle).setVisibility(View.VISIBLE);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
