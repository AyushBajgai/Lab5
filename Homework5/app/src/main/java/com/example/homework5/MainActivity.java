package com.example.homework5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int increment = 0;

    private TextView showCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting ID
        showCount = (TextView) findViewById(R.id.countInc);

        if (savedInstanceState != null) {
            increment = savedInstanceState.getInt("count");
            showCount.setText(String.valueOf(increment));
        }
    }

    public void increment(View view) {
        increment++;

        if(showCount != null){
            showCount.setText(Integer.toString(increment));
        }

    }

    //Save instance
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count", increment);

    }
}