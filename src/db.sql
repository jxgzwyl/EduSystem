/*
Navicat MySQL Data Transfer

Source Server         : db_edu
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : db_edu

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2013-06-10 17:58:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_class`;
CREATE TABLE `tb_class` (
  `class_id` int(11) NOT NULL auto_increment,
  `class_name` varchar(64) NOT NULL,
  `teather_id` int(11) default NULL,
  `project_id` int(11) default NULL,
  PRIMARY KEY  (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_country_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_country_area`;
CREATE TABLE `tb_country_area` (
  `area_id` int(11) NOT NULL auto_increment,
  `area_code` varchar(16) NOT NULL,
  `area_name` varchar(16) NOT NULL,
  PRIMARY KEY  (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_courses_data_struct
-- ----------------------------
DROP TABLE IF EXISTS `tb_courses_data_struct`;
CREATE TABLE `tb_courses_data_struct` (
  `struct_id` int(11) NOT NULL auto_increment,
  `struct_parent_id` int(11) default NULL,
  `course_id` int(11) NOT NULL,
  `node_name` varchar(64) NOT NULL,
  `data_location` varchar(128) default NULL,
  PRIMARY KEY  (`struct_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `tb_courses_data_struct_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `tb_course_library` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_courses_subject
-- ----------------------------
DROP TABLE IF EXISTS `tb_courses_subject`;
CREATE TABLE `tb_courses_subject` (
  `subject_id` int(11) NOT NULL auto_increment,
  `subject_name` varchar(64) default NULL,
  PRIMARY KEY  (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_course_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_course_comment`;
CREATE TABLE `tb_course_comment` (
  `homework_comment_id` bigint(20) NOT NULL auto_increment,
  `homework_comment_content` varchar(256) default NULL,
  `user_homework_id` int(11) NOT NULL,
  `homework_comment_man` varchar(16) default NULL,
  PRIMARY KEY  (`homework_comment_id`),
  KEY `user_homework_id` (`user_homework_id`),
  CONSTRAINT `tb_course_comment_ibfk_1` FOREIGN KEY (`user_homework_id`) REFERENCES `tb_user_homework` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_course_library
-- ----------------------------
DROP TABLE IF EXISTS `tb_course_library`;
CREATE TABLE `tb_course_library` (
  `course_id` int(11) NOT NULL auto_increment,
  `course_name` varchar(64) default NULL,
  `course_desc` varchar(128) default NULL,
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(64) default NULL,
  `course_data_type` tinyint(4) default NULL,
  `course_total_useable` int(11) default NULL,
  `course_total_useless` int(11) default NULL,
  PRIMARY KEY  (`course_id`),
  KEY `tb_course_library_ibfk_1` (`subject_id`),
  CONSTRAINT `tb_course_library_ibfk_1` FOREIGN KEY (`subject_id`) REFERENCES `tb_courses_subject` (`subject_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_homework
-- ----------------------------
DROP TABLE IF EXISTS `tb_homework`;
CREATE TABLE `tb_homework` (
  `homework_id` bigint(20) NOT NULL auto_increment,
  `homework_name` varchar(64) NOT NULL,
  `homework_publisher` int(11) default NULL,
  `homework_content` text,
  `homework_start_time` datetime default NULL,
  `homework_end_time` datetime default NULL,
  `homework_type` tinyint(4) default NULL,
  `course_id` int(11) NOT NULL,
  `homework_total_time` int(11) default NULL,
  `homework_publish_status` tinyint(1) default NULL,
  PRIMARY KEY  (`homework_id`),
  KEY `tb_homework_ibfk_1` (`course_id`),
  CONSTRAINT `tb_homework_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `tb_course_library` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 3072 kB; (`course_id`) REFER `db_edu/tb_course_';

-- ----------------------------
-- Table structure for tb_homework_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_homework_comment`;
CREATE TABLE `tb_homework_comment` (
  `homework_comment_id` bigint(20) NOT NULL auto_increment,
  `homework_comment_content` varchar(256) NOT NULL,
  `user_homework_id` int(11) default NULL,
  `homework_comment_man` varchar(16) default NULL,
  PRIMARY KEY  (`homework_comment_id`),
  KEY `user_homework_id` (`user_homework_id`),
  CONSTRAINT `tb_homework_comment_ibfk_1` FOREIGN KEY (`user_homework_id`) REFERENCES `tb_user_homework` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_homework_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_homework_project`;
CREATE TABLE `tb_homework_project` (
  `homework_project_id` bigint(20) NOT NULL auto_increment,
  `homework_id` bigint(20) default NULL,
  `project_id` int(11) default NULL,
  `visible_status` tinyint(1) default NULL,
  PRIMARY KEY  (`homework_project_id`),
  KEY `tb_homework_project_ibfk_1` (`homework_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tb_homework_project_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`) ON UPDATE CASCADE,
  CONSTRAINT `tb_homework_project_ibfk_1` FOREIGN KEY (`homework_id`) REFERENCES `tb_homework` (`homework_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice` (
  `notice_id` int(11) NOT NULL auto_increment,
  `notice_type` tinyint(4) default NULL,
  `notice_grade` tinyint(4) default NULL,
  `notice_title` varchar(64) default NULL,
  `notice_content` varchar(256) default NULL,
  `notice_publisher` int(11) default NULL,
  `notice_publish_time` datetime default NULL,
  PRIMARY KEY  (`notice_id`),
  KEY `tb_notice_ibfk_1` (`notice_publisher`),
  CONSTRAINT `tb_notice_ibfk_1` FOREIGN KEY (`notice_publisher`) REFERENCES `tb_user` (`user_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_organization
-- ----------------------------
DROP TABLE IF EXISTS `tb_organization`;
CREATE TABLE `tb_organization` (
  `organization_id` int(11) NOT NULL auto_increment,
  `organization_name` varchar(16) default NULL,
  `city_area_code` varchar(16) default NULL,
  `county_area_code` varchar(16) default NULL,
  `contact_info` varchar(64) default NULL,
  `address` varchar(128) default NULL,
  `regional_administrator_id` int(11) default NULL COMMENT 'Regional Administrator ID',
  PRIMARY KEY  (`organization_id`),
  KEY `regional_administrator_id` (`regional_administrator_id`),
  CONSTRAINT `tb_organization_ibfk_1` FOREIGN KEY (`regional_administrator_id`) REFERENCES `tb_user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_project`;
CREATE TABLE `tb_project` (
  `project_id` int(11) NOT NULL auto_increment,
  `project_name` varchar(64) NOT NULL,
  `start_time` date NOT NULL,
  `end_time` date NOT NULL,
  `project_manage_man` varchar(32) default NULL,
  `project_status` tinyint(4) NOT NULL,
  PRIMARY KEY  (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_project_check_plan
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_check_plan`;
CREATE TABLE `tb_project_check_plan` (
  `plan_id` int(11) NOT NULL auto_increment,
  `plan_content` varchar(64) NOT NULL,
  `plan_desc` varchar(128) NOT NULL,
  `plan_score` smallint(6) NOT NULL,
  `project_id` int(11) default NULL,
  PRIMARY KEY  (`plan_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tb_project_check_plan_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_project_course
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_course`;
CREATE TABLE `tb_project_course` (
  `id` int(11) NOT NULL auto_increment,
  `project_id` int(11) default NULL,
  `course_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `project_id` (`project_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `tb_project_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `tb_course_library` (`course_id`),
  CONSTRAINT `tb_project_course_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_project_dynamicstate
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_dynamicstate`;
CREATE TABLE `tb_project_dynamicstate` (
  `policy_id` int(11) NOT NULL auto_increment,
  `policy_title` varchar(128) NOT NULL,
  `policy_date` datetime default NULL,
  `policy_content` text,
  `policy_attachement` varchar(256) default NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY  (`policy_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tb_project_dynamicstate_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_project_policy
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_policy`;
CREATE TABLE `tb_project_policy` (
  `policy_id` int(11) NOT NULL auto_increment,
  `policy_title` varchar(128) NOT NULL,
  `policy_date` datetime default NULL,
  `policy_content` text,
  `policy_attachement` varchar(256) default NULL,
  `project_id` int(11) NOT NULL,
  PRIMARY KEY  (`policy_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tb_project_policy_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_project_schedule
-- ----------------------------
DROP TABLE IF EXISTS `tb_project_schedule`;
CREATE TABLE `tb_project_schedule` (
  `schedule_id` int(11) NOT NULL auto_increment,
  `project_id` int(11) default NULL,
  `schedule_title` varchar(64) NOT NULL,
  `schedule_content` text,
  `schedule_attachment` varchar(128) default NULL,
  PRIMARY KEY  (`schedule_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tb_project_schedule_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_report
-- ----------------------------
DROP TABLE IF EXISTS `tb_report`;
CREATE TABLE `tb_report` (
  `report_id` int(11) NOT NULL auto_increment,
  `report_title` varchar(64) NOT NULL,
  `report_content` text,
  `report_attachment` varchar(256) default NULL,
  `report_publisher` int(11) default NULL,
  `report_publish_time` datetime default NULL,
  `project_id` int(11) default NULL,
  PRIMARY KEY  (`report_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tb_report_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(64) default NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_privilege`;
CREATE TABLE `tb_role_privilege` (
  `id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `privilege_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `tb_role_privilege_ibfk_2` (`privilege_id`),
  KEY `tb_role_privilege_ibfk_1` (`role_id`),
  CONSTRAINT `tb_role_privilege_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON UPDATE CASCADE,
  CONSTRAINT `tb_role_privilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `tb_systemprivilege` (`privilege_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_students_class
-- ----------------------------
DROP TABLE IF EXISTS `tb_students_class`;
CREATE TABLE `tb_students_class` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `class_id` (`class_id`),
  KEY `tb_students_class_ibfk_1` (`user_id`),
  CONSTRAINT `tb_students_class_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON UPDATE CASCADE,
  CONSTRAINT `tb_students_class_ibfk_2` FOREIGN KEY (`class_id`) REFERENCES `tb_class` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_systemprivilege
-- ----------------------------
DROP TABLE IF EXISTS `tb_systemprivilege`;
CREATE TABLE `tb_systemprivilege` (
  `privilege_id` int(11) NOT NULL auto_increment,
  `privilege_type` tinyint(4) default NULL,
  `privilege_name` varchar(64) NOT NULL,
  PRIMARY KEY  (`privilege_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_system_area
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_area`;
CREATE TABLE `tb_system_area` (
  `system_area_id` int(11) NOT NULL auto_increment,
  `area_code` varchar(16) default NULL,
  `area_name` varchar(16) default NULL,
  PRIMARY KEY  (`system_area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(32) NOT NULL,
  `user_identity_card` char(24) NOT NULL,
  `user_login_name` varchar(32) default NULL,
  `role_name` varchar(8) default NULL,
  `user_gender` char(8) default NULL,
  `user_organization` varchar(64) default NULL,
  `user_grade` varchar(16) default NULL,
  `user_professional` varchar(16) default NULL,
  `teach_subject` varchar(16) default NULL,
  `phone` varchar(16) default NULL,
  `email` varchar(32) default NULL,
  `qq` varchar(16) default NULL,
  `blog` varchar(64) default NULL,
  `address` varchar(64) default NULL,
  `password` varchar(32) NOT NULL,
  `organization_id` int(11) default NULL,
  `administrator_id` int(11) default NULL,
  `role_id` int(11) default NULL,
  PRIMARY KEY  (`user_id`),
  KEY `role_id` (`role_id`),
  KEY `administrator_id` (`administrator_id`),
  KEY `organization_id` (`organization_id`),
  CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `tb_user_ibfk_2` FOREIGN KEY (`administrator_id`) REFERENCES `tb_user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `tb_user_ibfk_3` FOREIGN KEY (`organization_id`) REFERENCES `tb_organization` (`organization_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user_homework
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_homework`;
CREATE TABLE `tb_user_homework` (
  `user_id` int(11) default NULL,
  `homework_id` int(11) default NULL,
  `homework_score` smallint(6) default NULL,
  `is_excellent` tinyint(4) default NULL,
  `recommend_excellent` tinyint(4) default NULL,
  `is_commit` tinyint(4) default NULL,
  `homework_remark` varchar(128) default NULL,
  `id` int(11) NOT NULL auto_increment,
  `check_status` tinyint(4) default NULL,
  `teacher_id` int(11) default NULL,
  `homework_an_content` text,
  `project_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tb_user_homework_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_project`;
CREATE TABLE `tb_user_project` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `project_id` int(11) default NULL,
  `check_status` tinyint(4) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `tb_user_project_ibfk_2` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_project_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_project_courses_record
-- ----------------------------
DROP TABLE IF EXISTS `user_project_courses_record`;
CREATE TABLE `user_project_courses_record` (
  `record_id` int(11) NOT NULL auto_increment,
  `project_id` int(11) default NULL,
  `class_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `leaning_time` int(11) default NULL,
  PRIMARY KEY  (`record_id`),
  KEY `project_id` (`project_id`),
  KEY `user_id` (`user_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `user_project_courses_record_ibfk_3` FOREIGN KEY (`class_id`) REFERENCES `tb_class` (`class_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_project_courses_record_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tb_project` (`project_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_project_courses_record_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='The user program classroom record';
