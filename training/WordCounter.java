public class WordCounter {
    public static void main(String[] args) {
        String s = "Welcome to CVR";
        int wordCount = countWords(s);
        System.out.println("No. of words = " + wordCount);
    }
    public static int countWords(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int wordCount = 1; 
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == ' ' && s.charAt(i - 1) != ' ' && s.charAt(i + 1) != ' ') {
                wordCount++;
            }
        }
        return wordCount;
    }
}