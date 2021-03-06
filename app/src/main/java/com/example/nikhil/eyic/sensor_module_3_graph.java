/*
	*
	* Project Name: 	Crop Management using IoT
	* Author List: 		Nikhil Ahirrao
	* Filename: 		sensor_module_3.java
	* Functions: 		onCreate(), toLiv()
	* Global Variables:
	*
	*/
package com.example.nikhil.eyic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class sensor_module_3_graph extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_module_3_graph);

        WebView graph_t = findViewById(R.id.graph_t);
        graph_t.getSettings().setJavaScriptEnabled(true);
        //gauge_webview.loadUrl("file:///android_asset/gauge.html");
        String html = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/VoKTGuos0fFsjxxLBKRRDbPCaFk\"></iframe>";
        graph_t.loadData(html, "text/html", null);
        graph_t.getSettings().setLoadWithOverviewMode(true);
        graph_t.getSettings().setUseWideViewPort(true);

        WebView graph_h = findViewById(R.id.graph_h);
        graph_h .getSettings().setJavaScriptEnabled(true);
        String html2 = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/NFBSrX_OXEyr0OMwdh4cg2Q5KY4\"></iframe>";
        graph_h .loadData(html2, "text/html", null);
        graph_h .getSettings().setLoadWithOverviewMode(true);
        graph_h .getSettings().setUseWideViewPort(true);

        WebView graph_s = findViewById(R.id.graph_s);
        graph_s.getSettings().setJavaScriptEnabled(true);
        String html3 = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/VBYOD7rq9XONtxu53lifCkyoxUQ\"></iframe>";
        graph_s.loadData(html3, "text/html", null);
        graph_s.getSettings().setLoadWithOverviewMode(true);
        graph_s.getSettings().setUseWideViewPort(true);

        WebView graph_l = findViewById(R.id.graph_l);
        graph_l.getSettings().setJavaScriptEnabled(true);
        String html4 = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/6jt6vFXMp_1sYK5zN279KVrV7dc\"></iframe>";
        graph_l.loadData(html4, "text/html", null);
        graph_l.getSettings().setLoadWithOverviewMode(true);
        graph_l.getSettings().setUseWideViewPort(true);


    }
    public void toLiv(View view)
    {
        Intent intent = new Intent(this, LivMainActivity.class);
        startActivity(intent);
    }
    }

