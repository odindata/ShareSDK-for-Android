package com.odin.share.entity;

import com.odin.share.Constant;
import com.odin.share.R;

import cn.odinshare.core.Platform;

public class ShareType {

    /***
     * 标题，分割线
     */
    public final static int TITLE_SHARE_PLAT = 0;

    /***
     * 分享菜单和截图分享
     */
    public final static int DIRECT_SHARE_PLAT = 1;

    /**
     * 国内外平台分享
     */
    public final static int PLATFORM_SHARE_PLAT = 2;

    public static PlatformEntity createInLand() {
        PlatformEntity entity = new PlatformEntity();
        entity.setName(Constant.TYPE_SHARE_INLAND);
        entity.setType(ShareType.TITLE_SHARE_PLAT);
        return entity;
    }

    public static PlatformEntity createInternational() {
        PlatformEntity entity = new PlatformEntity();
        entity.setName(Constant.TYPE_SHARE_INTERNAL);
        entity.setType(ShareType.TITLE_SHARE_PLAT);
        return entity;
    }

    public static int getPlatformIcon(int share_type) {
        switch (share_type) {
            case Platform.SHARE_VIDEO:
                return R.mipmap.share_video;
            case Platform.SHARE_IMAGE:
                return R.mipmap.share_picture;
            case Platform.SHARE_IMAGE_ARRAY:
                return R.mipmap.share_multi_picture;
            case Platform.SHARE_APPS:
                return R.mipmap.share_app;
            case Platform.SHARE_FILE:
                return R.mipmap.share_file;
            case Platform.SHARE_EMOJI:
                return R.mipmap.share_emoji;
            case Platform.SHARE_WXMINIPROGRAM:
                return R.mipmap.share_mini_program;
            case Platform.SHARE_MUSIC:
                return R.mipmap.share_music;
            case Platform.SHARE_WEBPAGE:
                return R.mipmap.share_webpager;
            case Platform.SHARE_TEXT:
            default:
                return R.mipmap.share_text;
        }
    }

    public static int getPlatformName(int share_type) {
        switch (share_type) {
            case Platform.SHARE_VIDEO:
                return R.string.str_share_video;
            case Platform.SHARE_IMAGE:
                return R.string.str_share_image;
            case Platform.SHARE_IMAGE_LOCAL:
                return R.string.str_share_image_local;
            case Platform.SHARE_IMAGE_HTTP:
                return R.string.str_share_image_http;
            case Platform.SHARE_IMAGE_BITMAP:
                return R.string.str_share_image_bitmap;
            case Platform.SHARE_IMAGE_ARRAY:
                return R.string.str_share_image_array;
            case Platform.SHARE_APPS:
                return R.string.str_share_app;
            case Platform.SHARE_FILE:
                return R.string.str_share_file;
            case Platform.SHARE_EMOJI:
                return R.string.str_share_emoji;
            case Platform.SHARE_WXMINIPROGRAM:
                return R.string.str_share_mini_app;
            case Platform.SHARE_WEBPAGE:
                return R.string.str_share_webpage;
            case Platform.SHARE_MUSIC:
                return R.string.str_share_music;
            case Platform.SHARE_TEXT:
            default:
                return R.string.str_share_text;
        }
    }
}
