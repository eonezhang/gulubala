SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS albums;
DROP TABLE IF EXISTS singers;
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
	-- 专辑封面URL
	picUrl varchar(255) NOT NULL COMMENT '专辑封面URL',
	-- 播放次数
	playCount int DEFAULT 0 NOT NULL COMMENT '播放次数',
	-- 专辑简介
	intro varchar(500) COMMENT '专辑简介',
	PRIMARY KEY (id)
) COMMENT = '歌曲专辑表';


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



