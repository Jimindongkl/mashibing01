package org.ld.controller.webSocket;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.ld.model.webSocketModel.*;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;
import org.ld.service.WebSocketService.IWebSocketClientService;
import org.ld.service.WebSocketService.IWebSocketService;
import org.ld.service.congressControlService.ICongressControlService;
import org.ld.utils.Constant;
import org.ld.utils.WebSocketUtil;
import org.ld.websocket.MessageProcess;
import org.ld.websocket.WebSocketParamaters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/SendWebSocketMessageToCCU")
public class SendWebSocketMessageToCCU {
    private static SendWebSocketMessageToCCU sendWebSocketMessageToCCU;
    private static MyWebSocketClient socketConnect = new MyWebSocketClient();
    private static WebSocketClient webSocketClient;
    private static String fileName = "ccuconfig.properties";
    //目前正在进行的议程id
    private static String onGoingAgendaId;
    //目前正在进行的议题id
    private static String onGoingTopId ;
    /** 默认会序为-1 未开会状态*/
    private static int CongressId;

    static {
        CongressId = -1;
    }

    private static boolean sendOrNot = true;
    private static StringBuffer CongressOrderResult = new StringBuffer("-1||-1");

    @Resource(name = "myWebSocketService")
    private IWebSocketService myWebSocketService;
//    @Resource(name = "congressControlService")
    @Autowired
    private ICongressControlService congressControlService;//报到迁出

    @Autowired
    private IWebSocketClientService webSocketClientService;//CCU接口

    @PostConstruct
    void init(){
        sendWebSocketMessageToCCU = this;
        if(null == sendWebSocketMessageToCCU.congressControlService){
            sendWebSocketMessageToCCU.congressControlService = this.congressControlService;
        }
        sendWebSocketMessageToCCU.webSocketClientService = this.webSocketClientService;
        if(null == sendWebSocketMessageToCCU.myWebSocketService){
            sendWebSocketMessageToCCU.myWebSocketService = this.myWebSocketService;
        }
    }
    @RequestMapping("/client")
    @ResponseBody
    public ResponseServer getWebSocketClient(HttpServletRequest request){
        if(CongressId == -1){
            //第一次进入时 会序应该是-1 开会过程中就不再去新建和ccu端的webSocket连接
            HttpSession session = socketConnect.ClientConnect(request);
            webSocketClient = (WebSocketClient) session.getAttribute("webSocketClient");
        }
        System.out.println("websocket state  "+ MyWebSocketClient.client.getReadyState());
        if(MyWebSocketClient.client.getReadyState().equals(ReadyState.CLOSED)||MyWebSocketClient.client.getReadyState().equals(ReadyState.NOT_YET_CONNECTED)){
            HttpSession session = socketConnect.ClientConnect(request);
            webSocketClient = (WebSocketClient) session.getAttribute("webSocketClient");
        }
        JSONObject jsonObject = new JSONObject();
        StringBuilder stringBuffer;
        stringBuffer = new StringBuilder();
        //webSocket是连接状态 或者 会议是开启状态时 不再创建webSocket连接
        if( webSocketClient.isOpen() && sendOrNot){
            jsonObject.put("EventType", "CCUDevice");
            jsonObject.put("DeviceID", "");
            jsonObject.put("Channel", "");
            jsonObject.put("Address", "");
        List<CCUFirestConnectModel> modelList ;
        modelList = myWebSocketService.findIsUsedDeviceId();
        for(int i = 0; i<modelList.size();i++){
            if(i==0){
                stringBuffer.append(modelList.get(i).getDU_ID());
            }else{
                stringBuffer.append("|").append(modelList.get(i).getDU_ID());
            }
        }
            jsonObject.put("Data", "1");
//            jsonObject.put("Data",stringBuffer.toString() );
            webSocketClient.send(jsonObject.toString());
            sendOrNot = false;
        }
        return ResponseServer.success(jsonObject);
        }
    /**  根据ccu报文 进行数据库交互
     * @param s message*/
    public static void MessageToWebDesign(String s){
        if(MessageProcess.isJsonArray(s)){
            JSONArray jsonArray = JSONArray.fromObject(s);
                doCCUMessageHandle(jsonArray);
//              WebSocketParamaters.sendMessageToWebDesign(jsonArray.toString());
                WebSocketParamaters.broadcast(WebSocketParamaters.qianduan, jsonArray.toString());
        }else{
                WebSocketParamaters.broadcast(WebSocketParamaters.qianduan, s);
        }
    }

    @RequestMapping("/close")
    @ResponseBody
     public static ResponseServer closeWebSocket(){
        socketConnect.closeWebSocket();
        return ResponseServer.success("主动关闭webSocket客户端与CCU连接" );
     }

    @RequestMapping("/findDeviceInformation")
    @ResponseBody
    public ResponseServer findDeviceInformation(String id){
        CCUFirestConnectModel ccuFirestConnectModel ;
        WebSocektConfigModel webSocektConfigModel;
        String localFileName = fileName;
        List<CCUSeatUnitsModel> seatUnits = new ArrayList<>();
        List<JSON> list = new ArrayList<>();
        JSONObject jsonObject ;
        webSocektConfigModel = WebSocketUtil.initWebSocketConfigModel(localFileName);
        ccuFirestConnectModel = myWebSocketService.findDeviceInformation(id);
        jsonObject = doPutDevieInformation(ccuFirestConnectModel,webSocektConfigModel);
        try{
            seatUnits = myWebSocketService.findSeatUnitsInformation(jsonObject.get("congressId").toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(null != seatUnits){
            list = WebSocketUtil.doPutSeatUnits(seatUnits);

        }
        jsonObject.remove("congressId");
        jsonObject.put("DU_Seats", list);
        return ResponseServer.success(jsonObject);
    }

    /** WebSocket 客户端发送消息*/
    private void ClientSendMessageForJsonObject(JSONObject jsonObject){
        try {
            WebSocketClient localWebSocketClient = webSocketClient;
            localWebSocketClient.send(jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
            ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
        }
    }
    /**
     *  多命令接口
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param EventType 事件类型
     * 接口类型参数EventType前端传值，触发不需要data的指令
     * */
    @RequestMapping("/SimpleInstructions")
    @ResponseBody
    public ResponseServer SimpleInstructions(String DeviceID,String Channel,String Address,String EventType,String SeatID){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", EventType);
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        jsonObject.put("SeatID", SeatID);
        jsonObject.put("Data", "");
        try {
             WebSocketMessageForDAO(EventType,SeatID);
             ClientSendMessageForJsonObject(jsonObject);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
        }
        return ResponseServer.success(jsonObject);
    }

    /**
     * @param EventType 报文类型
     * @param SeatID 坐席id
     */
    private void WebSocketMessageForDAO(String EventType,String SeatID){
        switch (EventType){
            case "OpenDevice" :
                //将当前参会人员的报到信息初始化-status改为0
                congressControlService
                        .updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(0);
                break;
            case "CheckInAll" :
                //全部补报 将当前所有开会人员的状态改为 签到 1
                congressControlService
                        .updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(1);
                break;
            case "CheckInSingle" :
                //指定单元补报
                congressControlService
                        .updateUnderwayMeetingPersonCheckInTimeAndCheckState(Integer.parseInt(SeatID));
                break;
            case "UnCheckInAll" :
                //全部销报 将当前所有开会人员的状态改为 迁出 2
                congressControlService
                        .updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(2);
                break;
            case "UnCheckInSingle" :
                //指定单元销报
                congressControlService.
                        updateUnderwayMeetingPersonCheckInTimeAndCheckStateOut(Integer.parseInt(SeatID));
                break;
            case "StartCheckInAll" :
                //开始报道和重新报道时，将当前参会人员状态重置成 0
                congressControlService
                        .updateUnderwayMeetingPersonCheckInTimeAndCheckStateAll(0);
                break;
        }
    }
    /**
     * 设置报到结果
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param toCongressID 会议id
     * ”Data”:”应到人|实到人” 60|59
     * */
    @RequestMapping("/ShowCheckInResult")
    @ResponseBody
    public ResponseServer ShowCheckInResult(String DeviceID,String Channel,String Address,String toCongressID){
        JSONObject jsonObject = new JSONObject();
        StringBuilder stringBuffer = new StringBuilder();
        WebSocketModel webSocketModel = myWebSocketService.findReportResults(toCongressID);
            stringBuffer.append(webSocketModel.getShouldNum())
                    .append("|")
                    .append(webSocketModel.getActualNum());
        jsonObject.put("EventType", "ShowCheckInResult");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        jsonObject.put("Data", stringBuffer.toString());
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 设置发言容量
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param MaxSpeak 发言容量
     * 发言容量默认为6，因为c端是在配置文件中设置，没创建对应的表，所以在此项目中创建了ccuconfig.properties文件
     *                在此文件中设置配置属性
     * */
    @RequestMapping("/SetMaxSpeak")
    @ResponseBody
    public ResponseServer SetMaxSpeak(String DeviceID,String Channel,String Address,String MaxSpeak){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "SetMaxSpeak");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        if(null == MaxSpeak){//默认为6
            jsonObject.put("Data", "6");
            String TEMP = WebSocketUtil.readContext("MaxSpeakSumTogether",fileName);
            if(!TEMP.equals("6")){
                WebSocketUtil.setContext("MaxSpeakSumTogether","6",fileName);
            }
        }else{
            jsonObject.put("Data", MaxSpeak);
            WebSocketUtil.setContext("MaxSpeakSumTogether",MaxSpeak,fileName);
        }
            ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 设置发言模式
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param SpeechPatterns 发言模式 0 1 2 3
     * 申请发言= 0
     * 抢答发言= 1
     * 排队发言= 2
     * 自由发言= 3
     * */
    @RequestMapping("/SetSpeakModel")
    @ResponseBody
    public ResponseServer SetSpeakModel(String DeviceID,String Channel,String Address,String SpeechPatterns){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "SetSpeakModel");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        jsonObject.put("Data", SpeechPatterns);
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 开启或关闭指定单元话筒
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param microphonePatterns 0关闭  1 开启
     * */
    @RequestMapping("/ManageSpeak")
    @ResponseBody
    public ResponseServer ManageSpeak(String DeviceID,String Channel,String Address,String microphonePatterns){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "ManageSpeak");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        jsonObject.put("Data", microphonePatterns);
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 开始表决
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param id 议题id
     * data: 0|主表决议题|子议题1*子议题2*子议题3|赞成*反对*弃权|0
     *  VoteMethod| TopicName| topicCaption| keyCaption| key5Vote
     *  VoteMethod 0/1/2/3
     * 最后一次键盘有效的不公开表决 0
     * 第一次按键有效的不公开表决   1
     * 最后一次键盘有效的公开表决   2
     * 第一次按键有效的公开表决     3
     * TopicName  议题内容
     * topicCaption  子议题内容  如果没有传 nil 如有 子议题1*子议题2*子议题3
     * keyCaption     按钮显示名称   赞成*反对*弃权
     * key5Vote       是否为5键表决  0 否 1 是  数据库中 1否 2是
     * */
    @RequestMapping("/StartVoteAll")
    @ResponseBody
    public ResponseServer StartVoteAll(String DeviceID,String Channel,String Address,String id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "StartVoteAll");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        String arg = VoteData(id);
        jsonObject.put("Data",arg);
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 指定单元开始表决
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param SeatID 坐席id
     * @param id 议题id
     * data: 0|主表决议题|子议题1*子议题2*子议题3|赞成*反对*弃权|0
     *  VoteMethod| TopicName| topicCaption| keyCaption| key5Vote
     *  VoteMethod 0/1/2/3
     * 最后一次键盘有效的不公开表决 0
     * 第一次按键有效的不公开表决   1
     * 最后一次键盘有效的公开表决   2
     * 第一次按键有效的公开表决     3
     * TopicName  议题内容
     * topicCaption  子议题内容  如果没有传 nil
     * keyCaption     按钮显示名称   赞成*反对*弃权
     * key5Vote       是否为5键表决  0 否 1 是
     * */
    @RequestMapping("/VoteStartSingle")
    @ResponseBody
    public ResponseServer VoteStartSingle(String DeviceID,String Channel,String Address,String SeatID,String id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "VoteStartSingle");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        jsonObject.put("SeatID", SeatID);
        String arg = VoteData(id);
        jsonObject.put("Data", arg);
//           WebSocketMessageForDAO(EventType,SeatID);
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 处理表决需要的data
     * @param id 议题id
     * */
    private String VoteData(String id){
        StringBuilder stringBuffer = new StringBuilder();
        List<WebSocketModel> list;
        //查询当前表决议题
        WebSocketModel webSocketModel = myWebSocketService.findVoteTopicById(id);
        if(null == webSocketModel){
            //如果当前表决议题 查询为空
            stringBuffer.append("null").append("|");
        }else{
            stringBuffer.append(webSocketModel.getVoteMethod())
                    .append("|")
                    .append(webSocketModel.getToName()).append("|");
        }
        list = myWebSocketService.findChildById(id);
        if(null==list||list.size()==0){
            stringBuffer.append("null");
        }else{
            for(int i=0;i<list.size();i++){
                if(i==0){
                    stringBuffer.append(list.get(i).getToName());
                }else{
                    String a = "*"+list.get(i).getToName();
                    stringBuffer.append(a);
                }
            }
        }
        if(null == webSocketModel){
            stringBuffer.append("|").append("null");
        }else{
            String a = webSocketModel.getButtonOneName()+"*"+webSocketModel.getButtonTwoName()+"*"+webSocketModel.getButtonThreeName();
            stringBuffer.append("|")
                    .append(a)
                    .append("|")
                    .append(webSocketModel.getButtonType());//1为不是五键 2是
        }
        return stringBuffer.toString();
    }

    /**
     * 显示表决结果
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * @param id 议题id
     * 应该人数|实到人数|按键1人数|按键2人数|按键3人数|按键4人数|按键5人数|
     * */
    @RequestMapping("/ShowVoteResult")
    @ResponseBody
    public ResponseServer ShowVoteResult(String DeviceID,String Channel,String Address,String id){
        JSONObject jsonObject = new JSONObject();
        StringBuilder stringBuffer = new StringBuilder();
        jsonObject.put("EventType", "ShowVoteResult");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        WebSocketModel webSocketModel = myWebSocketService.findVoteResultById(id);
        if(null!=webSocketModel){
            stringBuffer.append(webSocketModel.getShouldNum()).append("|")
                    .append(webSocketModel.getActualNum()).append("|")
                    .append(webSocketModel.getButtonOneNum()).append("|")
                    .append(webSocketModel.getButtonTwoNum()).append("|")
                    .append(webSocketModel.getButtonThreeNum()).append("|")
                    .append(webSocketModel.getButtonFourNum()).append("|")
                    .append(webSocketModel.getButtoFiveNum());
        }else{
            stringBuffer.append("null").append("|").append("null").append("|")
                    .append("null").append("|").append("null").append("|")
                    .append("null").append("|").append("null").append("|")
                    .append("null");
        }
        jsonObject.put("Data", stringBuffer.toString());
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 显示关闭网页前表决结果，用于表决期间意外关闭网页，重新打开时获取已表决记录，
     * 远远不够用，因此注释掉
     * 然后还需要另外一个接口批量获取谁已表决，赞成还是否决还是弃权，还有相关坐席id，未完待续
     * @param id 议题id
     * 应该人数|实到人数|按键1人数|按键2人数|按键3人数|按键4人数|按键5人数|
     * */
//    @RequestMapping("/ShowOngoingVoteResult")
//    @ResponseBody
//    public ResponseServer ShowOngoingVoteResult( String id){
//        JSONObject jsonObject = new JSONObject();
//        StringBuilder stringBuffer = new StringBuilder();
//        jsonObject.put("EventType", "ShowOngoingVoteResult"); 
//        WebSocketModel webSocketModel = myWebSocketService.findVoteResultById(id);
//        if(null!=webSocketModel){
//            stringBuffer.append(webSocketModel.getShouldNum()).append("|")
//                    .append(webSocketModel.getActualNum()).append("|")
//                    .append(webSocketModel.getButtonOneNum()).append("|")
//                    .append(webSocketModel.getButtonTwoNum()).append("|")
//                    .append(webSocketModel.getButtonThreeNum()).append("|")
//                    .append(webSocketModel.getButtonFourNum()).append("|")
//                    .append(webSocketModel.getButtoFiveNum());
//        }else{
//            stringBuffer.append("null").append("|").append("null").append("|")
//                    .append("null").append("|").append("null").append("|")
//                    .append("null").append("|").append("null").append("|")
//                    .append("null");
//        }
//        jsonObject.put("Data", stringBuffer.toString());
//        //   WebSocketMessageForDAO(EventType,SeatID);
//        ClientSendMessageForJsonObject(jsonObject);
//        return ResponseServer.success(jsonObject);
//    }
    
    
    /** 合格不合格 通过不通过*/
    @RequestMapping("/VoteIsPassOrNot")
    @ResponseBody
    public ResponseServer VoteIsPassOrNot(String id){//根据议题id 获取表决结果
        WebSocketModel webSocketModel = myWebSocketService.findVoteResultById(id);
        JSONObject jsonObject = new JSONObject();
        Integer Divisor ;//除数
        Integer Divisor2 ;//被除数
        int result ;
        String PassTatio = WebSocketUtil.readContext("PassTatio", fileName);
        String VoteBase = WebSocketUtil.readContext("VoteBase",fileName );
        Integer state = webSocketModel.getVoteResult();
        webSocketModel.setToId(id);
        if(state==2){//查询有表决结果并且不是默认值2 ，直接反馈当前表决结果，没有则重新计算
            Divisor2 = webSocketModel.getButtonOneNum();
            if(VoteBase.equals("1")){
                Divisor = webSocketModel.getActualNum();
            }else{
                Divisor = webSocketModel.getShouldNum();
            }
            if(PassTatio.equals("1")){
               Integer temp = 2*Divisor2;
               result = Divisor.compareTo(temp);
            }else{
                Integer temp = 2*Divisor;
                Integer temp2 = 3*Divisor2;
                result = temp.compareTo(temp2);
            }
            if(result==1){
                //未通过
                jsonObject.put("result", "1");
                webSocketModel.setVoteResult(1);
            }else{
                //通过
                jsonObject.put("result", "0");
                webSocketModel.setVoteResult(0);
            }

        }else{
            Integer a = webSocketModel.getVoteResult();
            jsonObject.put("result", a.toString());
        }
        if(state == 2){
            myWebSocketService.updateVoteResult(webSocketModel);
        }
        return ResponseServer.success(jsonObject);
    }
    /**
     * 多项议题开始表决
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     *  data: 0|主表决议题|子议题1*子议题2*子议题3|赞成*反对*弃权|0
     *  VoteMethod| TopicName| topicCaption| keyCaption| key5Vote
     *  VoteMethod 0/1/2/3
     * 最后一次键盘有效的不公开表决 0
     * 第一次按键有效的不公开表决   1
     * 最后一次键盘有效的公开表决   2
     * 第一次按键有效的公开表决     3
     * TopicName  议题内容
     * topicCaption  子议题内容  如果没有传 nil
     * keyCaption     按钮显示名称   赞成*反对*弃权
     * key5Vote       是否为5键表决  0 否 1 是
     * */
    @RequestMapping("/MuchVoteStartAll")
    @ResponseBody
    public ResponseServer MuchVoteStartAll(String DeviceID,String Channel,String Address,String id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "MuchVoteStartAll");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        String arg = VoteData(id);
        jsonObject.put("Data", arg);
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }

    /**
     * 多项议题指定单元开始表决
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * data: 0|主表决议题|子议题1*子议题2*子议题3|赞成*反对*弃权|0
     *  VoteMethod| TopicName| topicCaption| keyCaption| key5Vote
     *  VoteMethod 0/1/2/3
     * 最后一次键盘有效的不公开表决 0
     * 第一次按键有效的不公开表决   1
     * 最后一次键盘有效的公开表决   2
     * 第一次按键有效的公开表决     3
     * TopicName  议题内容
     * topicCaption  子议题内容  子议题1*子议题2*子议题3
     * keyCaption     按钮显示名称   赞成*反对*弃权
     * key5Vote       是否为5键表决  0 否 1 是
     * */
    @RequestMapping("/MuchVoteStartSingle")
    @ResponseBody
    public ResponseServer MuchVoteStartSingle(String DeviceID,String Channel,String Address, String SeatID,String id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "MuchVoteStartSingle");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        String arg = VoteData(id);
        jsonObject.put("Data", arg);
        ClientSendMessageForJsonObject(jsonObject);
        return ResponseServer.success(jsonObject);
    }



    /**
     * 下发议题
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * ”Data”:”议题内容”
     * */
    @RequestMapping("/SendTopicAll")
    @ResponseBody
    public ResponseServer SendTopicAll(String DeviceID,String Channel,String Address,String id){
        JSONObject jsonObject = new JSONObject();
        WebSocketClient localWebSocketClient;
        jsonObject.put("EventType", "SendTopicAll");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        WebSocketModel webSocketModel = myWebSocketService.getTopicContent(id);
        if(null == webSocketModel){
            jsonObject.put("Data", "");
        }else{
            jsonObject.put("Data", webSocketModel.getToContent());
        }
        try {
            localWebSocketClient = webSocketClient;
            localWebSocketClient.send(jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
        }
        return ResponseServer.success(jsonObject);
    }

    /**
     * 指定单元下发议题
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * ”Data”:”议题内容”
     * */
    @RequestMapping("/SendTopicSingle")
    @ResponseBody
    public ResponseServer SendTopicSingle(String DeviceID,String Channel,String Address,String id){
        JSONObject jsonObject = new JSONObject();
        WebSocketClient localWebSocketClient;
        jsonObject.put("EventType", "SendTopicSingle");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        WebSocketModel webSocketModel = myWebSocketService.getTopicContent(id);
        if(null == webSocketModel){
            jsonObject.put("Data", "");
        }else{
            jsonObject.put("Data", webSocketModel.getToContent());
        }
        try {
            localWebSocketClient = webSocketClient;
            localWebSocketClient.send(jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
        }
        return ResponseServer.success(jsonObject);
    }

    /**
     * 指定单元发送短信息
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * data 短信内容
     * */
    @RequestMapping("/ShortMsgSingle")
    @ResponseBody
    public ResponseServer ShortMsgSingle(String DeviceID,String Channel,String Address,String ShortMessage){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "ShortMsgSingle");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        jsonObject.put("Data", ShortMessage);
        try {
            webSocketClient.send(jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
        }
        return ResponseServer.success(jsonObject);
    }

    /**
     * 发送短信息
     * @param DeviceID 设备id
     * @param Channel 通道号
     * @param Address 地址号
     * data 短信内容
     * */
    @RequestMapping("/ShortMsgAll")
    @ResponseBody
    public ResponseServer ShortMsgAll(String DeviceID,String Channel,String Address,String ShortMessage){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("EventType", "ShortMsgAll");
        jsonObject.put("DeviceID", DeviceID);
        jsonObject.put("Channel", Channel);
        jsonObject.put("Address", Address);
        jsonObject.put("Data", ShortMessage);
        try {
            webSocketClient.send(jsonObject.toString());
        }catch (Exception e){
            e.printStackTrace();
            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
        }
        return ResponseServer.success(jsonObject);
    }

//如果多指令方法有问题，可使用单条指令接口,测试多指令无问题也符合业务时，以下方法可以删除
//    /**
//     *  连接设备
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/OpenDevice")
//    @ResponseBody
//    public ResponseServer OpenDevice(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "OpenDevice");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     *  关闭设备
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     *
//     * */
//    @RequestMapping("/CloseDevice")
//    @ResponseBody
//    public ResponseServer CloseDevice(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "CloseDevice");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     *  查询设备
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     *
//     * */
//    @RequestMapping("/ScanDecice")
//    @ResponseBody
//    public ResponseServer ScanDecice(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "ScanDecice");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 全部补报
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//        @RequestMapping("/CheckInAll")
//    @ResponseBody
//    public ResponseServer CheckInAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "CheckInAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 指定单元补报
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/CheckInSingle")
//    @ResponseBody
//    public ResponseServer CheckInSingle(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "CheckInSingle");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 全部销报
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/UnCheckInAll")
//    @ResponseBody
//    public ResponseServer UnCheckInAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "UnCheckInAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 指定单元销报
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/UnCheckInSingle")
//    @ResponseBody
//    public ResponseServer UnCheckInSingle(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "UnCheckInSingle");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 结束表决
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/StopVoteAll")
//    @ResponseBody
//    public ResponseServer StopVoteAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "StopVoteAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 指定单元结束表决
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/VoteStopSingle")
//    @ResponseBody
//    public ResponseServer VoteStopSingle(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "VoteStopSingle");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 多项议题结束表决
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/MuchVoteStopAll")
//    @ResponseBody
//    public ResponseServer MuchVoteStopAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "MuchVoteStopAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 多项议题指定单元结束表决
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/MuchVoteStopSingle")
//    @ResponseBody
//    public ResponseServer MuchVoteStopSingle(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "MuchVoteStopSingle");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 开始报道
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/StartCheckInAll")
//    @ResponseBody
//    public ResponseServer StartCheckInAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "StartCheckInAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 指定单元开始报道
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @ResponseBody
//    public ResponseServer StartCheckInSingle(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "StartCheckInSingle");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     *结束报道
//     *
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/StopCheckInAll")
//    @ResponseBody
//    public ResponseServer StopCheckInAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "StopCheckInAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 指定单元结束报道
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/StopCheckInSingle")
//    @ResponseBody
//    public ResponseServer StopCheckInSingle(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "StopCheckInSingle");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 全部暂停报到
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/PauseCheckInAll")
//    @ResponseBody
//    public ResponseServer PauseCheckInAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "PauseCheckInAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 全部继续报到
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/ResumeCheckInAll")
//    @ResponseBody
//    public ResponseServer ResumeCheckInAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "ResumeCheckInAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }
//
//    /**
//     * 结束议题
//     * @param DeviceID 设备id
//     * @param Channel 通道号
//     * @param Address 地址号
//     * */
//    @RequestMapping("/TopicEndAll")
//    @ResponseBody
//    public ResponseServer TopicEndAll(String DeviceID,String Channel,String Address){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("EventType", "TopicEndAll");
//        jsonObject.put("DeviceID", DeviceID);
//        jsonObject.put("Channel", Channel);
//        jsonObject.put("Address", Address);
//        jsonObject.put("Data", "");
//        try {
//            webSocketClient.send(jsonObject.toString());
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseServer.error(ResponseEnum.valueOf("请检查webSocket连接状态"));
//        }
//        return ResponseServer.success(jsonObject);
//    }

    /**
     * 获取当前会序
     * */
    @RequestMapping("/getCurrMeetingOrder")
    @ResponseBody
    public JSONObject getCurrMeetingOrder(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("order", CongressOrderResult.toString());
        return jsonObject;
    }

    /**
     * 更改当前会序
     * */
    @RequestMapping("/updateMeetOrder")
    @ResponseBody
    public JSONObject updateMeetOrder(int status){
        int temp;
        if(status == -1) {sendOrNot = true;}
        JSONObject jsonObject = new JSONObject();
        temp = CongressOrderConversion(status);
        CongressId = temp;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(CongressId)
                .append("||")
                .append(status);
        CongressOrderResult = stringBuffer;
        jsonObject.put("order",stringBuffer.toString());
        return jsonObject;
    }

    /** 申请发言人 列表*/
    @RequestMapping("/getApplyPeople")
    @ResponseBody
    public ResponseServer getApplyPeople(){
        Map map = new HashMap();
        List<WebSocketClientModel> modelList = webSocketClientService.getApplyPeople();
        map.put("modelList", modelList);
        return ResponseServer.success(modelList);
    }
    /** 获取正在发言人列表 */
    @RequestMapping("/getSpeakers")
    @ResponseBody
    public ResponseServer getSpeakers(){
        Map map = new HashMap();
        List<WebSocketClientModel> modelList = webSocketClientService.getSpeakers();
        Integer temp ;
        for (int i = 0; i < modelList.size(); i++) {
            WebSocketClientModel model = modelList.get(i);
            //如果 用户有优先发言权则列表不展示
            temp = webSocketClientService.searchFirstSpeakPower(model.getSR_AgendaStaffID().toString());
            if(temp.equals(1)){
                modelList.remove(i);
            }
        }
        map.put("modelList", modelList);
        return ResponseServer.success(map);
    }
    /** 大屏展示，只展示一个正在发言人*/
    @RequestMapping("/getSpeakerForScreen")
    @ResponseBody
    public ResponseServer getSpeakerForScreen(){
        Map map = new HashMap();
        List<WebSocketClientModel> modelList = webSocketClientService.getSpeakers();
        //倒序取数据，默认取第一个即是展示的最新发言人
        int index =0;
        map.put("modelList", modelList.get(index));
        return ResponseServer.success(map);
    }
    /** 增加申请发言人信息
     *
     * @param SeatID 坐席id*/
    @RequestMapping("/insertApplyInformation")
    @ResponseBody
    public ResponseServer insertApplyInformation(String SeatID){
        webSocketClientService.insertApplyInformation(SeatID);
        return ResponseServer.success();
    }
    /** 增加或修改 开始发言时间*/
    @RequestMapping("/insertOrUpdateApplyInformation")
    @ResponseBody
    public  ResponseServer insertOrUpdateApplyInformation(String SeatID){
        webSocketClientService.insertOrUpdateApplyInformation(SeatID);
        return ResponseServer.success();
    }

    /** 更新结束发言时间*/
    @RequestMapping("/updateEndTime")
    @ResponseBody
    public ResponseServer updateEndTime(String SeatID,String SrTopicID){
        WebSocketClientModel model = new WebSocketClientModel();
        model.setSR_AgendaStaffID(Integer.valueOf(SeatID));
        model.setSR_TopicID(Integer.valueOf(SrTopicID));
        webSocketClientService.updateEndTime(model);
        return ResponseServer.success();
    }
    /** 根据记录id 删除记录信息*/
    @RequestMapping("/deleteSpeakRecordBySrId")
    @ResponseBody
    public ResponseServer deleteSpeakRecordBySrId(String SeatID){
        WebSocketClientModel model = new WebSocketClientModel();
        model.setSR_AgendaStaffID(Integer.valueOf(SeatID));
        webSocketClientService.deleteSpeakRecordBySrId(model);
        return ResponseServer.success();
    }
    private int CongressOrderConversion(int status){
        int result ;
        result = Constant.CongressOrderConversion(status);
        return result;
    }

    /** 获取正在进行的议程id
     * */
    @RequestMapping("/getOnGoingAgendaId")
    @ResponseBody
    public ResponseServer getOnGoingAgendaId(String agendaId){
        onGoingAgendaId = agendaId;
        return ResponseServer.success(onGoingAgendaId);
    }

    /** 获取正在进行的议题id
     * */
    @RequestMapping("/getOnGoingTopId")
    @ResponseBody
    public ResponseServer getOnGoingTopId(String topId){
        onGoingTopId = topId;
        return ResponseServer.success(onGoingTopId);
    }

    /** 开始表决前根据议题id 初始化 按键人数及表决结果*/
    @RequestMapping("/doVoteNumInitialization")
    @ResponseBody
    public ResponseServer doVoteNumInitialization(String topId){
        myWebSocketService.doVoteNumInitialization(topId);
        return ResponseServer.success();
    }
    /** 根据报文进行表决结果持久化
     * key1 赞成
     * key2 反对
     * key3 弃权
     * 测试用
     * */
    @RequestMapping("/updateVoteByWebSocket")
    @ResponseBody
    public ResponseServer updateVoteByWebSocket(String Status){
        WebSocketModel model = new WebSocketModel();
        if(StringUtils.isNotEmpty(onGoingTopId)){
            model.setToId(onGoingTopId);
        }else{
            model.setToId("0");
        }
        switch (Status){
            case "Key1" :
                //To_ButtonOneNum 人数加1
                model.setTempSqlName("To_ButtonOneNum");
                myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key2" :
                //To_ButtonTwoNum 人数加1
                model.setTempSqlName("To_ButtonTwoNum");
                myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key3" :
                //To_ButtonThreeNum 人数加1
                model.setTempSqlName("To_ButtonThreeNum");
                myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key4" :
                //To_ButtonFourNum
                model.setTempSqlName("To_ButtonFourNum");
                myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key5" :
                //To_ButtoFiveNum
                model.setTempSqlName("To_ButtoFiveNum");
                myWebSocketService.updateVoteByWebSocket(model);
                break;
        }
        return  ResponseServer.success(model);
    }

    /** 根据报文进行表决结果持久化
     * key1 赞成
     * key2 反对
     * key3 弃权
     * */
    private static void doVoteMessageForSth(String seatId,String Status){
        WebSocketModel model = new WebSocketModel();
        if(StringUtils.isEmpty(onGoingTopId)){
            model.setToId("0");
            System.out.println("未获取到当前议题id，无法进行表决结果持久化操作");
        }else{
            model.setToId(onGoingTopId);
        }
        switch (Status){
            case "Key1" :
                //To_ButtonOneNum 人数加1
                model.setTempSqlName("To_ButtonOneNum");
                sendWebSocketMessageToCCU.myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key2" :
                //To_ButtonTwoNum 人数加1
                model.setTempSqlName("To_ButtonTwoNum");
                sendWebSocketMessageToCCU.myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key3" :
                //To_ButtonThreeNum 人数加1
                model.setTempSqlName("To_ButtonThreeNum");
                sendWebSocketMessageToCCU.myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key4" :
                //To_ButtonFourNum
                model.setTempSqlName("To_ButtonFourNum");
                sendWebSocketMessageToCCU.myWebSocketService.updateVoteByWebSocket(model);
                break;
            case "Key5" :
                //To_ButtoFiveNum
                model.setTempSqlName("To_ButtoFiveNum");
                sendWebSocketMessageToCCU.myWebSocketService.updateVoteByWebSocket(model);
                break;
        }
    }

    /** 根据议题id更新 应到、实到人数*/
    @RequestMapping("/updateSAnumByTopId")
    @ResponseBody
    public ResponseServer updateSAnumByTopId(String topId){
        onGoingTopId = topId;
        WebSocketModel model = new WebSocketModel();
        model.setToId(topId);
        Integer countActualNum = myWebSocketService.countActualNum(topId);
        model.setActualNum(countActualNum);
        Integer countShouldNum = myWebSocketService.countShouldNum(topId);
        model.setShouldNum(countShouldNum);
        myWebSocketService.updateSAnumByTopId(model);

        return ResponseServer.success(model);
    }



    public static int getCongressId() {
        return CongressId;
    }

    public static void setCongressId(int congressId) {
        CongressId = congressId;
    }


    /** 拼接设备信息*/
    private JSONObject doPutDevieInformation(CCUFirestConnectModel ccuFirestConnectModel,WebSocektConfigModel webSocektConfigModel) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("DeviceGUID",ccuFirestConnectModel.getDU_ID());//设备ID
        jsonObject.put("CCUIP",ccuFirestConnectModel.getDU_NetIPAddress());//设备IP
        jsonObject.put("CCUPort",ccuFirestConnectModel.getDU_NetSendPort());//设备端口
        jsonObject.put("ChannelMinNumber",ccuFirestConnectModel.getDU_PassWayStartNum());//最小通道号
        jsonObject.put("ChannelCount",ccuFirestConnectModel.getDU_PassWayCount());//通道数量
        jsonObject.put("EnabledBrowseAll",webSocektConfigModel.getEnabledBrowseAll());//是否有浏览权 默认为ture
        jsonObject.put("EnabledCallAll",webSocektConfigModel.getEnabledCallAll());//是否有呼叫权
        jsonObject.put("EnabledSpeakAll",webSocektConfigModel.getEnabledSpeakAll());//是否有发言权
        jsonObject.put("EnabledCheckedInAll",webSocektConfigModel.getEnabledCheckedInAll());//是否有报道权
        jsonObject.put("EnabledVoteAll",webSocektConfigModel.getEnabledVoteAll());//是否有表决权
        jsonObject.put("ShowCheckInResult",webSocektConfigModel.getShowCheckInResult());//是否显示报到结果
        jsonObject.put("ICOutType",webSocektConfigModel.getICOutType());//卡模式
        ccuFirestConnectModel = myWebSocketService.findIsRunning();
        jsonObject.put("CReportMethod",ccuFirestConnectModel.getCoCheckInType());//报到模式
        jsonObject.put("CSeatMethod",ccuFirestConnectModel.getCoSeatMode());//就坐模式
        jsonObject.put("CSpeakMothod",webSocektConfigModel.getCSpeakMothod());//发言模式
        jsonObject.put("VoteMethodType",webSocektConfigModel.getToVoteMethod());//表决模式
        //jsonObject.put("VoteShowType",ccuFirestConnectModel.getToShowMode());//表决结果显示模式
        jsonObject.put("VoteShowType", webSocektConfigModel.getVoteShowType());//表决结果显示模式
        jsonObject.put("MaxSpeakSumTogether",webSocektConfigModel.getMaxSpeakSumTogether());//最大发言容量 默认6
        jsonObject.put("SpeakFirstCloseClient",webSocektConfigModel.getSpeakFirstCloseClient());//优先发言键按下时是否关闭其他发言设备 默认为true
        jsonObject.put("congressId", ccuFirestConnectModel.getCongressId());
        return jsonObject;
    }

    /** 根据报文类型进行数据库交互及相应业务处理*/
    private static void doCCUMessageHandle(JSONArray jsonArray) {
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if(!jsonObject.get("Status").equals(WebSocketUtil.UnRegister) && jsonObject.containsValue("RegisterEvent") ){
                String seatId = jsonObject.getString("SeatID");
                sendWebSocketMessageToCCU.congressControlService.updateUnderwayMeetingPersonCheckInTimeAndCheckState(Integer.valueOf(seatId));
                System.out.println("--------->修改的坐席id："+seatId);
            }else if(jsonObject.containsValue("SpeakEvent") && jsonObject.get("Status").equals(WebSocketUtil.ApplyOn)){
                String seatId = jsonObject.getString("SeatID");
                //收到申请发言消息，在 发言记录表中 插入一条 申请发言记录
                sendWebSocketMessageToCCU.webSocketClientService.insertApplyInformation(seatId);
                System.out.println("--------->申请发言的id："+seatId);
            }else if (jsonObject.containsValue("SpeakEvent") && jsonObject.get("Status").equals(WebSocketUtil.ApplyOff)){
                String seatId = jsonObject.getString("SeatID");
                //收到取消申请发言消息时，将 之前的申请发言记录删除
                WebSocketClientModel model = new WebSocketClientModel();
                model.setSR_AgendaStaffID(Integer.valueOf(seatId));
                sendWebSocketMessageToCCU.webSocketClientService.deleteSpeakRecordBySrId(model);
                System.out.println("--------->删除申请发言的id："+seatId);
            }
            else if(jsonObject.containsValue("SpeakEvent") && jsonObject.get("Status").equals(WebSocketUtil.SpeakOn)){
                String seatId = jsonObject.getString("SeatID");
                //收到正在发言消息，在发言记录中 插入一条正在发言记录或更新发言人开始发言时间
                sendWebSocketMessageToCCU.webSocketClientService.insertOrUpdateApplyInformation(seatId);
                System.out.println("--------->正在发言的id："+seatId);
            }else if(jsonObject.containsValue("SpeakEvent") && jsonObject.get("Status").equals(WebSocketUtil.SpeakOff)){
                String seatId = jsonObject.getString("SeatID");
                WebSocketClientModel model = new WebSocketClientModel();
                model.setSR_AgendaStaffID(Integer.valueOf(seatId));
                sendWebSocketMessageToCCU.webSocketClientService.updateEndTime(model);
                System.out.println("--------->结束发言的id："+seatId);
            }else if(jsonObject.containsValue("VoteEvent")){//表决
            	  String seatId = jsonObject.getString("SeatID");
            	  System.out.println("--------->表决的seatId："+seatId);
                doVoteMessageForSth(seatId,jsonObject.get("Status").toString());
            }
        }

    }
}
