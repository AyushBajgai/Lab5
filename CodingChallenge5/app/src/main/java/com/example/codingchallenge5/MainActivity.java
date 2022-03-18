package com.example.codingchallenge5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private ShopList items = new ShopList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if ((savedInstanceState != null) && (savedInstanceState.getSerializable("list") != null)) {
            HashMap<String, Integer> l = (HashMap<String, Integer>) savedInstanceState.getSerializable("list");
            TextView tv = findViewById(R.id.text1);
            tv.setText("");
            for (String keys : l.keySet()) {
                String s = l.get(keys).toString() + " " + keys + "\n";
                tv.setText(tv.getText() + s);
                for (int i = 0; i < l.get(keys); i++) {
                    items.addItem(keys);
                }
            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    //Save instance
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("items", items.getItems());
    }
    private void drawView() {
        HashMap<String, Integer> l = items.getItems();
        TextView tv = findViewById(R.id.text1);
        tv.setText("");
        for (String keys : l.keySet()) {
            String s = l.get(keys).toString() + ") " + keys + "\n";
            tv.setText(tv.getText() + s);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String item = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);
                items.addItem(item);
            }
            drawView();
        }
    }
}