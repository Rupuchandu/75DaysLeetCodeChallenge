class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int  i=0; i<numCourses; i++) graph.add(new ArrayList<>());
        int[] in=new int[numCourses];
        for(int[] pre: prerequisites) {
            int cor=pre[0];
            int preq=pre[1];
            graph.get(preq).add(cor);
            in[cor]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(in[i]==0) queue.offer(i);
        }
        int comp=0;
        while(!queue.isEmpty()) {
            int curr=queue.poll();
            comp++;
            for(int neighbor: graph.get(curr)) {
                in[neighbor]--;
                if(in[neighbor]==0) queue.offer(neighbor);
            }
        }
        return comp==numCourses;
    }
}