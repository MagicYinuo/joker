package com.tai.joker.joker.activity;

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
import com.tai.joker.joker.bean.JokerPicBean;
import com.tai.joker.joker.bean.JokerTextBean;
import com.tai.joker.joker.bean.NewsBean;
import com.tai.joker.joker.fragment.JokerPicFragment;
import com.tai.joker.joker.fragment.JokerTextFragment;
import com.tai.joker.joker.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class MainUi extends AppCompatActivity {
    private String tag = this.getClass().getSimpleName();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {"文本笑话", "搞笑图片", "新闻"};
    private MyPagerAdapter mAdapter;
    private Gson gson;
    private List<JokerTextBean.ShowapiResBodyBean.ContentlistBean> mData;
    private List<JokerPicBean.ShowapiResBodyBean.ContentlistBean> mPicData;
    private List<NewsBean.NewslistBean> mNewsData;
    private SlidingTabLayout layout;
    private Parameters parameters;
    private int FIRST_ENTER_PAGE = 1;
    private JokerTextBean jokerTextBean;
    private JokerPicBean jokerPicBean;

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

        layout = (SlidingTabLayout) findViewById(R.id.main_tabs);
        layout.setViewPager(viewPager);

    }

    private void initData() {
        parameters = new Parameters();
        parameters.put(Constant.PARAMETERS_KEY, String.valueOf(FIRST_ENTER_PAGE));

        for (String title : mTitles) {
            if ("文本笑话" == title) {
                ApiStoreSDK.execute(Constant.JOKER_TEXT_URL, ApiStoreSDK.GET, parameters, new ApiCallBack() {
                    @Override
                    public void onSuccess(int i, String s) {
                        super.onSuccess(i, s);
                        Toast.makeText(getApplicationContext(), "获取数据成功", Toast.LENGTH_SHORT).show();
                        gson = new Gson();

                        jokerTextBean = gson.fromJson(s, JokerTextBean.class);
                        if (jokerTextBean == null) {
                            Log.i(tag, "gson解析数据失败为空");
                        } else {
                            Log.i(tag, "文本解析数据成功:" + jokerTextBean.getShowapi_res_body().getContentlist().get(0).getText());
                            mData = jokerTextBean.getShowapi_res_body().getContentlist();
                            //设置fragment
                            mFragments.add(JokerTextFragment.getInstance(mData));
                            layout.addNewTab(mTitles[0]);
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                });
            } else if ("搞笑图片" == title) {
                ApiStoreSDK.execute(Constant.JOKER_PIC_URL, ApiStoreSDK.GET, parameters, new ApiCallBack() {
                    @Override
                    public void onSuccess(int i, String s) {
                        super.onSuccess(i, s);
                        Toast.makeText(getApplicationContext(), "获取数据成功", Toast.LENGTH_SHORT).show();
                        gson = new Gson();
                        jokerPicBean = gson.fromJson(s, JokerPicBean.class);
                        if (jokerPicBean == null) {
                            Log.i(tag, "gson解析数据失败为空");
                        } else {
                            Log.i(tag, "图片解析数据成功:" + jokerPicBean.getShowapi_res_body().getContentlist().get(0).getImg());
                            mPicData = jokerPicBean.getShowapi_res_body().getContentlist();
                            //设置fragment
                            mFragments.add(JokerPicFragment.getInstance(mPicData));
                            layout.addNewTab(mTitles[1]);
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                });
            } else {
                parameters.put("num", "10");
                ApiStoreSDK.execute(Constant.NEWS_URL, ApiStoreSDK.GET, parameters, new ApiCallBack() {
                    @Override
                    public void onSuccess(int i, String s) {
                        super.onSuccess(i, s);
                        Toast.makeText(getApplicationContext(), "获取数据成功", Toast.LENGTH_SHORT).show();
                        gson = new Gson();
                        NewsBean newsBean = gson.fromJson(s, NewsBean.class);
                        if (newsBean == null) {
                            Log.i(tag, "gson解析数据失败为空");
                        } else {
                            Log.i(tag, "解析数据成功:" + newsBean.getCode());
                            mNewsData = newsBean.getNewslist();
                            //设置fragment
                            mFragments.add(NewsFragment.getInstance(mNewsData));
                            layout.addNewTab(mTitles[2]);
                            mAdapter.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
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
