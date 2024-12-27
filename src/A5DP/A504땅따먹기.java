package A5DP;

import java.util.Arrays;

public class A504땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int temp = land[i][j];
                for (int k = 0; k < 4; k++) {
                    if(j==k) continue;
                    land[i][j] = Math.max(land[i][j], temp + land[i-1][k]);
                }
            }
        }

        for(int n : land[land.length-1]){
            answer = Math.max(answer, n);
        }
//        System.out.println(Arrays.stream(land[land.length - 1]).max().getAsInt());
        System.out.println(answer);
    }
}
