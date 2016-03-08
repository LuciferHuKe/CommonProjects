package com.lucifer.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.lucifer.ui.adapter.WaterFallAdapter;
import com.lucifer.ui.divider.DividerGridItemDecoration;
import com.lucifer.ui.ui.LocalDisplay;
import com.lucifer.ui.view.ptr.PtrDefaultHandler;
import com.lucifer.ui.view.ptr.PtrFrameLayout;
import com.lucifer.ui.view.ptr.PtrHandler;
import com.lucifer.ui.view.ptr.header.StoreHouseHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucifer on 16/3/8.
 */
public class PullListViewActivity extends Activity {

    private PtrFrameLayout ptr_frameLayout;
    private RecyclerView rcy_waterFall;

    private WaterFallAdapter mWaterFallAdapter = null;

    private List<Integer> mDataList = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_pull_listview);

        ptr_frameLayout = (PtrFrameLayout) findViewById(R.id.ptrMainFrameLayout);
        StoreHouseHeader header = new StoreHouseHeader(this);
        header.setPadding(0, LocalDisplay.dp2px(20), 0, LocalDisplay.dp2px(20));
        header.initWithString("Ultra PTR");
        header.setTextColor(Color.BLUE);

        ptr_frameLayout.setDurationToCloseHeader(1500);
        ptr_frameLayout.setHeaderView(header);
        ptr_frameLayout.addPtrUIHandler(header);
        ptr_frameLayout.setPtrHandler(new PtrHandler() {

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptr_frameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptr_frameLayout.refreshComplete();
                    }
                }, 1500);
            }

        });

        for (int i = 0; i < 20; i++) {
            mDataList.add(i);
        }

        rcy_waterFall = (RecyclerView) findViewById(R.id.rcyMainListView);
//        rcy_waterFall.setLayoutManager(new GridLayoutManager(this, 4));
        // StaggeredGridLayoutManager.VERTICAL表示有多少行，HORIZONTAL表示有多少列
        rcy_waterFall.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mWaterFallAdapter = new WaterFallAdapter(this, mDataList);
        rcy_waterFall.setAdapter(mWaterFallAdapter);
        // 设置ITEM间距
        rcy_waterFall.addItemDecoration(new DividerGridItemDecoration(this));
        // 设置item动画
        rcy_waterFall.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
