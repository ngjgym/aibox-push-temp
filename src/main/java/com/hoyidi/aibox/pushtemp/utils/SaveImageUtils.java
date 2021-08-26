package com.hoyidi.aibox.pushtemp.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
@Component
@Slf4j
public class SaveImageUtils {
    @Value("${uploadPath}")
    private String basePath;
    private final String path = "/images/";
    public String saveImageToStatic(MultipartFile file) throws IOException {
        String fileName = System.currentTimeMillis() + ".jpg";
        String imgFilePath = this.basePath + path + fileName;
        File newFile = new File(imgFilePath);
        FileUtils.touch(newFile);
        file.transferTo(newFile);
        log.info("MultipartFile: "+ imgFilePath);
        return path + fileName;
    }
    public String saveImageToStatic(String imgStr) throws IOException {
        if (imgStr == null || "".equals(imgStr)) //图像数据为空
            throw new IOException("切图不存在");
        BASE64Decoder decoder = new BASE64Decoder();
        //Base64解码
        byte[] b = decoder.decodeBuffer(imgStr);
        for(int i=0;i<b.length;++i)
        {
            if(b[i]<0)
            {//调整异常数据
                b[i]+=256;
            }
        }
        //生成jpeg图片
        String fileName = System.currentTimeMillis() + ".jpg";
        String imgFilePath = this.basePath + path + fileName;
        File newFile = new File(imgFilePath);
        FileUtils.touch(newFile);
        OutputStream out = new FileOutputStream(newFile);
        out.write(b);
        out.flush();
        out.close();
        System.out.println("String: "+ imgFilePath);
        return path + fileName;

    }
}