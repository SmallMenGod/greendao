package com.bidostar.testkotlin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class TestDateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_date);
        TextView textView = findViewById(R.id.tv_test);
        String passedTime = getPassedTime("2017-12-08 22:37:12.133");
        Log.d("TestDateActivity", "passedTime:" + passedTime);
    }

    private String getPassedTime(String createTime) {
        Date time = DateFormatUtils.parse(createTime, DateFormatUtils.PATTERN_MILL);
        return DateFormatUtils.getPassedTime2(this, time.getTime());
    }
}
