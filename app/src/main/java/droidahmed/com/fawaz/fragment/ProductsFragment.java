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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import droidahmed.com.fawaz.R;
import droidahmed.com.fawaz.api.GetHome;
import droidahmed.com.fawaz.controller.HomeAdapter;
import droidahmed.com.fawaz.controller.OnResponseResult;
import droidahmed.com.fawaz.controller.ProductsAdapter;
import droidahmed.com.fawaz.controller.Utility;
import droidahmed.com.fawaz.model.HomeModel;
import droidahmed.com.fawaz.model.ProductItem;
import droidahmed.com.fawaz.model.ResponseHome;

/**
 * Created by ahmed on 3/8/2016.
 */
public class ProductsFragment extends Fragment implements
        AdapterView.OnItemClickListener {
    ListView listView;
    private List<HomeModel> homeList;
    private OnResponseResult homeListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selected_product,container,false);


        listView = (ListView) view.findViewById(R.id.list);
        initLayout();

        return view;

    }

    private void initLayout() {


        listView.setOnItemClickListener(this);

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
                Utility.showFailureDialog(getActivity(), true,"");
            }
        };

        GetHome task = new GetHome(getActivity(), homeListener);
        task.execute();

    }
    private void setDate() {

        ProductsAdapter adapter = new ProductsAdapter(getActivity(), homeList);
        listView.setAdapter(adapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        MainActivity mainActivity = new MainActivity();
//        mainActivity.ui("Products");
        getActivity().findViewById(R.id.imgLogo).setVisibility(View.GONE);
        getActivity().findViewById(R.id.imgBack).setVisibility(View.VISIBLE);
      //  getActivity().findViewById(R.id.textTitle).setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.mainFragment, new ProductFragment());
        ft.commit();
    }
}
