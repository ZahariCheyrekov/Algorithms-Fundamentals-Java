package M04_AlgorithmsFundamentals.L03_RecursionAndCombinatorialProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T01ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] elements = reader.readLine().split("\\s+");

        reverse(elements, elements.length - 1);
    }

    private static void reverse(String[] elements, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(elements[index] + " ");

        reverse(elements, index - 1);
    }
}