package com.lucifer.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lucifer.ui.adapter.RcyListAdapter;
import com.lucifer.ui.ui.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucifer on 15/8/31.
 */
public class RcyListViewActivity extends AppCompatActivity {

    private RecyclerView rcy_listview;

    private List<String> mDates = new ArrayList<String>();

    private RcyListAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_rcy_list_layout);

        initView();
        initData();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            String date = "RecyclerView Item " + i;
            mDates.add(date);
        }
        mAdapter = new RcyListAdapter(this, mDates);
        mAdapter.setOnItemClickListener(new RcyListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(RcyListViewActivity.this, "ItemClick " + position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(View view, int position) {
                //Toast.makeText(RcyListViewActivity.this, "ItemLongClick " + position, Toast.LENGTH_SHORT).show();
            }
        });
        rcy_listview.setAdapter(mAdapter);

        //设置RecyclerView的列表形式
        LinearLayoutManager lyManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcy_listview.setLayoutManager(lyManager);
        //设置item的分割线
        rcy_listview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        rcy_listview.setItemAnimator(new DefaultItemAnimator());

    }

    private void initView() {
        rcy_listview = (RecyclerView)findViewById(R.id.rcyListView);
    }

}
