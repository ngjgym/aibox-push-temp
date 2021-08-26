package com.hoyidi.aibox.pushtemp.service.impl;

import com.hoyidi.aibox.pushtemp.pojo.entity.CarInfoEntity;
import com.hoyidi.aibox.pushtemp.mapper.CarInfoMapper;
import com.hoyidi.aibox.pushtemp.service.CarInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author henggao
 * @since 2021-07-23
 */
@Service
public class CarInfoServiceImpl extends ServiceImpl<CarInfoMapper, CarInfoEntity> implements CarInfoService {

    @Autowired
    private CarInfoMapper carInfoMapper;

    @Override
    public List<Map<String,Object>> selCarAll() {
        return carInfoMapper.getCarAll();
    }
}
