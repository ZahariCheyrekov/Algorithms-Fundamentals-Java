package M04_AlgorithmsFundamentals.L05_GraphTheoryTraversalAndShortestPaths.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class T01ConnectedComponents_BFS {
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
            System.out.print("Connected component: ");
            for (int current : connectedComponent) {
                System.out.print(current + " ");
            }
            System.out.println();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents() {
        List<Deque<Integer>> components = new ArrayList<>();

        for (int startNode = 0; startNode < graph.size(); startNode++) {
            if (!visited[startNode]) {
                components.add(new ArrayDeque<>());
                bfs(startNode, components);
            }
        }
        return components;
    }

    private static void bfs(int startNode, List<Deque<Integer>> components) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            components.get(components.size() - 1).offer(node);

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
    }
}