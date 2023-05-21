package org.ld.websocket;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
/**
 * webSocket监听
 * */
public class WebSocketClient implements ServerApplicationConfig  {
    /**
     * 注解方式
     * 扫描src下所有类@ServerEndPoint注解的类。
     */
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> arg0) {
        System.out.println("config=============" + arg0.size());
        return arg0;
    }

    /**
     * 获取所有以接口方式配置的webSocket类。
     */
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
        return null;
    }
}
