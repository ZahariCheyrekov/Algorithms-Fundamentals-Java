package M04_AlgorithmsFundamentals.ExamPreparation.Exam28June2020;

import java.util.Scanner;

public class T01AlphaDecay {
    private static String[] elements;
    private static String[] arr;
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split("\\s+");
        int k = Integer.parseInt(scanner.nextLine());

        arr = new String[k];
        used = new boolean[elements.length];

        generate(0);
    }

    private static void generate(int index) {
        if (index >= arr.length) {
            print();
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    arr[index] = elements[i];
                    generate(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        System.out.println(String.join(" ", arr));
    }
}