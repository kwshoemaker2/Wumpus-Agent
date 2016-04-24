package io.kwshoe.wumpagent.wumpcomm;

import java.util.ArrayList;

public class WumpTranslator
{   
    private ArrayList<WumpEvent> events;
    private ArrayList<WumpInfo> info;

    public void translate(String data)
    {
        translate(data.split("\n"));
    }

    public void translate(String[] lines)
    {
        events = new ArrayList<WumpEvent>(lines.length);
        info = new ArrayList<WumpInfo>(lines.length);
    }

    public ArrayList<WumpEvent> getEvents()
    {
        return new ArrayList<WumpEvent>(events);
    }

    public ArrayList<WumpInfo> getInfo()
    {
        return new ArrayList<WumpInfo>(info);
    }
}
