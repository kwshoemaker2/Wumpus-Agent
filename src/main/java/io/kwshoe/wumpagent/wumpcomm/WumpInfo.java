package io.kwshoe.wumpagent.wumpcomm;


public class WumpInfo
{
    private final WumpInfoType type;
    private final int room;
    public WumpInfo(WumpInfoType type, int room)
    {
        this.type = type;
        this.room = room;
    }

    public WumpInfoType getType()
    {
        return type;
    }

    public int getRoom()
    {
        return room;
    }
}

