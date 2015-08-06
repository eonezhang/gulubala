/*
Navicat MySQL Data Transfer

Source Server         : vm-192.168.137.101
Source Server Version : 50618
Source Host           : 192.168.137.101:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50618
File Encoding         : 65001

Date: 2015-08-06 16:26:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for P_CLIENT_APP_AUTH_CONFIG
-- ----------------------------
DROP TABLE IF EXISTS `P_CLIENT_APP_AUTH_CONFIG`;
CREATE TABLE `P_CLIENT_APP_AUTH_CONFIG` (
  `APP_ID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户端ID',
  `APP_NAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户端名称',
  `APP_TYPE` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户端类型:android,ios',
  `APP_KEY` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户端秘钥',
  `STATUS` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态:0-禁用1-启用',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`APP_ID`),
  UNIQUE KEY `UK_APP_ID` (`APP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='客户端认证授权配置';

-- ----------------------------
-- Records of P_CLIENT_APP_AUTH_CONFIG
-- ----------------------------
INSERT INTO `P_CLIENT_APP_AUTH_CONFIG` VALUES ('gulubala_app_android', 'gulubala安卓客户端!', 'android', '90e98f4e2c6d49b4a1b7e70588898517', '1', '2015-08-04 23:20:50');
