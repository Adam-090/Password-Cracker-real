 import java.util.*;
public class Runner
{
   
    public static void main(String args[])
    {
        /*Code c = new Code("HELP");
        System.out.println(c.toString());
        System.out.println(c.Encrypt());
        System.out.println(c.Decrypt());
        */
       
        Scanner info = new Scanner(System.in);
        System.out.println("Enter Phrase");
        String word = info.next();
        System.out.println("Enter E for encrypt or Enter D for decrypt");
        String function = info.next();
        Code c1 = new Code(word);
        if (function =="E"){
            System.out.println(c1.toString());
            System.out.println(c1.Encrypt());
        }else{
            System.out.println(c1.toString());
            System.out.println(c1.Decrypt());
        }
        
        
        
        
        
        
        
    }
}
