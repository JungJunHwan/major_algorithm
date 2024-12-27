package A5DP;

import java.util.Arrays;

public class A503정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j==0) triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                else if(j==triangle[i].length-1) triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                else triangle[i][j] = Math.max(triangle[i][j] + triangle[i-1][j-1], triangle[i][j] + triangle[i-1][j]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int n : triangle[triangle.length-1]) {
            max = Math.max(max, n);
        }

        System.out.println(max);
    }
}
