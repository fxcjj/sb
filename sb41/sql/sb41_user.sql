/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : sb41_user

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2021-05-12 20:19:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'victor', '11');
INSERT INTO `t_user` VALUES ('2', 'justin', '13');
INSERT INTO `t_user` VALUES ('3', 'diana', '14');
INSERT INTO `t_user` VALUES ('4', 'jessica', '18');
INSERT INTO `t_user` VALUES ('5', 'martin', '21');
INSERT INTO `t_user` VALUES ('6', 'carl', '22');
INSERT INTO `t_user` VALUES ('7', 'john', '31');
