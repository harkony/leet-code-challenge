package harkony.daily;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int hash = getHash(str);
            List<String> list = map.get(hash);
            if (list == null)
                list = new ArrayList<>();
            list.add(str);
            map.put(hash, list);
        }
        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet) {
            ans.add(map.get(key));
        }
        return ans;
    }

    private static int getHash(String str) {
        char[] sorted = str.toCharArray();
        Arrays.sort(sorted);
        return Arrays.hashCode(sorted);
    }
}
