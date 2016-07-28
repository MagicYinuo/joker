package com.tai.joker.joker.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tai.joker.joker.R;
import com.tai.joker.joker.activity.NewsItemActivity;
import com.tai.joker.joker.bean.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class NewsFragment extends Fragment {
    private List<NewsBean.NewslistBean> list;
    private Context mContext;
    private LayoutInflater mInflater;
    private MyFragmentAdapter mAdapter;

    public static NewsFragment getInstance(List<NewsBean.NewslistBean> list) {
        NewsFragment nf = new NewsFragment();
        nf.list = list;
        return nf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mInflater = LayoutInflater.from(mContext);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, null);
        TextView tv = (TextView) v.findViewById(R.id.news_title);
        tv.setText("新闻");
        ListView lv = (ListView) v.findViewById(R.id.news_lv);
        mAdapter = new MyFragmentAdapter();
        lv.setAdapter(mAdapter);

        return v;
    }

    public class MyFragmentAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            viewHolder viewHolder = null;
            final NewsBean.NewslistBean contentlistBean = list.get(position);
            if (convertView == null) {
                viewHolder = new viewHolder();
                convertView = mInflater.inflate(R.layout.list_news_item, null);
                viewHolder.mTitle = (TextView) convertView.findViewById(R.id.new__item_title);
                viewHolder.mDesc = (TextView) convertView.findViewById(R.id.new__item_desc);
                viewHolder.mDate = (TextView) convertView.findViewById(R.id.new__item_date);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (NewsFragment.viewHolder) convertView.getTag();
            }
            viewHolder.mTitle.setText(contentlistBean.getTitle());
            viewHolder.mDesc.setText(contentlistBean.getDescription());
            viewHolder.mDate.setText(contentlistBean.getCtime());
            viewHolder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(mContext, NewsItemActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("key",contentlistBean.getUrl());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
            return convertView;
        }

    }

    static class viewHolder {
        public TextView mTitle;
        public TextView mDesc;
        public TextView mDate;
    }
}
