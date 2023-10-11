package ru.tandemservice.test.task1;

import java.util.Comparator;

public class CustomComparator implements Comparator<String[]> {

    private static final String SPLIT_RGX = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)";

    private final int columnIndex;

    public CustomComparator(int columnIndex) {
        this.columnIndex = columnIndex;
    }


    @Override
    public int compare(String[] row1, String[] row2) {
        var s1 = row1[columnIndex];
        var s2 = row2[columnIndex];

        // Обработка null и пустых значений
        if (s1 == null && s2 == null)
            return 0;
        else if (s1 == null)
            return -1;
        else if (s2 == null)
            return 1;
        else if (s1.isEmpty() && s2.isEmpty())
            return 0;
        else if (s1.isEmpty())
            return -1;
        else if (s2.isEmpty())
            return 1;

        // Получаем массивы подстрок из строк
        String[] subArray1 = s1.split(SPLIT_RGX);
        String[] subArray2 = s2.split(SPLIT_RGX);

        // Вычисляем минимальное число итераций между двумя массивами
        int maxIter = Math.min(subArray1.length, subArray2.length);

        for(int i = 0; i < maxIter; i++) {
            boolean subStr1 = isNumeric(subArray1[i]);
            boolean subStr2 = isNumeric(subArray2[i]);

            int compareValue;
            if (subStr1 && subStr2) {
                // Если оба стринга числа, то сравниваем их int значения
                int subInt1 = Integer.parseInt(subArray1[i]);
                int subInt2 = Integer.parseInt(subArray2[i]);

                compareValue = Integer.compare(subInt1, subInt2);
            } else {
                // В другом случае сравниваем как строки
                compareValue = subArray1[i].compareTo(subArray2[i]);
            }

            if(compareValue != 0)
                return compareValue;
        }

        return 0;
    }

    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}