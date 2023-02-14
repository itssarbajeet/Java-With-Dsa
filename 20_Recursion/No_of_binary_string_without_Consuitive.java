import java .util.*;
public class No_of_binary_string_without_Consuitive {
    public static void No_of_binary_string_without_Consuitive1(int last_place, String newStr, int n ){
        if(n==0){
            System.out.println(newStr);
            return;
        }
        No_of_binary_string_without_Consuitive1(0, newStr+"0", n-1);
        if(last_place==0){
            No_of_binary_string_without_Consuitive1(1, newStr+"1", n-1);
        }
    }
    public static void main(String args[]){
        String str=" ";
        No_of_binary_string_without_Consuitive1(0, str, 3);

    }
}

