DROP TABLE IF EXISTS `capture`;
CREATE TABLE `capture`  (
    `id` int NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `device_id` varchar(255) NOT NULL DEFAULT '' COMMENT '设备ID',
    `channel_id` int NOT NULL DEFAULT 0 COMMENT '通道（相机）ID',
    `channel_location` varchar(255) NOT NULL DEFAULT '' COMMENT '通道（相机）占位',
    `type` int(11) NOT NULL  COMMENT '类型：抓拍类型(1.行人,2.车辆,3.人脸)',
    `det_probability` double NOT NULL DEFAULT 0.000000 COMMENT '识别可信度',
    `img` varchar(255) NOT NULL DEFAULT '' COMMENT '快照图像路径(大图)',
    `key_diagram` varchar(255) NOT NULL DEFAULT '' COMMENT '对象图像路径(小图)',
    `snap_time` datetime NOT NULL COMMENT '抓拍时间',
    `plate` varchar(255) NOT NULL DEFAULT '' COMMENT '车牌号码',
    PRIMARY KEY (`id`)
) ;
CREATE INDEX `key_capture_channel_id` ON capture(`id`);
CREATE INDEX `key_capture_type` ON capture(`type`);

DROP TABLE IF EXISTS `face_info`;
CREATE TABLE `face_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `capture_id` int NOT NULL DEFAULT 0 COMMENT '抓拍记录ID',
  `age` varchar(255) NOT NULL DEFAULT '' COMMENT '年龄段: 未知, ⼉童, 中⻘年, ⽼年',
  `glass` varchar(255) NOT NULL DEFAULT '' COMMENT '眼镜: 未知, ⽆, 普通眼镜, 墨镜',
  `hat` varchar(255) NOT NULL DEFAULT '' COMMENT '帽⼦: 未知, ⽆, 普通帽⼦, 头盔, 头⼱',
  `hat_color ` varchar(255) NOT NULL DEFAULT '' COMMENT '帽⼦颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉⾊, 棕⾊,灰⾊, ⽩⾊, ⿊⾊, 花⾊',
  `facemask` varchar(255) NOT NULL DEFAULT '' COMMENT '⼝罩: 有, ⽆',
  `gender` varchar(255) NOT NULL DEFAULT '' COMMENT '性别: 未知, 男, ⼥',
  `hairstyle` varchar(255) NOT NULL DEFAULT '' COMMENT '发型: 未知, 光头, 平头, 短发, ⻬⽿短发, ⻓发, 扎辫⼦, 谢顶',
  `beard` varchar(255) NOT NULL DEFAULT '' COMMENT '胡须: 有, ⽆',
  `race` varchar(255) NOT NULL DEFAULT '' COMMENT '⼈种: 未知, ⻩种⼈, ⿊种⼈, ⽩种⼈',
  PRIMARY KEY (`id`)
);
CREATE INDEX `key_face_info_capture_id` ON face_info(`capture_id`);

Drop table if exists  `person_info`;
create  table  `person_info` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `capture_id` int NOT NULL DEFAULT 0 COMMENT '抓拍记录ID',
    `age` varchar(255) NOT NULL DEFAULT '' COMMENT '年龄段: 未知, ⼉童, 中⻘年, ⽼年',
    `bag` varchar(255) NOT NULL DEFAULT '' COMMENT '带包: ⽆, 单肩, 双肩, 斜挎, 拎包, 拎东⻄, 带包',
    `bottom_style` varchar(255) NOT NULL DEFAULT '' COMMENT '下⾐款式: 未知, ⻓裤, 短裤, 七分裤, 裙⼦',
    `bottom_color` varchar(255) NOT NULL DEFAULT '' COMMENT '下⾐颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉⾊,棕⾊, 灰⾊, ⽩⾊, ⿊⾊, 花⾊',
    `top_style` varchar(255) NOT NULL DEFAULT '' COMMENT '上⾐款式: 未知, 短袖, ⻓袖, 外套, ⽆袖, ⾬⾐',
    `top_color` varchar(255) NOT NULL DEFAULT '' COMMENT '上⾐颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉⾊,棕⾊, 灰⾊, ⽩⾊, ⿊⾊, 花⾊',
    `clothing_texture` varchar(255) NOT NULL DEFAULT '' COMMENT '⾐服纹理: 未知, 格⼦, 花纹, 纯⾊, 条纹, 拼⾊, 图案',
    `hairstyle` varchar(255) NOT NULL DEFAULT '' COMMENT '发型: 未知, 光头, 平头, 短发, ⻬⽿短发, ⻓发, 扎辫⼦, 谢顶',
    `hat` varchar(255) NOT NULL DEFAULT '' COMMENT '帽⼦: 未知, ⽆, 普通帽⼦, 头盔, 头⼱',
    `hat_color` varchar(255) NOT NULL DEFAULT '' COMMENT '帽⼦颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉⾊,棕⾊, 灰⾊, ⽩⾊, ⿊⾊, 花⾊',
    `holding` varchar(255) NOT NULL DEFAULT '' COMMENT '抱东⻄: ⽆, 抱孩⼦, 抱东⻄, 扛背东⻄',
    `pull` varchar(255) NOT NULL DEFAULT '' COMMENT '拉东⻄: ⽆, ⾏李箱, 婴⼉⻋, 轮椅, 推拉东⻄',
    `gender` varchar(255) NOT NULL DEFAULT '' COMMENT '性别: 未知, 男, ⼥',
    `shose_color` varchar(255) NOT NULL DEFAULT '' COMMENT '鞋⼦颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉⾊,棕⾊, 灰⾊, ⽩⾊, ⿊⾊, 花⾊',
    `glass` varchar(255) NOT NULL DEFAULT '' COMMENT '眼镜: 有, ⽆',
    `facemask` varchar(255) NOT NULL DEFAULT '' COMMENT '⼝罩: 有, ⽆',
    `umbrella` varchar(255) NOT NULL DEFAULT '' COMMENT '⾬伞: 有, ⽆',
    PRIMARY KEY (`id`)
);
CREATE INDEX `key_person_info_capture_id` ON person_info(`capture_id`);


Drop table if exists  `car_info`;
create  table  `car_info` (
     `id` int NOT NULL AUTO_INCREMENT COMMENT 'PK',
     `capture_id` int NOT NULL DEFAULT 0 COMMENT '抓拍记录ID',
     `color` varchar(255) NOT NULL DEFAULT '' COMMENT '⻋辆颜⾊: 未知, 红⾊, ⻩⾊, 蓝⾊, 绿⾊, 灰⾊, ⽩⾊, ⿊⾊, 银⾊, 橙⾊, ⾦⾊, 棕⾊, 紫⾊, 粉⾊',
     `heavy_truck_cover` varchar(255) NOT NULL DEFAULT '' COMMENT '渣⼟盖⼦: ⽆, 苫盖, 未苫盖, 铁⽪盖',
     `heavy_truck_load` varchar(255) NOT NULL DEFAULT '' COMMENT '装载情况: ⽆, 空载, 满载, 超载',
     `vehicle_func_type` varchar(255) NOT NULL DEFAULT '' COMMENT '⻋辆⽤途: 未知, 校⻋, 集装箱, 油罐⻋, 搅拌⻋, 出租⻋,消防⻋, 公检法, ⼯程抢险, 军⻋, 渣⼟⻋, 公交⻋, ⻓途客⻋, 教练⻋, 救护⻋, 运钞⻋,环保⻋, 宣传⻋, 禽畜运输, 箱式货⻋, 殡仪⻋, 特种⻋辆, 普通⻋辆, ⾏政执法',
     `vehicle_type` varchar(255) NOT NULL DEFAULT '' COMMENT '⻋辆类型: 未知, 轿⻋, 越ᰀ⻋, 商务⻋, ⾯包⻋, ⽪卡⻋,⼩型货⻋, ⼤型货⻋, 中⼩型客⻋, ⼤型客⻋, 三轮⻋, 拖拉机, 两轮⻋, 特种⻋辆',
     `roof_rack` varchar(255) NOT NULL DEFAULT '' COMMENT '⾏礼架: 有, ⽆',
     `sunroof` varchar(255) NOT NULL DEFAULT '' COMMENT '天窗: 有, ⽆',
     `tanker_truck` varchar(255) NOT NULL DEFAULT '' COMMENT '危险品: 有, ⽆',
     `part` varchar(255) NOT NULL DEFAULT '' COMMENT '⻋部分: ⻋头，⻋尾，⻋侧',
     PRIMARY KEY (`id`)
);
CREATE INDEX `key_car_info_capture_id` ON car_info(`capture_id`);


Drop table if exists  `bycycle_info`;
create  table  `bycycle_info` (
     `id` int NOT NULL AUTO_INCREMENT COMMENT 'PK',
     `capture_id` int NOT NULL DEFAULT 0 COMMENT '抓拍记录ID',
     `bag` varchar(255) NOT NULL DEFAULT '' COMMENT '带包: ⽆, 单肩, 双肩, 斜挎, 拎包, 拎东⻄, 带包',
     `clothing_texture` varchar(255) NOT NULL DEFAULT '' COMMENT '⾐服纹理: 未知, 格⼦, 花纹, 纯⾊, 条纹, 拼⾊, 图案',
     `top_style` varchar(255) NOT NULL DEFAULT '' COMMENT '上⾐款式: 未知, 短袖, ⻓袖, 外套, ⽆袖, ⾬⾐',
     `top_color` varchar(255) NOT NULL DEFAULT '' COMMENT '上⾐颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉⾊,棕⾊, 灰⾊, ⽩⾊, ⿊⾊, 花⾊',
     `color` varchar(255) NOT NULL DEFAULT '' COMMENT '⾮机动⻋颜⾊: 未知, 红⾊, ⻩⾊, 蓝⾊, 绿⾊, 灰⾊, ⽩⾊, ⿊⾊, 银⾊, 橙⾊, ⾦⾊, 棕⾊, 紫⾊, 粉⾊',
     `guest_hat` varchar(255) NOT NULL DEFAULT '' COMMENT '乘客帽⼦: 未知, ⽆, 普通帽⼦, 头盔, 头⼱',
     `guest_hat_color` varchar(255) NOT NULL DEFAULT '' COMMENT '乘客帽⼦颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉 ⾊, 棕⾊, 灰⾊, ⽩⾊, ⿊⾊, 花⾊',
     `hairstyle` varchar(255) NOT NULL DEFAULT '' COMMENT '发型: 未知, 光头, 平头, 短发, ⻬⽿短发, ⻓发, 扎辫⼦, 谢顶',
     `hat` varchar(255) NOT NULL DEFAULT '' COMMENT '帽⼦: 未知, ⽆, 普通帽⼦, 头盔, 头⼱',
     `hat_color` varchar(255) NOT NULL DEFAULT '' COMMENT '帽⼦颜⾊: 未知, 红⾊, 橙⾊, ⻩⾊, 绿⾊, 蓝⾊, 紫⾊, 粉⾊,棕⾊, 灰⾊, ⽩⾊, ⿊⾊, 花⾊',
     `holding` varchar(255) NOT NULL DEFAULT '' COMMENT '抱东⻄: ⽆, 抱孩⼦, 抱东⻄, 扛背东⻄',
     `load` varchar(255) NOT NULL DEFAULT '' COMMENT '架乘⼈数: 未知, ⼀⼈, 载⼈, 多⼈, ⽆⼈',
     `glass` varchar(255) NOT NULL DEFAULT '' COMMENT '眼镜: 有, ⽆',
     `facemask` varchar(255) NOT NULL DEFAULT '' COMMENT '⼝罩: 有, ⽆',
     `vehicle_type` varchar(255) NOT NULL DEFAULT '' COMMENT '⾮机动⻋类型: 两轮⻋, 三轮⻋',
     `byc_type` varchar(255) NOT NULL DEFAULT '' COMMENT '两轮类型: 未知, 摩托⻋, ⾃⾏⻋, 电动⻋, 电动滑板⻋',
     `umbrella` varchar(255) NOT NULL DEFAULT '' COMMENT '⾬伞: 有, ⽆',
     `take_out_box` varchar(255) NOT NULL DEFAULT '' COMMENT '外卖箱: 有, ⽆',
     `tri_type` varchar(255) NOT NULL DEFAULT '' COMMENT '三轮⻋类型: 未知, ⽃式, 篷式, 厢式, 三⽆',
     PRIMARY KEY (`id`)
);
CREATE INDEX `key_bycycle_info_capture_id` ON bycycle_info(`capture_id`);