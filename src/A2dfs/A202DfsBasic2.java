package A2dfs;

import java.util.ArrayList;
import java.util.List;

public class A202DfsBasic2 {
    static List<List<Integer>> adjList;
    static List<List<Integer>> answerList = new ArrayList<>();
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3,7}, {4,8}, {4,9}, {5,10}};

        adjList = new ArrayList<>();
        for (int i = 0; i < 10 + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] a : arr){
            adjList.get(a[0]).add(a[1]);
        }

//        답 : {1,2,4,8}, {1,2,4,9}, {1,2,5,10}, {1,3,6}, {1,3,7}
        List<Integer> answer = new ArrayList<>();
        dfs(1, answer);
        System.out.println(answerList);
    }

    static void dfs(int start, List<Integer> answer){
        answer.add(start);
        if(adjList.get(start).isEmpty()){ //더 이상 갈수있는곳이 없을때(마지막 노드 or 트리의 끝단) 저장
            answerList.add(new ArrayList<>(answer));
        }
        for(int target : adjList.get(start)){
            dfs(target, answer);
            answer.remove(answer.size()-1);
        }
    }
}
