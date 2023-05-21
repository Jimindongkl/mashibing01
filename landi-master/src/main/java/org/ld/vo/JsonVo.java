package org.ld.vo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.ld.websocket.MessageProcess;

import java.util.HashMap;
import java.util.Map;

//处理报文用到
public class JsonVo {
    public static void main(String[] args) {
        String  string = new String("{\"datas\":[{\"EventType\":\"RegisterEvent\",\"DeviceID\":1,\"Channel\":222,\"Address\":222,\"Status\":true,\"Spare\":0},{\"EventType\":\"RegisterEvent\",\"DeviceID\":1,\"Channel\":222,\"Address\":222,\"Status\":true,\"Spare\":0},{\"EventType\":\"RegisterEvent\",\"DeviceID\":1,\"Channel\":222,\"Address\":222,\"Status\":true,\"Spare\":0},{\"EventType\":\"RegisterEvent\",\"DeviceID\":1,\"Channel\":222,\"Address\":222,\"Status\":true,\"Spare\":0}]}");
        JSONObject jsonObject = JSONObject.fromObject(string);
        JSONArray jsonArray  = (JSONArray)jsonObject.get("datas");
        Map map = new HashMap();
        map = MessageProcess.MessageToJson(jsonArray);
//        for(int i =0;i<jsonArray.size();i++){
//            String a = jsonArray.get(i).toString();
//        }
        System.out.println(map);
    }
    //报文类型
    private String eventType;
    //状态
    private String  status;
    //表决时用来记录 会议序号 其他类型接口传null
    private String spare;
//    //坐席id
//    private Integer seatId;
//    //人员id （预留）
//    private Integer personId;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }
}
