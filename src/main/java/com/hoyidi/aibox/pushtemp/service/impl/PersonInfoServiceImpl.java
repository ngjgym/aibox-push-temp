package com.hoyidi.aibox.pushtemp.service.impl;

import com.hoyidi.aibox.pushtemp.pojo.entity.PersonInfoEntity;
import com.hoyidi.aibox.pushtemp.mapper.PersonInfoMapper;
import com.hoyidi.aibox.pushtemp.service.PersonInfoService;
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
public class PersonInfoServiceImpl extends ServiceImpl<PersonInfoMapper, PersonInfoEntity> implements PersonInfoService {

    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Override
    public List<Map<String,Object>> selPersonInfoAll() {
        return personInfoMapper.getPersonInfoAll();
    }
}
