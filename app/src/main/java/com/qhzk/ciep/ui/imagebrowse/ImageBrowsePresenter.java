package com.qhzk.ciep.ui.imagebrowse;

import android.content.Intent;

import java.util.List;

/**
 * Created by pucheng on 2017年1月9日16:04:20.
 * 图片浏览presenter层, 持有View层的引用
 */
public class ImageBrowsePresenter {

    private ImageBrowseView mImageBrowseView;
    private List<String> images;
    private int position;

    public ImageBrowsePresenter(ImageBrowseView view) {
        mImageBrowseView = view;
    }

    public void loadImage(){
        Intent intent = mImageBrowseView.getDataIntent();
        images = intent.getStringArrayListExtra("images");
        position = intent.getIntExtra("position",0);
        mImageBrowseView.setImageBrowse(images,position);
    }

    public List<String> getImages() {
        return images;
    }

    public void setPosition(int position) {
        this.position = position;
    }


}

