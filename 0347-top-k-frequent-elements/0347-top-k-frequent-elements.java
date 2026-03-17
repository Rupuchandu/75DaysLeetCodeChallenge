class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap=new HashMap<>();
        for(int x: nums) {
            freqMap.put(x, freqMap.getOrDefault(x, 0)+1);
        }
        List<Integer>[] buck=new ArrayList[nums.length+1];
        for(int key: freqMap.keySet()) {
            int freq=freqMap.get(key);
            if(buck[freq]==null) {
                buck[freq]=new ArrayList<>();
            }
            buck[freq].add(key);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=buck.length-1; i>=0 && res.size()<k; i--) {
            if(buck[i]!=null) {
                res.addAll(buck[i]);
            }
        }
        int[] resu=new int[k];
        for(int i=0; i<k; i++) {
            resu[i]=res.get(i);
        }
        return resu;
    }
}