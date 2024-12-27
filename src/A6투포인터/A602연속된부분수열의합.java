package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A602연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        int[] answer = {};
        int start = 0;
        int end = 0;
        int total = sequence[start];
        List<int[]> myList = new ArrayList<>();

        while(start<=end && end<sequence.length){
            if(total == k){
                myList.add(new int[]{start, end});
                end++;
                if(end < sequence.length){
                    total += sequence[end];
                }
            }
            if (total < k) {
                end++;
                if(end < sequence.length){
                    total += sequence[end];
                }
            }else if (total > k) {
                total -= sequence[start];
                start++;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int[] a : myList){
            if(a[1] - a[0] < min) {
                min = a[1] - a[0];
                answer = a;
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
