package harkony.daily;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    public static Map<Integer,Boolean> map=new HashMap<>();
    public static boolean isHappy(int n) {
        if(map.get(n)!=null) {
            map.clear();
            return false;
        }
        int copy = n;
        int num = 0;
        while (copy != 0) {
            int remain = copy % 10;
            num += Math.pow(remain, 2);
            copy /= 10;
        }
        if (num == 1) {
            map.clear();
            return true;
        }
        map.put(n,true);
        return isHappy(num);
    }

    public static void main(String[] args) {
        System.out.println(isHappy(Integer.MAX_VALUE));
    }

}