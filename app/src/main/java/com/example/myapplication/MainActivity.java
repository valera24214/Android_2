package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.text.method.LinkMovementMethod;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private GridView gridView;
private Button b1;
private RadioGroup group;
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.GridView);
        ViewCompat.setNestedScrollingEnabled(gridView, true);
        gridView.isNestedScrollingEnabled();
        b1 = (Button) findViewById(R.id.count_button);
        group = (RadioGroup) findViewById(R.id.radioGroup);
        b1.setOnClickListener(onClickListener);
        textView = findViewById(R.id.textView);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        gridView.setNumColumns(2);
    }

    private double f(double x, String str)
    {

        if(str == ((TextView)findViewById(R.id.textView3)).getText())
            return (x*x+2*x-5);
        else if (str == ((TextView)findViewById(R.id.textView4)).getText())
            return Math.sin(x);
        else
            return 0;
    }

    View.OnClickListener onClickListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            String str;
          switch (group.getCheckedRadioButtonId())
          {
              case (R.id.radioButton8):
                      {
                          str = ((TextView)findViewById(R.id.textView3)).getText().toString();
                          break;
                      }
              case (R.id.radioButton7):
                      {
                          str = ((TextView)findViewById(R.id.textView4)).getText().toString();
                          break;
                      }
              default:
                      {
                          str = new String();
                          Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                          break;
                      }
          }

          try
          {
              ArrayList<String> values = new ArrayList<String>();
            double x = Double.valueOf(((EditText)findViewById(R.id.editText1)).getText().toString());
            double x_MAX = Double.valueOf(((EditText)findViewById(R.id.editText2)).getText().toString());
            double h = Double.valueOf(((EditText)findViewById(R.id.editText3)).getText().toString());;
            for (double i = x; i <= x_MAX ; i+=h)
            {
                values.add("x = " + String.valueOf(i));
                values.add("y = " + String.valueOf(f(i, str)));
            }
              ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, values.toArray());
            gridView.setAdapter(adapter);

          }
          catch(Exception e)
          {
              Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
          }

        }

   };



}