public class bubbleSort {
    public static void bubble(int[] arr) {
        boolean swap = true;
        while(swap) {
            swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap = true;
                    int max = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = max;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,7,3,8,10,1};
        bubble(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
