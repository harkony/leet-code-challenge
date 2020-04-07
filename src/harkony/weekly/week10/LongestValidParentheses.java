package harkony.weekly.week10;

import java.util.Arrays;
import java.util.List;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if(s.length()<2)
            return 0;
        char opener = '(';
        int[] arr=new int[s.length()];
        int[][] mat=new int[s.length()][s.length()];

        Arrays.fill(arr,-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==opener)
                arr[i]=1;
        }
        mat[0][0]=arr[0];


        int max=0;
        for(int j=1;j<s.length();j++){
            mat[0][j]= mat[0][j-1]+arr[j];
            if(mat[0][j]==0)
                max= Math.max(max,j+1);
        }

        for(int i=1;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                mat[i][j]=mat[i-1][j]-arr[i];
                if(mat[i][j]==0)
                    max= Math.max(max,j-i+1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("(()", ")()())",")(");
        input.forEach(x -> System.out.println(longestValidParentheses(x)));
    }
}
