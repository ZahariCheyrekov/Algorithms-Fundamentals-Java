package M04_AlgorithmsFundamentals.MyExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T01SuperSet {
    public static int[] elements;
    public static List<String> out = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        elements = Arrays.stream(reader.readLine().split("[,\\s]+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= elements.length; i++) {
            int[] arr = new int[i];
            combinations(0, 0, arr);
        }
    }

    private static void combinations(int index, int start, int[] arr) {
        if (index == arr.length) {
            print(arr);
        } else {
            for (int i = start; i < elements.length; i++) {
                arr[index] = elements[i];
                combinations(index + 1, i + 1, arr);
            }
        }
    }

    private static void print(int[] arr) {
        for (int el : arr) {
            System.out.print(el + " ");
        }
        System.out.println();
    }
}