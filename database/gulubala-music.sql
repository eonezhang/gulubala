SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS albums;
DROP TABLE IF EXISTS danmu;
DROP TABLE IF EXISTS favorites;
DROP TABLE IF EXISTS mediacategory;
DROP TABLE IF EXISTS playlists;
DROP TABLE IF EXISTS singers;
DROP TABLE IF EXISTS slideadv;
DROP TABLE IF EXISTS songcategorys;
DROP TABLE IF EXISTS songcomments;
DROP TABLE IF EXISTS songlists;
DROP TABLE IF EXISTS songs;




/* Create Tables */

-- 歌曲专辑表
CREATE TABLE albums
(
	-- 专辑ID
	id int NOT NULL AUTO_INCREMENT COMMENT '专辑ID',
	-- 专辑名称
	name varchar(50) NOT NULL COMMENT '专辑名称',
	-- 发行单位
	publisher varchar(50) NOT NULL COMMENT '发行单位',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	-- 所属歌手ID
	singerId int NOT NULL COMMENT '所属歌手ID',
	-- 专辑封面URL
	picUrl varchar(255) NOT NULL COMMENT '专辑封面URL',
	-- 播放次数
	playCount int DEFAULT 0 NOT NULL COMMENT '播放次数',
	-- 专辑简介
	remark varchar(500) COMMENT '专辑简介',
	PRIMARY KEY (id)
) COMMENT = '歌曲专辑表';


-- 弹幕表
CREATE TABLE danmu
(
	-- 弹幕ID
	id int NOT NULL AUTO_INCREMENT COMMENT '弹幕ID',
	-- 歌曲ID
	songId int NOT NULL COMMENT '歌曲ID',
	-- 用户ID
	userId int NOT NULL COMMENT '用户ID',
	-- 弹幕内容
	content varchar(255) NOT NULL COMMENT '弹幕内容',
	-- 弹幕显示的时机
	showAt datetime COMMENT '弹幕显示的时机',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '弹幕表';


-- 收藏表
CREATE TABLE favorites
(
	-- 收藏ID
	id int NOT NULL AUTO_INCREMENT COMMENT '收藏ID',
	-- 用户ID
	userId int NOT NULL COMMENT '用户ID',
	-- 收藏数据
	data varchar(1000) COMMENT '收藏数据',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 收藏对象类型:1-歌曲收藏2-歌单收藏
	favoriteType tinyint NOT NULL COMMENT '收藏对象类型:1-歌曲收藏2-歌单收藏',
	-- 根据favoriteType判断是歌曲ID或歌单ID
	favoriteId int NOT NULL COMMENT '根据favoriteType判断是歌曲ID或歌单ID',
	PRIMARY KEY (id),
	CONSTRAINT uk_favorites_user UNIQUE (userId, favoriteType, favoriteId)
) COMMENT = '收藏表';


-- 媒体分类表,ID[1-99]区间的都是固定死的
CREATE TABLE mediacategory
(
	-- 分类ID
	categoryId int NOT NULL AUTO_INCREMENT COMMENT '分类ID',
	-- 分类名称
	categoryName varchar(32) NOT NULL COMMENT '分类名称',
	-- 分类类型(1-音乐分类2-视频分类3-排行榜分类)
	categoryType int NOT NULL COMMENT '分类类型(1-音乐分类2-视频分类3-排行榜分类)',
	-- 兄弟节点间的排序值
	siblingsOrder int NOT NULL COMMENT '兄弟节点间的排序值',
	-- 创建者ID
	createdBy int NOT NULL COMMENT '创建者ID',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	PRIMARY KEY (categoryId),
	CONSTRAINT uk_mediacategory_name UNIQUE (categoryName, categoryType)
) COMMENT = '媒体分类表,ID[1-99]区间的都是固定死的'
AUTO_INCREMENT = 100;


-- 播放历史表
CREATE TABLE playlists
(
	-- 播放历史ID
	id int NOT NULL AUTO_INCREMENT COMMENT '播放历史ID',
	-- 用户ID
	userId int NOT NULL COMMENT '用户ID',
	-- 歌曲ID,逗号隔开
	songIds varchar(1000) COMMENT '歌曲ID,逗号隔开',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	PRIMARY KEY (id),
	CONSTRAINT uk_playlists_userId UNIQUE (userId)
) COMMENT = '播放历史表';


-- 歌手表
CREATE TABLE singers
(
	-- 歌手ID
	id int NOT NULL AUTO_INCREMENT COMMENT '歌手ID',
	-- 歌手名
	name varchar(50) NOT NULL COMMENT '歌手名',
	-- 歌手简介
	profile text COMMENT '歌手简介',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	-- 性别(0-女1-男)
	sex tinyint NOT NULL COMMENT '性别(0-女1-男)',
	-- 出生日期
	birthday date COMMENT '出生日期',
	-- 国籍
	country varchar(20) COMMENT '国籍',
	-- 星座
	xingzuo varchar(10) COMMENT '星座',
	-- 血型
	xuexing varchar(20) COMMENT '血型',
	-- 身高
	shengao varchar(20) COMMENT '身高',
	-- 体重
	tizhong varchar(20) COMMENT '体重',
	-- 职业
	zhiye varchar(50) COMMENT '职业',
	PRIMARY KEY (id)
) COMMENT = '歌手表';


-- 轮播广告表
CREATE TABLE slideadv
(
	-- 轮播广告ID
	id int NOT NULL AUTO_INCREMENT COMMENT '轮播广告ID',
	-- 轮播广告标题
	title varchar(255) NOT NULL COMMENT '轮播广告标题',
	-- 广告图片URL
	imgUrl varchar(255) NOT NULL COMMENT '广告图片URL',
	-- 排序值
	orderIndex int NOT NULL COMMENT '排序值',
	-- 状态(1-上架,0-下架)
	status tinyint DEFAULT 1 NOT NULL COMMENT '状态(1-上架,0-下架)',
	-- 广告备注
	remark varchar(500) COMMENT '广告备注',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	PRIMARY KEY (id)
) COMMENT = '轮播广告表';


-- 歌曲分类关系表
CREATE TABLE songcategorys
(
	-- 歌曲id
	songId int NOT NULL COMMENT '歌曲id',
	-- 分类id
	categoryId int NOT NULL COMMENT '分类id',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间'
) COMMENT = '歌曲分类关系表'
ALTER TABLE songcategorys ADD PRIMARY KEY pk_songid_categoryid(songId,categoryId);


-- 歌曲/歌单评论表
CREATE TABLE songcomments
(
	-- 评论ID
	id int NOT NULL AUTO_INCREMENT COMMENT '评论ID',
	-- 父评论ID，默认0代表没有父评论
	parentId int DEFAULT 0 NOT NULL COMMENT '父评论ID，默认0代表没有父评论',
	-- 用户ID
	userId int NOT NULL COMMENT '用户ID',
	-- 评论内容
	content varchar(1000) NOT NULL COMMENT '评论内容',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 评论类型:1-歌曲评论2-歌单评论
	commentType tinyint NOT NULL COMMENT '评论类型:1-歌曲评论2-歌单评论',
	-- 评论对象ID，歌曲ID或者歌单ID
	commentId int NOT NULL COMMENT '评论对象ID，歌曲ID或者歌单ID',
	-- 评论点赞数
	commentPraises int DEFAULT 0 NOT NULL COMMENT '评论点赞数',
	PRIMARY KEY (id)
) COMMENT = '歌曲/歌单评论表';


-- 歌单表
CREATE TABLE songlists
(
	-- 歌单Id
	id int NOT NULL AUTO_INCREMENT COMMENT '歌单Id',
	-- 用户Id
	userId int NOT NULL COMMENT '用户Id',
	-- 歌曲Id集合","分割
	songIds varchar(1000) COMMENT '歌曲Id集合","分割',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	-- 歌单名称
	name varchar(50) NOT NULL COMMENT '歌单名称',
	-- 歌单描述
	remark varchar(500) COMMENT '歌单描述',
	-- 评论数
	comments int DEFAULT 0 NOT NULL COMMENT '评论数',
	-- 点赞数
	praises int DEFAULT 0 NOT NULL COMMENT '点赞数',
	-- 收藏数
	collects int DEFAULT 0 NOT NULL COMMENT '收藏数',
	-- 播放次数
	plays int DEFAULT 0 NOT NULL COMMENT '播放次数',
	-- 歌单封面图URL
	pictureUrl varchar(255) NOT NULL COMMENT '歌单封面图URL',
	PRIMARY KEY (id)
) COMMENT = '歌单表';


-- 歌曲表
CREATE TABLE songs
(
	-- 歌曲ID
	id int NOT NULL AUTO_INCREMENT COMMENT '歌曲ID',
	-- 歌曲名称
	name varchar(50) NOT NULL COMMENT '歌曲名称',
	-- 作曲
	zuoqu varchar(50) NOT NULL COMMENT '作曲',
	-- 作词
	zuoci varchar(50) NOT NULL COMMENT '作词',
	-- 编曲
	bianqu varchar(50) NOT NULL COMMENT '编曲',
	-- 所属歌手ID
	singerId int NOT NULL COMMENT '所属歌手ID',
	-- 所属专辑ID
	albumId int COMMENT '所属专辑ID',
	-- 是否原唱(1:是 0:否)
	yuanchuang tinyint NOT NULL COMMENT '是否原唱(1:是 0:否)',
	-- 是否翻唱(1:是 0:否)
	fangchang tinyint NOT NULL COMMENT '是否翻唱(1:是 0:否)',
	-- 是否MV(1:是 0:否)
	mv tinyint NOT NULL COMMENT '是否MV(1:是 0:否)',
	-- 发行单位
	publisher varchar(50) NOT NULL COMMENT '发行单位',
	-- 发行时间
	publishAt date NOT NULL COMMENT '发行时间',
	-- 人气数
	hot int DEFAULT 0 NOT NULL COMMENT '人气数',
	-- 播放次数
	playCount int DEFAULT 0 NOT NULL COMMENT '播放次数',
	-- 点赞数
	zan int DEFAULT 0 NOT NULL COMMENT '点赞数',
	-- 收藏数
	shoucang int DEFAULT 0 NOT NULL COMMENT '收藏数',
	-- 创建时间
	createdAt datetime NOT NULL COMMENT '创建时间',
	-- 更新时间
	updatedAt datetime COMMENT '更新时间',
	-- 歌曲分类ID
	categoryId int NOT NULL COMMENT '歌曲分类ID',
	-- 歌词链接URL
	lrcUrl varchar(255) NOT NULL COMMENT '歌词链接URL',
	-- 歌曲封面小图URL
	smallPicUrl varchar(255) NOT NULL COMMENT '歌曲封面小图URL',
	-- 歌曲封面大图URL
	picUrl varchar(255) NOT NULL COMMENT '歌曲封面大图URL',
	-- 歌曲文件URL
	songUrl varchar(255) NOT NULL COMMENT '歌曲文件URL',
	PRIMARY KEY (id),
	CONSTRAINT uk_songs_name UNIQUE (name, singerId)
) COMMENT = '歌曲表';



