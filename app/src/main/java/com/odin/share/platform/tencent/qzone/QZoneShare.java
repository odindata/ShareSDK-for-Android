package com.odin.share.platform.tencent.qzone;

import com.odin.share.Constant;
import com.odin.share.platform.PlatformShare;

import cn.odinshare.core.OdinShareSDK;
import cn.odinshare.core.Platform;
import cn.odinshare.core.PlatformActionListener;
import cn.odinshare.core.utils.BitmapHelper;

/**
 * QQ空间分享
 */
public class QZoneShare extends PlatformShare {

    public QZoneShare(PlatformActionListener mListener) {
        super(mListener);
    }

    @Override
    public void shareText() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setShareType(Platform.SHARE_TEXT);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
    }

    @Override
    public void shareWebPage() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setTitle(Constant.TITLE_WEBPAGE);
        shareParams.setText(Constant.TEXT);
        shareParams.setUrl(Constant.WEBPAGE_URL);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
    }

    @Override
    public void shareImageLocal() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImagePath(Constant.IMAGE_PATH);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
    }

    @Override
    public void shareImageHttp() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
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

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
    }

    @Override
    public void shareImageArray() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImageArray(Constant.IMAGE_ARRAY);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
    }

    @Override
    public void shareVideo() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_VIDEO);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setVideoUrl(Constant.VIDEO_URL);
        shareParams.setShareType(Platform.SHARE_VIDEO);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
    }

    @Override
    public void shareMusic() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setText(Constant.TEXT);
        shareParams.setTitle(Constant.TITLE_MUSIC);
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setMusicUrl(Constant.MUSIC_URL);
        shareParams.setShareType(Platform.SHARE_MUSIC);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_QZONE, shareParams, platformActionListener);
    }

}
