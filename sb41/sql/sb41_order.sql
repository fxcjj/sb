/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : sb41_order

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2021-05-12 20:19:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', 'apple', '2');
INSERT INTO `t_order` VALUES ('2', 'banana', '4');
INSERT INTO `t_order` VALUES ('3', 'orange', '7');
INSERT INTO `t_order` VALUES ('4', 'pen', '3');
INSERT INTO `t_order` VALUES ('5', 'cup', '1');
INSERT INTO `t_order` VALUES ('6', 'mouse', '2');
INSERT INTO `t_order` VALUES ('7', 'desk', '5');
