package com.hoyidi.aibox.pushtemp.common;

import org.springframework.stereotype.Component;

/**
 * 公共字段信息
 * @author Boom
 */
@Component
public class Constant {


    /**
     * 抓拍类型
     */
    public static class CaptureType {
        /**
         * 行人
         */
        public static int PEDESTRIAN = 1;
        /**
         * 机动车
         */
        public static int VEHICLE = 2;
        /**
         * 人脸
         */
        public static int FACE = 3;
        /**
         * 非机动车
         */
        public static int BYCYCLE =4;

        /**
         * 行人
         */
        public static String PEDESTRIAN_SLIM = "PERSON";
        /**
         * 机动车
         */
        public static String VEHICLE_SLIM = "CAR";
        /**
         * 人脸
         */
        public static String FACE_SLIM = "FACE_SNAP";

    }


    /**
     * 库类型
     */
    public static class LibraryType {
        /**
         * 人脸库
         */
        public static int FACE_LIBRARY = 1;
        /**
         * 车辆库
         */
        public static int VEHICLE_LIBRARY = 2;
    }


    /**
     * 智盒消息相关
     */
    public static class AiBoxPath {
        /**
         * 开机注册
         */
        public static String registered = "registered";
        /**
         * 根据图像base64返回特征值
         */
        public static String getFeatureByImg = "getFeatureByImg";
        /**
         * 请求相机列表
         */
        public static String getCameraList = "getCameraList";
        /**
         * 人脸库下发
         */
        public static String releaseLibraryFace = "releaseLibraryFace";
        /**
         * 人脸库删除
         */
        public static String removeLibraryFace = "removeLibraryFace";
        /**
         * 人脸库修改
         */
        public static String updateLibraryFace = "updateLibraryFace";
        /**
         * 车辆库下发
         */
        public static String releaseLibraryVehicle = "releaseLibraryVehicle";
        /**
         * 车辆库删除
         */
        public static String removeLibraryVehicle = "removeLibraryVehicle";
        /**
         * 车辆库修改
         */
        public static String updateLibraryVehicle = "updateLibraryVehicle";
        /**
         * 人脸下发
         */
        public static String releaseFace = "releaseFace";
        /**
         * 人脸删除
         */
        public static String removeFace = "removeFace";
        /**
         * 人脸修改
         */
        public static String updateFace = "updateFace";
        /**
         * 车辆下发
         */
        public static String releaseVehicle = "releaseVehicle";
        /**
         * 车辆删除
         */
        public static String removeVehicle = "removeVehicle";
        /**
         * 车辆修改
         */
        public static String updateVehicle = "updateVehicle";
    }

    /**
     * 前端消息类型
     */
    public static class WebMsgType {
        /**
         * 抓拍消息
         */
        public static int SNAP = 1;
        /**
         * 中消云火警消息
         */
        public static int ZXY_ALARM = 2;
        /**
         * 布控预警消息
         */
        public static int CONTROL_AlARM = 3;
    }

    /**
     * 智盒相关消息来源类型
     */
    public static class AiBoxMessageSource {
        /**
         * 系统
         */
        public static int SYSTEM = 1;
        /**
         * 智盒
         */
        public static int AI_BOX = 2;
    }

    /**
     * websocket连接类型
     */
    public static class ChannelType {
        /**
         * token
         */
        public static int TOKEN = 1;
        /**
         * 场所
         */
        public static int PLACE = 2;
        /**
         * 智盒
         */
        public static int AI_BOX = 3;
    }

    /**
     * 布控类型
     */
    public static class ControlType {
        /**
         * 人脸
         */
        public static int face = 1;
        /**
         * 人脸库
         */
        public static int face_library = 2;
        /**
         * 车辆
         */
        public static int vehicle = 3;
        /**
         * 车辆库
         */
        public static int vehicle_library = 4;
        /**
         * 高频陌生人
         */
        public static int hfs = 5;
        /**
         * 昼伏夜出
         */
        public static int nocturnal = 6;

    }

    /**
     * 设备类型
     */
    public static class DeviceType {
        /**
         * AI监控
         */
        public static int AI_CAMERA = 1;
        /**
         * 普通监控
         */
        public static int CAMERA = 2;
        /**
         * 车道闸
         */
        public static int LANE_GATE = 3;
        /**
         * 充电桩
         */
        public static int CHARGING_PILE = 4;
        /**
         * 门禁
         */
        public static int ENTRANCE_GUARD = 5;
        /**
         * 烟感
         */
        public static int SMOKE = 6;
    }

    /**
     * 区块类型
     */
    public static class GardenType {
        /**
         * 国家
         */
        public static int COUNTRY = 1;
        /**
         * 省
         */
        public static int PROVINCE = 2;
        /**
         * 市
         */
        public static int CITY = 3;
        /**
         * 区
         */
        public static int AREA = 4;
        /**
         * 社区
         */
        public static int COMMUNITY = 5;
        /**
         *
         */
        public static int VILLAGE = 6;
        /**
         * 工业区
         */
        public static int INDUSTRIAL_AREA = 7;
    }

    /**
     * 其他设备类型
     */
    public static class OtherDeviceType {
        /**
         * 房屋
         */
        public static int HOUSE = 1;
        /**
         * 垃圾点
         */
        public static int JUNK_POINT = 2;
        /**
         * 消防栓
         */
        public static int FIREHYDRANTS = 3;
        /**
         * 摄像头
         */
        public static int CAMERA = 4;
    }


}
