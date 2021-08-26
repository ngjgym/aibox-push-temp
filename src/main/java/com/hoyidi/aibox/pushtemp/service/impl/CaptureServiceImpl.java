package com.hoyidi.aibox.pushtemp.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hoyidi.aibox.pushtemp.common.Constant;
import com.hoyidi.aibox.pushtemp.pojo.entity.*;
import com.hoyidi.aibox.pushtemp.mapper.CaptureMapper;
import com.hoyidi.aibox.pushtemp.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hoyidi.aibox.pushtemp.utils.FastDFSClient;
import com.hoyidi.aibox.pushtemp.utils.SaveImageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 抓拍记录表 服务实现类
 * </p>
 *
 * @author henggao
 * @since 2021-07-22
 */
@Service
@Slf4j
public class CaptureServiceImpl extends ServiceImpl<CaptureMapper, CaptureEntity> implements CaptureService {

    @Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    private CaptureService captureService;

    @Autowired
    private PersonInfoService personInfoService;

    @Autowired
    private FaceInfoService faceInfoService;

    @Autowired
    private BycycleInfoService bycycleInfoService;

    @Autowired
    private CarInfoService carInfoService;

//    @Autowired
//    private SocketService socketService;


    @Override
    public void pushData(String json, MultipartFile file) throws IOException {
        // 处理图片，将图片和切图保存到images目录下，并获取地址

        // 根据抓拍类型将数据保存到数据库
        JSONObject jsonObject = JSON.parseObject(json);
        String channelLocation = jsonObject.getString("channelLocation");
        log.info("推送数据设备" + channelLocation);
        //根据channelLocation查询摄像机
        //Camera camera = cameraMapper.selectOneByDeviceCode(channelLocation);
        JSONArray objects = jsonObject.getJSONArray("objects");
        //Date snapTime = jsonObject.getDate("snapTime");
        //上传整张画面
//        String Url=System.getProperty("user.dir")+"/src/main/resources/templates/images/"+auto()+".jpg";
//        file.transferTo(new File(Url));
//        String imgUrl="./"+Url.substring(48);
        String imgUrl = SaveImageUtils.saveImageToStatic(file);
        for (int i = 0; i < objects.size(); i++) {
            //创建抓拍
            CaptureEntity capture = new CaptureEntity();
            capture.setSnapTime(new Date());
            capture.setImg(imgUrl);
            capture.setChannelLocation(channelLocation);

            JSONObject object = objects.getJSONObject(i);
            String chip = object.getString("chip");
            String carLicenceNumber = object.getString("carLicenceNumber");
//            String listType = null;
//            String alarmInfo = null;
//            if (object.size() == 8) {
//                alarmInfo = object.getJSONObject("alarmInfo").toJSONString();
//            }
//            if (alarmInfo != null) {
//                listType = object.getJSONObject("alarmInfo").get("listType").toString();
//            }
            //上传对象图像信息
            String keyDiagramUrl = SaveImageUtils.saveImageToStatic(chip);
            capture.setKeyDiagram(keyDiagramUrl);
            capture.setPlate(carLicenceNumber);
            String type = object.getString("type");
//            if (listType != null && listType.equals("黑名单")) {
//                capture.setBlackWhiteListId(1);
//            } else if (listType != null && listType.equals("白名单")) {
//                capture.setBlackWhiteListId(2);
//            }
//            if (camera != null) {
//                capture.setCameraId(camera.getId())
//                        .setPlaceId(camera.getPlaceId())
//                        .setRegionalCode(camera.getRegionalCode())
//                        .setRegionalId(camera.getRegionalId())
//                        .setLongitude(camera.getLongitude())
//                        .setLatitude(camera.getLatitude())
//                        .setDeviceCode(camera.getDeviceCode());
//            }
//            log.info(type);
            if (Constant.CaptureType.FACE_SLIM.equals(type)) {
                //人脸类型
                capture.setType(Constant.CaptureType.FACE);
                JSONObject attr = object.getJSONObject("attr");
                String age = attr.getString("age");
                String gender = attr.getString("gender");
                String galss = attr.getString("galss");
                String beard =attr.getString("beard");
                String facemask =attr.getString("facemask");
                String hat = attr.getString("hat");
                String hairstyle = attr.getString("hairstyle");
                String race = attr.getString("race");
                FaceInfoEntity facesInfo = new FaceInfoEntity();
                facesInfo.setAge(age);
                facesInfo.setGender(gender);
                facesInfo.setGlass(galss);
                facesInfo.setBeard(beard);
                facesInfo.setFacemask(facemask);
                facesInfo.setHat(hat);
                facesInfo.setHairstyle(hairstyle);
                facesInfo.setRace(race);
                //拿到人脸特征值
//                String featureBin = object.getString("featureBin");
//                capture.setSignature(featureBin);
                capture.setFacesInfo(facesInfo);
            } else if (Constant.CaptureType.VEHICLE_SLIM.equals(type)) {
                //机动车
                capture.setType(Constant.CaptureType.VEHICLE);
                JSONObject attr = object.getJSONObject("attr");
                String color = attr.getString("color");
                String vehicleType = attr.getString("vehicleType");
                String heavyTruckCover = attr.getString("heavyTruckCover");
                String heavyTruckLoad = attr.getString("heavyTruckLoad");
                String vehicleFuncType = attr.getString("vehicleFuncType");
                String roofRack = attr.getString("roofRack");
                String sunroof = attr.getString("sunroof");
                String tankerTruck = attr.getString("tankerTruck");
                String part = attr.getString("part");

                CarInfoEntity carInfo = new CarInfoEntity();
                carInfo.setVehicleType(vehicleType);
                carInfo.setColor(color);
                carInfo.setHeavyTruckCover(heavyTruckCover);
                carInfo.setHeavyTruckLoad(heavyTruckLoad);
                carInfo.setVehicleFuncType(vehicleFuncType);
                carInfo.setRoofRack(roofRack);
                carInfo.setSunroof(sunroof);
                carInfo.setTankerTruck(tankerTruck);
                carInfo.setPart(part);
                capture.setCarInfo(carInfo);
            } else if (Constant.CaptureType.PEDESTRIAN_SLIM.equals(type)) {
                //行人
                capture.setType(Constant.CaptureType.PEDESTRIAN);
                JSONObject attr = object.getJSONObject("attr");
                String bag = attr.getString("bag");
                String coatColor = attr.getString("coatColor");
                //帽子
                String hat = attr.getString("hat");
                String age = attr.getString("age");
                String gender =attr.getString("gender");
                //雨伞
                String umberlla = attr.getString("umberlla");
                String bottomStyle = attr.getString("bottomStyle");
                String bottomColor = attr.getString("bottomColor");
                String topStyle = attr.getString("topStyle");
                String topColor = attr.getString("topColor");
                String clothingTexture = attr.getString("clothingTexture");
                String hairstyle = attr.getString("hairstyle");
                String hatColor = attr.getString("hatColor");
                String holding = attr.getString("holding");
                String pull = attr.getString("pull");
                String shoseColor = attr.getString("shoseColor");

                PersonInfoEntity personInfo = new PersonInfoEntity();
                personInfo.setBag(bag);
                personInfo.setHat(hat);
                personInfo.setTopColor(coatColor);
                personInfo.setAge(age);
                personInfo.setGender(gender);
                personInfo.setUmbrella(umberlla);
                personInfo.setBottomStyle(bottomStyle);
                personInfo.setBottomColor(bottomColor);
                personInfo.setTopStyle(topStyle);
                personInfo.setTopColor(topColor);
                personInfo.setClothingTexture(clothingTexture);
                personInfo.setHairstyle(hairstyle);
                personInfo.setHatColor(hatColor);
                personInfo.setHolding(holding);
                personInfo.setPull(pull);
                personInfo.setShoseColor(shoseColor);
                capture.setPersonInfo(personInfo);
            }else{
                //非机动车
                capture.setType(Constant.CaptureType.BYCYCLE);
                JSONObject attr = object.getJSONObject("attr");
                String load = attr.getString("load");
                String facemask = attr.getString("facemask");
                //眼镜
                String glass = attr.getString("glass");
                //非机动车类型
                String bag =attr.getString("bag");
                String clothingTexture =attr.getString("clothingTexture");
                String topStyle =attr.getString("topStyle");
                String topColor =attr.getString("topColor");
                String color =attr.getString("color");
                String guestHat =attr.getString("guestHat");
                String guestHatColor =attr.getString("guestHatColor");
                String hairstyle =attr.getString("hairstyle");
                String hatColor =attr.getString("hatColor");
                String hat =attr.getString("hat");
                String holding =attr.getString("holding");
                String vehicleType =attr.getString("vehicleType");
                String bycType =attr.getString("bycType");
                String umbrella =attr.getString("umbrella");
                String takeOutBox =attr.getString("takeOutBox");
                String triType =attr.getString("triType");

                //雨伞
                String umberlla = attr.getString("umberlla");
                BycycleInfoEntity bycycleInfo = new BycycleInfoEntity();
                bycycleInfo.setLoad(load);
                bycycleInfo.setFacemask(facemask);
                bycycleInfo.setGlass(glass);
                bycycleInfo.setVehicleType(vehicleType);
                bycycleInfo.setUmbrella(umberlla);
                bycycleInfo.setBag(bag);
                bycycleInfo.setClothingTexture(clothingTexture);
                bycycleInfo.setTopStyle(topStyle);
                bycycleInfo.setTopColor(topColor);
                bycycleInfo.setColor(color);
                bycycleInfo.setGuestHat(guestHat);
                bycycleInfo.setGuestHatColor(guestHatColor);
                bycycleInfo.setHairstyle(hairstyle);
                bycycleInfo.setHatColor(hatColor);
                bycycleInfo.setHat(hat);
                bycycleInfo.setHolding(holding);
                bycycleInfo.setBycType(bycType);
                bycycleInfo.setUmbrella(umbrella);
                bycycleInfo.setTakeOutBox(takeOutBox);
                bycycleInfo.setTriType(triType);
                capture.setBycycleInfo(bycycleInfo);
            }
//            Map<String, Object> map = new HashMap<>();
//            map.put("type", 1);
//            map.put("data", capture);
            captureService.save(capture);
            log.info("成功");
            saveCapture(capture);
            //sendSocketMsg(capture);
            //预警信息
            //controlAlarmRecordService.controlAlarm(capture, camera);
            //昼伏夜出
//            configAlarmRecordService.configNocturnalAlarm(capture,camera);
        }
    }
//    private void sendSocketMsg(CaptureEntity capture){
//        socketService.pushMsgToAll(JSONObject.toJSONString(capture));
//    }

    private void saveCapture(CaptureEntity capture) {
        Integer id = capture.getId();
        Integer type = capture.getType();
        if (type.equals(Constant.CaptureType.FACE)) {
            FaceInfoEntity facesInfo = capture.getFacesInfo();
            facesInfo.setCaptureId(id);
            //拿取人脸特征值保存人脸信息
            faceInfoService.save(facesInfo);
            //保存人脸抓拍特征值
            //captureService.saveSignature(capture.getSignature(), capture.getId(), capture.getCreateTime());
            //cameraMapper.updateFaceInfoCountById(capture.getCameraId());
        } else if (type.equals(Constant.CaptureType.PEDESTRIAN)) {
            PersonInfoEntity pedestrianInfo = capture.getPersonInfo();
            pedestrianInfo.setCaptureId(id);
            personInfoService.save(pedestrianInfo);
            //cameraMapper.updatePedestrianInfoCountById(capture.getCameraId());
        } else if (type.equals(Constant.CaptureType.VEHICLE)) {
            CarInfoEntity carInfo = capture.getCarInfo();
            carInfo.setCaptureId(id);
            carInfoService.save(carInfo);
            //cameraMapper.updateVehicleInfoCountById(capture.getCameraId());
        }else if (type.equals(Constant.CaptureType.BYCYCLE)){
            BycycleInfoEntity bycycleInfo = capture.getBycycleInfo();
            bycycleInfo.setCaptureId(id);
            bycycleInfoService.save(bycycleInfo);
        }
    }

    /**
     * 生成五位数字
     *
     * @return
     */
    private Integer auto() {
        int max=99999,min=10000;
        int ran2 = (int) (Math.random()*(max-min)+min);
        return ran2;
    }
    public static String getSubUtilSimple(String soap,String rgex){
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(soap);
        while(m.find()){
            return m.group(1);
        }
        return "";


    }
}
