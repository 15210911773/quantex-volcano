package com.iquantex.otc.constant;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Constants {
    
    public static final ScheduledExecutorService SCHEDULED_POOL = Executors.newScheduledThreadPool(3);
    
    /**
     * redist id
     */
    public static final String REDIS_DB = "web";
	
	/** 已删除 */
	public static final boolean DELETE_TRUE = Boolean.TRUE;
	/** 未删除 */
	public static final boolean DELETE_FALSE = Boolean.FALSE;
	
	/** 已启用 */
	public static final boolean ENABLED_TRUE = Boolean.TRUE;
	/** 已禁用 */
	public static final boolean ENABLED_FALSE = Boolean.FALSE;
	
	/******************** 看涨/看跌 ***********************/
	/** 看涨 */
	public static final int CALL = 1;
	/** 看跌 */
	public static final int PUT = 2;
	
	/***************** 交割方式 ******************/
	/** 实物 */
	public static final int PHYSICAL = 1;
	/** 现金 */
	public static final int CASH = 2;
	
	/********************字典key begin*************************/
	
	/** 行权方式 */
	public static final String EXERCISE_TYPE_KEY="exercise";
	/** 期权种类 */
	public static final String OPTION_TYPE_KEY="option";
	/** 标的种类 */
	public static final String UNDERLYING_TYPE_KEY="underlying";
	
	/********************字典key end*************************/
	
	/** job中QuotationsBean在map中的key */
	public static final String QUOTATIONS_MAP_KEY = "REAL_TIME_QUOTATIONS";
	/**
	 * 汇总的
	 */
//	public static final String QUOTATIONS_MAP_TOTAL_KEY = "REAL_TIME_TOTAL_QUOTATIONS";
	
	/**
	 * 仅有日期的格式表达式
	 */
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	/**
	 * 默认tag名称
	 */
	public static final String DEFAULT_TAG_NAME = "default";
	/**
	 * 默认tag的tagCode前缀
	 */
	public static final String DEFAULT_TAG_CODE_PREFIX = "default_";
	
	/*****************系统生成唯一标识码信息 begin***************************/
	/**
	 * 唯一标识码长度
	 */
	public static final int CODE_LENG = 4;
	
	/**
	 * 唯一标识码长度不足，左补字符
	 */
	public static final char CODE_LEFT_CHAR = '0';
	
	/*****************系统生成唯一标识码信息 end***************************/
	
	/**
	 * 买方
	 */
	public static final String TRADE_SIDE_BUY = "B";
	
	/**
     * 卖方
     */
	public static final String TRADE_SIDE_SELL = "S";
	
	/**
	 * 默认密码
	 */
	public static final String DEFAULT_PWD = "123456";
	
	/**
	 * 系统使用时区
	 */
	public static final String TIME_ZONE="Asia/Shanghai";
	
	/**
	 * 系统中一年天数
	 */
    public static final int YEAR = 365;
    
    /**
     * 系统中一周天数
     */
    public static final int WEEK = 7;
    
    /**
     * 系统中一月天数
     */
    public static final int MONTH = 30;
    
    /**
     * 默认impl_vol
     */
    public static final double IMP_VOL = 0.1675;
    
    /******************* redis begin **********************/
    /**
     * 存放bookTag关系Hash列表的索引
     */
//    public static final String BOOK_TAG_LIST_KEY = "book_tag_list_key";
    
    /**
     * 存放bookTagPosition的hash列表的索引
     */
    public static final String BOOK_TAG_POSITION_SET_KEY = "book_tag_position_set_key";
    
    /**
     * 存放bookUser权限hash列表的索引
     */
    public static final String BOOK_USER_PRIVILEGE_SET_KEY = "book_user_privilege_set_key";
    /******************* redis end **********************/
    
    /*********************证券类型begin****************************/
    
    /**
     * 场外期权
     */
    public static final int BOND_TYPE_OTC_OPTION=1;
    
    /**
     * 场内期权
     */
    public static final int BOND_TYPE_EXCHANGE_OPTION=2;
    
    /**
     * 期货
     */
    public static final int BOND_TYPE_FUTURES=3;
    
    /**
     * 股票
     */
    public static final int BOND_TYPE_STOCK=4;
    
    /**
     * 自选股
     */
    public static final int BOND_TYPE_SEL_SELECT=10;
    /*********************证券类型end****************************/
    
    /**
     * 最近一周
     */
    public static final int RECENT_WEEK = 1;
    /**
     * 最近一月
     */
    public static final int RECENT_MONTH = 2;
    
    
    /********************* 角色 ****************************/
    /**
     * 系统管理员角色主键
     */
    public static final long ROLE_ADMIN_ID = 1;
    /**
     * 系统管理员角色名称
     */
    public static final String ROLE_ADMIN_NAME = "系统管理员";
    
    /**
     * 系统初始化数据文件地址
     */
    public static final String APP_INIT_FILE_PATH = "/app.init.properties";
    
    /********************* 角色权限 begin ****************************/
    /**
     * 读写
     */
    public static final int PRIVILEGE_READ_WRITE = 1;
    /**
     * 只读
     */
    public static final int PRIVILEGE_READ_ONLY = 2;
    /********************* 角色权限 end ****************************/
    
    /********************* bsModel默认值 begin ****************************/
    
    /**
     * 年化无风险利率
     */
    public static final double BS_MODEL_R = 0.03;
    /**
     * 年化股息率
     */
    public static final double BS_MODEL_Q = 0;
    /**
     * 波动率
     */
    public static final double BS_MODEL_VOL = 0.4;
    
    /********************* bsModel默认值 end ******************************/
    
    /**
     * histVol目前只是统计30天的
     */
    public static final int HIST_VOL_DAYS = 30;
    
    
    /********************* 财汇接口地址 begin ****************************/
    
    public static final String FINCHINA_REDIS_TOKEN = "finchina_redis_token";
    public static final String FINCHINA_REDIS_REFRESHTOKEN = "finchina_redis_refreshtoken";
    
    public static final String FINCHINA_ACCOUNT_NAME = "ktkj2018";
    public static final String FINCHINA_ACCOUNT_PWD = "ktkj2018";
    
    /**
     * 获取访问Token接口
     */
    public static final String FINCHINA_AUTH_URL = "https://api.finchina.com/auth";
    /**
     * 刷新token
     */
    public static final String FINCHINA_REFRESH_URL = "https://api.finchina.com/refresh";
    
    /**
     * 静态数据接口（K线）
     */
    public static final String FINCHINA_KLINE_URL = "https://api.finchina.com/hq/v1/kline";
    
    /**
     * 动态websocket接口
     */
    public static final String FINCHINA_WS_DYNAMIC_URL = "ws://api.finchina.com/hq/v1/dynamic";
    
    /********************* 财汇接口地址 end ******************************/
    
    
    /********************* tradingView begin ******************************/
    
    /**
     * 1天
     */
    public static final String TRADING_VIEW_RESOLUTION_D = "1D";
    
    /**
     * 1周
     */
    public static final String TRADING_VIEW_RESOLUTION_W = "1W";
    
    /**
     * 1月
     */
    public static final String TRADING_VIEW_RESOLUTION_M = "1M";
    
    /********************* tradingView end ********************************/
    
}
