package M04_AlgorithmsFundamentals.L01_RecursionAndBacktracking.Lab;

import java.util.Scanner;

public class T04RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        long factorial = calFact(num);
        System.out.println(factorial);
    }

    private static long calFact(int num) {
        if (num <= 1) {
            return 1;
        }

        return num * calFact(num - 1);
    }
}