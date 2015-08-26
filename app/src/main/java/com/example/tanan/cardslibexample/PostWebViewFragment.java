package com.example.tanan.cardslibexample;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
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
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultFontSize(12);


        String title = "<h1>Rise of the Foodpreneur– Sabyasachi Gorai</h1>";
        String pub = "<h3>Wed, 26 Aug 2015 07:45:43 +0000</h3>";
        String author = "Indrojit D. Chaudhuri";

        String html = "<p>The F&amp;B industry in India is facing testing times with the new FSSAI regulations hampering product imports. The global trends tilt towards sourcing local food, sustainability, decreasing carbon footprints and bringing to the fore local/regional cuisine and street food. These very principles are the mainstay of Chef Sabyasachi Gorai’s food philosophy. The ex-Director of Kitchens at Olive Bar &amp; Kitchen, Saby, as he is fondly known in the industry has moved on from his glamorous job to a more gratifying role as the Ring Master at Fabrica by Saby, a boutique restaurant consultancy venture and eventually launched his own restaurant, Lavaash by Saby.</p> <p><img class=\"aligncenter size-full wp-image-161687\" src=\"http://d152j5tfobgaot.cloudfront.net/wp-content/uploads/2015/08/Sabyasachi-Gorai.jpg\" alt=\"Sabyasachi-Gorai\" width=\"800\" height=\"400\" /></p> <h2><strong>The early years </strong></h2> <p>42 year old Saby,  who has a cult following in the culinary world, started his career in hotel management and did some odds and ends  before being enchanted by the kitchen where he saw his creativity take shape. Coming from a middle class Bengali family, Saby, an art graduate, realised soon enough that art is not going to be a sustainable profession for him.</p> <p>Given his background in music and arts, Saby started to use food as a medium of creative expression. After getting a hold of the medium, he treated the plate as a canvas. “I liked playing with textures and colours and would never make a dish look the same next time, so I would request my staff to record or click the plating, for continuity.” Over the years, he has worked across the globe and has cooked for the Bachchans, Ambanis, F1 teams among other known names and has acquired a cult following of his own.</p> <h2><strong>Reluctant steps towards entrepreneurship</strong></h2> <p>With Fabrica by Saby, he started providing consultancy to other restaurants for menu, staffing and sourcing along with setting up a culinary institute for training budding chefs. Besides, Saby has also instituted a scholarship in the name of his mother, to help girls from the weaker sections of society. He says, &#8220;Most girls from underprivileged society already know cooking, so I am only acting as a catalyst to help them earn and establish themselves.&#8221; In fact, he also encourages them to be hired within his network.</p> <p>“And after a lot of deliberation, introspection, resistance, I finally plunged into what I never wanted to do: open a restaurant of my own,” he says. He has launched Lavaash by Saby at Mehrauli, which traces the culinary influence of early Armenian settlers in Asansol (his home town) on the food that we eat today. Quiz him about his entrepreneurial sojourn and Saby says, &#8220;There was this excessive desire to leave behind a legacy, especially for my daughter, and that made me push myself towards entrepreneurship&#8221;.</p> <h2><strong>Tracing a culinary legacy</strong></h2> <p><img class=\"alignright size-full wp-image-161688\" src=\"http://d152j5tfobgaot.cloudfront.net/wp-content/uploads/2015/08/Sabyasachi-Gorai2.jpg\" alt=\"Sabyasachi-Gorai\" width=\"400\" height=\"453\" />Though he had his heart in place about the restaurant, it was increasingly difficult to get information about Armenian food, as there was little to go by way of information, online or otherwise.  He shares, &#8220;Traditional Armenian food is not available anywhere and it took me almost a year to sheaf through my father, Sakti Gorai’s book &#8216;100 years of the Coal mining history&#8217; (which spoke about the Armenian settlers in the coal belt) and my grandmother&#8217;s recipe book from the 1930’s. I also went through newspaper cuttings, met a few Armenian chefs for recipe research and read up blogs. I dug up my past and researched on recipes to bring in my version of the quintessential preparations of Bengali delicacies on the table as well.” His child like enthusiasm is infectious when he shares about rediscovering recipes which had been lost over time. Saby also put his thinking cap when he was recreating those recipes. “I went back in time and thought how I would have cooked these dishes 100 years ago, with the then available utensils and techniques. I have thus applied the same principles and science and the results have been mind-blowing,” he adds.</p> <h2><strong>Food philosophy</strong></h2> <p>“Today’s diners are more aware and want to know about the origin of food on their table and the menus of today are an indication of that. And I did not want to disappoint myself or them. So for my restaurant, I consciously chose to go local by sourcing local ingredients from Kolkata (be it Gondhoraj lemons, local cheese, jaggery or a particular variety of bitter gourd) to using clay cooking pots and utensils,&#8221; he reveals.</p> <p>Coming from a mofussil town, Chef Saby has travelled a long way. With the knowledge that he has gathered over the years, Saby is almost an institution in himself. He has received India’s Best Chef Award from the President of India amongst other numerable recognitions and awards. Each of them are reminiscent of his contribution to the food industry, but his biggest reward comes from cooking for a fellow human being. “The long hours, challenging working conditions, back and knee problems, no weekends, no festive holidays, working while everyone else is enjoying with their families, gets offset by the joy of serving a soul satisfying meal”, says Saby.</p>";
        String htmldata = title+author+"\n"+pub+"\n"+html;

        webView.loadDataWithBaseURL("file:///android_asset/", getHtmlData(htmldata), "text/html", "utf-8", null);
        
        
//        webView.loadData(htmldata, "text/html; charset=UTF-8", null);


//        StringRequest stringRequest = new StringRequest(Request.Method.GET, articleUrl, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                String htmlData = response.toString();
//
//                Readability readability = new Readability(htmlData);
//                readability.init();
//                String cleanHtml = readability.outerHtml();
//
//                webView.loadData(cleanHtml, "text/html", "utf-8");
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error){
//            Toast.makeText(getActivity(), "Fucked", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);

//        webView.loadUrl(articleUrl);
    }

    private String getHtmlData(String htmldata) {
        String head = "<head><style>img{max-width: 100%; width:auto; height: auto;} title{font-weight: bold;font: 25px arial, sans-serif;}</style></head>";
        return "<html>" + head + "<body>" + htmldata + "</body></html>";
    }


}
