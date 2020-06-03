package com.odin.share;

import com.odin.share.entity.PlatformEntity;
import com.odin.share.entity.ShareType;

import java.util.ArrayList;
import java.util.List;

import cn.odinshare.alipay.friends.Alipay;
import cn.odinshare.alipay.moments.AlipayMoments;
import cn.odinshare.core.OdinShareSDK;
import cn.odinshare.core.Platform;
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

public class Constant {

    public static final String TYPE_SHARE_INLAND = "国内平台";
    public static final String TYPE_SHARE_INTERNAL = "国外平台";

    /**分享的参数*/
    public static final String TEXT = "OdinShareSDK for Android不仅集成简单、支持如QQ好友、微信、新浪微博、支付宝等所有社交平台，而且还有强大的统计分析管理后台，实时了解用户、信息流、回流率、传播效应等数据 http://www.odinanalysis.com/";
    public static final String TITLE_TEXT = "OdinShareSDK";
    public static final String TITLE_WEBPAGE = "OdinShareSDK-分享网页";
    public static final String TITLE_MUSIC = "OdinShareSDK-分享音乐";
    public static final String TITLE_VIDEO = "OdinShareSDK-分享视频";
    public static final String TITLE_MINI_PROGRAM = "OdinShareSDK-分享小程序";


    public static final String TEXT_WEIBO_VIDEO = "OdinShareSDK for Android-新浪微博-分享视频";
    public static final String TEXT_WEIBO_WEBPAGE = "OdinShareSDK for Android-新浪微博-分享网页";

    public static final String IMAGE_URL = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587620755974&di=107b7c08f16782679b58a8c49c4c9f4f&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F78%2F52%2F01200000123847134434529793168.jpg";
    public static final String IMAGE_PATH = "sdcard/odin/com.odin.share/cache/images/4fddefd9fbb9100454c472d3cb62febe.jpg";
    public static final String IMAGE_BITMAP = "sdcard/odin/com.odin.share/cache/images/4fddefd9fbb9100454c472d3cb62febe.jpg";
    public static final String[] IMAGE_ARRAY = {"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587620755974&di=107b7c08f16782679b58a8c49c4c9f4f&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F78%2F52%2F01200000123847134434529793168.jpg", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3675415932,4054970339&fm=26&gp=0.jpg"};

    public static final String MUSIC_URL = "http://f1.webshare.mob.com/dvideo/demovideos.mp4";//音乐文件URL，必须是后缀为.map3等格式
    public static final String MUSIC_URL_WEBPAGE = "http://music.taihe.com/song/73987458";//音乐网页URL
    public static final String VIDEO_URL = "http://f1.webshare.mob.com/dvideo/demovideos.mp4";
    public static final String WEBPAGE_URL = "http://www.odinanalysis.com/";
    public static final String EMOJI_URL = "https://n.sinaimg.cn/tech/transform/447/w225h222/20200421/9c47-isqivxf7736773.gif";

    /**
     * 各个平台支持分享的类型
     */
    private static Integer[] alipay = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_TEXT,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_MUSIC,
            Platform.SHARE_VIDEO
    };
    private static Integer[] alipayMoments = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_MUSIC,
            Platform.SHARE_VIDEO
    };
    private static Integer[] qq = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_MUSIC,
            Platform.SHARE_VIDEO
    };
    private static Integer[] qzone = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_IMAGE_ARRAY,
            Platform.SHARE_TEXT,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_MUSIC,
            Platform.SHARE_VIDEO
    };
    private static Integer[] sinaWeibo = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_IMAGE_ARRAY,
            Platform.SHARE_TEXT,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_VIDEO
    };
    private static Integer[] wechat = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_TEXT,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_MUSIC,
            Platform.SHARE_VIDEO,
            Platform.SHARE_EMOJI,
            Platform.SHARE_WXMINIPROGRAM
    };
    private static Integer[] wechatMoments = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_TEXT,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_MUSIC,
            Platform.SHARE_VIDEO
    };
    private static Integer[] wechatFavorite = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_TEXT,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_MUSIC,
            Platform.SHARE_VIDEO
    };
    private static Integer[] dingding = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_TEXT,
            Platform.SHARE_WEBPAGE,
    };
    private static Integer[] facebook = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_WEBPAGE,
            Platform.SHARE_VIDEO
    };
    private static Integer[] twitter = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_TEXT,
            Platform.SHARE_VIDEO
    };
    private static Integer[] instagram = new Integer[]{
            Platform.SHARE_IMAGE,
            Platform.SHARE_VIDEO
    };

    /**
     * 获取平台支持的分享类型集合
     *
     * @param name 平台的名称
     * @return 平台支持的分享类型集合
     */
    public static Integer[] byNamePlatforms(String name) {
        if (name.equals(QQ.NAME)) {
            return qq;
        } else if (name.equals(QZone.NAME)) {
            return qzone;
        } else if (name.equals(Wechat.NAME)) {
            return wechat;
        } else if (name.equals(WechatMoments.NAME)) {
            return wechatMoments;
        } else if (name.equals(WechatFavorite.NAME)) {
            return wechatFavorite;
        } else if (name.equals(Alipay.NAME)) {
            return alipay;
        } else if (name.equals(AlipayMoments.NAME)) {
            return alipayMoments;
        } else if (name.equals(SinaWeibo.NAME)) {
            return sinaWeibo;
        } else if (name.equals(Facebook.NAME)) {
            return facebook;
        } else if (name.equals(Twitter.NAME)) {
            return twitter;
        } else if (name.equals(Instagram.NAME)) {
            return instagram;
        } else if (name.equals(Dingding.NAME)) {
            return dingding;
        } else {
            return new Integer[]{};
        }
    }


    /**
     * 分享菜单和截图分享
     *
     * @return 国内平台列表
     */
    public static List<PlatformEntity> getOneKeySharePlatformEntity() {
        List<PlatformEntity> entityList = new ArrayList<>();

        PlatformEntity entityOneKey = new PlatformEntity();
        entityOneKey.setName("分享菜单");
        entityOneKey.setType(ShareType.DIRECT_SHARE_PLAT);

        entityList.add(entityOneKey);

        return entityList;
    }

    /**
     * 国内平台列表
     *
     * @return 国内平台列表
     */
    public static List<PlatformEntity> getInLandSharePlatformEntity() {
        List<PlatformEntity> entityList = new ArrayList<>();

        PlatformEntity entityQQ = new PlatformEntity();
        entityQQ.setPlatform(OdinShareSDK.getPlatform(QQ.NAME));
        entityQQ.setName("QQ");
        entityQQ.setPlatName(QQ.NAME);
        entityQQ.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityQQ.setIcon(R.mipmap.odin_oks_classic_qq);

        PlatformEntity entityQZone = new PlatformEntity();
        entityQZone.setPlatform(OdinShareSDK.getPlatform(QZone.NAME));
        entityQZone.setName("QQ空间");
        entityQZone.setPlatName(QZone.NAME);
        entityQZone.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityQZone.setIcon(R.mipmap.odin_oks_classic_qzone);

        PlatformEntity entityWechat = new PlatformEntity();
        entityWechat.setPlatform(OdinShareSDK.getPlatform(Wechat.NAME));
        entityWechat.setName("微信");
        entityWechat.setPlatName(Wechat.NAME);
        entityWechat.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityWechat.setIcon(R.mipmap.odin_oks_classic_wechat);

        PlatformEntity entityWechatMoments = new PlatformEntity();
        entityWechatMoments.setPlatform(OdinShareSDK.getPlatform(WechatMoments.NAME));
        entityWechatMoments.setName("微信朋友圈");
        entityWechatMoments.setPlatName(WechatMoments.NAME);
        entityWechatMoments.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityWechatMoments.setIcon(R.mipmap.odin_oks_classic_wechatmoments);

        PlatformEntity entityWechatFavorite = new PlatformEntity();
        entityWechatFavorite.setPlatform(OdinShareSDK.getPlatform(WechatFavorite.NAME));
        entityWechatFavorite.setName("微信收藏");
        entityWechatFavorite.setPlatName(WechatFavorite.NAME);
        entityWechatFavorite.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityWechatFavorite.setIcon(R.mipmap.odin_oks_classic_wechatfavorite);

        PlatformEntity entitySinaWeibo = new PlatformEntity();
        entitySinaWeibo.setPlatform(OdinShareSDK.getPlatform(SinaWeibo.NAME));
        entitySinaWeibo.setName("新浪微博");
        entitySinaWeibo.setPlatName(SinaWeibo.NAME);
        entitySinaWeibo.setType(ShareType.PLATFORM_SHARE_PLAT);
        entitySinaWeibo.setIcon(R.mipmap.odin_oks_classic_sinaweibo);

        PlatformEntity entityAlipay = new PlatformEntity();
        entityAlipay.setPlatform(OdinShareSDK.getPlatform(Alipay.NAME));
        entityAlipay.setName("支付宝");
        entityAlipay.setPlatName(Alipay.NAME);
        entityAlipay.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityAlipay.setIcon(R.mipmap.odin_oks_classic_alipay);

        PlatformEntity entityAlipayMoments = new PlatformEntity();
        entityAlipayMoments.setPlatform(OdinShareSDK.getPlatform(AlipayMoments.NAME));
        entityAlipayMoments.setName("支付宝生活圈");
        entityAlipayMoments.setPlatName(AlipayMoments.NAME);
        entityAlipayMoments.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityAlipayMoments.setIcon(R.mipmap.odin_oks_classic_alipaymoments);

        PlatformEntity entityDingding = new PlatformEntity();
        entityDingding.setPlatform(OdinShareSDK.getPlatform(Dingding.NAME));
        entityDingding.setName("钉钉");
        entityDingding.setPlatName(Dingding.NAME);
        entityDingding.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityDingding.setIcon(R.mipmap.odin_oks_classic_dingding);

        entityList.add(entityQQ);
        entityList.add(entityQZone);
        entityList.add(entityWechat);
        entityList.add(entityWechatMoments);
        entityList.add(entityWechatFavorite);
        entityList.add(entitySinaWeibo);
        entityList.add(entityAlipay);
        entityList.add(entityAlipayMoments);
        entityList.add(entityDingding);

        return entityList;
    }

    /**
     * 国外平台列表
     *
     * @return 国外平台列表
     */
    public static List<PlatformEntity> getInternationalSharePlatformEntity() {
        List<PlatformEntity> entityList = new ArrayList<>();

        PlatformEntity entityFacebook = new PlatformEntity();
        entityFacebook.setPlatform(OdinShareSDK.getPlatform(Facebook.NAME));
        entityFacebook.setName("Facebook");
        entityFacebook.setPlatName(Facebook.NAME);
        entityFacebook.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityFacebook.setIcon(R.mipmap.odin_oks_classic_facebook);

        PlatformEntity entityTwitter = new PlatformEntity();
        entityTwitter.setPlatform(OdinShareSDK.getPlatform(Twitter.NAME));
        entityTwitter.setName("Twitter");
        entityTwitter.setPlatName(Twitter.NAME);
        entityTwitter.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityTwitter.setIcon(R.mipmap.odin_oks_classic_twitter);

        PlatformEntity entityInstagram = new PlatformEntity();
        entityInstagram.setPlatform(OdinShareSDK.getPlatform(Instagram.NAME));
        entityInstagram.setName("Instagram");
        entityInstagram.setPlatName(Instagram.NAME);
        entityInstagram.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityInstagram.setIcon(R.mipmap.odin_oks_classic_instagram);

        entityList.add(entityFacebook);
        entityList.add(entityTwitter);
        entityList.add(entityInstagram);

        return entityList;
    }

    /**
     * 国内支持授权登录的平台列表
     *
     * @return 国内支持授权登录的平台列表
     */
    public static List<PlatformEntity> getAuthorInLandEntityList() {
        List<PlatformEntity> authorShareListItemInEntityList = new ArrayList<>();

        PlatformEntity entityQQ = new PlatformEntity();
        entityQQ.setPlatform(OdinShareSDK.getPlatform(QQ.NAME));
        entityQQ.setName("QQ");
        entityQQ.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityQQ.setIcon(R.mipmap.odin_oks_classic_qq);

//        PlatformEntity entityWechat = new PlatformEntity();
//        entityWechat.setPlatform(OdinShareSDK.getPlatform(Wechat.NAME));
//        entityWechat.setName("微信");
//        entityWechat.setType(ShareType.PLATFORM_SHARE_PLAT);
//        entityWechat.setIcon(R.mipmap.odin_oks_classic_wechat);
//
//        PlatformEntity entitySinaWeibo = new PlatformEntity();
//        entitySinaWeibo.setPlatform(OdinShareSDK.getPlatform(SinaWeibo.NAME));
//        entitySinaWeibo.setName("新浪微博");
//        entitySinaWeibo.setType(ShareType.PLATFORM_SHARE_PLAT);
//        entitySinaWeibo.setIcon(R.mipmap.odin_oks_classic_sinaweibo);

        authorShareListItemInEntityList.add(entityQQ);
//        authorShareListItemInEntityList.add(entityWechat);
//        authorShareListItemInEntityList.add(entitySinaWeibo);
        return authorShareListItemInEntityList;
    }

    /**
     * 国外支持授权登录的平台列表
     *
     * @return 国外支持授权登录的平台列表
     */
    public static List<PlatformEntity> getAuthorInternationalEntityList() {
        List<PlatformEntity> authorShareListItemInEntityList = new ArrayList<>();

        PlatformEntity entityFacebook = new PlatformEntity();
        entityFacebook.setPlatform(OdinShareSDK.getPlatform(Facebook.NAME));
        entityFacebook.setName("Facebook");
        entityFacebook.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityFacebook.setIcon(R.mipmap.odin_oks_classic_facebook);

        PlatformEntity entityTwitter = new PlatformEntity();
        entityTwitter.setPlatform(OdinShareSDK.getPlatform(Twitter.NAME));
        entityTwitter.setName("Twitter");
        entityTwitter.setType(ShareType.PLATFORM_SHARE_PLAT);
        entityTwitter.setIcon(R.mipmap.odin_oks_classic_twitter);

        authorShareListItemInEntityList.add(entityFacebook);
        authorShareListItemInEntityList.add(entityTwitter);
        return authorShareListItemInEntityList;
    }
}
