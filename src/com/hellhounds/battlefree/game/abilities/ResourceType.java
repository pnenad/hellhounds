package com.hellhounds.battlefree.game.abilities;


public enum ResourceType {
    GOLD, STEEL, CRYSTAL;

    public static ResourceType[] getResources()
    {
        ResourceType[] list = {GOLD, STEEL, CRYSTAL};
        return list;
    }
}
