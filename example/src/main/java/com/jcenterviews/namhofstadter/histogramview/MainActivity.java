package com.jcenterviews.namhofstadter.histogramview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jcenterviews.namhofstadter.histogramview_master.HistogramView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HistogramView histogramView = (HistogramView) findViewById(R.id.histoGramView);
        histogramView.change_Status(false);
        histogramView.change_Status(true);
    }
}
