package com.tai.joker.joker.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tai.joker.joker.R;
import com.tai.joker.joker.Utils.HtmlUtil;
import com.tai.joker.joker.bean.JokerTextBean;

import java.util.List;


@SuppressLint("ValidFragment")
public class JokerTextFragment extends Fragment {
    private ListView lv;
    private View v;
    private final String tag = this.getClass().getSimpleName();
    private List<JokerTextBean.ShowapiResBodyBean.ContentlistBean> list;
    private LayoutInflater mInflater;

    public static JokerTextFragment getInstance(List<JokerTextBean.ShowapiResBodyBean.ContentlistBean> list) {
        JokerTextFragment jf = new JokerTextFragment();
        jf.list = list;
        return jf;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInflater = LayoutInflater.from(getContext());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_text, null);
        TextView tv = (TextView) v.findViewById(R.id.text_tv);
        tv.setText("文本笑话");

        lv = (ListView) v.findViewById(R.id.text_lv);
        lv.setAdapter(new MyTextAdapter());
        return v;
    }

    public class MyTextAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if (list != null) {
                Log.i(tag, "有数据:" + list.size());
                return list.size();
            } else {
                Log.i(tag, "数据为空");
                return 0;
            }
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
        public View getView(int position, View convertView, ViewGroup parent) {
            JokerTextBean.ShowapiResBodyBean.ContentlistBean bean = list.get(position);
            viewHolder holder = null;
            if (convertView == null) {
                holder = new viewHolder();
                convertView = mInflater.inflate(R.layout.list_text_item, null);
                holder.mName = (TextView) convertView.findViewById(R.id.name);
                holder.mContent = (TextView) convertView.findViewById(R.id.content);
                holder.mDate = (TextView) convertView.findViewById(R.id.date);
                convertView.setTag(holder);
            } else {
                holder = (viewHolder) convertView.getTag();
            }
            //设置数据
            holder.mName.setText(bean.getTitle());
            holder.mContent.setText(HtmlUtil.getTextFromHtml(bean.getText()));
            holder.mDate.setText(bean.getCt().substring(0, 16));

            return convertView;
        }

        public class viewHolder {
            public TextView mName;
            public TextView mContent;
            private TextView mDate;
        }
    }


}