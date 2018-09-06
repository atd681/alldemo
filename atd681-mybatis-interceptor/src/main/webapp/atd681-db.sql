DROP TABLE IF EXISTS `atd681_mybatis_sql`;
CREATE TABLE `atd681_mybatis_sql` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `v_sql` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `atd681_mybatis_test`;
CREATE TABLE `atd681_mybatis_test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dv` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
