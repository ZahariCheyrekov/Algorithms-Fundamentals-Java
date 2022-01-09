package M04_AlgorithmsFundamentals.ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T02ClusterBorder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] singleShipTime = findData(reader);
        int[] pairShipTime = findData(reader);

        int[] dp = new int[singleShipTime.length + 1];

        dp[1] = singleShipTime[0];

        for (int i = 2; i <= singleShipTime.length; i++) {
            dp[i] = Math.min(dp[i - 1] + singleShipTime[i - 1], dp[i - 2] + pairShipTime[i - 2]);
        }

        List<String> output = new ArrayList<>();
        for (int i = dp.length - 1; i > 0; i--) {
            int timeDiff = dp[i] - dp[i - 1];

            if (timeDiff == singleShipTime[i - 1]) {
                output.add("Single " + i);
            } else {
                output.add("Pair of " + (i - 1) + " and " + i);
                i--;
            }
        }

        System.out.println("Optimal Time: " + dp[singleShipTime.length]);
        for (int i = output.size() - 1; i >= 0; i--) {
            System.out.println(output.get(i));
        }
    }

    private static int[] findData(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}