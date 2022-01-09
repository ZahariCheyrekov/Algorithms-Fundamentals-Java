package M04_AlgorithmsFundamentals.MyExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class T02Paths {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());

        for (int i = 0; i < nodes; i++) {
            String input = reader.readLine();
            if (!input.trim().equals("")) {
                List<Integer> nextNodes = Arrays.stream(input.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(i, nextNodes);

            } else {
                graph.add(i, new ArrayList<>());
            }
        }

        for (int i = 0; i < nodes - 1; i++) {
            path.add(i);
            dfs(i, nodes - 1);
            path.clear();
        }
    }

    private static void dfs(int node, int destination) {
        if (node == destination) {
            print();
            return;
        }

        for (int child : graph.get(node)) {
            path.add(child);
            dfs(child, destination);
            path.remove(path.size() - 1);
        }
    }

    private static void print() {
        for (int i : path) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}