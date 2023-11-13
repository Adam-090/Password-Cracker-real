
/**
 * Write a description of class CipherRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CipherRunner
{
    public static void main( String args[] ){
        Cipher test = new Cipher("Hell");
        System.out.println(test.cipherWork());
        System.out.println(test.encrypt());
        System.out.println(test.Decrypt());
    }
}
