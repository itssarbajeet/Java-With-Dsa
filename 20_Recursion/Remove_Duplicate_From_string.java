import java.util.*;
public class Remove_Duplicate_From_string {
    public static void Remove_Duplicate_From_string1(int i, StringBuilder newStr, String str, boolean[] map){
        if(i == str.length()){
            System.out.println(newStr);
            return;

        }
        char character = str.charAt(i);
        if(map[character - 'a']== true){
            Remove_Duplicate_From_string1(i + 1, newStr, str, map);
        }
        else {
            map[character - 'a'] = true;
            Remove_Duplicate_From_string1(i + 1, newStr.append(character), str, map);
        }
    }

    public static void main(String[] args) {
        String str = "sarbajeetmohanty";
        boolean[] map = new boolean[26];
        Remove_Duplicate_From_string1(0, new StringBuilder(""), str, map);
    }
}

