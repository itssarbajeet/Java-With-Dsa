import java .util.*;
public class Print_all_the_Binary_digit {
    public static void No_of_binary_string_without_Consuitive1(int last_place, String newStr, int n ){
        if(n==0){
            System.out.println(newStr);
            return;
        }
        
        if(last_place==0){
            No_of_binary_string_without_Consuitive1(0, newStr+"1", n-1);
            No_of_binary_string_without_Consuitive1(0, newStr+"0", n-1);
        }
        else{
            No_of_binary_string_without_Consuitive1(0, newStr+"0", n-1);
        }
    }
    public static void main(String args[]){
        String str=" ";
        No_of_binary_string_without_Consuitive1(0, str, 4);

    }
    
}

