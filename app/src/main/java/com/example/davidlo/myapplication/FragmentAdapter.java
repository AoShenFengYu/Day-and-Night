package com.example.davidlo.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by davidlo on 9/20/16.
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    public final String TAG = "FragmentAdapter";

    private ArrayList<BaseFragment> fragments;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        if (position < fragments.size())
            return fragments.get(position);
        else
            return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(BaseFragment baseFragment) {
        fragments.add(baseFragment);
    }
}
