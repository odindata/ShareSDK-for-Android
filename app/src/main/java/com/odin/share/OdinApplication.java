package com.odin.share;

import android.app.Application;

import cn.odinshare.core.OdinShareSDK;

public class OdinApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //OdinShareSDK初始化
        OdinShareSDK.init(this);

        //开启日志打印，默认是关闭模式
        OdinShareSDK.setLogEnabled(true);
    }
}
