import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitFinder {

    Optional<String> findFirstDigit(String s) {
        String tempString = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                return Optional.of(String.valueOf(c));
            } else {
                tempString += String.valueOf(c);
                if (checkForDigitsInText(tempString)) {
                    return Optional.ofNullable(convertDigits(tempString));
                }
            }
        }
        return Optional.empty();
    }

    Optional<String> findLastDigit(String s) {
        String tempString = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                return  Optional.of(String.valueOf(c));
            } else {
                tempString = c + tempString;
                if (checkForDigitsInText(tempString)) {
                    return  Optional.ofNullable(convertDigits(tempString));
                }
            }
        }
        return Optional.empty();
    }

    private boolean checkForDigitsInText(String s) {
        List<String> keywords = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        for (String keyword : keywords) {
            Pattern word = Pattern.compile(keyword);
            Matcher match = word.matcher(s);
            if (match.find()) {
                return true;
            }
        }
        return false;
    }

    private String convertDigits(String tempString) {
        List<String> keywords = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        List<String> returnStrings = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

        for (int i = 0; i < keywords.size(); i++) {
            if (tempString.contains(keywords.get(i))) {
                return returnStrings.get(i);
            }
        }
        return null;
    }
}