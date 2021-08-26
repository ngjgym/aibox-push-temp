package com.hoyidi.aibox.pushtemp.service.impl;

import com.hoyidi.aibox.pushtemp.pojo.entity.BycycleInfoEntity;
import com.hoyidi.aibox.pushtemp.mapper.BycycleInfoMapper;
import com.hoyidi.aibox.pushtemp.service.BycycleInfoService;
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
public class BycycleInfoServiceImpl extends ServiceImpl<BycycleInfoMapper, BycycleInfoEntity> implements BycycleInfoService {

    @Autowired
    private BycycleInfoMapper bycycleInfoMapper;

    @Override
    public List<Map<String,Object>> selBycycleInfoAll() {
        return bycycleInfoMapper.getBycycleInfoAll();
    }
}
