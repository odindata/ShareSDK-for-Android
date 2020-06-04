package com.odin.share;

import android.app.Application;

import cn.odinshare.core.OdinShareSDK;

public class OdinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //OdinShareSDK初始化
        OdinShareSDK.init(this);
    }
}
