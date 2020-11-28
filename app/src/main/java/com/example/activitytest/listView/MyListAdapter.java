package com.example.activitytest.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.activitytest.R;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater layoutInflater;

    public  MyListAdapter(Context context){
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,TvContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.layout_list_item, null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.TvContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("牛肉拉面");
        holder.tvTime.setText("2020-1130");
        holder.TvContent.setText("特别好吃！");
        //第三方库加载图片
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606562085969&di=809fa6f33671f081ffa4e48ab6eafee3&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%3D580%2Fsign%3D1b1c2a35402309f7e76fad1a420f0c39%2F1b9038f5e0fe9925e86756f132a85edf8cb17164.jpg").into(holder.imageView);
        return convertView;
    }
}
