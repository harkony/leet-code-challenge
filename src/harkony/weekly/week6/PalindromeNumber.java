package harkony.weekly.week6;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x==0)
            return true;
        if(x<0)
            return false;

        int n= (int) Math.log10(x)+1;
        int arr[]=new int[n];
        int remain=0;
        for(int i=n-1;i>=0;i--){
            remain=x%10;
            arr[i]=remain;
            x = x/10;
        }
        for(int i=0;i<n/2;i++){
            if(arr[i]!=arr[n-i-1])
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        int arr[]={0,101,10,-1,-101,11};
        for(int n:arr) {
            System.out.println(isPalindrome(n));
        }
    }
}
