/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : projectmanage

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-02-13 21:08:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry` (
  `id` varchar(32) NOT NULL COMMENT '行业ID',
  `name` varchar(30) DEFAULT NULL COMMENT '行业名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `status_flag` char(1) DEFAULT '' COMMENT '状态（0：正常 1：禁用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of industry
-- ----------------------------
INSERT INTO `industry` VALUES ('1222868534409822208', '政要', '2020-01-30 13:05:53', '1', '2020-02-08 07:28:27', '1', '0');
INSERT INTO `industry` VALUES ('1222870896457285632', '生态', '2020-01-30 13:15:18', '1', null, null, '1');

-- ----------------------------
-- Table structure for keyword
-- ----------------------------
DROP TABLE IF EXISTS `keyword`;
CREATE TABLE `keyword` (
  `id` varchar(32) NOT NULL COMMENT '关键词id',
  `name` varchar(30) DEFAULT NULL COMMENT '关键词名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `status_flag` char(1) DEFAULT '' COMMENT '状态（0：正常 1：禁用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of keyword
-- ----------------------------
INSERT INTO `keyword` VALUES ('1226039684233166848', '5G', '2020-02-08 07:06:56', '1', null, null, '0');
INSERT INTO `keyword` VALUES ('1226061629506977792', '互联网', '2020-02-08 08:34:08', '1', null, null, '0');
INSERT INTO `keyword` VALUES ('1226061680992059392', '医疗', '2020-02-08 08:34:19', '1', null, null, '0');

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` decimal(19,0) NOT NULL COMMENT 'id',
  `name` varchar(30) DEFAULT NULL COMMENT '组织机构名称',
  `is_parent` char(1) DEFAULT NULL COMMENT '是否为父节点（1：是，0：否）',
  `parent_id` decimal(19,0) DEFAULT NULL COMMENT '父节点ID',
  `region_id` varchar(30) DEFAULT NULL COMMENT '所属行政区',
  `parent_code` varchar(30) DEFAULT NULL COMMENT '父节点编码',
  `code` int(255) DEFAULT NULL COMMENT '节点编码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `delete_flag` char(1) DEFAULT NULL COMMENT '是否删除（0：否，1：是）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('1213651276961677312', '省集成BU', '1', '0', '35', '1/', '1', '2020-01-05 02:39:48', '1', null, null, '0');
INSERT INTO `organization` VALUES ('1213988863513460736', '支撑一部', '0', '1213651276961677312', '35', '1/2/', '2', '2020-01-06 01:01:19', '1', null, null, '0');
INSERT INTO `organization` VALUES ('1213989101942865920', '支撑二部', '0', '1213651276961677312', '35', '1/3/', '3', '2020-01-06 01:02:12', '1', null, null, '0');
INSERT INTO `organization` VALUES ('1213989231546859520', '外派驻点', '0', '1213651276961677312', '35', '1/4/', '4', '2020-01-06 01:02:42', '1', null, null, '0');
INSERT INTO `organization` VALUES ('1213989305551159296', '综合事务', '0', '1213651276961677312', '35', '1/5/', '5', '2020-01-06 01:03:00', '1', null, null, '0');
INSERT INTO `organization` VALUES ('1214384115642531840', '省集成', '0', '1213651276961677300', '35', '7/', '7', '2020-01-07 03:11:55', '1', null, null, '0');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '用户中心', 'user:add');
INSERT INTO `permission` VALUES ('2', '会员中心', 'user:vip');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` varchar(32) NOT NULL COMMENT '主键id',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `region_id` varchar(11) DEFAULT NULL COMMENT '行政区域id',
  `industry_id` varchar(32) DEFAULT NULL COMMENT '行业ID',
  `project_stage` char(255) DEFAULT NULL COMMENT '项目阶段。0：商机；1：解决方案（可研）；2：招标；3：投标；4：实施；5：验收；6：维护',
  `project_manager_id` varchar(32) DEFAULT NULL COMMENT '项目经理id',
  `estimated_amount` double(10,4) DEFAULT NULL COMMENT '预估金额',
  `contract_date` datetime DEFAULT NULL COMMENT '签订合同日期',
  `contract_amount` double(255,0) DEFAULT NULL COMMENT '合同金额',
  `intended_completion_date` datetime DEFAULT NULL COMMENT '计划完成日期',
  `contract_period` varchar(255) DEFAULT NULL COMMENT '合同工期',
  `project_info` varchar(255) DEFAULT NULL COMMENT '项目详情-描述',
  `assignable_project_score` int(255) DEFAULT NULL COMMENT '可分配的项目积分',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `status_flag` char(1) DEFAULT '' COMMENT '状态（0：正常 1：禁用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('1226129355042717696', '项目名称', '35', '1', '0', '1', '1.0000', '2020-02-07 16:00:00', '1', '2020-02-07 16:00:00', '2020-02-08', '项目详情-描述', '1', '2020-02-08 13:03:13', '1', null, null, '0');

-- ----------------------------
-- Table structure for project_keyword_relation
-- ----------------------------
DROP TABLE IF EXISTS `project_keyword_relation`;
CREATE TABLE `project_keyword_relation` (
  `id` varchar(32) NOT NULL,
  `keyword_id` varchar(32) DEFAULT NULL,
  `project_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project_keyword_relation
-- ----------------------------
INSERT INTO `project_keyword_relation` VALUES ('1226129368623874048', '1226039684233166848', '1226129355042717696');
INSERT INTO `project_keyword_relation` VALUES ('1226129368623874049', '1226061629506977792', '1226129355042717696');

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `id` varchar(255) NOT NULL COMMENT '行政区域ID',
  `name` varchar(255) DEFAULT NULL COMMENT '行政区域名称',
  `parent_id` varchar(255) DEFAULT NULL COMMENT '父节点ID',
  `is_parent` char(1) DEFAULT NULL COMMENT '是否为父节点（1：是，0：否）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of region
-- ----------------------------
INSERT INTO `region` VALUES ('35', '福建省', '0', '1');
INSERT INTO `region` VALUES ('3501', '福州市', '35', '1');
INSERT INTO `region` VALUES ('350102', '鼓楼区', '3501', '0');
INSERT INTO `region` VALUES ('350103', '台江区', '3501', '0');
INSERT INTO `region` VALUES ('350104', '仓山区', '3501', '0');
INSERT INTO `region` VALUES ('350105', '马尾区', '3501', '0');
INSERT INTO `region` VALUES ('350111', '晋安区', '3501', '0');
INSERT INTO `region` VALUES ('350112', '长乐区', '3501', '0');
INSERT INTO `region` VALUES ('350121', '闽侯县', '3501', '0');
INSERT INTO `region` VALUES ('350122', '连江县', '3501', '0');
INSERT INTO `region` VALUES ('350123', '罗源县', '3501', '0');
INSERT INTO `region` VALUES ('350124', '闽清县', '3501', '0');
INSERT INTO `region` VALUES ('350125', '永泰县', '3501', '0');
INSERT INTO `region` VALUES ('350128', '平潭县', '3501', '0');
INSERT INTO `region` VALUES ('350181', '福清市', '3501', '0');
INSERT INTO `region` VALUES ('3502', '厦门市', '35', '1');
INSERT INTO `region` VALUES ('350203', '思明区', '3502', '0');
INSERT INTO `region` VALUES ('350205', '海沧区', '3502', '0');
INSERT INTO `region` VALUES ('350206', '湖里区', '3502', '0');
INSERT INTO `region` VALUES ('350211', '集美区', '3502', '0');
INSERT INTO `region` VALUES ('350212', '同安区', '3502', '0');
INSERT INTO `region` VALUES ('350213', '翔安区', '3502', '0');
INSERT INTO `region` VALUES ('3503', '莆田市', '35', '1');
INSERT INTO `region` VALUES ('350302', '城厢区', '3503', '0');
INSERT INTO `region` VALUES ('350303', '涵江区', '3503', '0');
INSERT INTO `region` VALUES ('350304', '荔城区', '3503', '0');
INSERT INTO `region` VALUES ('350305', '秀屿区', '3503', '0');
INSERT INTO `region` VALUES ('350322', '仙游县', '3503', '0');
INSERT INTO `region` VALUES ('3504', '三明市', '35', '1');
INSERT INTO `region` VALUES ('350402', '梅列区', '3504', '0');
INSERT INTO `region` VALUES ('350403', '三元区', '3504', '0');
INSERT INTO `region` VALUES ('350421', '明溪县', '3504', '0');
INSERT INTO `region` VALUES ('350423', '清流县', '3504', '0');
INSERT INTO `region` VALUES ('350424', '宁化县', '3504', '0');
INSERT INTO `region` VALUES ('350425', '大田县', '3504', '0');
INSERT INTO `region` VALUES ('350426', '尤溪县', '3504', '0');
INSERT INTO `region` VALUES ('350427', '沙县', '3504', '0');
INSERT INTO `region` VALUES ('350428', '将乐县', '3504', '0');
INSERT INTO `region` VALUES ('350429', '泰宁县', '3504', '0');
INSERT INTO `region` VALUES ('350430', '建宁县', '3504', '0');
INSERT INTO `region` VALUES ('350481', '永安市', '3504', '0');
INSERT INTO `region` VALUES ('3505', '泉州市', '35', '1');
INSERT INTO `region` VALUES ('350502', '鲤城区', '3505', '0');
INSERT INTO `region` VALUES ('350503', '丰泽区', '3505', '0');
INSERT INTO `region` VALUES ('350504', '洛江区', '3505', '0');
INSERT INTO `region` VALUES ('350505', '泉港区', '3505', '0');
INSERT INTO `region` VALUES ('350521', '惠安县', '3505', '0');
INSERT INTO `region` VALUES ('350524', '安溪县', '3505', '0');
INSERT INTO `region` VALUES ('350525', '永春县', '3505', '0');
INSERT INTO `region` VALUES ('350526', '德化县', '3505', '0');
INSERT INTO `region` VALUES ('350527', '金门县', '3505', '0');
INSERT INTO `region` VALUES ('350581', '石狮市', '3505', '0');
INSERT INTO `region` VALUES ('350582', '晋江市', '3505', '0');
INSERT INTO `region` VALUES ('350583', '南安市', '3505', '0');
INSERT INTO `region` VALUES ('3506', '漳州市', '35', '1');
INSERT INTO `region` VALUES ('350602', '芗城区', '3506', '0');
INSERT INTO `region` VALUES ('350603', '龙文区', '3506', '0');
INSERT INTO `region` VALUES ('350622', '云霄县', '3506', '0');
INSERT INTO `region` VALUES ('350623', '漳浦县', '3506', '0');
INSERT INTO `region` VALUES ('350624', '诏安县', '3506', '0');
INSERT INTO `region` VALUES ('350625', '长泰县', '3506', '0');
INSERT INTO `region` VALUES ('350626', '东山县', '3506', '0');
INSERT INTO `region` VALUES ('350627', '南靖县', '3506', '0');
INSERT INTO `region` VALUES ('350628', '平和县', '3506', '0');
INSERT INTO `region` VALUES ('350629', '华安县', '3506', '0');
INSERT INTO `region` VALUES ('350681', '龙海市', '3506', '0');
INSERT INTO `region` VALUES ('3507', '南平市', '35', '1');
INSERT INTO `region` VALUES ('350702', '延平区', '3507', '0');
INSERT INTO `region` VALUES ('350703', '建阳区', '3507', '0');
INSERT INTO `region` VALUES ('350721', '顺昌县', '3507', '0');
INSERT INTO `region` VALUES ('350722', '浦城县', '3507', '0');
INSERT INTO `region` VALUES ('350723', '光泽县', '3507', '0');
INSERT INTO `region` VALUES ('350724', '松溪县', '3507', '0');
INSERT INTO `region` VALUES ('350725', '政和县', '3507', '0');
INSERT INTO `region` VALUES ('350781', '邵武市', '3507', '0');
INSERT INTO `region` VALUES ('350782', '武夷山市', '3507', '0');
INSERT INTO `region` VALUES ('350783', '建瓯市', '3507', '0');
INSERT INTO `region` VALUES ('3508', '龙岩市', '35', '1');
INSERT INTO `region` VALUES ('350802', '新罗区', '3508', '0');
INSERT INTO `region` VALUES ('350803', '永定区', '3508', '0');
INSERT INTO `region` VALUES ('350821', '长汀县', '3508', '0');
INSERT INTO `region` VALUES ('350823', '上杭县', '3508', '0');
INSERT INTO `region` VALUES ('350824', '武平县', '3508', '0');
INSERT INTO `region` VALUES ('350825', '连城县', '3508', '0');
INSERT INTO `region` VALUES ('350881', '漳平市', '3508', '0');
INSERT INTO `region` VALUES ('3509', '宁德市', '35', '1');
INSERT INTO `region` VALUES ('350902', '蕉城区', '3509', '0');
INSERT INTO `region` VALUES ('350921', '霞浦县', '3509', '0');
INSERT INTO `region` VALUES ('350922', '古田县', '3509', '0');
INSERT INTO `region` VALUES ('350923', '屏南县', '3509', '0');
INSERT INTO `region` VALUES ('350924', '寿宁县', '3509', '0');
INSERT INTO `region` VALUES ('350925', '周宁县', '3509', '0');
INSERT INTO `region` VALUES ('350926', '柘荣县', '3509', '0');
INSERT INTO `region` VALUES ('350981', '福安市', '3509', '0');
INSERT INTO `region` VALUES ('350982', '福鼎市', '3509', '0');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL COMMENT '角色ID',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `status_flag` char(1) DEFAULT NULL COMMENT '是否可编辑可删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `delete_flag` char(1) DEFAULT NULL COMMENT '是否删除（0：否，1：是）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '领导', null, null, null, null, null, null);
INSERT INTO `role` VALUES ('2', '副总', null, null, null, null, null, null);
INSERT INTO `role` VALUES ('3', 'BU负责人', null, null, null, null, null, null);
INSERT INTO `role` VALUES ('4', '支撑组组长', null, null, null, null, null, null);
INSERT INTO `role` VALUES ('5', '项目管理', null, null, null, null, null, null);
INSERT INTO `role` VALUES ('6', '市场支撑', null, null, null, null, null, null);
INSERT INTO `role` VALUES ('7', '派驻支撑', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL COMMENT '用户ID',
  `mss` varchar(30) NOT NULL COMMENT '用户账号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `real_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `user_code` varchar(7) DEFAULT NULL COMMENT '员工编号',
  `employ_type` varchar(7) DEFAULT NULL COMMENT '用工形式：合同制，经营性外包',
  `ethnic_group` varchar(255) DEFAULT NULL COMMENT '族群：管理族群，集成族群',
  `id_number` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `sex` char(1) DEFAULT NULL COMMENT '性别（0：男，1：女）',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `organization_id` varchar(32) DEFAULT NULL COMMENT '组织机构id',
  `login_ip` varchar(30) DEFAULT NULL COMMENT '登录ip',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `status_flag` char(1) DEFAULT '' COMMENT '状态（0：正常 1：禁用）',
  `sort` int(11) DEFAULT NULL COMMENT '排序顺序（0最前，99最后）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', 'b8c2d5b0a37cc51f91d5e8970347a3a3', '普通用户', null, null, null, null, '1', '11111111111', '1213651276961677312', '127.0.0.1', '2020-02-10 21:59:06', '2019-07-30 16:03:10', null, null, null, '0', '0');
INSERT INTO `user` VALUES ('2', 'vip', '01ffb6fc48048d105ba5061f8df5a35e', '用户', null, null, null, null, '0', '22222222222', '1213651276961677312', null, null, '2019-07-30 16:07:49', null, null, null, '0', '99');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '1');
INSERT INTO `user_role` VALUES ('3', '2', '2');
