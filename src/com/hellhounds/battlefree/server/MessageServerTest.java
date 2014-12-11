package com.hellhounds.battlefree.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hellhounds.battlefree.game.Game;
import com.hellhounds.battlefree.game.Player;
import com.hellhounds.battlefree.messaging.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 */
public class MessageServerTest {

    public static void main(String argv[]) throws Exception{
        System.out.println("Starting server...");
        String message;
        ServerSocket socket = new ServerSocket(8888);

        HashMap<Long, Game> games = new HashMap<>();

        Player opponent = null;
        Gson gson = new GsonBuilder().create();

        while(true){
            System.out.println("Server running...");
            Socket conn = socket.accept();
            BufferedReader incoming = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            DataOutputStream outbound = new DataOutputStream(conn.getOutputStream());
            message = incoming.readLine();
            System.out.println("Received: " + message);
            //System.out.println("Sending reply: " + message);
            //outbound.writeBytes("Reply for message " + message + '\n');

            Message head = gson.fromJson(message, Message.class);
            MessageType type = head.getType();
            MessageHandler messageHandler = new MessageHandler();

            Message body = null;

            switch (type)
            {
                case TARGETS:
                    body = (TargetsMessage) gson.fromJson(message, TargetsMessage.class);
                    break;
                case REQUEST:
                    opponent = messageHandler.handleRequest((RequestMessage) gson.fromJson(message, RequestMessage.class), opponent, games);
                    break;
                default:
                    body = gson.fromJson(message, Message.class);
            }

            conn.close();
            //conn.close();
            //conn.bind(conn.getRemoteSocketAddress());
        }

    }
}
