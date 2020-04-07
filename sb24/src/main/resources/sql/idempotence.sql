DROP TABLE IF EXISTS `v_user`;
CREATE TABLE `v_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `password` varchar(20) DEFAULT NULL COMMENT '密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_type` tinyint(2) DEFAULT NULL COMMENT '1普通用户 2管理员',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态 1启用 0 停用',
  `gmt_created` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(2) DEFAULT NULL COMMENT '逻辑删除 1正常 2删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_phone` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `v_goods`;
CREATE TABLE `v_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '名称',
  `status` tinyint(2) DEFAULT '1' COMMENT '状态 1启用 0 停用',
  `version` bigint(20) DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
