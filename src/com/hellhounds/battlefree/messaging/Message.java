package com.hellhounds.battlefree.messaging;

/**
 * Superclass for message subclasses.
 */

public class Message {

    private MessageType type;

    public Message(MessageType type)
    {
        this.type = type;
    }

    public MessageType getType(){ return this.type; }
    public void setType(MessageType type){ this.type = type; }
}
