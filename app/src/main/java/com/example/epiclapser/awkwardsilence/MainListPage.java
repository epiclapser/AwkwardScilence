package com.example.epiclapser.awkwardsilence;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainListPage extends ActionBarActivity {
Button search;
Button adder;
    EditText editText;
TextView displayer;
    ArrayList a;
    String selected="";
    String MyPREFERENCES = "MyPrefs";
    Set<String> set1;
    String arr[];
    SharedPreferences.Editor editor;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_page);
        search =(Button)findViewById(R.id.button);
        displayer =(TextView)findViewById(R.id.textView);
        adder= (Button)findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.editText);
         a= new ArrayList();
        final String aold[]={"Parkour","Running","VideoGames","Skateboarding","Surfing","TV Shows","Boredom","Humanity","Earthquakes","Physics","Nature","Glasses","Mexican Food","Indian Food"};
        SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
         editor = sharedpreferences.edit();
         set1 = new HashSet<String>();
        for(int i = 0; i< aold.length;i++)
        {a.add(aold[i]);}
        set1.addAll(a);
        editor.putStringSet("key", set1);
        editor.commit();

        search.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
             Random rand = new Random();
                int random = rand.nextInt(a.size()-1);
                arr=set1.toArray(new String[set1.size()]);
                displayer.setText(""+arr[random]);
                            }
        });

        adder.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                a.add(editText.getText());
                set1.addAll(a);

                editor.putStringSet("key", set1);
                editor.commit();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_list_page, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
