//package com.hoyidi.aibox.pushtemp.service.impl;
//
//import com.hoyidi.aibox.pushtemp.service.SocketService;
//import org.springframework.stereotype.Service;
//
//
///**
// * @author Boom
// */
//@Service
//public class SocketServiceImpl implements SocketService {
//
//    @Override
//    public void pushMsgToOne(Integer regionalId, String msg) {
////        ConcurrentHashMap<Channel, Channel> userChannelMap = NettyConfig.getUserChannelMap();
////        Channel channel = userChannelMap.get(userId);
////        channel.writeAndFlush(new TextWebSocketFrame(msg));
//    }
//
//    @Override
//    public void pushMsgToAll(String msg) {
//        NettyConfig.getChannelGroup().writeAndFlush(new TextWebSocketFrame(msg));
//    }
//
//    /**
//     * 推送给指定区域以及其上级区域用户组
//     *
//     * @param regionalCode
//     * @param msg
//     */
//    @Override
//    public void pushMsgToGroupUserByRegionalCode(String regionalCode, String msg) {
//        String[] split = regionalCode.split(">");
//        StringBuilder code = new StringBuilder();
//        for (String s : split) {
//            code = new StringBuilder(code.append(s).append(">"));
//            //得到所有的上级区域
//            ChannelGroup channelGroupMap = NettyConfig.getChannelGroupMap(code.toString());
//            //推送给在组中的所有的人
//            if (channelGroupMap != null) {
//                channelGroupMap.writeAndFlush(new TextWebSocketFrame(msg));
//            }
//
//        }
//    }
//
//    /**
//     * 推送给指定场所的用户
//     *
//     * @param placeId
//     * @param msg
//     */
//    @Override
//    public void pushMsgToGroupUserByPlaceId(Integer placeId, String msg) {
//        ChannelGroup channelGroupMapPlace = NettyConfig.getChannelGroupMapPlace(placeId);
//        if (channelGroupMapPlace != null) {
//            channelGroupMapPlace.writeAndFlush(new TextWebSocketFrame(msg));
//        }
//    }
//
//    /**
//     * 推送给指定区域并拥有布控权限的用户组
//     *
//     * @param regionalCode
//     * @param msg
//     */
//    @Override
//    public void pushMsgToControlGroupUserByRegionalCode(String regionalCode, String msg) {
//        String[] split = regionalCode.split(">");
//        StringBuilder code = new StringBuilder();
//        for (String s : split) {
//            code = new StringBuilder(code.append(s).append(">"));
//            ChannelGroup controlGroup = NettyConfig.getControlGroup(code.toString());
//            if (controlGroup != null) {
//                controlGroup.writeAndFlush(new TextWebSocketFrame(msg));
//            }
//        }
//    }
//
//    /**
//     * 推送给指定区域并拥有消防权限的用户组
//     *
//     * @param regionalCode
//     * @param msg
//     */
//    @Override
//    public void pushMsgToFireGroupUserByRegionalCode(String regionalCode, String msg) {
//        String[] split = regionalCode.split(">");
//        StringBuilder code = new StringBuilder();
//        for (String s : split) {
//            code = new StringBuilder(code.append(s).append(">"));
//            ChannelGroup fireGroup = NettyConfig.getFireGroup(code.toString());
//            if (fireGroup != null) {
//                fireGroup.writeAndFlush(new TextWebSocketFrame(msg));
//            }
//        }
//    }
//
//    /**
//     * 推送给指定场所并拥有抓拍权限的用户组
//     *
//     * @param placeId
//     * @param msg
//     */
//    @Override
//    public void pushMsgToCaptureGroupUserByPlaceId(Integer placeId, String msg) {
//        ChannelGroup captureGroup = NettyConfig.getCaptureGroup(placeId);
//        if (captureGroup != null) {
//            captureGroup.writeAndFlush(new TextWebSocketFrame(msg));
//        }
//    }
//
//}