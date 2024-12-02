package github.HsiehGrace;

import java.util.*;

public class Day1 {

    private static final String dayOneFile = "day1.txt";

    public static int partOne() {
        Scanner scanner = _Util.readFile(dayOneFile);
        if(scanner == null) return 0;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split(" {3}");
            left.add(Integer.parseInt(values[0]));
            right.add(Integer.parseInt(values[1]));
        }

        Collections.sort(left);
        Collections.sort(right);

        int distance = 0;

        for(int i = 0; i < left.size(); i++) {
            distance += Math.abs(left.get(i) - right.get(i));
        }

        scanner.close();
        return distance;

    }

    public static int partTwo() {
        Scanner scanner = _Util.readFile(dayOneFile);
        if(scanner == null) return 0;

        ArrayList<Integer> left = new ArrayList<>();
        Map<Integer, Integer> right = new HashMap<>();

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] values = line.split(" {3}");
            left.add(Integer.parseInt(values[0]));

            int rightValue = Integer.parseInt(values[1]);

            if (right.containsKey(rightValue))
                right.put(rightValue, right.get(rightValue) + 1);

            else
                right.put(rightValue, 1);
        }

        int similarity = 0;
        for (Integer leftVal : left) {

            if (right.containsKey(leftVal))
                similarity += leftVal * right.get(leftVal);

        }

        scanner.close();
        return similarity;
    }

}
