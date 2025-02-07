public class InsertionSort{
    public static void insert(int[] arr) {
        int comp;
        int j;
        for(int i = 1; i < arr.length; i++) {
            j = i - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                comp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = comp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,7,5,4,9,10,2};
        insert(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}
