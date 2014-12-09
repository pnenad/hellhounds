package com.hellhounds.battlefree.messaging;

/**
 * Message sent from server to clients, notifying
 * about the start of a new game.
 */
public class INITMessage extends Message{



    public INITMessage()
    {
        super(MessageType.INIT);
    }
}
