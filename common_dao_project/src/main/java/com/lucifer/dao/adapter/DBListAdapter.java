package com.lucifer.dao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lucifer.dao.R;
import com.lucifer.dao.model.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucifer on 15/8/3.
 */
public class DBListAdapter extends BaseAdapter {

    private Context context;

    private LayoutInflater layoutInflater;

    private List<UserBean> mUserList = new ArrayList<UserBean>();

    public DBListAdapter(Context context, List<UserBean> userList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.mUserList = userList;
    }

    public void dataNotifyChange(List<UserBean> userList) {
        this.mUserList = userList;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder = null;
        if(null == convertView) {
            convertView = layoutInflater.inflate(R.layout.a_user_item, null);
            mViewHolder = new ViewHolder();
            mViewHolder.tv_name = (TextView)convertView.findViewById(R.id.tvDBName);
            mViewHolder.tv_telNum = (TextView)convertView.findViewById(R.id.tvDBTel);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }

        UserBean mUserBean = mUserList.get(position);

        mViewHolder.tv_name.setText(mUserBean.getUserName());
        mViewHolder.tv_telNum.setText("" + mUserBean.getTelNum());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null == mUserList ? null : mUserList.get(position);
    }

    @Override
    public int getCount() {
        return null == mUserList ? 0 : mUserList.size();
    }

    private class ViewHolder {
        public TextView tv_name;
        public TextView tv_address;
        public TextView tv_telNum;
    }
}
