package com.training.demo0515.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class MyHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        System.out.println("==========handleTextMessage start ===============message:" + message);
        session.sendMessage(message);
        System.out.println("==========handleTextMessage end ==============");

    }

}