package com.example.textviewer;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * author K.K
 * created on 2020/7/28
 *
 * @Describe MyViewPagerAdapter
 */
public class MyViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<View> views = new ArrayList<>();
    private ArrayList<ItemInfo> itemInfos = new ArrayList<>();
    private LayoutInflater layoutInflater;


    public MyViewPagerAdapter(Context context, ArrayList<ItemInfo> itemInfos) {
        this.mContext = context;
        this.itemInfos = itemInfos;
        layoutInflater = LayoutInflater.from(context);
        for (int i = 0; i < itemInfos.size(); i++) {
            View view = layoutInflater.inflate(R.layout.item_pager_1, null);
            ImageView imageView = view.findViewById(R.id.imageView2);
            TextView textView = view.findViewById(R.id.textView);
            imageView.setImageResource(itemInfos.get(i).image);
            textView.setText(itemInfos.get(i).description);

            views.add(view);
        }
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int position) {
        switch (position) {
            case 0:
                TextView tvWeb = views.get(0).findViewById(R.id.textView);
                tvWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, WebActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 1:
                TextView tvSummit=views.get(1).findViewById(R.id.textView);
                tvSummit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1=new Intent(mContext,TranslationActivity.class);
                        mContext.startActivity(intent1);
                    }
                });
                break;
            case 2:
                break;
            default:
                break;

        }
        viewGroup.addView(views.get(position));
        return views.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return itemInfos.get(position).name;
    }
}
