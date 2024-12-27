package A6투포인터;

public class A603숫자의표현 {
    public static void main(String[] args) {
        int n = 15;

        int answer = 0;
        int start = 1;
        int end = 1;
        int total = 1;

        while (end <= n){
            if(total == n){
                answer++;
                end++;
                total += end;
            }
            if(total < n){
                end++;
                total += end;
            } else if (total > n) {
                total -= start;
                start++;
            }
        }

        System.out.println(answer);
    }
}
