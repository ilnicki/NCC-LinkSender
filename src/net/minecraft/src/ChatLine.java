package net.minecraft.src;

public class ChatLine
{
    /** The chat message. */
    public String message;

    /** Counts the number of screen updates. */
    public int updateCounter;

    public ChatLine(String par1Str)
    {
        this.message = LinkListener.ParseLink(par1Str);
        this.updateCounter = 0;
    }
}
