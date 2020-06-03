package com.odin.share.platform.facebook;

import com.odin.share.Constant;
import com.odin.share.platform.PlatformShare;

import cn.odinshare.core.OdinShareSDK;
import cn.odinshare.core.Platform;
import cn.odinshare.core.PlatformActionListener;
import cn.odinshare.core.utils.BitmapHelper;

/**
 * Facebook分享
 */
public class FacebookShare extends PlatformShare {

    public FacebookShare(PlatformActionListener mListener) {
        super(mListener);
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

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_FACEBOOK, shareParams, platformActionListener);
    }

    @Override
    public void shareImageHttp() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImageUrl(Constant.IMAGE_URL);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_FACEBOOK, shareParams, platformActionListener);
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

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_FACEBOOK, shareParams, platformActionListener);
    }

    @Override
    public void shareImageArray() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setImageArray(Constant.IMAGE_ARRAY);
        shareParams.setShareType(Platform.SHARE_IMAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_FACEBOOK, shareParams, platformActionListener);
    }

    @Override
    public void shareMusic() {
        //暂时不支持
    }

    @Override
    public void shareVideo() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setVideoUrl(Constant.VIDEO_URL);
        shareParams.setShareType(Platform.SHARE_VIDEO);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_FACEBOOK, shareParams, platformActionListener);
    }

    @Override
    public void shareWebPage() {
        Platform.ShareParams shareParams = new Platform.ShareParams();
        shareParams.setUrl(Constant.WEBPAGE_URL);
        shareParams.setShareType(Platform.SHARE_WEBPAGE);

        OdinShareSDK.doShare(OdinShareSDK.PLATFORM_FACEBOOK, shareParams, platformActionListener);
    }

}
