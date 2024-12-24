package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class A101HeapSort구현 {

    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,6};
//        최초 힙구성 : O(n*log(n))
        for (int i = arr.length/2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

//        로트노드와 최하위노드를 바꾸면서 heapify
//        최하위노드는 바뀔때마다 자리수가 -1
        for (int i = arr.length-1; i >= 0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
        System.out.println(Arrays.toString(arr));

//        pq를 통한 정렬 방법
        int[] newArr = new int[arr.length];
        Queue<Integer> pq = new PriorityQueue<>();
        for(int a : arr){
            pq.add(arr[a]);
        }
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = pq.poll();
        }
    }

    static void heapify(int[] arr, int parent, int len){
        int left = parent*2 + 1;
        int right = parent*2 + 2;
//        check1 : 왼쪽, 오른쪽 노드가 배열의 길이보다 짧아야 함
//        check2 : left, right 셋 중에 parent 값보다 작은 값이 있을 경우 자리 바꾸기 후 재귀
//        left만 존재
        if(left >= len) return;
        if(right >= len) {
            if(arr[left] < arr[parent]){
                int temp = arr[left];
                arr[left] = arr[parent];
                arr[parent] = temp;
                heapify(arr, left, len);
            }
        }else {
            int index = 0;
            if (arr[parent] > arr[left] || arr[parent] > arr[right]) {
                if (arr[left] > arr[right]) index = right;
                else index = left;
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
                heapify(arr, index, len);
            }
        }
    }
}
