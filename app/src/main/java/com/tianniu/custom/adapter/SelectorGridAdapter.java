package com.tianniu.custom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianniu.custom.model.LocationInfo;
import com.tianniu.custom.utils.ScreenUtil;
import com.tianniu.up.testprogect.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/8 0008.
 */

public class SelectorGridAdapter extends  RecyclerView.Adapter{
    private Context mContext;
    private List<LocationInfo> mItemInfos = new ArrayList<>();

    /**
     * 选择的字符
     */
    private String mSelectedStr;

    private OnItemClickListener onItemClickListener;

    public SelectorGridAdapter(Context mContext, List<LocationInfo> infos, String selected, OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        mItemInfos.clear();
        if (infos != null){
            mItemInfos.addAll(infos);
        }
        this.mSelectedStr =selected;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.pop_text_item, parent, false);
        TextView areaTv = (TextView) itemView.findViewById(R.id.tv_area_info);
        int textSize = ScreenUtil.px2dip(mContext, 20);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        View itemView = holder.itemView;
        TextView textView = (TextView)itemView.findViewById(R.id.tv_area_info);
        String contentStr = mItemInfos.get(position).getName();
        textView.setPressed(contentStr.equals(mSelectedStr));
        textView.setText(contentStr);
        setListener(holder);
    }

    @Override
    public int getItemCount() {
        return mItemInfos.size();
    }

    private void setListener(final RecyclerView.ViewHolder holder){
        if (onItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onAreaItemClickListener(holder.itemView,mItemInfos.get(holder.getAdapterPosition()));
                }
            });
        }
    }



    public void updateData(List<LocationInfo> infos, String selected) {
        mItemInfos.clear();
        if (infos != null){
            mItemInfos.addAll(infos);
        }
        this.mSelectedStr =selected;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
