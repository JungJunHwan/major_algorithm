package A3bfs;

import java.util.*;

public class A304가장먼노드 {
    public static void main(String[] args) {
        int answer = 0;
        int n = 6;
        int[][] edge = {{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}};

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] a : edge){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }

        boolean[] isVisited = new boolean[n+1];
        int[] distance = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisited[1] = true;

        while(!q.isEmpty()){
            int pop = q.poll();
            for(int target : adjList.get(pop)){
                if(!isVisited[target]) {
                    q.add(target);
                    distance[target] = distance[pop] + 1;
                    isVisited[target] = true;
                }
            }
        }

        Arrays.sort(distance);
        int max = distance[distance.length-1];
        for (int i = distance.length-1; i >= 0; i--) {
            if(distance[i] == max) answer++;
            else break;
        }

        System.out.println(answer);
    }
}
