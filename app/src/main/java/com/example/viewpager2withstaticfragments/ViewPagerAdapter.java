package com.example.viewpager2withstaticfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

class ViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> fragmentArrayList;

    public ViewPagerAdapter(MainActivity mainActivity, ArrayList<Fragment> fragmentArrayList) {
        super(mainActivity);
        this.fragmentArrayList = fragmentArrayList;
    }

    @NonNull @Override public Fragment createFragment(int position) {
        return fragmentArrayList.get(position);
    }

    @Override public int getItemCount() {
        return fragmentArrayList.size();
    }
}