package com.app.primafilaoutfit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.ViewPager;


public class StartActivity extends Activity {
    private static final int NUM_PAGES = 4;
    private ViewPager viewPager;
    LinearLayout lnContainer;
    private StartAdapter mPicOneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /*
        (findViewById(R.id.btnNext)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this, StartActivity.class));
            }
        });
*/
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        lnContainer = (LinearLayout)findViewById(R.id.lnContainer);
        mPicOneAdapter = new StartAdapter(StartActivity.this);

        for (int i = 0; i < mPicOneAdapter.getCount(); i++) {
            ImageView imageView = new ImageView(StartActivity.this);

            if (i == 0) {
                imageView.setId(i);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.space_50), (int) getResources().getDimension(R.dimen.space_10));
                params.leftMargin = (int) getResources().getDimension(R.dimen.space_5);
                imageView.setLayoutParams(params);
                imageView.setBackgroundResource(R.drawable.circle_select);
            }else {
                imageView.setId(i);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.space_10), (int) getResources().getDimension(R.dimen.space_10));
                params.leftMargin = (int) getResources().getDimension(R.dimen.space_5);
                imageView.setLayoutParams(params);
                imageView.setBackgroundResource(R.drawable.circle);
            }
            lnContainer.addView(imageView, i);
        }

        viewPager.setAdapter(mPicOneAdapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int a = 0;

            }

            @Override
            public void onPageSelected(int position) {
                lnContainer.removeAllViews();
                for (int i = 0; i < mPicOneAdapter.getCount(); i++) {
                    ImageView imageView = new ImageView(StartActivity.this);

                    if (i == position) {
                        imageView.setId(i);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.space_50), (int) getResources().getDimension(R.dimen.space_10));
                        params.leftMargin = (int) getResources().getDimension(R.dimen.space_5);
                        imageView.setLayoutParams(params);
                        imageView.setBackgroundResource(R.drawable.circle_select);
                    }else {
                        imageView.setId(i);
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) getResources().getDimension(R.dimen.space_10), (int) getResources().getDimension(R.dimen.space_10));
                        params.leftMargin = (int) getResources().getDimension(R.dimen.space_5);
                        imageView.setLayoutParams(params);
                        imageView.setBackgroundResource(R.drawable.circle);
                    }
                    lnContainer.addView(imageView, i);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int a = 0;
            }
        });
    }

    public void gotoNext(int page){
        viewPager.setCurrentItem(page);
    }
}
