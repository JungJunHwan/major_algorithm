package A1sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A103야근지수 {
    public static void main(String[] args) {
//        int n = 4;
//        int[] works = {4, 3, 3};
//        int n = 1;
//        int[] works = {2, 1, 2};
        int n = 3;
        int[] works = {1, 1};

        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int a : works){
            pq.add(a);
        }

        for (int i = 0; i < n; i++) {
            if(pq.peek() == 0) break;
            pq.add(pq.poll()-1);
        }

        while (!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }

        System.out.println(answer);
    }
}
