package com.example.david.thu1febpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String MyPREFERENCES = "MyPREFERENCES";
    final String NAME_KEY = "namekey";
    EditText edit;
    TextView text;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit = findViewById(R.id.edit);
        text = findViewById(R.id.text);

        sharedPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String savedName = sharedPref.getString(NAME_KEY, null);

        if (savedName != null) {
            text.setText(savedName);
        }



    }


    public void save(View view) {
        String s = edit.getText().toString();
        text.setText(s);

        SharedPreferences.Editor edit = sharedPref.edit();

        edit.putString(NAME_KEY, s);
        edit.commit();

    }


}
