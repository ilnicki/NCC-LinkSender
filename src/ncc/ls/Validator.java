package ncc.ls;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator 
{
   public static boolean validURL(String URL)
   {
       Pattern pattern = Pattern.compile("(https?:\\/\\/([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]{2,}((\\/[a-zA-Z0-9%-]*)*|\\?(([a-zA-Z0-9%-]* = [a-zA-Z0-9%-]&?)*)*))");
       Matcher matcher = pattern.matcher(URL);

       return matcher.matches();
   }
}
