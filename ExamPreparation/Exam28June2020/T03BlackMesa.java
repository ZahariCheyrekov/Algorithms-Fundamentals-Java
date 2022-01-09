package M04_AlgorithmsFundamentals.ExamPreparation.Exam28June2020;

import java.io.IOException;
import java.util.*;

public class T03BlackMesa {
    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int nodes = Integer.parseInt(scanner.nextLine());
        int connections = Integer.parseInt(scanner.nextLine());

        graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < connections; i++) {
            graph[scanner.nextInt()][scanner.nextInt()] = 1;
        }

        int source = scanner.nextInt();
        int destination = scanner.nextInt();

        visited = new boolean[nodes + 1];

        List<Integer> path = new ArrayList<>();

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        boolean isNotFound = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;

            if (isNotFound) {
                path.add(node);
                isNotFound = node != destination;
            }

            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }

        StringBuilder output = new StringBuilder();

        for (int node : path) {
            output.append(node).append(" ");
        }

        output.append(System.lineSeparator());

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                output.append(i).append(" ");
            }
        }

        System.out.println(output);
    }
}