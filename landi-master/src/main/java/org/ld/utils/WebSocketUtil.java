package org.ld.utils;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.ld.controller.webSocket.SendWebSocketMessageToCCU;
import org.ld.model.webSocketModel.CCUSeatUnitsModel;
import org.ld.model.webSocketModel.WebSocektConfigModel;
import org.ld.model.webSocketModel.WebSocketClientModel;
import org.ld.service.WebSocketService.IWebSocketService;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * @program: landi-master
 * @description: WebSocket
 * @author: 魏中元
 * @create: 2021-01-19 15:21
 **/
public class WebSocketUtil {

    /**设置配置文件某一参数的值*/
    public static void setContext(String key, String value,String fileName) {
        InputStream is = null;
        OutputStream os ;
        Properties pro = new Properties();
        StringBuilder stringBuffer = new StringBuilder();
        try {
            is = new FileInputStream(SendWebSocketMessageToCCU.class.getClassLoader().getResource(fileName).getFile());
            pro.load(is);
            pro.setProperty(key, value);
            Enumeration enumeration = pro.propertyNames();//获取配置文件名字
            while(enumeration.hasMoreElements()){
                String strKey = (String) enumeration.nextElement();
                String strValue = pro.getProperty(strKey);
                stringBuffer.append(strKey).append("=").append(strValue).append("\n");
            }
            System.out.println(stringBuffer.toString());
            os = new FileOutputStream(SendWebSocketMessageToCCU.class.getClassLoader().getResource(fileName).getFile());
            os.write(stringBuffer.toString().getBytes());
//            pro.store(os, key);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /** 从配置文件中获取参数value*/
    public static String readContext(String key,String fileName) {
        String value = "";
        InputStream is = null;
        try {
            is = SendWebSocketMessageToCCU.class.getClassLoader().getResourceAsStream(
                    fileName);
            Properties p = new Properties();
            p.load(is);
            value = p.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    //销报
    public static String UnRegister = String.valueOf("UnRegister");
    //申请发言
    public static String ApplyOn = String.valueOf("ApplyOn");
    //取消申请
    public static String ApplyOff = String.valueOf("ApplyOff");
    //正在发言
    public static String SpeakOn = String.valueOf("SpeakOn");
    //关闭发言
    public static String SpeakOff =String.valueOf("SpeakOff");

    //
    public static  WebSocektConfigModel initWebSocketConfigModel(String localFileName) {
        WebSocektConfigModel configModel = new WebSocektConfigModel();
        String EnabledBrowseAll = WebSocketUtil.readContext("EnabledBrowseAll",localFileName);
        String EnabledCallAll =  WebSocketUtil.readContext("EnabledCallAll",localFileName);
        String EnabledSpeakAll = WebSocketUtil.readContext("EnabledSpeakAll",localFileName);
        String EnabledCheckedInAll = WebSocketUtil.readContext("EnabledCheckedInAll",localFileName);
        String EnabledVoteAll = WebSocketUtil.readContext("EnabledVoteAll",localFileName);
        String ShowCheckInResult = WebSocketUtil.readContext("ShowCheckInResult",localFileName);
        String ICOutType = WebSocketUtil.readContext("ICOutType",localFileName);
        String MaxSpeakSumTogether = WebSocketUtil.readContext("MaxSpeakSumTogether",localFileName);
        String SpeakFirstCloseClient = WebSocketUtil.readContext("SpeakFirstCloseClient",localFileName);
        String VoteShowType = WebSocketUtil.readContext("VoteShowType", localFileName);
        String CSpeakMothod = WebSocketUtil.readContext("CSpeakMothod", localFileName);
        String ToVoteMethod = WebSocketUtil.readContext("ToVoteMethod", localFileName);
        configModel.setEnabledBrowseAll(EnabledBrowseAll);
        configModel.setEnabledCallAll(EnabledCallAll);
        configModel.setEnabledSpeakAll(EnabledSpeakAll);
        configModel.setEnabledCheckedInAll(EnabledCheckedInAll);
        configModel.setShowCheckInResult(ShowCheckInResult);
        configModel.setICOutType(ICOutType);
        configModel.setMaxSpeakSumTogether(MaxSpeakSumTogether);
        configModel.setEnabledVoteAll(EnabledVoteAll);
        configModel.setSpeakFirstCloseClient(SpeakFirstCloseClient);
        configModel.setVoteShowType(VoteShowType);
        configModel.setCSpeakMothod(CSpeakMothod);
        configModel.setToVoteMethod(ToVoteMethod);
        return configModel;
    }

    /** 拼接坐席信息*/
    public static List<JSON> doPutSeatUnits(List<CCUSeatUnitsModel> seatUnits) {
        List<JSON> list = new ArrayList<>();
        for(CCUSeatUnitsModel model : seatUnits ){
            JSONObject SeatUnits = new JSONObject();//坐席
            SeatUnits.put("SU_ID", model.getAP_SeatID());//坐席id
            SeatUnits.put("SU_DeviceID", model.getSD_DeviceID());//设备id
            SeatUnits.put("AP_ReportPower", model.getAP_ReportPower());//报道权
            SeatUnits.put("AP_VotePower", model.getAP_VotePower());//表决权
            SeatUnits.put("AP_SpeakPower", model.getAP_SpeakPower());//发言权
            SeatUnits.put("AP_FirstSpeakPower", model.getAP_FirstSpeakPower());//优先发言权
            SeatUnits.put("AP_CallPower", model.getAP_CallPower());//呼叫权
            SeatUnits.put("AP_SearchPower", model.getAP_SearchPower());//搜索权
            SeatUnits.put("SD_PassWayCode", model.getSD_PassWayCode());//通道号
            SeatUnits.put("SD_CCUAddressCode", model.getSD_CCUAddressCode());//地址号
            SeatUnits.put("SD_OtherPassWayCode", "");//备用通道号
            SeatUnits.put("SD_OtherAddressCode", "");//备用地址号
            if(null == model.getSt_ViceCardNum()){
                SeatUnits.put("St_ViceCardNum", "");//卡号
            }else{
                SeatUnits.put("St_ViceCardNum", model.getSt_ViceCardNum());//卡号
            }
            list.add(SeatUnits);
        }
        return list;
    }
}
