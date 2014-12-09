package com.hellhounds.battlefree.messaging;


/**
 * Objects of this class is created to hold each unit's
 * targeting info. Packed down to be sent in a TARGETSMessage
 * by a client to the server.
 */
public class UnitAction {

    private String source;
    private String[] pTargets;
    private String[] sTargets;

    public UnitAction(String source, String[] pTargets, String[] sTargets)
    {
        this.source = source;
        this.pTargets = pTargets;
        this.sTargets = sTargets;
    }
}
