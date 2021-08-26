package com.hoyidi.aibox.pushtemp.controller;


import com.hoyidi.aibox.pushtemp.pojo.entity.PersonInfoEntity;
import com.hoyidi.aibox.pushtemp.service.PersonInfoService;
import com.hoyidi.aibox.pushtemp.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author henggao
 * @since 2021-07-23
 */
@RestController
@CrossOrigin
@RequestMapping("/personInfoEntity")
public class PersonInfoController {

    @Autowired
    private PersonInfoService personInfoService;


    @PostMapping("/personInfoAll")
    public ResultMap personInfoAll(){
        List<Map<String,Object>> personInfo = personInfoService.selPersonInfoAll();
        if (personInfo!=null){
            return ResultMap.success(personInfo,"成功");
        }
        return ResultMap.error("失败");
    }

}

