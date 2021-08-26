package com.hoyidi.aibox.pushtemp.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author henggao
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("car_info")
public class CarInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 抓拍记录ID
     */
    private Integer captureId;

    /**
     * 车辆颜色: 未知, 红色, 橙色, 黄色, 绿色, 蓝色, 紫色, 粉色, 棕色,灰色, 白色, 黑色, 花色
     */
    private String color;

    /**
     * 渣土盖子: 无, 苫盖, 未苫盖, 铁皮盖
     */
    private String heavyTruckCover;

    /**
     * 装载情况: 无, 空载, 满载, 超载
     */
    private String heavyTruckLoad;

    /**
     * 车辆用途: 未知, 校车, 集装箱, 油罐车, 搅拌车, 出租车,消防车, 公检法, 工程抢险, 军车, 渣土车, 公交车, 长途客车, 教练车, 救护车, 运钞车,环保车, 宣传车, 禽畜运输, 箱式货车, 殡仪车, 特种车辆, 普通车辆, 行政执法
     */
    private String vehicleFuncType;

    /**
     * 车辆类型: 未知, 轿车, 越野车, 商务车, 面包车, 皮卡车,小型货车, 大型货车, 中小型客车, 大型客车, 三轮车, 拖拉机, 两轮车, 特种车辆
     */
    private String vehicleType;

    /**
     * 行礼架: 有, 无
     */
    private String roofRack;

    /**
     * 天窗: 有, 无
     */
    private String sunroof;

    /**
     * 危险品: 有, 无
     */
    private String tankerTruck;

    /**
     * 车部分: 车头，车尾，车侧
     */
    private String part;



}
