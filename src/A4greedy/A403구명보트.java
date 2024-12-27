package A4greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class A403구명보트 {
    public static void main(String[] args) {
        int[] people={70, 50, 80};
        int limit = 100;

        int boat=0;
        Arrays.sort(people);
        int fir = 0;
        int last = people.length-1;

        while (fir<=last){
            if(people[fir]+people[last]<=limit){
                fir++;
            }
            last--;
            boat++;
        }
        System.out.println(boat);

    }
}