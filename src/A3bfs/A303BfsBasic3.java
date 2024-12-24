package A3bfs;

import java.util.*;

public class A303BfsBasic3 {
    public static void main(String[] args) {
        int[][] edge = {{0,2}, {0,1}, {1,3}, {2,3}, {2,4}};
//        0에서 출발해서 4번 노드까지의 최단거리 구하기
        int targetNode = 4;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] a : edge){
            adjList.get(a[0]).add(a[1]);
            adjList.get(a[1]).add(a[0]);
        }
        for(List<Integer> a : adjList){
            a.sort(Comparator.naturalOrder());
        }

        boolean[] isVisited = new boolean[5];
        int[] distance = new int[5];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        isVisited[0] = true;
        int start = 0;
//        distance[0] = 0;
        loop :
        while(!q.isEmpty()){
            isVisited[start] = true;
            int pop = q.poll();
            for(int target : adjList.get(pop)){
                if(!isVisited[target]) {
                    q.add(target);
                    distance[target] = distance[pop] + 1;
//                    targetNode를 발견시 더 이상 distance를 구하기 위한 작업은 필요 없음
                    if(target == targetNode) break loop;
                    isVisited[target] = true;
                }
            }
        }
        System.out.println(distance[targetNode]);
    }
}
