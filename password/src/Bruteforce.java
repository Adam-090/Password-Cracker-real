import java.util.ArrayList;

public class Bruteforce {
    int Length;
    String Word;
    ArrayList<String> CharList;
    public Bruteforce(String Char, int length){
         CharList = new ArrayList<String>();
        Length = length;
        Word = Char;
        append(Word);
        System.out.print(CharList);

    }
    public void append(String word){
        for(int i =0; i < Word.length();i++){
            CharList.add(Word.substring(i,i+1));
        }
    }





}
