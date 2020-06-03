package com.odin.share.ui.frag;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.share.base.BaseActivity;
import com.odin.share.base.BaseFragment;
import com.odin.share.R;
import com.odin.share.adapter.AuthorizationAdapter;
import com.odin.share.Constant;
import com.odin.share.entity.PlatformEntity;
import com.odin.share.entity.ShareType;

import java.util.ArrayList;
import java.util.List;

/**
 * 授权的Fragment.
 */
public class AuthorizationFragment extends BaseFragment {

    private AuthorizationAdapter authorizationAdapter;
    private List<PlatformEntity> authorPlatformList = new ArrayList<>();

    @Override
    public void initView(View mView) {

        RecyclerView mRecyclerView = mView.findViewById(R.id.recycler_view_authorize);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        authorizationAdapter = new AuthorizationAdapter((BaseActivity) getActivity(), authorPlatformList);
        mRecyclerView.setAdapter(authorizationAdapter);
    }

    @Override
    public void initData() {
        //国内授权平台
        authorPlatformList.add(ShareType.createInLand());
        authorPlatformList.addAll(Constant.getAuthorInLandEntityList());

        //国外授权平台
        authorPlatformList.add(ShareType.createInternational());
        authorPlatformList.addAll(Constant.getAuthorInternationalEntityList());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_authorize;
    }

    @Override
    public void refreshData() {
        if (authorizationAdapter != null) {
            authorizationAdapter.notifyDataSetChanged();
        }
    }
}
