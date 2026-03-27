class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxLength=0;
        HashSet<Character> hash=new HashSet<>();
        for(int right=0; right<s.length(); right++) {
            while(hash.contains(s.charAt(right))) {
                hash.remove(s.charAt(left));
                left++;
            }
            hash.add(s.charAt(right));
            maxLength=Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}