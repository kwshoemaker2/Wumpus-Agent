package io.kwshoe.wumpagent.wumpcomm;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public enum WumpInfoType
{
    InRoom("You are in room ([0-9]+) of the cave, and have [0-9]+ arrows left."),
    Stench("*sniff* (I can smell the evil Wumpus nearby!)"),
    Rustle("*rustle* *rustle* (must be bats nearby)"),
    Breeze("*whoosh* (I feel a draft from some pits)."),
    Adjacent("There are tunnels to rooms ([0-9]+), ([0-9]+), and ([0-9]+).");

    private final String patternString;
    private final Pattern messagePattern;
    WumpInfoType(String message)
    {
        patternString = message;
        messagePattern = Pattern.compile(message);
    }

    public boolean matchesInfo(String message)
    {
        return messagePattern.matcher(message).matches();
    }

    public Pattern getMatchPattern()
    {
        return Pattern.compile(patternString);
    }
}
