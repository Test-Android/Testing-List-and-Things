package com.example.dad.eventstest;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{
    public static TextView text;
    public static EditText eText;
    public static String[] arraySpinner;
    public static String[] colors;
    public static String[] fonts;
    public static Spinner s;
    public static Spinner s2;
    public static Spinner s3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);
        eText = (EditText)findViewById(R.id.editText);
        this.arraySpinner = new String[]{"Default string","Default string"
                ,"Default string","Default string"};
        this.colors = new String[]{"Black","Red","Blue","Cyan"};
        this.fonts = new String[]{"Default", "Monospace", "Sans Serif","Sans"};

        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);

        s2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> a2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, colors);
        s2.setAdapter(a2);
        s2.setOnItemSelectedListener(new cListen());

        s3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> a3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, fonts);
        s3.setAdapter(a3);
        s3.setOnItemSelectedListener(new fListen());

    }
    public static void cText(View view)
    {
        String lastString = "";
        String[] curString = new String[3];

        for(int k = 0; k < 3; k++)
            curString[k] = arraySpinner[k];

        arraySpinner[0] = (eText.getText()).toString();
        arraySpinner[1] = curString[0];
        arraySpinner[2] = curString[1];
        arraySpinner[3] = curString[2];

        text.setText(eText.getText());
        eText.setText("");
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_ENTER)
        {
            String lastString = "";
            String[] curString = new String[3];

            for(int k = 0; k < 3; k++)
                curString[k] = arraySpinner[k];

            arraySpinner[0] = (eText.getText()).toString();
            arraySpinner[1] = curString[0];
            arraySpinner[2] = curString[1];
            arraySpinner[3] = curString[2];

            text.setText(eText.getText());
            eText.setText("");
        }
        return true;
    }
    public class cListen implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id)
        {
            if(pos == 0)
            {
                MainActivity.text.setTextColor(Color.BLACK);
            }
            else if(pos == 1)
            {
                MainActivity.text.setTextColor(Color.RED);
            }
            else if(pos == 2)
            {
                MainActivity.text.setTextColor(Color.BLUE);
            }
            else if(pos == 3)
            {
                MainActivity.text.setTextColor(Color.CYAN);
            }
        }
        public void onNothingSelected(AdapterView parent) {}
    }
    public class fListen implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id)
        {
            if(pos == 0)
            {
                MainActivity.text.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            }
            else if(pos == 1)
            {
                MainActivity.text.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
            }
            else if(pos == 2)
            {
                MainActivity.text.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            }
            else if(pos == 3)
            {
                MainActivity.text.setTypeface(Typeface.SERIF, Typeface.BOLD);
            }
        }
        public void onNothingSelected(AdapterView parent) {}
    }

}
