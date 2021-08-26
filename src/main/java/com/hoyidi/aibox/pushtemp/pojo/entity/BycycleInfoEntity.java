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
@TableName("bycycle_info")
public class BycycleInfoEntity implements Serializable {

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
     * 带包: 无, 单肩, 双肩, 斜挎, 拎包, 拎东西, 带包
     */
    private String bag;

    /**
     * 衣服纹理: 未知, 格子, 花纹, 纯色, 条纹, 拼⾊, 图案
     */
    private String clothingTexture;

    /**
     * 上衣款式: 未知, 短袖, 长袖, 外套, 无袖, 雨衣
     */
    private String topStyle;

    /**
     * 上衣颜色: 未知, 红色, 橙色, 黄色, 绿色, 蓝色, 紫色, 粉色, 棕色,灰色, 白色, 黑色, 花色
     */
    private String topColor;

    /**
     * 非机动车颜色: 未知, 红色, 黄色, 蓝色, 绿色, 灰色, 白色, 黑色, 银色, 橙色, 金色, 棕色, 紫色, 粉色
     */
    private String color;

    /**
     * 乘客帽子: 未知, 无, 普通帽子, 头盔, 头巾
     */
    private String guestHat;

    /**
     * 乘客帽子颜色: 未知, 红色, 橙色, 黄色, 绿色, 蓝色, 紫色, 粉色, 棕色,灰色, 白色, 黑色, 花色
     */
    private String guestHatColor;

    /**
     * 发型: 未知, 光头, 平头, 短发, 齐耳短发, 长发, 扎辫子, 谢顶
     */
    private String hairstyle;

    /**
     * 帽子: 未知, 无, 普通帽子, 头盔, 头巾
     */
    private String hat;

    /**
     * 帽子颜色: 未知, 红色, 橙色, 黄色, 绿色, 蓝色, 紫色, 粉色, 棕色,灰色, 白色, 黑色, 花色
     */
    private String hatColor;

    /**
     * 抱东西: 无, 抱孩子, 抱东西, 扛背东西
     */
    private String holding;

    /**
     * 架乘人数: 未知, 一人, 载人, 多人, 无人
     */
    private String load;

    /**
     * 眼镜: 有, 无
     */
    private String glass;

    /**
     * ⼝罩: 有, 无
     */
    private String facemask;

    /**
     * 非机动车类型: 两轮车, 三轮车
     */
    private String vehicleType;

    /**
     * 两轮类型: 未知, 摩托车, 自行车, 电动车, 电动滑板车
     */
    private String bycType;

    /**
     * ⾬伞: 有, 无
     */
    private String umbrella;

    /**
     * 外卖箱: 有, 无
     */
    private String takeOutBox;

    /**
     * 三轮⻋类型: 未知, 斗式, 篷式, 厢式, 三无
     */
    private String triType;


}
