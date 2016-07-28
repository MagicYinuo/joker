package com.tai.joker.joker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.tai.joker.joker.R;

public class GuideUI extends AppCompatActivity {
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_activity);

        initView();

    }

    private void initView() {
        mImageView = (ImageView) findViewById(R.id.guide_iv);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(GuideUI.this, MainUi.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }

}
