package com.qhzk.ciep.ui.notice;

import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.Notice;
import com.qhzk.ciep.mvp.BasePresenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by pucheng on 2017/1/4.
 *
 */

public class ConferenceNoticePresenter extends BasePresenter<ConferenceNoticeView> {

    private int page = 1;

    public void loadData(int page, int rows, String mid) {
        mApi.getNotices(page, rows, mid, new ResultSubscriber<Notice>(this) {
            @Override
            public void onSuccess(Notice notice) {
                List<Notice.RowsBean> list = notice.getRows();
                if (list != null) {
                    Collections.sort(list, (o1, o2) -> {
                        String time1 = o1.getCreatetime();
                        String time2 = o2.getCreatetime();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                        try {
                            Date date1 = sdf.parse(time1);
                            Date date2 = sdf.parse(time2);
                            return date2.compareTo(date1);
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    });
                    getMvpView().onLoadSuccess(list);
                }
            }
        });
    }

    public void loadMore(String mid) {
        mApi.getNotices(++page, 20, mid, new ResultSubscriber<Notice>(this) {
            @Override
            public void onSuccess(Notice notice) {
                List<Notice.RowsBean> list = notice.getRows();
                if (list != null) {
                    if (list.size()<20){
                        getMvpView().onLoadNoMore(list);
                    }else {
                        getMvpView().onLoadHasMore(list);
                    }
                }
            }
        });
    }
}
