package com.plaurion.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.EditText;

import com.plaurion.taskmaster.R;

public class SettingsActivity extends AppCompatActivity {
    protected static SharedPreferences sharedPreferences;
    protected static SharedPreferences.Editor sharedPreferencesEditor;
    public final static String USER_NAME_KEY = "userName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferencesEditor = sharedPreferences.edit();

        EditText userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        String userName = sharedPreferences.getString(USER_NAME_KEY, "");
        userNameEditText.setText(userName);

        Button saveUserButton = (Button) findViewById(R.id.saveUserButton);
        saveUserButton.setOnClickListener(view ->
                {
                    String userName2 = userNameEditText.getText().toString();
                    sharedPreferencesEditor.putString(USER_NAME_KEY, userName2);
                    sharedPreferencesEditor.apply();
                    Intent saveUserIntent = new Intent(SettingsActivity.this, MainActivity.class);
                    startActivity(saveUserIntent);
                }
        );
    }
}