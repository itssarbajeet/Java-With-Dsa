import java.util.*;

public class valid_Anagram {
  public static void main(String[] args) {
    String s = "anagram";
    String t = "nagaam";

    boolean isAnagram = checkAnagram(s, t);

    if (isAnagram) {
      System.out.println(s + " and " + t + " are valid anagrams.");
    } else {
      System.out.println(s + " and " + t + " are not valid anagrams.");
    }
  }

  public static boolean checkAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> freqMap = new HashMap<>();

    // Count the frequency of each character in s
    for (char ch : s.toCharArray()) {
      freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
    }

    // Decrement the frequency of each character in t
    for (char ch : t.toCharArray()) {
      int freq = freqMap.getOrDefault(ch, 0);
      if (freq == 0) {
        return false; // t contains a character not in s
      }
      freqMap.put(ch, freq - 1);
    }

    return true; // s and t have the same characters with the same frequencies
  }
}
