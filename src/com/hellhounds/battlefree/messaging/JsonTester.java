package com.hellhounds.battlefree.messaging;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 */
public class JsonTester {

    public static void main(String[] args)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonUnit unit1 = new JsonUnit("Archer", 100, false, null, null);
        JsonUnit unit2 = new JsonUnit("Defender", 100, false,  null, null);
        JsonUnit unit3 = new JsonUnit("Barbarian", 100, false,  null, null);

        JsonUnit[] units = {unit1, unit2, unit3};

        RequestMessage rm = new RequestMessage("Mannebind", units);
        String json = new Serializer().getJsonMessage(rm);

        Message head = gson.fromJson(json, Message.class);
        MessageType type = head.getType();

        Message body = null;

        switch (type)
        {
            case TARGETS:
                body = (TargetsMessage) gson.fromJson(json, TargetsMessage.class);
                break;
            case REQUEST:
                body = (RequestMessage) gson.fromJson(json, RequestMessage.class);
                break;
            default:
                body = gson.fromJson(json, Message.class);
        }

        System.out.print(gson.toJson(body));
    }
}
