package com.tai.joker.joker.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.tai.joker.joker.R;

/**
 * Created by Administrator on 2016/7/28.
 */
public class NewsItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        Intent intent = this.getIntent();
        String value = intent.getStringExtra("key");
        WebView webView = (WebView) findViewById(R.id.news_wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(value);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
