package M04_AlgorithmsFundamentals.L02_CombinatorialProblems.Lab;

import java.util.Scanner;

public class T04VariationsWithRepetition {
    public static String[] elements;
    public static String[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        int sizeArr = Integer.parseInt(scanner.nextLine());

        arr = new String[sizeArr];

        variations(0);
    }

    private static void variations(int index) {
        if (index == arr.length) {
            print();
        } else {
            for (String element : elements) {
                arr[index] = element;
                variations(index + 1);
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", arr));
    }
}