
package javaprovincesandgold;

import java.util.InputMismatchException;
import java.util.Scanner;


public class JavaProvincesAndGold {

    // https://open.kattis.com/problems/provincesandgold 
    // simple comparison program
    // accepted in kattis
    
    
    
    public static void main(String[] args) {
        
        Scanner in=new Scanner(System.in);
        
        int[] line =Line2IntArray(in);
        String result=Buy(line);
        System.out.println(result);
        
    }
    private static String Buy(int[] costArray)
    {
        int cost =costArray[2]+2*costArray[1]+3*costArray[0];
        
        String first=BuyVictoryCard(cost);
        String second=BuyTreasureCard(cost);
        
        if(first!=null && second!=null)
            return first+" or "+second;
        else if(first==null && second!=null)
            return second;
        return null;
    }
            
    private static String BuyTreasureCard(int cost)
    {
        if(cost>=6)
            return "Gold";
        else if(cost>=3)
            return "Silver";
        else if(cost>=0)
            return "Copper";
        return null;
    }
    
    private static String BuyVictoryCard(int cost)
    {
        if(cost>=8)
            return "Province";
        else if(cost>=5)
            return "Duchy";
        else if(cost>=2)
            return "Estate";
        return null;
    }
    
    private static int[] Line2IntArray(Scanner input)
    {
        try{
            String str =GetLine(input);
            String[] array =String2StringArray(str);
            int[] numbers=StringArray2IntArray(array);
            if(!CheckIntArray(numbers))
                throw new InputMismatchException();
            return numbers;
        }catch(Exception e)
        {
            return Line2IntArray(input);
        }
    }
    
    private static String GetLine(Scanner input)
    {
        return input.nextLine();
    }
    
    private static String[] String2StringArray(String str)
    {
        String[] arr=new String[3];
        arr=str.split(" ", 3);
        return arr;
    }
    
    private static int[] StringArray2IntArray(String[] array)
    {
        int[] numbers=new int[array.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]=Integer.parseInt(array[i]);
        }
        return numbers;
    }
    
    private static boolean CheckIntArray(int[] array)
    {
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]<0)
                return false;
            sum=sum+array[i];
            if(sum>5)
                return false;
        }
        return true;
    }
}
