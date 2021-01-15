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

 Date: 15/01/2021 18:44:39
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
  `article_description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '描述',
  `article_body` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `classify_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类',
  `user_id` int(11) NOT NULL COMMENT '文章所属用户',
  `add_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '0-发布；1-删除；2-草稿',
  `star_num` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '点赞数量',
  `comment_num` int(11) NULL DEFAULT NULL COMMENT '评论数量',
  `collect_num` int(11) NULL DEFAULT NULL COMMENT '收藏数量',
  `star_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启点赞',
  `comment_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启评论',
  `collect_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启收藏',
  `article_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '首图',
  `article_flag` int(2) NULL DEFAULT NULL COMMENT '文章标志 0-原创；1-转载；2-翻译；',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES (16, '沙发上阿发FDAWFE', '分分啊发分为afaSD', '分分啊发分为afaSD', '', 1, '2020-12-30 14:02:46', '2020-12-30 14:02:46', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/6c9a178e8a2791a3b5606f9cfc015cf22c180b875ba8f-mC5lts_fw658/format/webp', 0);
INSERT INTO `blog_article` VALUES (20, '为预览提供的测试文档', '# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题', '# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题2\n大师傅IE\n### 这是二级标题的三级标题2\n范德萨见覅额\n----\n> 这里是引用\n\n这里是代码\n```java\npublic ResponseBase updateArticle(@RequestBody ArticleRequest article){\n        UserInfo userContext = UserContext.getUserContext();\n        if(userContext == null){\n            return new ResponseBase().fail(\"用户登录失败，请重新登录！\");\n        }\n        return adminArticleService.updateArticle(article,userContext);\n    }\n```\n# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题2\n大师傅IE\n### 这是二级标题的三级标题2\n范德萨见覅额\n\n----\n\n>这里是引用\n\n\n这里是代码\n\n```java\npublic ResponseBase updateArticle(@RequestBody ArticleRequest article){\n        UserInfo userContext = UserContext.getUserContext();\n        if(userContext == null){\n            return new ResponseBase().fail(\"用户登录失败，请重新登录！\");\n        }\n        return adminArticleService.updateArticle(article,userContext);\n    }\n```', '历史', 1, '2020-12-30 16:00:24', '2021-01-14 14:58:47', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/25fe5381aa9cb19de79be4abb0755eca6d0db13f477f2-9bzSyh_fw658/format/webp', 1);
INSERT INTO `blog_article` VALUES (21, '个人年终工作总结', '个人年终工作总结\n时间飞逝，转眼已经来到这里四个月，回顾这段时间的成长，收获颇多，感慨颇多。刚来时，在领导和同事的带领下熟悉业务，同时也着手参与小部分功能。在工作上，项目进度把控合理，需求分析到位，大', '个人年终工作总结\n时间飞逝，转眼已经来到这里四个月，回顾这段时间的成长，收获颇多，感慨颇多。刚来时，在领导和同事的带领下熟悉业务，同时也着手参与小部分功能。在工作上，项目进度把控合理，需求分析到位，大家一起沟通愉快。在生活上领导同事的亲切与关怀，让我洋溢着喜悦。身处这样工作环境下，我感到了我的进步和喜悦，在这里感谢我的领导和同事对我的关怀与帮助。\n一、本年度工作回顾\n1.参与熟悉历史业务。在我读取研究成熟业务部分时，严谨的逻辑、新颖的思维，对我的思维逻辑有极大的提升；在我使用工具时，由于涉及工具广泛且要求精准，对我的技术广度深度都做了更深层次的要求。\n2.参与存房2.0业务的部分开发工作。存房2.0业务整合C端、B端、S端，成为一个更为完整的业务功能，它打通了CBS三端的业务数据的交互，这里需要更为严谨的逻辑，更为准确的数据，更为有效的沟通，做好这项工作对沟通和技术都提出高要求。\n参与进这样的工作中，紧跟着项目我感到了我的进步。端正态度，热爱本职工作，尽到自己本份，尽力完成应该做的事情，这是我的优点，在努力工作时也收获到了技术能力的成长，但也感到自己的不足，在以后的时光抓紧时间弥补自己的不足。\n二、来年工作的展望\n1.严于律己。事业是学生事业的延续在空闲时，深度学习基础知识，不断扩展自己的知识储备以达到广度的积累，使自己技术深度广度得到提高。\n2. 加强沟通，同事之间要坦诚、宽容、沟通和信任。工作中有些问题往往就是因为没有及时沟通引起的，以后工作中要与领导与同事加强沟通。\n3.依然热爱工作，以端正的态度，尽到自己的本分，尽力完成应进之事。\n4.“士不可以不弘毅，任重而道远”，希望自己的工作可以作为公司最坚固的一块砖。 \n在以后的工作中，我一定会扬长避短，克服不足、认真学习、发奋工作、积极进取、尽快成长，把工作做的更好。我已经准备好我全部的心和热情，让新的一年和新的学习过程早点开始。\n', '', 1, '2020-12-30 16:14:17', '2020-12-30 16:14:17', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/c66074d69cc700028232d62daa554a4f291660c638fa5-WoX4AD_fw658/format/webp', 2);
INSERT INTO `blog_article` VALUES (22, '2否232水电费', '# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题', '# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题2\n大师傅IE\n### 这是二级标题的三级标题2\n范德萨见覅额\n----\n>这里是引用\n\n这里是代码\n```java\npublic ResponseBase updateArticle(@RequestBody ArticleRequest article){\n        UserInfo userContext = UserContext.getUserContext();\n        if(userContext == null){\n            return new ResponseBase().fail(\"用户登录失败，请重新登录！\");\n        }\n        return adminArticleService.updateArticle(article,userContext);\n    }\n```', '', 1, '2020-12-30 16:51:54', '2020-12-30 16:51:54', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/eee2251fd4b7de27fdc390b3501ebfa863f1a5dd7fa47-DAmJZg_fw658/format/webp', 0);
INSERT INTO `blog_article` VALUES (23, '发送到发', '方法阿斯蒂芬', '方法阿斯蒂芬', '', 1, '2021-01-08 17:46:42', '2021-01-08 17:46:42', 2, 0, 0, 0, 1, 1, 1, '', NULL);
INSERT INTO `blog_article` VALUES (24, '测试预览按钮', '测试预览按钮', '测试预览按钮', '', 1, '2021-01-08 17:50:26', '2021-01-08 17:50:26', 2, 0, 0, 0, 1, 1, 1, '', NULL);

-- ----------------------------
-- Table structure for blog_classify
-- ----------------------------
DROP TABLE IF EXISTS `blog_classify`;
CREATE TABLE `blog_classify`  (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `classify_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '分类所属用户',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_classify
-- ----------------------------
INSERT INTO `blog_classify` VALUES (2, '数据结果', 1, '2020-11-11 10:46:04', '2020-11-11 10:46:07', 0);
INSERT INTO `blog_classify` VALUES (5, 'java', 1, NULL, NULL, 0);
INSERT INTO `blog_classify` VALUES (6, '高等数学', 1, '2021-01-11 18:55:36', '2021-01-11 18:55:41', 0);
INSERT INTO `blog_classify` VALUES (7, '文化', 1, '2021-01-12 09:28:40', '2021-01-12 09:28:40', 0);
INSERT INTO `blog_classify` VALUES (8, '杂谈', 1, '2021-01-12 09:57:42', '2021-01-12 09:57:42', 0);

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `comment_body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `comment_parent` int(11) NULL DEFAULT 0 COMMENT '父级评论ID，0-表示1级评论',
  `read_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否被作者阅读',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '评论用户',
  `article_id` int(11) NULL DEFAULT NULL COMMENT '被评论文章',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '评论添加时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '评论修改时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_res_article_classify
-- ----------------------------
DROP TABLE IF EXISTS `blog_res_article_classify`;
CREATE TABLE `blog_res_article_classify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `article_id` int(11) NOT NULL COMMENT '文章ID',
  `classify_id` int(11) NOT NULL COMMENT '分类ID',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加数据时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改数据时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_res_article_classify
-- ----------------------------
INSERT INTO `blog_res_article_classify` VALUES (2, 0, 1, 0, '2020-12-29 11:11:49', '2020-12-29 11:11:49');
INSERT INTO `blog_res_article_classify` VALUES (3, 0, 1, 0, '2020-12-29 13:37:58', '2020-12-29 13:37:58');
INSERT INTO `blog_res_article_classify` VALUES (5, 16, 1, 0, '2020-12-30 14:03:00', '2020-12-30 14:03:00');
INSERT INTO `blog_res_article_classify` VALUES (9, 20, 1, 0, '2020-12-30 16:00:24', '2020-12-30 16:00:24');
INSERT INTO `blog_res_article_classify` VALUES (10, 21, 1, 0, '2020-12-30 16:14:17', '2020-12-30 16:14:17');
INSERT INTO `blog_res_article_classify` VALUES (11, 22, 1, 0, '2020-12-30 16:52:47', '2020-12-30 16:52:47');

-- ----------------------------
-- Table structure for blog_res_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_res_article_tag`;
CREATE TABLE `blog_res_article_tag`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `article_id` int(11) NOT NULL COMMENT '文章ID',
  `tag_id` int(11) NOT NULL COMMENT '分类ID',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加数据时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改数据时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_res_article_tag
-- ----------------------------
INSERT INTO `blog_res_article_tag` VALUES (17, 20, 5, 0, '2021-01-12 18:17:30', '2021-01-12 18:17:30');
INSERT INTO `blog_res_article_tag` VALUES (19, 20, 2, 0, '2021-01-12 18:37:03', '2021-01-12 18:37:03');

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标签名',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '标签所属用户',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '标签添加时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '标签修改时间',
  `deleted` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES (1, '标签一', 1, '2021-01-12 14:26:47', '2021-01-12 14:26:52', 0);
INSERT INTO `blog_tag` VALUES (2, '标签二', 1, '2021-01-12 14:27:03', '2021-01-12 14:27:08', 0);
INSERT INTO `blog_tag` VALUES (3, '标签三', 1, '2021-01-12 15:13:53', '2021-01-12 15:13:53', 0);
INSERT INTO `blog_tag` VALUES (4, '标签四', 1, '2021-01-12 15:16:11', '2021-01-12 15:16:11', 0);
INSERT INTO `blog_tag` VALUES (5, '标签五', 1, '2021-01-12 15:17:21', '2021-01-12 15:17:21', 0);

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
  `real_age` int(3) NULL DEFAULT NULL COMMENT '真实年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '插入数据时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改数据时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '删除状态',
  `user_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES (1, NULL, 'a', 'a', NULL, 1, NULL, 'a', NULL, NULL, NULL, NULL);
INSERT INTO `blog_user` VALUES (2, NULL, 'b', 'b', NULL, 2, NULL, 'b', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
