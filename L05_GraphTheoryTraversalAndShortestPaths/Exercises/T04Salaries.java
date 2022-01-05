package M04_AlgorithmsFundamentals.L05_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T04Salaries {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static long[] salaries;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int employees = Integer.parseInt(reader.readLine());

        visited = new boolean[employees];
        salaries = new long[employees];

        int[] managersCount = new int[employees];

        for (int i = 0; i < employees; i++) {
            graph.add(new ArrayList<>());

            String line = reader.readLine();
            for (int employee = 0; employee < line.length(); employee++) {
                char currentChar = line.charAt(employee);

                if (currentChar == 'Y') {
                    graph.get(i).add(employee);
                    managersCount[employee]++;
                }
            }
        }

        List<Integer> sources = new ArrayList<>();
        for (int i = 0; i < managersCount.length; i++) {
            if (managersCount[i] == 0) {
                sources.add(i);
            }
        }

        for (int source : sources) {
            dfs(source);
        }

        long sum = Arrays.stream(salaries).sum();

        System.out.println(sum);
    }

    private static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);

                long sum = graph.get(child)
                        .stream()
                        .mapToLong(c -> salaries[c])
                        .sum();

                salaries[child] = sum == 0 ? 1 : sum;
            }
        }

        long sum = graph.get(node)
                .stream()
                .mapToLong(c -> salaries[c])
                .sum();

        salaries[node] = sum == 0 ? 1 : sum;
    }
}