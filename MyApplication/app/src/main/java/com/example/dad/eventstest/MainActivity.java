package com.example.dad.eventstest;

import android.graphics.Color;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.textView);
        eText = (EditText)findViewById(R.id.editText);
        this.arraySpinner = new String[]{"Default string","Default string"
                ,"Default string","Default string"};
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new myListener());

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
    public class myListener implements AdapterView.OnItemSelectedListener
    {
        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id)
        {
            if(pos == 0)
            {
                text.setText(arraySpinner[0]);
                MainActivity.text.setTextColor(Color.BLACK);
            }
            else if(pos == 1)
            {
                text.setText(arraySpinner[1]);
                MainActivity.text.setTextColor(Color.RED);
            }
            else if(pos == 2)
            {
                text.setText(arraySpinner[2]);
                MainActivity.text.setTextColor(Color.BLUE);
            }
            else if(pos == 3)
            {
                text.setText(arraySpinner[3]);
                MainActivity.text.setTextColor(Color.CYAN);
            }
        }
        public void onNothingSelected(AdapterView parent)
        {}
    }

}
