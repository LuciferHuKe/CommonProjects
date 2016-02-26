package com.lucifer.ui;

import android.app.Activity;
import android.os.Bundle;

import com.lucifer.ui.view.RevealTextView;

/**
 * Created by lucifer on 16/2/26.
 */
public class RevealTextActivity extends Activity {

    private RevealTextView tv_reveal = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_reveal_text);

        tv_reveal = (RevealTextView)findViewById(R.id.tvRevealContent);

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
