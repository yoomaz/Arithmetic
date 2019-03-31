package q35;

import java.util.LinkedHashMap;

/**
 * 在字符串中找出第一个只出现一个的字符
 * <p>
 * 思路：字符串转换成字符数组，然后遍历，把 char 和 出现次数 放到一个 LinkedHashMap 中，因为 LinkedHashMap 是有序的，所以 keyset 获取的 Set(LinkedKeySet) 也是有序的，取出第一个 value == 1 的 key 即可
 */
public class FirstNotRepeating {

    public static void main(String[] args) {
        System.out.println(firstNotRepeating("abaccdeff"));
    }

    public static Character firstNotRepeating(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return null;
    }

}
