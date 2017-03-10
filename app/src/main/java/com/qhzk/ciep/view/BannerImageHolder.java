package com.qhzk.ciep.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;

/**
 * Created by Thisdk on 2016/9/1.
 */

public class BannerImageHolder implements Holder<String> {

    private ImageView mImageView;

    @Override
    public View createView(Context context) {
        mImageView = new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String url) {
        Glide.with(context).load(url).into(mImageView);
    }

}
