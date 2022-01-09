package M04_AlgorithmsFundamentals.ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class T01MonkeyBusiness {
    public static int[] arr;
    public static int[] numbers;
    public static int solutions = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        numbers = new int[n];

        int value = 1;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = value;
            value++;
        }

        generateNumbers(0);

        System.out.print(sb);
        System.out.println("Total Solutions: " + solutions);
    }

    private static void generateNumbers(int index) {
        if (index == numbers.length) {
            print();
        } else {
            arr[index] = numbers[index];
            generateNumbers(index + 1);
            arr[index] = -numbers[index];
            generateNumbers(index + 1);
        }
    }

    private static void print() {
        int sum = Arrays.stream(arr).sum();

        if (sum == 0) {
            solutions++;

            for (int num : arr) {
                String value = "-";

                if (num > 0) {
                    value = "+";
                }
                sb.append(value).append(Math.abs(num)).append(" ");
            }
            sb.append(System.lineSeparator());
        }
    }
}