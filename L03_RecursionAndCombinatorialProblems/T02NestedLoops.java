package M04_AlgorithmsFundamentals.L03_RecursionAndCombinatorialProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T02NestedLoops {
    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];

        printRes(0);
    }

    private static void printRes(int index) {
        if (index >= arr.length) {
            printRes();
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            printRes(index + 1);
        }
    }

    private static void printRes() {
        for (int current : arr) {
            System.out.print(current + " ");
        }
        System.out.println();
    }
}