package oop.ooppractice.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int c = divide(a, b);
        } catch (TestException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new TestException("Test message");
        }
        return a / b;
    }

}
