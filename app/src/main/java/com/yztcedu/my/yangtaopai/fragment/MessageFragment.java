package com.yztcedu.my.yangtaopai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.yztcedu.my.yangtaopai.base.BaseFragment;

import yztcedu.com.yangtaotop.R;

/**
 * Created by Administrator on 2016/12/7.
 */

public class MessageFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }
}
