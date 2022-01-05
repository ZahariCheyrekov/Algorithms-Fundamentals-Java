package M04_AlgorithmsFundamentals.L05_GraphTheoryTraversalAndShortestPaths.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class T01ConnectedComponents_DFS {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nodes; i++) {
            String input = scanner.nextLine();

            if (input.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> edges = Arrays.stream(input.split("\\s+"))
                        .map(Integer::parseInt).collect(Collectors.toList());

                graph.add(edges);
            }
        }

        List<Deque<Integer>> connectedComponents = getComponents();

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected component: ");
            for (int element : connectedComponent) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static List<Deque<Integer>> getComponents() {
        visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int startNode = 0; startNode < graph.size(); startNode++) {
            if (!visited[startNode]) {
                components.add(new ArrayDeque<>());
                dfs(startNode, components);
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
}