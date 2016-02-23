package com.lucifer.ui.model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lucifer.ui.R;
import com.lucifer.ui.adapter.RcyListAdapter;

/**
 * Created by lucifer on 15/8/31.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    public View itemView;

    public TextView tv_title;

    public MyViewHolder(View view) {
        super(view);

        itemView = view;
        tv_title = (TextView)view.findViewById(R.id.tvRcyTitle);
    }
}
