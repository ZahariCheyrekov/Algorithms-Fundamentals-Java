package M04_AlgorithmsFundamentals.L05_GraphTheoryTraversalAndShortestPaths.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class T03CyclesInGraph {
    public static Map<String, List<String>> graph = new HashMap<>();
    public static Set<String> visited = new HashSet<>();
    public static Set<String> cycles = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] connections = input.split("-");

            String node = connections[0];
            String edge = connections[1];

            graph.putIfAbsent(node, new ArrayList<>());
            graph.get(node).add(edge);

            input = reader.readLine();
        }

        String out = "";
        try {
            for (String current : graph.keySet()) {
                if (!visited.contains(current)) {
                    dfsDetectCycles(current);
                    out = "Acyclic: Yes";
                }
            }
        } catch (IllegalStateException ex) {
            out = ex.getMessage();
        }
        System.out.println(out);
    }

    private static void dfsDetectCycles(String source) {
        if (cycles.contains(source)) {
            throw new IllegalStateException("Acyclic: No");
        }
        if (visited.contains(source)) {
            return;
        }
        cycles.add(source);
        visited.add(source);

        if (graph.get(source) == null) {
            return;
        }

        for (String child : graph.get(source)) {
            dfsDetectCycles(child);
        }
        cycles.remove(source);
    }
}