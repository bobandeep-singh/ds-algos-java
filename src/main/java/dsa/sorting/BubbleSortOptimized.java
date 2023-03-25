package dsa.sorting;

import java.util.Arrays;

public class BubbleSortOptimized {
    private void sort(int[] arr){
        int length = arr.length;
        boolean swapped = false;

        for(int i=0; i < length-1; i++){
            for(int j=0; j < length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }
            if(!swapped){
                // Array is sorted as no swap happened in this iteration
                // we can break out from loop
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 61, 2, 9, 4, 2, 35, 21, 8, 4};
        System.out.println("Input array: "+ Arrays.toString(arr));

        BubbleSortOptimized bubbleSortOptimized = new BubbleSortOptimized();
        bubbleSortOptimized.sort(arr);

        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
}
