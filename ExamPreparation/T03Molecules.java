package M04_AlgorithmsFundamentals.ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class T03Molecules {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        int connections = Integer.parseInt(reader.readLine());

        for (int i = 0; i < nodes + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connections; i++) {
            int[] pairs = Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int node = pairs[0];
            int edge = pairs[1];

            graph.get(node).add(edge);
        }
        visited = new boolean[graph.size()];

        int start = Integer.parseInt(reader.readLine());

        bfs(start);

        StringBuilder out = new StringBuilder();
        for (int node = 1; node < visited.length; node++) {
            if (!visited[node]) {
                out.append(node).append(" ");
            }
        }
        System.out.println(out);
    }

    private static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }
}