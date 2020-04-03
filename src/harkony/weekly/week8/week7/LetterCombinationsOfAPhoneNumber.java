package harkony.weekly.week8.week7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static final List<String> NOTHING = Collections.singletonList("");
    public static String[][] mat = {
            {},
            {},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return Collections.emptyList();

        List<String> ans = new ArrayList<>();
        String[] startWith = mat[digits.charAt(0) - '0'];
        List<String> nextList;
        if (digits.length() == 1) {
            nextList = NOTHING;
        } else
            nextList = letterCombinations(digits.substring(1));
        for (String start : startWith) {
            for (String next : nextList) {
                ans.add(start + next);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String test = "23";
        System.out.println(letterCombinations(test));

    }
}