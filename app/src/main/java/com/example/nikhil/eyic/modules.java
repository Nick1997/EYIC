/*
	*
	* Project Name: 	Crop Management using IoT
	* Author List: 		Nikhil Ahirrao
	* Filename: 		modules.java
	* Functions: 		onCreate(), toSM1,toSM2,toSM3,toSM4,toLiv
	*                   toSM1=='toSensorModule1' it directs to sensor module 1's activity
	*                   toSM2=='toSensorModule2' it directs to sensor module 2's activity
	*                   toSM3=='toSensorModule3' it directs to sensor module 3's activity
	*                   toSM4=='toSensorModule4' it directs to sensor module 4's activity
		* * Global Variables:	prefs
	*
	*/
package com.example.nikhil.eyic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class modules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
    }
    public void toSM1(View view){
        Intent intent = new Intent(this, sensor_module_1.class);
        startActivity(intent);
    }
    public void toSM2(View view){
        Intent intent = new Intent(this, sensor_module_2.class);
        startActivity(intent);

    }
    public void toSM3(View view){
        Intent intent = new Intent(this, sensor_module_3.class);
        startActivity(intent);
       /** android.app.ActionBar ab = getActionBar();
        assert ab != null;
        ab.setTitle("SM3"); */
    }
    public void toSM4(View view){
        Intent intent = new Intent(this, sensor_module_4.class);
        startActivity(intent);
    }
    public void toLiv(View view)
    {
        Intent intent = new Intent(this, LivMainActivity.class);
        startActivity(intent);
    }
}
