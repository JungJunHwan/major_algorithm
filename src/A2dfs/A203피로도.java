//package A2dfs;
//
//public class A203피로도 {
//    static int answer;
//    public static void main(String[] args) {
//        int k = 80;
//        int[][] dungeons = {{80,20},{50,40},{30,10}};
//
//        boolean[] isVisited = new boolean[dungeons.length];
//        dfs(dungeons, isVisited, k, 0);
//        System.out.println(answer);
//    }
//
//    static void dfs(int[][] dungeons, boolean[] isVisited, int k, int count){
//        if(count > answer){
//            answer = count;
//        }
//        for (int i = 0; i <= dungeons.length; i++) {
//            if(dungeons[i][0] <= k && !isVisited[i]){
//                isVisited[i] = true;
//                dfs(dungeons, isVisited, k - dungeons[i][1], count + 1);
//                isVisited[i] = false;
//            }
//        }
//    }
//}

package A2dfs;

public class A203피로도 {
    static int answer;
    public static void main(String[] args) {
        int k=80;
        int[][] dungeons = {{80, 20}, {50,40}, {30,10}};
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, visited, k, 0);
        System.out.println(answer);
    }

    static void dfs(int[][] dungeons, boolean[] visited, int k, int count){
        if(count > answer){
            answer = count;
        }
        for (int i=0; i<dungeons.length;i++){
            if(dungeons[i][0] <= k && !visited[i]){
                visited[i] = true;
                dfs(dungeons, visited, k-dungeons[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}