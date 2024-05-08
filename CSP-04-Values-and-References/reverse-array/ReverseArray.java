import java.util.Arrays;

public class ReverseArray {
    public static int[] reverseArr(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int [] test_arr = {1, 2, 3, 4, 5};
        reverseArr(test_arr);
        System.out.println(Arrays.toString(test_arr));
    }
}
