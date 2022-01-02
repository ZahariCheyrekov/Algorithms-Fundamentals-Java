package M04_AlgorithmsFundamentals.L02_CombinatorialProblems.Lab;

import java.util.Scanner;

public class T05CombinationsWithoutRepetition {
    public static String[] elements;
    public static String[] arr;
    public static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");

        int arrSize = Integer.parseInt(scanner.nextLine());
        arr = new String[arrSize];
        used = new boolean[elements.length];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == arr.length) {
            print();
        } else {
            for (int i = start; i < elements.length; i++) {
                arr[index] = elements[i];
                combinations(index + 1, i + 1);
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", arr));
    }
}