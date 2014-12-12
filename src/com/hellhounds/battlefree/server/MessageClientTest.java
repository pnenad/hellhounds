/**
 * Copyright 2014 Endre Koekebakker, Espen Strømland,
 *                Nenad Petkovic, Steven Hicks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hellhounds.battlefree.server;

import com.hellhounds.battlefree.messaging.JsonUnit;
import com.hellhounds.battlefree.messaging.RequestMessage;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.*;
import java.net.*;

/**
 *
 */
public class MessageClientTest {


    public static void main(String[] args) throws Exception
    {
        String messageIn;

        Gson gson = new GsonBuilder().create();

        Socket socket = new Socket("localhost", 8888);
        DataOutputStream outbound = new DataOutputStream(socket.getOutputStream());
        BufferedReader incoming = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        JsonUnit[] units = {new JsonUnit(args[1], 100, false, null, null),
                            new JsonUnit(args[2], 100, false, null, null),
                            new JsonUnit(args[3], 100, false, null, null)};


        RequestMessage rm = new RequestMessage(args[0], units);

        String json = gson.toJson(rm);

        outbound.writeBytes(json + '\n');
        System.out.println("*****Message sent, waiting for reply*****");
        messageIn = incoming.readLine();
        System.out.println("*****Message received, printing out*****");
        System.out.println("Server reply: " + messageIn);
        socket.close();
    }
}
