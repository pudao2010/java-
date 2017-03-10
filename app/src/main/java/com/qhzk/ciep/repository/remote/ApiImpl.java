package com.qhzk.ciep.repository.remote;

import android.text.TextUtils;

import com.google.gson.internal.LinkedTreeMap;
import com.qhzk.ciep.common.retrofit.HttpMethod;
import com.qhzk.ciep.common.retrofit.ResultSubscriber;
import com.qhzk.ciep.common.retrofit.RetrofitManage;
import com.qhzk.ciep.entity.AchieveMent;
import com.qhzk.ciep.entity.CompicEntity;
import com.qhzk.ciep.entity.Deliver;
import com.qhzk.ciep.entity.EnterpriseBean;
import com.qhzk.ciep.entity.Exhibitor;
import com.qhzk.ciep.entity.Focus;
import com.qhzk.ciep.entity.ForumAgenda;
import com.qhzk.ciep.entity.JobDetail;
import com.qhzk.ciep.entity.MyFocus;
import com.qhzk.ciep.entity.MyMeeting;
import com.qhzk.ciep.entity.NewEntity;
import com.qhzk.ciep.entity.NewVideoEntity;
import com.qhzk.ciep.entity.NewsDetail;
import com.qhzk.ciep.entity.Notice;
import com.qhzk.ciep.entity.PlateDetail;
import com.qhzk.ciep.entity.ProjectDetail;
import com.qhzk.ciep.entity.ProjectDock;
import com.qhzk.ciep.entity.ProjectManage;
import com.qhzk.ciep.entity.ProjectRequireEntity;
import com.qhzk.ciep.entity.ResumeEntity;
import com.qhzk.ciep.entity.Talentdock;
import com.qhzk.ciep.entity.UnitInfoEntity;
import com.qhzk.ciep.entity.UnitList;
import com.qhzk.ciep.entity.UserInfo;
import com.qhzk.ciep.entity.VideoList;
import com.qhzk.ciep.interactor.Api;
import com.qhzk.ciep.repository.remote.api.ApiService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rx.Subscription;

/**
 * Created by Thisdk on 2016/8/5.
 * 2016年12月26日11:10:15
 *
 */
public class ApiImpl implements Api {

    private ApiService mApiService;

    public ApiImpl() {
        this.mApiService = RetrofitManage.getApiInstance(ApiService.class);
    }

    @Override
    public Subscription getQRcodeInfo(String action, String params, ResultSubscriber<LinkedTreeMap> subscriber) {
        Map<String, String> fields = new HashMap<>();
        String[] split = params.split("&");
        for (String param : split) {
            String[] split_ = param.split("=");
            if (split_.length == 2 && !TextUtils.isEmpty(split_[0]) && !TextUtils.isEmpty(split_[1])) {
                fields.put(split_[0], split_[1]);
            }
        }
        char[] chars = action.toCharArray();
        if (chars[0] == '/') {
            action = new String(chars, 1, chars.length - 1);
        }
        return HttpMethod.execute(mApiService.qrcodeinf(action, fields), subscriber);
    }

    @Override
    public Subscription getNews(int page, int rows, String mid, ResultSubscriber<List<NewEntity>> subscriber) {
        return HttpMethod.execute(mApiService.news(page, rows, mid), subscriber);
    }

    @Override
    public Subscription getCompic(ResultSubscriber<List<CompicEntity>> subscriber) {
        return HttpMethod.execute(mApiService.compic(), subscriber);
    }

    @Override
    public Subscription login(String usercode, String password, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.login(usercode, password), subscriber);
    }

    //获取当前用户信息
    @Override
    public Subscription getCurruser(ResultSubscriber<UserInfo> subscriber) {
        return HttpMethod.execute(mApiService.getCurruser(), subscriber);
    }

    @Override
    public Subscription register(String custtype, String custname, String password, String passconfirm, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.register(custtype, custname, password ,passconfirm), subscriber);
    }

    // 获取新闻中心数据
    @Override
    public Subscription getNewsCenter(int page, int rows, int inxshow, String mid, ResultSubscriber<List<NewEntity>> subscriber) {
        return HttpMethod.execute(mApiService.getNewsCenter(page, rows, inxshow, mid), subscriber);
    }

    @Override
    public Subscription getByidinfo(String id, ResultSubscriber<NewsDetail> subscriber) {
        return HttpMethod.execute(mApiService.getByidinfo(id), subscriber);
    }
    // 获取大会新闻
    @Override
    public Subscription getConfNews(int page, int rows, String mid, ResultSubscriber<List<NewEntity>> subscriber) {
        return HttpMethod.execute(mApiService.getConfNews(page, rows , mid ), subscriber);
    }

    @Override
    public Subscription getByTypecodeinfo(String typecode, ResultSubscriber<NewsDetail> subscriber) {
        return HttpMethod.execute(mApiService.getByTypecodeinfo(typecode), subscriber);
    }

    @Override
    public Subscription getVideoList(int page, int rows, ResultSubscriber<List<NewVideoEntity>> subscriber) {
        return HttpMethod.execute(mApiService.getVideoList(page, rows), subscriber);
    }

    //获取项目引进
    @Override
    public Subscription getProjectRequire(String searchType, int page, int rows, ResultSubscriber<List<ProjectRequireEntity>> subscriber) {
        return HttpMethod.execute(mApiService.getProjectRequire(searchType, page, rows), subscriber);
    }
    // 修改密码
    @Override
    public Subscription updatePassword(String password, String passwordnew, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.updatePassword(password, passwordnew), subscriber);
    }

    @Override
    public Subscription logout(ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.logout(), subscriber);
    }

    @Override
    public Subscription getProjectDetail(String projectId, ResultSubscriber<ProjectDetail> subscriber) {
        return HttpMethod.execute(mApiService.getProjectDetail(projectId), subscriber);
    }

    @Override
    public Subscription getUnitInfos(int page, int rows, ResultSubscriber<UnitInfoEntity> subscriber) {
        return HttpMethod.execute(mApiService.getUnitInfos(page, rows), subscriber);
    }

    @Override
    public Subscription getJobDetail(String id, ResultSubscriber<JobDetail> subscriber) {
        return HttpMethod.execute(mApiService.getJobDetail(id), subscriber);
    }

    //提交我的参会列表
    @Override
    public Subscription commitMeetings(String confIds, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.commitMeetings(confIds), subscriber);
    }

    @Override
    public Subscription getUserInfo(ResultSubscriber<UserInfo> subscriber) {
        return HttpMethod.execute(mApiService.getUserInfo(), subscriber);
    }

    @Override
    public Subscription getUnitList(int page, int rows, ResultSubscriber<List<UnitList>> subscriber) {
        return HttpMethod.execute(mApiService.getUnitList(page, rows), subscriber);
    }

    @Override
    public Subscription getAchievements(int page, int rows, ResultSubscriber<List<AchieveMent>> subscriber) {
        return HttpMethod.execute(mApiService.getAchievements(page, rows), subscriber);
    }

    @Override
    public Subscription getExhibitorList(int page, int rows, ResultSubscriber<List<Exhibitor>> subscriber) {
        return HttpMethod.execute(mApiService.getExhibitorList(page, rows), subscriber);
    }

    @Override
    public Subscription getPhoneCode(String mobile, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.getPhoneCode(mobile), subscriber);
    }

    @Override
    public Subscription checkPhoneCode(String mbcode, String mobile, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.checkMobileCode(mbcode, mobile), subscriber);
    }

    @Override
    public Subscription changePassword(String password, String passwordnew, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.changePassword(password, passwordnew), subscriber);
    }

    @Override
    public Subscription getEnterpriseInfo(String id, ResultSubscriber<EnterpriseBean> subscriber) {
        return HttpMethod.execute(mApiService.getEnterpriseInfo(id), subscriber);
    }

    @Override
    public Subscription addFocus(String entId, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.addFocus(entId), subscriber);
    }

    @Override
    public Subscription cancelFocus(String entId, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.cancelFocus(entId), subscriber);
    }

    @Override
    public Subscription checkFocus(String entId, ResultSubscriber<Focus> subscriber) {
        return HttpMethod.execute(mApiService.checkFocus(entId), subscriber);
    }

    @Override
    public Subscription getEntPositions(int page, int rows, String entId, ResultSubscriber<Talentdock> subscriber) {
        return HttpMethod.execute(mApiService.getEntPositions(page, rows, entId), subscriber);
    }

    @Override
    public Subscription getProjectDocks(String userId, ResultSubscriber<List<ProjectDock>> subscriber) {
        return HttpMethod.execute(mApiService.getProjectdocks(userId), subscriber);
    }

    @Override
    public Subscription getMyFocus(ResultSubscriber<MyFocus> subscriber) {
        return HttpMethod.execute(mApiService.getMyFocus(), subscriber);
    }

    // 获取我的简历对象
    @Override
    public Subscription getMyResume(ResultSubscriber<ResumeEntity> subscriber) {
        return HttpMethod.execute(mApiService.getMyResume(), subscriber);
    }

    @Override
    public Subscription deliver(String positionId, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.deliver(positionId), subscriber);
    }

    @Override
    public Subscription getDeliverlist(int page, int rows, ResultSubscriber<List<Deliver>> subscriber) {
        return HttpMethod.execute(mApiService.getDeliverlist(page, rows), subscriber);
    }

    @Override
    public Subscription getSearchJob(int page, int rows, String title, String entName, String salRange, String experience, String education, String major, String industry, String jobType, ResultSubscriber<UnitInfoEntity> subscriber) {
        return HttpMethod.execute(mApiService.getSearchJob(page, rows, title, entName, salRange, experience, education, major, industry,jobType), subscriber);
    }

    @Override
    public Subscription getSearchProject(String projectName, String projectType, String projectSector, String releasetype, String searchType, ResultSubscriber<List<ProjectRequireEntity>> subscriber) {
        return HttpMethod.execute(mApiService.getSearchProject(projectName, projectType, projectSector, releasetype, searchType), subscriber);
    }

    @Override
    public Subscription getPlateDetail(int id, ResultSubscriber<PlateDetail> subscriber) {
        return HttpMethod.execute(mApiService.getPlateDetail(id), subscriber);
    }

    @Override
    public Subscription getProjectList(int page, int rows, ResultSubscriber<List<ProjectManage>> subscriber) {
        return HttpMethod.execute(mApiService.getProjectList(page, rows), subscriber);
    }

    @Override
    public Subscription getMyMeetings(ResultSubscriber<List<MyMeeting>> subscriber) {
        return HttpMethod.execute(mApiService.getMyMeetings(), subscriber);
    }

    @Override
    public Subscription getEmailCode(String userEmail, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.getEmailCode(userEmail), subscriber);
    }

    @Override
    public Subscription verifiyEmailCode(String userEmail, String code, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.verifyEmailCode(userEmail, code), subscriber);
    }

    @Override
    public Subscription getNotices(int page, int rows, String mid, ResultSubscriber<Notice> subscriber) {
        return HttpMethod.execute(mApiService.getNotices(page, rows, mid), subscriber);
    }

    @Override
    public Subscription changePwd(String userEmail, String code, String password, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.changePwd(userEmail, code, password), subscriber);
    }

    @Override
    public Subscription commitResumeInfo(Map<String, String> options, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.commitResumeInfo(options), subscriber);
    }

    @Override
    public Subscription commitWorkExp(Map<String, String> params, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.commitWorkExp(params), subscriber);
    }

    @Override
    public Subscription commitEduExp(Map<String, String> params, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.commitEduExp(params), subscriber);
    }

    @Override
    public Subscription commitJobPref(Map<String, String> params, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.commitJobpref(params), subscriber);
    }

    @Override
    public Subscription commitMineData(Map<String, String> params, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.commitMineData(params), subscriber);
    }

    @Override
    public Subscription getConfVideoList(int page, int rows, ResultSubscriber<VideoList> subscriber) {
        return HttpMethod.execute(mApiService.getConfVideoList(page, rows), subscriber);
    }

    @Override
    public Subscription deleteProject(String id, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.deleteProject(id), subscriber);
    }

    @Override
    public Subscription deleteResume(int deleteType, String id, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.deleteResume(deleteType, id), subscriber);
    }

    @Override
    public Subscription checkPersonOrNot(String userCode, ResultSubscriber<Void> subscriber) {
        return HttpMethod.execute(mApiService.checkPersonOrNot(userCode), subscriber);
    }

    @Override
    public Subscription getForumAgenda(int page, int rows, ResultSubscriber<List<ForumAgenda>> subscriber) {
        return HttpMethod.execute(mApiService.getForumAgenda(page, rows), subscriber);
    }


}
