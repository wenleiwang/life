/*
 Navicat Premium Data Transfer

 Source Server         : 自己阿里服务器
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 39.108.141.221:3306
 Source Schema         : poesy_life

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 06/08/2021 07:53:35
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
  `classify_id` int(11) NULL DEFAULT NULL COMMENT '分类ID',
  `user_id` int(11) NOT NULL COMMENT '文章所属用户',
  `add_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '0-发布；1-删除；2-草稿',
  `star_num` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '点赞数量',
  `comment_num` int(11) NULL DEFAULT NULL COMMENT '评论数量',
  `collect_num` int(11) NULL DEFAULT NULL COMMENT '收藏数量',
  `star_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启点赞',
  `comment_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启评论',
  `collect_status` tinyint(1) NULL DEFAULT NULL COMMENT '是否开启收藏',
  `article_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '首图',
  `article_flag` int(2) NULL DEFAULT NULL COMMENT '文章标志 0-原创；1-转载；2-翻译；',
  `view_num` int(11) NULL DEFAULT 0 COMMENT '浏览数',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES (16, '沙发上阿发FDAWFE', '分分啊发分为afaSD', '分分啊发分为afaSD', '杂谈', 8, 1, '2020-12-30 14:02:46', '2020-12-30 14:02:46', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/6c9a178e8a2791a3b5606f9cfc015cf22c180b875ba8f-mC5lts_fw658/format/webp', 0, 2);
INSERT INTO `blog_article` VALUES (20, '为预览提供的测试文档', '# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题', '# 这是一级标题\n![Netty.png](http://img.poesy.ink/Fo0irmFD0uut218XqGoKnq8hu7re)\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题2\n大师傅IE\n### 这是二级标题的三级标题2\n范德萨见覅额\n----\n> 这里是引用\n\n这里是代码\n```java\npublic ResponseBase updateArticle(@RequestBody ArticleRequest article){\n        UserInfo userContext = UserContext.getUserContext();\n        if(userContext == null){\n            return new ResponseBase().fail(\"用户登录失败，请重新登录！\");\n        }\n        return adminArticleService.updateArticle(article,userContext);\n    }\n```\n# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题2\n大师傅IE\n### 这是二级标题的三级标题2\n范德萨见覅额\n\n----\n\n>这里是引用\n\n\n这里是代码\n\n```java\npublic ResponseBase updateArticle(@RequestBody ArticleRequest article){\n        UserInfo userContext = UserContext.getUserContext();\n        if(userContext == null){\n            return new ResponseBase().fail(\"用户登录失败，请重新登录！\");\n        }\n        return adminArticleService.updateArticle(article,userContext);\n    }\n```', '历史', 9, 1, '2020-12-30 16:00:24', '2021-04-02 17:52:52', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/25fe5381aa9cb19de79be4abb0755eca6d0db13f477f2-9bzSyh_fw658/format/webp', 1, 7);
INSERT INTO `blog_article` VALUES (21, '个人年终工作总结', '个人年终工作总结\n时间飞逝，转眼已经来到这里四个月，回顾这段时间的成长，收获颇多，感慨颇多。刚来时，在领导和同事的带领下熟悉业务，同时也着手参与小部分功能。在工作上，项目进度把控合理，需求分析到位，大', '个人年终工作总结\n时间飞逝，转眼已经来到这里四个月，回顾这段时间的成长，收获颇多，感慨颇多。刚来时，在领导和同事的带领下熟悉业务，同时也着手参与小部分功能。在工作上，项目进度把控合理，需求分析到位，大家一起沟通愉快。在生活上领导同事的亲切与关怀，让我洋溢着喜悦。身处这样工作环境下，我感到了我的进步和喜悦，在这里感谢我的领导和同事对我的关怀与帮助。\n一、本年度工作回顾\n1.参与熟悉历史业务。在我读取研究成熟业务部分时，严谨的逻辑、新颖的思维，对我的思维逻辑有极大的提升；在我使用工具时，由于涉及工具广泛且要求精准，对我的技术广度深度都做了更深层次的要求。\n2.参与存房2.0业务的部分开发工作。存房2.0业务整合C端、B端、S端，成为一个更为完整的业务功能，它打通了CBS三端的业务数据的交互，这里需要更为严谨的逻辑，更为准确的数据，更为有效的沟通，做好这项工作对沟通和技术都提出高要求。\n参与进这样的工作中，紧跟着项目我感到了我的进步。端正态度，热爱本职工作，尽到自己本份，尽力完成应该做的事情，这是我的优点，在努力工作时也收获到了技术能力的成长，但也感到自己的不足，在以后的时光抓紧时间弥补自己的不足。\n二、来年工作的展望\n1.严于律己。事业是学生事业的延续在空闲时，深度学习基础知识，不断扩展自己的知识储备以达到广度的积累，使自己技术深度广度得到提高。\n2. 加强沟通，同事之间要坦诚、宽容、沟通和信任。工作中有些问题往往就是因为没有及时沟通引起的，以后工作中要与领导与同事加强沟通。\n3.依然热爱工作，以端正的态度，尽到自己的本分，尽力完成应进之事。\n4.“士不可以不弘毅，任重而道远”，希望自己的工作可以作为公司最坚固的一块砖。 \n在以后的工作中，我一定会扬长避短，克服不足、认真学习、发奋工作、积极进取、尽快成长，把工作做的更好。我已经准备好我全部的心和热情，让新的一年和新的学习过程早点开始。\n', '杂谈', 8, 1, '2020-12-30 16:14:17', '2021-01-18 20:03:10', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/c66074d69cc700028232d62daa554a4f291660c638fa5-WoX4AD_fw658/format/webp', 2, 8);
INSERT INTO `blog_article` VALUES (22, '2否232水电费', '# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题', '# 这是一级标题\n巴拉巴拉\n## 这里是二级标题\n弗拉随机发\n## 这是二级标题\n答非啊\n### 这是二级标题的三级标题1\n发斯蒂芬就爱看\n#### 这是四级标题1\n额发而发\n#### 这里是四级标题2\n大师傅IE\n### 这是二级标题的三级标题2\n范德萨见覅额\n----\n>这里是引用\n\n这里是代码\n```java\npublic ResponseBase updateArticle(@RequestBody ArticleRequest article){\n        UserInfo userContext = UserContext.getUserContext();\n        if(userContext == null){\n            return new ResponseBase().fail(\"用户登录失败，请重新登录！\");\n        }\n        return adminArticleService.updateArticle(article,userContext);\n    }\n```', '杂谈', 8, 1, '2020-12-30 16:51:54', '2020-12-30 16:51:54', 0, 0, 0, 0, 1, 1, 1, 'https://hbimg.huabanimg.com/eee2251fd4b7de27fdc390b3501ebfa863f1a5dd7fa47-DAmJZg_fw658/format/webp', 0, 8);
INSERT INTO `blog_article` VALUES (23, '发送到发', '方法阿斯蒂芬', '方法阿斯蒂芬', '杂谈', 8, 1, '2021-01-08 17:46:42', '2021-01-08 17:46:42', 2, 0, 0, 0, 1, 1, 1, '', NULL, 0);
INSERT INTO `blog_article` VALUES (24, '测试预览按钮', '测试预览按钮', '测试预览按钮', '杂谈', 8, 1, '2021-01-08 17:50:26', '2021-01-08 17:50:26', 0, 0, 0, 0, 1, 1, 1, '', 0, 8);
INSERT INTO `blog_article` VALUES (25, '测试图片调整大小', '![image.png](http://img.poesy.ink/FqWIGae2cz1lyHUYZK_KPXY8hOaz)', '![image.png](http://img.poesy.ink/FqWIGae2cz1lyHUYZK_KPXY8hOaz)\n手法和玩法代核发违法打死非我可能使肌肤哇卡上到能发货咦安慰法看时间hi 按我if你上课的我分咖啡UI微分会计师大部分晚饭开始的呢覅五河思考京东方hi我嗯肯定是金牛范围焚枯食淡能分开下午二分开始的呢覅无额饭袋访问外恶妇开始的呢福娃反馈绝对是你看哇离开你啥这上哪覅发多开心呢违法和丸发生的可能无解肥撒', '杂谈', 8, 1, '2021-03-29 22:28:56', '2021-03-29 22:34:27', 0, 0, 0, 0, 1, 1, 1, 'http://img.poesy.ink/FqWIGae2cz1lyHUYZK_KPXY8hOaz', 0, 10);
INSERT INTO `blog_article` VALUES (26, '本博客VUE项目部署服务器', '# 0.前言\n经过一段时间的探索，前端后端都有大致的样子了。下面就是部署到服务器，让我的博客项目公布在网上啦~~\n![image.png](http://img.poesy.ink/FpzYIZniS', '# 0.前言\n经过一段时间的探索，前端后端都有大致的样子了。下面就是部署到服务器，让我的博客项目公布在网上啦~~\n![image.png](http://img.poesy.ink/FpzYIZniS7GQf-S6CHNGcQ2cEFGS)\n# 1.前端部署\n## 1.1服务器准备\nNginx环境\n后端接口——想要完全的效果提前部署好\n## 1.2前端打包准备\n终端运行命令 npm run build\n其实它就是个静态文件，在哪访问都一样\n### 1.2.1 静态路径问题\n点击index.html，通过浏览器运行，出现以下报错，如图\n![image.png](http://img.poesy.ink/FrSZWRY7lUNOBhiQEDt_JNelta3n)\n具体步骤如下：\n1、找到配置文件\n修改\n![image.png](http://img.poesy.ink/FrKEuMvLb_8wfT2gL9F4cQl3amF-)\n2、找到配置文件\n修改\n![image.png](http://img.poesy.ink/Fh9HhKTVnvVHx35LDdCoZORa1JD4)\n3、终端运行 npm run build 即可。\n此时点击index.html，通过浏览器运行便，会发现动态绑定的static的图片找不到，故static必须使用绝对路径。将图片路径修改为绝对路径，至此，打包完成\n### 1.2.2不报错但也不显示任何页面\n出现原因：\nrouter文件夹内部的index.js的mode模式导致\nhash模式会带来#，很丑，想去调#可以改成history\n1. 开发阶段history模式不会有#，但是打包上线后，需要后端帮忙指定项目根目录\n2. hash模式可以不需要后端帮忙，只会多个#而已\n如何解决：\n1. 注释或换成hash模式\n2. 使用Nginx，修改Nginx配置来映射路径\n\n\n## 1.3修改Nginx配置\n![image.png](http://img.poesy.ink/FnqKeL5Z7sP7KDOQDy-K3H2PqPfc)\n# 2.解决发现问题\n## 2.1点击文章详情发现我static里的图片加载404\n![image.png](http://img.poesy.ink/Fg8nCVo9HXDRMnbhe4YyNLSQGwGx)\n看路径是多了一层/show\nhistory模式导致，把下图的./改回/；再重新部署，就是在本地直接打开会报资源找不到\n![image.png](http://img.poesy.ink/Fh9HhKTVnvVHx35LDdCoZORa1JD4)\n## 2.2vue打包生成的文件的js文件过大的优化\n### 2.2.1去掉生成map文件\n打包时会生成map文件，而map文件通常都比较大，可以取消生成map文件\nconfig/index.js找到productionSourceMap把true改成false\n### 2.2.2代码压缩\nconfig/index.js 找到 productionGzip 把 false 改为 true\n安装插件\nnpm install compression-webpack-plugin --save-dev\n在根目录新建文件vue.config.js\n```javascript\nconst path = require(\'path\');\n\nconst webpack = require(\'webpack\')\nconst CompressionWebpackPlugin = require(\'compression-webpack-plugin\')\nconst productionGzipExtensions = [\'js\', \'css\']\nconst isProduction = process.env.NODE_ENV === \'production\'\n\nconst PrerenderSPAPlugin = require(\'prerender-spa-plugin\');\nconst Renderer = PrerenderSPAPlugin.PuppeteerRenderer;\n\n\n\nmodule.exports = {\n  publicPath: \'/\',\n  lintOnSave: false,\n  devServer: {\n    open: true,      // 运行项目时，是否自动开启新窗口。\n    host: \'127.0.0.1\',  // 手机测试端口号。//主机名字  locahost 或 127.0.0.0 或 真机测试 0.0.0.0\n    port: 3000,     // 默认端口号\n\n  },\n  configureWebpack: {\n    resolve: {\n      alias: {\n        \'@\': path.resolve(__dirname, \'./src\'),\n        \'@i\': path.resolve(__dirname, \'./src/assets\'),\n      }\n    },\n    plugins: [\n      new webpack.IgnorePlugin(/^\\.\\/locale$/, /moment$/),\n\n      // 下面是下载的插件的配置\n      new CompressionWebpackPlugin({\n        algorithm: \'gzip\',\n        test: new RegExp(\'\\\\.(\' + productionGzipExtensions.join(\'|\') + \')$\'),\n        threshold: 10240,\n        minRatio: 0.8\n      }),\n      new webpack.optimize.LimitChunkCountPlugin({\n        maxChunks: 5,\n        minChunkSize: 100\n      }),\n      new PrerenderSPAPlugin({\n        staticDir: path.join(__dirname, \'dist\'),\n        routes: [\'/\', \'/home\', \'/login\', \'/interviewList\', \'/interviewDetail\'],\n        renderer: new PrerenderSPAPlugin.PuppeteerRenderer({\n          renderAfterTime: 5000\n        })\n      })\n    ]\n  }\n}\n```\n\n修改Nginx配置文件在http全局里开启gzip\n配置后实测不生效，经过一翻排查，问题最终锁定在了gzip_types类型上，确保覆盖了你希望压缩的文件类型\n全部Nginx配置文件内容：\n\n```JSON\nuser www www;\nworker_processes 2; #设置值和CPU核心数一致\nerror_log /usr/local/webserver/nginx/logs/nginx_error.log crit; #日志位置和日志级别\npid /usr/local/webserver/nginx/nginx.pid;\n#Specifies the value for maximum file descriptors that can be opened by this process.\nworker_rlimit_nofile 65535;\nevents\n{\n  use epoll;\n  worker_connections 65535;\n}\nhttp\n{\n  include mime.types;\n  default_type application/octet-stream;\n  log_format main  \'$remote_addr - $remote_user [$time_local] \"$request\" \'\n               \'$status $body_bytes_sent \"$http_referer\" \'\n               \'\"$http_user_agent\" $http_x_forwarded_for\';\n  \n#charset gb2312;\n     \n  server_names_hash_bucket_size 128;\n  client_header_buffer_size 32k;\n  large_client_header_buffers 4 32k;\n  client_max_body_size 8m;\n     \n  sendfile on;\n  tcp_nopush on;\n  keepalive_timeout 60;\n  tcp_nodelay on;\n  fastcgi_connect_timeout 300;\n  fastcgi_send_timeout 300;\n  fastcgi_read_timeout 300;\n  fastcgi_buffer_size 64k;\n  fastcgi_buffers 4 64k;\n  fastcgi_busy_buffers_size 128k;\n  fastcgi_temp_file_write_size 128k;\n  gzip on; \n  gzip_min_length 1k;\n  gzip_buffers 4 16k;\n  gzip_http_version 1.0;\n  gzip_comp_level 2;\n  gzip_types text/plain application/javascript application/x-javascript text/css application/xml text/javascript application/x-httpd-php image/jpeg image/gif image/png;\n  gzip_vary on;\n \n  #limit_zone crawler $binary_remote_addr 10m;\n #下面是server虚拟主机的配置\n server\n  {\n    listen 80;#监听端口\n    server_name localhost;#域名\n    index index.html index.htm index.php;\n    root /usr/local/webserver/nginx/html;#站点目录\n      location ~ .*\\.(php|php5)?$\n    {\n      #fastcgi_pass unix:/tmp/php-cgi.sock;\n      fastcgi_pass 127.0.0.1:9000;\n      fastcgi_index index.php;\n      include fastcgi.conf;\n    }\n    location ^~ /api {\n        proxy_pass   http://39.108.141.221:2716/;\n        add_header Access-Control-Allow-Methods *;\n        add_header Access-Control-Max-Age 3600;\n        add_header Access-Control-Allow-Credentials true;\n        add_header Access-Control-Allow-Origin $http_origin;\n        add_header Access-Control-Allow-Headers $http_access_control_request_headers;\n        if ($request_method = OPTIONS ) {\n            return 200;\n        }\n    }\n    location ~ .*\\.(gif|jpg|jpeg|png|bmp|swf|ico)$\n    {\n      expires 30d;\n      #root /static/img;\n  # access_log off;\n    }\n    location ~ .*\\.(js|css)?$\n    {\n      expires 15d;\n   # access_log off;\n    }\n    access_log off;\n  }\n\n}\n\n```\n\n### 2.2.3 Element UI引入了全部改成部分引入\n', 'java', 5, 1, '2021-04-02 20:04:12', '2021-04-02 21:47:47', 0, 0, 0, 0, 1, 1, 1, 'http://img.poesy.ink/FpzYIZniS7GQf-S6CHNGcQ2cEFGS', 0, 9);

-- ----------------------------
-- Table structure for blog_classify
-- ----------------------------
DROP TABLE IF EXISTS `blog_classify`;
CREATE TABLE `blog_classify`  (
  `classify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `classify_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分类名',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '分类所属用户',
  `add_time` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`classify_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_classify
-- ----------------------------
INSERT INTO `blog_classify` VALUES (2, '数据结果', 1, '2020-11-11 10:46:04', '2020-11-11 10:46:07', 0);
INSERT INTO `blog_classify` VALUES (5, 'java', 1, '2021-04-02 20:15:33', '2021-04-02 20:15:36', 0);
INSERT INTO `blog_classify` VALUES (6, '高等数学', 1, '2021-01-11 18:55:36', '2021-01-11 18:55:41', 0);
INSERT INTO `blog_classify` VALUES (7, '文化', 1, '2021-01-12 09:28:40', '2021-01-12 09:28:40', 0);
INSERT INTO `blog_classify` VALUES (8, '杂谈', 1, '2021-01-12 09:57:42', '2021-01-12 09:57:42', 0);
INSERT INTO `blog_classify` VALUES (9, '历史', 1, '2021-03-21 09:47:42', '2021-03-21 09:47:44', 0);

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
  `add_time` datetime NULL DEFAULT NULL COMMENT '评论添加时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '评论修改时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

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
  `add_time` datetime NULL DEFAULT NULL COMMENT '添加数据时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改数据时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

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
  `add_time` datetime NULL DEFAULT NULL COMMENT '添加数据时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改数据时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_res_article_tag
-- ----------------------------
INSERT INTO `blog_res_article_tag` VALUES (17, 20, 5, 0, '2021-01-12 18:17:30', '2021-01-12 18:17:30');
INSERT INTO `blog_res_article_tag` VALUES (19, 20, 2, 0, '2021-01-12 18:37:03', '2021-01-12 18:37:03');
INSERT INTO `blog_res_article_tag` VALUES (20, 25, 1, 0, '2021-03-29 22:28:56', '2021-03-29 22:28:56');
INSERT INTO `blog_res_article_tag` VALUES (21, 26, 6, 0, '2021-04-02 20:04:12', '2021-04-02 20:04:12');

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
  `deleted` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES (1, '标签一', 1, '2021-01-12 14:26:47', '2021-01-12 14:26:52', 0);
INSERT INTO `blog_tag` VALUES (2, '标签二', 1, '2021-01-12 14:27:03', '2021-01-12 14:27:08', 0);
INSERT INTO `blog_tag` VALUES (3, '标签三', 1, '2021-01-12 15:13:53', '2021-01-12 15:13:53', 0);
INSERT INTO `blog_tag` VALUES (4, '标签四', 1, '2021-01-12 15:16:11', '2021-01-12 15:16:11', 0);
INSERT INTO `blog_tag` VALUES (5, '标签五', 1, '2021-01-12 15:17:21', '2021-01-12 15:17:21', 0);
INSERT INTO `blog_tag` VALUES (6, '前端VUE', 1, '2021-04-02 19:56:47', '2021-04-02 19:56:47', 0);

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
  `add_time` datetime NULL DEFAULT NULL COMMENT '插入数据时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改数据时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '删除状态',
  `user_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES (1, 'admin', 'adminTest1-.-', 'a', NULL, 1, NULL, 'a', NULL, NULL, NULL, NULL);
INSERT INTO `blog_user` VALUES (2, 'test', '123', 'b', NULL, 2, NULL, 'b', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
