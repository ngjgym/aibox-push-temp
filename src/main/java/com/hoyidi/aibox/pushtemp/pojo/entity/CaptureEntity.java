package com.hoyidi.aibox.pushtemp.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 抓拍记录表
 * </p>
 *
 * @author henggao
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("capture")
public class CaptureEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备ID
     */
    private String deviceId;

    /**
     * 通道（相机）ID
     */
    private Integer channelId;

    /**
     * 通道（相机）占位
     */
    private String channelLocation;

    /**
     * 类型：PERSON,BYCYCLE|TRICYCLE,CAR,FACE_SNAP
     */
    private Integer type;

    /**
     * 识别可信度
     */
    private Double detProbability;

    /**
     * 快照图像路径(大图)
     */
    private String img;

    /**
     * 对象图像路径(小图)
     */
    private String keyDiagram;

    /**
     * 抓拍时间
     */
    private Date snapTime;

    /**
     * 车牌号码
     */
    private String plate;

    /**
     * 人脸抓拍属性
     */
    @TableField(exist = false)
    private FaceInfoEntity facesInfo;

    /**
     * 机动车抓拍属性
     */
    @TableField(exist = false)
    private CarInfoEntity carInfo;

    /**
     * 行人抓拍属性
     */
    @TableField(exist = false)
    private PersonInfoEntity personInfo;

    /**
     * 非机动车抓拍属性
     */
    @TableField(exist = false)
    private BycycleInfoEntity bycycleInfo;

}
