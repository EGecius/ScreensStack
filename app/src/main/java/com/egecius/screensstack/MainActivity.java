package com.egecius.screensstack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerOnClickListeners();
    }

    private void registerOnClickListeners() {
        findViewById(R.id.to_detail_screen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToDetailsScreen();
            }
        });
    }

    private void navigateToDetailsScreen() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}
