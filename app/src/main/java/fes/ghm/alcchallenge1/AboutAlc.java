package fes.ghm.alcchallenge1;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class AboutAlc extends AppCompatActivity {

    public static final String LINK_TO_LOAD = "https://andela.com/alc/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        WebView webView = findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl(LINK_TO_LOAD);
//        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new MyWebViewClient());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

    }


    /**
     * we create our own WebViewClient so that when we click on a link we don't leave the app
     * and go for the default browser on the device
     */
    private class MyWebViewClient extends WebViewClient {

        /**
         * if we receive an SSL error we tell our webView to proceed rather than showing a blank page
         * @param view
         * @param handler
         * @param error
         */
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }

        /**
         * when we return false the URL passed as parameter to the method is loaded inside the
         * WebView instead of the browser
         * @param webView
         * @param url
         * @return
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, String url) {
            return false;
        }
    }
}
