package M04_AlgorithmsFundamentals.L05_GraphTheoryTraversalAndShortestPaths.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class T02TopologicalSorting {
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        graph = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

                graph.add(numbers);
            }
        }

        visited = new boolean[graph.size()];

        List<Deque<Integer>> connectedComponents = getConnectedComponents();

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected component:");
            for (int current : connectedComponent) {
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents() {
        List<Deque<Integer>> components = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                components.add(new ArrayDeque<>());
                dfs(start, components);
            }
        }

        return components;
    }

    private static void dfs(int node, List<Deque<Integer>> components) {
        if (!visited[node]) {
            visited[node] = true;

            for (int child : graph.get(node)) {
                dfs(child, components);
            }
            components.get(components.size() - 1).offer(node);
        }
    }

    public static List<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
            String key = graph.keySet().stream()
                    .filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (key == null) {
                break;
            }

            for (String child : graph.get(key)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(key);
            graph.remove(key);
        }

        if (!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependenciesCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                dependenciesCount.putIfAbsent(child, 0);
                dependenciesCount.put(child, dependenciesCount.get(child) + 1);
            }
        }

        return dependenciesCount;
    }
}