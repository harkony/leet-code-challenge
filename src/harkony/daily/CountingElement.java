package harkony.daily;


/*
Given an integer array arr, count element x such that x + 1 is also in arr.
If there're duplicates in arr, count them seperately.
 */
public class CountingElement {
    public static int countElements(int[] arr) {
        int count = 0;
        int counter[] = new int[1002];
        for (int num : arr) {
            counter[num ]++;
        }
        for (int num : arr) {
            if (counter[num+1] != 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 1, 3, 3, 5, 5, 7, 7},
                {1, 3, 2, 3, 5, 0},
                {1, 1, 2, 2},
        };
        for(int[] test:tests)
            System.out.println(countElements(test));
    }
}
