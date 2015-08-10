SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS appauths;
DROP TABLE IF EXISTS mediacategory;
DROP TABLE IF EXISTS userlogs;
DROP TABLE IF EXISTS users;




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


-- 媒体分类表
CREATE TABLE mediacategory
(
	-- 分类ID
	categoryId int NOT NULL AUTO_INCREMENT COMMENT '分类ID',
	-- 分类名称
	categoryName varchar(32) NOT NULL COMMENT '分类名称',
	-- 父分类ID
	parentCategoryId int NOT NULL COMMENT '父分类ID',
	-- 兄弟节点间的排序值
	siblingsOrder int NOT NULL COMMENT '兄弟节点间的排序值',
	-- 创建者ID
	createdBy int NOT NULL COMMENT '创建者ID',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	PRIMARY KEY (categoryId),
	CONSTRAINT uk_mediacategory_name UNIQUE (categoryName, parentCategoryId)
) COMMENT = '媒体分类表'
AUTO_INCREMENT = 100;


-- 用户操作日志表
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
) COMMENT = '用户操作日志表';


-- 用户表
CREATE TABLE users
(
	-- 用户ID
	id int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
	-- 昵称
	nickname varchar(32) COMMENT '昵称',
	-- 邮箱
	email varchar(100) COMMENT '邮箱',
	-- 手机号码
	phone varchar(20) COMMENT '手机号码',
	-- 用户密码
	password varchar(50) NOT NULL COMMENT '用户密码',
	-- 注册类型:1-使用手机号码注册2-使用邮箱注册
	registerType tinyint NOT NULL COMMENT '注册类型:1-使用手机号码注册2-使用邮箱注册',
	-- 0-女1-男
	sex int COMMENT '0-女1-男',
	-- 生日
	birthday date COMMENT '生日',
	-- 住址
	address varchar(255) COMMENT '住址',
	-- 是否是vip会员:1-是0-否
	vip tinyint DEFAULT 0 NOT NULL COMMENT '是否是vip会员:1-是0-否',
	-- 收货地址
	shdz varchar(255) COMMENT '收货地址',
	-- 消息设置
	xxsz varchar(255) COMMENT '消息设置',
	-- 权限设置
	qxsz varchar(255) COMMENT '权限设置',
	-- GU认真:1-已认证0-未认证
	gurz tinyint DEFAULT 0 NOT NULL COMMENT 'GU认真:1-已认证0-未认证',
	-- 积分
	score int DEFAULT 0 NOT NULL COMMENT '积分',
	-- 注册时间
	createdAt datetime NOT NULL COMMENT '注册时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	-- 登录次数
	loginTimes int DEFAULT 0 NOT NULL COMMENT '登录次数',
	-- 用户状态:0-冻结1-正常
	status tinyint DEFAULT 1 NOT NULL COMMENT '用户状态:0-冻结1-正常',
	lastLoginAt datetime NOT NULL,
	-- 个性签名
	remark varchar(255) COMMENT '个性签名',
	-- 用户头像地址
	iconUrl varchar(255) COMMENT '用户头像地址',
	PRIMARY KEY (id),
	CONSTRAINT uk_users_phone UNIQUE (phone),
	CONSTRAINT uk_users_email UNIQUE (email)
) COMMENT = '用户表';



