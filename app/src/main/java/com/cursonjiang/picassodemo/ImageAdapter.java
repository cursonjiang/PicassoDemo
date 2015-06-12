package com.cursonjiang.picassodemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by root on 15/6/12.
 */
public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    //图片url地址
    private List<String> urls;

    public ImageAdapter(Context context, List<String> urls) {
        mContext = context;
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object getItem(int position) {
        return urls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        Picasso.with(mContext).load(urls.get(position)).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //设置显示imageview上的大小
        imageView.setLayoutParams(new GridView.LayoutParams(280, 280));
        return imageView;
    }
}
