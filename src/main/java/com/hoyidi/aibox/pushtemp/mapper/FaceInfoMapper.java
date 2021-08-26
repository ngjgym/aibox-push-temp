package com.hoyidi.aibox.pushtemp.mapper;

import com.hoyidi.aibox.pushtemp.pojo.entity.FaceInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 人脸抓拍信息表 Mapper 接口
 * </p>
 *
 * @author henggao
 * @since 2021-07-22
 */
@Repository
public interface FaceInfoMapper extends BaseMapper<FaceInfoEntity> {

    List<Map<String,Object>> getFaceInfoAll();
}
