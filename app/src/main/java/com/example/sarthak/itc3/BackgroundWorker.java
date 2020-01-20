package com.example.sarthak.itc3;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Sarthak on 10-09-2017.
 */



public class BackgroundWorker extends AsyncTask<String, Void, String>{
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx) {
        context=ctx;
    }
    String result="hello";
    @Override
    protected String doInBackground(String... params)
    {
        String type=params[0];
        String user_name=params[1];
        String password=params[2];
        //Toast.makeText(context, "DO IN", Toast.LENGTH_SHORT).show();
        String login_url="http://192.168.12.140/login.php";
        if(type.equals("login")){
            try {
                //Toast.makeText(context, "LOGIN", Toast.LENGTH_SHORT).show();
            URL url=new URL(login_url);
            HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            OutputStream outputStream= httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_data= URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"+URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream =httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

            String line="";
            while((line = bufferedReader.readLine())!= null){
                //Toast.makeText(context, "LOOP", Toast.LENGTH_SHORT).show();
                result+=line;
            }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        //Toast.makeText(context, "DO IN", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    protected void onPreExecute(){
        //Toast.makeText(context, "Pre", Toast.LENGTH_SHORT).show();
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Pre");
        alertDialog.show();
    }

    protected void OnPostExecute(String result)
    {
       // Toast.makeText(context, "POST", Toast.LENGTH_SHORT).show();
        alertDialog.setMessage("Post");
        alertDialog.show();
    }

    protected void OnProgressiveUpdate(Void... values)
    {
        super.onProgressUpdate(values);
    }


}


