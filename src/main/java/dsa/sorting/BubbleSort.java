package dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

    private void sort(int[] inputArray){
        int length = inputArray.length;

        for(int i=0; i < length-1; i++){
            for(int j=0; j < length-i-1; j++){
                if(inputArray[j] > inputArray[j+1]){
                    // swap
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 61, 2, 9, 4, 2, 35, 21, 8, 4};
        System.out.println("Input array: "+ Arrays.toString(arr));

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);

        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
}
