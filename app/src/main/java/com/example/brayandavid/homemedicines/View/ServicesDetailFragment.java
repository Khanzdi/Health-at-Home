package com.example.brayandavid.homemedicines.View;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brayandavid.homemedicines.Conection.TaskImages;
import com.example.brayandavid.homemedicines.Objects.Product;
import com.example.brayandavid.homemedicines.R;


public class ServicesDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "producto";
    private Product mItem;

    public ServicesDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            mItem = (Product) getArguments().getSerializable(ARG_ITEM_ID);
            if (appBarLayout != null && mItem != null) {
                appBarLayout.setTitle(mItem.getName());
                TaskImages taskImages = new TaskImages((ImageView) activity.findViewById(R.id.image_details));
                taskImages.execute(mItem);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.servicios_detail, container, false);
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.servicios_detail)).setText(mItem.getMedicalCharacteristics());
        }
        return rootView;
    }
}
