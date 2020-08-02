package com.example.textviewer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
*   author K.K
*   created on 2020/7/28
*   @Describe OpenActivity
*/


public class OpenActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button btn_1;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.pagertab)
    PagerTabStrip pagertab;



    private ArrayList<ItemInfo> itemInfos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        ButterKnife.bind(this);

        itemInfos=ItemInfo.getDefaultList();
        MyViewPagerAdapter mAdapter=new MyViewPagerAdapter(this,itemInfos);
        viewpager.setAdapter(mAdapter);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


}
