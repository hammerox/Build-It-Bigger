package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.mauricio.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.hammerox.android.joketeller.JokeActivity;

import java.io.IOException;

/**
 * Created by Mauricio on 27-Jul-16.
 */
class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private Button button;
    private ProgressBar loading;

    public EndpointsAsyncTask(Context context, View view) {
        this.context = context;
        button = (Button) view.findViewById(R.id.joke_button);
        loading = (ProgressBar) view.findViewById(R.id.progress_bar);
    }

    @Override
    protected String doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-1385.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        button.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(context, JokeActivity.class);
        intent.putExtra(JokeActivity.TAG_JOKE, result);
        context.startActivity(intent);

        button.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
    }
}