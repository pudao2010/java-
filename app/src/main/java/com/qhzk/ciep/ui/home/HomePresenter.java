package com.qhzk.ciep.ui.home;


import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.entity.CompicEntity;
import com.qhzk.ciep.entity.MyMeeting;
import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.entity.Notice;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.utils.ServiceUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Thisdk on 2016/9/1.
 *
 */

public class HomePresenter extends BasePresenter<HomeView> {

    public void getMarqueesData() {
        mApi.getNotices(1, 20, "confnotice", new ResultSubscriber<Notice>(this) {
            @Override
            public void onSuccess(Notice notice) {
                List<Notice.RowsBean> list = notice.getRows();
                List<String> result = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    result.add(list.get(i).getTitle());
                }
                getMvpView().onMarqueesResult(result);
            }
        });
    }

    /**
     * 获取轮播图的数据
     */
    public void getBannersData() {
        mApi.getCompic(new ResultSubscriber<List<CompicEntity>>(this) {
            @Override
            public void onSuccess(List<CompicEntity> compicEntities) {
                if (compicEntities != null) {
                    List<String> list = new ArrayList<>();
                    for (CompicEntity compic : compicEntities) {
                        if (compic != null && "1".equals(compic.getIsshow())) {
                            list.add(ServiceUtil.subImageUrl(compic.getLogopath()));
                        }
                        System.out.println("轮播图地址======"+list);
                    }
                    getMvpView().onBannerResult(list);
                }
            }
        });
    }

    /**
     * 获取新闻条目的数据
     */
    public void getNewItemData() {
        mApi.getNews(1, 10, "newscenter", new ResultSubscriber<List<NewEntity>>(this) {
            @Override
            public void onSuccess(List<NewEntity> newEntities) {
                List<HomeFragment.NewItem> list = new ArrayList<>();
                for (NewEntity news : newEntities) {
                    list.add(new HomeFragment.NewItem(ServiceUtil.subImageUrl(news.getPcimg())
                            , news.getTitle()
                            , news.getCreatetime()
                    ));
                }

                Collections.sort(newEntities, (o1, o2) -> {
                    String date1 = o1.getCreatetime();
                    String date2 = o2.getCreatetime();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                    try {
                        Date data1 = sdf.parse(date1);
                        Date data2 = sdf.parse(date2);
                        return data2.compareTo(data1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0;
                    }
                });
                Collections.sort(list, (o1, o2) -> {
                    String date1 = o1.getDate();
                    String date2 = o2.getDate();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                    try {
                        Date data1 = sdf.parse(date1);
                        Date data2 = sdf.parse(date2);
                        return data2.compareTo(data1);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0;
                    }
                });
                getMvpView().onNewItemResult(list);
                getMvpView().onNewItemResults(newEntities);
            }
        });

    }

    public void checkIsAttend(){
        mApi.getMyMeetings(new ResultSubscriber<List<MyMeeting>>(this) {
            @Override
            public void onSuccess(List<MyMeeting> myMeetings) {
                if (myMeetings != null) {
                    if (myMeetings.size() >= 1){
                        getMvpView().onCheckIsAttend(true);
                    } else {
                        getMvpView().onCheckIsAttend(false);
                    }
                }else {
                    getMvpView().onCheckIsAttend(false);
                }
            }
        });
    }

}
