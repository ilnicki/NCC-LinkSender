package net.minecraft.src;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;


public class ChatLine
{
    /** The chat message. */
    public String message;

    /** Counts the number of screen updates. */
    public int updateCounter;

    public ChatLine(String par1Str)
    {
        message = ParseLink(par1Str);
        updateCounter = 0;
    }
    
    public String ParseLink(String Str2parse)
    {
        if(Str2parse.startsWith("LINK: "))
        {
            openLink((String) Str2parse.subSequence("LINK: ".length(), Str2parse.length()));
            return "Opening page " + (String) Str2parse.subSequence("LINK: ".length(), Str2parse.length());
        }
        return Str2parse;
    }
    
    /*private void openLink(String link)
    {
        try
        {
           Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + link);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }    
    }*/
    private void openLink(String link) 
    {
        Desktop desktop;
        if (Desktop.isDesktopSupported()) 
        {
            desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.BROWSE)) 
            {
                URI uri;
                try 
                {
                    uri = new URI(link);
                    desktop.browse(uri);
                }
                catch (IOException ioe) 
                {
                    ioe.printStackTrace();
                }
                catch (URISyntaxException use)
                {
                    use.printStackTrace();
                }
            }
        }
    }

}
