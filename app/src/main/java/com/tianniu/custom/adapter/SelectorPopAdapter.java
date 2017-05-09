package com.tianniu.custom.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tianniu.custom.model.LocationInfo;
import com.tianniu.up.testprogect.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/8 0008.
 */

public class SelectorPopAdapter extends  RecyclerView.Adapter{
    private Context mContext;
    private List<LocationInfo> mItemInfos;

    /**
     * 选择的字符
     */
    private String mSelectedStr;

    private OnItemClickListener onItemClickListener;

    public SelectorPopAdapter(Context mContext, List<LocationInfo> infos,String selected,OnItemClickListener onItemClickListener) {
        this.mContext = mContext;
        this.mItemInfos = infos;
        this.mSelectedStr =selected;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View itemView = layoutInflater.inflate(R.layout.pop_recruitment_and_job_hunting_item, parent, false);
        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(100, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(layoutParams);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextView itemTvView = (TextView) holder.itemView;
//        TextView textView = (TextView)itemView.findViewById(R.id.pop_recruitment_item);

        String contentStr = mItemInfos.get(position).getName();
        itemTvView.setPressed(contentStr.equals(mSelectedStr));
        itemTvView.setText(contentStr);
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
                    //TODO 图片背景
                    holder.itemView.setBackgroundResource(R.color.mi_ripple_color);
                    onItemClickListener.onItemClickListener(holder.itemView,mItemInfos.get(holder.getAdapterPosition()));
                }
            });
        }

    }



    public void updateData(List<LocationInfo> infos, String selected) {
        this.mItemInfos = infos;
        this.mSelectedStr =selected;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
