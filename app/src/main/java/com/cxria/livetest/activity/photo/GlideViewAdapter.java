package com.cxria.livetest.activity.photo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cxria.livetest.R;

import java.util.ArrayList;

/**
 * Created by yukun on 17-1-19.
 */
public class GlideViewAdapter extends BaseAdapter {
    ArrayList<ImageDetail> strings;
    Context context;
    CheckCheckbox mCheckCheckbox;

    public void setCheckCheckbox(CheckCheckbox checkCheckbox) {
        mCheckCheckbox = checkCheckbox;
    }

    public GlideViewAdapter(Context context, ArrayList<ImageDetail> strings) {
        this.strings = strings;
        this.context = context;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewHolder;
        ImageDetail imageDetail = strings.get(position);
//        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.gride_item, null);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.mCheckBox= (CheckBox) convertView.findViewById(R.id.cb_choice);
            viewHolder.mCheckBox.setVisibility(View.VISIBLE);
            convertView.setTag(viewHolder);
//        }else{
//            viewHolder = (ViewHolder) convertView.getTag();
//        }

        viewHolder.mImageView.setImageBitmap(null);
        Glide.with(context).load(imageDetail.getImagePath()).into(viewHolder.mImageView);
        if(imageDetail.getChecked()==false){
            viewHolder.mCheckBox.setChecked(false);
        }else {
            viewHolder.mCheckBox.setChecked(true);
        }
        viewHolder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCheckCheckbox.checkCheckboxCallBacks(position,isChecked);
            }
        });
        return convertView;
    }

    public static class ViewHolder{
        public ImageView mImageView;
        public CheckBox mCheckBox;
    }

    public interface CheckCheckbox{
        void checkCheckboxCallBacks(int position, boolean isChecked);
    }
}
