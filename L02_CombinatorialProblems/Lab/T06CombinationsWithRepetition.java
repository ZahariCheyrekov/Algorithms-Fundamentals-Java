package M04_AlgorithmsFundamentals.L02_CombinatorialProblems.Lab;

import java.util.Scanner;

public class T06CombinationsWithRepetition {
    private static String[] elements;
    private static String[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");

        int arrSize = Integer.parseInt(scanner.nextLine());
        arr = new String[arrSize];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == arr.length) {
            print();
        } else {
            for (int i = start; i < elements.length; i++) {
                arr[index] = elements[i];
                combinations(index + 1, i);
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", arr));
    }
}