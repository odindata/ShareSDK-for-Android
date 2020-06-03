package com.odin.share.adapter;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.share.adapter.listener.OnItemClickListener;
import com.odin.share.adapter.listener.OnScreenshotClickListener;
import com.odin.share.base.BaseActivity;
import com.odin.share.R;
import com.odin.share.entity.PlatformEntity;
import com.odin.share.Constant;
import com.odin.share.entity.ShareType;
import com.odin.share.platform.OdinPlatformActionListener;

import java.util.List;

import cn.odinshare.odinonekeyshare.OneKeyShare;

/**
 * 分享平台的Adapter
 */
public class SharePlatformAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private BaseActivity activity;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    private OnScreenshotClickListener screenshotClickListener;

    private List<PlatformEntity> platformEntityList;

    /**
     * 点击各个平台的item时的回调事件
     *
     * @param onItemClickListener 回调事件
     */
    public void setOnItemListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnScreenshotClickListener(OnScreenshotClickListener screenshotClickListener) {
        this.screenshotClickListener = screenshotClickListener;
    }

    public SharePlatformAdapter(BaseActivity activity, List<PlatformEntity> platformEntityList) {
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
        } else if (viewType == ShareType.DIRECT_SHARE_PLAT) {
            View view = layoutInflater.inflate(R.layout.item_share_onekey, parent, false);
            return new OneKeyShareViewHolder(view);
        } else {
            View view = layoutInflater.inflate(R.layout.item_share_platform, parent, false);
            return new PlatformShareViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        //内容的标题
        if (holder instanceof TitleViewHolder) {
            TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
            titleViewHolder.textView.setText(platformEntityList.get(position).getName());
        }
        //一键分享和截图分享
        if (holder instanceof OneKeyShareViewHolder) {
            OneKeyShareViewHolder oneKeyShareViewHolder = (OneKeyShareViewHolder) holder;
            oneKeyShareViewHolder.mLlOneKeyShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    oneKeyShare();
                }
            });
            oneKeyShareViewHolder.mLlScreenshotShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(screenshotClickListener !=null) {
                        screenshotClickListener.onScreenshot(v, position);
                    }
                }
            });
        }
        //国内外分享
        if (holder instanceof PlatformShareViewHolder) {
            final PlatformShareViewHolder platformShareViewHolder = (PlatformShareViewHolder) holder;
            platformShareViewHolder.platformIcon.setImageResource(platformEntityList.get(position).getIcon());
            platformShareViewHolder.platformName.setText(platformEntityList.get(position).getName());
            platformShareViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(platformShareViewHolder.itemView, platformShareViewHolder.getLayoutPosition());
                }
            });
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

    /**
     * 一键分享和截图分享
     */
    class OneKeyShareViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLlOneKeyShare;
        LinearLayout mLlScreenshotShare;

        OneKeyShareViewHolder(View itemView) {
            super(itemView);
            mLlOneKeyShare = itemView.findViewById(R.id.ll_one_key_share);
            mLlScreenshotShare = itemView.findViewById(R.id.ll_screenshot_share);
        }
    }

    /**
     * 分享平台
     */
    class PlatformShareViewHolder extends RecyclerView.ViewHolder {
        ImageView platformIcon;
        TextView platformName;
        RelativeLayout rootView;

        PlatformShareViewHolder(View itemView) {
            super(itemView);
            platformIcon = itemView.findViewById(R.id.img_platform_icon);
            platformName = itemView.findViewById(R.id.tv_platform_name);
            rootView = itemView.findViewById(R.id.rl_share_content_root);
        }
    }

    /**
     * 打开一键UI分享界面，用户选择相应的平台进行分享操作
     */
    private void oneKeyShare() {
        //分享一个web页面
        new OneKeyShare()
                .setUrl(Constant.WEBPAGE_URL)
                .setTitle(Constant.TITLE_TEXT)
                .setText(Constant.TEXT)
                .setImageData(BitmapFactory.decodeResource(activity.getResources(), R.mipmap.ic_launcher))
                .setPlatformActionListener(new OdinPlatformActionListener(activity))
                .show(activity);
    }
}
