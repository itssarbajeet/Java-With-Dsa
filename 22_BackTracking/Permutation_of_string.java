import java.util.*;
class Permutation_of_string {
static int c;
public static void Permutation_of_String(String str,String ans)
{
    if(str.length()==0){
        c++;
        System.out.println(ans);
        return;
    }
    for (int i=0;i<str.length();i++){
        char curr= str.charAt(i);
        String temp=str.substring(0, i)+str.substring(i+1);
        Permutation_of_String(temp,ans+curr);
    }
return ;
}
public static void main(String[] args) {
String str="abd";
Permutation_of_String(str,"");
System.out.println(c);
}
}