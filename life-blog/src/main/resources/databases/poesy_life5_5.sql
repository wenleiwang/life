/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : poesy_life

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 06/11/2020 10:58:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `article_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `article_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `article_body` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `user_id` int(11) NOT NULL COMMENT '文章所属用户',
  `add_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `deleted` tinyint(1)   NULL DEFAULT NULL,
  `star_num` int(11)   NULL DEFAULT NULL COMMENT '点赞数量',
  `comment_num` int(11)   NULL DEFAULT NULL COMMENT '评论数量',
  `collect_num` int(11)   NULL DEFAULT NULL COMMENT '收藏数量',
  `star_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启点赞',
  `comment_status` tinyint(1)   NULL DEFAULT NULL COMMENT '是否开启评论',
  `collect_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启收藏',
  `article_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '首图',
  `artcle_flag` int(2) NULL DEFAULT NULL COMMENT '文章标志 0-原创；1-转载；2-翻译；',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_classify
-- ----------------------------
DROP TABLE IF EXISTS `blog_classify`;
CREATE TABLE `blog_classify`  (
  `classify_id` int(11)   NOT NULL COMMENT '分类ID',
  `classify_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '分类所属用户',
  `add_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1)   NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `comment_body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `comment_parent` int(11)   NULL DEFAULT NULL COMMENT '父级评论ID，0-表示1级评论',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '评论用户',
  `article_id` int(11) NULL DEFAULT NULL COMMENT '被评论文章',
  `add_time` datetime NULL DEFAULT NULL COMMENT '评论添加时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '评论修改时间',
  `deleted` tinyint(1)   NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '标签所属用户',
  `add_time` datetime NULL DEFAULT NULL COMMENT '标签添加时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '标签修改时间',
  `deleted` tinyint(1)   NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `user_password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_age` int(3) NULL DEFAULT NULL COMMENT '虚拟年龄',
  `real_age` int(3)   NULL DEFAULT NULL COMMENT '真实年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `add_time` datetime NULL DEFAULT NULL COMMENT '插入数据时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改数据时间',
  `deleted` tinyint(1)   NULL DEFAULT NULL COMMENT '删除状态',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
