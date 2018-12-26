package test.com.rrefreshlayout.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import test.com.rrefreshlayout.R;
import test.com.rrefreshlayout.util.StatusBarUtil;

public class QQBrowserActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqbrowser);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        //设置下拉刷新功能
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //LoadingLayout封装网络请求的各种效果compile 'com.lai.weavey:loadinglayout:1.3.1'
//        final LoadingLayout loading = findViewById(R.id.loading);
        //
        final WebView webView = findViewById(R.id.webView);
        //通过loadUrl方法设置当前webView须要訪问的网址：
        webView.loadUrl("https://github.com/scwang90/SmartRefreshLayout");
        //在android中专门通过WebSettings来设置WebView的一些属性、状态等。在创建WebView时，系统有一个默认的设置，我们能够通过WebView.getSettings来得到这个设置
        // setJavaScriptEnabledWebView是否允许执行JavaScript脚本，默认false，不允许。
        webView.getSettings().setJavaScriptEnabled(true);
        //WebViewClient是辅助WebView处理各种通知、请求等事件的类。
        webView.setWebViewClient(new WebViewClient (){
            @Override
            @SuppressWarnings("deprecation")
            // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转。不跳到浏览器那边
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            @Override
            //页面加载完成
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //显示加载的页面
//                loading.showContent();

            }
        });

        //状态栏透明和间距处理
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
    }

}

