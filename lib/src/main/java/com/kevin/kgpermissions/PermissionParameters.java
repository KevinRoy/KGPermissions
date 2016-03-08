package com.kevin.kgpermissions;

import android.Manifest;

/**
 * Dangerous Permissions
 * Created by kevin on 16/2/23.
 */
public class PermissionParameters {

    //group:android.permission-group.CONTACTS 联系人
    public static final int REQUEST_WRITE_CONTACTS = 0x01; //写入联系人
    public static final int REQUEST_GET_ACCOUNTS = 0x02; //访问GMail账户列表
    public static final int REQUEST_READ_CONTACTS = 0x03; //读取联系人

    //group:android.permission-group.PHONE 电话
    public static final int REQUEST_READ_CALL_LOG = 0x04; //读取通话纪律
    public static final int REQUEST_READ_PHONE_STATE = 0x05; //读写手机状态和身份
    public static final int REQUEST_CALL_PHONE= 0x06; //拨打电话
    public static final int REQUEST_WRITE_CALL_LOG= 0x07; //写入通话纪律
    public static final int REQUEST_USE_SIP= 0x08; //使用SIP视频
    public static final int REQUEST_PROCESS_OUTGOING_CALLS= 0x09; //拨出电话
    public static final int REQUEST_ADD_VOICEMAIL= 0x10; //添加语言邮件

    //group:android.permission-group.CALENDAR 日程
    public static final int REQUEST_READ_CALENDAR= 0x11; //读取日程提醒
    public static final int REQUEST_WRITE_CALENDAR= 0x12; //写入日程提醒

    //group:android.permission-group.CAMERA 拍照
    public static final int REQUEST_READ_CAMERA= 0x13; //照相

    //group:android.permission-group.SENSORS 传感器
    public static final int REQUEST_BODY_SENSORS= 0x14; //传感器？(貌似google keep 以及一些google service相关的都需要)

    //group:android.permission-group.LOCATION 定位
    public static final int REQUEST_ACCESS_FINE_LOCATION= 0x15; //gps定位
    public static final int REQUEST_ACCESS_COARSE_LOCATION= 0x16; //网络定位

    //group:android.permission-group.STORAGE 存储
    public static final int REQUEST_READ_EXTERNAL_STORAGE= 0x17; //读取存储卡
    public static final int REQUEST_WRITE_EXTERNAL_STORAGE= 0x18; //写入存储卡

    //group:android.permission-group.MICROPHONE 麦克风
    public static final int REQUEST_RECORD_AUDIO= 0x19; //通过耳机或手机录音

    //group:android.permission-group.SMS 手机
    public static final int REQUEST_READ_SMS= 0x20; //读取短消息
    public static final int REQUEST_RECEIVE_WAP_PUSH= 0x21; //接收Wap Push
    public static final int REQUEST_RECEIVE_MMS= 0x22; //接受彩信
    public static final int REQUEST_RECEIVE_SMS= 0x23; //接受短信
    public static final int REQUEST_SEND_SMS= 0x24; //发送短信
    public static final int REQUEST_READ_CELL_BROADCASTS= 0x25; //读取小区广播

    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;

    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public static final String USE_SIP = Manifest.permission.USE_SIP;
    public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static final String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;

    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;

    public static final String CAMERA = Manifest.permission.CAMERA;

    public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;

    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;

    public static final String READ_SMS = Manifest.permission.READ_SMS;
    public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String SEND_SMS = Manifest.permission.SEND_SMS;


}
