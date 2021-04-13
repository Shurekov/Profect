package com.zodiac.praktika31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String APP_PREFERENCES = "myPreferences";
    Button save;
    EditText name, surname, birth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.name = findViewById(R.id.name);
        this.birth = findViewById(R.id.birth);
        this.surname = findViewById(R.id.surname);
        this.save = findViewById(R.id.save);
        save.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if ( name.getText().toString().isEmpty()){
            Toast.makeText(this, "Вы не ввели имя", Toast.LENGTH_SHORT).show();
            return;
        }else if(surname.getText().toString().isEmpty()) {
            Toast.makeText(this, "Вы не ввели фамлию", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (birth.getText().toString().isEmpty()){
            Toast.makeText(this, "Вы не ввели дату рождения", Toast.LENGTH_SHORT).show();
            return;
        }
        SharedPreferences preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name.getText().toString());
        editor.putString("surname", surname.getText().toString());
        editor.putString("birth", birth.getText().toString());
        editor.commit();
        if (!preferences.getString("name","").isEmpty() &&
                !preferences.getString("surname","").isEmpty() &&
                !preferences.getString("birth","").isEmpty()){
            Intent i = new Intent(MainActivity.this, TupaActivity.class);
            startActivity(i);

        }

    }
}
