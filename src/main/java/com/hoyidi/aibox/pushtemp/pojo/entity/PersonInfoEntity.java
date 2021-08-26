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
@TableName("person_info")
public class PersonInfoEntity implements Serializable {

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
     * 年龄段: 未知, 儿童, 中青年, 老年
     */
    private String age;

    /**
     * 带包: 无, 单肩, 双肩, 斜挎, 拎包, 拎东⻄, 带包
     */
    private String bag;

    /**
     * 下衣款式: 未知, 长裤, 短裤, 七分裤, 裙子
     */
    private String bottomStyle;

    /**
     * 下衣颜色: 未知, 红色, 橙色, 黄色, 绿色, 蓝色, 紫色, 粉色, 棕色,灰色, 白色, 黑色, 花色
     */
    private String bottomColor;

    /**
     * 上衣款式: 未知, 短袖, 长袖, 外套, 无袖, 雨衣
     */
    private String topStyle;

    /**
     * 上衣颜色: 未知, 红色, 橙色, 黄色, 绿色, 蓝色, 紫色, 粉色, 棕色,灰色, 白色, 黑色, 花色
     */
    private String topColor;

    /**
     * 衣服纹理: 未知, 格子, 花纹, 纯色, 条纹, 拼色, 图案
     */
    private String clothingTexture;

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
     * 拉东西: 无, 行李箱, 婴儿车, 轮椅, 推拉东西
     */
    private String pull;

    /**
     * 性别: 未知, 男, 女
     */
    private String gender;

    /**
     * 鞋子颜色: 未知, 红色, 橙色, 黄色, 绿色, 蓝色, 紫色, 粉色, 棕色,灰色, 白色, 黑色, 花色
     */
    private String shoseColor;

    /**
     * 眼镜: 有, 无
     */
    private String glass;

    /**
     * 口罩: 有, 无
     */
    private String facemask;

    /**
     * 雨伞: 有, 无
     */
    private String umbrella;


}
