package github.HsiehGrace;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _Util {

    static String absolutePath = getFilePath() + "\\Calendar\\src\\main\\resources\\PuzzleInputs\\";

    private static String getFilePath() {
        File file = new File("");
        return file.getAbsolutePath();
    }

    // scanner for input.txt
    public static Scanner readFile() {
        Scanner thisFile = null;

        try {
            thisFile = new Scanner(new File(absolutePath + "input.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("input.txt not found");
        }

        return thisFile;
    }

    // scanner for user provided file
    public static Scanner readFile(String fileName) {
        Scanner thisFile = null;

        try {
            thisFile = new Scanner(new File(absolutePath + fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println(fileName + " not found");
        }

        return thisFile;
    }


}
