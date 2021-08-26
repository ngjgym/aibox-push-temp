package com.hoyidi.aibox.pushtemp.controller;


import com.hoyidi.aibox.pushtemp.pojo.entity.CarInfoEntity;
import com.hoyidi.aibox.pushtemp.service.CarInfoService;
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
@RequestMapping("/carInfo")
public class CarInfoController {

    @Autowired
    private CarInfoService carInfoService;

    /**
     * 查询所有的车辆抓拍数据
     * @return
     */
    @GetMapping("/CarInfoAll")
    public ResultMap CarInfoAll(){
        List<Map<String,Object>> carInfo=carInfoService.selCarAll();
        if (carInfo!=null){
            return ResultMap.success(carInfo,"成功！");
        }
        return ResultMap.error("失败！没有返回数据，请检查数据库是否存在数据。");
    }

}

