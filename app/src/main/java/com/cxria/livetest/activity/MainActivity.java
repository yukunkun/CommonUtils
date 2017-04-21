package com.cxria.livetest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cxria.livetest.R;
import com.cxria.livetest.activity.photo.PhotoListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Photo(View view) {
        Intent intent=new Intent(this, PhotoListActivity.class);
        startActivity(intent);
    }
}
