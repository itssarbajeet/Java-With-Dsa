import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLParser {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\sarba_lcvi2cc\\Java-With-Dsa\\mcq\\file.html";
        List<String> questions = extractQuestions(filePath);
        List<String> correctAnswers = extractCorrectAnswers(filePath);

        System.out.println("Questions:");
        for (String question : questions) {
            System.out.println(question);
        }

        System.out.println("\nCorrect Answers:");
        for (String answer : correctAnswers) {
            System.out.println(answer);
        }
    }

    public static List<String> extractQuestions(String filePath) {
        List<String> questions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder questionBuilder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.contains("<p>")) {
                    questionBuilder.append(line);
                } else if (line.contains("</p>")) {
                    questionBuilder.append(line);
                    questions.add(questionBuilder.toString());
                    questionBuilder.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questions;
    }

    public static List<String> extractCorrectAnswers(String filePath) {
        List<String> correctAnswers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("<span class=\"correct\">(.*?)</span>");

            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    correctAnswers.add(matcher.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return correctAnswers;
    }
}
