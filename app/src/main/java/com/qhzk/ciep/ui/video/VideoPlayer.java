package com.qhzk.ciep.ui.video;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qhzk.ciep.R;
import com.qhzk.ciep.library_ijkplayer.media.IjkVideoView;

import java.util.Locale;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Thisdk on 2016/9/6.
 */

public class VideoPlayer implements IMediaPlayer.OnPreparedListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener, IMediaPlayer.OnCompletionListener {

    private Activity mActivity;

    private IjkVideoView mIjkvideoview;

    private Handler mPlayHandler;
    private PlayRunnable mPlayRunnable;

    private IMediaPlayer mMediaPlayer;

    private AppCompatSeekBar mAppCompatSeekBar;
    private TextView mCurrentTime, mTotleTime;
    private VideoPlayerCallback mVideoPlayerCallback;

    private long mTotleDuration;
    private long mCurrentDuration;

    private boolean mIsTouchSeekBar;
    private ImageButton mPlayButton;
    private View mRootLayout;
    private boolean mIsPlay;

    private int mStopMis;
    private boolean mIsHideTheLayout;

    private long mSaveProgress;
    private boolean mSavePlayStatus;

    private boolean mIsFirst = true;

    private boolean mIsEnd;


    public VideoPlayer(Activity activity, View rootLayout, IjkVideoView imIjkvideoview) {
        mActivity = activity;
        mRootLayout = rootLayout;
        mIjkvideoview = imIjkvideoview;
        init();
    }

    private void init() {
        if (mIjkvideoview == null) {
            throw new NullPointerException("ijkvideoview is null");
        }
        try {
            IjkMediaPlayer.loadLibrariesOnce(null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        } catch (Exception e) {
            Log.e(TAG, "init", e);
        }

        mIjkvideoview.setOnPreparedListener(this);
        mIjkvideoview.setOnCompletionListener(this);

        mRootLayout.setOnClickListener(this);

        mPlayHandler = new Handler(Looper.getMainLooper());
        mPlayRunnable = new PlayRunnable();
    }


    @Override
    public void onPrepared(IMediaPlayer iMediaPlayer) {
        mMediaPlayer = iMediaPlayer;
        mTotleDuration = mMediaPlayer.getDuration();
        if (mTotleTime != null) {
            mTotleTime.setText(formatTime(mTotleDuration));
        }
        if (mVideoPlayerCallback != null) {
            mVideoPlayerCallback.onPrepared();
        }
        mMediaPlayer.start();
        mIsPlay = true;
        mIsEnd = false;
    }

    public void play(String url) {
        mIjkvideoview.setVideoURI(Uri.parse(url));
    }

    public void setSeekBar(AppCompatSeekBar appCompatSeekBar) {
        mAppCompatSeekBar = appCompatSeekBar;
        mAppCompatSeekBar.setMax(1000);
        mAppCompatSeekBar.setOnSeekBarChangeListener(this);
    }

    public void setVideoPlayerCallback(VideoPlayerCallback videoPlayerCallback) {
        mVideoPlayerCallback = videoPlayerCallback;
    }

    public void setTextView(TextView currentTime, TextView totleTime) {
        mCurrentTime = currentTime;
        mTotleTime = totleTime;
    }

    public void setPlayButton(ImageButton playButton) {
        mPlayButton = playButton;
        mPlayButton.setOnClickListener(this);
    }

    private String formatTime(long time) {
        int totalSeconds = (int) (time / 1000);
        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;
        return hours > 0 ? String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)
                : String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }

    public void onResume() {
        mPlayHandler.postDelayed(mPlayRunnable, 1000);
        mIsPlay = true;
        setPlayButtonStatus();
        if (mIsFirst) {
            mIsFirst = false;
            return;
        }
        mIjkvideoview.resume();
        if (!mIsEnd) {
            mIjkvideoview.seekTo((int) mSaveProgress);
            if (!mSavePlayStatus) {
                mMediaPlayer.pause();
            }
        } else {
            mIsEnd = false;
        }
    }

    public void onPause() {
        mPlayHandler.removeCallbacks(mPlayRunnable);
        mIsPlay = false;
        setPlayButtonStatus();
        if (mMediaPlayer != null) {
            saveCurrentStatus();
        }
        mIjkvideoview.suspend();
    }

    public void saveCurrentStatus() {
        mSavePlayStatus = mIjkvideoview.isPlaying();
        mSaveProgress = mMediaPlayer.getCurrentPosition();
    }

    public void onDestroy() {
        mIjkvideoview.stopPlayback();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (mIsTouchSeekBar && fromUser) {
            mStopMis = 0;
            mCurrentDuration = (long) (progress / 1000.00f * mTotleDuration);
            updateView();
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        if (!mIjkvideoview.isPlaying()) return;
        mIsTouchSeekBar = true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if (mIsTouchSeekBar) {
            mIsTouchSeekBar = false;
            mIjkvideoview.seekTo((int) mCurrentDuration);
        }
    }

    private void updateView() {
        if (mCurrentTime != null) {
            mCurrentTime.setText(formatTime(mCurrentDuration));
        }
    }

    public void setHideStatus(boolean isHide) {
        mIsHideTheLayout = isHide;
        mStopMis = 0;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_layout:
                if (!mIsHideTheLayout) {
                    mIsHideTheLayout = true;
                    if (mVideoPlayerCallback != null) mVideoPlayerCallback.hideLayout();
                } else {
                    mStopMis = 0;
                    mIsHideTheLayout = false;
                    if (mVideoPlayerCallback != null) mVideoPlayerCallback.showLayout();
                }
                break;

            case R.id.button_play:
                if (mIsEnd) {
                    mIsEnd = false;
                }
                mIsPlay = !mIsPlay;
                setPlayButtonStatus();
                if (mIsPlay) {
                    mMediaPlayer.start();
                } else {
                    mMediaPlayer.pause();
                }
                break;
        }
    }

    private void setPlayButtonStatus() {
        if (mIsPlay) {
            mPlayButton.setBackground(AppCompatDrawableManager.get().getDrawable(mActivity, R.drawable.icon_pause));
        } else {
            mPlayButton.setBackground(AppCompatDrawableManager.get().getDrawable(mActivity, R.drawable.icon_play_circle));
        }

    }

    @Override
    public void onCompletion(IMediaPlayer iMediaPlayer) {
        mIsPlay = false;
        mIsEnd = true;
        setPlayButtonStatus();
    }

    private class PlayRunnable implements Runnable {

        @Override
        public void run() {
            if (mMediaPlayer != null) {
                if (!mIsTouchSeekBar) {
                    mCurrentDuration = mMediaPlayer.getCurrentPosition();
                    if (mAppCompatSeekBar != null) {
                        long pos = (long) (mCurrentDuration * 1.00f / mTotleDuration * 1000.00f);
                        mAppCompatSeekBar.setProgress((int) pos);
                        mAppCompatSeekBar.setSecondaryProgress(mIjkvideoview.getBufferPercentage() * 10);
                    }
                    updateView();
                }
                if (!mIsHideTheLayout) {
                    mStopMis++;
                    if (mStopMis == 5) {
                        mIsHideTheLayout = true;
                        if (mVideoPlayerCallback != null) mVideoPlayerCallback.hideLayout();
                    }
                    if (mStopMis > 5) {
                        mStopMis = 1;
                    }
                }
            }
            mPlayHandler.postDelayed(this, 1000);
        }
    }

    public interface VideoPlayerCallback {
        void onPrepared();

        void hideLayout();

        void showLayout();
    }

}
