package com.hoyidi.aibox.pushtemp.controller;


import com.hoyidi.aibox.pushtemp.pojo.entity.FaceInfoEntity;
import com.hoyidi.aibox.pushtemp.service.FaceInfoService;
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
@RequestMapping("/faceInfoEntity")
public class FaceInfoController {

    @Autowired
    private FaceInfoService faceInfoService;

    @PostMapping("/faceInfoAll")
    public ResultMap faceInfoAll(){
        List<Map<String,Object>> faceInfo = faceInfoService.selFaceInfoAll();
        if (faceInfo!=null){
            return ResultMap.success(faceInfo,"成功");
        }
        return ResultMap.error("失败！");
    }
}

