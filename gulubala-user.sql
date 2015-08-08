SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS appauths;
DROP TABLE IF EXISTS userlogs;
DROP TABLE IF EXISTS U_USER;




/* Create Tables */

-- 客户端应用认证配置表
CREATE TABLE appauths
(
	-- 客户端应用ID
	appid varchar(50) NOT NULL COMMENT '客户端应用ID',
	-- 客户端应用名称
	appname varchar(100) NOT NULL COMMENT '客户端应用名称',
	-- 客户端类型:android,ios
	apptype varchar(32) NOT NULL COMMENT '客户端类型:android,ios',
	-- 客户端秘钥
	appkey varchar(50) NOT NULL COMMENT '客户端秘钥',
	-- 状态:0-禁用1-启用
	status tinyint NOT NULL COMMENT '状态:0-禁用1-启用',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	PRIMARY KEY (appid)
) COMMENT = '客户端应用认证配置表';


CREATE TABLE userlogs
(
	-- 日志id
	logId bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '日志id',
	-- 日志类别:1-读取操作2-写入操作
	logType tinyint NOT NULL COMMENT '日志类别:1-读取操作2-写入操作',
	-- 日志标题
	logTitle varchar(100) NOT NULL COMMENT '日志标题',
	-- 请求URL
	requestUrl varchar(256) NOT NULL COMMENT '请求URL',
	-- HTTP请求方法(大写)
	httpMethod varchar(20) NOT NULL COMMENT 'HTTP请求方法(大写)',
	-- 请求参数(json)
	requestParams text COMMENT '请求参数(json)',
	-- 请求结果(json)
	requestResult text COMMENT '请求结果(json)',
	-- 操作用户ID
	operatorId bigint COMMENT '操作用户ID',
	-- 操作时间
	operateTime datetime NOT NULL COMMENT '操作时间',
	-- 操作耗时(毫秒)
	operateTimeMillis bigint NOT NULL COMMENT '操作耗时(毫秒)',
	-- 操作IP
	operateIp varchar(20) COMMENT '操作IP',
	PRIMARY KEY (logId)
);


CREATE TABLE U_USER
(
	-- 用户ID
	USER_ID bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
	-- 用户名
	USER_NAME varchar(32) COMMENT '用户名',
	-- 手机号码
	MOBILE_PHONE varchar(20) COMMENT '手机号码',
	-- 邮箱
	EMAIL varchar(100) COMMENT '邮箱',
	-- 用户密码
	PASSWORD varchar(50) NOT NULL COMMENT '用户密码',
	-- 注册类型:1-使用手机号码注册2-使用邮箱注册
	REGISTER_TYPE tinyint NOT NULL COMMENT '注册类型:1-使用手机号码注册2-使用邮箱注册',
	-- 用户等级:Lv1,Lv2,Lv3等等
	USER_GRADE varchar(50) DEFAULT 'Lv1' NOT NULL COMMENT '用户等级:Lv1,Lv2,Lv3等等',
	-- 是否已认证:0-否1-是
	AUTHENTICATED tinyint DEFAULT 0 NOT NULL COMMENT '是否已认证:0-否1-是',
	-- 硬币数量
	PRICE_NUM int DEFAULT 0 NOT NULL COMMENT '硬币数量',
	-- 积分数量
	INTEGRAL_NUM int DEFAULT 0 NOT NULL COMMENT '积分数量',
	-- 登录次数
	LOGIN_TIMES int DEFAULT 0 NOT NULL COMMENT '登录次数',
	-- 个性签名
	REMARK varchar(200) COMMENT '个性签名',
	-- QQ号码
	QQ_NUMBER varchar(20) COMMENT 'QQ号码',
	-- 用户头像
	USER_ICON varchar(256) COMMENT '用户头像',
	-- 性别:0-女,1-男
	SEX tinyint COMMENT '性别:0-女,1-男',
	-- 用户状态:0-冻结1-正常
	STATUS tinyint DEFAULT 1 NOT NULL COMMENT '用户状态:0-冻结1-正常',
	LAST_LOGIN_TIME datetime NOT NULL,
	-- 注册时间
	CREATE_TIME datetime NOT NULL COMMENT '注册时间',
	PRIMARY KEY (USER_ID),
	UNIQUE (USER_NAME),
	UNIQUE (MOBILE_PHONE),
	UNIQUE (EMAIL)
);



