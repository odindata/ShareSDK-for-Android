package com.odin.share.ui.frag;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.share.adapter.listener.OnScreenshotClickListener;
import com.odin.share.base.BaseActivity;
import com.odin.share.base.BaseFragment;
import com.odin.share.R;
import com.odin.share.adapter.listener.OnItemClickListener;
import com.odin.share.adapter.SharePlatformAdapter;
import com.odin.share.Constant;
import com.odin.share.entity.ShareType;
import com.odin.share.entity.PlatformEntity;
import com.odin.share.platform.OdinPlatformActionListener;
import com.odin.share.ui.activity.ShareTypeActivity;

import java.util.ArrayList;
import java.util.List;

import cn.odinshare.odinonekeyshare.OneKeyShare;

/**
 * 分享的Fragment:
 * <p>
 * 1、一键分享和截图分享；2、国内平台分享；3、国外平台分享。
 */
public class ShareFragment extends BaseFragment implements OnItemClickListener, OnScreenshotClickListener {

    private ImageView mImgScreenshotShare;

    private Bitmap screenshotBitmap;
    private List<PlatformEntity> platformEntityList = new ArrayList<>();

    public void initView(View view) {

        mImgScreenshotShare = view.findViewById(R.id.img_screenshot_share);
        mImgScreenshotShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenshotShare(screenshotBitmap);
            }
        });
        RecyclerView mRecyclerView = view.findViewById(R.id.recycler_view_share);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        SharePlatformAdapter sharePlatformAdapter = new SharePlatformAdapter((BaseActivity) getActivity(), platformEntityList);
        sharePlatformAdapter.setOnItemListener(this);
        sharePlatformAdapter.setOnScreenshotClickListener(this);
        mRecyclerView.setAdapter(sharePlatformAdapter);
    }

    /**
     * 获取分享的平台数据
     */
    public void initData() {
        //一键分享和截图分享
        platformEntityList.addAll(Constant.getOneKeySharePlatformEntity());

        //国内分享平台
        platformEntityList.add(ShareType.createInLand());
        platformEntityList.addAll(Constant.getInLandSharePlatformEntity());

        //国外分享平台
        platformEntityList.add(ShareType.createInternational());
        platformEntityList.addAll(Constant.getInternationalSharePlatformEntity());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_shareplatform;
    }

    @Override
    public void refreshData() {

    }

    /**
     * 当点击某个平台时，会进入该平台具体的分享类型的Activity
     *
     * @param view     view
     * @param position position
     */
    @Override
    public void onItemClick(View view, int position) {
        PlatformEntity entity = platformEntityList.get(position);
        ShareTypeActivity.newInstance(getContext(), entity.getName(), entity.getPlatName());
    }

    /**
     * 截图分享
     */
    private void screenshotShare(Bitmap screenshotBitmap) {
        try {
            //分享一个图片
            new OneKeyShare()
                    .setImageData(screenshotBitmap)
                    .setPlatformActionListener(new OdinPlatformActionListener(activity))
                    .show(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onScreenshot(View view, int position) {
        if (screenshotBitmap == null) {
            screenshotBitmap = screenshot(activity);
            if (screenshotBitmap == null) {
                return;
            }
        }
        mImgScreenshotShare.setImageBitmap(screenshotBitmap);
        mImgScreenshotShare.setVisibility(View.VISIBLE);
        Toast.makeText(activity, activity.getString(R.string.str_screenshot_share_hint), Toast.LENGTH_SHORT).show();
        mImgScreenshotShare.postDelayed(new Runnable() {
            @Override
            public void run() {
                mImgScreenshotShare.setVisibility(View.GONE);
            }
        }, 3000);
    }

    private Bitmap screenshot(Activity activity) {
        /*获取windows中最顶层的view*/
        View view = activity.getWindow().getDecorView();
        //允许当前窗口保存缓存信息
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        WindowManager windowManager = activity.getWindowManager();
        //获取屏幕宽和高
        DisplayMetrics outMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        int height = outMetrics.heightPixels;
        //去掉状态栏
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, width, height);
        //销毁缓存信息
        view.destroyDrawingCache();
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }
}
