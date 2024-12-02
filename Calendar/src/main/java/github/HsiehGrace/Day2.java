package github.HsiehGrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    private static final String dayTwoFile = "day2.txt";

    public static int partOne() {

        Scanner scanner = _Util.readFile(dayTwoFile);
        if (scanner == null) {
            return 0;
        }

        int safeReports = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(" ")));

            if (checkValid(values)) {
                safeReports++;
            }
        }

        scanner.close();
        return safeReports;

    }

    public static int partTwo() {

        Scanner scanner = _Util.readFile(dayTwoFile);
        if (scanner == null)
            return 0;


        int safeReports = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            ArrayList<String> values = new ArrayList<>(Arrays.asList(line.split(" ")));

            if (checkValidException(values))
                safeReports++;

        }

        scanner.close();
        return safeReports;
    }

    private static int compareStringInts(String firstString, String secondString){

        int first = Integer.parseInt(firstString);
        int second = Integer.parseInt(secondString);
        int difference = Math.abs(first - second);

        if (difference > 3) return -1;

        if (first < second) return 0;

        if (first > second) return 1;

        return -1;
    }

    private static boolean checkValidException(ArrayList<String>values)
    {
        // Get Ascending or Descending
        if (checkValid(values))
            return true;

        ArrayList<String> modifiedValues;

        for(int i = 0; i < values.size(); i++)
        {
            modifiedValues = new ArrayList<>(values);
            modifiedValues.remove(i);
            if (checkValid(modifiedValues))
                return true;

        }

        return false;
    }

    private static boolean checkValid(ArrayList<String> values)
    {
        int comparison = compareStringInts(values.get(0), values.get(1));

        if (comparison == -1) {return false;}

        for (int i = 1; i < values.size() - 1; i++) {
            if (compareStringInts(values.get(i), values.get(i + 1)) != comparison) {
                return false;
            }
        }

        return true;
    }

}
