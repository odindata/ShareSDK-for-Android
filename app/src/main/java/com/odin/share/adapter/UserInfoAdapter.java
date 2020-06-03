package com.odin.share.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.share.base.BaseActivity;
import com.odin.share.R;
import com.odin.share.entity.PlatformEntity;
import com.odin.share.entity.ShareType;
import com.odin.share.platform.OdinPlatformActionListener;
import com.odin.share.ui.activity.ShowUserInfoActivity;
import com.odin.share.utils.TextUtils;

import java.util.HashMap;
import java.util.List;

import cn.odinshare.core.Platform;

/**
 * 获取用户信息的Adapter
 */
public class UserInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private BaseActivity activity;
    private LayoutInflater layoutInflater;
    private List<PlatformEntity> platformEntityList;

    public UserInfoAdapter(BaseActivity activity, List<PlatformEntity> platformEntityList) {
        this.activity = activity;
        this.platformEntityList = platformEntityList;
        this.layoutInflater = LayoutInflater.from(activity);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShareType.TITLE_SHARE_PLAT) {
            View view = layoutInflater.inflate(R.layout.item_title, parent, false);
            return new TitleViewHolder(view);
        } else {
            View view = layoutInflater.inflate(R.layout.item_authorization, parent, false);
            return new AuthorizationViewHolder(view);
        }
    }

    /**
     * 设置按钮的状态
     *
     * @param mBtnAuthorizeStatus 按钮
     * @param resIdText           text的ID
     * @param resIdBg             背景的ID
     * @param color               文字颜色的ID
     */
    private void setAuthorizeStatus(Button mBtnAuthorizeStatus, @StringRes int resIdText, @DrawableRes int resIdBg, @ColorRes int color) {
        mBtnAuthorizeStatus.setText(resIdText);
        mBtnAuthorizeStatus.setBackgroundResource(resIdBg);
        mBtnAuthorizeStatus.setTextColor(activity.getResources().getColor(color));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        PlatformEntity platformEntity = platformEntityList.get(position);
        final Platform platform = platformEntity.getPlatform();

        //标题
        if (holder instanceof TitleViewHolder) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
            titleViewHolder.textView.setText(platformEntity.getName());
        }
        //国内外平台
        if (holder instanceof AuthorizationViewHolder) {
            final AuthorizationViewHolder authorizationViewHolder = (AuthorizationViewHolder) holder;
            if (platform.isAuthValid()) {
                setAuthorizeStatus(authorizationViewHolder.mBtnAuthorizeStatus, R.string.str_user_info_show, R.drawable.shape_user_info_status, R.color.colorWhite);
            } else {
                setAuthorizeStatus(authorizationViewHolder.mBtnAuthorizeStatus, R.string.str_user_info, R.drawable.shape_authorize_status, R.color.colorTitle);
            }
            authorizationViewHolder.mBtnAuthorizeStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OdinPlatformActionListener platformActionListener = new OdinPlatformActionListener(activity);
                    platformActionListener.setOnCompleteListener(new OdinPlatformActionListener.OnCompleteListener() {
                        @Override
                        public void onComplete(HashMap<String, Object> userInfo) {
                            if (platform.isAuthValid()) {
                                setAuthorizeStatus(authorizationViewHolder.mBtnAuthorizeStatus, R.string.str_user_info_show, R.drawable.shape_user_info_status, R.color.colorWhite);
                            } else {
                                setAuthorizeStatus(authorizationViewHolder.mBtnAuthorizeStatus, R.string.str_user_info, R.drawable.shape_authorize_status, R.color.colorTitle);
                            }
                            String strUserInfo = TextUtils.format("", userInfo);
                            ShowUserInfoActivity.newInstance(activity, platform.getName(), strUserInfo);
                        }
                    });
                    //添加监听事件，用户信息在回调事件中返回
                    platform.setPlatformActionListener(platformActionListener);
                    //获取用户信息
                    platform.showUser(null);
                }
            });
            authorizationViewHolder.mTvPlatformName.setText(platformEntity.getName());
            authorizationViewHolder.mImgPlatformIcon.setImageResource(platformEntity.getIcon());
        }
    }

    @Override
    public int getItemCount() {
        if (platformEntityList == null) {
            return 0;
        }
        return platformEntityList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (platformEntityList == null) {
            return 0;
        }
        return platformEntityList.get(position).getType();
    }

    /**
     * 标题
     */
    class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        TitleViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.titleTxt);
        }
    }

    class AuthorizationViewHolder extends RecyclerView.ViewHolder {
        TextView mTvPlatformName;
        ImageView mImgPlatformIcon;
        Button mBtnAuthorizeStatus;

        AuthorizationViewHolder(View itemView) {
            super(itemView);
            mTvPlatformName = itemView.findViewById(R.id.tv_authorize_platform_name);
            mImgPlatformIcon = itemView.findViewById(R.id.img_authorize_platform_icon);
            mBtnAuthorizeStatus = itemView.findViewById(R.id.btn_authorize_status);
        }
    }
}
