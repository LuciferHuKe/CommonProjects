package com.lucifer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucifer.ui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucifer on 16/3/8.
 */
public class WaterFallAdapter extends RecyclerView.Adapter<WaterFallAdapter.WaterFallViewHolder> {

    private Context mContext;
    private List<Integer> mDataList = new ArrayList<Integer>();

    private List<Integer> mHeights = new ArrayList<Integer>();

    public WaterFallAdapter(Context context) {
        this.mContext = context;
    }

    public WaterFallAdapter(Context context, List<Integer> dataList) {
        this.mContext = context;
        this.mDataList = dataList;

        for (int i = 0; i < mDataList.size(); i++) {
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    @Override
    public WaterFallViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.a_water_fall_item, parent, false);
        return new WaterFallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WaterFallViewHolder holder, int position) {

        ViewGroup.LayoutParams lp = holder.ly_back.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.ly_back.setLayoutParams(lp);

        holder.tv_title.setText("标题为：" + mDataList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return null == mDataList ? 0 : mDataList.size();
    }


    public static class WaterFallViewHolder extends RecyclerView.ViewHolder {

        public final TextView tv_title;
        public final ImageView img_icon;
        public final LinearLayout ly_back;

        public WaterFallViewHolder(View view) {
            super(view);
            tv_title = (TextView)view.findViewById(R.id.tvWFTitle);
            img_icon = (ImageView)view.findViewById(R.id.imgWFIcon);
            ly_back = (LinearLayout)view.findViewById(R.id.lyWFBack);
        }

    }
}
