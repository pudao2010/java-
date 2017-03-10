package com.qhzk.ciep.repository.remote.api;

import com.google.gson.internal.LinkedTreeMap;
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
import com.qhzk.ciep.repository.remote.modle.ResultModle;

import java.util.List;
import java.util.Map;

import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * 网络接口列表
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("{action}")
    Observable<Response<ResultModle<LinkedTreeMap>>> qrcodeinf(@Path(value = "action", encoded = true) String url, @FieldMap Map<String, String> fields);

    @GET("index/news!jsonlist.action")
    Observable<Response<ResultModle<List<NewEntity>>>> news(@Query("page") int page, @Query("rows") int rows, @Query("mid") String mid);

    @GET("index/news!getByidinfo.action")
    Observable<Response<ResultModle<NewEntity>>> newsinfo(@Query("id") String id);

    @GET("common/compic!jsonlist.action")
    Observable<Response<ResultModle<List<CompicEntity>>>> compic();

    // 登录
    @FormUrlEncoded
    @POST("login/login!login.action")
    Observable<Response<ResultModle<Void>>> login(@Field("usercode") String usercode, @Field("password") String password);

    // 获取当前用户信息
    @GET("login/login!curruser.action")
    Observable<Response<ResultModle<UserInfo>>> getCurruser();

    // 注册
    @FormUrlEncoded
    @POST("register/register!addUser.action")
    Observable<Response<ResultModle<Void>>> register(@Field("custtype") String custtype, @Field("custname") String custname, @Field("password") String password, @Field("passconfirm") String passconfirm);

    //    // 获取新闻中心
    @GET("index/news!indexlist.action")
    Observable<Response<ResultModle<List<NewEntity>>>> getNewsCenter(@Query("page") int page, @Query("rows") int rows, @Query("inxshow") int inxshow, @Query("mid") String mid);

    // 获取新闻详情
    @GET("index/news!getByidinfo.action")
    Observable<Response<ResultModle<NewsDetail>>> getByidinfo(@Query("id") String id);

    @GET("index/news!jsonlist.action")
    Observable<Response<ResultModle<List<NewEntity>>>> getConfNews(@Query("page") int page, @Query("rows") int rows, @Query("mid") String mid);

    // 大会版块
    @GET("common/comarticle!getByTypecode.action")
    Observable<Response<ResultModle<NewsDetail>>> getByTypecodeinfo(@Query("typecode") String typecode);

    // 往届回顾视频
    @GET("history-video/list.action")
    Observable<Response<ResultModle<List<NewVideoEntity>>>> getVideoList(@Query("page") int page, @Query("rows") int rows);

    // 大会视频
    @GET("video/vod/vod!vodlist.action")
    Observable<Response<ResultModle<VideoList>>> getConfVideoList(@Query("page") int page, @Query("rows") int rows);

    //当searchType==0时，获取项目引进，当searchType!=0时，获取项目推介
    @GET("project/list.action")
    Observable<Response<ResultModle<List<ProjectRequireEntity>>>> getProjectRequire(@Query("searchType") String searchType, @Query("page") int page, @Query("rows") int row);

    @GET("login/login!changepass.action")
    Observable<Response<ResultModle<Void>>> updatePassword(@Query("password") String password, @Query("passwordnew") String passwordnew);

    @GET("login/login!loginout.action")
    Observable<Response<ResultModle<Void>>> logout();

    // 获取项目详情
    @GET("project/detail.action")
    Observable<Response<ResultModle<ProjectDetail>>> getProjectDetail(@Query("project.id") String projectId);

    // 获取职位搜索列表
    @GET("position/position!list.action")
    Observable<Response<ResultModle<UnitInfoEntity>>> getUnitInfos(@Query("page") int page, @Query("rows") int rows);

    // 获取岗位信息
    @GET("position/position!getByidinfo.action")
    Observable<Response<ResultModle<JobDetail>>> getJobDetail(@Query("id") String id);

    // 提交我的参会列表
    @FormUrlEncoded
    @POST("partici/participant!myconfs.action")
    Observable<Response<ResultModle<Void>>> commitMeetings(@Field("confIds") String confIds);

    // 查询登录用户的参会个人信息
    @GET("partici/participant!currpartici.action")
    Observable<Response<ResultModle<UserInfo>>> getUserInfo();

    // 获取参展名单
    @GET("enterprise/list.action")
    Observable<Response<ResultModle<List<UnitList>>>> getUnitList(@Query("page") int page, @Query("rows") int rows);

    // 获取往届回顾--取得成果
    @GET("history-achievement/list.action")
    Observable<Response<ResultModle<List<AchieveMent>>>> getAchievements(@Query("page") int page, @Query("rows") int rows);

    // 获取往届回顾--展商名录
    @GET("history-exhibitor/list.action")
    Observable<Response<ResultModle<List<Exhibitor>>>> getExhibitorList(@Query("page") int page, @Query("rows") int rows);

    // 获取手机短信验证码
    @FormUrlEncoded
    @POST("register/register!getPhoneCode.action")
    Observable<Response<ResultModle<Void>>> getPhoneCode(@Field("mobile") String mobile);

    // 检查手机验证码是否有效
    @FormUrlEncoded
    @POST("login/login!checkMobileCode.action")
    Observable<Response<ResultModle<Void>>> checkMobileCode(@Field("mbcode") String mbcode, @Field("mobile") String mobile);

    // 修改密码
    @GET("login/login!changepass.action")
    Observable<Response<ResultModle<Void>>> changePassword(@Query("password") String password, @Query("passwordnew") String passwordnew);

    // 获取企业信息
    @GET("ent/enterprise!getByidinfo.action")
    Observable<Response<ResultModle<EnterpriseBean>>> getEnterpriseInfo(@Query("id") String id);

    // 关注某个企业
    @FormUrlEncoded
    @POST("focus/focus!addFocus.action")
    Observable<Response<ResultModle<Void>>> addFocus(@Field("entId") String entId);

    // 取消关注某个企业
    @FormUrlEncoded
    @POST("focus/focus!cancelFocus.action")
    Observable<Response<ResultModle<Void>>> cancelFocus(@Field("entId") String entId);

    // 判断企业是否被关注
    @GET("focus/focus!focused.action")
    Observable<Response<ResultModle<Focus>>> checkFocus(@Query("entId") String entId);

    // 单位信息里的人才对接
    @FormUrlEncoded
    @POST("position/position!entPositions.action")
    Observable<Response<ResultModle<Talentdock>>> getEntPositions(@Field("page") int page, @Field("rows") int rows, @Field("entId") String entId);

    // 单位信息里的项目对接, 传userId
    @GET("project/list.action")
    Observable<Response<ResultModle<List<ProjectDock>>>> getProjectdocks(@Query("project.releaseid") String userId);

    // 我的关注企业列表
    @GET("focus/focus!myFocus.action")
    Observable<Response<ResultModle<MyFocus>>> getMyFocus();

    // 简历上传和修改 uodateType=0时,简历基本信息 为1时,教育经历 为2时,工作经历 为3时,期望工作
//    @GET("member/person/resume/update.action")
//    Observable<Response<ResultModle<Void>>> updateResume(@Query("updateType") int updateType, @Query("resumeInfo.name") String name, @Query("gender") int gender,
//                                                         @Query("resumeInfo.birthday") String birthday, @Query("mobile") String phone, @Query("email") String email,
//                                                         @Query("yearsofwork") int yearsofwork, @Query("residency") String residency, @Query("salary") int salary,
//                                                         @Query("height") int height, @Query("maritalstatus") String maritalstatus, @Query("qq") String qq,
//                                                         @Query("wechat") String wechat);

    // 获取我的简历
    @GET("member/person/resume/myResume.action")
    Observable<Response<ResultModle<ResumeEntity>>> getMyResume();
    // 个人用户对职位投递简历
    @FormUrlEncoded
    @POST("common/resume-deliver/deliver.action")
    Observable<Response<ResultModle<Void>>> deliver(@Field("resumeDeliver.positionId") String positionId);

    // 获取简历投递列表
    @GET("common/resume-deliver/list.action")
    Observable<Response<ResultModle<List<Deliver>>>> getDeliverlist(@Query("page") int page, @Query("rows") int rows);

    // 根据条件搜索职位
    @FormUrlEncoded
    @POST("position/position!list.action")
    Observable<Response<ResultModle<UnitInfoEntity>>> getSearchJob(@Field("page") int page, //
                                                              @Field("rows") int rows,  //
                                                              @Field("title") String title,  //
                                                              @Field("entName") String entName, //
                                                              @Field("salRange") String salRange,  //
                                                              @Field("experience") String experience, //
                                                              @Field("education") String education, //
                                                              @Field("major") String major, //
                                                              @Field("industry") String industry, //
                                                              @Field("jobType") String jobType); //

    // 根据条件搜索项目
    @GET("project/list.action")
    Observable<Response<ResultModle<List<ProjectRequireEntity>>>> getSearchProject(@Query("project.name") String projectName, @Query("project.type") String projectType,
                                                                                   @Query("project.sector") String projectSector, @Query("releasetype") String releasetype,
                                                                                   @Query("searchType") String searchType);
    // 根据id获取大会版块详情
    @GET("system/section/getSectionDetail.action")
    Observable<Response<ResultModle<PlateDetail>>> getPlateDetail(@Query("section.id") int id);

    // 获取项目列表
    @GET("common/project/list.action")
    Observable<Response<ResultModle<List<ProjectManage>>>> getProjectList(@Query("page") int page, @Query("rows") int rows);

    // 获取我的会议
    @GET("partici/participant!getmyconfs.action")
    Observable<Response<ResultModle<List<MyMeeting>>>> getMyMeetings();

    // 首页搜索接口
//    @GET("search/list.action")
//    Observable<Response<ResultModle<List<NewEntity>>>> search

    // 找回密码,验证图形验证码
    @FormUrlEncoded
    @POST("system/pwdrest!getVailCode.action")
    Observable<Response<ResultModle<Void>>> getEmailCode(@Field("userEmail") String userEmail);

    // 验证发送邮箱的验证码
    @FormUrlEncoded
    @POST("system/pwdrest!vaildation.action")
    Observable<Response<ResultModle<Void>>> verifyEmailCode(@Field("userEmail") String userEnail, @Field("code") String code);

    // 获取大会通知
    @GET("index/news!indexlist.action")
    Observable<Response<ResultModle<Notice>>> getNotices(@Query("page") int page, @Query("rows") int rows, @Query("mid") String mid);

    // 找回密码,设置新密码
    @FormUrlEncoded
    @POST("system/pwdrest!changePwd.action")
    Observable<Response<ResultModle<Void>>> changePwd(@Field("userEmail") String userEmail, @Field("code") String code, @Field("password") String password);

    // 提交简历的基本信息
    @GET("member/person/resume/update.action")
    Observable<Response<ResultModle<Void>>> commitResumeInfo(@QueryMap Map<String, String> options);

    // 添加工作经历
    @FormUrlEncoded
    @POST("member/person/resume/work-exp/save.action")
    Observable<Response<ResultModle<Void>>> commitWorkExp(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("member/person/resume/education/save.action")
    Observable<Response<ResultModle<Void>>> commitEduExp(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("member/person/resume/job-pre/save.action")
    Observable<Response<ResultModle<Void>>> commitJobpref(@FieldMap Map<String, String> params);

    // 提交我要参会的个人信息
    @FormUrlEncoded
    @POST("partici/participant!add.action")
    Observable<Response<ResultModle<Void>>> commitMineData(@FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST("common/project/delete.action")
    Observable<Response<ResultModle<Void>>> deleteProject(@Field("project.id") String id);

    // 我的简历删除  //删除类型  范围数字0-3。0：简历基本信息；1：教育经历；2：工作经历；3：期望工作。0和3不开放
    @GET("member/person/resume/delete.action")
    Observable<Response<ResultModle<Void>>> deleteResume(@Query("deleteType") int deleteType, @Query("id") String id);

    // 校验用户是否为个人用户
    @FormUrlEncoded
    @POST("login/checkPersonOrNot.action")
    Observable<Response<ResultModle<Void>>> checkPersonOrNot(@Field("userCode") String userCode);

    // 获取论坛议程列表
    @GET("forum-agenda/list.action")
    Observable<Response<ResultModle<List<ForumAgenda>>>> getForumAgenda(@Query("page") int page, @Query("rows") int rows);
}
