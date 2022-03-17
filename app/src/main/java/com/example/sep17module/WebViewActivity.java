package com.example.sep17module;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.sep17module.databinding.ActivityWebView2Binding;

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebView2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWebView2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.webView.loadUrl("https://www.google.com/");

        binding.webView.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        if(binding.webView.canGoBack()){
            binding.webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

    //    class MyWebView extends WebViewClient{
//
//        @Nullable
//        @Override
//        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
//            return super.shouldInterceptRequest(view, request);
//        }
//    }
}