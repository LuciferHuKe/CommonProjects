package com.lucifer.dao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lucifer.dao.R;
import com.lucifer.dao.model.MenuItem;

/**
 * Created by lucifer on 15/8/16.
 */
public class LeftMenuAdapter extends ArrayAdapter<MenuItem> {

    private LayoutInflater mLayoutInflater;

    private int mSelected;

    public LeftMenuAdapter(Context context, MenuItem[] objects) {

        super(context, -1, objects);
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null == convertView) {
            convertView = mLayoutInflater.inflate(R.layout.a_slider_menu_left_item, parent, false);
        }

        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvSMITitle);
        tvTitle.setText(getItem(position).text);

        if(position == mSelected) {
            convertView.setBackgroundColor(getContext().getResources()
                    .getColor(R.color.abc_background_cache_hint_selector_material_dark));
        }

        return convertView;
    }

    public void setSelected(int selected) {
        this.mSelected = selected;
        notifyDataSetChanged();
    }


}
