package com.tai.joker.tabtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/27.
 */
public class MyFragment extends Fragment {
    private String mTitle;

    public static MyFragment getInstance(String title) {
        MyFragment mf = new MyFragment();
        mf.mTitle = title;
        return mf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment, null);
        TextView tv = (TextView) v.findViewById(R.id.textview);
        tv.setText(mTitle);
        return v;
    }
}
