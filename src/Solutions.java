import java.util.ArrayList;
import java.util.List;

public class Solutions {

    /* Problem 49. #Group Anagrams# #MEDIUM#
     * https://leetcode.com/problems/group-anagrams/
     *  Problem description:
     *  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     *  typically using all the original letters exactly once.
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> innerList;
            if (map.containsKey(s)) {
                innerList = map.get(s);
                innerList.add(str);
            } else {
                innerList = new ArrayList();
                innerList.add(str);
            }
            map.put(s, innerList);
        }
        for (String key: map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    /* Problem 347. #Top K Frequent Elements# # #MEDIUM#
     * https://leetcode.com/problems/top-k-frequent-elements/submissions/
     *  Problem description:
     *  Given an integer array nums and an integer k, return the k most frequent elements.
     *  You may return the answer in any order.
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> entry: entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }
}
