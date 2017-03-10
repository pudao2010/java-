package com.qhzk.ciep.interactor;

import com.google.gson.internal.LinkedTreeMap;
import com.qhzk.ciep.common.retrofit.ResultSubscriber;
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

import java.util.List;
import java.util.Map;

import rx.Subscription;


/**
 * Created by Thisdk on 2016/8/5.
 * 2016年12月26日11:09:57
 */

public interface Api {

    Subscription getQRcodeInfo(String action, String params, ResultSubscriber<LinkedTreeMap> subscriber);

    Subscription getNews(int page, int rows, String mid, ResultSubscriber<List<NewEntity>> subscriber);

    Subscription getCompic(ResultSubscriber<List<CompicEntity>> subscriber);

    Subscription login(String usercode, String password, ResultSubscriber<Void> subscriber);

    Subscription getCurruser(ResultSubscriber<UserInfo> subscriber);

    Subscription register(String custtype, String custname, String password, String passconfirm, ResultSubscriber<Void> subscriber);

    Subscription getNewsCenter(int page, int rows, int inxshow, String mid, ResultSubscriber<List<NewEntity>> subscriber);
    // 获取新闻详情
    Subscription getByidinfo(String id, ResultSubscriber<NewsDetail> subscriber);
    // 大会新闻
    Subscription getConfNews(int page, int rows, String mid, ResultSubscriber<List<NewEntity>> subscriber);

    // 获取大会信息,根据typecode
    Subscription getByTypecodeinfo(String typecode, ResultSubscriber<NewsDetail> subscriber);

    Subscription getVideoList(int page, int rows, ResultSubscriber<List<NewVideoEntity>> subscriber);

    // 获取项目引进信息
    Subscription getProjectRequire(String searchType, int page, int rows, ResultSubscriber<List<ProjectRequireEntity>> subscriber);

    Subscription updatePassword(String password, String passwordnew, ResultSubscriber<Void> subscriber);

    Subscription logout(ResultSubscriber<Void> subscriber);

    // 根据项目id获取项目详情
    Subscription getProjectDetail(String projectId, ResultSubscriber<ProjectDetail> subscriber);

    // 获取职位搜索列表
    Subscription getUnitInfos(int page, int rows, ResultSubscriber<UnitInfoEntity> subscriber);

    //获取岗位信息
    Subscription getJobDetail(String id, ResultSubscriber<JobDetail> subscriber);

    //提交我的参会列表
    Subscription commitMeetings(String confIds, ResultSubscriber<Void> subscriber);

    //获取登录用户信息
    Subscription getUserInfo(ResultSubscriber<UserInfo> subscriber);

    //获取参展名单
    Subscription getUnitList(int page, int rows, ResultSubscriber<List<UnitList>> subscriber);

    //获取取得成果
    Subscription getAchievements(int page, int rows, ResultSubscriber<List<AchieveMent>> subscriber);

    // 往届展商名录
    Subscription getExhibitorList(int page, int rows, ResultSubscriber<List<Exhibitor>> subscriber);

    // 获取手机短信验证码
    Subscription getPhoneCode(String mobile, ResultSubscriber<Void> subscriber);

    // 检查手机验证码是否有效
    Subscription checkPhoneCode(String mbcode, String mobile, ResultSubscriber<Void> subscriber);

    Subscription changePassword(String password, String passwordnew, ResultSubscriber<Void> subscriber);

    Subscription getEnterpriseInfo(String id, ResultSubscriber<EnterpriseBean> subscriber);

    Subscription addFocus(String entId, ResultSubscriber<Void> subscriber);

    Subscription cancelFocus(String entId, ResultSubscriber<Void> subscriber);

    Subscription checkFocus(String entId, ResultSubscriber<Focus> subscriber);

    Subscription getEntPositions(int page, int rows, String entId, ResultSubscriber<Talentdock> subscriber);

    Subscription getProjectDocks(String userId, ResultSubscriber<List<ProjectDock>> subscriber);

    Subscription getMyFocus(ResultSubscriber<MyFocus> subscriber);

    // 获取我的简历对象
    Subscription getMyResume(ResultSubscriber<ResumeEntity> subscriber);

    Subscription deliver(String positionId, ResultSubscriber<Void> subscriber);

    Subscription getDeliverlist(int page, int rows, ResultSubscriber<List<Deliver>> subscriber);

    Subscription getSearchJob(int page, int rows, String title, String entName, String salRange,//
                              String experience, String education, String major, String industry, //
                              String jobType, ResultSubscriber<UnitInfoEntity> subscriber);//

    Subscription getSearchProject(String projectName, String projectType, String projectSector, String releasetype,
                                  String searchType, ResultSubscriber<List<ProjectRequireEntity>> subscriber);

    Subscription getPlateDetail(int id, ResultSubscriber<PlateDetail> subscriber);

    Subscription getProjectList(int page, int rows, ResultSubscriber<List<ProjectManage>> subscriber);

    Subscription getMyMeetings(ResultSubscriber<List<MyMeeting>> subscriber);

    Subscription getEmailCode(String userEmail, ResultSubscriber<Void> subscriber);

    Subscription verifiyEmailCode(String userEmail, String code, ResultSubscriber<Void> subscriber);

    Subscription getNotices(int page, int rows, String mid, ResultSubscriber<Notice> subscriber);

    Subscription changePwd(String userEmail, String code, String password, ResultSubscriber<Void> subscriber);

    Subscription commitResumeInfo(Map<String, String> options, ResultSubscriber<Void> subscriber);

    Subscription commitWorkExp(Map<String, String> params, ResultSubscriber<Void> subscriber);

    Subscription commitEduExp(Map<String, String> params, ResultSubscriber<Void> subscriber);

    Subscription commitJobPref(Map<String, String> params, ResultSubscriber<Void> subscriber);

    Subscription commitMineData(Map<String, String> params, ResultSubscriber<Void> subscriber);

    Subscription getConfVideoList(int page, int rows, ResultSubscriber<VideoList> subscriber);

    Subscription deleteProject(String id, ResultSubscriber<Void> subscriber);

    Subscription deleteResume(int deleteType, String id, ResultSubscriber<Void> subscriber);

    Subscription checkPersonOrNot(String userCode, ResultSubscriber<Void> subscriber);

    // 获取论坛议程列表
    Subscription getForumAgenda(int page, int rows, ResultSubscriber<List<ForumAgenda>> subscriber);
}
