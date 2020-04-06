package quodvide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("235"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) { return new ArrayList<>(); }
        if (digits.length() == 1) {
            return Letter.findByIntExpression(digits.charAt(0)).characters;
        }
        List<String> result = Letter.findByIntExpression(digits.charAt(0)).characters;
        char[] arr = digits.toCharArray();
        for (int i = 1; i < digits.length(); i++) {
            result = addPosibilities(result, Letter.findByIntExpression(arr[i]).characters);
        }

        return result;
    }

    private static List<String> addPosibilities(List<String> result, List<String> characters) {
        return result.stream().flatMap((element) -> characters.stream().map((target) -> element.concat(target))).collect(Collectors.toList());
    }
}

enum Letter {
    TWO('2', Arrays.asList("a", "b", "c")),
    THREE('3', Arrays.asList("d", "e", "f")),
    FOUR('4', Arrays.asList("g", "h", "i")),
    FIVE('5', Arrays.asList("j", "k", "l")),
    SIX('6', Arrays.asList("m", "n", "o")),
    SEVEN('7', Arrays.asList("p", "q", "r", "s")),
    EIGHT('8', Arrays.asList("t", "u", "v")),
    NINE('9', Arrays.asList("w", "x", "y", "z"));

    char intExpression;
    List<String> characters;

    Letter(char intExpression, List<String> characters) {
        this.intExpression = intExpression;
        this.characters = characters;
    }

    public static Letter findByIntExpression(char c) {
        return Arrays.stream(Letter.values()).filter((let) -> let.intExpression == c).findFirst().get();
    }
}