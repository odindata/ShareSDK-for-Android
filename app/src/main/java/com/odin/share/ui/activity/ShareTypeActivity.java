package com.odin.share.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.share.base.BaseActivity;
import com.odin.share.R;
import com.odin.share.adapter.listener.OnItemClickListener;
import com.odin.share.adapter.ShareTypeAdapter;
import com.odin.share.Constant;
import com.odin.share.platform.ShareTypeManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 平台的具体的分享类型Activity：
 * <p>
 * 各个平台支持分享的类型，如文本、视频、音频等等。
 */
public class ShareTypeActivity extends BaseActivity implements OnItemClickListener {

    private String name;
    private String platformName;
    private ShareTypeAdapter shareTypeAdapter;

    private List<Integer> shareTypeList = new ArrayList<>();

    private static final String EXTRA_NAME = "EXTRA_NAME";
    private static final String EXTRA_PLATFORM_NAME = "EXTRA_PLATFORM_NAME";

    public static void newInstance(Context context, String name, String platformName) {
        Intent intent = new Intent(context, ShareTypeActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_PLATFORM_NAME, platformName);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_share_type;
    }

    @Override
    public void initView() {
        ImageView mImgGoBack = findViewById(R.id.img_back);
        mImgGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView mTvShareTitle = findViewById(R.id.mTitle);
        String title = "分享至" + (name == null ? "" : name);
        mTvShareTitle.setText(title);

        RecyclerView mRecyclerView = findViewById(R.id.mSharePlatform);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        shareTypeAdapter = new ShareTypeAdapter(this, shareTypeList);
        shareTypeAdapter.setOnClickItemListener(this);
        mRecyclerView.setAdapter(shareTypeAdapter);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            name = intent.getStringExtra(EXTRA_NAME);
            platformName = intent.getStringExtra(EXTRA_PLATFORM_NAME);
        }
        shareTypeList.clear();
        if (!TextUtils.isEmpty(platformName)) {
            Integer[] shareTypes = Constant.byNamePlatforms(platformName);
            List<Integer> ls = Arrays.asList(shareTypes);
            shareTypeList.addAll(ls);
            if (shareTypeAdapter != null) {
                shareTypeAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onItemClick(View view, int shareTypeCode) {
        ShareTypeManager shareManager = new ShareTypeManager(this, platformName);
        shareManager.shareShow(shareTypeCode);
    }
}
