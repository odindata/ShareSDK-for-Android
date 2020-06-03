package com.odin.share.platform.wechat.favorite;

import com.odin.share.Constant;
import com.odin.share.platform.PlatformShare;

import cn.odinshare.core.OdinShareSDK;
import cn.odinshare.core.Platform;
import cn.odinshare.core.PlatformActionListener;
import cn.odinshare.core.utils.BitmapHelper;

/**
 * 微信收藏分享
 */
public class WechatFavoriteShare extends PlatformShare {

    public WechatFavoriteShare(PlatformActionListener mListener) {
        super(mListener);
    }

    @Override
    public void shareText() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_TEXT);
        shareParams.setShareType(Platform.SHARE_TEXT);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_WECHATFAVORITE, shareParams, platformActionListener);
    }

    @Override
    public void shareImageLocal() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImagePath(Constant.IMAGE_PATH);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_WECHATFAVORITE, shareParams, platformActionListener);
    }

    @Override
    public void shareImageHttp() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_TEXT);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_WECHATFAVORITE, shareParams, platformActionListener);
    }

    @Override
    public void shareImageBitmap() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        try {
            shareParams.setImageData(BitmapHelper.getBitmap(Constant.IMAGE_BITMAP));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_WECHATFAVORITE, shareParams, platformActionListener);
    }

    @Override
    public void shareMusic() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_MUSIC);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setUrl(Constant.MUSIC_URL_WEBPAGE);
        shareParams.setMusicUrl(Constant.MUSIC_URL);
        shareParams.setShareType(Platform.SHARE_MUSIC);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_WECHATFAVORITE, shareParams, platformActionListener);
    }

    @Override
    public void shareVideo() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);//不显示
        shareParams.setTitle(Constant.TITLE_VIDEO);//不显示
        shareParams.setVideoUrl(Constant.VIDEO_URL);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_VIDEO);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_WECHATFAVORITE, shareParams, platformActionListener);
    }

    @Override
    public void shareWebPage() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);//不显示
        shareParams.setTitle(Constant.TITLE_WEBPAGE);
        shareParams.setUrl(Constant.WEBPAGE_URL);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_WECHATFAVORITE, shareParams, platformActionListener);
    }

}
