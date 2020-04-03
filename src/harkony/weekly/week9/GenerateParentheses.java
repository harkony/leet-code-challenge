package harkony.weekly.week9;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    static char opener = '(';
    static char closer = ')';
    static List<String> ans = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        ans.clear();
        dfs(n, n, new StringBuilder());
        return ans;
    }

    public static void dfs(int openers, int closers, StringBuilder sentence) {
        if (openers == 0 && closers == 0) {
            ans.add(sentence.toString());
        }

        int len=sentence.length();
        //add opener
        if (openers > 0 && (openers - 1 <= closers)) {
            dfs(openers - 1, closers, sentence.append(opener));
        }
        sentence.delete(len,sentence.length());
        //add closer
        if (closers > 0 && (openers <= closers - 1)) {
            dfs(openers, closers - 1, sentence.append(closer));
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " : " + generateParenthesis(i).size());
        }
    }
}