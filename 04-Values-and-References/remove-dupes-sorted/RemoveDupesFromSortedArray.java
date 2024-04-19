import java.util.Arrays;

public class RemoveDupesFromSortedArray {

    public static int[] removeDupesFromSorted(int[] numArr) {
        int length = 1; // Length of the non-duplicate part of the array
        for (int i = 1; i < numArr.length; i++) {
            if (numArr[i] != numArr[i - 1]) {
                numArr[length++] = numArr[i]; // Move the unique number to the next position
            }
        }

        return Arrays.copyOf(numArr, length);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 4, 4, 5, 5, 5 };
        int[] result = removeDupesFromSorted(nums);
        System.out.println(Arrays.toString(result));
    }

}
