package com.example.heber.w2d2_ex02;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyAppSettings";
    private EditText Name;
    private EditText LastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name = (EditText) findViewById(R.id.et_Name);
        LastName = (EditText) findViewById(R.id.et_Lastname);
    }

    public void Save(View view) {

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        //Writing to SP
        editor.putString("Name", Name.getText().toString());
        editor.putString("LastName", LastName.getText().toString());
        editor.commit();

        Name.setText("");
        LastName.setText("");
    }

    public void ReadName(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String value = settings.getString("Name", "No name has been saved");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    public void ReadLastname(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String value = settings.getString("LastName", "No Lastname has been saved");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    public void Update(View view) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Name.setText(settings.getString("Name", "Empty"));
        LastName.setText(settings.getString("LastName", "Empty"));
    }
}
