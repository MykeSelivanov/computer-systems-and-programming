class SumArray {

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4, 5, -10, 20 };
        System.out.println(sumArray(test));
    }
}