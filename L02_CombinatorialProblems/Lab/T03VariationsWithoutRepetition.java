package M04_AlgorithmsFundamentals.L02_CombinatorialProblems.Lab;

import java.util.Scanner;

public class T03VariationsWithoutRepetition {
    private static String[] elements;
    private static String[] arr;
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");

        int arrSize = Integer.parseInt(scanner.nextLine());

        used = new boolean[elements.length];
        arr = new String[arrSize];

        variations(0);
    }

    private static void variations(int index) {
        if (index == arr.length) {
            print();
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    arr[index] = elements[i];
                    variations(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", arr));
    }
}