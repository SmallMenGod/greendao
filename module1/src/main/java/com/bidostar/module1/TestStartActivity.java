package com.bidostar.module1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestStartActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvmessage;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPreferences;
    private LinkedHashSet<String> mLinkedHashSet;
    private String[] strs = {"北京市", "许昌市", "南京市", "河北是", "被滨州市", "贵州市", "海南市"};
    private String mName = "city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_start);
        mTvmessage = findViewById(R.id.tv_message);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_query).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        mPreferences = getSharedPreferences(null, MODE_PRIVATE);
        mEditor = mPreferences.edit();

        mLinkedHashSet = new LinkedHashSet<>();
        String s = "{\"name\":\"anshan\",\"region\":\"鞍山\",\"regionInitial\":\"A\"}";

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btn_add) {
            mLinkedHashSet.add(strs[(int) (Math.random() * (strs.length - 1))]);
            Iterator<String> iterator = mLinkedHashSet.iterator();
            while (iterator.hasNext()) {
                Log.d("TestStartActivity", "btn_add:"+iterator.next());
            }
            mEditor.putStringSet(mName, mLinkedHashSet);
            mEditor.commit();
        } else if (i == R.id.btn_query) {
            Set<String> stringSet = mPreferences.getStringSet(mName, new LinkedHashSet<String>());
            Iterator<String> iterator = stringSet.iterator();
            StringBuffer sb = new StringBuffer();
            while (iterator.hasNext()) {
                String next = iterator.next();
                Log.d("TestStartActivity", "btn_query:"+next);
                sb.append(next + "\n");
            }
            mTvmessage.setText(sb.toString());
        } else if (i == R.id.btn_delete) {
            mEditor.clear();
            mEditor.commit();
        }
    }
}
