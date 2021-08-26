package com.hoyidi.aibox.pushtemp.controller;


import com.hoyidi.aibox.pushtemp.pojo.entity.BycycleInfoEntity;
import com.hoyidi.aibox.pushtemp.service.BycycleInfoService;
import com.hoyidi.aibox.pushtemp.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/bycycleInfo")
public class BycycleInfoController {

    @Autowired
    private BycycleInfoService bycycleInfoService;


    @GetMapping("/bycycleInfoAll")
    public ResultMap bycycleInfoAll(){
        List<Map<String,Object>> bycycleInfo = bycycleInfoService.selBycycleInfoAll();
        if (bycycleInfo!=null){
            return ResultMap.success(bycycleInfo,"成功");
        }
        return ResultMap.error("失败");
    }
}