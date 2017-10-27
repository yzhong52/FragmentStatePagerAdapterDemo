package com.o8o4.yuchen.fragmentstatepageradapterexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

public class MyAdapter extends FragmentStatePagerAdapter
{
    private static final int NUM_ITEMS = 10;
    private ArrayList<Integer> page_indexes;

    MyAdapter(FragmentManager fm) {
        super(fm);

        page_indexes = new ArrayList<>();
        for (int i = 0; i < NUM_ITEMS; i++) {
            page_indexes.add(i);
        }
    }

    @Override
    public int getCount() {
        return page_indexes.size();
    }

    @Override
    public Fragment getItem(int position) {
        Integer index = page_indexes.get(position);
        return ArrayListFragment.newInstance(index);
    }

    void deletePage(int position) {
        if (canDelete()) {
            page_indexes.remove(position);
            notifyDataSetChanged();
        }
    }

    boolean canDelete() {
        return page_indexes.size() > 0;
    }

    // This is called when notifyDataSetChanged() is called
    @Override
    public int getItemPosition(Object object) {
        // refresh all fragments when data set changed
        return PagerAdapter.POSITION_NONE;
    }
}
