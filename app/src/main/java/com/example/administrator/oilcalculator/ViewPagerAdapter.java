package com.example.administrator.oilcalculator;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import java.util.List;

/**
 * Created by Holmes on 2015/11/8.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    private Context context;

    public ViewPagerAdapter(List<View> views,Context context)
    {
        this.viewList=views;
        this.context=context;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {

        ((ViewPager) container).removeView(viewList.get(position));
    }

    @Override
    public Object instantiateItem(View container, int position) {

        ((ViewPager) container).addView(viewList.get(position));

        return viewList.get(position);

    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view==o;
    }
}