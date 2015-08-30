package com.o8o4.yuchen.fragmentstatepageradapterexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by yuchen on 15-08-30.
 */
public class MyAdapter extends FragmentStatePagerAdapter
{
    static final int NUM_ITEMS = 10;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.newInstance(position);
    }
}
