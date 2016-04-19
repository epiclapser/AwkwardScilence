package com.example.epiclapser.awkwardsilence;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
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
Button advanced;
    SharedPreferences sharedpreferences;
    EditText editText;
TextView displayer;
    ArrayList a;
    String selected="";
    String MyPREFERENCES = "MyPrefs";
    Set<String> set1 = new HashSet<String>();;
    String arr[];
    SharedPreferences.Editor editor;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void LoadPreferences()
    {
        sharedpreferences = getPreferences(MODE_PRIVATE);
        set1 = sharedpreferences.getStringSet("key", set1);

        // Strings variable are ready with the values, you can assign them to other component if you want
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_page);
        search =(Button)findViewById(R.id.button);
        displayer =(TextView)findViewById(R.id.textView);
        adder= (Button)findViewById(R.id.button2);
        editText=(EditText)findViewById(R.id.editText);
        advanced= (Button) findViewById(R.id.advanced);
         a= new ArrayList();
        final String aold[]={"Parkour","Running","VideoGames","Skateboarding","Surfing","TV Shows","Boredom","Humanity","Earthquakes","Physics","Nature","Glasses","Mexican Food","Indian Food"};
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        LoadPreferences();
         editor = sharedpreferences.edit();


        for(int i = 0; i< aold.length;i++)
        {a.add(aold[i]);}
        set1.addAll(a);
        editor.putStringSet("key", set1);
        editor.commit();

        search.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
             Random rand = new Random();
                String s ="";
                int random = rand.nextInt(a.size()-1);
                arr=sharedpreferences.getStringSet("key", set1).toArray(new String[a.size()]);
                displayer.setText(""+arr[random]);

                            }
        });

        adder.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                set1.add(editText.getText() + "");

                editor.putStringSet("key", set1);

                editor.commit();
                editText.setText("");
            }
        });

        advanced.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                startActivity(new Intent(MainListPage.this,Enter.class));
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
