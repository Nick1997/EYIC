/*
	*
	* Project Name: 	Crop Management using IoT
	* Author List: 		Nikhil Ahirrao
	* Filename: 		sensor_module_1.java
	* Functions: 		onCreate(), toSM1_graph, toLiv()
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

public class sensor_module_1 extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_module_1);

        WebView gauge_t = findViewById(R.id.gauge_t);
        gauge_t.getSettings().setJavaScriptEnabled(true);
        String html = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/5lgFjeUvhenHj50JE88X1c5z1gE\"></iframe>";
        gauge_t.loadData(html, "text/html", null);
        gauge_t.getSettings().setLoadWithOverviewMode(true);
        gauge_t.getSettings().setUseWideViewPort(true);

        WebView gauge_h = findViewById(R.id.gauge_h);
        gauge_h.getSettings().setJavaScriptEnabled(true);
        String html2 = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/HSq4SeFBf4ksFzz7slyLwR2C-pM\"></iframe>";
        gauge_h.loadData(html2, "text/html", null);
        gauge_h.getSettings().setLoadWithOverviewMode(true);
        gauge_h.getSettings().setUseWideViewPort(true);

        WebView gauge_s = findViewById(R.id.gauge_s);
        gauge_s.getSettings().setJavaScriptEnabled(true);
        String html3 = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/xkJLYmcARCHDxzA6qmjAzvaujLE\"></iframe>";
        gauge_s.loadData(html3, "text/html", null);
        gauge_s.getSettings().setLoadWithOverviewMode(true);
        gauge_s.getSettings().setUseWideViewPort(true);

        WebView gauge_l = findViewById(R.id.gauge_l);
        gauge_l.getSettings().setJavaScriptEnabled(true);
        String html4 = "<iframe width=\"900\" height=\"500\" frameborder=\"0\" src=\"https://app.ubidots.com/ubi/getchart/_RsDec9EXnfyHUos8Hlz0EKDLhw\"></iframe>";
        gauge_l.loadData(html4, "text/html", null);
        gauge_l.getSettings().setLoadWithOverviewMode(true);
        gauge_l.getSettings().setUseWideViewPort(true);


    }
    public void toLiv(View view)
    {
        Intent intent = new Intent(this, LivMainActivity.class);
        startActivity(intent);
    }
    public void toSM1_graph(View view)
    {
        Intent intent = new Intent(this, sensor_module_1_graph.class);
        startActivity(intent);
    }
}
