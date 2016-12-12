package com.yztcedu.my.yangtaopai.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yztcedu.com.yangtaotop.R;

import com.yztcedu.my.yangtaopai.adapter.ViewpagerAdapter;
import com.yztcedu.my.yangtaopai.base.BaseActivity;

public class GuideActivity extends BaseActivity {


    //引导页的资源id集合
    public static final int[] photoId = {R.mipmap.yin1, R.mipmap.yin2,
            R.mipmap.yin3, R.mipmap.yin4, R.mipmap.yin5};


    //数据源
    private List<Integer> mPhotos;
    //Viewpager
    @BindView(R.id.vp_guide)
    ViewPager mVpGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        initData();
    }
    //初始化数据源
    private void initData() {
        mPhotos = new ArrayList<>();
        for (int i = 0; i < photoId.length; i++) {
            mPhotos.add(photoId[i]);
        }
        //初始化适配器
        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(this, mPhotos);
        //绑定适配器
        mVpGuide.setAdapter(viewpagerAdapter);
        //设置Viewpager的超屏数量
        mVpGuide.setOffscreenPageLimit(mPhotos.size() - 1);



    }


}
