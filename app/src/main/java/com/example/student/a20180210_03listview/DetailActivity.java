package com.example.student.a20180210_03listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tv = (TextView) findViewById(R.id.textView);

        Intent it = getIntent();
        String str = it.getStringExtra("data");
        tv.setText(str);
    }
}
