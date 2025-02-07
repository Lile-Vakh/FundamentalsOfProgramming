import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if(arr.length == 1 || arr == null) {
            return;
        }

        int halfLength = arr.length / 2;
        int[] leftHalf = new int[halfLength];
        int[] rightHalf = new int[arr.length - halfLength];

        for(int i = 0; i < halfLength; i++) {
            leftHalf[i] = arr[i];
        }
        for(int j = halfLength; j < arr.length; j++) {
            rightHalf[j - halfLength] = arr[j];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        sort(arr, leftHalf, rightHalf);
    }

    public static void sort(int[] arr, int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;
        int i = 0, j = 0, k = 0;

        while(i < leftLen && j < rightLen) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < leftLen) {
            arr[k] = left[i];
            k++;
            i++;
        }
        while(j < rightLen) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,6,1,2,7,9,5,10,8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
