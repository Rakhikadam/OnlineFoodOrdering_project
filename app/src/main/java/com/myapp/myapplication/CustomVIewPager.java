package com.myapp.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class CustomVIewPager  extends ViewPager {

    boolean swippable = true;

    public CustomVIewPager(@NonNull Context context) {
        super(context);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if(swippable){
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Never allow swiping to switch between pages
        if(swippable){
            return super.onTouchEvent(event);
        }
        return false;
    }

    public void setSwipeable(boolean swippable) {
        this.swippable = swippable;
    }
}