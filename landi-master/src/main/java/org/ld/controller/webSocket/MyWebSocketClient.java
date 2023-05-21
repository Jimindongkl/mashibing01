package org.ld.controller.webSocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;
import org.ld.service.congressControlService.ICongressControlService;
import org.ld.utils.WebSocketUtil;
import org.ld.websocket.WebSocketParamaters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.net.URISyntaxException;

@Component
public class MyWebSocketClient  {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyWebSocketClient.class);
    private static MyWebSocketClient myWebSocketClient;
    @Autowired
    private ICongressControlService congressControlService;
    public static WebSocketClient client =null;
//    private String url ="ws://192.168.8.176:81/webSocket/YINGconnect/1";//websocket连接地址
    private static String url =WebSocketUtil.readContext("ccuurl", "ccuconfig.properties");//websocket连接地址
    private static HttpSession session;
    private boolean isConnect;
    private boolean isMessage;

    @PostConstruct
    void init(){
        myWebSocketClient = this;
        myWebSocketClient.congressControlService = this.congressControlService;
    }

    public HttpSession ClientConnect(final HttpServletRequest request){
        final HttpServletRequest reRequest = request;
        if(null==session||null == session.getAttribute("webSocketClient")){
            //判断公用session中是否包含 webSocketClient, 没有则说明是第一次访问
            session = request.getSession();
        }
            if(null == client ||client.getReadyState().equals(ReadyState.CLOSED)||client.getReadyState().equals(ReadyState.CLOSING)){
                try {
                client = new WebSocketClient(new URI(url),new Draft_6455()) {
                    @Override
                    public void onOpen(ServerHandshake serverHandshake) {
                        LOGGER.info("连接成功.....");
                        client.send("成功与CCU建立连接");
                    }
                    @Override
                    public synchronized void onMessage(String s) {
                        getMessage(s);
                    }

                    @Override
                    public void onClose(int i, String s, boolean b) {
                        LOGGER.info("ccu连接已经关闭......"+client.getReadyState().getDeclaringClass().getName()+"/n"+client.getURI()+" 状态: "+client.getReadyState());
                        WebSocketParamaters.broadcast(WebSocketParamaters.qianduan, "发生错误，ccu连接关闭....");
                        while (!client.getReadyState().equals(ReadyState.OPEN)){
                            client .reconnect();
                        }
                    }
                    @Override
                    public void onError(Exception e) {
                        LOGGER.error("发生错误，ccu连接非法关闭....");
                        LOGGER.info("连接已经关闭......"+client.getReadyState().getDeclaringClass().getName()+"/n"+client.getURI()+"状态 :"+client.getReadyState());
                        WebSocketParamaters.broadcast(WebSocketParamaters.qianduan, "发生错误，ccu连接非法关闭....");
                        try {
                            while (!client.getReadyState().equals(ReadyState.OPEN)){
                                    Thread.sleep(500);
                            if(client.getReadyState()== ReadyState.NOT_YET_CONNECTED) {
                                if(client.isClosed()) {

                                    client.reconnectBlocking();

                                }else{
                                    client.connectBlocking();
                                }
                            }else if( client.getReadyState() == ReadyState.CLOSED){
                                client.reconnectBlocking();
                            }
                                LOGGER.info("正在重新连接.......");
                            }
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                };
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        if(client.getReadyState().equals(ReadyState.NOT_YET_CONNECTED)){
            //webSocketClient未连接时再创建连接
            if(!client.isOpen()){
                client.connect();//建立连接
            }
            while (!client.getReadyState().equals(ReadyState.OPEN)){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                LOGGER.info("正在连接.......");
            }
            //存储到公用session中
            session.setAttribute("webSocketClient",client );
        }
        if(session.getAttribute("webSocketClient") == null){
            session.setAttribute("webSocketClient",client );
        }
        return session;
    }
    /** 收到CCU message */
    private static void getMessage(String s){
        if(null!=s||s.trim().equals("")){
            LOGGER.info("收到的消息: "+client.getURI()+":  "+ s);
            try { //将接收到的C#端反馈msg，转发至前端websocket
                SendWebSocketMessageToCCU.MessageToWebDesign(s);
            } catch (Exception e) {
                LOGGER.info("转发失败的消息: "+client.getURI()+":  "+ s);
                e.printStackTrace();
            }
        }
    }

    public void closeWebSocket() {
        try {
//            client.close();
//            request.getSession().invalidate();
//            session.removeAttribute("webSocketClient");
//            SendWebSocketMessageToCCU.sendOrNot = true;
            LOGGER.info("正在主动关闭连接.......");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /** 监听到前端webSocket连接关闭 目前不做与C端相关操作，为后期业务拓展做预留*/
    public static void  closeSocket(){
        try {
//            client.close();
//            session.removeAttribute("webSocketClient");
            //关闭连接 是否需要 重新发送初始化消息
//            SendWebSocketMessageToCCU.sendOrNot = true;
            LOGGER.info("监听前端webSocket连接已经关闭.......");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

