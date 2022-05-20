class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String test : strs) {
            char[] arr  = test.toCharArray();
            Arrays.sort(arr);
            String sortedString = Arrays.toString(arr);
            if (map.containsKey(sortedString)) {
                map.get(sortedString).add(test);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(test);
                map.put(sortedString, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}