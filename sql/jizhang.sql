/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost:3306
 Source Schema         : jizhang

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 04/09/2021 15:37:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `class_bg` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `class_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `bill_type` int(8) DEFAULT NULL,
  `amount_of_money` double(20, 2) DEFAULT NULL,
  `create_date` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'cuIcon-taxi', 'green', '出租车', '', 1, 100.00, '2021-09-03 18:03:39', 3);
INSERT INTO `book` VALUES (2, 'cuIcon-same', 'red', '买花', '', 1, 50.00, '2021-09-03 18:03:42', 3);
INSERT INTO `book` VALUES (3, 'cuIcon-taxi', 'green', '出租车', '打车去咖啡厅', 1, 55.00, '2021-09-02 18:03:47', 3);
INSERT INTO `book` VALUES (4, 'cuIcon-like', 'blue', '兼职', '', 2, 300.00, '2021-09-04 15:01:37', 3);
INSERT INTO `book` VALUES (5, 'cuIcon-same', 'red', '买花', '', 1, 33.00, '2021-09-04 15:03:56', 1);

-- ----------------------------
-- Table structure for book_class_t
-- ----------------------------
DROP TABLE IF EXISTS `book_class_t`;
CREATE TABLE `book_class_t`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `icon_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图标',
  `bg_color` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '背景色',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '名字',
  `bill_type` int(20) DEFAULT NULL COMMENT '账单类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book_class_t
-- ----------------------------
INSERT INTO `book_class_t` VALUES (1, 'cuIcon-same', 'red', '买花', 1);
INSERT INTO `book_class_t` VALUES (2, 'cuIcon-taxi', 'green', '出租车', 1);
INSERT INTO `book_class_t` VALUES (3, 'cuIcon-like', 'blue', '兼职', 2);
INSERT INTO `book_class_t` VALUES (5, 'cuIcon-profile', 'orange', '工资收入', 2);

-- ----------------------------
-- Table structure for user_info_t
-- ----------------------------
DROP TABLE IF EXISTS `user_info_t`;
CREATE TABLE `user_info_t`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像地址',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `province` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '省',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '市',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '电话',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '密码',
  `open_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '微信登录唯一ID',
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info_t
-- ----------------------------
INSERT INTO `user_info_t` VALUES (1, '微信用户', 'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132', 0, '', '', '13275001111', '111111', '0211s5ll2TFWz74sQNll26p9C621s5lK', 'user');
INSERT INTO `user_info_t` VALUES (2, '微信用户', 'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132', 0, '', '', '13275001112', '111111', '071UZ0100b8SfM1ZI5300j2JDH1UZ01o', 'user');
INSERT INTO `user_info_t` VALUES (3, '微信用户', 'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132', 0, '', '', '13275006970', '111111', 'o5H4Q6W-pQ5Mz7Mne1XLqbncf5ng', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
