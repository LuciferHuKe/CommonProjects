package com.lucifer.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_image = null;
    private Button btn_badge = null;
    private Button btn_reveal = null;
    private Button btn_loading = null;
    private Button btn_edittext = null;
    private Button btn_percent = null;
    private Button btn_pullRefresh = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_image = (Button)findViewById(R.id.btnMainImage);
        btn_badge = (Button)findViewById(R.id.btnMainBadge);
        btn_reveal = (Button)findViewById(R.id.btnMainReveal);
        btn_loading = (Button)findViewById(R.id.btnMainLoading);
        btn_edittext = (Button)findViewById(R.id.btnMainEdit);
        btn_percent = (Button)findViewById(R.id.btnMainPercent);
        btn_pullRefresh = (Button)findViewById(R.id.btnMainPull);

        btn_image.setOnClickListener(this);
        btn_badge.setOnClickListener(this);
        btn_reveal.setOnClickListener(this);
        btn_loading.setOnClickListener(this);
        btn_edittext.setOnClickListener(this);
        btn_percent.setOnClickListener(this);
        btn_pullRefresh.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_listview:
                break;
            case R.id.action_gridview:
                break;
            case R.id.action_hor_listview:
                break;
        }
        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMainImage: {
                Intent intent = new Intent(MainActivity.this, ImageInfoActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.btnMainBadge: {
                Intent intent = new Intent(MainActivity.this, BadgeViewActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.btnMainReveal: {
                Intent intent = new Intent(MainActivity.this, RevealTextActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.btnMainLoading: {
                Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.btnMainEdit: {
                Intent intent = new Intent(MainActivity.this, ScrollViewActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.btnMainPercent: {
                Intent intent = new Intent(MainActivity.this, PercentLayoutActivity.class);
                startActivity(intent);
            }
                break;
            case R.id.btnMainPull: {
                Intent intent = new Intent(MainActivity.this, PullListViewActivity.class);
                startActivity(intent);
            }
                break;
        }
    }
}
