package com.yztcedu.my.yangtaopai.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.yztcedu.my.yangtaopai.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.yztcedu.my.yangtaopai.R;

import com.yztcedu.my.yangtaopai.adapter.MainAdapter;
import com.yztcedu.my.yangtaopai.fragment.MainFragment;
import com.yztcedu.my.yangtaopai.fragment.MessageFragment;
import com.yztcedu.my.yangtaopai.fragment.RankFragment;
import com.yztcedu.my.yangtaopai.fragment.UserFragment;


/**
 * 通过Viewpager 跟Fragment 实现底部导航
 * 1）数据源 List<Fragment>
 * 2) 适配器 FragmentPagerAdapter
 * 3) 控件绑定适配器
 */
public class MainActivity extends BaseActivity {

    //Viewpager 跟fragment集合 跟适配器
    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    private List<Fragment> mFragments;
    private MainAdapter mMainAdapter;


    //底部的layout  通过底部的layout 控件点击事件
    @BindView(R.id.layout_bottom)
    LinearLayout mLayoutBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //初始化Fragment
        initFragment();
        initViewPager();
    }

    /**
     * 初始化Viewpager
     */
    private void initViewPager() {
        //初始化mMainAdapter
        mMainAdapter = new MainAdapter(getSupportFragmentManager(), mFragments);
        //设置适配器
        mVpMain.setAdapter(mMainAdapter);
        //设置超屏数量
        mVpMain.setOffscreenPageLimit(mFragments.size() - 1);
        //设置第一个默认选择
        setTab(0);
        //设置
        setTabOnClick();
        //对Viewpager进行滑动监听
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {  //滑动结束
                setTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setTabOnClick() {

        //获得子View的数据
        int tabCount = mLayoutBottom.getChildCount();
        for (int i=0; i<tabCount; i++) {
            //获得tab
            View tabView = mLayoutBottom.getChildAt(i);
            //让tabView绑定位置
            tabView.setTag(i);
            tabView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //从tabView背包中取出位置
                    int position = (int) view.getTag();
                    //让ViewPager滑动到指定位置
                    mVpMain.setCurrentItem(position);
                }
            });
        }
    }

    private void initFragment() {
        //将主页面中的四个Fragment添加到集合中去
        mFragments = new ArrayList<>();
        mFragments.add(new MainFragment());
        mFragments.add(new RankFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new UserFragment());
    }

    //设置Tab按钮高亮显示
    private void setTab(int position) {
        //获得子View的数据
        int tabCount = mLayoutBottom.getChildCount();
        for (int i = 0; i < tabCount; i++) {
            //获得tab
            View tabView = mLayoutBottom.getChildAt(i);
            if (i == position) {
                tabView.setSelected(true);
            } else {
                tabView.setSelected(false);
            }
        }
    }




}
