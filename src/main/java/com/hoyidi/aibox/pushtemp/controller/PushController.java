package com.hoyidi.aibox.pushtemp.controller;

import com.hoyidi.aibox.pushtemp.pojo.entity.CaptureEntity;
import com.hoyidi.aibox.pushtemp.service.impl.CaptureServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/pull")
public class PushController {
    @Autowired
    private CaptureServiceImpl captureService;

    @PostMapping("/pushData")
    @ResponseBody
    public String pushData(@RequestParam("json_info") String json, @RequestParam("image") MultipartFile file) throws IOException {
        captureService.pushData(json, file);
        log.info(json);
        return "ok";
    }

    @GetMapping("/test/addData")
    @ResponseBody
    public String addData(){
        // 模拟传入的参数
        CaptureEntity captureEntity = new CaptureEntity();
        captureEntity.setChannelId(1);
        captureEntity.setChannelLocation("office");
        captureEntity.setDetProbability(0.9999);
        captureEntity.setDeviceId("100001");
        captureEntity.setImg("/static/xiongmao.jpg");
        captureEntity.setKeyDiagram("/static/xiongmao.jpg");
        captureEntity.setType(1);
        captureEntity.setSnapTime(new Date());
        boolean b = captureService.save(captureEntity);
        return b ? "true" : "false";
    }

    @GetMapping("/test/listData")
    @ResponseBody
    public List<CaptureEntity> listData(){
        List<CaptureEntity> list = captureService.list();
        return list;
    }
}
