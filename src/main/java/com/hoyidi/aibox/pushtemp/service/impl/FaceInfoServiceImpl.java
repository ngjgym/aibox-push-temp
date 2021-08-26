package com.hoyidi.aibox.pushtemp.service.impl;

import com.hoyidi.aibox.pushtemp.pojo.entity.FaceInfoEntity;
import com.hoyidi.aibox.pushtemp.mapper.FaceInfoMapper;
import com.hoyidi.aibox.pushtemp.service.FaceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 人脸抓拍信息表 服务实现类
 * </p>
 *
 * @author henggao
 * @since 2021-07-22
 */
@Service
public class FaceInfoServiceImpl extends ServiceImpl<FaceInfoMapper, FaceInfoEntity> implements FaceInfoService {

    @Autowired
    private FaceInfoMapper faceInfoMapper;

    @Override
    public List<Map<String,Object>> selFaceInfoAll() {
        return faceInfoMapper.getFaceInfoAll();
    }
}
