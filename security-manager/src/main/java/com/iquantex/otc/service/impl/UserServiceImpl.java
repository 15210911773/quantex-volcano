package com.iquantex.otc.service.impl;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;
import com.iquantex.otc.constant.Constants;
import com.iquantex.otc.mapper.UserMapper;
import com.iquantex.otc.model.User;
import com.iquantex.otc.service.UserService;
import com.iquantex.web.framework.exception.SystemException;
import com.iquantex.web.framework.redis.bean.UserLoginInfo;
import com.iquantex.web.framework.redis.dao.UserLoginInfoDao;
import com.iquantex.web.framework.util.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public static final String REDIS_DB = "web";
    private static final UserLoginInfoDao userLoginInfoDao = RedisDaoFactory.getDao(UserLoginInfoDao.class, REDIS_DB);

    private static Integer JWT_EXPIRE;
    private static String JWT_SECRET;

    static {
        JWT_SECRET = AppInfo.get("jwt.secret");
        if (StringUtils.isBlank(JWT_SECRET)) {
            logger.error("jwt.secret is not set");
            throw new SystemException("jwt.secret is not set");
        }
        JWT_EXPIRE = AppInfo.getInteger("jwt.expire");
        if (null == JWT_EXPIRE) {
            logger.warn("jwt.expire is not set");
            JWT_EXPIRE = 0;
        }
    }

    @Override
    public Map<String, Object> userLogin(String loginName, String loginPassword) {
        logger.debug("loginName <{}> , loginPassword <{}>", loginName, loginPassword);
        // 查询登录名为loginName的记录
        //FIXME 暂时系统 没有对登录名做限制，避免出错，查询列表，后续加了限制，改为selectOne
        List<User> retList = userMapper.selectBy(User.f_loginName,loginName,User.f_deleted,Constants.DELETE_FALSE);
        if(CollectionUtils.isEmpty(retList)) {
            logger.debug("用户名错误：{}",loginName);
            throw new SystemException("用户名错误!");
        }
        User user = retList.get(0);

        // 校验密码
        if (!MD5Util.getMd5(loginPassword).equals(user.getPasswd())) {
            logger.debug("DB loginName <{}> , 参数 loginPassword <{}>", user.getPasswd(), MD5Util.getMd5(loginPassword));
            throw new SystemException("密码错误!");
        }

        // 签发token
        JWTSigner signer = new JWTSigner(JWT_SECRET);

        // 返回结构
        Map<String, Object> claims = new HashMap<>();
        claims.put(User.f_id, user.getId());
        claims.put("userId", user.getId());
        claims.put(User.f_loginName, user.getLoginName());
        //FIXME 未测试
        claims.put("roleIds", user.getRoleId());

        // 采用base64编码，否则中文会报错
        claims.put(User.f_userName, Base64.encodeBase64String(user.getUserName().getBytes()));
        // 设置 token 过期时间，分钟
        Date expire = DateUtils.addMinutes(new Date(), JWT_EXPIRE);
        claims.put("exp", expire.getTime());
        // token生成
        String token = signer.sign(claims);
        // 返回前端还是原来的用户名
        claims.put(User.f_userName, user.getUserName());
        claims.put("token", token);

        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setUserId(user.getId());
        userLoginInfo.setMultiSite(UserLoginInfo.c_multiSite_yes);
        userLoginInfoDao.saveToRedis(userLoginInfo);

        //FIXME 这里用户权限应该有过期时间，随着用户token过期而过期，目前未设置
        /*List<BookUser> bookUserList = bookUserMapper.selectBy(BookUser.f_userId,user.getId(),BookUser.f_enabled,Constants.ENABLED_TRUE);
        BookPrivilege bookPrivilege = null;
        if(CollectionUtils.isNotEmpty(bookUserList)) {
            for(BookUser bookUser:bookUserList) {
                bookPrivilege = new BookPrivilege();
                bookPrivilege.setUserId(bookUser.getUserId());
                bookPrivilege.setBookId(bookUser.getBookId());
                bookPrivilege.setPrivilege(bookUser.getPrivilege());
                bookPrivilegeDao.saveToRedisWithList(Constants.BOOK_USER_PRIVILEGE_SET_KEY, bookPrivilege);
            }
        }*/

        //记录用户最新登录时间
/*        User loginUser = new User();
        loginUser.setId(user.getId());
        loginUser.setLastLoginTime(DateUtil.getSysDate());
        userMapper.updateByPrimaryKeySelective(loginUser);*/

        //记录用户登录日志
/*        UserLoginLog loginLog = new UserLoginLog();
        loginLog.setUserId(user.getId());
        loginLog.setLoginIp(SessionData.getIp());
        loginLog.setLoginName(user.getLoginName());
//        loginLog.setFailedReason(failedReason);//目前没有失败，都是成功
//        loginLog.setLoginStatus(loginStatus);//目前取数据库默认值0代表成功
//        loginLog.setLoginTime(loginTime);//数据库自动生成
        userLoginLogMapper.insertSelective(loginLog);*/

        return claims;
    }
}
