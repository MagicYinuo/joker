package com.tai.joker.joker.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.tai.joker.joker.R;
import com.tai.joker.joker.Utils.Constant;
import com.tai.joker.joker.bean.JokerTextBean;
import com.tai.joker.joker.fragment.JokerPicFragment;
import com.tai.joker.joker.fragment.JokerTextFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainUiBackup extends AppCompatActivity {
    private Context mContext = this;
    private String tag = this.getClass().getSimpleName();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {"文字笑话", "图片笑话"};
    private MyPagerAdapter mAdapter;
    private Gson gson;
    private List<JokerTextBean.ShowapiResBodyBean.ContentlistBean> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        //异步加载数据
        initData();

        //设置界面
        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mAdapter);

        //设置tabs
        SlidingTabLayout layout = (SlidingTabLayout) findViewById(R.id.main_tabs);
        layout.setViewPager(viewPager);

    }

    private void initData() {
        Parameters parameters = new Parameters();
        parameters.put(Constant.PARAMETERS_KEY, Constant.PARAMETERS_VALUE);
        ApiStoreSDK.execute(Constant.JOKER_TEXT_URL, ApiStoreSDK.GET, parameters, new ApiCallBack() {
            @Override
            public void onSuccess(int i, String s) {
                super.onSuccess(i, s);
                Toast.makeText(getApplicationContext(), "获取数据成功", Toast.LENGTH_SHORT).show();
                gson = new Gson();
                JokerTextBean jokerTextBean = gson.fromJson(s, JokerTextBean.class);
                if (jokerTextBean == null) {
                    Log.i(tag, "gson解析数据失败为空");
                } else {
                    Log.i(tag, "gson解析数据成功:" + jokerTextBean.getShowapi_res_body().getContentlist().get(0).getText());
                    mData = jokerTextBean.getShowapi_res_body().getContentlist();
                    //设置fragment
                    for (String title : mTitles) {
                        if ("文字笑话" == title) {
                            mFragments.add(JokerTextFragment.getInstance(mData));
                            mAdapter.notifyDataSetChanged();
                        } else {
                            mFragments.add(new JokerPicFragment());
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onError(int i, String s, Exception e) {
                super.onError(i, s, e);
            }
        });
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}
