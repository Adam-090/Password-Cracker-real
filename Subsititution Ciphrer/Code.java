

public class Code
{
    public String[][] cipher = {{"A", "B", "C", "D", "E"}, {"F", "G", "H", "IJ",
                "K"}, {"L", "M", "N", "O", "P"}, {"Q", "R", "S", "T", "U"}, {"V", "W", "X", "Y",
                "Z"}};
    private int[][] arr;
    private String str;
    private String enc = "";
    private String dec = "";
    private String nums = "";
    public Code(String s)
    {
        str = s;
        arr = new int[2][s.length()];
    }

    public String Encrypt()
    {
        // Converts the word into the 2D Array
        for(int s = 0; s < str.length(); s++)
        {
            for(int row = 0; row < cipher.length; row++)
            {
                for(int col = 0; col < cipher[0].length; col++)
                {
                    if(cipher[row][col].indexOf(str.substring(s, s + 1)) != -1)
                    {
                        arr[0][s] = row + 1;
                        arr[1][s] = col + 1;
                    }
                }
            }
        }
        // Puts the numbers into a straight line
        for(int row = 0; row < arr.length; row++)
        {
            for(int col = 0; col < arr[row].length; col += 2)
            {
                if(((col + 1) > arr[row].length - 1) && (row == 0))
                {
                    nums += "" + arr[row][col] + arr[row + 1][0];
                }
                else
                {
                    if(row == 1 && col == 0 && (arr[row].length % 2 != 0))
                    {
                        col++;
                    }
                    nums += "" + arr[row][col] + arr[row][col + 1];
                }
            }
        }
        // Converts the numbers into letters
        for(int n = 0; n < nums.length(); n++)
        {
            String first = nums.substring(n, n + 1);
            String second = nums.substring(n + 1, n + 2);
            int num1 = Integer.parseInt(first);
            int num2 = Integer.parseInt(second);
            enc += "" + cipher[num1 - 1][num2 - 1].substring(0, 1);
            nums = nums.substring(n + 2);
            n--;
        }
        return enc;
    }

    public String Decrypt()
    {
        for(int e = 0; e < enc.length(); e++)
        {
            for(int row = 0; row < cipher.length; row++)
            {
                for(int col = 0; col < cipher[0].length; col++)
                {
                    if(cipher[row][col].indexOf(enc.substring(e, e + 1)) != -1)
                    {
                        nums += "" + (row + 1) + (col + 1);
                    }
                }
            }
        }
        for(int row = 0; row < arr.length; row++)
        {
            for(int col = 0; col < arr[row].length; col++)
            {
                arr[row][col] = Integer.parseInt(nums.substring(col, col + 1));
            }
            nums = nums.substring(arr[row].length);
        }
        for(int i = 0; i < arr[0].length; i++)
        {
            dec += cipher[arr[0][i] - 1][arr[1][i] - 1].substring(0, 1);
        }
        return dec;
    }

    public String toString()
    {
        String array = "";
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                array += (arr[i][j] + " ");
            }
            array += "\n";
        }
        return array;
    }
}
