package com.yztcedu.my.yangtaopai.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.yztcedu.my.yangtaopai.base.BaseFragment;

import yztcedu.com.yangtaotop.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {


    public MainFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}
