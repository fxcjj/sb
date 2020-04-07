DROP TABLE IF EXISTS `v_user`;
CREATE TABLE `v_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标示',
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `password` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `user_type` tinyint(2) DEFAULT NULL COMMENT '1普通用户 2管理员',
  `status` char(1) DEFAULT '1' COMMENT '状态 1启用 0停用',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
