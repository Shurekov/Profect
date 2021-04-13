package com.zodiac.praktika31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class TupaActivity extends AppCompatActivity {


    TextView infa1,infa2,infa3;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tupa);
        this.infa1 = findViewById(R.id.text1);
        this.infa2 = findViewById(R.id.text2);
        this.infa3 = findViewById(R.id.text3);

        SharedPreferences preferences = getSharedPreferences(MainActivity.APP_PREFERENCES, Context.MODE_PRIVATE);
        infa1.setText(preferences.getString("name",""));
        infa2.setText(preferences.getString("surname",""));
        infa3.setText(preferences.getString("birth",""));
    }
}
