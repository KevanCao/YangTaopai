package com.yztcedu.my.yangtaopai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */

public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    /**
     * 通过构造方法传参
     *
     * @param fm         FragmentManager 管理对象 固定写法
     * @param mFragments Fragment 集合
     */
    public MainAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }


    //返回当前的Fragment
    @Override
    public Fragment getItem(int position) {
        return mFragments != null ? mFragments.get(position) : null;
    }

    //返回Fragment的个数
    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }
}
