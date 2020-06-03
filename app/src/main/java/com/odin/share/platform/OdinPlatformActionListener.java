package com.odin.share.platform;

import android.app.Activity;
import android.widget.Toast;

import java.util.HashMap;

import cn.odinshare.core.Platform;
import cn.odinshare.core.PlatformActionListener;

/**
 * 分享和授权的回调事件
 * <p>
 * 注意：回调事件是在子线程中运行的，如需要在主线程中使用，请使用Handler或其他方法使其运行在主线程中
 */
public class OdinPlatformActionListener implements PlatformActionListener {

    private Activity activity;

    private OnCompleteListener onCompleteListener;

    public OdinPlatformActionListener(Activity activity) {
        this.activity = activity;
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        this.onCompleteListener = onCompleteListener;
    }

    @Override
    public void onComplete(Platform platform, final int action, final HashMap<String, Object> res) {
        String text = "";
        if (action == Platform.ACTION_SHARE) {
            text = "分享成功";
        } else if (action == Platform.ACTION_AUTHORIZING) {
            text = "授权成功";
        } else if (action == Platform.ACTION_USER_INFOR) {
            text = "获取用户信息成功";
        }
        final String completeText = text;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (onCompleteListener != null) {
                    onCompleteListener.onComplete(res);
                }
                Toast.makeText(activity, completeText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onError(Platform platform, int action, Throwable t) {
        String text = "";
        if (action == Platform.ACTION_SHARE) {
            text = "分享失败：" + t.getMessage();
        } else if (action == Platform.ACTION_AUTHORIZING) {
            text = "授权失败：" + t.getMessage();
        } else if (action == Platform.ACTION_USER_INFOR) {
            text = "获取用户资料失败：" + t.getMessage();
        }
        final String errorText = text;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, errorText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCancel(Platform platform, int action) {
        String text = "";
        if (action == Platform.ACTION_SHARE) {
            text = "已取消分享";
        } else if (action == Platform.ACTION_AUTHORIZING) {
            text = "已取消授权";
        } else if (action == Platform.ACTION_USER_INFOR) {
            text = "已取消获取用户资料";
        }
        final String cancelText = text;
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(activity, cancelText, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public interface OnCompleteListener {
        void onComplete(HashMap<String, Object> res);
    }
}
