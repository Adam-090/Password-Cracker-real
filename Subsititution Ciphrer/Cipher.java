import java.util.ArrayList;
import java.util.Locale;

/**
 * Write a description of class Cipher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public  class Cipher
{
    private String[][] key = {{"A","B","C","D","E"},{"F","G","H","J","K"},{"L","M","N","O","P"},{"Q","R","S","T","U"},{"V","W","X","Y","Z"}};

    private String[][] key2 = {{"A","B","C","D","E"},{"F","G","H","I","K"},{"L","M","N","O","P"},{"Q","R","S","T","U"},{"V","W","X","Y","Z"}};

    private String Phrase = "";

    private Integer[][] transformedTemp;

    ArrayList<Integer> transformed = new ArrayList<Integer>();
    // instance variables - replace the example below with your own
    public Cipher(String phrase){
        Phrase = phrase;
        transformedTemp = new Integer[2][Phrase.length()];

    }

    public  ArrayList cipherWork(){

        for(int i =0; i < Phrase.length() ;i ++){
            for(int r =0; r< key.length;r++ ){
                for(int c =0; c < key[i].length; c ++){
                    if((Phrase.substring(i,i+1).toUpperCase()) .equals(key[r][c])){
                        transformed.add(r);
                        transformed.add(c);

                    }
                    else if((Phrase.substring(i,i+1).toUpperCase()) .equals(key2[r][c])){
                        transformed.add(r);
                        transformed.add(c);
                    }
                }
            }

        }
        return transformed;
    }

    public String encrypt(){
        ArrayList<Integer> num = transformed;
        String newWord = "";
        int count =0;
        for (int i =0 ; i <num.size();i++){
            if(i % 2 == 0){
                transformedTemp[0][count] = num.get(i);
            }else{
                transformedTemp[1][count] = num.get(i);
                count++;
            }

        }
        for (int r = 0; r < transformedTemp.length; r++){
            for(int i = 0; i<transformedTemp[0].length; i+=2 ){

                if(transformedTemp[0].length %2 == 0){
                    newWord += key[transformedTemp[r][i]][transformedTemp[r][i+1]];

                }
                if ((transformedTemp[0].length %2 == 1)&&(r==1)&&(i==0)){
                    i =1;
                }
                if(transformedTemp[0].length %2 == 1){
                    if(i==transformedTemp[0].length-1){
                        newWord+=key[transformedTemp[r][i]][transformedTemp[r+1][0]];

                    }
                    newWord += key[transformedTemp[r][i]][transformedTemp[r][i+1]];
                }


            }
        }
        Phrase = newWord;
        return newWord;
    }

    public String Decrypt(){
        ArrayList<Integer> transformed2 = new ArrayList<Integer>();  
        String Phrase2 = "";
        Integer[][] backwardsTransformed = new Integer[2][Phrase.length()];
        if( Phrase.length()%2 == 0 ){
            for(int i =0; i < Phrase.length() ;i ++){
                for(int r =0; r< key.length;r++ ){
                    for(int c =0; c < key[i].length; c ++){
                        if((Phrase.substring(i,i+1).toUpperCase()) .equals(key[r][c])){
                            transformed2.add(r);
                            transformed2.add(c);

                        }
                        else if((Phrase.substring(i,i+1).toUpperCase()) .equals(key2[r][c])){
                            transformed2.add(r);
                            transformed2.add(c);
                        }
                    }
                }

            }
            int count = 0;
            for ( int r = 0; r<2 ;r++){
                for(int c =0; c < backwardsTransformed[0].length;c++){
                    backwardsTransformed[r][c] = transformed2.get(count);
                    count++;
                }
            }
        }
        System.out.print(backwardsTransformed);

        return Phrase + " or" +  Phrase2;
    }

}
