package M04_AlgorithmsFundamentals.L05_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class T02AreasInMatrix {
    public static char[][] matrix;
    public static boolean[][] visited;
    public static Map<Character, Integer> areas = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());

        fillMatrix(rows, reader);

        findAreas();

        int totalAreas = areas.values().stream().mapToInt(value -> value).sum();
        System.out.println("Areas: " + totalAreas);

        areas.forEach((key, value) ->
                System.out.printf("Letter '%c' -> %d%n", key, value));
    }

    private static void findAreas() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];

                if (!visited[row][col]) {
                    if (!areas.containsKey(symbol)) {
                        areas.put(symbol, 1);
                    } else {
                        areas.put(symbol, areas.get(symbol) + 1);
                    }

                    dfs(row, col, symbol);
                }
            }
        }
    }

    private static void dfs(int row, int col, char symbol) {
        if (!isValid(row, col, symbol)) {
            return;
        }

        visited[row][col] = true;

        dfs(row, col + 1, symbol);
        dfs(row, col - 1, symbol);
        dfs(row + 1, col, symbol);
        dfs(row - 1, col, symbol);
    }

    private static boolean isValid(int row, int col, char symbol) {
        return (row >= 0) && (row < matrix.length) &&
                (col >= 0) && (col < matrix[row].length) &&
                !visited[row][col] &&
                matrix[row][col] == symbol;
    }

    private static void fillMatrix(int rows, BufferedReader reader) throws IOException {
        matrix = new char[rows][];
        visited = new boolean[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = reader.readLine().toCharArray();
            visited[row] = new boolean[matrix[row].length];
        }
    }
}