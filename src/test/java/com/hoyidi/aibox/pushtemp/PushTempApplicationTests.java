package com.hoyidi.aibox.pushtemp;

import com.hoyidi.aibox.pushtemp.pojo.entity.CaptureEntity;
import com.hoyidi.aibox.pushtemp.service.impl.CaptureServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Date;

@SpringBootTest
@Slf4j
class PushTempApplicationTests {
    @Autowired
    private CaptureServiceImpl captureService;
    @Test
    void testCapture() {
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
        Assert.isTrue(b);
    }

}
