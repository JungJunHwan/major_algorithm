package A3bfs;

import java.util.*;

public class A301BfsBasic1 {
    public static void main(String[] args) {
//        방문할 수 있는 정점이 여러개인 경우 정점번호가 작은것을 먼저 방문
//        bfs 알고리즘 형식의 방문순서를 출력, 출발은 0부터
        int[][] edge = {{0,2}, {0,1}, {1,3}, {2,3}, {2,4}};
//        bfs 방문시 0->1->2->3->4

//        인접리스트에 담기 (양방향)
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
//        bfs 알고리즘 구현을 위한 큐 생성
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        isVisited[0] = true;
//        queue가 비워질때까지 방문을 지속
//        queue가 비워진다는 것은 더 이상 갈곳이 없을때를 의미. 이때 코드 종료
        int start = 0;
        while(!q.isEmpty()){
            isVisited[start] = true;
            int pop = q.poll();
            System.out.println(pop);
            for(int target : adjList.get(pop)){
                if(!isVisited[target]) {
                    q.add(target);
//                    queue에 add 하는 시점에 boolean값 세팅
                    isVisited[target] = true;
                }
            }
        }

    }
}
