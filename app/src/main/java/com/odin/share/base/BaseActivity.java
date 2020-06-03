package com.odin.share.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.odin.share.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initData();
        initView();
        //设置状态栏的背景颜色和文字颜色
        ImmersionBar.with(this).fitsSystemWindows(true).barColor(R.color.colorWhite).statusBarDarkFont(true).init();
    }

    //界面加载类
    public abstract int getLayoutId();

    //界面加载类
    public abstract void initView();

    //数据初始化完成操作
    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
