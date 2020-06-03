package com.odin.share.platform.alipay.moments;

import com.odin.share.Constant;
import com.odin.share.platform.PlatformShare;

import cn.odinshare.core.OdinShareSDK;
import cn.odinshare.core.Platform;
import cn.odinshare.core.PlatformActionListener;
import cn.odinshare.core.utils.BitmapHelper;

/**
 * 支付宝生活圈分享
 */
public class AlipayMomentsShare extends PlatformShare {

    public AlipayMomentsShare(PlatformActionListener listener) {
        super(listener);
    }

    @Override
    public void shareText() {
        //暂时不支持
    }

    @Override
    public void shareImageLocal() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImagePath(Constant.IMAGE_PATH);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_ALIPAYMOMENTS, shareParams, platformActionListener);
    }

    @Override
    public void shareImageHttp() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_ALIPAYMOMENTS, shareParams, platformActionListener);
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

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_ALIPAYMOMENTS, shareParams, platformActionListener);
    }

    @Override
    public void shareMusic() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_MUSIC);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setMusicUrl(Constant.MUSIC_URL_WEBPAGE);
        shareParams.setShareType(Platform.SHARE_MUSIC);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_ALIPAYMOMENTS, shareParams, platformActionListener);
    }

    @Override
    public void shareVideo() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_VIDEO);
        shareParams.setVideoUrl(Constant.VIDEO_URL);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_VIDEO);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_ALIPAYMOMENTS, shareParams, platformActionListener);
    }

    @Override
    public void shareWebPage() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_WEBPAGE);
        shareParams.setUrl(Constant.WEBPAGE_URL);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_ALIPAYMOMENTS, shareParams, platformActionListener);
    }

}
