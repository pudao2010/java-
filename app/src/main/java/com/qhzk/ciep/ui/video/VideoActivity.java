package com.qhzk.ciep.ui.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.base.BaseActivity;
import com.qhzk.ciep.entity.VideoEntity;
import com.qhzk.ciep.library_ijkplayer.media.IjkVideoView;
import com.qhzk.ciep.utils.AnimUtil;
import com.qhzk.ciep.utils.ServiceUtil;
import com.qhzk.ciep.utils.StateBarTranslucentUtil;
import com.qhzk.ciep.view.ShareDialog;
import com.qhzk.ciep.widget.CommentBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Thisdk on 2016/9/5.
 *
 */

public class VideoActivity extends BaseActivity implements VideoPlayer.VideoPlayerCallback {

    private static final String BUNDLE_VIDEO = "BUNDLE_VIDEO";

    @BindView(R.id.ijkvideoview)
    IjkVideoView mIjkvideoview;
    @BindView(R.id.button_play)
    ImageButton mButtonPlay;
    @BindView(R.id.seekbar)
    AppCompatSeekBar mSeekbar;
    @BindView(R.id.start_time)
    TextView mStartTime;
    @BindView(R.id.totle_time)
    TextView mTotleTime;
    @BindView(R.id.button_fullscreen)
    ImageButton mButtonFullscreen;
    @BindView(R.id.toolbar_title)
    TextView mToolbarTitle;
    @BindView(R.id.toolbar_share)
    ImageButton mToolbarShare;
    @BindView(R.id.thumbnail)
    ImageView mThumbnail;
    @BindView(R.id.loading_progress)
    ProgressBar mLoadingProgress;
    @BindView(R.id.video_footer_layout)
    LinearLayout mVideoFooterLayout;
    @BindView(R.id.video_layout)
    FrameLayout mVideoLayout;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.share)
    ImageView mShare;
    @BindView(R.id.activity_comments)
    CoordinatorLayout mCoorLayout;
    private VideoPlayer mVideoPlayer;
    private boolean mIsHide = false;
    private CommentBar mDelegation;
    private boolean mIsPortrait;
    private View mStatusBarView;
    private int mVideoViewInitHeight;
    private VideoIntent mVideo;
    private VideoEntity mVideoEntity;

    private int mStatusBarHeight;
    private String playUrl;


    @Override
    public int getLayoutId() {
        return R.layout.activity_video;
    }

    // 扫描二维码过来
    public static Bundle newBundle(VideoIntent videoIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_VIDEO, videoIntent);
        return bundle;
    }

    // 由新闻中心跳转过来
    public static Bundle newBundle(VideoEntity videoEntity) {
        VideoIntent videoIntent = new VideoIntent(
                ServiceUtil.subImageUrl(videoEntity.getVideopath()),
                videoEntity.getTitle(), videoEntity.getSubtitle());
        Bundle bundle = new Bundle();
        bundle.putParcelable(BUNDLE_VIDEO, videoIntent);
        return bundle;
    }

    @OnClick(R.id.share)
    public void onClick() {
        // 弹出分享对话框
        shareToThird();
    }

    private void shareToThird() {
        ShareDialog shareDialog = new ShareDialog(this);
        shareDialog.setTitle(mVideo.title);
        if (mVideo.playUrl != null) {
            shareDialog.setUrl(mVideo.playUrl);
        }else {
            shareDialog.setUrl(playUrl);
        }

        shareDialog.show();
    }

    public static class VideoIntent implements Parcelable {

        private String playUrl;
        private String title;
        private String subTitle;

        public VideoIntent(String playUrl, String title, String subTitle) {
            this.playUrl = playUrl;
            this.title = title;
            this.subTitle = subTitle;
        }

        public VideoIntent() {
        }

        public VideoIntent(String playUrl) {
            this.playUrl = playUrl;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }


        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.playUrl);
            dest.writeString(this.title);
            dest.writeString(this.subTitle);
        }

        protected VideoIntent(Parcel in) {
            this.playUrl = in.readString();
            this.title = in.readString();
            this.subTitle = in.readString();
        }

        public static final Creator<VideoIntent> CREATOR = new Creator<VideoIntent>() {
            @Override
            public VideoIntent createFromParcel(Parcel source) {
                return new VideoIntent(source);
            }

            @Override
            public VideoIntent[] newArray(int size) {
                return new VideoIntent[size];
            }
        };
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        mVideo = savedInstanceState.getParcelable(BUNDLE_VIDEO);
        playUrl = mVideo.getPlayUrl();
    }

    @Override
    protected void initview() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mIsPortrait) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else finish();
            }
        });
        mIsPortrait = true;
        StateBarTranslucentUtil.setStateBarTranslucent(this);
        mStatusBarView = StateBarTranslucentUtil.setupStatusBarView(this, (ViewGroup) findViewById(android.R.id.content));
        mVideoViewInitHeight = mVideoLayout.getLayoutParams().height;
        mStatusBarHeight = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        setToolbarMargin(mStatusBarHeight);
        switchScreenStatus();
        // 添加评论条
        mDelegation = CommentBar.delegation(this, mCoorLayout);
        mDelegation.getBottomSheet().setCommitListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSendComment();
            }
        });
        mDelegation.setShareListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareToThird();
            }
        });
        mDelegation.getBottomSheet().getEditText().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    mDelegation.getCommentText().setHint("发表评论");
                    mDelegation.getBottomSheet().getEditText().setHint("发表评论");
                }
                return false;
            }
        });
    }

    private void handleSendComment() {

    }

    @Override
    protected void initdata() {
        super.initdata();
        mVideoPlayer = new VideoPlayer(this, mVideoLayout, mIjkvideoview);
        mVideoPlayer.setSeekBar(mSeekbar);
        mVideoPlayer.setVideoPlayerCallback(this);
        mVideoPlayer.setTextView(mStartTime, mTotleTime);
        mVideoPlayer.setPlayButton(mButtonPlay);
        mVideoPlayer.play(mVideo.getPlayUrl());
        mToolbarTitle.setText(mVideo.getSubTitle());
        mTitle.setText(mVideo.getTitle());

    }

    public void hideLayout() {
        if (mIsPortrait) {
            mVideoFooterLayout.startAnimation(AnimUtil.getVideoViewDownTranslateAnim());
        } else {
            mVideoFooterLayout.startAnimation(AnimUtil.getVideoViewDownTranslateAnim());
            mToolbar.startAnimation(AnimUtil.getVideoViewUpTranslateAnim15f());
            mStatusBarView.startAnimation(AnimUtil.getVideoViewUpTranslateAnim());
            WindowManager.LayoutParams attrs = getWindow().getAttributes();
            attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
            getWindow().setAttributes(attrs);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        mIsHide = true;
    }

    public void showLayout() {
        if (mIsPortrait) {
            mVideoFooterLayout.startAnimation(AnimUtil.getVideoViewDownRecTranslateAnim());
        } else {
            mVideoFooterLayout.startAnimation(AnimUtil.getVideoViewDownRecTranslateAnim());
            mToolbar.startAnimation(AnimUtil.getVideoViewUpRecTranslateAnim15f());
            mStatusBarView.startAnimation(AnimUtil.getVideoViewUpRecTranslateAnim());
            WindowManager.LayoutParams attrs = getWindow().getAttributes();
            attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().setAttributes(attrs);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        mIsHide = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoPlayer.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mVideoPlayer.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mVideoPlayer.onDestroy();
    }

    @OnClick({R.id.button_fullscreen})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_fullscreen:
                if (mIsPortrait) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                } else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }
                break;
        }
    }

    @Override
    public void onPrepared() {
        mThumbnail.setVisibility(View.INVISIBLE);
        mLoadingProgress.setVisibility(View.INVISIBLE);
    }


    private void switchScreenStatus() {
        if (mIsPortrait) {
            mStatusBarView.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mToolbar.setBackgroundColor(Color.TRANSPARENT);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mVideoLayout.getLayoutParams();
            params.weight = LinearLayout.LayoutParams.MATCH_PARENT;
            params.height = mVideoViewInitHeight;
            params.setMargins(0, mStatusBarHeight, 0, 0);
            mVideoLayout.setLayoutParams(params);
            mButtonFullscreen.setBackground(AppCompatDrawableManager.get().getDrawable(this, R.drawable.icon_fullscreen));
            mToolbarTitle.setVisibility(View.INVISIBLE);
            mToolbarShare.setVisibility(View.INVISIBLE);
            // 显示评论条( 第一次不能调用, 会空指针 )
            if (mDelegation != null) {
                mDelegation.showCommentBar();
            }
        } else {
            mStatusBarView.setBackgroundColor(0xAA000000);
            mToolbar.setBackgroundColor(0xAA000000);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) mVideoLayout.getLayoutParams();
            params.weight = LinearLayout.LayoutParams.MATCH_PARENT;
            params.height = LinearLayout.LayoutParams.MATCH_PARENT;
            params.setMargins(0, 0, 0, 0);
            mVideoLayout.setLayoutParams(params);
            mButtonFullscreen.setBackground(AppCompatDrawableManager.get().getDrawable(this, R.drawable.icon_fullscreen_exit));
            mToolbarTitle.setVisibility(View.VISIBLE);
            mToolbarShare.setVisibility(View.VISIBLE);
            // 隐藏评论条
            if (mDelegation != null) {
                mDelegation.hideCommentBar();
            }
        }
    }

    private void setToolbarMargin(int stateBarHeight) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) mToolbar.getLayoutParams();
        params.setMargins(0, stateBarHeight, 0, 0);
        mToolbar.setLayoutParams(params);
    }

    public int getScreenOrientation() {
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int orientation;
        if ((rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180) && height > width || (rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270) && width > height) {
            switch (rotation) {
                case Surface.ROTATION_0:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    break;
                case Surface.ROTATION_90:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                    break;
                case Surface.ROTATION_180:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                    break;
                case Surface.ROTATION_270:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                    break;
                default:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    break;
            }
        } else {
            switch (rotation) {
                case Surface.ROTATION_0:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                    break;
                case Surface.ROTATION_90:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                    break;
                case Surface.ROTATION_180:
                    orientation =
                            ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                    break;
                case Surface.ROTATION_270:
                    orientation =
                            ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                    break;
                default:
                    orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                    break;
            }
        }
        return orientation;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && !mIsPortrait) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (mIsHide) {
            mVideoPlayer.setHideStatus(false);
            showLayout();
        }
        mIsPortrait = (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        switchScreenStatus();
    }

}
