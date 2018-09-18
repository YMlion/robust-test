package com.ymlion.robusttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            //RobustModify.modify();
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            //Snackbar.make(v, "Replace with fix action", Snackbar.LENGTH_LONG)
            //        .setAction("Action", null).show();
        });
    }

    //@Modify
    public void openActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("content", "this is from MainActivity.");
        intent.putExtra("open", false);
        //intent.putExtra("open", true);
        startActivity(intent);
    }

    public void openActivity3(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("content", "this is from MainActivity.");
        intent.putExtra("open", false);
        startActivity(intent);
    }
}
