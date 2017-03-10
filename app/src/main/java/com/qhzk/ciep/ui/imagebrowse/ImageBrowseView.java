package com.qhzk.ciep.ui.imagebrowse;

import android.content.Intent;

import java.util.List;

/**
 * Created by pucheng on 2017年1月9日19:08:25
 * View层接口
 */
public interface ImageBrowseView {

    Intent getDataIntent();

    void setImageBrowse(List<String> images, int position);

}
