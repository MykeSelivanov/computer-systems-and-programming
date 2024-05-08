public class IsPalindrom {
    public static boolean isPalindrom(String[] strArr) {
        for (int i = 0; i < strArr.length / 2; i++) {
            if (strArr[i] != strArr[strArr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] palindrome = {"hey", "hello", "world", "hello", "hey"};
        System.out.println(isPalindrom(palindrome));
    }
}
