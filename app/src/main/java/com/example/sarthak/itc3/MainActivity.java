package com.example.sarthak.itc3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*getActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mWebView=(WebView) findViewById(R.id.activity_main_webview);
        WebSettings webSettings=mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://betaitcorner.000webhostapp.com/proj3/web/index.php");*/
    }
    public void sbuttonClickFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(), SloginActivity.class);
        startActivity(intent);
    }
}
