package com.tai.joker.tabtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String[] TITLES = {"大蛇丸", "皮卡丘", "皮皮鲁"};
    private ViewPager mViewPager;
    private SlidingTabLayout tabs;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (String title : TITLES) {
            mFragments.add(MyFragment.getInstance(title));
        }
        //pager
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        //tab
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setViewPager(mViewPager, TITLES);
    }

    public class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
    }


}
