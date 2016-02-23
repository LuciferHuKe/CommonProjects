package com.lucifer.dao;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.lucifer.dao.ui.LeftMenuFragment;
import com.lucifer.dao.ui.SliderMenuLayout;

/**
 *
 * Created by lucifer on 15/8/14.
 *
 * 描述：使用ViewDragHelp实现侧滑栏效果
 *
 */

public class SliderMenuActivity extends ActionBarActivity implements LeftMenuFragment.OnMenuItemClickListener {

    private SliderMenuLayout mSliderMenu;

    private LeftMenuFragment mLeftFragment;

    private TextView tv_content;

    public SliderMenuActivity() {
        super();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_slider_menu_main);

        tv_content = (TextView)findViewById(R.id.tvSMContentTitle);
        mSliderMenu = (SliderMenuLayout)findViewById(R.id.smMain);
        FragmentManager fm = getSupportFragmentManager();
        mLeftFragment = (LeftMenuFragment)fm.findFragmentById(R.id.flSliderMenu);

        if(null == mLeftFragment) {
            fm.beginTransaction().add(R.id.flSliderMenu, mLeftFragment = new LeftMenuFragment()).commit();
        }
        mLeftFragment.setOnMenuItemClickListener(this);

    }

    @Override
    public void onMenuItemClick(String title) {
        mSliderMenu.closeDrawer();
        tv_content.setText(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initView() {

    }

}
