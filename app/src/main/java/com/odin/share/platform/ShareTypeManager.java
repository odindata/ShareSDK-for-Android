package com.odin.share.platform;

import com.odin.share.ui.activity.ShareTypeActivity;

import cn.odinshare.core.Platform;

public class ShareTypeManager {

    private String platformName;
    private PlatformShareManager platformShareManager;

    public ShareTypeManager(ShareTypeActivity context, String platformName) {
        this.platformName = platformName;
        this.platformShareManager = new PlatformShareManager();
        this.platformShareManager.setPlatformActionListener(new OdinPlatformActionListener(context));
    }

    public void shareShow(int shareTypeCode) {
        switch (shareTypeCode) {
            case Platform.SHARE_TEXT:
                shareText();
                break;
            case Platform.SHARE_VIDEO:
                shareVideo();
                break;
            case Platform.SHARE_IMAGE:
                shareImage();
                break;
            case Platform.SHARE_IMAGE_LOCAL:
                shareImageLocal();
                break;
            case Platform.SHARE_IMAGE_HTTP:
                shareImageHttp();
                break;
            case Platform.SHARE_IMAGE_BITMAP:
                shareImageBitmap();
                break;
            case Platform.SHARE_IMAGE_ARRAY:
                shareImageArray();
                break;
            case Platform.SHARE_EMOJI:
                shareEmoji();
                break;
            case Platform.SHARE_WXMINIPROGRAM:
                shareMiniProgram();
                break;
            case Platform.SHARE_WEBPAGE:
                shareWebPage();
                break;
            case Platform.SHARE_MUSIC:
                shareMusic();
                break;
        }
    }

    private void shareText() {
        platformShareManager.shareText(platformName);
    }

    private void shareVideo() {
        platformShareManager.shareVideo(platformName);
    }

    private void shareImage() {
        platformShareManager.shareImage(platformName);
    }

    private void shareImageLocal() {
        platformShareManager.shareImageLocal(platformName);
    }

    private void shareImageHttp() {
        platformShareManager.shareImageHttp(platformName);
    }

    private void shareImageBitmap() {
        platformShareManager.shareImageBitmap(platformName);
    }

    private void shareImageArray() {
        platformShareManager.shareImageArray(platformName);
    }

    private void shareEmoji() {
        platformShareManager.shareEmoji(platformName);
    }

    private void shareMiniProgram() {
        platformShareManager.shareMiniProgram(platformName);
    }

    private void shareWebPage() {
        platformShareManager.shareWebPage(platformName);
    }

    private void shareMusic() {
        platformShareManager.shareMusic(platformName);
    }

}
