package com.example.viewpager2withstaticfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.viewpager2withstaticfragments.transformers.AntiClockSpinTransformation;
import com.example.viewpager2withstaticfragments.transformers.CubeInDepthTransformation;
import com.example.viewpager2withstaticfragments.transformers.CubeInRotationTransformation;
import com.example.viewpager2withstaticfragments.transformers.CubeOutRotationTransformation;
import com.example.viewpager2withstaticfragments.transformers.CubeOutScalingTransformation;
import com.example.viewpager2withstaticfragments.transformers.FadeOutTransformation;
import com.example.viewpager2withstaticfragments.transformers.FidgetSpinTransformation;
import com.example.viewpager2withstaticfragments.transformers.GateTransformation;
import com.example.viewpager2withstaticfragments.transformers.HingeTransformation;
import com.example.viewpager2withstaticfragments.transformers.HorizontalFlipTransformation;
import com.example.viewpager2withstaticfragments.transformers.PopTransformation;
import com.example.viewpager2withstaticfragments.transformers.SimpleTransformation;
import com.example.viewpager2withstaticfragments.transformers.SpinnerTransformation;
import com.example.viewpager2withstaticfragments.transformers.TossTransformation;
import com.example.viewpager2withstaticfragments.transformers.VerticalFlipTransformation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout pager_dots;
    private FragmentStateAdapter pagerAdapter;
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewpager);
        pager_dots = findViewById(R.id.pager_dots);

        fragmentArrayList.add(new Fragment1());
        fragmentArrayList.add(new Fragment2());
        fragmentArrayList.add(new Fragment3());

        pagerAdapter = new ViewPagerAdapter(this, fragmentArrayList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setPageTransformer(new TossTransformation());
        ViewPagerUtil.getInstance().setupIndicator(this, viewPager, pager_dots, fragmentArrayList.size());
        ViewPagerUtil.getInstance().onBackPressed(viewPager, getSupportFragmentManager());
    }

    @Override
    public void onBackPressed() {
        setViewPagerBackPress();
    }

    private void setViewPagerBackPress() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }


}