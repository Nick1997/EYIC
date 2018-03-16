/*
	*
	* Project Name: 	Crop Management using IoT
	* Author List: 		Nikhil Ahirrao
	* Filename: 		MainActivity.java
	* Functions: 		onCreate(), toLiv(), toAvg(), toModules()
	*
	*
	*/

package com.example.nikhil.eyic;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ImageButton b_speech = findViewById(R.id.b_speech);
    }
    public void toLiv(View view)
    {
        Intent intent = new Intent(this, LivMainActivity.class);
        startActivity(intent);
    }
    public void toAvg(View view)
    {
        Intent intent = new Intent(this, overview_gauge.class);
        startActivity(intent);
    }

   public void toModules(View view)
   {    Intent intent = new Intent(this, modules.class);
       startActivity(intent);
   }


}
