package com.yztcedu.my.yangtaopai.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yztcedu.my.yangtaopai.activity.GuideActivity;
import com.yztcedu.my.yangtaopai.activity.MainActivity;

import java.util.List;

import yztcedu.com.yangtaotop.R;
import com.yztcedu.my.yangtaopai.activity.GuideActivity;
import com.yztcedu.my.yangtaopai.activity.MainActivity;
import com.yztcedu.my.yangtaopai.activity.SplashActivity;

/**
 * Created by Administrator on 2016/12/6.
 */

public class ViewpagerAdapter extends PagerAdapter {


    private List<Integer> mGuidePhotos;
    private Context mContext;
    private LayoutInflater mInflater;

    /**
     *  通过构造方法给Context 个数据源赋值
     * @param mContext  作用是初始化LayoutInflater
     * @param mGuidePhotos  数据源
     */
    public ViewpagerAdapter(Context mContext, List<Integer> mGuidePhotos) {
        this.mContext = mContext;
        this.mGuidePhotos = mGuidePhotos;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {  //判断是否 为空 返回长度
        return mGuidePhotos != null ? mGuidePhotos.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;  //判断当前显示的View 是不是返回的View
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mInflater.inflate(R.layout.viewpager_guide, container, false);

        ImageView ivGuidePhoto = (ImageView) view.findViewById(R.id.iv_guide_photo);
        //设置图片
        ivGuidePhoto.setImageResource(mGuidePhotos.get(position));
        if (position == mGuidePhotos.size() - 1) {  //判断是否是最后一张引导页   如果最后一张可以给用用户一个点击事件
            ivGuidePhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, MainActivity.class);
                    //把Context 强制转成Activity
                    GuideActivity guideActivity = (GuideActivity) mContext;
                    guideActivity.startActivity(intent);
                    guideActivity.finish();
                }
            });
        }

        //必须把view加进去
        container.addView(view);
        return view;
    }

    //销毁一个View
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


}
