CREATE database iot;
 
use iot;

CREATE TABLE `user`  (
  user_name VARCHAR(64) NOT NULL COMMENT '用户名',
  `password` VARCHAR(64)  NOT NULL COMMENT '密码',
  email VARCHAR(32) NULL DEFAULT NULL COMMENT '邮箱',
  last_login_time DATETIME DEFAULT NULL COMMENT '最近登录时间',
  user_descript  VARCHAR(128) DEFAULT '编辑信息添加个人描述' COMMENT '用户描述',
  PRIMARY KEY (user_name)
);

CREATE TABLE device (
	device_id INT AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(64),
	device_name VARCHAR(64) NOT NULL COMMENT '设备名称',
    device_type VARCHAR(64) NOT NULL COMMENT '设备类型',
    device_discript VARCHAR(128) NOT NULL COMMENT '设备描述',
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间'
);

CREATE TABLE IOTMessage (
	log_id INT AUTO_INCREMENT PRIMARY KEY,
	device_id INT NOT NULL,
    info VARCHAR(64) COMMENT '上报信息',
	alert INT DEFAULT 0 NOT NULL COMMENT '警告信息',
    lat FLOAT DEFAULT 0.0000 NOT NULL COMMENT '维度',
	lng FLOAT DEFAULT 0.0000 NOT NULL COMMENT '经度',
    log_time LONG NOT NULL COMMENT '上报时间'
);
