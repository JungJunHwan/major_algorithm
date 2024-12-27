package A4greedy;

import java.util.Arrays;

public class A402체육복 {
    public static void main(String[] args) {
        int n =5;
        int[] lost = new int[]{2,4};
        int[] reserve = new int[]{3};
        int[] student1 = new int[n+1];
        int[] student2 = new int[n+1];
        Arrays.fill(student2,1);
        Arrays.fill(student1,1);
        for(int i=0;i<lost.length;i++){

            student1[lost[i]]--;
            student2[lost[i]]--;
        }
        student1[0]=0;
        student2[0]=0;

        int caseup= 0;
        int casedown = 0;
        for(int i = 0;i<reserve.length;i++){
            if(student1[reserve[i]]==1&&student1[reserve[i]-1]==0){
                student1[reserve[i]-1]++;
            }
        }
        for(int i = 0;i<reserve.length;i++){
            if(student2[reserve[i]]==1&&student2[reserve[i]+1]==0){
                student2[reserve[i]+1]++;
            }
        }


        for(int a : student1){
            caseup+=a;
        }

        for(int a : student2){
            casedown+=a;
        }
        System.out.println(Arrays.toString(student1));
        System.out.println(Arrays.toString(student2));
        int answer = Math.max(caseup,casedown);
        System.out.println(answer);

    }
}