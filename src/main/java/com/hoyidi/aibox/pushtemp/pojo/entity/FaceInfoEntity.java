package com.hoyidi.aibox.pushtemp.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 人脸抓拍信息表
 * </p>
 *
 * @author henggao
 * @since 2021-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("face_info")
public class FaceInfoEntity implements Serializable {

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
     * 年龄段:未知,儿童,中青年,老年
     */
    private String age;

    /**
     * 眼镜:未知,无,普通眼镜,墨镜
     */
    private String glass;

    /**
     * 帽子:未知,无,普通帽子,头盔,头巾
     */
    private String hat;

    /**
     * 帽子颜色:未知,红色,橙色,黄色,绿色,蓝色,紫色,粉色,棕色,灰色,白色，黑色，花色
     */
    private String hatColor;

    /**
     * 口罩:有,无
     */
    private String facemask;

    /**
     * 性别: 未知, 男, ⼥
     */
    private String gender;

    /**
     * 发型: 未知, 光头, 平头, 短发, ⻬⽿短发, ⻓发, 扎辫⼦, 谢顶
     */
    private String hairstyle;

    /**
     * 胡须:有,无
     */
    private String beard;

    /**
     * 人种:未知,黄种人,黑种人,白种人
     */
    private String race;


}
