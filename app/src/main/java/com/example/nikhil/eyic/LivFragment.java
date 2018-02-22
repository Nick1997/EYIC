/*
	*
	* Project Name: 	Crop Management using IoT
	* Author List: 		Nikhil Ahirrao
	* Filename: 		LivFragment.java
	* Functions: 		onCreate(), toLiv(), toAvg(), toModules()
	* Global Variables:	TAG,b1,contentView1, contentView2, contentView3, contentView4,textViewList
	*
	*/
package com.example.nikhil.eyic;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Objects;

import ai.liv.s2tlibrary.Speech2TextIntent;
public class LivFragment extends Fragment {
    private static final String TAG = LivFragment.class.getName();

    ImageButton b1;

    TextView contentView1, contentView2, contentView3, contentView4;
    TextView[] textViewList = new TextView[4];
    public LivFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liv,
                container, false);
        contentView1 =  view.findViewById(R.id.contentTextView1);
        contentView2 =  view.findViewById(R.id.contentTextView2);
        contentView3 =  view.findViewById(R.id.contentTextView3);
        contentView4 =  view.findViewById(R.id.contentTextView4);
        textViewList[0] = contentView1;
        textViewList[1] = contentView2;
        textViewList[2] = contentView3;
        textViewList[3] = contentView4;

        b1 =  view.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), Speech2TextIntent.class);
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                i.putExtra(Speech2TextIntent.LANGUAGE, prefs.getString("pref_language", Speech2TextIntent.LANGUAGE_ENGLISH));
                //i.putExtra(Speech2TextIntent.INTENT, Speech2TextIntent.INTENT_ENABLE);
                Log.i("onServiceConnected","startActivity");
                startActivityForResult(i, 1);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if (requestCode == 1)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                String[] results = data.getStringArrayExtra("resultList");
                for (int i=0; i<results.length; i++)
                {
                    textViewList[i].setText("");
                    textViewList[i].setText(results[i]);
                    if (i == 3)
                    {
                        break;
                    }
                }
            }
        }
        Log.i("LIV OUTPUT", textViewList[0].getText().toString());
        compare(textViewList[0].getText().toString());
    }

    public void compare(String string)
    {
        String test1 = "सेन्सॉर एक चा डेटा दाखवा";
       // String text1_1="सेन्सर एक चा डेटा दाखवा";
        String text2="दूसरे सेंसर की जानकारी प्राप्त कीजिये";
        String pump1="पाणी चा पंप चालू करा";
        String pump2="पाणी चा पंप बंद करा";
        if (Objects.equals(string, test1) )
        {
            Log.i("COMPARE OUTPUT ", "SUCCESS");
            Intent intent;
            intent = new Intent(getActivity(), sensor_module_1.class);
            startActivity(intent);

        }
        else if (Objects.equals(string,text2))
        {
            Log.i("COMPARE OUTPUT ", "SUCCESS");
            Intent intent;
            intent = new Intent(getActivity(), sensor_module_2.class);
            startActivity(intent);
        }
       else if (Objects.equals(string,pump1))
        {
            //startPump();
            //send_0_ubidots();
            Toast.makeText(getActivity().getApplicationContext(),"पाणी पंप सुरु झाला", Toast.LENGTH_LONG).show();
        }
        else if (Objects.equals(string,pump2))
        {
            //startPump();
            Toast.makeText(getActivity().getApplicationContext(),"पाणी पंप बंद झाला", Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.i("COMPARE OUTPUT","FAIL");
        }
    }

}