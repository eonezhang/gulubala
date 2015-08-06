SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS U_USER;
DROP TABLE IF EXISTS U_USER_LOGS;




/* Create Tables */

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


CREATE TABLE U_USER_LOGS
(
	-- 日志id
	LOG_ID bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '日志id',
	-- 日志类别:1-读取操作2-写入操作
	LOG_TYPE tinyint NOT NULL COMMENT '日志类别:1-读取操作2-写入操作',
	-- 日志标题
	LOG_TITLE varchar(100) NOT NULL COMMENT '日志标题',
	-- 请求URL
	REQUEST_URL varchar(256) COMMENT '请求URL',
	-- 请求参数
	REQUEST_PARAMS text COMMENT '请求参数',
	OPERATOR_ID bigint NOT NULL,
	-- 操作时间
	OPERATE_TIME datetime NOT NULL COMMENT '操作时间',
	PRIMARY KEY (LOG_ID)
);



