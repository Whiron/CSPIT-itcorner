package com.example.sarthak.itc3;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.json.JSONObject;

public class SloginActivity extends AppCompatActivity {

    private EditText usernameField, passwordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slogin);
        usernameField = (EditText) findViewById(R.id.editText);
        passwordField = (EditText) findViewById(R.id.editText2);
    }
    public void swelcClickFunction(View v) {
        Intent intent = new Intent(getApplicationContext(), Swelcome.class);
        startActivity(intent);
    }

    public void loginPost(View view) {
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,type, username, password);
        //new Swelcome(this).execute(username,password);
    }

    public void sqlconn(View view) {
        //startActivity(new Intent(this,Register.class))
        /*JSONObject jsonobject;
        jsonobject = JSONfunctions.getJSONfromURL("http://YOUR_DATABASE_URL");*/
    }
}
