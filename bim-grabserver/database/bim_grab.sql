-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        5.6.21 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 bim_base 的数据库结构
DROP DATABASE IF EXISTS `bim_base`;
CREATE DATABASE IF NOT EXISTS `bim_base` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `bim_base`;


-- 导出  表 bim_base.cinema 结构
CREATE TABLE IF NOT EXISTS `cinema` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `district_id` int(11) NOT NULL DEFAULT '0' COMMENT '区域',
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '名称',
  `address` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '地址',
  `latitude` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '经度',
  `longitude` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '纬度',
  `rating` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '评分',
  `has_3d` tinyint(1) DEFAULT NULL COMMENT '是否3d',
  `has_imax` tinyint(1) DEFAULT NULL COMMENT '是否IMax',
  `has_Wifi` tinyint(1) DEFAULT NULL COMMENT '是否Wifi',
  `has_Park` tinyint(1) DEFAULT NULL COMMENT '是否停车',
  `tel` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话json',
  `route` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_maoyan` int(11) DEFAULT NULL,
  `id_mtime` int(11) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `district_id_name` (`district_id`,`name`),
  CONSTRAINT `fk_cinema_area` FOREIGN KEY (`district_id`) REFERENCES `city_area` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_base.city 结构
CREATE TABLE IF NOT EXISTS `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `first_letter` varchar(4) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `pinyin` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `id_maoyan` int(11) DEFAULT '0',
  `id_mtime` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_base.city_area 结构
CREATE TABLE IF NOT EXISTS `city_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL DEFAULT '0',
  `area` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `city_id_area` (`city_id`,`area`),
  CONSTRAINT `fk_area_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_base.movieshowing 结构
CREATE TABLE IF NOT EXISTS `movieshowing` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '名称',
  `image` varchar(400) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '主图片',
  `rating` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '评分',
  `is_imax` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否imax',
  `is_3d` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否3d',
  `directors` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '导演',
  `actors` varchar(3000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '演员',
  `type` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '类型',
  `content` varchar(2000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '简述',
  `runTime` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '时长',
  `id_maoyan` int(11) DEFAULT '0',
  `id_mtime` int(11) DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_base.screening 结构
CREATE TABLE IF NOT EXISTS `screening` (
  `id`          int(11)                 NOT NULL AUTO_INCREMENT,
  `cinema_id`   int(11)                 NOT NULL DEFAULT '0' COMMENT '影院',
  `movie_id`    int(11)                 NOT NULL DEFAULT '0' COMMENT '影片',
  `show_date`   DATE                    NOT NULL
  COMMENT '日期',
  `start_time`  TIME                    NOT NULL
  COMMENT '开始时间',
  `end_time`    TIME                    NOT NULL
  COMMENT '结束时间',
  `language`    VARCHAR(50)
                COLLATE utf8_unicode_ci NOT NULL
  COMMENT '语种',
  `hall`        VARCHAR(50)
                COLLATE utf8_unicode_ci NOT NULL
  COMMENT '厅位',
  `versionDesc` VARCHAR(50)
                COLLATE utf8_unicode_ci NOT NULL
  COMMENT '类型',
  `salePrice`   FLOAT                   NOT NULL
  COMMENT '原价',
  `cinemaPrice` FLOAT                   NOT NULL
  COMMENT '价格',
  `ticket_url`  VARCHAR(3000)
                COLLATE utf8_unicode_ci NOT NULL,
  `create_time` timestamp               NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp               NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cinema_id_movie_id_show_date_start_time_end_time` (`cinema_id`, `movie_id`, `show_date`, `start_time`, `end_time`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COLLATE = utf8_unicode_ci;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
