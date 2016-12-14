package com.yztcedu.my.yangtaopai.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.yztcedu.my.yangtaopai.base.BaseActivity;
import com.yztcedu.my.yangtaopai.util.SharedPreferencesUtils;

import com.yztcedu.my.yangtaopai.R;

public class SplashActivity extends BaseActivity {

    private static final String KEY_GOTO_MAIN = "key_goto_main";
    private boolean isGotoMain;  //设置一个标志位  是否进入主页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //开启一个子线程，进行睡眠操作，睡眠完成后，通过标志位判断是否进入主页面
        initThread();


    }

    private void initThread() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    Intent intent = new Intent();
                    isGotoMain  = SharedPreferencesUtils.getData(SplashActivity.this,KEY_GOTO_MAIN);
                    if (isGotoMain) {//true  就进入主页面
                        intent.setClass(SplashActivity.this, MainActivity.class);

                    } else {//false 进入引导页
                        intent.setClass(SplashActivity.this, GuideActivity.class);
                        //进入玩引导页面之后把开关保存成true ，下次就不进入引导页了

                        SharedPreferencesUtils.saveData(SplashActivity.this,KEY_GOTO_MAIN,true);
                    }
                    //启动
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();  //线程启动
    }


}
