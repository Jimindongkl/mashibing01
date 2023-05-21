package org.ld.websocket;

import org.ld.controller.webSocket.MyWebSocketClient;
import org.ld.response.ResponseEnum;
import org.ld.response.ResponseServer;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *可传指定参数
 * paramType 参数类型
 * content 有文本消息的，发送文本消息
 * */
@ServerEndpoint("/webSocket/{paramType}/{username}")
public class WebSocketParamaters {
    // 使用map来收集session，paramType，value为同一个连接的用户集合
    // concurrentMap的key不存在时报错，不是返回null
    private static final Map<String, Set<Session>> connections = new ConcurrentHashMap();
    private static final Map<String, String> usernameList = new ConcurrentHashMap();
    //前端标识，与前端建立连接和通讯使用
    public static final String qianduan = "firstconnect";
    public static final String Cduan = "CCUconnect";
    private static Session WebSocketClientSession;
    /**
     * 建立连接时触发
     * 根据第一个参数 paramType做判断，判断报文类型，第二个参数 可以传用户名
     * 参数目前设计 两个足够
     * */
    @OnOpen
    public void connect(@PathParam("paramType") String paramType, @PathParam("username") String username, Session session) throws Exception {
        // 将session按照参数类型来存储，将各个类型的会话隔离
        if(username.equals("1")&& paramType.equals("firstconnect")){

            WebSocketClientSession = session;
        }
        if (!connections.containsKey(paramType)) {
            // 当前类型不存在时，新增一个
            Set<Session> connection = new HashSet<Session>();
            // 添加
            connection.add(session);

            connections.put(paramType, connection);
        } else {
            // 参数类型已存在，直接添加连接到相应的参数类型中
            connections.get(paramType).add(session);
        }
        if(paramType.equals(qianduan)){//如果是前端建立连接的消息，反馈一个回执
            session.getBasicRemote().sendText("与前端建立连接！！");
        }else if (paramType.equals(Cduan)){
            session.getBasicRemote().sendText("与c#端建立连接！！");
        }
        System.out.println("a client has connected!"+"  by "+ paramType + "  name:" +username);
    }
    /**
     * 关闭连接时触发
     * */
    @OnClose
    public void disConnect(@PathParam("paramType") String paramType,@PathParam("username") String username, Session session) {
        //关闭指定session
        connections.get(paramType).remove(session);
        MyWebSocketClient.closeSocket();
        System.out.println("a client has disconnected!"+paramType+ "  name:" +username);
    }
    /**
     * 当webSocket服务端收到消息时触发
     * */
    @OnMessage
    public synchronized void receiveMsg(@PathParam("paramType") String paramType,@PathParam("username") String username,
                           String msg) {
        System.out.println("webSocket服务器收到消息====>"+username + ":"+msg);
        try {
            broadcast(paramType, msg);
        }catch (Exception e){
            broadcast(paramType, "解析出现了问题" + ":"+msg);
            e.printStackTrace();
        }
    }

    // 进行广播(将消息发送至所有已保存的连接）
    public static void broadcast(String paramType, String msg) {
            if(connections.get(qianduan).size()==1){
                Session session = connections.get(qianduan).iterator().next();
                session.getAsyncRemote().sendText(msg);
            }else{
                for (Session session : connections.get(paramType)) {
                    String username = session.getPathParameters().get("username");
//            session.getBasicRemote().sendText(msg);//同步发送
                    session.getAsyncRemote().sendText(msg);//非同步，按时间需求使用
                    System.out.println("广播消息至" +paramType +"/"+username + "  message:" + msg);
                }
            }
/*        for (Session session : connections.get(paramType)) {
//            session.getBasicRemote().sendText(msg);//同步发送
            session.getAsyncRemote().sendText(msg);//非同步，按时间需求使用
            System.out.println("广播消息至" +paramType + "message:" + msg);
        }*/
    }
    /** 单个连接 不需要轮询*/
    public static void sendMessageToWebDesign(String msg){
        if(null == WebSocketClientSession){
            if(connections.containsKey(qianduan)){
                WebSocketClientSession = connections.get(qianduan).iterator().next();
            }else{
                //没有保存的session，就炸了
                System.out.println("send message have some error://"+"目前没用前端WebSocket连接");
                ResponseServer.error(ResponseEnum.valueOf("\"send message have some error://\"+\"目前没用前端WebSocket连接\""));
            }
        }
        synchronized (WebSocketClientSession){
            try {
                WebSocketClientSession.getBasicRemote().sendText(msg);
                System.out.println("转发" + ":message:" + msg);
            } catch (IOException e) {
                System.out.println("send message have some error://"+e.getMessage()+"//");
                e.printStackTrace();
            }
        }


    }

    //接收c#端消息后，将消息广播至前端   --暂时关闭该方法
    /*public static void radioToFontend(String paramType, String msg)throws Exception{
        if(connections.containsKey(qianduan)){
            if(connections.size()==1){
                Session session = connections.get(qianduan).iterator().next();
                synchronized (session){
                    session.getBasicRemote().sendText(msg);//同步发送
//                    session.getAsyncRemote().sendText(msg);
                    System.out.println("广播消息至" +paramType + ":message:" + msg);
                }
            }else{
                for (Session session : connections.get(qianduan)) {
//                session.getBasicRemote().sendText(msg);//同步发送
                    session.getAsyncRemote().sendText(msg);//非同步，按时间需求使用
                    System.out.println("广播消息至" +paramType + ":message:" + msg);
                }
            }
        }else{
            Session session =  connections.get(paramType).iterator().next();
            session.getBasicRemote().sendText("消息："+"//"+msg+"//"+"\n未发送至前端客户端，请检查前端webSocket连接");
        }
    }*/

}
