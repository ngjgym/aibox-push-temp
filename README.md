# 运行方式

本项目用于好易点智盒（视频分析结构化产口）展示和调试demo样例，配合智盒一起运行。

`注意：`本应用所有数据均保存在内存，重启应用数据将会删除，但是不包括图片，因为图片保存本地硬盘，需要手动删除。

## 1 安装Java环境

## 2  获取源码

源码github地址：https://github.com/ngjgym/aibox-push-temp/tree/main

## 3 以命令行的方式进入到项目目录下的target目录

## 4 运行启动命令

```java -jar push-temp-0.0.1-SNAPSHOT.jar```

## 5 智盒配置

在上报管理栏目里设置`HTTP结构数据上报`

```http://192.168.31.125:8089/pull/pushData```

以上IP地址改为计算机的实际IP

保存并打开状态

## 6 在浏览器访问 `http://localhost:8089/display.html`

浏览器会每隔30s刷新一次页面，以获取新的抓拍数据

