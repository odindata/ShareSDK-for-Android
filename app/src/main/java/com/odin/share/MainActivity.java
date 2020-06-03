package com.odin.share;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.odin.share.adapter.PagerAdapter;
import com.odin.share.base.BaseActivity;
import com.odin.share.base.BaseFragment;
import com.odin.share.ui.frag.AuthorizationFragment;
import com.odin.share.ui.frag.ShareFragment;
import com.odin.share.ui.frag.UserInfoFragment;
import com.odin.share.utils.TabLayoutUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private TabLayout mTabLayout;

    private List<BaseFragment> mFragmentList = new ArrayList<>();

    private String[] mainTabTitles = null;

    private static final int REQUEST_CODE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE};

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ViewPager viewPager = findViewById(R.id.mViewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.setTitles(mainTabTitles);
        pagerAdapter.setFragments(mFragmentList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(1);
        viewPager.addOnPageChangeListener(this);

        mTabLayout = findViewById(R.id.tablayout);
        mTabLayout.setupWithViewPager(viewPager);
        mTabLayout.post(new Runnable() {
            @Override
            public void run() {
                TabLayoutUtils.changeIndicatorWidthEqualsTextView(mTabLayout);
            }
        });
        checkPermission();
    }

    /**
     * 检查权限，分享授权登录需要动态申请的权限
     */
    public void checkPermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(PERMISSIONS_STORAGE, REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void initData() {
        mainTabTitles = new String[]{
                getString(R.string.str_share),
                getString(R.string.str_authorization),
                getString(R.string.str_user_info)
        };
        ShareFragment shareFragment = new ShareFragment();
        mFragmentList.add(shareFragment);
        AuthorizationFragment authorizationFragment = new AuthorizationFragment();
        mFragmentList.add(authorizationFragment);
        UserInfoFragment userInfoFragment = new UserInfoFragment();
        mFragmentList.add(userInfoFragment);
    }


    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        BaseFragment fragment = mFragmentList.get(position);
        fragment.refreshData();
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
