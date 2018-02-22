/*
	*
	* Project Name: 	Crop Management using IoT
	* Author List: 		Nikhil Ahirrao
	* Filename: 		LivMainActivity.java
	* Functions: 		onCreate(), onCreateOptionsMenu,onOptionsItemSelected(),
	* Global Variables:	prefs
	*
	*/
package com.example.nikhil.eyic;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import ai.liv.s2tlibrary.Speech2TextIntent;
public class LivMainActivity extends AppCompatActivity {

    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(R.layout.activity_liv_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_lang);
        CharSequence lang = prefs.getString("pref_language", Speech2TextIntent.LANGUAGE_ENGLISH);
        Log.v("Language already set: " , lang.toString());
        item.setTitle(lang);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            Intent intent = new Intent(this, PreferenceActivity.class);
//            startActivity(intent);
            return true;
        } else if (id == R.id.action_lang) {
            CharSequence title = item.getTitle();
            if (title.equals(Speech2TextIntent.LANGUAGE_ENGLISH)) {
                item.setTitle(Speech2TextIntent.LANGUAGE_PUNJABI);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_PUNJABI);
                editor.apply();
            }
            else if(title.equals(Speech2TextIntent.LANGUAGE_PUNJABI)){
                item.setTitle(Speech2TextIntent.LANGUAGE_KANNADA);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_KANNADA);
                editor.apply();
            }
            else if(title.equals(Speech2TextIntent.LANGUAGE_KANNADA)){
                item.setTitle(Speech2TextIntent.LANGUAGE_BENGALI);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_BENGALI);
                editor.apply();
            }
            else if(title.equals(Speech2TextIntent.LANGUAGE_BENGALI)){
                item.setTitle(Speech2TextIntent.LANGUAGE_TELUGU);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_TELUGU);
                editor.apply();
            }
            else if(title.equals(Speech2TextIntent.LANGUAGE_TELUGU)){
                item.setTitle(Speech2TextIntent.LANGUAGE_HINDI);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_HINDI);
                editor.apply();
            }
            else if(title.equals(Speech2TextIntent.LANGUAGE_HINDI)){
                item.setTitle(Speech2TextIntent.LANGUAGE_MARATHI);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_MARATHI);
                editor.apply();
                return true;
            }
            else if (title.equals(Speech2TextIntent.LANGUAGE_MARATHI)) {
                item.setTitle(Speech2TextIntent.LANGUAGE_GUJARATI);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_GUJARATI);
                editor.apply();
                return true;
            }
            else if (title.equals(Speech2TextIntent.LANGUAGE_GUJARATI)) {
                item.setTitle(Speech2TextIntent.LANGUAGE_ENGLISH);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("pref_language", Speech2TextIntent.LANGUAGE_ENGLISH);
                editor.apply();
            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
