package M04_AlgorithmsFundamentals.L02_CombinatorialProblems.Lab;

import java.util.Scanner;

public class T01PermutationsWithoutRepetition {
    public static String[] elements;
    public static String[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("[\\s]+");
        arr = new String[elements.length];

        permute(0);
    }

    private static void permute(int index) {
        if (index >= elements.length) {
            print();
        } else {
            permute(index + 1);

            for (int i = index + 1; i < elements.length; i++) {
                swapElements(index, i);
                permute(index + 1);
                swapElements(index, i);
            }
        }
    }

    private static void swapElements(int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }

    private static void print() {
        System.out.println(String.join(" ", elements));
    }
}