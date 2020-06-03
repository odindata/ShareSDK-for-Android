package com.odin.share.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.List;

import cn.odinshare.core.Platform;

/**
 * 授权登录Adapter.
 */
public class AuthorizationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private BaseActivity activity;
    private LayoutInflater layoutInflater;
    private List<PlatformEntity> authorEntityList;

    public AuthorizationAdapter(BaseActivity activity, List<PlatformEntity> authorEntityList) {
        this.activity = activity;
        this.authorEntityList = authorEntityList;
        this.layoutInflater = LayoutInflater.from(activity);
    }

    @Override
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ShareType.TITLE_SHARE_PLAT) {
            View view = layoutInflater.inflate(R.layout.item_title, parent, false);
            return new TitleViewHolder(view);
        } else {
            View view = layoutInflater.inflate(R.layout.item_authorization, parent, false);
            return new AuthorizationViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final PlatformEntity platformEntity = authorEntityList.get(position);
        final Platform platform = authorEntityList.get(position).getPlatform();
        //标题
        if (holder instanceof TitleViewHolder) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
            titleViewHolder.textView.setText(platformEntity.getName());
        }
        //各个收授权平台
        if (holder instanceof AuthorizationViewHolder) {
            final AuthorizationViewHolder viewHolder = (AuthorizationViewHolder) holder;
            if (platform.isAuthValid()) {
                setAuthorizeStatus(viewHolder.mBtnAuthorizeStatus, R.string.str_authorization_delete, R.drawable.shape_user_info_status, R.color.colorWhite);
            } else {
                setAuthorizeStatus(viewHolder.mBtnAuthorizeStatus, R.string.str_authorization, R.drawable.shape_authorize_status, R.color.colorTitle);
            }
            viewHolder.mBtnAuthorizeStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //判断是否已经授权过
                    if (platform.isAuthValid()) {
                        //取消授权
                        platform.removeAccount(true);

                        setAuthorizeStatus(viewHolder.mBtnAuthorizeStatus, R.string.str_authorization, R.drawable.shape_authorize_status, R.color.colorTitle);
                        Toast.makeText(activity, "已取消授权", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    //自定义一个PlatformActionListener，用于处理成功或失败的回调事件
                    OdinPlatformActionListener listener = new OdinPlatformActionListener(activity);
                    listener.setOnCompleteListener(new OdinPlatformActionListener.OnCompleteListener() {
                        @Override
                        public void onComplete(HashMap<String, Object> res) {
                            setAuthorizeStatus(viewHolder.mBtnAuthorizeStatus, R.string.str_authorization_delete, R.drawable.shape_user_info_status, R.color.colorWhite);
                        }
                    });
                    //添加授权的监听事件，授权成功、失败和取消在回调事件中返回
                    platform.setPlatformActionListener(listener);
                    //进行第三方授权操作
                    platform.authorize();
                    //指定平台授权可以采用以下方法进行
                    //OdinShareSDK.doAuthorize(OdinShareSDK.PLATFORM_QQ, listener);
                }
            });
            viewHolder.mTvPlatformName.setText(platformEntity.getName());
            viewHolder.mImgPlatformIcon.setImageResource(platformEntity.getIcon());
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
    public int getItemCount() {
        return authorEntityList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (authorEntityList == null) {
            return 0;
        }
        return authorEntityList.get(position).getType();
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

    /**
     * 授权
     */
    class AuthorizationViewHolder extends RecyclerView.ViewHolder {
        ImageView mImgPlatformIcon;
        TextView mTvPlatformName;
        Button mBtnAuthorizeStatus;

        AuthorizationViewHolder(View itemView) {
            super(itemView);
            mTvPlatformName = itemView.findViewById(R.id.tv_authorize_platform_name);
            mImgPlatformIcon = itemView.findViewById(R.id.img_authorize_platform_icon);
            mBtnAuthorizeStatus = itemView.findViewById(R.id.btn_authorize_status);
        }
    }
}
