package com.example.tanan.cardslibexample;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

/**
 * Created by tanan on 5/8/15.
 */
public class PostWebViewFragment extends WebViewFragment {

    String articleUrl = "";

    public static PostWebViewFragment newInstance(String url) {
        PostWebViewFragment postWebViewFragment = new PostWebViewFragment();
        Bundle args = new Bundle();
        args.putString("article_url", url);
        postWebViewFragment.setArguments(args);
        return postWebViewFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleUrl = getArguments().getString("article_url");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WebView webView = getWebView();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(articleUrl);
    }
}
