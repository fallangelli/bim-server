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

-- 导出 bim_grab 的数据库结构
DROP DATABASE IF EXISTS `bim_grab`;
CREATE DATABASE IF NOT EXISTS `bim_grab` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `bim_grab`;


-- 导出  表 bim_grab.base 结构
CREATE TABLE IF NOT EXISTS `base` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `json_md5` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `url` varchar(1024) COLLATE utf8_unicode_ci NOT NULL,
  `url_md5` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.cinemamovie_maoyan 结构
CREATE TABLE IF NOT EXISTS `cinemamovie_maoyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) NOT NULL,
  `movie_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cinema_id_movie_id` (`cinema_id`,`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.cinema_maoyan 结构
CREATE TABLE IF NOT EXISTS `cinema_maoyan` (
  `id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL DEFAULT '0',
  `nm` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '名称',
  `ct` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '城市',
  `area` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '区域',
  `addr` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '地址',
  `lat` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '经度',
  `lng` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '纬度',
  `sell` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否售票',
  `preferential` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否特惠',
  `imax` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否imax',
  `tel` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话json',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `json_md5` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.cinema_mtime 结构
CREATE TABLE IF NOT EXISTS `cinema_mtime` (
  `id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL DEFAULT '0',
  `district_id` int(11) NOT NULL DEFAULT '0' COMMENT '区域',
  `nm` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '名称',
  `addr` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '地址',
  `lat` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '经度',
  `lng` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '纬度',
  `rating` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '评分',
  `has_3d` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否3d',
  `has_imax` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否IMax',
  `has_Wifi` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否Wifi',
  `has_Park` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否停车',
  `tel` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '联系电话json',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.city_maoyan 结构
CREATE TABLE IF NOT EXISTS `city_maoyan` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `first_letter` varchar(4) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `pinyin` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.city_mtime 结构
CREATE TABLE IF NOT EXISTS `city_mtime` (
  `id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `first_letter` varchar(4) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `pinyin` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.moviecoming 结构
CREATE TABLE IF NOT EXISTS `moviecoming` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `director` varchar(500) COLLATE utf8_unicode_ci DEFAULT '0',
  `actor` varchar(2000) COLLATE utf8_unicode_ci DEFAULT '0',
  `type` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `source` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `url` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `urlMd5` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.movieshowing_maoyan 结构
CREATE TABLE IF NOT EXISTS `movieshowing_maoyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nm` varchar(200) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '名称',
  `img` varchar(400) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '主图片',
  `sc` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '评分',
  `src` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '地区',
  `imax` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否imax',
  `is3d` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否3d',
  `dir` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '导演',
  `star` varchar(3000) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '演员',
  `cat` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '类型',
  `scm` varchar(300) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '简述',
  `dur` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '时长',
  `ver` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '版本',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。


-- 导出  表 bim_grab.showplan_maoyan 结构
CREATE TABLE IF NOT EXISTS `showplan_maoyan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cinema_id` int(11) NOT NULL DEFAULT '0' COMMENT '影院',
  `movie_id` int(11) NOT NULL DEFAULT '0' COMMENT '影片',
  `dt` date NOT NULL COMMENT '日期',
  `tm` time NOT NULL COMMENT '开始时间',
  `end` time NOT NULL COMMENT '结束时间',
  `lang` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '语种',
  `th` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '厅位',
  `tp` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '类型',
  `sellPr` float NOT NULL COMMENT '原价',
  `pr` float NOT NULL COMMENT '价格',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- 数据导出被取消选择。
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
