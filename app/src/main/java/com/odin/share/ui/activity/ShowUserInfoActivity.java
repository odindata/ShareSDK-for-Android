package com.odin.share.ui.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.odin.share.base.BaseActivity;
import com.odin.share.R;

/**
 * 用户信息展示界面
 */
public class ShowUserInfoActivity extends BaseActivity {

    private static final String EXTRA_PLATFORM = "EXTRA_PLATFORM";
    private static final String EXTRA_USER_INFO = "EXTRA_USER_INFO";

    public static void newInstance(Context context, String platform, String userInfo) {
        Intent intent = new Intent(context, ShowUserInfoActivity.class);
        intent.putExtra(EXTRA_PLATFORM, platform);
        intent.putExtra(EXTRA_USER_INFO, userInfo);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_userinfomsg;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        final String userMsg = intent.getStringExtra(EXTRA_USER_INFO);

        TextView mTvTitle = findViewById(R.id.mTitle);
        mTvTitle.setText("详细信息");
        TextView mTvUserInfoMsg = findViewById(R.id.showUserInfo);
        mTvUserInfoMsg.setText(userMsg);

        ImageView mImgBack = findViewById(R.id.img_back);
        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button mBtnCopyMsg = findViewById(R.id.btn_copy_msg);
        mBtnCopyMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setClipboard(userMsg);
            }
        });
    }

    @Override
    public void initData() {

    }

    public void setClipboard(String text) {
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (cm != null) {
            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText(null, text);
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            Toast.makeText(this, "已将用户信息复制到剪贴板", Toast.LENGTH_SHORT).show();
        }
    }
}
