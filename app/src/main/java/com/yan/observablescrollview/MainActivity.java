package com.yan.observablescrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity implements ObservableScrollView.OnScrollListener{

    private View view;
    private View hess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ObservableScrollView observableScrollView = (ObservableScrollView) findViewById(R.id.scrollView);
        view = findViewById(R.id.header);
        hess = findViewById(R.id.headersss);

        assert observableScrollView != null;
        observableScrollView.setOnScrollListener(this);
        observableScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                onScroll(observableScrollView.getScrollY());
            }
        });
    }

    @Override
    public void onScroll(int scrollY) {
        int mBuyLayout2ParentTop = Math.max(scrollY, hess.getTop());
        view.setTranslationY(mBuyLayout2ParentTop);
    }
}
