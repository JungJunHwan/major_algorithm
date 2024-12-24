package A2dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        boolean[] isVisited;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for(List<Integer> a : adjList){
            a.sort(Comparator.naturalOrder());
        }

//        dfs
        sb = new StringBuilder();
        isVisited = new boolean[n+1];
        dfs(adjList, isVisited, v, sb);
        System.out.println(sb.toString().strip());

//        bfs
        sb = new StringBuilder();
        isVisited = new boolean[n+1];
        bfs(adjList, isVisited, v, sb);
        System.out.println(sb.toString().strip());
    }

    static void dfs(List<List<Integer>> adjList, boolean[] isVisited, int v, StringBuilder sb){
        if(isVisited[v]) return;
        isVisited[v] = true;
        sb.append(v).append(" ");
        for (int n : adjList.get(v)){
            dfs(adjList, isVisited, n, sb);
        }
    }

    static void bfs(List<List<Integer>> adjList, boolean[] isVisited, int v, StringBuilder sb){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        isVisited[v] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            sb.append(temp).append(" ");
            for(int n : adjList.get(temp)){
                if(!isVisited[n]) {
                    q.add(n);
                    isVisited[n] = true;
                }
            }
        }
    }
}
