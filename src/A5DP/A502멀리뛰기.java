package A5DP;

public class A502멀리뛰기 {
    public static void main(String[] args) {
        int n = 2000;
        long answer = 0;

        int[] arr = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        answer = arr[n];
        System.out.println(answer);
    }


}
