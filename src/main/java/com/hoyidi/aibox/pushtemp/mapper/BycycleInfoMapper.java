package com.hoyidi.aibox.pushtemp.mapper;

import com.hoyidi.aibox.pushtemp.pojo.entity.BycycleInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author henggao
 * @since 2021-07-23
 */
@Repository
public interface BycycleInfoMapper extends BaseMapper<BycycleInfoEntity> {

   List<Map<String,Object>> getBycycleInfoAll();
}
