package com.hellhounds.battlefree.messaging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 */
public class MessageHandler {

    public MessageHandler() {

    }

    public static void handleMessage(String json)
    {
        Gson gson = new GsonBuilder().create();
        Message head = gson.fromJson(json, Message.class);
        MessageType type;

        if(head != null) {
            type = head.getType();

            switch (type) {
                case TARGETS:
                    break;
                case REQUEST:
                    RequestMessage request = (RequestMessage) gson.fromJson(json, RequestMessage.class);
                    handleRequest(request);
                    break;
                case ROUND:
                    break;
                default:

            }
        }
    }

    public static void handleRequest(RequestMessage message)
    {

    }
}
