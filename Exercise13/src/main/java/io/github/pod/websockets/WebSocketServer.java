/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.pod.websockets;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
@ServerEndpoint(value = "/websocketserver")
public class WebSocketServer {

    private static final Set<Session> USER_WEB_SOCKETS = new CopyOnWriteArraySet<>();

    @OnError
    public void onError(Throwable throwable) {
    }

    @OnOpen
    public void onConnect(Session session) {

        USER_WEB_SOCKETS.add(session);
    }

    @OnClose
    public void onDisconnect(Session session) {

        USER_WEB_SOCKETS.remove(session);
    }

    private void sendMessage(String message) {

        Iterator<Session> usersWebSocketIterator = USER_WEB_SOCKETS.iterator();

        Session userWebSocket;

        while (usersWebSocketIterator.hasNext()) {

            userWebSocket = usersWebSocketIterator.next();

            try {
                userWebSocket.getBasicRemote().sendText(message);
            } catch (IOException ex) {

                usersWebSocketIterator.remove();
                try {
                    userWebSocket.close();
                } catch (IOException ex2) {
                }

            } catch (Exception ex3) {
            }

        }

    }

    @OnMessage
    public void echoTextMessage(Session session, String msg, boolean last) {

        sendMessage(msg);
    }

}
