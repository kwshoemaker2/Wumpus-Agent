package io.kwshoe.wumpagent.wumpcomm;

public enum WumpEvent
{
    SURVIVED_PIT("Without conscious thought you grab for the side of the cave and manage"),
    MOVED_BY_BATS("*flap*  *flap*  *flap*  (humongous bats pick you up and move you!)"),
    WENT_THROUGH_TUNNEL("With a jaunty step you enter the magic tunnel.  As you do, you"),
    WUMPUS_MOVED("Your colorful comments awaken the wumpus!"),
    FELL_IN_PIT("*AAAUUUUGGGGGHHHHHhhhhhhhhhh...*"),
    OUT_OF_ARROWS("You turn and look at your quiver, and realize with a sinking feeling"),
    SHOT_SELF("*Thwack!*  A sudden piercing feeling informs you that the ricochet"),
    EATEN_BY_WUMPUS("*ROAR* *chomp* *snurfle* *chomp*!"),
    WUMPUS_KILLED("*thwock!* *groan* *crash*");

    private final String message;
    WumpEvent(String msg)
    {
        message = msg;
    }

    public boolean matchesEvent(String msg)
    {
        boolean same = false;
        if(message.equals(msg)) {
            same = true;
        }
        return same;
    }
}
