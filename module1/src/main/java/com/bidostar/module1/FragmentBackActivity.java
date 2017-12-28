package com.bidostar.module1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class FragmentBackActivity extends AppCompatActivity implements View.OnClickListener {
    private TestFragment mFragment;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_back);
        findViewById(R.id.btn_add).setOnClickListener(this);
        mFragment = new TestFragment();
        mManager = getSupportFragmentManager();

    }

    @Override
    public void onClick(View v) {
        Log.d("FragmentBackActivity", "onClick");
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.add(R.id.ll_content, mFragment, "test");
        transaction.addToBackStack("test");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        Log.d("FragmentBackActivity", "onBackPressed");
        Log.d("FragmentBackActivity", "mManager.getBackStackEntryCount():" + mManager.getBackStackEntryCount());
        if (mManager.getBackStackEntryCount() > 0) {
            mManager.popBackStack();
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("FragmentBackActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("FragmentBackActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("FragmentBackActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("FragmentBackActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FragmentBackActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("FragmentBackActivity", "onDestroy");
    }
}
