package com.yztcedu.my.yangtaopai.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yztcedu.com.yangtaotop.R;
import com.yztcedu.my.yangtaopai.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankFragment extends BaseFragment {


    public RankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rank, container, false);
    }

}