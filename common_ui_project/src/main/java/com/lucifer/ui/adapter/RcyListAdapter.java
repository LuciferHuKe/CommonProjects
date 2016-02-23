package com.lucifer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lucifer.ui.R;
import com.lucifer.ui.model.MyViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class RcyListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;

    private LayoutInflater mLayoutInflater;

    private List<String> mDates = new ArrayList<String>();

    public interface  OnItemClickListener {
        public void onItemClick(View view, int position);
        public void onItemLongClick(View view, int position);
    }

    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RcyListAdapter(Context context, List<String> dates) {
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        this.mDates = dates;
    }

    @Override
    public int getItemCount() {
        return mDates.size();
    }


    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int i) {
        viewHolder.tv_title.setText(mDates.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDates.add("Add Item " + i);
                notifyItemInserted(i);
                if (null != onItemClickListener) {
                    onItemClickListener.onItemClick(viewHolder.itemView, i);
                }
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mDates.remove(i);
                notifyItemRemoved(i);
                if(null != onItemClickListener) {
                    onItemClickListener.onItemLongClick(viewHolder.itemView, i);
                }
                return false;
            }
        });
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = mLayoutInflater.inflate(R.layout.a_rcy_list_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

}
