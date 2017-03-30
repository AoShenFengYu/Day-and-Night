package com.example.davidlo.myapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "MainActivity";

    private VerticalViewPager fragmentsViewPager;
    private FragmentAdapter fragmentAdapter;

    /**
     * Sky
     **/
    private View daySkyLayout;
    private View nightSkyLayout;

    /**
     * Cloud
     **/
    private View dayCloudLayout;
    private View nightCloudLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLayout();
    }

    private void initLayout() {

        daySkyLayout = findViewById(R.id.day_sky_layout);
        nightSkyLayout = findViewById(R.id.night_sky_layout);

        dayCloudLayout = findViewById(R.id.day_cloud_layout);
        nightCloudLayout = findViewById(R.id.night_cloud_layout);

        initFragmentViewPager();
    }

    private void initFragmentViewPager() {
        fragmentsViewPager = (VerticalViewPager) findViewById(R.id.activity_main_fragments_view_pager);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());

        setupFragments();

        fragmentsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG, position + " " + positionOffset + " " + positionOffsetPixels);
                if (position == 0) {

                    daySkyLayout.setAlpha(1 - positionOffset);
                    nightSkyLayout.setAlpha(positionOffset);

//                    dayCloudLayout.setAlpha(1 - positionOffset);
                    nightCloudLayout.setAlpha(positionOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupFragments() {
        fragmentAdapter.addFragment(new DayFragment());
        fragmentAdapter.addFragment(new NightFragment());
        fragmentsViewPager.setAdapter(fragmentAdapter);
    }
}
