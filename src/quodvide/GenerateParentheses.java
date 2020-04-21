package quodvide;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *  너무생각 안나서 학현놈꺼 보고 만듬
 */
public class GenerateParentheses {
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        makeParentheses(n, n, new StringBuilder());
        return list;
    }

    private static void makeParentheses(int openers, int closers, StringBuilder builder) {
        if(openers + closers == 0) {
            list.add(builder.toString());
            return;
        }

        if(openers > 0) {
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append('(');
            makeParentheses(openers - 1, closers, newBuilder);
        }

        if(closers > 0 && openers < closers) {
            StringBuilder newBuilder = new StringBuilder(builder);
            newBuilder.append(')');
            makeParentheses(openers, closers - 1, newBuilder);
        }
    }
}
