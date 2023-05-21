package org.ld.websocket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.ld.controller.SeatDeviceController;
import org.ld.model.Message;
import org.ld.service.congressControlService.ICongressControlService;
import org.ld.utils.Constant;
import org.ld.utils.Util;
import org.ld.vo.JsonVo;
import org.ld.vo.MessageByStr;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 报文处理
 * 1.判断报文类型 JudgeMessageType
 * 2.处理报文
 * 3.会控需要的方法及变量
 * 4.拼接报文（主动发送时需要的功能）
 *
 * */
public class MessageProcess {



    //将C#端 json格式数据进行处理
    public static JSONObject MessageToJson(JSONArray jsons){
        Map results = new HashMap();
        List data = new ArrayList();
        for(int i=0;i< jsons.size();i++){
            Map<String ,Object> map = new HashMap<String ,Object>();
            JsonVo jsonVo = new JsonVo();
            String seatid = new String() ;
            JSONObject jsonObject = (JSONObject) jsons.get(i);//取到c#端发来的json数组
            jsonVo.setEventType(jsonObject.get("EventType").toString());//RegisterEvent 报到，VoteEvent 表决，Speak 发言，CallServiceEvent 呼叫服务
            jsonVo.setStatus(jsonObject.get("Status").toString());//状态
            jsonVo.setSpare(jsonObject.get("Spare").toString());//议题序号，除表决类型的报文，可以设置为null
            //拼接查询seatid用到的key
            StringBuffer key = new StringBuffer();
            key.append(jsonObject.get("DeviceID")).append('|')
                    .append(jsonObject.get("Channel")).append('|')
                    .append(jsonObject.get("Address"));
            if(SeatDeviceController.contextMap.containsKey(key.toString())){//如果缓存中有对应key
                //则赋值给seatid
                seatid = SeatDeviceController.contextMap.get(key.toString()).toString();
            }else{//没有对应key则刷新缓存
                SeatDeviceController seatDeviceController  = new SeatDeviceController();
                seatDeviceController.getSeatIdCache(false,1);
                //刷新缓存还是没有，则存空。
                if(SeatDeviceController.contextMap.containsKey(key.toString())){
                    seatid = SeatDeviceController.contextMap.get(key.toString()).toString();
                }else{
                    seatid="";
                }
            }
            //拼接数据
            map.put("seatId", seatid);//加载seatid
            map.put(jsonVo.getEventType(), jsonVo);//根据报文类型存储
            if(map.containsKey("RegisterEvent"  )){
                //如果存在报到状态,其他类型传空，否则前端无法渲染，必须有四种类型数据
                Map  a = new HashMap<>();
                map.put("VoteEvent", a);
                map.put("SpeakEvent", a);
                map.put("CallServiceEvent", a);
            }else if(map.containsKey("VoteEvent")){
                Map  a = new HashMap<>();
                map.put("RegisterEvent", a);
                map.put("SpeakEvent", a);
                map.put("CallServiceEvent", a);
            }else if(map.containsKey("SpeakEvent")){
                Map  a = new HashMap<>();
                map.put("VoteEvent", a);
                map.put("RegisterEvent", a);
                map.put("CallServiceEvent", a);
            }else{
                Map  a = new HashMap<>();
                map.put("VoteEvent", a);
                map.put("SpeakEvent", a);
                map.put("RegisterEvent", a);
                map.put("CallServiceEvent", a);
            }
            data.add(map);
        }
        results.put("results", data);
        JSONObject object = JSONObject.fromObject(results);
        System.out.println(object);
        return object;
    }
   /*

    *//**
     * 截取string类型报文内容
     * 通过crc校验比对 看报文内容是否发生变化
     * *//*
    public static boolean messageCheck(String message){
        boolean symbol = false;
        int length = message.length();
        int end = length - 4;
        String waitCheck = message.substring(0,end);
        String messageCrc = message.substring(end,length);
        byte[] crc = new byte[2];
        StringBuffer sb =new StringBuffer();
        crc = makefcs(waitCheck.getBytes());
        for (int i = 0; i < crc.length; ++i)
            sb.append(i == 0 ? "" : ", ").append(crc[i]);
        if(sb.toString()==  (messageCrc)){
            symbol = true;
        }
        return symbol;
    }*/
    /*
    *//**
     * CRC校验 生成校验高位和校验低位
     * *//*
    public static byte[] makefcs(byte[] data)
    {
        int crc=0xFFFF;
        byte[] buf = new byte[data.length];// 存储需要产生校验码的数据
        byte[] bup=new byte[2];
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];  //数据的复制
        }
        int len = buf.length;
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                crc ^= (int) buf[pos] + 256; //^异或:用于位运算，每个位相同为0，不同为1
            } else {
                crc ^= (int) buf[pos];
            }
            for (int i = 8; i != 0; i--) {
                if ((crc & 0x0001) != 0) {
                    crc >>= 1;   //右移运算符
                    crc ^= 0xA001;
                } else
                    crc >>= 1;
            }
        }
        String c = Integer.toHexString(crc);
        if (c.length() == 4) {
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 3) {
            c = "0" + c;
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 2) {
            c = "0" + c.substring(1, 2) + "0" + c.substring(0, 1);
        }
        //校验高位
        bup[0]=(byte)(Integer.parseInt(c.substring(0, 1), 16)+Integer.parseInt(c.substring(1,2), 16));
        //校验低位
        bup[1]=(byte)(Integer.parseInt(c.substring(2, 3), 16)+Integer.parseInt(c.substring(3,4), 16));
        return bup;
    }*/

    /** 16进制中的字符集 */
    private static final String HEX_CHAR = "0123456789ABCDEF";

    /** 16进制中的字符集对应的字节数组 */
    private static final byte[] HEX_STRING_BYTE = HEX_CHAR.getBytes();
    /**
     * 10进制字节数组转换为16进制字节数组
     *
     * byte用二进制表示占用8位，16进制的每个字符需要用4位二进制位来表示，则可以把每个byte
     * 转换成两个相应的16进制字符，即把byte的高4位和低4位分别转换成相应的16进制字符，再取对应16进制字符的字节
     *
     * @param b 10进制字节数组
     * @return 16进制字节数组
     */
    public static byte[] byte2hex(byte[] b) {
        int length = b.length;
        byte[] b2 = new byte[length << 1];
        int pos;
        for(int i=0; i<length; i++) {
            pos = 2*i;
            b2[pos] = HEX_STRING_BYTE[(b[i] & 0xf0) >> 4];
            b2[pos+1] = HEX_STRING_BYTE[b[i] & 0x0f];
        }
        return b2;
    }

    /**
     * 字节数组转16进制
     * @param bytes 需要转换的byte数组
     * @return  转换后的Hex字符串
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if(hex.length() < 2){
                sb.append(0);
            }
            sb.append(hex);
        }
        return sb.toString();
    }
    //16进制转英文字母
    public static String fromHexStringToString(String str){
        char[] c = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < c.length-1; i+=2) {
            int num = (c[i]-'0')*16+(c[i+1]-'0')*1;
            builder.append((char) num);
        }
        return builder.toString();
    }

    public static boolean isJsonArray(String content){
        try {
            JSONArray.fromObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**********************************************姬民东********************************************/
    //将C#端 json格式数据进行处理
    public static JSONObject MessageToJsons(JSONArray jsons){
    	  Map results = new HashMap();
         //标志Map
         Map<String,Integer> flagMap = new HashMap<>();
         //最终的数据
         List<Map> lastMap =  new ArrayList<Map>();
          for(int i=0;i< jsons.size();i++){
              Map<String ,Object> map = new HashMap<String ,Object>();
              JsonVo jsonVo = new JsonVo();
              JSONObject jsonObject = (JSONObject) jsons.get(i);//取到c#端发来的json数组
              //遍历数据
              String EventType = jsonObject.get("EventType").toString();
              String Status	= jsonObject.get("Status").toString();
              String Spare = jsonObject.get("Spare").toString();
              String seatid = new String() ;
              //拼接查询seatid用到的key
              StringBuffer key = new StringBuffer();
              key.append(jsonObject.get("DeviceID")).append('|')
                      .append(jsonObject.get("Channel")).append('|')
                      .append(jsonObject.get("Address"));
              if(SeatDeviceController.contextMap.containsKey(key.toString())){//如果缓存中有对应key
                  //则赋值给seatid
                  seatid = SeatDeviceController.contextMap.get(key.toString()).toString();
              }else{//没有对应key则刷新缓存
                  SeatDeviceController seatDeviceController  = new SeatDeviceController();
                  //seatDeviceController.getSeatIdCache(false);
                  //刷新缓存还是没有，则存空。
                  if(SeatDeviceController.contextMap.containsKey(key.toString())){
                      seatid = SeatDeviceController.contextMap.get(key.toString()).toString();
                  }else{
                      seatid="";
                  }
              }
              if(flagMap.get(seatid)!=null) {//true有
	    		  Map bmap = new HashMap<>();
	    		  bmap.put(EventType, Status);
	    		  bmap.put(EventType+"Spare",Spare);
	    		  lastMap.get((int) flagMap.get(seatid)).putAll(bmap);
	    	  }else {
	    		  Map zmap = new HashMap<>();
	    		  zmap.put("SeatId", seatid);
	    		  zmap.put(EventType, Status);
	    		  zmap.put(EventType+"Spare",Spare);
	    		  lastMap.add(zmap);
	    		  flagMap.put(seatid, lastMap.size()-1);
	    	  }
          }
          results.put("results", lastMap);
          JSONObject object = JSONObject.fromObject(results);
          System.out.println(object);
          return object;
    }

}
