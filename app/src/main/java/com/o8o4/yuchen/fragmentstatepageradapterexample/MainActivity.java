package com.o8o4.yuchen.fragmentstatepageradapterexample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    MyAdapter mAdapter;
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);

        mAdapter = new MyAdapter(getSupportFragmentManager());

        mPager = findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        findViewById(R.id.goto_first).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(0);
            }
        });
        findViewById(R.id.delete_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.deletePage(mPager.getCurrentItem());
            }
        });
        findViewById(R.id.goto_last).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(mAdapter.getCount() - 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
