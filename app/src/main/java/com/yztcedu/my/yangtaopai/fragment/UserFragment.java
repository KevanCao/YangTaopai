package com.yztcedu.my.yangtaopai.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yztcedu.my.yangtaopai.R;
import com.yztcedu.my.yangtaopai.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment {


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

}
