package harkony.daily;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            Integer result=map.get(num);
            if(result==null){
                map.put(num,1);
                continue;
            }
            map.remove(num);
        }
        Set<Integer> keySet= map.keySet();
        for(Integer key:keySet){
            return key;
        }
        return -1;
    }
}