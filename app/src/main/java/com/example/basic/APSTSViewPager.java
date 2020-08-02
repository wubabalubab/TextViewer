package com.example.basic;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;


/**
 * Created by linhonghong on 2015/8/10.
 */
public class APSTSViewPager extends ViewPager {
    private boolean mNoFocus = false; //if true, keep View don't move
    public APSTSViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public APSTSViewPager(Context context){
        this(context,null);
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mNoFocus) {
            return false;
        }
        return !noScroll && super.onInterceptTouchEvent(event);
    }
    private boolean noScroll = true;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        /* return false;//super.onTouchEvent(arg0); */
        switch(event.getAction()){
        }
        return !noScroll && super.onTouchEvent(event);
    }

    public void setNoScroll(boolean b){
        noScroll = b;
    }

    public void setNoFocus(boolean b){
        mNoFocus = b;
    }
}