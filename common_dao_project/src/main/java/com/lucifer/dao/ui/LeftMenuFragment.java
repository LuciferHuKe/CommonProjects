package com.lucifer.dao.ui;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lucifer.dao.adapter.LeftMenuAdapter;
import com.lucifer.dao.model.MenuItem;

/**
 * Created by lucifer on 15/8/16.
 */
public class LeftMenuFragment extends ListFragment {

    private static final int SIZE_MENU_ITEM = 3;

    private MenuItem[] mItems = new MenuItem[SIZE_MENU_ITEM];

    private LeftMenuAdapter mMenuAdapter;

    private LayoutInflater mLayoutInflager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLayoutInflager = LayoutInflater.from(getActivity());

        MenuItem menuItem = null;
        for (int i = 0; i < SIZE_MENU_ITEM; i++) {
            menuItem = new MenuItem(false, "MenuItem" + i, 0, 0);
            mItems[i] = menuItem;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(0xffffffff);
        setListAdapter(mMenuAdapter = new LeftMenuAdapter(getActivity(), mItems));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if(null != mMenuItemClickListener) {
            mMenuItemClickListener.onMenuItemClick(
                    ((MenuItem)(getListAdapter().getItem(position))).text);
        }
        mMenuAdapter.setSelected(position);
    }

    //回调接口
    public interface OnMenuItemClickListener {
        public void onMenuItemClick(String title);
    }

    private OnMenuItemClickListener mMenuItemClickListener;

    public void setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        this.mMenuItemClickListener = menuItemClickListener;
    }
}
