package com.example.sort.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sort.R;

public class Test1 extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("darren", this.getClass().getName() + " onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("darren", this.getClass().getName() + " onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("darren", this.getClass().getName() + " onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("darren", this.getClass().getName() + " onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("darren", this.getClass().getName() + " onDestroy");
    }
}