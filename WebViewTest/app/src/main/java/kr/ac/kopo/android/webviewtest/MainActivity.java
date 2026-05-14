package kr.ac.kopo.android.webviewtest;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    WebView web1;
    Button btnGo, btnPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        web1 = findViewById(R.id.web1);
        btnGo = findViewById(R.id.btn_go);
        btnPrev = findViewById(R.id.btn_prev);

        web1.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = web1.getSettings();
        webSettings.setJavaScriptEnabled(true);


        btnGo.setOnClickListener(btnListener);
        btnPrev.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_go) {
                String url = edit1.getText().toString();
                if (!url.startsWith("http")) {
                    url = "https://" + url;
                }
                web1.loadUrl(url);
            } else if (v.getId() == R.id.btn_prev) {
                if (web1.canGoBack()) {
                    web1.goBack();
                }
            }
        }
    };

    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return false;
        }
    }
}