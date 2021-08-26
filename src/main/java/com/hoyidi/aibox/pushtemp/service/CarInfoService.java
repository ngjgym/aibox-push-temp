package com.hoyidi.aibox.pushtemp.service;

import com.hoyidi.aibox.pushtemp.pojo.entity.CarInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author henggao
 * @since 2021-07-23
 */
public interface CarInfoService extends IService<CarInfoEntity> {

    List<Map<String,Object>> selCarAll();
}
