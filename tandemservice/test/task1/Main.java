package ru.tandemservice.test.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String[]> array = new ArrayList<>();
        array.add(new String[]{"457ABC326DEF", "457BRD247DEF", "",   "",  "1"});
        array.add(new String[]{"367ABC326DEF", null,           "0",  "",  "12ABC"});
        array.add(new String[]{"",             "1ABC",          null, "1", "12BCD"});
        array.add(new String[]{null,           "1BBC",          null, "2", "2ABC"});

        Task1Impl.INSTANCE.sort(array, 0);
        printArray(array);
    }

    private static void printArray(List<String[]> array) {
        for (String[] row : array) {
            for (String s : row) {
                System.out.printf("| %-15s", s);
            }
            System.out.println();
        }
    }
}
