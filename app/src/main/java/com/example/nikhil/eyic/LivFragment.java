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
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import ai.liv.s2tlibrary.Speech2TextIntent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;

public class LivFragment extends Fragment {
   // SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
    TextToSpeech tts;
    private static final String TAG = LivFragment.class.getName();
    String url_pump = "http://things.ubidots.com/api/v1.6/variables/5aa8fb38c03f9757378ec63a/values/?token=A1E-Z2m0vH27CzyCsg8UhN9Rih1w94Ezpw";
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
        if(Objects.equals(textViewList[0].getText().toString(), "सेन्सॉर एक चा डेटा दाखवा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_1.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "सेन्सॉर दोन चा डेटा दाखवा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_2.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "सेन्सॉर तीन चा डेटा दाखवा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_3.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "सेन्सॉर चार चा डेटा दाखवा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_4.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "show data of sensor one"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_1.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "show data of sensor two"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_2.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "show data of sensor three"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_3.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "show data of sensor four"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_4.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "સેન્સર એકની માહિતી બતાવો"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_1.class);
            startActivity(intent);
        }
        else if(Objects.equals(textViewList[0].getText().toString(), "સેન્સર બે માહિતી બતાવો"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_2.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "સેન્સર ત્રણ માહિતી બતાવો"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_3.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "સેન્સર ચાર ડેટા બતાવો"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_4.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "సెన్సార్ ఒకటి డేటా చూపించు"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_1.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "సెన్సార్ రెండు డేటా చూపించు"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_2.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "సెన్సార్ మూడు డేటా చూపించు"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_3.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "సెన్సార్ నాలుగు డేటా చూపించు"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_4.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "সেন্সর এক তথ্য দেখান"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_1.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "সেন্সরের দুটি তথ্য দেখান"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_2.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "সেন্সর তিনটি তথ্য দেখান"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_3.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "সেন্সর চার তথ্য দেখান"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_4.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "सेंसर एक का डेटा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_1.class);
            startActivity(intent);
        }
        else if (Objects.equals(textViewList[0].getText().toString(), "सेंसर दो का डेटा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_2.class);
            startActivity(intent);
        }

        else if (Objects.equals(textViewList[0].getText().toString(), "सेंसर तीन का डेटा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_3.class);
            startActivity(intent);
        }

        else if (Objects.equals(textViewList[0].getText().toString(), "सेंसर चार का डेटा"))
        {
            Intent intent = new Intent(getActivity(),sensor_module_4.class);
            startActivity(intent);
        }


        try {
            translate(textViewList[0].getText().toString());
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        // compare(textViewList[0].getText().toString());
    }

    public void translate(String string) throws ExecutionException, InterruptedException {
        String textToBeTranslated=string;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String lang=prefs.getString("pref_language","");
        Log.i("PREFS FROM TRANSLATE",lang);
      //  if (lang.equals("EN"))
       // {
          //  keyword_extraction(textToBeTranslated);
        //}
        //else {
            String languagePair = lang.toLowerCase()+"-en";
            Log.i("languagePair",languagePair);
            TranslatorBackgroundTask translatorBackgroundTask= new TranslatorBackgroundTask(getActivity().getApplicationContext());
            String translationResult =
                    translatorBackgroundTask.execute
                            (textToBeTranslated,languagePair).get(); // Returns the translated text as a String

       // new Handler().postDelayed(new Runnable() {
        //@Override
          //  public void run() {
        //if(translationResult)
                Log.i("Translation Result", String.valueOf(translationResult));

                keyword_extraction(String.valueOf(translationResult));
            //}
        //}, 5000); // Millisecond 1000 = 1 sec


    }


    public void keyword_extraction(String string)
    {
        String[] action_start={"start","loose","resume", "open", "trigger","on","activate","actuate","initiate","put","insert","leave","give","pour","let","allow","fill","begin","continue","unblock","go","move"};

        String[] action_stop={"stop","shut","obstruct","clog","off", "close","deactivate","unactuate","remove","disrupt","forbid","end","block","halt","prevent","pause"};

        String[] action = {"start","resume","loose", "open", "trigger","on","activate","actuate","initiate","put","insert","leave","give","pour","let","allow","fill","begin","continue","unblock","go","move"
        ,"stop","shut","obstruct","off","clog", "close","deactivate","unactuate","remove","disrupt","forbid","end","block","halt","prevent","pause"};
        String a="";

        String[] thing = {"water","pump","motor","tank",
                "pesticide","pesticides","insect","killer","chemical","insecticide","DDT","ddt","fungicide","pest","pests","insect","insects",
                "fogger","mist","fog","mister","haze","smog"};
        String t="";
        String[] thing_pump={"water","pump","motor","tank"};
        String[] thing_pesticide={"pesticide","insect","killer","pesticides","chemical","insecticide","DDT","ddt","fungicide","pest","pests","insect","insects"};
        String[] thing_mist={"fogger","mist","fog","mister","haze","smog"};

        String sentence = string;

        String[] words = sentence.split("\\W+");

        int length=words.length;

        for(int i=0; i<length; i++)  //to iterate words[]
        {
            for(int p=0; p<action.length;p++)  //to iterate action[]
            {
                if(action[p].equals(words[i]))
                {
                    a = action[p];  //action identified

                }
            }
        }
        Log.i("action:",a);

        for(int j=0;j<length;j++)   //to iterate words[]
        {
            for(int q=0; q<thing.length;q++)  //to iterate thing[]
            {
                if(thing[q].equals(words[j]))
                {
                    t = thing[q];  //action identified

                }
            }
        }
        Log.i("thing:",t);

        if (Arrays.asList(action_start).contains(a))   //if command to start, then what to start
        {
            if (Arrays.asList(thing_pump).contains(t))
            {
                //start water pump
                post_0_ubidots_pump();
            }
            else if (Arrays.asList(thing_pesticide).contains(t))
            {
                //start pesticide
                post_0_ubidots_pest();
            }
            else if (Arrays.asList(thing_mist).contains(t))
            {
                //start mist
                post_0_ubidots_mist();
            }
        }

        if (Arrays.asList(action_stop).contains(a))   //if command to stop, then what to stop
        {
            if (Arrays.asList(thing_pump).contains(t))
            {
                //start water pump
                post_1_ubidots_pump();
            }
            else if (Arrays.asList(thing_pesticide).contains(t))
            {
                //start pesticide
                post_1_ubidots_pest();
            }
            else if (Arrays.asList(thing_mist).contains(t))
            {
                //start mist
                post_1_ubidots_mist();
            }
        }
    }

   /** public void compare(String string)
    {
        String test1 = "सेन्सॉर एक चा डेटा दाखवा";
       // String text1_1="सेन्सर एक चा डेटा दाखवा";
        String text2="दूसरे सेंसर की जानकारी प्राप्त कीजिये";
        String pump1="पाणीचा पंप चालू करा"; String pump3="पाहणीचा पंप चालू करा"; String pump1_eng="start the water pump";
        String pump2="पाणीचा पंप बंद करा";  String pump2_eng="stop the water pump";
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
       else if (Objects.equals(string,pump1) || Objects.equals(string,pump1_eng) ||Objects.equals(string,pump3))
        {
            //startPump();
            post_0_ubidots();
            //Toast.makeText(getActivity().getApplicationContext(),"पाणी पंप सुरु झाला", Toast.LENGTH_LONG).show();

        }
        else if (Objects.equals(string,pump2) || Objects.equals(string,pump2_eng))
        {
            //startPump();
            post_1_ubidots();
            //Toast.makeText(getActivity().getApplicationContext(),"पाणी पंप बंद झाला", Toast.LENGTH_LONG).show();

        }
        else
        {
            Log.i("COMPARE OUTPUT","FAIL");
        }
    }  **/

    public void post_0_ubidots_pump()
    {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("value", "0");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url_pump,
                new JSONObject(jsonParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }

        };
        requestQueue.add(postRequest);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String lang=prefs.getString("pref_language","");
        Log.i("PREFS",lang);
        Output_start_pump(lang);
        //mrOutput_start();

    }

    public void post_0_ubidots_pest()
    {   String url_pest = "http://things.ubidots.com/api/v1.6/variables/5aa8fb44c03f9757d5aa295c/values/?token=A1E-Z2m0vH27CzyCsg8UhN9Rih1w94Ezpw";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("value", "0");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url_pest,
                new JSONObject(jsonParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }

        };
        requestQueue.add(postRequest);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String lang=prefs.getString("pref_language","");
        Log.i("PREFS",lang);
        Output_start_pest(lang);
        //mrOutput_start();
    }

    public void post_0_ubidots_mist()
    {
        String url_mist = "http://things.ubidots.com/api/v1.6/variables/5aa8fb4ec03f9757378ec641/values/?token=A1E-Z2m0vH27CzyCsg8UhN9Rih1w94Ezpw";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("value", "0");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url_mist,
                new JSONObject(jsonParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }

        };
        requestQueue.add(postRequest);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String lang=prefs.getString("pref_language","");
        Log.i("PREFS",lang);
        Output_start_mist(lang);
        //mrOutput_start();
    }

    public void post_1_ubidots_pump()
    {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("value", "1");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url_pump,
                new JSONObject(jsonParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }

        };
        requestQueue.add(postRequest);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String lang=prefs.getString("pref_language","");
        Log.i("PREFS",lang);
        Output_stop_pump(lang);
    }

    public void post_1_ubidots_pest()
    {
        String url_pest = "http://things.ubidots.com/api/v1.6/variables/5aa8fb44c03f9757d5aa295c/values/?token=A1E-Z2m0vH27CzyCsg8UhN9Rih1w94Ezpw";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("value", "1");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url_pest,
                new JSONObject(jsonParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }

        };
        requestQueue.add(postRequest);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String lang=prefs.getString("pref_language","");
        Log.i("PREFS",lang);
        Output_stop_pest(lang);
        //mrOutput_start();
    }

    public void post_1_ubidots_mist()
    {
        String url_mist = "http://things.ubidots.com/api/v1.6/variables/5aa8fb4ec03f9757378ec641/values/?token=A1E-Z2m0vH27CzyCsg8UhN9Rih1w94Ezpw";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("value", "1");
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST,url_mist,
                new JSONObject(jsonParams),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                headers.put("User-agent", System.getProperty("http.agent"));
                return headers;
            }

        };
        requestQueue.add(postRequest);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String lang=prefs.getString("pref_language","");
        Log.i("PREFS",lang);
        Output_stop_mist(lang);
        //mrOutput_start();
    }

    public void Output_start_pump(final String lang)
    {
        tts=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int i)
            {
                //tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float) 0.9);
                tts.setPitch((float) 1);
                if (Objects.equals(lang, "EN")) {
                    tts.speak("water pump has been started", TextToSpeech.QUEUE_ADD, null);
                }
                else if(Objects.equals(lang,"MR")){
                    tts.speak("पाणी पंप सुरू करण्यात आले आहे",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"PB"))
                {
                    tts.speak("ਪਾਣੀ ਪੰਪ ਸ਼ੁਰੂ ਹੋ ਗਿਆ ਹੈ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"KA"))
                {
                    tts.speak("ನೀರಿನ ಪಂಪ್ ಅನ್ನು ಪ್ರಾರಂಭಿಸಲಾಗಿದೆ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"BN"))
                {
                    tts.speak("জল পাম্প শুরু করা হয়েছে",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"TE"))
                {
                    tts.speak("నీటి పంపు ప్రారంభించబడింది",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"HI"))
                {
                    tts.speak("पानी पंप शुरू कर दिया गया है",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"GU"))
                {
                    tts.speak("પાણી પંપ શરૂ કરવામાં આવ્યું છે",TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
    }

    public void Output_stop_pump(final String lang)
    {
        tts=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int i)
            {
                //tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float) 0.9);
                tts.setPitch((float) 1);
                if (Objects.equals(lang, "EN")) {
                    tts.speak("water pump has been stopped", TextToSpeech.QUEUE_ADD, null);
                }
                else if(Objects.equals(lang,"MR")){
                    tts.speak("पाणी पंप थांबविले गेले आहे",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"PB"))
                {
                    tts.speak("ਪਾਣੀ ਦਾ ਪੰਪ ਬੰਦ ਕਰ ਦਿੱਤਾ ਗਿਆ ਹੈ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"KA"))
                {
                    tts.speak("ನೀರಿನ ಪಂಪ್ ಅನ್ನು ನಿಲ್ಲಿಸಲಾಗಿದೆ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"BN"))
                {
                    tts.speak("জল পাম্প বন্ধ করা হয়েছে",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"TE"))
                {
                    tts.speak("నీటి పంపు నిలిపివేయబడింది",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"HI"))
                {
                    tts.speak("पानी पंप बंद कर दिया गया है",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"GU"))
                {
                    tts.speak("પાણી પંપ બંધ કરવામાં આવ્યું છે",TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
    }

    public void Output_start_pest(final String lang)
    {
        tts=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int i)
            {
                //tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float) 0.9);
                tts.setPitch((float) 1);
                if (Objects.equals(lang, "EN")) {
                    tts.speak("pesticide unit has been started", TextToSpeech.QUEUE_ADD, null);
                }
                else if(Objects.equals(lang,"MR")){
                    tts.speak("कीटकनाशक युनिट सुरू करण्यात आले आहे",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"PB"))
                {
                    tts.speak("ਕੀਟਨਾਸ਼ਕਾਂ ਦੀ ਇਕਾਈ ਸ਼ੁਰੂ ਕੀਤੀ ਗਈ ਹੈ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"KA"))
                {
                    tts.speak("ಕೀಟನಾಶಕ ಘಟಕವನ್ನು ಪ್ರಾರಂಭಿಸಲಾಗಿದೆ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"BN"))
                {
                    tts.speak("কীটনাশক ইউনিট চালু করা হয়েছে",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"TE"))
                {
                    tts.speak("పురుగుమందుల యూనిట్ ప్రారంభించబడింది",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"HI"))
                {
                    tts.speak("कीटनाशक इकाई शुरू की गई है",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"GU"))
                {
                    tts.speak("જંતુનાશક એકમની શરૂઆત થઈ છે",TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
    }

    public void Output_stop_pest(final String lang)
    {
        tts=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int i)
            {
                //tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float) 0.9);
                tts.setPitch((float) 1);
                if (Objects.equals(lang, "EN")) {
                    tts.speak("pesticide unit has been stopped", TextToSpeech.QUEUE_ADD, null);
                }
                else if(Objects.equals(lang,"MR")){
                    tts.speak("कीटकनाशक युनिट थांबविले गेले आहे",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"PB"))
                {
                    tts.speak("ਕੀਟਨਾਸ਼ਕ ਯੂਨਿਟ ਬੰਦ ਕਰ ਦਿੱਤਾ ਗਿਆ ਹੈ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"KA"))
                {
                    tts.speak("ಕೀಟನಾಶಕ ಘಟಕವನ್ನು ನಿಲ್ಲಿಸಲಾಗಿದೆ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"BN"))
                {
                    tts.speak("কীটনাশক ইউনিট বন্ধ করা হয়েছে",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"TE"))
                {
                    tts.speak("పురుగుమందుల విభాగం నిలిపివేయబడింది",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"HI"))
                {
                    tts.speak("कीटनाशक इकाई बंद कर दिया गया है",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"GU"))
                {
                    tts.speak("જંતુનાશક એકમ બંધ કરવામાં આવ્યું છે",TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
    }

    public void Output_start_mist(final String lang)
    {
        tts=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int i)
            {
                //tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float) 0.9);
                tts.setPitch((float) 1);
                if (Objects.equals(lang, "EN")) {
                    tts.speak("mist sprayer has been started", TextToSpeech.QUEUE_ADD, null);
                }
                else if(Objects.equals(lang,"MR")){
                    tts.speak("धुसर स्प्रेअर सुरु झाला आहे",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"PB"))
                {
                    tts.speak("ਧੁੰਧ ਸਪਰੇਅਰ ਸ਼ੁਰੂ ਹੋ ਗਿਆ ਹੈ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"KA"))
                {
                    tts.speak("ಮಂಜು ಸಿಂಪಡಿಸುವವವನ್ನು ಪ್ರಾರಂಭಿಸಲಾಗಿದೆ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"BN"))
                {
                    tts.speak("কুয়াশা স্প্রেয়ার শুরু হয়েছে",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"TE"))
                {
                    tts.speak("మంచు తుషార యంత్రం ప్రారంభించబడింది",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"HI"))
                {
                    tts.speak("धुंध स्प्रेयर शुरू किया गया है",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"GU"))
                {
                    tts.speak("ઝાકળ સ્પ્રેઝર શરૂ કરવામાં આવ્યું છે",TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
    }

    public void Output_stop_mist(final String lang)
    {
        tts=new TextToSpeech(getActivity().getApplicationContext(), new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int i)
            {
                //tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float) 0.9);
                tts.setPitch((float) 1);
                if (Objects.equals(lang, "EN")) {
                    tts.speak("mist sprayer has been stopped", TextToSpeech.QUEUE_ADD, null);
                }
                else if(Objects.equals(lang,"MR")){
                    tts.speak("धुकेचे स्प्रेअर बंद केले गेले आहे",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"PB"))
                {
                    tts.speak("ਧੁੰਧ ਸਪਰੇਅਰ ਬੰਦ ਕਰ ਦਿੱਤਾ ਗਿਆ ਹੈ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"KA"))
                {
                    tts.speak("ಮಂಜು ಸಿಂಪಡಿಸುವವವನ್ನು ನಿಲ್ಲಿಸಲಾಗಿದೆ",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"BN"))
                {
                    tts.speak("কুয়াশা স্প্রেয়ার বন্ধ করা হয়েছে",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"TE"))
                {
                    tts.speak("మిస్ట్ తుషార యంత్రం నిలిపివేయబడింది",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"HI"))
                {
                    tts.speak("धुंध स्प्रेयर बंद कर दिया गया है",TextToSpeech.QUEUE_ADD,null);
                }
                else if (Objects.equals(lang,"GU"))
                {
                    tts.speak("ઝાકળ સ્પ્રેઝર બંધ કરવામાં આવ્યું છે",TextToSpeech.QUEUE_ADD,null);
                }
            }
        });
    }

}