package com.tai.joker.joker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tai.joker.joker.R;

/**
 * Created by Administrator on 2016/7/28.
 */
public class NewsItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        Intent intent = new Intent();
        String value = intent.getStringExtra("key");
        TextView tv = (TextView) findViewById(R.id.new_item_tv);
        tv.setText(value);
    }
}
