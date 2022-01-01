package M04_AlgorithmsFundamentals.L01_RecursionAndBacktracking.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T05PathsInLabyrinth {
    private static final List<Character> paths = new ArrayList<>();
    private static char[][] labyrinth;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        labyrinth = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            labyrinth[row] = scanner.nextLine().toCharArray();
        }

        findPaths(0, 0, ' ');
    }

    private static void findPaths(int row, int col, char direction) {
        if (!isInBound(row, col) ||
                labyrinth[row][col] == '*' ||
                labyrinth[row][col] == 'V') {
            return;
        }

        paths.add(direction);

        if (labyrinth[row][col] == 'e') {
            printPath();
            paths.remove(paths.size() - 1);
            return;
        }

        labyrinth[row][col] = 'V';

        findPaths(row - 1, col, 'U');
        findPaths(row + 1, col, 'D');
        findPaths(row, col - 1, 'L');
        findPaths(row, col + 1, 'R');

        labyrinth[row][col] = '-';

        paths.remove(paths.size() - 1);
    }

    private static void printPath() {
        for (int i = 1; i < paths.size(); i++) {
            System.out.print(paths.get(i));
        }
        System.out.println();
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < labyrinth.length && col >= 0 && col < labyrinth[row].length;
    }
}