/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : sb43_order

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2021-05-12 20:15:54
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='订单表';

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', 'rabbit', '2');
INSERT INTO `t_order` VALUES ('2', 'dog', '4');
INSERT INTO `t_order` VALUES ('3', 'pig', '7');
INSERT INTO `t_order` VALUES ('4', 'sheep', '3');
INSERT INTO `t_order` VALUES ('5', 'duck', '1');
INSERT INTO `t_order` VALUES ('6', 'chicken', '2');
INSERT INTO `t_order` VALUES ('7', 'tiger', '5');
