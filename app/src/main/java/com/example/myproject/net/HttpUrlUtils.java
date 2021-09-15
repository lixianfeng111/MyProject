package com.example.myproject.net;

/**
 * function ：接口
 * date ：2019/1/22
 */
public interface HttpUrlUtils {
    String INNER_BASE_URL = "https://172.17.8.100/techApi/";
    String BASE_URL = "https://mobile.bwstudent.com/techApi/";
    /**
     * 用户相关接口
     */
    //1.注册
    String REGISTER = "user/v1/register";
    //2.登陆
    String LOGIN = "user/v1/login";
    //3.完善用户信息
    String perfectUserInfo = "user/verify/v1/perfectUserInfo";
    //4.根据用户ID查询用户信息
    String getUserInfoByUserId = "user/verify/v1/getUserInfoByUserId";
    //5.修改用户昵称
    String MODIFY_NICKNAME = "user/verify/v1/modifyNickName";
    //6.修改用户签名
    String MODIFY_SIGNATURE = "user/verify/v1/modifySignature";
    //7.用户上传头像
    String MODIFY_HEAD_PIC = "user/verify/v1/modifyHeadPic";
    //8.修改邮箱
    String MODIFY_EMAIL = "user/verify/v1/modifyEmail";
    //9.修改用户密码
    String MODIFY_USER_PWD = "user/verify/v1/modifyUserPwd";
    //10.根据环信userNames批量查询会话列表需要的用户信息
    String findConversationList = "user/verify/v1/findConversationList";
    //11.查询用户积分
    String FIND_USER_INTEGRAL = "user/verify/v1/findUserIntegral";
    //12.查询用户积分明细
    String find_User_Integral_Record = "user/verify/v1/findUserIntegralRecord";
    //13.用户收藏列表
    String FIND_ALL_INFO_COLLECTION = "user/verify/v1/findAllInfoCollection";
    //14.添加收藏
    String ADDCOLLECTION = "user/verify/v1/addCollection";
    //15.取消收藏（支持批量操作）
    String CANCEL_COLLECTION = "user/verify/v1/cancelCollection";
    //16.用户关注列表
    String FIND_FOLLOW_USER_LIST = "user/verify/v1/findFollowUserList";
    //17.关注用户
    String ADDFOLLOW = "user/verify/v1/addFollow";
    //18.取消关注
    String CANCELFOLLOW = "user/verify/v1/cancelFollow";
    //19.校验手机号是否可用
    String checkPhone = "user/verify/v1/checkPhone";
    //20.微信登录
    String WECHATLOGIN = "user/v1/weChatLogin";
    //21.绑定微信帐号
    String BIND_WE_CHAT = "user/verify/v1/bindWeChat";
    //22.判断是否绑定微信
    String whetherToBindWeChat = "user/verify/v1/whetherToBindWeChat";
    //23.查询用户任务列表
    String findUserTaskList = "user/verify/v1/findUserTaskList";
    //24.做任务
    String doTheTask = "user/verify/v1/doTheTask";
    //25.签到
    String USER_SIGN = "user/verify/v1/userSign";
    //26. 查询当天签到状态
    String FIND_USER_SIGN_STATUS = "user/verify/v1/findUserSignStatus";
    //27.查询用户连续签到天数
    String findContinuousSignDays = "user/verify/v1/findContinuousSignDays";
    //28.1 查询用户当月所有签到的日期
    String findUserSignRecording = "user/verify/v1/findUserSignRecording";
    //28.2.查询好友信息
    String queryFriendInformation = "user/verify/v1/queryFriendInformation";
    //29.1 增量查询脸部特征库
    String incrementFindFaceFeature = "user/verify/v1/incrementFindFaceFeature";
    //29. 绑定faceId
    String bindingFaceId = "user/verify/v1/bindingFaceId";
    //30.刷脸登陆
    String faceLogin = "user/v1/faceLogin";
    //31.根据手机号查询用户信息
    String FINDPERSON = "user/verify/v1/findUserByPhone";
    /**
     * 好友聊天相关接口
     */
    String ChartVerify = "chat/verify/v1/";
    //1.添加好友
    String ADDFRIEND = ChartVerify + "addFriend";
    //2.删除好友
    String DELETEFRIEND = ChartVerify + "deleteFriendRelation";
    //3.修改好友备注
    String modifyFriendRemark = ChartVerify + "modifyFriendRemark";
    //4.检测是否为我的好友
    String CHECKFRIEND = ChartVerify + "checkMyFriend";
    //5.创建自定义好友分组
    String addFriendGroup = ChartVerify + "addFriendGroup";
    //6.查询用户所有分组
    String FINDGROUP = ChartVerify + "findFriendGroupList";
    //7.修改好友分组名称
    String modifyGroupName = ChartVerify + "modifyGroupName";
    //8.转移好友到其他分组
    String TRANSFERFRIENDGROUP = ChartVerify + "transferFriendGroup";
    //9.删除用户好友分组
    String deleteFriendGroup = ChartVerify + "deleteFriendGroup";
    //10.查询分组下的好友列表信息
    String GROUPFRIENDS = ChartVerify + "findFriendListByGroupId";
    //11.查询用户的好友通知记录
    String FRIENDSNOTICE = ChartVerify + "findFriendNoticePageList";
    //12.审核好友申请
    String REVIEWFRIENDAPPLY = ChartVerify + "reviewFriendApply";
    //13.发送消息
    String sendMessage = ChartVerify + "sendMessage";
    //14.查询好友聊天记录
    String findChatRecordPageList = ChartVerify + "findChatRecordPageList";
    //15.查询好友对话记录
    String findDialogueRecordPageList = ChartVerify + "findDialogueRecordPageList";
    //16.删除好友聊天记录
    String deleteChatRecord = ChartVerify + "deleteChatRecord";
    //17.查询我的好友列表
    String searchFriend = ChartVerify + "searchFriend";
    //初始化我的好友列表全量信息
    String INITFRIENDLIST = ChartVerify + "initFriendList";
    /**
     * 群组相关接口
     */
    String GroupVerify = "group/verify/v1/";
    //1.创建群
    String CREATEGROUP = GroupVerify + "createGroup";
    //2.修改群组名
    String modifyGroupName1 = GroupVerify + "modifyGroupName";
    //3.修改群简介
    String modifyGroupDescription = GroupVerify + "modifyGroupDescription";
    //4.解散群组
    String disbandGroup = GroupVerify + "disbandGroup";
    //5.查询我创建的群组
    String findGroupsByUserId = GroupVerify + "findGroupsByUserId";
    //6.查询我所有加入的群组
    String FINDUSERJOINGROUP = GroupVerify + "findUserJoinedGroup";
    //7. 查询群组内所有用户信息
    String findGroupMemberList = GroupVerify + "findGroupMemberList";
    //8. 查询群组详细信息
    String FINDGROUP_ONE = GroupVerify + "findGroupInfo";
    //9. 发送群信息
    String sendGroupMessage = GroupVerify + "sendGroupMessage";
    //10.查询群聊天内容
    String findGroupChatRecordPage = GroupVerify + "findGroupChatRecordPage";
    //11.移出群成员(管理员与群主才有的权限)
    String removeGroupMember = GroupVerify + "removeGroupMember";
    //12.调整群成员角色(群主才有的权限)
    String modifyPermission = GroupVerify + "modifyPermission";
    //13.判断用户是否已在群内
    String WHETHERINGROUP = GroupVerify + "whetherInGroup";
    //14.申请进群
    String APPLYADDGROUP = GroupVerify + "applyAddGroup";
    //15. 邀请加群
    String inviteAddGroup = GroupVerify + "inviteAddGroup";
    //批量邀请加群
    String batchInviteAddGroup = GroupVerify + "batchInviteAddGroup";
    //16.查询群通知记录
    String findGroupNoticePageList = GroupVerify + "findGroupNoticePageList";
    //17. 审核群申请
    String reviewGroupApply = GroupVerify + "reviewGroupApply";
    //18.上传群头像
    String uploadGroupHeadPic = GroupVerify + "uploadGroupHeadPic";
    //19.退群
    String retreat = GroupVerify + "retreat";
    /**
     * 资讯相关接口
     */
    String INFORMATION = "information/v1/";
    String INFORMATIONVERIFY = "information/verify/v1/";
    //1.banner展示列表
    String BANNERSHOW = INFORMATION + "bannerShow";
    //2.资讯推荐展示列表(包含单独板块列表展示)
    String INFORECOMMENDLIST = INFORMATION + "infoRecommendList";
    //3. 资讯详情展示
    String FINDINFORMATIONDETILS = INFORMATION + "findInformationDetails";
    //4.所有板块查询
    String FINDALLINFOPLATE = INFORMATION + "findAllInfoPlate";
    //5.修改资讯分享数
    String UPDATEINFOSHARENUM = INFORMATION + "updateInfoShareNum";
    //6.资讯点赞
    String ADDGREATRECORD = INFORMATIONVERIFY + "addGreatRecord";
    //7. 取消点赞
    String CACELGREATE = INFORMATIONVERIFY + "cancelGreat";
    //8. 资讯用户评论
    String ADDINFOCOMMENT = INFORMATIONVERIFY + "addInfoComment";
    //9. 查询资讯评论列表
    String FINDALLINFOCOMMENTLIST = INFORMATION + "findAllInfoCommentList";
    //10.根据标题模糊查询
    String FINDINFORMATIONBYTITLE = INFORMATION + "findInformationByTitle";
    //11.根据作者名模糊查询
    String FINDINFORMATIONBYSOURCE = INFORMATION + "findInformationBySource";
    //12.资讯广告
    String FINDINFOADVERTSING = INFORMATION + "findInfoAdvertising";
    //13.资讯积分兑换
    String INFOPAYBYINTEGRAL = INFORMATIONVERIFY + "infoPayByIntegral";
    /**
     * 社区相关接口
     */
    String community = "community/v1/";
    String communityVerify = "community/verify/v1/";
    //1.社区列表
    String FINDCOMMUNITYLIST = community + "findCommunityList";
    //2.发布帖子
    String RELEASEPOST = communityVerify + "releasePost";
    //3. 删除帖子(支持批量删除)
    String deletePost = communityVerify + "deletePost";
    //4.点赞
    String ADDCOMMUNITYGREAT = communityVerify + "addCommunityGreat";
    //5.取消点赞
    String CANCELCOMMUNITYGREAT = communityVerify + "cancelCommunityGreat";
    //6.社区评论列表（标签方式返参）
    String findCommunityCommentList = community + "findCommunityCommentList";
    //7.社区用户评论列表（bean方式返参）
    String FINDCOMMUNITYUSERCOMMENLIST = community + "findCommunityUserCommentList";
    //8.社区评论
    String ADDCOMMUNITYCOMMENT = communityVerify + "addCommunityComment";
    //9. 我的帖子
    String findMyPostById = communityVerify + "findMyPostById";
    //10. 查询用户发布的帖子
    String FINDUSERPOSTBYID = communityVerify + "findUserPostById";
    /**
     * 综合业务相关接口
     */
    String tool = "tool/v1/";
    String toolVerify = "tool/verify/v1/";
    //1.查询所有会员商品
    String findVipCommodityList = tool + "findVipCommodityList";
    //2.用户购买VIP
    String buyVip = toolVerify + "buyVip";
    //3.支付
    String pay = toolVerify + "pay";
    //4.微信分享前置接口，获取分享所需参数
    String wxShare = tool + "wxShare";
    //5.意见反馈
    String recordFeedBack = toolVerify + "recordFeedBack";
    //6.查询新版本
    String findNewVersion = tool + "findNewVersion";
    //7.查询所有奖品
    String findAllPrize = toolVerify + "findAllPrize";
    //8.抽奖
    String lottery = toolVerify + "lottery";
    //9.查询用户抽奖记录
    String findLotteryRecordList = toolVerify + "findLotteryRecordList";
    //10.领取奖品
    String receivePrize = toolVerify + "receivePrize";
    //11.查询用户系统通知
    String findSysNoticeList = toolVerify + "findSysNoticeList";
}