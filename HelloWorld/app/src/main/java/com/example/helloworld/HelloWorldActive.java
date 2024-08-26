package com.example.helloworld;
import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;


public class HelloWorldActive extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello);
    }
}
