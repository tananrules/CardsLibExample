package com.example.tanan.cardslibexample;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewFragment;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.tanan.cardslibexample.helper.Readability;

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
        final WebView webView = getWebView();
        webView.getSettings().setJavaScriptEnabled(true);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, articleUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String htmlData = response.toString();

                Readability readability = new Readability(htmlData);
                readability.init();
                String cleanHtml = readability.outerHtml();

                webView.loadData(cleanHtml, "text/html", "utf-8");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
            Toast.makeText(getActivity(), "Fucked", Toast.LENGTH_LONG).show();
            }
        });

        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);

//        webView.loadUrl(articleUrl);
    }



}
