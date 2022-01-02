package M04_AlgorithmsFundamentals.L02_CombinatorialProblems.Lab;

import java.util.HashSet;
import java.util.Scanner;

public class T02PermutationsWithRepetitions {
    public static String[] elements;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        elements = scanner.nextLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            print(elements);
        } else {
            permute(index + 1);

            HashSet<String> swapped = new HashSet<>();
            swapped.add(elements[index]);

            for (int i = index + 1; i < elements.length; i++) {
                if (!swapped.contains(elements[i])) {
                    swap(elements, index, i);
                    permute(index + 1);
                    swap(elements, index, i);
                    swapped.add(elements[i]);
                }
            }
        }
    }

    private static void swap(String[] elements, int first, int second) {
        String temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }

    private static void print(String[] arr) {
        System.out.println(String.join(" ", arr));
    }
}