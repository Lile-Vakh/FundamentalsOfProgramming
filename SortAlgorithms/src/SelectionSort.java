public class SelectionSort {
    public static void select(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for(int k = i + 1; k < arr.length; k++) {
                if(arr[k] < min) {
                    min = arr[k];
                    index = k;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 5, 9, 1, 0, 2};
        select(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
