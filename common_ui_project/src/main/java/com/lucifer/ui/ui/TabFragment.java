package com.lucifer.ui.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lucifer.ui.R;

/**
 * Created by lucifer on 15/8/18.
 */
public class TabFragment extends Fragment {

    public static final String TITLE = "TITLE";

    private String mTitle = "DEFAULT_TITLE";

    private TextView tv_title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            mTitle = getArguments().getString(TITLE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.a_tab_fragment, container, false);
        tv_title = (TextView)view.findViewById(R.id.tvTFInfo);
        tv_title.setText(mTitle);
        return view;
    }

    public static TabFragment newInstance(String title) {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }
}
