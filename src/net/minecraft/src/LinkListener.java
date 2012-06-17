package net.minecraft.src;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

public class LinkListener
{
    public static String ParseLink(String Str2parse)
    {
        if(Str2parse.startsWith("LINK: "))
        {
            openLink((String) Str2parse.subSequence("LINK: ".length(), Str2parse.length()));
            return "Opening page " + (String) Str2parse.subSequence("LINK: ".length(), Str2parse.length());
        }
        return Str2parse;
    }
    
    private static void openLink(String link) 
    { 
        try
        {
            URI uri = new URI(link);
            Class class1 = Class.forName("java.awt.Desktop");
            Object obj = class1.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
            class1.getMethod("browse", new Class[]
                    {
                        java.net.URI.class
                    }).invoke(obj, new Object[]
                            {
                                uri
                            });
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }
}