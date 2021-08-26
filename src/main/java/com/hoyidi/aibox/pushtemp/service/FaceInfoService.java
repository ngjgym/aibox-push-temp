package com.hoyidi.aibox.pushtemp.service;

import com.hoyidi.aibox.pushtemp.pojo.entity.FaceInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 人脸抓拍信息表 服务类
 * </p>
 *
 * @author henggao
 * @since 2021-07-22
 */
public interface FaceInfoService extends IService<FaceInfoEntity> {

    List<Map<String,Object>> selFaceInfoAll();
}
