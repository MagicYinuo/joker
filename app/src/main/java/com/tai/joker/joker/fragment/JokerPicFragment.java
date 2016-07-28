package com.tai.joker.joker.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tai.joker.joker.R;
import com.tai.joker.joker.bean.JokerPicBean;

import java.util.List;

/**
 * 获取图片的fragment
 */
@SuppressLint("ValidFragment")
public class JokerPicFragment extends Fragment {
    private ListView lv;
    private View v;
    private List<JokerPicBean.ShowapiResBodyBean.ContentlistBean> list;
    private LayoutInflater mInflater;
    private Context mContext;

    public static JokerPicFragment getInstance(List<JokerPicBean.ShowapiResBodyBean.ContentlistBean> list) {
        JokerPicFragment jf = new JokerPicFragment();
        jf.list = list;
        return jf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mContext = getContext();
        Fresco.initialize(mContext);
        super.onCreate(savedInstanceState);
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_pic, null);
        TextView tv = (TextView) v.findViewById(R.id.pic_tv);
        tv.setText("图片笑话");
        lv = (ListView) v.findViewById(R.id.pic_lv);
        lv.setAdapter(new MyPicAdapter());
        return v;
    }

    public class MyPicAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (list != null) {
                return list.size();
            } else {
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
            //获取数据bean
            JokerPicBean.ShowapiResBodyBean.ContentlistBean bean = list.get(position);
            viewHolder holder = null;
            if (convertView == null) {
                holder = new viewHolder();
                convertView = mInflater.inflate(R.layout.list_pic_item, null);
                holder.mTitle = (TextView) convertView.findViewById(R.id.title);
                holder.mImageView = (SimpleDraweeView) convertView.findViewById(R.id.image_view);
                holder.mDate = (TextView) convertView.findViewById(R.id.date);
                convertView.setTag(holder);

            } else {
                holder = (viewHolder) convertView.getTag();
            }

            holder.mTitle.setText(bean.getTitle());
            Uri uri = Uri.parse(bean.getImg());
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(uri)
                    .setAutoPlayAnimations(true)
                    .build();

            holder.mImageView.setController(controller);
            holder.mDate.setText(bean.getCt().substring(0, 16));


            return convertView;
        }
    }

    public class viewHolder {
        private TextView mTitle;
        private SimpleDraweeView mImageView;
        private TextView mDate;
    }


}