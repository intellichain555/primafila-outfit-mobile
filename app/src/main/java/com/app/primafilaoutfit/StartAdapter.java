package com.app.primafilaoutfit;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class StartAdapter extends PagerAdapter {

    private Context mContext;

    public StartAdapter(Context context) {
        mContext = context;
    }
    private View.OnClickListener mItemClickListener = null;
    public void setItemClickListener(View.OnClickListener listener) {
        mItemClickListener = listener;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {
        // TODO Auto-generated method stub
        return view == obj;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        final View v2 = LayoutInflater.from(mContext).inflate(R.layout.start_item, null);
        ImageView imgPhoto = (ImageView)v2.findViewById(R.id.imgPhoto);
        TextView txtFirst = (TextView)v2.findViewById(R.id.txtFirst);

        Button btnNext = (Button)v2.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, Home.class));
            }
        });
        ImageView imgNext = (ImageView)v2.findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StartActivity) mContext).gotoNext(position + 1);
            }
        });
        switch (position){
            case 0:
                imgPhoto.setImageDrawable(mContext.getResources().getDrawable(R.drawable.back_start1));
                txtFirst.setText(mContext.getResources().getString(R.string.start_string1_first));
                imgNext.setVisibility(View.VISIBLE);
                break;
            case 1:
                imgPhoto.setImageDrawable(mContext.getResources().getDrawable(R.drawable.back_start2));
                txtFirst.setText(mContext.getResources().getString(R.string.start_string2_first));
                imgNext.setVisibility(View.VISIBLE);
                break;
            case 2:
                imgPhoto.setImageDrawable(mContext.getResources().getDrawable(R.drawable.back_start3));
                txtFirst.setText(mContext.getResources().getString(R.string.start_string3_first));
                imgNext.setVisibility(View.VISIBLE);
                break;
            case 3:
                imgPhoto.setImageDrawable(mContext.getResources().getDrawable(R.drawable.back_start4));
                txtFirst.setText(mContext.getResources().getString(R.string.start_string4_first));
                imgNext.setVisibility(View.GONE);
                break;
        }

        ((ViewPager) container).addView(v2);
        return v2;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        ((ViewPager) container).removeView((View) object);
    }
}
