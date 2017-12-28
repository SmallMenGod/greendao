package com.bidostar.module1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zsh27
 * @date 2017/12/28.
 * description .
 * @since 0
 */

public class TestFragment extends Fragment {
    onChooseCityCallBack mCallBack;

    public interface onChooseCityCallBack {
        void onResult(String city);
    }

    public static TestFragment newInstance(onChooseCityCallBack callBack) {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        fragment.setCallBack(callBack);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("FragmentBackActivity", "onCreateView");
        View view = inflater.inflate(R.layout.fragment_back, container, false);
        return view;
    }

    public void setCallBack(onChooseCityCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("FragmentBackActivity", "onStart");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("FragmentBackActivity", "onPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("FragmentBackActivity", "onResume");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("FragmentBackActivity", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("FragmentBackActivity", "onDestroy");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("FragmentBackActivity", "onAttach");
    }

}
