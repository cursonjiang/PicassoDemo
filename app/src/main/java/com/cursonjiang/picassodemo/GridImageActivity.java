package com.cursonjiang.picassodemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 15/6/12.
 */
public class GridImageActivity extends AppCompatActivity {

    private ImageAdapter mImageAdapter;
    private GridView mGridView;

    private List<String> urls = new ArrayList<>();

    private final String baseUrl = "http://www.jycoder.com/json/Image/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        mGridView = (GridView) findViewById(R.id.grid_view);
        //图片地址
        for (int i = 1; i <= 18; i++) {
            urls.add(baseUrl + i + ".jpg");
        }
        mImageAdapter = new ImageAdapter(GridImageActivity.this, urls);
        mGridView.setAdapter(mImageAdapter);

        mGridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(GridImageActivity.this, MainActivity.class);
                        //把点击的url地址传到MainActivity
                        intent.putExtra("imageUrl", urls.get(position));
                        startActivity(intent);
                    }
                }
        );
    }
}
