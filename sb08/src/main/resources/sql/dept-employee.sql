CREATE TABLE `v_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '部门code',
  `name` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `dflag` int(2) DEFAULT NULL COMMENT '0:无效 1:有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `v_dept_employee_link` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_code` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `employee_code` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `dflag` int(2) DEFAULT NULL COMMENT '0:无效 1:有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `v_employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '工号',
  `name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '姓名',
  `dflag` int(2) DEFAULT NULL COMMENT '0:无效 1:有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;