/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50636
 Source Host           : 127.0.0.1
 Source Database       : dy

 Target Server Type    : MySQL
 Target Server Version : 50636
 File Encoding         : utf-8

 Date: 01/23/2018 16:33:12 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `dm_count`
-- ----------------------------
DROP TABLE IF EXISTS `dm_count`;
CREATE TABLE `dm_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `roomid` int(11) DEFAULT NULL,
  `nickName` varchar(32) COLLATE utf8_bin NOT NULL,
  `dmCount` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=351 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `dm_detail`
-- ----------------------------
DROP TABLE IF EXISTS `dm_detail`;
CREATE TABLE `dm_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `roomid` int(11) DEFAULT NULL,
  `text` varchar(255) COLLATE utf8_bin NOT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1854 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `gift`
-- ----------------------------
DROP TABLE IF EXISTS `gift`;
CREATE TABLE `gift` (
  `uid` int(11) DEFAULT NULL,
  `gfid` int(11) DEFAULT NULL,
  `text` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
