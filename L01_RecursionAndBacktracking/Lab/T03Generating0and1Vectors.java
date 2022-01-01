package M04_AlgorithmsFundamentals.L01_RecursionAndBacktracking.Lab;

import java.util.Scanner;

public class T03Generating0and1Vectors {
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        arr = new int[n];

        generate(0);
    }

    private static void generate(int index) {
        if (index >= arr.length) {
            print();
        } else {
            for (int i = 0; i <= 1; i++) {
                arr[index] = i;
                generate(index + 1);
            }
        }
    }

    private static void print() {
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();
    }
}