package com.lucifer.ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import com.lucifer.ui.view.BadgeView;

/**
 * Created by lucifer on 16/2/26.
 */
public class BadgeViewActivity extends Activity {

    private BadgeView badgeView = null;

    private TextView tv_point = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_badge_view);

        tv_point = (TextView)findViewById(R.id.tvBadgePoint);
        badgeView = new BadgeView(this);
        badgeView.setTargetView(tv_point);
        badgeView.setBadgeGravity(Gravity.CENTER);
        badgeView.setBackgroundColor(Color.RED);
        badgeView.setBadgeCount(99);
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
