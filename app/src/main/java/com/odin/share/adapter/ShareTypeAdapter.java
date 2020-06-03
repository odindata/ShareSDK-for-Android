package com.odin.share.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.odin.share.R;
import com.odin.share.adapter.listener.OnItemClickListener;
import com.odin.share.entity.ShareType;

import java.util.List;

/**
 * 分享类型的Adapter
 */
public class ShareTypeAdapter extends RecyclerView.Adapter<ShareTypeAdapter.ShareTypeViewHolder> {

    private List<Integer> shareTypeList;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;

    public ShareTypeAdapter(Context context, List<Integer> shareTypeList) {
        this.shareTypeList = shareTypeList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void setOnClickItemListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    @NonNull
    public ShareTypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_share_type, parent, false);
        return new ShareTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShareTypeViewHolder viewHolder, final int position) {
        final int shareType = shareTypeList.get(position);
        viewHolder.shareTypeIcon.setImageResource(ShareType.getPlatformIcon(shareType));
        viewHolder.shareTypeName.setText(ShareType.getPlatformName(shareType));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(v, shareType);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (shareTypeList == null) {
            return 0;
        }
        return shareTypeList.size();
    }

    class ShareTypeViewHolder extends RecyclerView.ViewHolder {
        ImageView shareTypeIcon;
        TextView shareTypeName;
        RelativeLayout rootView;

        ShareTypeViewHolder(View itemView) {
            super(itemView);
            shareTypeIcon = itemView.findViewById(R.id.img_share_icon);
            shareTypeName = itemView.findViewById(R.id.tv_share_type);
            rootView = itemView.findViewById(R.id.rootView);
        }
    }
}
