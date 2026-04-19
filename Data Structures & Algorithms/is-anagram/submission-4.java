class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCounts = new HashMap<>();
        Map<Character, Integer> tCounts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sCounts.put(s.charAt(i), sCounts.getOrDefault(s.charAt(i), 0) + 1);
            tCounts.put(t.charAt(i), tCounts.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sCounts.equals(tCounts);

    }
}
