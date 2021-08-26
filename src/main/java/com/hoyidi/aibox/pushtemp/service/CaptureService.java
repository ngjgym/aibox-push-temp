package com.hoyidi.aibox.pushtemp.service;

import com.hoyidi.aibox.pushtemp.pojo.entity.CaptureEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <p>
 * 抓拍记录表 服务类
 * </p>
 *
 * @author henggao
 * @since 2021-07-22
 */
public interface CaptureService extends IService<CaptureEntity> {

    void pushData(String json, MultipartFile file) throws IOException;
}
