package com.cursonjiang.picassodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.full_image);

        //获取传过来的地址
        Intent intent = getIntent();
        String imageUrl = intent.getExtras().getString("imageUrl");

        //通过Picasso设置到ImageView上
        Picasso.with(MainActivity.this)
               .load(imageUrl)
               .placeholder(R.mipmap.ic_launcher)
               .error(R.mipmap.ic_launcher)
               .into(mImageView);
    }
}
