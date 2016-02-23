package com.lucifer.dao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Button;

import com.lucifer.dao.adapter.DBListAdapter;
import com.lucifer.dao.model.UserBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener{

    private Button btn_input;
    private Button btn_update;

    private ListView lv_db;

    private DBListAdapter mDBAdapter = null;

    private List<UserBean> mUserList = new ArrayList<UserBean>();

    private DiskLruCache mDiskCache = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDBInput:
                break;
            case R.id.btnDBUpdate:
                break;
            default:
                break;
        }
    }

    // ------------------------- private method ------------------

    private void initView() {
        btn_input = (Button)findViewById(R.id.btnDBInput);
        btn_update = (Button)findViewById(R.id.btnDBUpdate);
        lv_db = (ListView)findViewById(R.id.lvDB);
    }

    private void initData() {
        mDBAdapter = new DBListAdapter(this, mUserList);
        lv_db.setAdapter(mDBAdapter);
        lv_db.setOnItemClickListener(this);
        btn_input.setOnClickListener(this);
        btn_update.setOnClickListener(this);
    }
}
