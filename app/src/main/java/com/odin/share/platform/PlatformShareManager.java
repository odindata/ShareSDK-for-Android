package com.odin.share.platform;

import com.odin.share.platform.alipay.friends.AlipayShare;
import com.odin.share.platform.alipay.moments.AlipayMomentsShare;
import com.odin.share.platform.dingding.friends.DingdingShare;
import com.odin.share.platform.facebook.FacebookShare;
import com.odin.share.platform.instagram.InstagramShare;
import com.odin.share.platform.sina.weibo.SinaWeiboShare;
import com.odin.share.platform.tencent.qq.QQShare;
import com.odin.share.platform.tencent.qzone.QZoneShare;
import com.odin.share.platform.twitter.TwitterShare;
import com.odin.share.platform.wechat.favorite.WechatFavoriteShare;
import com.odin.share.platform.wechat.friends.WechatShare;
import com.odin.share.platform.wechat.moments.WechatMomentsShare;

import cn.odinshare.alipay.friends.Alipay;
import cn.odinshare.alipay.moments.AlipayMoments;
import cn.odinshare.core.PlatformActionListener;
import cn.odinshare.dingding.friends.Dingding;
import cn.odinshare.facebook.Facebook;
import cn.odinshare.instagram.Instagram;
import cn.odinshare.qq.qq.QQ;
import cn.odinshare.qq.qzone.QZone;
import cn.odinshare.sina.weibo.SinaWeibo;
import cn.odinshare.twitter.Twitter;
import cn.odinshare.wechat.favorite.WechatFavorite;
import cn.odinshare.wechat.friends.Wechat;
import cn.odinshare.wechat.moments.WechatMoments;

/**
 * 获取各个平台后进行分享的操作。
 */
public class PlatformShareManager {
    private PlatformActionListener platformActionListener;

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.platformActionListener = platformActionListener;
    }

    private PlatformShare initPlatformShare(String name) {
        PlatformShare mPlatformShare = null;
        if (name.equals(Wechat.NAME)) {
            mPlatformShare = new WechatShare(platformActionListener);
        } else if (name.equals(WechatMoments.NAME)) {
            mPlatformShare = new WechatMomentsShare(platformActionListener);
        } else if (name.equals(WechatFavorite.NAME)) {
            mPlatformShare = new WechatFavoriteShare(platformActionListener);
        } else if (name.equals(QQ.NAME)) {
            mPlatformShare = new QQShare(platformActionListener);
        } else if (name.equals(QZone.NAME)) {
            mPlatformShare = new QZoneShare(platformActionListener);
        } else if (name.equals(SinaWeibo.NAME)) {
            mPlatformShare = new SinaWeiboShare(platformActionListener);
        } else if (name.equals(Alipay.NAME)) {
            mPlatformShare = new AlipayShare(platformActionListener);
        } else if (name.equals(AlipayMoments.NAME)) {
            mPlatformShare = new AlipayMomentsShare(platformActionListener);
        } else if (name.equals(Twitter.NAME)) {
            mPlatformShare = new TwitterShare(platformActionListener);
        } else if (name.equals(Facebook.NAME)) {
            mPlatformShare = new FacebookShare(platformActionListener);
        } else if (name.equals(Instagram.NAME)) {
            mPlatformShare = new InstagramShare(platformActionListener);
        } else if (name.equals(Dingding.NAME)) {
            mPlatformShare = new DingdingShare(platformActionListener);
        }
        return mPlatformShare;
    }

    public void shareText(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareText();
    }

    public void shareImage(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareImageHttp();
    }

    public void shareImageLocal(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareImageLocal();
    }

    public void shareImageHttp(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareImageHttp();
    }

    public void shareImageBitmap(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareImageBitmap();
    }

    public void shareImageArray(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareImageArray();
    }

    public void shareWebPage(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareWebPage();
    }

    public void shareVideo(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareVideo();
    }

    public void shareMusic(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareMusic();
    }

    public void shareEmoji(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareEmoji();
    }

    public void shareMiniProgram(String name) {
        PlatformShare platformShare = initPlatformShare(name);
        platformShare.shareMiniProgram();
    }
}
