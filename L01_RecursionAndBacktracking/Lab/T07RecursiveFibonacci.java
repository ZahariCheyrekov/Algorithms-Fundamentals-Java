package M04_AlgorithmsFundamentals.L01_RecursionAndBacktracking.Lab;

import java.util.Scanner;

public class T07RecursiveFibonacci {
    public static long[] memory;

    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).nextLine());

        memory = new long[n + 1];

        long fib = fib(n);

        System.out.println(fib);
    }

    private static long fib(int n) {
        if (n <= 1) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = fib(n - 1) + fib(n - 2);
    }
}