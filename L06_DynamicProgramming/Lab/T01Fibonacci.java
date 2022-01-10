package M04_AlgorithmsFundamentals.L06_DynamicProgramming.Lab;

import java.util.Scanner;

public class T01Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        int prev = 0;
        int current = 1;

        for (int i = 1; i < num; i++) {
            int currentNum = current;
            current = prev + current;
            prev = currentNum;
        }

        System.out.println(current);
    }
}