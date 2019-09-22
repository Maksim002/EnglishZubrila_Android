package mainactivity.musicplayer.example.com.englishzubrila.InitilCourses;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import mainactivity.musicplayer.example.com.englishzubrila.InitilCourses.ContenetListViewPager.Model;
import mainactivity.musicplayer.example.com.englishzubrila.R;

public class WebViewB extends AppCompatActivity {

    private WebView webview;
    private ProgressBar progressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_b);

        webview = findViewById(R.id.webBra);
        progressbar = findViewById(R.id.progressbar);

        webview.getSettings().setJavaScriptEnabled(true);

        Intent intent = getIntent();
        Model property = intent.getParcelableExtra("Web");
        String streetName = property.getUrl();

        String address = streetName;

        webview.loadUrl(address);

        webview.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                progressbar.setVisibility(View.GONE);
            }
        });

    }
}
