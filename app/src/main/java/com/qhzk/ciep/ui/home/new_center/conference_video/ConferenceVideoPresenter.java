package com.qhzk.ciep.ui.home.new_center.conference_video;

import com.qhzk.ciep.entity.CiepVideo;
import com.qhzk.ciep.entity.ConfVideoEntity;
import com.qhzk.ciep.mvp.BasePresenter;
import com.qhzk.ciep.protocol.BaseProtocol;
import com.qhzk.ciep.protocol.CiepVideoProtocol;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.Call;

/**
 * Created by Administrator on 2016/12/16.
 */

public class ConferenceVideoPresenter extends BasePresenter<ConferenceVideoView> {
    public int page = 1;

    public void loadData() {

        CiepVideoProtocol protocol = new CiepVideoProtocol();
        protocol.loadDataByGet(new BaseProtocol.Callback<CiepVideo>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(CiepVideo ciepVideo, int id) {
                if (ciepVideo != null) {
                    if (ciepVideo.getData() != null && ciepVideo.getData().getRows() != null ) {
                        List<ConfVideoEntity> list = ciepVideo.getData().getRows();
                        Collections.sort(list, (o1, o2) -> {
                            String time1 = o1.getCreate_date().trim();
                            String time2 = o2.getCreate_date().trim();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
                            try {
                                Date data1 = sdf.parse(time1);
                                Date data2 = sdf.parse(time2);
                                return data2.compareTo(data1);
                            } catch (Exception e) {
                                e.printStackTrace();
                                return 0;
                            }
                        });
                        getMvpView().onLoadSuccess(list);
                    }
                }
            }
        });
    }

    public void loadMore() {

        CiepVideoProtocol protocol = new CiepVideoProtocol();
        protocol.setPage(++page);
        protocol.loadDataByGet(new BaseProtocol.Callback<CiepVideo>() {
            @Override
            public void onError(Call call, Exception e, int id) {
                getMvpView().onError(e);
            }

            @Override
            public void onResponse(CiepVideo ciepVideo, int id) {
                if (ciepVideo != null) {
                    if (ciepVideo.getData() != null && ciepVideo.getData().getRows() != null ) {
                        if (ciepVideo.getData().getRows().size() < 20){
                            getMvpView().onLoadNoMore(ciepVideo.getData().getRows());
                        }else {
                            getMvpView().onLoadMore(ciepVideo.getData().getRows());
                        }
                    }
                }
            }

        });
    }
}
