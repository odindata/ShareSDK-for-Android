package com.odin.share.platform;

import cn.odinshare.core.PlatformActionListener;

/**
 * 目前OdinShareSDK所支持的所有分享
 */
public abstract class PlatformShare {

    protected PlatformActionListener platformActionListener;

    public PlatformShare(PlatformActionListener mListener) {
        platformActionListener = mListener;
    }

    /**
     * 分享文本，QQ好友、支付宝生活圈、Facebook和Instagram暂不支持
     */
    public abstract void shareText();

    /**
     * 分享本地图片
     */
    public abstract void shareImageLocal();

    /**
     * 分享网络图片
     */
    public abstract void shareImageHttp();

    /**
     * 分享二进制图片
     */
    public abstract void shareImageBitmap();

    /**
     * 分享音频，钉钉、Facebook、Twitter和Instagram暂不支持
     */
    public abstract void shareMusic();

    /**
     * 分享视频，暂时只有钉钉不支持
     */
    public abstract void shareVideo();

    /**
     * 分享链接，Twitter和Instagram暂不支持
     */
    public abstract void shareWebPage();


    /**
     * 分享多张图片，暂时只有新浪微博和QQ空间支持
     */
    public void shareImageArray() {
    }

    /**
     * 分享表情，当前只有微信好友支持
     */
    public void shareEmoji() {
    }

    /**
     * 分享小程序，暂时只有微信好友支持
     */
    public void shareMiniProgram() {
    }

}
