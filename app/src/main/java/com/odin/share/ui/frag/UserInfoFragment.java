package com.odin.share.ui.frag;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.share.base.BaseActivity;
import com.odin.share.base.BaseFragment;
import com.odin.share.R;
import com.odin.share.adapter.UserInfoAdapter;
import com.odin.share.Constant;
import com.odin.share.entity.PlatformEntity;
import com.odin.share.entity.ShareType;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取用户信息的Fragment:
 * <p>
 * 1、如果还未授权登录，先进行授权登录，然后再获取用户信息；
 * 2、如果已经授权，直接获取用户信息。
 */
public class UserInfoFragment extends BaseFragment {

    private UserInfoAdapter userInfoAdapter;
    private List<PlatformEntity> showUserPlatformEntityList = new ArrayList<>();

    @Override
    public void initView(View mView) {

        RecyclerView mRecyclerView = mView.findViewById(R.id.recycler_view_show_user_info);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        userInfoAdapter = new UserInfoAdapter((BaseActivity) getActivity(), showUserPlatformEntityList);
        mRecyclerView.setAdapter(userInfoAdapter);
    }

    @Override
    public void initData() {
        //国内授权平台
        showUserPlatformEntityList.add(ShareType.createInLand());
        showUserPlatformEntityList.addAll(Constant.getAuthorInLandEntityList());

        //国外授权平台
        showUserPlatformEntityList.add(ShareType.createInternational());
        showUserPlatformEntityList.addAll(Constant.getAuthorInternationalEntityList());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_userinfo;
    }

    @Override
    public void refreshData() {
        if (userInfoAdapter != null) {
            userInfoAdapter.notifyDataSetChanged();
        }
    }
}
