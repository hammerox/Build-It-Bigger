package com.hammerox.android.joketeller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public final static String TAG_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(TAG_JOKE);
        TextView jokeContainer = (TextView) findViewById(R.id.container_joke);
        jokeContainer.setText(joke);
    }
}
