//package com.hoyidi.aibox.pushtemp.service;
//
///**
// * @author Boom
// */
//public interface SocketService {
//    /**
//     * 推送给指定用户
//     *
//     * @param regionalId
//     * @param msg
//     */
//    void pushMsgToOne(Integer regionalId, String msg);
//
//    /**
//     * 推送给所有用户
//     *
//     * @param msg
//     */
//    void pushMsgToAll(String msg);
//
//    /**
//     * 推送给指定区域以及其上级区域用户组
//     *
//     * @param regionalCode
//     * @param msg
//     */
//    void pushMsgToGroupUserByRegionalCode(String regionalCode, String msg);
//
//    /**
//     * 推送给指定场所的用户
//     *
//     * @param placeId
//     * @param msg
//     */
//    void pushMsgToGroupUserByPlaceId(Integer placeId, String msg);
//
//
//    /**
//     * 推送给指定区域并拥有布控权限的用户组
//     */
//    void pushMsgToControlGroupUserByRegionalCode(String regionalCode, String msg);
//
//
//    /**
//     * 推送给指定区域并拥有消防权限的用户组
//     */
//    void pushMsgToFireGroupUserByRegionalCode(String regionalCode, String msg);
//
//    /**
//     * 推送给指定场所并拥有抓拍权限的用户组
//     */
//    void pushMsgToCaptureGroupUserByPlaceId(Integer placeId, String msg);
//}
